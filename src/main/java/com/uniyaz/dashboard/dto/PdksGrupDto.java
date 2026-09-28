package com.uniyaz.dashboard.dto;

import java.io.Serializable;

public class PdksGrupDto implements Serializable {	
	 
	private static final long serialVersionUID = 1L;
	
	private Integer pdksGrupId;
    private String aciklama;
    private PbsOrgutDto pbsOrgut;
    private Long kullaniciKod;
    private String kayitTarihi;
	public Integer getPdksGrupId() {
		return pdksGrupId;
	}
	public void setPdksGrupId(Integer pdksGrupId) {
		this.pdksGrupId = pdksGrupId;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
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
	public PbsOrgutDto getPbsOrgut() {
		return pbsOrgut;
	}
	public void setPbsOrgut(PbsOrgutDto pbsOrgut) {
		this.pbsOrgut = pbsOrgut;
	}        
}

