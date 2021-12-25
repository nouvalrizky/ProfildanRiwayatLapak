package id.aryad.sipasar.data;

import java.util.ArrayList;

import id.aryad.sipasar.R;
import id.aryad.sipasar.helpers.IncrementId;
import id.aryad.sipasar.models.LapakModel;

public class LapakData {
    private ArrayList<LapakModel> lapakData;

    public LapakData() {
        lapakData = new ArrayList<>();

        IncrementId incrementId = new IncrementId();

        lapakData.add(
                new LapakModel(incrementId.up(), "Sinar Plastik", 5, "Rizky Akbar Juliansyah",
                        "Jl. " +
                        "Mawar No. 110" +
                        " Denpasar " +
                        "Utara", R.drawable.sinar_plastik, "A1", 1, "2016-05-01",
                        "2022-02-20", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Buah Nirmala", 2, "Kumala", "Jl. Kenanga " +
                        "No. 12A " +
                        "Denpasar " +
                        "Selatan", R.drawable.buah_nirmala, "A2", 1, "2017-12-04"
                        , "2024-12-04", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Sayur Bu Selamet", 1, "Adi Guna Selamet", "Jl. " +
                        "Kembang No. 110 " +
                        "Denpasar " +
                        "Utara", R.drawable.person_1, "A3", 1, "2016-07-01",
                        "2023-07-20", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Taskia", 6, "Alexander", "Jl.Teuku Umar No. 117" +
                        " Denpasar Barat", R.drawable.person_2, "B1", 1, "2016-05-01",
                        "2022-02-20", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Devan Grosir", 4, "Panji", "Jl. Moch Yamin No. " +
                        "321, Denpasar Utara",
                        R.drawable.person_3, "B2", 1, "2016-05-01",
                        "2026-09-20", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Sayur Bu Desak", 1, "Desak", "Jl. " +
                        "Kembang No. 110 " +
                        "Denpasar " +
                        "Utara", R.drawable.person_4, "B3", 0, "2016-05-20",
                        "2018-05-20", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Bukde Buah", 2, "Farhunnisa Nuraini", "Ki. Raden Saleh " +
                        "No" +
                        ". 200, Denpasar Barat", R.drawable.person_5, "C1", 1, "2016-11-20",
                        "2022-11-20", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Aroma Meat Fresh", 3, "Iriana Padmasari",
                        "Jl. Bagis Utama No. 66, Denpasar Selatan", R.drawable.person_6, "C2", 0,
                        "2015-05-01",
                        "2019-02-20", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Sembako Barokah", 4, "Wirda Novitasari", "Jln. " +
                        "Baya Kali Bungur No. 43, Denpasar Utara", R.drawable.person_7, "C3", 1,
                        "2016-05-01",
                        "2022-02-20", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Jajan Baliku", 6, "Dipa Haryanto", "Jl" +
                        ".Panjaitan No. 34, Denpasar Barat", R.drawable.person_11, "D1", 1, "2016-05-01",
                        "2022-02-20", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Sayur Sri Wahyu", 1, "Sri Wahyu", "Jl. Bara " +
                        "Tambar No. 989, Kuta Selatan", R.drawable.person_9, "D2", 1, "2012-02-20",
                        "2022-05-02", 1)
        );
        lapakData.add(
                new LapakModel(incrementId.up(), "Oemah Daging Food", 3, "Makuta Permadi",
                        "Jl. Casablanca No. 377, Badung", R.drawable.person_10, "D2", 1, "2016-08-02",
                        "2023-07-20", 1)
        );
    }

    public ArrayList<LapakModel> getLapakData() {
        return lapakData;
    }

    public void setLapakData(ArrayList<LapakModel> lapakData) {
        this.lapakData = lapakData;
    }
}
