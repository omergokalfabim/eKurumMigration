package com.uniyaz.dashboard.bean;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniyaz.dashboard.dto.PdksBirimDevamDurumDto;
import com.uniyaz.dashboard.dto.PdksGrupMapKullaniciDto;
import com.uniyaz.dashboard.dto.PdksGrupMapPdksPersonelDto;
import com.uniyaz.dashboard.dto.PdksHareketListeDto;
import com.uniyaz.dashboard.dto.PdksPVardiyaDto;
import com.uniyaz.dashboard.service.PdksBirimDevamDurumService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import software.xdev.chartjs.model.charts.DoughnutChart;
import software.xdev.chartjs.model.charts.PieChart;
import software.xdev.chartjs.model.color.RGBAColor;
import software.xdev.chartjs.model.data.PieData;
import software.xdev.chartjs.model.dataset.PieDataset;
 
@Named("pdksBirimDevamDurumBean")
@ViewScoped
public class PdksBirimDevamDurumBean implements Serializable {
 
	private static final long serialVersionUID = 1L;

	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	
	private Date ilkIslemTarihi;
	private Date sonIslemTarihi;
	
	private Integer grupId;
	private Integer vardiyaId;
	
	private List<PdksGrupMapKullaniciDto> pdksGrupMapKullaniciDtos;
	private List<PdksBirimDevamDurumDto> pdksBirimDevamDurumDtos;
	private List<PdksBirimDevamDurumDto> pdksBirimDevamDurumTumuDtos;
	private List<PdksGrupMapPdksPersonelDto> pdksGrupMapPersonelListe;
	private List<PdksPVardiyaDto> vardiyaListe;
	private List<PdksHareketListeDto> pdksHareketListeDtos;
	private PdksBirimDevamDurumService pdksBirimDevamDurumService; 
	
	private Integer toplamGrupPersonelSayisi;
	private Integer toplamGelenSayisi;
	private Integer toplamGecikenSayisi;
	private Integer toplamIzinliSayisi;
	private Integer toplamRaporluSayisi;
	
	private BigDecimal toplamKatilimOran;
	private BigDecimal toplamGecikenOran;
	private BigDecimal toplamIzinliOran;
	private BigDecimal toplamRaporluOran;
	
	private String barChartJson;
	private String pieModel;
	
	public void islem() {
		System.out.print("geldi");	
	}
	
	public void resetEntityLoad() {
		
	}
	
