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
import com.uniyaz.dashboard.service.PdksBirimDevamDurumService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

 
@Named("pdksBirimDevamDurumBean")
@ViewScoped
public class PdksBirimDevamDurumBean implements Serializable {
 
	private static final long serialVersionUID = 1L;

	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	
	private Date ilkIslemTarihi;
	private Date sonIslemTarihi;
	
	private Integer grupId;
	private Integer vardiyaId;
	
	private List<PdksBirimDevamDurumDto> pdksBirimDevamDurumDtos;
	private PdksBirimDevamDurumService pdksBirimDevamDurumService;  
	
	private String barChartJson;
	
	@PostConstruct
	public void pdksBirimDevamDurumBean() {
	    setPdksBirimDevamDurumService(new PdksBirimDevamDurumService());
	    String kullaniciAdi = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("kullaniciAdi");
	   try {
			
		   setBarChartJson("""
	    			{
   			    type: 'bar',

   			    data: {
   			        labels: [
   			            'Bilgi İşlem',
   			            'Muhasebe',
   			            'İK',
   			            'PDKS',
   			            'Destek'
   			        ],

   			        datasets: [

   			            {
   			                label: 'Zamanında',
   			                data: [18, 30, 12, 25, 20],
   			                backgroundColor: '#42A5F5'
   			            },

   			            {
   			                label: 'Gecikti',
   			                data: [4, 7, 3, 6, 5],
   			                backgroundColor: '#EF5350'
   			            },

   			            {
   			                label: 'İzinli',
   			                data: [2, 3, 2, 2, 1],
   			                backgroundColor: '#FFA726'
   			            },

   			            {
   			                label: 'Raporlu',
   			                data: [1, 2, 1, 2, 2],
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
   			""");
			
			
			setPdksBirimDevamDurumDtos(pdksBirimDevamDurumService.selectAll(kullaniciAdi));
	    } catch (Exception e) {
			e.printStackTrace();
		}	   	   
	}	
	
	public String createBirimDurumBarChartJson(List<PdksBirimDevamDurumDto> liste) {

	    try {

	        ObjectMapper objectMapper = new ObjectMapper();

	        Map<String, Object> chart = new LinkedHashMap<>();

	        // =====================================================
	        // CHART TYPE
	        // =====================================================

	        chart.put("type", "bar");


	        // =====================================================
	        // LABELS
	        // =====================================================

	        List<String> labels = liste.stream()
	                .map(PdksBirimDevamDurumDto::getBirimAdi)
	                .toList();


	        // =====================================================
	        // DATASETS
	        // =====================================================

	        List<Map<String, Object>> datasets = new ArrayList<>();


	        // =====================================================
	        // ZAMANINDA
	        // =====================================================

	        Map<String, Object> zamaninda =
	                new LinkedHashMap<>();

	        zamaninda.put("label", "Zamanında");

	        zamaninda.put(
	                "data",
	                liste.stream()
	                        .map(PdksBirimDevamDurumDto::getGirisYapan)
	                        .toList()
	        );

	        zamaninda.put(
	                "percentages",
	                liste.stream()
	                        .map(PdksBirimDevamDurumDto::getGirisYapanYuzde)
	                        .toList()
	        );

	        zamaninda.put(
	                "backgroundColor",
	                "#42A5F5"
	        );

	        datasets.add(zamaninda);


	        // =====================================================
	        // GECİKTİ
	        // =====================================================

	        Map<String, Object> gecikti =
	                new LinkedHashMap<>();

	        gecikti.put("label", "Gecikti");

	        gecikti.put(
	                "data",
	                liste.stream()
	                        .map(PdksBirimDevamDurumDto::getGecKalan)
	                        .toList()
	        );

	        gecikti.put(
	                "percentages",
	                liste.stream()
	                        .map(PdksBirimDevamDurumDto::getGecKalanYuzde)
	                        .toList()
	        );

	        gecikti.put(
	                "backgroundColor",
	                "#EF5350"
	        );

	        datasets.add(gecikti);


	        // =====================================================
	        // İZİNLİ
	        // =====================================================

	        Map<String, Object> izinli =
	                new LinkedHashMap<>();

	        izinli.put("label", "İzinli");

	        izinli.put(
	                "data",
	                liste.stream()
	                        .map(PdksBirimDevamDurumDto::getIzinli)
	                        .toList()
	        );

	        izinli.put(
	                "percentages",
	                liste.stream()
	                        .map(PdksBirimDevamDurumDto::getIzinliYuzde)
	                        .toList()
	        );

	        izinli.put(
	                "backgroundColor",
	                "#FFA726"
	        );

	        datasets.add(izinli);


	        // =====================================================
	        // RAPORLU
	        // =====================================================

	        Map<String, Object> raporlu =
	                new LinkedHashMap<>();

	        raporlu.put("label", "Raporlu");

	        raporlu.put(
	                "data",
	                liste.stream()
	                        .map(PdksBirimDevamDurumDto::getRaporlu)
	                        .toList()
	        );

	        raporlu.put(
	                "percentages",
	                liste.stream()
	                        .map(PdksBirimDevamDurumDto::getRaporluYuzde)
	                        .toList()
	        );

	        raporlu.put(
	                "backgroundColor",
	                "#AB47BC"
	        );

	        datasets.add(raporlu);


	        // =====================================================
	        // DATA
	        // =====================================================

	        Map<String, Object> data =
	                new LinkedHashMap<>();

	        data.put("labels", labels);
	        data.put("datasets", datasets);

	        chart.put("data", data);


	        // =====================================================
	        // OPTIONS
	        // =====================================================

	        Map<String, Object> options =
	                new LinkedHashMap<>();

	        options.put("responsive", true);
	        options.put("maintainAspectRatio", false);


	        // =====================================================
	        // LEGEND
	        // =====================================================

	        Map<String, Object> legend =
	                new LinkedHashMap<>();

	        legend.put("position", "top");


	        // =====================================================
	        // DATALABELS
	        // =====================================================

	        Map<String, Object> datalabels =
	                new LinkedHashMap<>();

	        datalabels.put("anchor", "end");
	        datalabels.put("align", "top");

	        datalabels.put(
	                "font",
	                Map.of(
	                        "weight", "bold",
	                        "size", 11
	                )
	        );


	        // =====================================================
	        // PLUGINS
	        // =====================================================

	        Map<String, Object> plugins =
	                new LinkedHashMap<>();

	        plugins.put("legend", legend);
	        plugins.put("datalabels", datalabels);

	        options.put("plugins", plugins);


	        // =====================================================
	        // SCALES
	        // =====================================================

	        Map<String, Object> yAxis =
	                new LinkedHashMap<>();

	        yAxis.put("beginAtZero", true);

	        yAxis.put(
	                "ticks",
	                Map.of(
	                        "precision", 0
	                )
	        );

	        Map<String, Object> scales =
	                new LinkedHashMap<>();

	        scales.put("y", yAxis);

	        options.put("scales", scales);


	        chart.put("options", options);


	        // =====================================================
	        // JSON
	        // =====================================================

	        return objectMapper.writeValueAsString(chart);

	    } catch (JsonProcessingException e) {

	        LOG.error(
	                "PDKS birim durum Chart JSON oluşturulamadı",
	                e
	        );

	        return "{}";
	    }
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
	
}

