package com.uniyaz.dashboard.service;

import java.util.List;

import com.uniyaz.dashboard.dto.PdksBirimDevamDurumDto;
import com.uniyaz.dashboard.dto.PdksGrupMapKullaniciDto;
import com.uniyaz.dashboard.dto.PdksGrupMapPdksPersonelDto;
import com.uniyaz.dashboard.dto.PdksHareketListeDto;
import com.uniyaz.dashboard.dto.PdksPVardiyaDto;
import com.uniyaz.sistem.dao.GenericRestDao;

public class PdksBirimDevamDurumService {

	private static final String BASE_URL = "http://127.0.0.1:7788/eKurumSpringWs";
	private final GenericRestDao<PdksBirimDevamDurumDto> clientPdksBirimDevamDurum;
	private final GenericRestDao<PdksGrupMapPdksPersonelDto> clientPdksGrupMapPdksPersonel;
	private final GenericRestDao<PdksGrupMapKullaniciDto> clientPdksGrupMapKullanici;
	private final GenericRestDao<PdksHareketListeDto> clientPdksHareketListe;
	private final GenericRestDao<PdksPVardiyaDto> clientPdksPVardiyaListe;

	public PdksBirimDevamDurumService() {
		clientPdksBirimDevamDurum = new GenericRestDao<>(PdksBirimDevamDurumDto.class);
		clientPdksGrupMapPdksPersonel = new GenericRestDao<>(PdksGrupMapPdksPersonelDto.class);
		clientPdksGrupMapKullanici = new GenericRestDao<>(PdksGrupMapKullaniciDto.class);
		clientPdksHareketListe = new GenericRestDao<>(PdksHareketListeDto.class);
		clientPdksPVardiyaListe = new GenericRestDao<>(PdksPVardiyaDto.class);
	}

	/** * Tarih ve grup ID'lerine göre PDKS birim devam durumlarını getirir. */

	public List<PdksBirimDevamDurumDto> selectAll(String ilkTarih, String sonTarih, String grupIds) throws Exception {
		String url = BASE_URL + "/abb/pdks/hareketliste/selectallbygrup/" + ilkTarih + "/" + sonTarih + "/" + grupIds;
		return clientPdksBirimDevamDurum.findAll(url);
	}

	/** * Grup ID'lerine bağlı personelleri getirir. */

	public List<PdksGrupMapPdksPersonelDto> selectAllByGrupIds(String grupIds) throws Exception {
		String url = BASE_URL + "/abb/pdks/grupmappersonel/selectallbygrupids/" + grupIds;
		return clientPdksGrupMapPdksPersonel.findAll(url);
	}

	public List<PdksGrupMapKullaniciDto> selectAllByKullanici(String kullanici) throws Exception {
		String url = BASE_URL + "/abb/pdks/grupmapkullanici/selectallbykullanici/" + kullanici;
		return clientPdksGrupMapKullanici.findAll(url);
	}

	public List<PdksHareketListeDto> selectAllByGrup(String ilkTarih,String sonTarih,String grupIds) throws Exception {
		
		String url = BASE_URL + "/abb/pdks/hareketliste/selectallbygrup/"+ilkTarih+"/"+sonTarih+"/"+grupIds;
		return clientPdksHareketListe.findAll(url); 
	}
	
	public List<PdksPVardiyaDto> selectAllByVardiya() throws Exception {
		
		String url = BASE_URL + "/abb/pdks/vardiya/selectall";
		
		return clientPdksPVardiyaListe.findAll(url);
	}
	
}
