package com.uniyaz.dashboard.dto;

import java.io.Serializable;

public class PbsPersonelViewDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long personelId;
	private Long tcKimlikNo;
	private String adSoyad;
	private String telefon;
	private String pdksKartNo;
	private Long kurumSicilNo;
	private String fiiliGorevYeri;
	private String mudurluk;
	private String gorev;
	private String isyeri;
	private Long   fiiliGorevYeriId;
	private Long mudurlukId;
	private Integer isyeriId;
	private Integer grupId;
	private String grupAdi;
	private Long grupMapPersonelId;
	public Long getPersonelId() {
		return personelId;
	}
	public void setPersonelId(Long personelId) {
		this.personelId = personelId;
	}
	public Long getTcKimlikNo() {
		return tcKimlikNo;
	}
	public void setTcKimlikNo(Long tcKimlikNo) {
		this.tcKimlikNo = tcKimlikNo;
	}
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getPdksKartNo() {
		return pdksKartNo;
	}
	public void setPdksKartNo(String pdksKartNo) {
		this.pdksKartNo = pdksKartNo;
	}
	public Long getKurumSicilNo() {
		return kurumSicilNo;
	}
	public void setKurumSicilNo(Long kurumSicilNo) {
		this.kurumSicilNo = kurumSicilNo;
	}
	public String getFiiliGorevYeri() {
		return fiiliGorevYeri;
	}
	public void setFiiliGorevYeri(String fiiliGorevYeri) {
		this.fiiliGorevYeri = fiiliGorevYeri;
	}
	public String getMudurluk() {
		return mudurluk;
	}
	public void setMudurluk(String mudurluk) {
		this.mudurluk = mudurluk;
	}
	public String getGorev() {
		return gorev;
	}
	public void setGorev(String gorev) {
		this.gorev = gorev;
	}
	public String getIsyeri() {
		return isyeri;
	}
	public void setIsyeri(String isyeri) {
		this.isyeri = isyeri;
	}
	public Long getFiiliGorevYeriId() {
		return fiiliGorevYeriId;
	}
	public void setFiiliGorevYeriId(Long fiiliGorevYeriId) {
		this.fiiliGorevYeriId = fiiliGorevYeriId;
	}
	public Long getMudurlukId() {
		return mudurlukId;
	}
	public void setMudurlukId(Long mudurlukId) {
		this.mudurlukId = mudurlukId;
	}
	public Integer getIsyeriId() {
		return isyeriId;
	}
	public void setIsyeriId(Integer isyeriId) {
		this.isyeriId = isyeriId;
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
	public Long getGrupMapPersonelId() {
		return grupMapPersonelId;
	}
	public void setGrupMapPersonelId(Long grupMapPersonelId) {
		this.grupMapPersonelId = grupMapPersonelId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public PbsPersonelViewDto(Long personelId, Long tcKimlikNo, String adSoyad, String telefon, String pdksKartNo,
			Long kurumSicilNo, String fiiliGorevYeri, String mudurluk, String gorev, String isyeri,
			Long fiiliGorevYeriId, Long mudurlukId, Integer isyeriId, Integer grupId, String grupAdi,
			Long grupMapPersonelId) {
		super();
		this.personelId = personelId;
		this.tcKimlikNo = tcKimlikNo;
		this.adSoyad = adSoyad;
		this.telefon = telefon;
		this.pdksKartNo = pdksKartNo;
		this.kurumSicilNo = kurumSicilNo;
		this.fiiliGorevYeri = fiiliGorevYeri;
		this.mudurluk = mudurluk;
		this.gorev = gorev;
		this.isyeri = isyeri;
		this.fiiliGorevYeriId = fiiliGorevYeriId;
		this.mudurlukId = mudurlukId;
		this.isyeriId = isyeriId;
		this.grupId = grupId;
		this.grupAdi = grupAdi;
		this.grupMapPersonelId = grupMapPersonelId;
	}
	public PbsPersonelViewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	@Override
	public String toString() {
		if (adSoyad == null) {
			return null;
		} else {
			return adSoyad + " Müdürlük: "+ mudurluk +" / "+fiiliGorevYeri+ " Grup Adı: " +  grupAdi;
		}
	}
}