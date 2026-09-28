package com.uniyaz.dashboard.dto;

import java.io.Serializable;

public class PdksGrupMapPdksPersonelDto implements Serializable {	
	
    public PdksGrupMapPdksPersonelDto() {
		super();		
	}
	 
	private static final long serialVersionUID = 1L;
	private Integer pdksGrupMapPdksPersonelId;    
    private Character aktif;
    private Long kullaniciKod;
    private String kayitTarihi;
    private PdksGrupDto pdksGrup;
    private PbsPersonelViewDto pbsPersonel;    
    
	public Integer getPdksGrupMapPdksPersonelId() {
		return pdksGrupMapPdksPersonelId;
	}
	public void setPdksGrupMapPdksPersonelId(Integer pdksGrupMapPdksPersonelId) {
		this.pdksGrupMapPdksPersonelId = pdksGrupMapPdksPersonelId;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PbsPersonelViewDto getPbsPersonel() {
		return pbsPersonel;
	}
	public void setPbsPersonel(PbsPersonelViewDto pbsPersonel) {
		this.pbsPersonel = pbsPersonel;
	}
	public PdksGrupMapPdksPersonelDto(Integer pdksGrupMapPdksPersonelId, Character aktif, Long kullaniciKod,
			String kayitTarihi, PdksGrupDto pdksGrup, PbsPersonelViewDto pbsPersonel) {
		super();
		this.pdksGrupMapPdksPersonelId = pdksGrupMapPdksPersonelId;
		this.aktif = aktif;
		this.kullaniciKod = kullaniciKod;
		this.kayitTarihi = kayitTarihi;
		this.pdksGrup = pdksGrup;
		this.pbsPersonel = pbsPersonel;
	}
}
