package com.uniyaz.dashboard.bean;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

 

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

 
@Named("pdksBirimDevamDurumBean")
@ViewScoped
public class PdksBirimDevamDurumBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private Date ilkIslemTarihi;
	private Date sonIslemTarihi;
	
	private Integer grupId;
	private Integer vardiyaId;
	
	
	
	
	
	
	
	
	
	
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
	
}

