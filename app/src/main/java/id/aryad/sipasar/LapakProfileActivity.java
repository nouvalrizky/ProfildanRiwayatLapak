package id.aryad.sipasar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import id.aryad.sipasar.data.IuranData;
import id.aryad.sipasar.data.KategoriLapakData;
import id.aryad.sipasar.data.KontrakData;
import id.aryad.sipasar.models.LapakModel;

public class LapakProfileActivity extends AppCompatActivity {

    private TextView id_lapak;
    private TextView id_kategori_lapak;
    private TextView nama_lapak;
    private TextView nama_pemilik;
    private TextView alamat_pemilik;
    private TextView posisi_lapak;
    private TextView status;
    private TextView tanggal_pendaftaran;
    private TextView tanggal_akhir_kontrak;
    private ImageView foto_lapak;
    private LinearLayout badge_color;
    private TextView nama_pemilik_lapak;
    private int id_lapak_iuran;
    private IuranData iuranData;
    private KontrakData kontrakData;
    private ScrollView scrollViewIuran;

    private RecyclerView recyclerViewIuran;
    private RecyclerView.Adapter adapterIuran;
    private RecyclerView.LayoutManager layoutManagerIuran;

    private RecyclerView recyclerViewKontrak;
    private RecyclerView.Adapter adapterKontrak;
    private RecyclerView.LayoutManager layoutManagerKontrak;



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapak_profile);



        connectIdView();
        try {
            setView();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        iuranData = new IuranData();
        kontrakData = new KontrakData();


//      Set toolbar buatan sendiri
        Toolbar toolbar = findViewById(R.id.toolbarProfil);
        setSupportActionBar(toolbar);

//      Hapus title bawaan toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//      Tambah tombol back di toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        scrollViewIuran = findViewById(R.id.scrollIuran);
//
//        scrollViewIuran.setNestedScrollingEnabled(false);

        recyclerViewIuran = findViewById(R.id.recyclerViewIuran);
        layoutManagerIuran = new LinearLayoutManager(this);
        adapterIuran = new RecyclerAdapterIuran(id_lapak_iuran, iuranData.getIuranData());

        recyclerViewIuran.setLayoutManager(layoutManagerIuran);
        recyclerViewIuran.setAdapter(adapterIuran);
        recyclerViewIuran.setNestedScrollingEnabled(false);

        recyclerViewKontrak = findViewById(R.id.recyclerViewKontrak);
        layoutManagerKontrak = new LinearLayoutManager(this);
        adapterKontrak = new RecyclerAdapterKontrak(id_lapak_iuran, kontrakData.getKontrakData());

        recyclerViewKontrak.setLayoutManager(layoutManagerKontrak);
        recyclerViewKontrak.setAdapter(adapterKontrak);
        recyclerViewKontrak.setNestedScrollingEnabled(false);

//        recyclerViewKontrak.setNestedScrollingEnabled(false);

//        scrollViewIuran = findViewById(R.id.scrollIuran);
//        scrollViewIuran.setNestedScrollingEnabled(false);

//        ViewCompat.setNestedScrollingEnabled(recyclerViewIuran, false);
//        ViewCompat.setNestedScrollingEnabled(recyclerViewKontrak, false);


    }

    protected void connectIdView(){
//      Menghubungkan id
//        id_lapak = (TextView) findViewById(R.id.id_lapak);
        nama_lapak = (TextView) findViewById(R.id.nama_lapak);
        foto_lapak = (ImageView) findViewById(R.id.profil_foto_pemilik);
        id_kategori_lapak = (TextView) findViewById(R.id.id_kategori_lapak);
        nama_pemilik = (TextView) findViewById(R.id.nama_pemilik);
        alamat_pemilik = (TextView) findViewById(R.id.alamat_pemilik);
        posisi_lapak = (TextView) findViewById(R.id.posisi_lapak);
        status = (TextView) findViewById(R.id.status_lapak);
        tanggal_pendaftaran = (TextView) findViewById(R.id.tanggal_pendaftaran);
        tanggal_akhir_kontrak = (TextView) findViewById(R.id.tanggal_akhir_kontrak);
        nama_pemilik_lapak = findViewById(R.id.nama_pemilik_lapak);
        badge_color = findViewById(R.id.badge_color);
    }

    protected void setView() throws ParseException {
//      Mengambil data dari Intent
        Intent getLapak = getIntent();
        LapakModel dataRinciLapak = getLapak.getParcelableExtra("lapak");

        id_lapak_iuran = dataRinciLapak.getId_lapak();

//      Set view
//        id_lapak.setText(String.valueOf(dataRinciLapak.getId_lapak()));
        nama_lapak.setText("Toko " + dataRinciLapak.getNama_lapak());
        foto_lapak.setImageResource(dataRinciLapak.getFoto_pemilik());
        id_kategori_lapak.setText(kategoriLapak(dataRinciLapak.getId_kategori_lapak()));
        nama_pemilik.setText(dataRinciLapak.getNama_pemilik());
        alamat_pemilik.setText(dataRinciLapak.getAlamat_pemilik());
        posisi_lapak.setText(dataRinciLapak.getPosisi_lapak());
        tanggal_pendaftaran.setText(formatTanggal(dataRinciLapak.getTanggal_pendaftaran()));
        tanggal_akhir_kontrak.setText(formatTanggal(dataRinciLapak.getTanggal_akhir_kontrak()));
        status.setText(statusLapak(dataRinciLapak.getStatus()));
        nama_pemilik_lapak.setText(dataRinciLapak.getNama_pemilik());
        badge_color.setBackgroundResource(getBadgeKategori(dataRinciLapak.getId_kategori_lapak()));
        if (dataRinciLapak.getStatus()==1){
            status.setTextColor(Color.parseColor("#17ab0c"));
        }else{
            status.setTextColor(Color.parseColor("#ab0c0c"));
        }

    }

    protected String statusLapak(int flagStatus){
        if (flagStatus==1){
            return "Aktif";
        }else{
            return "Nonaktif";
        }
    }

    protected String kategoriLapak(int flagKategori){
        KategoriLapakData kategoriLapakData = new KategoriLapakData();
        for (int i = 0 ; i<kategoriLapakData.getKategoriLapakData().size() ; i++){
            if (kategoriLapakData.getKategoriLapakData().get(i).getId_kategori_lapak()==flagKategori){
                return kategoriLapakData.getKategoriLapakData().get(i).getNama_kategori();
            }
        }
        return "";
    }

    protected Date stringToDate(String dob) throws ParseException {
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //Parsing the given String to Date object
        Date date = formatter.parse(dob);
        System.out.println("Date object value: "+date);
        return date;
    }

    protected String formatTanggal(String tanggal) throws ParseException {
        Date date = stringToDate(tanggal);
        String formatted_date = new SimpleDateFormat("dd MMM yyyy").format(date);
        return formatted_date;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    protected int getBadgeKategori(int id_kategori){
        if(id_kategori==1){
            return R.drawable.round_green;
        }else if(id_kategori==2){
            return R.drawable.round_yellow;
        }else if(id_kategori==3){
            return R.drawable.round_red;
        }else if(id_kategori==4){
            return R.drawable.round_blue;
        }else if(id_kategori==6){
            return R.drawable.round_purple;
        }
        return R.drawable.round_black;
    }

}