package id.aryad.sipasar.models;


public class KontrakModel {
    private int id_pembayaran_kontrak;
    private int id_lapak;
    private String tanggal_bayar;
    private String tanggal_kontrak_awal;
    private String tanggal_kontrak_akhir;
    private int nilai;
    private int id_admin;
    private int id_manager;
    private String tanggal_penyerahan;

    public KontrakModel(int id_pembayaran_kontrak, int id_lapak, String tanggal_bayar, String tanggal_kontrak_awal, String tanggal_kontrak_akhir, int nilai, int id_admin, int id_manager, String tanggal_penyerahan) {
        this.id_pembayaran_kontrak = id_pembayaran_kontrak;
        this.id_lapak = id_lapak;
        this.tanggal_bayar = tanggal_bayar;
        this.tanggal_kontrak_awal = tanggal_kontrak_awal;
        this.tanggal_kontrak_akhir = tanggal_kontrak_akhir;
        this.nilai = nilai;
        this.id_admin = id_admin;
        this.id_manager = id_manager;
        this.tanggal_penyerahan = tanggal_penyerahan;
    }

    public int getId_pembayaran_kontrak() {
        return id_pembayaran_kontrak;
    }

    public int getId_lapak() {
        return id_lapak;
    }

    public String getTanggal_bayar() {
        return tanggal_bayar;
    }

    public String getTanggal_kontrak_awal() {
        return tanggal_kontrak_awal;
    }

    public String getTanggal_kontrak_akhir() {
        return tanggal_kontrak_akhir;
    }

    public int getNilai() {
        return nilai;
    }

    public int getId_admin() {
        return id_admin;
    }

    public int getId_manager() {
        return id_manager;
    }

    public String getTanggal_penyerahan() {
        return tanggal_penyerahan;
    }
}