	@PostConstruct
	public void pdksBirimDevamDurumBean() {
	    setPdksBirimDevamDurumService(new PdksBirimDevamDurumService());
	    String kullaniciAdi = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("kullaniciAdi");
	   try {
		  
		   setVardiyaListe(pdksBirimDevamDurumService.selectAllByVardiya());
			  
		   setPdksGrupMapKullaniciDtos(pdksBirimDevamDurumService.selectAllByKullanici(kullaniciAdi));
		   String[] selectedPdksGrupIds = new String[pdksGrupMapKullaniciDtos.size()];
			 int i=0;
			 for(PdksGrupMapKullaniciDto pdksGrupMapKullaniciDto:pdksGrupMapKullaniciDtos) {
				 selectedPdksGrupIds[i] = pdksGrupMapKullaniciDto.getPdksGrup().getPdksGrupId().toString();
				 i++;
			 }
			 setIlkIslemTarihi(MyUtil.toDate("dd/MM/yyyy", "01/09/2026"));
				setSonIslemTarihi(new Date());
			 pdksGrupMapPersonelListe =  pdksBirimDevamDurumService.selectAllByGrupIds(MyUtil.convertStringArrayToString(selectedPdksGrupIds,","));
		   
		   setPdksHareketListeDtos(pdksBirimDevamDurumService.selectAllByGrup(MyUtil.toString("yyyy-MM-dd", ilkIslemTarihi),
									MyUtil.toString("yyyy-MM-dd", sonIslemTarihi), MyUtil.convertStringArrayToString(selectedPdksGrupIds,",")));
		  
		  
		   
		   
		   pdksBirimDevamDurumDtos = pdksHareketListeDtos.stream()
			        .collect(Collectors.groupingBy(
			                PdksHareketListeDto::getGrupAdi
			        ))
			        .entrySet()
			        .stream()
			        .map(e -> {

			            List<PdksHareketListeDto> liste = e.getValue();

			            return new PdksBirimDevamDurumDto(
			                    e.getKey(),

			                    (int) liste.stream()
			                            .map(PdksHareketListeDto::getPersonelId)
			                            .filter(Objects::nonNull)
			                            .distinct()
			                            .count(),

			                    (int) liste.stream()
			                            .filter(x -> "ZAMANINDA GELDI"
			                                    .equals(x.getMesaiGirisDurum()))
			                            .count(),

			                    (int) liste.stream()
			                            .filter(x -> "GECIKTI"
			                                    .equals(x.getMesaiGirisDurum()))
			                            .count(),

			                    (int) liste.stream()
			                            .filter(x -> "IZINLI"
			                                    .equals(x.getMesaiGirisDurum()))
			                            .count(),

			                    (int) liste.stream()
			                            .filter(x -> "RAPORLU"
			                                    .equals(x.getMesaiGirisDurum()))
			                            .count()
			            );

			        })
			        .collect(Collectors.toList()); 
		   pdksBirimDevamDurumTumuDtos = pdksHareketListeDtos.stream()
			        .collect(Collectors.groupingBy(
			                PdksHareketListeDto::getKurumAdi
			        ))
			        .entrySet()
			        .stream()
			        .map(e -> {

			            List<PdksHareketListeDto> liste = e.getValue();

			            return new PdksBirimDevamDurumDto(
			                    e.getKey(),

			                    (int) liste.stream()
			                            .map(PdksHareketListeDto::getPersonelId)
			                            .filter(Objects::nonNull)
			                            .distinct()
			                            .count(),

			                    (int) liste.stream()
			                            .filter(x -> "ZAMANINDA GELDI"
			                                    .equals(x.getMesaiGirisDurum()))
			                            .count(),

			                    (int) liste.stream()
			                            .filter(x -> "GECIKTI"
			                                    .equals(x.getMesaiGirisDurum()))
			                            .count(),

			                    (int) liste.stream()
			                            .filter(x -> "IZINLI"
			                                    .equals(x.getMesaiGirisDurum()))
			                            .count(),

			                    (int) liste.stream()
			                            .filter(x -> "RAPORLU"
			                                    .equals(x.getMesaiGirisDurum()))
			                            .count()
			            );

			        })
			        .collect(Collectors.toList());         		        
		
		   
		   setToplamGrupPersonelSayisi(pdksGrupMapPersonelListe.size());
		   setToplamGelenSayisi(pdksHareketListeDtos.size());
			 
			 setToplamKatilimOran(BigDecimal.valueOf(toplamGelenSayisi)
				        .multiply(BigDecimal.valueOf(100))
				        .divide(BigDecimal.valueOf(toplamGrupPersonelSayisi), 2, RoundingMode.HALF_UP));
			 
			 Long gecikenPersonelSayisi = pdksHareketListeDtos.stream()
		        .filter(x -> "GECIKTI".equals(x.getMesaiGirisDurum()))
		        .count();
			 setToplamGecikenSayisi(gecikenPersonelSayisi.intValue());
			 
			 setToplamGecikenOran(BigDecimal.valueOf(toplamGecikenSayisi)
				        .multiply(BigDecimal.valueOf(100))
				        .divide(BigDecimal.valueOf(toplamGrupPersonelSayisi), 2, RoundingMode.HALF_UP));
			 
			 
			 Long izinliPersonelSayisi = pdksHareketListeDtos.stream()
				        .filter(x -> !"RAPOR".equals(x.getIzinAciklama()))
				        .count();
			 setToplamIzinliSayisi(izinliPersonelSayisi.intValue());
			 
			 setToplamIzinliOran(BigDecimal.valueOf(toplamIzinliSayisi)
				        .multiply(BigDecimal.valueOf(100))
				        .divide(BigDecimal.valueOf(toplamGrupPersonelSayisi), 2, RoundingMode.HALF_UP));
			 
			 Long raporluPersonelSayisi = pdksHareketListeDtos.stream()
				        .filter(x -> "RAPOR".equals(x.getIzinAciklama()))
				        .count();
			 setToplamRaporluSayisi(raporluPersonelSayisi.intValue());
			 
			 setToplamRaporluOran(BigDecimal.valueOf(toplamRaporluSayisi)
				        .multiply(BigDecimal.valueOf(100))
				        .divide(BigDecimal.valueOf(toplamGrupPersonelSayisi), 2, RoundingMode.HALF_UP));
		   
		   
		   
		createBarChart(getPdksBirimDevamDurumDtos()); 
		createPieModel(pdksBirimDevamDurumTumuDtos);
		} catch (Exception e) {
			e.printStackTrace();
		}	   	   
	}	
	
