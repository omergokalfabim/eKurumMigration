package com.uniyaz.dashboard.dto;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.uniyaz.dashboard.bean.MyUtil;

public class PdksHareketListeDto implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private Long tcKimlikNo;
    private String adi;
    private String soyAdi;
    private String sube;
    private String isyeri;
    private String numara;	
    private String kurumSicilNo;
    private String fiiliGorevYeri;
    private String tarih;
    private String girisSaat;
    private String cikisSaat;
    private String izinTuru;
    private String izinTarihleri;
    private Integer grupId;
    private String grupAdi;
    private Long personelId;
    private String izinAciklama;
    private String girisOkutmaTuru;
	private String cikisOkutmaTuru;
    private Integer ilkCihaz;
    private Integer sonCihaz;
    private String mesaiGirisDurum;
   	private String mesaiCikisDurum;   
   	private String girisCihazAdi;
   	private String cikisCihazAdi;
   	private String kurumAdi;
   	
	public String getCikisCihazAdi() {
		return girisSaat.equals(cikisSaat) ? "":cikisCihazAdi;
	}
	public void setCikisCihazAdi(String cikisCihazAdi) {
		this.cikisCihazAdi = cikisCihazAdi;
	}
	public Long getTcKimlikNo() {
		return tcKimlikNo;
	}
	public void setTcKimlikNo(Long tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyAdi() {
		return soyAdi;
	}
	public void setSoyAdi(String soyAdi) {
		this.soyAdi = soyAdi;
	}
	public String getSube() {
		return sube;
	}
	public void setSube(String sube) {
		this.sube = sube;
	}
	public String getIsyeri() {
		return isyeri;
	}
	public void setIsyeri(String isyeri) {
		this.isyeri = isyeri;
	}
	public String getNumara() {
		return numara;
	}
	public void setNumara(String numara) {
		this.numara = numara;
	}
	public String getKurumSicilNo() {
		return kurumSicilNo;
	}
	public void setKurumSicilNo(String kurumSicilNo) {
		this.kurumSicilNo = kurumSicilNo;
	}
	public String getFiiliGorevYeri() {
		return fiiliGorevYeri;
	}
	public void setFiiliGorevYeri(String fiiliGorevYeri) {
		this.fiiliGorevYeri = fiiliGorevYeri;
	}
	public String getTarih() {
		return tarih != null ? MyUtil.toString("dd/MM/yyyy",tarih):null;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String getGirisSaat() {
		return girisSaat;
	}
	public void setGirisSaat(String girisSaat) {
		this.girisSaat = girisSaat;
	}
	public String getCikisSaat() {
		 return girisSaat.equals(cikisSaat) ? "":cikisSaat;
	}
	public void setCikisSaat(String cikisSaat) {
		this.cikisSaat = cikisSaat;
	}
	public String getIzinTuru() {
		return izinTuru;
	}
	public void setIzinTuru(String izinTuru) {
		this.izinTuru = izinTuru;
	}
	public Integer getGrupId() {
		return grupId;
	}
	public void setGrupId(Integer grupId) {
		this.grupId = grupId;
	}
	public String getGrupAdi() {
		return grupAdi;
	}
	public void setGrupAdi(String grupAdi) {
		this.grupAdi = grupAdi;
	}
	public Long getPersonelId() {
		return personelId;
	}
	public void setPersonelId(Long personelId) {
		this.personelId = personelId;
	}
	public String getIzinAciklama() {
		return izinAciklama;
	}
	public void setIzinAciklama(String izinAciklama) {
		this.izinAciklama = izinAciklama;
	}
	public String getGirisOkutmaTuru() {
		return girisOkutmaTuru;
	}
	public void setGirisOkutmaTuru(String girisOkutmaTuru) {
		this.girisOkutmaTuru = girisOkutmaTuru;
	}
	public String getCikisOkutmaTuru() {
		return cikisOkutmaTuru;
	}
	public void setCikisOkutmaTuru(String cikisOkutmaTuru) {
		this.cikisOkutmaTuru = cikisOkutmaTuru;
	}
	public Integer getIlkCihaz() {
		return ilkCihaz;
	}
	public void setIlkCihaz(Integer ilkCihaz) {
		this.ilkCihaz = ilkCihaz;
	}
	public Integer getSonCihaz() {
		return sonCihaz;
	}
	public void setSonCihaz(Integer sonCihaz) {
		this.sonCihaz = sonCihaz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PdksHareketListeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMesaiGirisDurum() {
		return mesaiGirisDurum == null ? "VARDIYA TANIMSIZ":mesaiGirisDurum;
	}
	public void setMesaiGirisDurum(String mesaiGirisDurum) {
		this.mesaiGirisDurum = mesaiGirisDurum;
	}
	public String getMesaiCikisDurum() {
		return mesaiCikisDurum == null ? "VARDIYA TANIMSIZ":mesaiCikisDurum;
	}
	public void setMesaiCikisDurum(String mesaiCikisDurum) {
		this.mesaiCikisDurum = mesaiCikisDurum;
	}
	public String getGirisCihazAdi() {
		return girisCihazAdi;
	}
	public void setGirisCihazAdi(String girisCihazAdi) {
		this.girisCihazAdi = girisCihazAdi;
	}
	public String getIzinTarihleri() {
		return izinTarihleri;
	}
	public void setIzinTarihleri(String izinTarihleri) {
		this.izinTarihleri = izinTarihleri;
	}
	public String getKurumAdi() {
		return kurumAdi;
	}
	public void setKurumAdi(String kurumAdi) {
		this.kurumAdi = kurumAdi;
	}  
     
	 
}

