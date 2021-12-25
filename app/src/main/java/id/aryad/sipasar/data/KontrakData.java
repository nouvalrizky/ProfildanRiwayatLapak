package id.aryad.sipasar.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import id.aryad.sipasar.helpers.IncrementId;
import id.aryad.sipasar.models.KontrakModel;

public class KontrakData {
    public ArrayList<KontrakModel> kontrakData;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public KontrakData() {
        kontrakData = new ArrayList<>();

        IncrementId incrementKontrak = new IncrementId();

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 1, "2018-02" +
                "-20", "2018-02-20", "2022-02-20", 14000000, 2,
                4, "2018-05-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 1, "2016-05" +
                "-01", "2016-05-01", "2018-05-02", 14000000, 1,
                4, "2016-05-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 1, "2012-05" +
                "-01", "2012-05-01", "2016-05-02", 14000000, 2,
                4, "2012-05-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 2, "2020-12-04", "2020-12-04", "2024-12-04", 28000000, 1,
                4, "2020-12-12"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 2, "2017-12-04", "2017-12-04",
                "2020-12-04", 21000000, 1,
                4, "2017-12-12"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 3, "2018-07" +
                "-20", "2018-07-20", "2023-07-20", 35000000, 1,
                4, "2018-07-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 3, "2016-05" +
                "-01", "2016-07-01", "2018-07-02", 14000000, 2,
                4, "2021-07-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 4, "2018-02" +
                "-20", "2018-02-20", "2022-02-20", 14000000, 1,
                4, "2022-05-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 4, "2016-05" +
                "-01", "2016-05-01", "2018-05-02", 14000000, 2,
                4, "2021-05-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 5, "2021-09" +
                "-20", "2021-09-20", "2026-09-20", 35000000, 1,
                4, "2021-09-20"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 5, "2016-09-20", "2016-05-01",
                "2021-09-20", 35000000, 1,
                4, "2021-09-20"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 6, "2016-05" +
                "-20", "2016-05-20", "2018-05-20", 14000000, 2,
                4, "2016-05-20"));


        kontrakData.add(new KontrakModel(incrementKontrak.up(), 7, "2018-11" +
                "-20", "2018-11-20", "2022-11-20", 28000000, 1,
                4, "2021-11-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 7, "2016-11-20", "2016-11-20",
                "2018-11-20", 14000000, 1,
                4, "2018-11-20"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 8, "2017-02" +
                "-20", "2017-02-20", "2019-02-20", 14000000, 2,
                4, "2017-03-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 8, "2015-05" +
                "-01", "2015-05-01", "2016-05-02", 7000000, 1,
                4, "2015-03-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 9, "2017-02" +
                "-20", "2017-02-20", "2022-02-20", 35000000, 2,
                4, "2017-03-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 9, "2016-05" +
                "-01", "2016-05-01", "2017-05-02", 7000000, 1,
                4, "2016-05-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 10, "2018-02" +
                "-20", "2018-02-20", "2022-02-20", 14000000, 2,
                4, "2018-03-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 10, "2016-05" +
                "-01", "2016-05-01", "2018-05-02", 14000000, 2,
                4, "2016-05-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 11, "2017-05" +
                "-01", "2017-05-01", "2022-05-02", 35000000, 2,
                4, "2017-05-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 11, "2012-02" +
                "-20", "2012-02-20", "2017-02-20", 35000000, 1,
                4, "2012-05-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 12, "2016-07" +
                "-20", "2016-07-20", "2023-07-20", 49000000, 1,
                4, "2016-07-01"));

        kontrakData.add(new KontrakModel(incrementKontrak.up(), 12, "2015-05" +
                "-01", "2015-08-01", "2016-08-02", 7000000, 2,
                4, "2015-08-01"));
    }

    public ArrayList<KontrakModel> getKontrakData() {
        return kontrakData;
    }

    public void setKontrakData(ArrayList<KontrakModel> kontrakData) {
        this.kontrakData = kontrakData;
    }
}
