package id.aryad.sipasar.data;

import java.util.ArrayList;

import id.aryad.sipasar.R;
import id.aryad.sipasar.models.PegawaiModel;

public class PegawaiData {
    private ArrayList<PegawaiModel> dataPegawai;

    public PegawaiData() {
        dataPegawai = new ArrayList<>();
        dataPegawai.add(new PegawaiModel(1, "Nouval Rizky", "Jalan Diponegoro Denpasar Selatan",
                R.drawable.pegawai_1));
        dataPegawai.add(new PegawaiModel(2, "Arya Dharmaadi", "Jalan Mawar Denpasar Selatan",
                R.drawable.arya_dharmaadi));
        dataPegawai.add(new PegawaiModel(3, "Arya Dharmaadi", "Jalan Mawar Denpasar Selatan",
                R.drawable.arya_dharmaadi));
        dataPegawai.add(new PegawaiModel(4, "Arya Dharmaadi", "Jalan Mawar Denpasar Selatan",
                R.drawable.arya_dharmaadi));
    }

    public ArrayList<PegawaiModel> getDataPegawai() {
        return dataPegawai;
    }

    public void setDataPegawai(ArrayList<PegawaiModel> dataPegawai) {
        this.dataPegawai = dataPegawai;
    }
}
