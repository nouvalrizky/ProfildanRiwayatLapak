package id.aryad.sipasar.models;

public class KategoriLapakModel {
    private int id_kategori_lapak;
    private String nama_kategori;

    public KategoriLapakModel(int id_kategori_lapak, String nama_kategori) {
        this.id_kategori_lapak = id_kategori_lapak;
        this.nama_kategori = nama_kategori;
    }

    public int getId_kategori_lapak() {
        return id_kategori_lapak;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }
}
