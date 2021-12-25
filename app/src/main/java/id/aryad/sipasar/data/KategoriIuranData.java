package id.aryad.sipasar.data;

import java.util.ArrayList;

import id.aryad.sipasar.models.KategoriIuranModel;

public class KategoriIuranData {
    private ArrayList<KategoriIuranModel> kategoriIuranData;

    public KategoriIuranData() {
        kategoriIuranData = new ArrayList<>();

        kategoriIuranData.add(new KategoriIuranModel(1, "Iuran Sampah", 20000, 1));
        kategoriIuranData.add(new KategoriIuranModel(2, "Iuran Air", 80000, 1));
        kategoriIuranData.add(new KategoriIuranModel(3, "Iuran Keamanan", 10000, 1));
    }

    public ArrayList<KategoriIuranModel> getKategoriIuranData() {
        return kategoriIuranData;
    }
}
