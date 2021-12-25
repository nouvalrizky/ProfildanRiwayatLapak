package id.aryad.sipasar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import id.aryad.sipasar.data.LapakData;
import id.aryad.sipasar.data.PegawaiData;

public class ListLapakActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//  Deklarasi Field
    private RecyclerView recyclerView;
    private RecyclerAdapterLapak adapter;
    private RecyclerView.LayoutManager layoutManager;
    private DrawerLayout drawerLayout;
    private ImageView foto_admin;
    private TextView nama_admin;
    private LapakData lapakData;
    private TextView totalLapak;
    private TextView totalLapakAktif;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


//      Set toolbar buatan sendiri
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//      Hapus title bawaan toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//      Set id layout drawer
        drawerLayout = findViewById(R.id.drawer_layout);

//      Menambahkan hamburger icon di toolbar
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

//      Set id navigation drawer
        NavigationView navigationView = findViewById(R.id.nav_view);

//      Ganti header navigation dengan buatan sendiri, agar dapat dikostumisasi
        View headerView = navigationView.getHeaderView(0);
        nama_admin = headerView.findViewById(R.id.nama_admin);
        foto_admin = headerView.findViewById(R.id.foto_admin);

//      Atur info akun pada Navigation Drawer, sesuai pegawai yang login
        setInfoAkun();

//      Set Click listener dari navigation drawer, dengan method yg dioveride
        navigationView.setNavigationItemSelectedListener(this);

//      Instance object Data Lapak
        lapakData = new LapakData();


//      Set Overview
        setOverview();

//      Atur Recycler View list lapak
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerAdapterLapak(lapakData.getLapakData());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lapak_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.search_icon);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutButton:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        this);

                // set title dialog
                alertDialogBuilder.setTitle("Yakin ingin logout?");

                // set pesan dari dialog
                alertDialogBuilder
                        .setMessage("Klik Ya untuk logout")
                        .setCancelable(false)
                        .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                SessionManagement sessionManagement = new SessionManagement(ListLapakActivity.this);
                                sessionManagement.removeSession();

                                Intent intent = new Intent(ListLapakActivity.this, LoginPegawaiActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("Batal",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                // membuat alert dialog dari builder
                AlertDialog alertDialog = alertDialogBuilder.create();

                // menampilkan alert dialog
                alertDialog.show();

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            this.finishAffinity();
        }
    }

    public void setInfoAkun(){
        SessionManagement sessionManagement = new SessionManagement(ListLapakActivity.this);
        sessionManagement.getSession();

        PegawaiData pegawaiData = new PegawaiData();
        for(int i = 0 ; i<pegawaiData.getDataPegawai().size() ; i++){
            if (pegawaiData.getDataPegawai().get(i).getId_pegawai()==sessionManagement.getSession()){
                foto_admin.setImageResource(pegawaiData.getDataPegawai().get(i).getFoto());
                nama_admin.setText(pegawaiData.getDataPegawai().get(i).getNama_pegawai());
            }
        }
    }

    protected void setOverview(){
//      Konek ID
        totalLapak = findViewById(R.id.totalLapak);
        totalLapakAktif = findViewById(R.id.totalLapakAktif);
//      Set overview data
        totalLapak.setText(String.valueOf(lapakData.getLapakData().size()));

        int lapakAktif = 0;

        for (int i = 0 ; i < lapakData.getLapakData().size() ; i++){
            if (lapakData.getLapakData().get(i).getStatus()==1){
                lapakAktif++;
            }
        }

        totalLapakAktif.setText(String.valueOf(lapakAktif));

    }
}