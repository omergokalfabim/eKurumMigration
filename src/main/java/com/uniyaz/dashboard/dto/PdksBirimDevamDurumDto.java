package com.uniyaz.dashboard.dto;

public class PdksBirimDevamDurumDto {

	private String birimAdi;

    private int personelSayisi;
    private int girisYapan;
    private int gecKalan;
    private int izinli;
    private int raporlu;

    public PdksBirimDevamDurumDto(String birimAdi,
                               int personelSayisi,
                               int girisYapan,
                               int gecKalan,
                               int izinli,
                               int raporlu) {

        this.birimAdi = birimAdi;
        this.personelSayisi = personelSayisi;
        this.girisYapan = girisYapan;
        this.gecKalan = gecKalan;
        this.izinli = izinli;
        this.raporlu = raporlu;
    }

    public String getBirimAdi() {
        return birimAdi;
    }

    public void setBirimAdi(String birimAdi) {
        this.birimAdi = birimAdi;
    }

    public int getPersonelSayisi() {
        return personelSayisi;
    }

    public void setPersonelSayisi(int personelSayisi) {
        this.personelSayisi = personelSayisi;
    }

    public int getGirisYapan() {
        return girisYapan;
    }

    public void setGirisYapan(int girisYapan) {
        this.girisYapan = girisYapan;
    }

    public int getGecKalan() {
        return gecKalan;
    }

    public void setGecKalan(int gecKalan) {
        this.gecKalan = gecKalan;
    }

    public int getIzinli() {
        return izinli;
    }

    public void setIzinli(int izinli) {
        this.izinli = izinli;
    }

    public int getRaporlu() {
        return raporlu;
    }

    public void setRaporlu(int raporlu) {
        this.raporlu = raporlu;
    }
    
    public int getGirisYapanYuzde() {
        if (personelSayisi == 0) {
            return 0;
        }

        return (girisYapan * 100) / personelSayisi;
    }

    public int getGecKalanYuzde() {
        if (personelSayisi == 0) {
            return 0;
        }

        return (gecKalan * 100) / personelSayisi;
    }

    public int getIzinliYuzde() {
        if (personelSayisi == 0) {
            return 0;
        }

        return (izinli * 100) / personelSayisi;
    }

    public int getRaporluYuzde() {
        if (personelSayisi == 0) {
            return 0;
        }

        return (raporlu * 100) / personelSayisi;
    }
    
}