	private void createPieModel(List<PdksBirimDevamDurumDto> dtoList) {
        pieModel = new PieChart()
                .setData(new PieData()
                .addDataset(new PieDataset()
                        .setData(dtoList.get(0).getGirisYapan(), dtoList.get(0).getGecKalan() , dtoList.get(0).getIzinli(),dtoList.get(0).getRaporlu())
                        .setLabel("Personel Sayısı")
                        .addBackgroundColors(
                        	    new RGBAColor(66, 165, 245),    // Giriş Yapan - Yeşil
                        	    new RGBAColor(239, 83, 80),    // Geciken - Kırmızı
                        	    new RGBAColor(255, 167, 38),   // İzinli - Turuncu
                        	    new RGBAColor(171, 71, 188)    // Raporlu - Mor
                        	)                        
                )
                .setLabels("Giriş Yapan", "Geciken", "İzinli", "Raporlu"))
                .toJson();
    }



	private void createBarChart(List<PdksBirimDevamDurumDto> dtoList) {

	    StringBuilder labels = new StringBuilder();

	    StringBuilder girisYapan = new StringBuilder();
	    StringBuilder gecKalan = new StringBuilder();
	    StringBuilder izinli = new StringBuilder();
	    StringBuilder raporlu = new StringBuilder();

	    StringBuilder girisYapanYuzde = new StringBuilder();
	    StringBuilder gecKalanYuzde = new StringBuilder();
	    StringBuilder izinliYuzde = new StringBuilder();
	    StringBuilder raporluYuzde = new StringBuilder();

	    for (int i = 0; i < dtoList.size(); i++) {

	        PdksBirimDevamDurumDto dto = dtoList.get(i);

	        // ---------------------------------------------------------
	        // LABEL
	        // ---------------------------------------------------------

	        labels.append("'")
	              .append(escapeJs(dto.getBirimAdi()))
	              .append("'");

	        // ---------------------------------------------------------
	        // SAYISAL DEĞERLER
	        // ---------------------------------------------------------

	        girisYapan.append(nullToZero(dto.getGirisYapan()));
	        gecKalan.append(nullToZero(dto.getGecKalan()));
	        izinli.append(nullToZero(dto.getIzinli()));
	        raporlu.append(nullToZero(dto.getRaporlu()));

	        // ---------------------------------------------------------
	        // YÜZDE DEĞERLERİ
	        // ---------------------------------------------------------

	        girisYapanYuzde.append(nullToZero(dto.getGirisYapanYuzde()));
	        gecKalanYuzde.append(nullToZero(dto.getGecKalanYuzde()));
	        izinliYuzde.append(nullToZero(dto.getIzinliYuzde()));
	        raporluYuzde.append(nullToZero(dto.getRaporluYuzde()));

	        // ---------------------------------------------------------
	        // VIRGÜL
	        // ---------------------------------------------------------

	        if (i < dtoList.size() - 1) {

	            labels.append(", ");

	            girisYapan.append(", ");
	            gecKalan.append(", ");
	            izinli.append(", ");
	            raporlu.append(", ");

	            girisYapanYuzde.append(", ");
	            gecKalanYuzde.append(", ");
	            izinliYuzde.append(", ");
	            raporluYuzde.append(", ");
	        }
	    }

	    // -------------------------------------------------------------
	    // CHART
	    // -------------------------------------------------------------
 
	    setBarChartJson("""
	    	    {
	    	        type: 'bar',

	    	        data: {

	    	            labels: [%s],

	    	            datasets: [

	    	                {
	    	                    label: 'Zamanında',
	    	                    data: [%s],
	    	                    yuzdeler: [%s],
	    	                    backgroundColor: '#42A5F5'
	    	                },

	    	                {
	    	                    label: 'Geç Kalan',
	    	                    data: [%s],
	    	                    yuzdeler: [%s],
	    	                    backgroundColor: '#EF5350'
	    	                },

	    	                {
	    	                    label: 'İzinli',
	    	                    data: [%s],
	    	                    yuzdeler: [%s],
	    	                    backgroundColor: '#FFA726'
	    	                },

	    	                {
	    	                    label: 'Raporlu',
	    	                    data: [%s],
	    	                    yuzdeler: [%s],
	    	                    backgroundColor: '#AB47BC'
	    	                }
	    	            ]
	    	        },

	    	        options: {

	    	            responsive: true,

	    	            maintainAspectRatio: false,

	    	            plugins: {

	    	                legend: {
	    	                    position: 'top'
	    	                },

	    	                datalabels: {

	    	                    anchor: 'end',

	    	                    align: 'top',

	    	                    color: '#333',

	    	                    font: {
	    	                        weight: 'bold',
	    	                        size: 11
	    	                    },

	    	                    formatter: function(value, context) {

	    	                        var yuzde =
	    	                            context.dataset.yuzdeler[
	    	                                context.dataIndex
	    	                            ];

	    	                        return value + '(%%' + yuzde + ')';
	    	                    }
	    	                }
	    	            },

	    	            scales: {

	    	                x: {
	    	                    stacked: false
	    	                },

	    	                y: {

	    	                    beginAtZero: true,

	    	                    ticks: {
	    	                        precision: 0
	    	                    }
	    	                }
	    	            }
	    	        }
	    	    }
	    	    """.formatted(

	    	        labels,

	    	        girisYapan,
	    	        girisYapanYuzde,

	    	        gecKalan,
	    	        gecKalanYuzde,

	    	        izinli,
	    	        izinliYuzde,

	    	        raporlu,
	    	        raporluYuzde
	    	    ));
	}


