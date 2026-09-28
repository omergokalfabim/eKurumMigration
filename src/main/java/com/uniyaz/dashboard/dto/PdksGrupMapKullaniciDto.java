package com.uniyaz.dashboard.dto;

import java.io.Serializable;

public class PdksGrupMapKullaniciDto implements Serializable {	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pdksGrupMapKullaniciId;    
    private String kullanici;
    private Character aktif;
    private Long kullaniciKod;
    private String kayitTarihi;
    private PdksGrupDto pdksGrup;
    private Boolean checkAktif;
   
   public Integer getPdksGrupMapKullaniciId() {
		return pdksGrupMapKullaniciId;
	}
	public void setPdksGrupMapKullaniciId(Integer pdksGrupMapKullaniciId) {
		this.pdksGrupMapKullaniciId = pdksGrupMapKullaniciId;
	}	
	public String getKullanici() {
		return kullanici;
	}
	public void setKullanici(String kullanici) {
		this.kullanici = kullanici;
	}
	public Character getAktif() {
		return aktif;
	}
	public void setAktif(Character aktif) {
		this.aktif = aktif;
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
	public PdksGrupDto getPdksGrup() {
		return pdksGrup;
	}
	public void setPdksGrup(PdksGrupDto pdksGrup) {
		this.pdksGrup = pdksGrup;
	}
	public PdksGrupMapKullaniciDto(Integer pdksGrupMapKullaniciId, String kullanici, Character aktif,
			Long kullaniciKod, String kayitTarihi, PdksGrupDto pdksGrup) {
		super();
		this.pdksGrupMapKullaniciId = pdksGrupMapKullaniciId;
		this.kullanici = kullanici;
		this.aktif = aktif;
		this.kullaniciKod = kullaniciKod;
		this.kayitTarihi = kayitTarihi;
		this.pdksGrup = pdksGrup; 
	}
	public PdksGrupMapKullaniciDto() {
		super();		 
	}
	public Boolean getCheckAktif() {
		return aktif == '1' ? true:false;
	}
	public void setCheckAktif(Boolean checkAktif) {
		this.checkAktif = checkAktif;
	}
	 
	
}

