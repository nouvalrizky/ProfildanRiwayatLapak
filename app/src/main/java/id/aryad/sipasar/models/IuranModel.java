package id.aryad.sipasar.models;


public class IuranModel {
    private int id_pembayaran_iuran;
    private int id_lapak;
    private String tanggal_bayar;
    private String tanggal_iuran;
    private int periode_iuran;
    private int id_kategori_iuran;
    private int nilai;
    private int id_pegawai;
    private int id_manager;
    private String tanggal_penyerahan;

    public IuranModel(int id_pembayaran_iuran, int id_lapak, String tanggal_bayar,
                      String tanggal_iuran, int periode_iuran, int id_kategori_iuran, int nilai
            , int id_pegawai, int id_manager, String tanggal_penyerahan) {
        this.id_pembayaran_iuran = id_pembayaran_iuran;
        this.id_lapak = id_lapak;
        this.tanggal_bayar = tanggal_bayar;
        this.tanggal_iuran = tanggal_iuran;
        this.periode_iuran = periode_iuran;
        this.id_kategori_iuran = id_kategori_iuran;
        this.nilai = nilai;
        this.id_pegawai = id_pegawai;
        this.id_manager = id_manager;
        this.tanggal_penyerahan = tanggal_penyerahan;
    }

    public int getId_pembayaran_iuran() {
        return id_pembayaran_iuran;
    }

    public int getId_lapak() {
        return id_lapak;
    }

    public String getTanggal_bayar() {
        return tanggal_bayar;
    }

    public String getTanggal_iuran() {
        return tanggal_iuran;
    }

    public int getPeriode_iuran() {
        return periode_iuran;
    }

    public int getId_kategori_iuran() {
        return id_kategori_iuran;
    }

    public int getNilai() {
        return nilai;
    }

    public int getId_pegawai() {
        return id_pegawai;
    }

    public int getId_manager() {
        return id_manager;
    }

    public String getTanggal_penyerahan() {
        return tanggal_penyerahan;
    }
}