	/**
	 * Null değerleri 0 olarak döndürür.
	 */
	private int nullToZero(Integer value) {
	    return value == null ? 0 : value;
	}


	/**
	 * Java string'inin JavaScript string içerisinde
	 * güvenli kullanılmasını sağlar.
	 */
	private String escapeJs(String value) {

	    if (value == null) {
	        return "";
	    }

	    return value
	            .replace("\\", "\\\\")
	            .replace("'", "\\'")
	            .replace("\r", "\\r")
	            .replace("\n", "\\n");
	}
	
	public Date getIlkIslemTarihi() {
		return ilkIslemTarihi;
	}
	public void setIlkIslemTarihi(Date ilkIslemTarihi) {
		this.ilkIslemTarihi = ilkIslemTarihi;
	}
	public Date getSonIslemTarihi() {
		return sonIslemTarihi;
	}
	public void setSonIslemTarihi(Date sonIslemTarihi) {
		this.sonIslemTarihi = sonIslemTarihi;
	}
	public Integer getGrupId() {
		return grupId;
	}
	public void setGrupId(Integer grupId) {
		this.grupId = grupId;
	}
	public Integer getVardiyaId() {
		return vardiyaId;
	}
	public void setVardiyaId(Integer vardiyaId) {
		this.vardiyaId = vardiyaId;
	}

	public PdksBirimDevamDurumService getPdksBirimDevamDurumService() {
		return pdksBirimDevamDurumService;
	}

	public void setPdksBirimDevamDurumService(PdksBirimDevamDurumService pdksBirimDevamDurumService) {
		this.pdksBirimDevamDurumService = pdksBirimDevamDurumService;
	}

	public List<PdksBirimDevamDurumDto> getPdksBirimDevamDurumDtos() {
		return pdksBirimDevamDurumDtos;
	}

	public void setPdksBirimDevamDurumDtos(List<PdksBirimDevamDurumDto> pdksBirimDevamDurumDtos) {
		this.pdksBirimDevamDurumDtos = pdksBirimDevamDurumDtos;
	}

	public String getBarChartJson() {
		return barChartJson;
	}

	public void setBarChartJson(String barChartJson) {
		this.barChartJson = barChartJson;
	}

