package com.uniyaz.dashboard.dto;

import java.io.Serializable;

public class PdksPVardiyaDto implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	private Integer pdksPVardiyaId;
    private String ilkSaat;
    private String sonSaat;
	private Character aktif;
	private Character varsayilan;
	private String kullanici;
    private Long kullaniciKod;
    private String kayitTarihi;
    private Boolean durum;
    private Boolean durumVarsayilan;
    
    
   
	public Integer getPdksPVardiyaId() {
		return pdksPVardiyaId;
	}



	public void setPdksPVardiyaId(Integer pdksPVardiyaId) {
		this.pdksPVardiyaId = pdksPVardiyaId;
	}



	public String getIlkSaat() {
		if(ilkSaat!=null) {
			if(ilkSaat.equals("00:00") && sonSaat.equals("00:00")) {
				ilkSaat = "Mesai";
				sonSaat = "Yok";
			}  
		}
		return ilkSaat ;
	}



	public void setIlkSaat(String ilkSaat) {
		this.ilkSaat = ilkSaat;
	}



	public String getSonSaat() {
		return sonSaat;
	}



	public void setSonSaat(String sonSaat) {
		this.sonSaat = sonSaat;
	}



	public Character getAktif() {
		return aktif;
	}



	public void setAktif(Character aktif) {
		this.aktif = aktif;
	}



	public Character getVarsayilan() {
		return varsayilan;
	}



	public void setVarsayilan(Character varsayilan) {
		this.varsayilan = varsayilan;
	}



	public Long getKullaniciKod() {
		return kullaniciKod;
	}



	public void setKullaniciKod(Long kullaniciKod) {
		this.kullaniciKod = kullaniciKod;
	}



	public String getKayitTarihi() {
		return kayitTarihi;
	}



	public void setKayitTarihi(String kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}



	public Boolean getDurum() {
		return aktif == '1' ? true : false;
	}



	public void setDurum(Boolean durum) {
		this.durum = durum;
	}



	public Boolean getDurumVarsayilan() {
		  if(varsayilan == null) {
			  return false;	  
		  }else {
		      return varsayilan == '1' ? true : false;
		  }
	}



	public void setDurumVarsayilan(Boolean durumVarsayilan) {
		this.durumVarsayilan = durumVarsayilan;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public PdksPVardiyaDto(Integer pdksPVardiyaId, String ilkSaat, String sonSaat, Character aktif,
			Character varsayilan,String kullanici, Long kullaniciKod, String kayitTarihi, Boolean durum, Boolean durumVarsayilan) {
		super();
		this.pdksPVardiyaId = pdksPVardiyaId;
		this.ilkSaat = ilkSaat;
		this.sonSaat = sonSaat;
		this.aktif = aktif;
		this.varsayilan = varsayilan;
		this.kullanici = kullanici;
		this.kullaniciKod = kullaniciKod;
		this.kayitTarihi = kayitTarihi;
		this.durum = durum;
		this.durumVarsayilan = durumVarsayilan;
	}



	public String getKullanici() {
		return kullanici;
	}



	public void setKullanici(String kullanici) {
		this.kullanici = kullanici;
	}
	 
}