package com.example.recyclerviewecommerce;

public class FilmLer {
    private int filmID;
    private String filmBaslik;
    private double filmFiyat;
    private String filmResimAdi;

    public FilmLer() {
    }

    public FilmLer(int filmID, String filmBaslik, double filmFiyat, String filmResimAdi) {
        this.filmID = filmID;
        this.filmBaslik = filmBaslik;
        this.filmFiyat = filmFiyat;
        this.filmResimAdi = filmResimAdi;
    }

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getFilmBaslik() {
        return filmBaslik;
    }

    public void setFilmBaslik(String filmBaslik) {
        this.filmBaslik = filmBaslik;
    }

    public double getFilmFiyat() {
        return filmFiyat;
    }

    public void setFilmFiyat(double filmFiyat) {
        this.filmFiyat = filmFiyat;
    }

    public String getFilmResimAdi() {
        return filmResimAdi;
    }

    public void setFilmResimAdi(String filmResimAdi) {
        this.filmResimAdi = filmResimAdi;
    }
}
