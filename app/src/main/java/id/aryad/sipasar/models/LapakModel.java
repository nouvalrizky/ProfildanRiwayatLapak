package id.aryad.sipasar.models;

import android.os.Parcel;
import android.os.Parcelable;

public class LapakModel implements Parcelable {

//  Deklarasi Field sesuai tabel
    private int id_lapak;
    private String nama_lapak;
    private int id_kategori_lapak;
    private String nama_pemilik;
    private String alamat_pemilik;
    private int foto_pemilik;
    private String posisi_lapak;
    private int status;
    private String tanggal_pendaftaran;
    private String tanggal_akhir_kontrak;
    private int id_admin;

//  Constructor
    public LapakModel(
            int id_lapak,
            String nama_lapak,
            int id_kategori_lapak,
            String nama_pemilik,
            String alamat_pemilik,
            int foto_pemilik,
            String posisi_lapak,
            int status,
            String tanggal_pendaftaran,
            String tanggal_akhir_kontrak,
            int id_admin)
    {
        this.id_lapak = id_lapak;
        this.nama_lapak = nama_lapak;
        this.id_kategori_lapak = id_kategori_lapak;
        this.nama_pemilik = nama_pemilik;
        this.alamat_pemilik = alamat_pemilik;
        this.foto_pemilik = foto_pemilik;
        this.posisi_lapak = posisi_lapak;
        this.status = status;
        this.tanggal_pendaftaran = tanggal_pendaftaran;
        this.tanggal_akhir_kontrak = tanggal_akhir_kontrak;
        this.id_admin = id_admin;
    }

    protected LapakModel(Parcel in) {
        id_lapak = in.readInt();
        nama_lapak = in.readString();
        id_kategori_lapak = in.readInt();
        nama_pemilik = in.readString();
        alamat_pemilik = in.readString();
        foto_pemilik = in.readInt();
        posisi_lapak = in.readString();
        status = in.readInt();
        id_admin = in.readInt();
        tanggal_pendaftaran = in.readString();
        tanggal_akhir_kontrak = in.readString();
    }

    public static final Creator<LapakModel> CREATOR = new Creator<LapakModel>() {
        @Override
        public LapakModel createFromParcel(Parcel in) {
            return new LapakModel(in);
        }

        @Override
        public LapakModel[] newArray(int size) {
            return new LapakModel[size];
        }
    };

    //  Getter
    public int getId_lapak() {
        return id_lapak;
    }

    public String getNama_lapak() {
        return nama_lapak;
    }

    public int getId_kategori_lapak() {
        return id_kategori_lapak;
    }

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public String getAlamat_pemilik() {
        return alamat_pemilik;
    }

    public int getFoto_pemilik() {
        return foto_pemilik;
    }

    public String getPosisi_lapak() {
        return posisi_lapak;
    }

    public int getStatus() {
        return status;
    }

    public String getTanggal_pendaftaran() {
        return tanggal_pendaftaran;
    }

    public String getTanggal_akhir_kontrak() {
        return tanggal_akhir_kontrak;
    }

    public int getId_admin() {
        return id_admin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_lapak);
        dest.writeString(nama_lapak);
        dest.writeInt(id_kategori_lapak);
        dest.writeString(nama_pemilik);
        dest.writeString(alamat_pemilik);
        dest.writeInt(foto_pemilik);
        dest.writeString(posisi_lapak);
        dest.writeInt(status);
        dest.writeInt(id_admin);
        dest.writeString(tanggal_pendaftaran);
        dest.writeString(tanggal_akhir_kontrak);
    }
}