	public List<PdksGrupMapKullaniciDto> getPdksGrupMapKullaniciDtos() {
		return pdksGrupMapKullaniciDtos;
	}

	public void setPdksGrupMapKullaniciDtos(List<PdksGrupMapKullaniciDto> pdksGrupMapKullaniciDtos) {
		this.pdksGrupMapKullaniciDtos = pdksGrupMapKullaniciDtos;
	}


	public List<PdksHareketListeDto> getPdksHareketListeDtos() {
		return pdksHareketListeDtos;
	}


	public void setPdksHareketListeDtos(List<PdksHareketListeDto> pdksHareketListeDtos) {
		this.pdksHareketListeDtos = pdksHareketListeDtos;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Logger getLOG() {
		return LOG;
	}


	public List<PdksGrupMapPdksPersonelDto> getPdksGrupMapPersonelListe() {
		return pdksGrupMapPersonelListe;
	}


	public void setPdksGrupMapPersonelListe(List<PdksGrupMapPdksPersonelDto> pdksGrupMapPersonelListe) {
		this.pdksGrupMapPersonelListe = pdksGrupMapPersonelListe;
	}

	public String getPieModel() {
		return pieModel;
	}

	public void setPieModel(String pieModel) {
		this.pieModel = pieModel;
	}

	public List<PdksBirimDevamDurumDto> getPdksBirimDevamDurumTumuDtos() {
		return pdksBirimDevamDurumTumuDtos;
	}

	public void setPdksBirimDevamDurumTumuDtos(List<PdksBirimDevamDurumDto> pdksBirimDevamDurumTumuDtos) {
		this.pdksBirimDevamDurumTumuDtos = pdksBirimDevamDurumTumuDtos;
	}

	public List<PdksPVardiyaDto> getVardiyaListe() {
		return vardiyaListe;
	}

	public void setVardiyaListe(List<PdksPVardiyaDto> vardiyaListe) {
		this.vardiyaListe = vardiyaListe;
	}

	public Integer getToplamGrupPersonelSayisi() {
		return toplamGrupPersonelSayisi;
	}

	public void setToplamGrupPersonelSayisi(Integer toplamGrupPersonelSayisi) {
		this.toplamGrupPersonelSayisi = toplamGrupPersonelSayisi;
	}

	public Integer getToplamGelenSayisi() {
		return toplamGelenSayisi;
	}

	public void setToplamGelenSayisi(Integer toplamGelenSayisi) {
		this.toplamGelenSayisi = toplamGelenSayisi;
	}

	public Integer getToplamGecikenSayisi() {
		return toplamGecikenSayisi;
	}

	public void setToplamGecikenSayisi(Integer toplamGecikenSayisi) {
		this.toplamGecikenSayisi = toplamGecikenSayisi;
	}

	public Integer getToplamIzinliSayisi() {
		return toplamIzinliSayisi;
	}

	public void setToplamIzinliSayisi(Integer toplamIzinliSayisi) {
		this.toplamIzinliSayisi = toplamIzinliSayisi;
	}

	public Integer getToplamRaporluSayisi() {
		return toplamRaporluSayisi;
	}

	public void setToplamRaporluSayisi(Integer toplamRaporluSayisi) {
		this.toplamRaporluSayisi = toplamRaporluSayisi;
	}

	public BigDecimal getToplamKatilimOran() {
		return toplamKatilimOran;
	}

	public void setToplamKatilimOran(BigDecimal toplamKatilimOran) {
		this.toplamKatilimOran = toplamKatilimOran;
	}

	public BigDecimal getToplamGecikenOran() {
		return toplamGecikenOran;
	}

	public void setToplamGecikenOran(BigDecimal toplamGecikenOran) {
		this.toplamGecikenOran = toplamGecikenOran;
	}

	public BigDecimal getToplamIzinliOran() {
		return toplamIzinliOran;
	}

	public void setToplamIzinliOran(BigDecimal toplamIzinliOran) {
		this.toplamIzinliOran = toplamIzinliOran;
	}

	public BigDecimal getToplamRaporluOran() {
		return toplamRaporluOran;
	}

	public void setToplamRaporluOran(BigDecimal toplamRaporluOran) {
		this.toplamRaporluOran = toplamRaporluOran;
	}


	 
}

