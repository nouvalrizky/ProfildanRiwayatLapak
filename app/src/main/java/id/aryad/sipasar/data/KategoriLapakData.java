package id.aryad.sipasar.data;

import java.util.ArrayList;

import id.aryad.sipasar.models.KategoriLapakModel;

public class KategoriLapakData {
    private ArrayList<KategoriLapakModel> kategoriLapakData;

    public KategoriLapakData() {
        kategoriLapakData = new ArrayList<>();

        kategoriLapakData.add(new KategoriLapakModel(1, "Sayuran"));
        kategoriLapakData.add(new KategoriLapakModel(2, "Buah-buahan"));
        kategoriLapakData.add(new KategoriLapakModel(3, "Daging"));
        kategoriLapakData.add(new KategoriLapakModel(4, "Sembako"));
        kategoriLapakData.add(new KategoriLapakModel(5, "Perabotan"));
        kategoriLapakData.add(new KategoriLapakModel(6, "Jajan Tradisional"));
    }

    public ArrayList<KategoriLapakModel> getKategoriLapakData() {
        return kategoriLapakData;
    }

    public void setKategoriLapakData(ArrayList<KategoriLapakModel> kategoriLapakData) {
        this.kategoriLapakData = kategoriLapakData;
    }
}
