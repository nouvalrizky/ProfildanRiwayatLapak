package id.aryad.sipasar.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import id.aryad.sipasar.helpers.IncrementId;
import id.aryad.sipasar.models.IuranModel;

public class IuranData {
    public ArrayList<IuranModel> iuranData;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public IuranData() {
        iuranData = new ArrayList<>();

        IncrementId incrementIuran = new IncrementId();

        iuranData.add(
                new IuranModel(incrementIuran.up(), 1, "2021-05-26",
                        "2021-05-01", 30, 1, 20000, 1, 4, "2021" +
                        "-05-03")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 1, "2021-05-19",
                        "2021-05-04", 30, 2, 80000, 2, 4, "2021" +
                        "-05-06")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 1, "2021-04-28",
                        "2021-05-11", 7, 3, 10000, 1, 4, "2021" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 1, "2021-04-05",
                        "2021-05-11", 7, 3, 10000, 2, 4, "2021" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 2, "2021-04-24",
                        "2021-05-04", 7, 1, 20000, 2, 4, "2021" +
                        "-05-06")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 2, "2021-04-12",
                        "2021-05-11", 7, 3, 10000, 2, 4, "2021" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 2, "2021-03-30",
                        "2021-05-11", 7, 3, 10000, 1, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 3, "2021-05-20",
                        "2021-05-04", 7, 2, 80000, 2, 4, "2021" +
                        "-05-06")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 3, "2021-05-12",
                        "2021-05-11", 7, 1, 20000, 2, 4, "2021" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 3, "2021-04-05",
                        "2021-05-11", 30, 2, 80000, 1, 4, "2021" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 3, "2021-04-20",
                        "2021-05-11", 7, 2, 80000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 4, "2021-04-24",
                        "2021-05-04", 7, 3, 10000, 2, 4, "2021" +
                        "-05-06")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 4, "2021-04-12",
                        "2021-05-11", 7, 3, 10000, 1, 4, "2021" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 4, "2021-04-05",
                        "2021-05-11", 30, 2, 80000, 1, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 5, "2021-03-19",
                        "2021-05-11", 7, 1, 20000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 5, "2021-03-10",
                        "2021-05-04", 30, 2, 80000, 2, 4, "2021" +
                        "-05-06")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 5, "2021-03-02",
                        "2021-05-11", 7, 3, 10000, 1, 4, "2021" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 6, "2021-05-26",
                        "2021-05-11", 7, 1, 20000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 6, "2021-05-21",
                        "2021-05-11", 30, 2, 80000, 1, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 6, "2021-04-19",
                        "2021-05-11", 7, 1, 20000, 1, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 6, "2018-03-10",
                        "2021-05-04", 30, 2, 80000, 2, 4, "2021" +
                        "-05-06")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 6, "2018-03-02",
                        "2021-05-11", 7, 3, 10000, 1, 4, "2021" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 6, "2018-03-01",
                        "2021-05-11", 7, 1, 20000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 7, "2021-05-18",
                        "2021-05-04", 30, 2, 80000, 2, 4, "2018" +
                        "-05-06")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 7, "2021-05-07",
                        "2021-05-11", 7, 3, 10000, 1, 4, "2018" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 7, "2021-04-20",
                        "2021-05-11", 7, 1, 20000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 8, "2019-04-26",
                        "2019-05-11", 7, 1, 20000, 2, 4, "2019" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 8, "2019-02-21",
                        "2019-05-11", 30, 2, 80000, 1, 4, "2019" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 8, "2019-02-10",
                        "2019-05-11", 7, 1, 20000, 1, 4, "2019" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 9, "2021-02-12",
                        "2021-05-11", 30, 2, 80000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 9, "2021-02-03",
                        "2021-05-11", 7, 1, 20000, 1, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 9, "2021-01-26",
                        "2021-05-04", 30, 2, 80000, 2, 4, "2021" +
                        "-05-06")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 9, "2021-01-17",
                        "2021-05-11", 7, 3, 10000, 1, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 10, "2021-03-02",
                        "2021-05-11", 7, 3, 10000, 1, 4, "2021" +
                        "-05-13")
        );

        iuranData.add(
                new IuranModel(incrementIuran.up(), 10, "2021-05-26",
                        "2021-05-11", 7, 1, 20000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 10, "2021-05-21",
                        "2021-05-11", 30, 2, 80000, 1, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 10, "2021-04-19",
                        "2021-05-11", 7, 1, 20000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 11, "2021-04-21",
                        "2021-05-11", 30, 2, 80000, 1, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 11, "2021-04-19",
                        "2021-05-11", 7, 1, 20000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 12, "2021-05-21",
                        "2021-05-11", 30, 2, 80000, 2, 4, "2021" +
                        "-05-13")
        );
        iuranData.add(
                new IuranModel(incrementIuran.up(), 12, "2021-04-19",
                        "2021-05-11", 7, 1, 20000, 1, 4, "2021" +
                        "-05-13")
        );

    }

    public ArrayList<IuranModel> getIuranData() {
        return iuranData;
    }

    public void setIuranData(ArrayList<IuranModel> iuranData) {
        this.iuranData = iuranData;
    }
}
