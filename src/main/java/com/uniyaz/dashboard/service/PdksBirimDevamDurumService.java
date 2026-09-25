package com.uniyaz.dashboard.service;

import java.util.List;

import com.uniyaz.dashboard.dto.PdksBirimDevamDurumDto;
import com.uniyaz.sistem.dao.GenericRestDao;

public class PdksBirimDevamDurumService {
	
	GenericRestDao<PdksBirimDevamDurumDto> client = new GenericRestDao<PdksBirimDevamDurumDto>(PdksBirimDevamDurumDto.class);
	

	public PdksBirimDevamDurumService() {
		client = new GenericRestDao<PdksBirimDevamDurumDto>(PdksBirimDevamDurumDto.class);
	}
	
	public List<PdksBirimDevamDurumDto> selectAll(String kullanici) throws Exception {
		List<PdksBirimDevamDurumDto> pdksBirimDevamDurumDto = client.findAll("http://127.0.0.1:7788/eKurumSpringWs/abb/pdks/selectallIlce/"+kullanici);
		return pdksBirimDevamDurumDto;
	}

}
