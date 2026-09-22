package com.uniyaz.sistem.dto;

public class Personel {
    private Long id;
    private String adSoyad;
    private String birim;
    private String durum;

    public Personel(Long id, String adSoyad, String birim, String durum) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.birim = birim;
        this.durum = durum;
    }

    public Long getId() { return id; }
    public String getAdSoyad() { return adSoyad; }
    public String getBirim() { return birim; }
    public String getDurum() { return durum; }
}
