package com.uniyaz.dashboard.dto;

 

import java.io.Serializable;

public class PbsOrgutDto implements Serializable{

	private static final long serialVersionUID = 1L;
  
    private Long pbsOrgutId;
    
    private String adi;
    
    private String durum;

	public Long getPbsOrgutId() {
		return pbsOrgutId;
	}

	public void setPbsOrgutId(Long pbsOrgutId) {
		this.pbsOrgutId = pbsOrgutId;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getDurum() {
		return durum;
	}

	public void setDurum(String durum) {
		this.durum = durum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}   
    
}

