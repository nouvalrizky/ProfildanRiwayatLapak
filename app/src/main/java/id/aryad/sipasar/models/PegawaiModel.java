package id.aryad.sipasar.models;

public class PegawaiModel {
    private int id_pegawai;
    private String nama_pegawai;
    private String alamat;
    private int foto;

    public PegawaiModel(int id_pegawai, String nama_pegawai, String alamat, int foto) {
        this.id_pegawai = id_pegawai;
        this.nama_pegawai = nama_pegawai;
        this.alamat = alamat;
        this.foto = foto;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public String getNama_pegawai() {
        return nama_pegawai;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getFoto() {
        return foto;
    }
}
