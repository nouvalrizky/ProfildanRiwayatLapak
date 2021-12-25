package id.aryad.sipasar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;

import id.aryad.sipasar.data.KategoriIuranData;
import id.aryad.sipasar.data.KategoriLapakData;
import id.aryad.sipasar.data.PegawaiData;
import id.aryad.sipasar.helpers.DateFormatter;
import id.aryad.sipasar.models.IuranModel;

public class RecyclerAdapterIuran extends RecyclerView.Adapter<RecyclerAdapterIuran.IuranViewHolder> {

    private int id_lapak;
    private ArrayList<IuranModel> iuranData;

    public static class IuranViewHolder extends RecyclerView.ViewHolder{

        public TextView tanggal_iuran;
        public TextView kategori_iuran;
        public TextView pegawai_iuran;
        public TextView harga_iuran;


        public IuranViewHolder(@NonNull View itemView) {
            super(itemView);

            tanggal_iuran = itemView.findViewById(R.id.tanggal_iuran);
            kategori_iuran = itemView.findViewById(R.id.kategori_iuran);
            pegawai_iuran = itemView.findViewById(R.id.pegawai_iuran);
            harga_iuran = itemView.findViewById(R.id.harga_iuran);
        }
    }

    public RecyclerAdapterIuran(int id_lapak, ArrayList<IuranModel> iuranData){
        this.id_lapak = id_lapak;
        this.iuranData = iuranData;

    }

    @NonNull
    @Override
    public IuranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_iuran_lapak,
                parent, false);

        IuranViewHolder iuranViewHolder = new IuranViewHolder(v);
        return iuranViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IuranViewHolder holder, int position) {
        IuranModel currentItem = iuranData.get(position);

        if (currentItem.getId_lapak()!=id_lapak){
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }else{
            holder.harga_iuran.setText(getDecimalPrice(currentItem.getNilai()));
            holder.pegawai_iuran.setText("Pegawai : " + getPegawai(currentItem.getId_pegawai()));
            holder.kategori_iuran.setText(getKategoriIuran(currentItem.getId_kategori_iuran()));
        }

        try {
            holder.tanggal_iuran.setText(DateFormatter.formatTanggal(currentItem.getTanggal_bayar()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return iuranData.size();
    }

    protected String getKategoriIuran(int id_kategori){
        KategoriIuranData kategoriIuranData = new KategoriIuranData();
        for (int i = 0 ; i<kategoriIuranData.getKategoriIuranData().size() ; i++){
            if (kategoriIuranData.getKategoriIuranData().get(i).getId_kategori_iuran()==id_kategori){
                return kategoriIuranData.getKategoriIuranData().get(i).getNama_kategori_iuran();
            }
        }
        return "";
    }

    protected String getPegawai(int id_pegawai){
        PegawaiData pegawaiData = new PegawaiData();
        for (int i = 0 ; i<pegawaiData.getDataPegawai().size() ; i++){
            if (pegawaiData.getDataPegawai().get(i).getId_pegawai()==id_pegawai){
                return pegawaiData.getDataPegawai().get(i).getNama_pegawai();
            }
        }
        return "";
    }

    protected String getDecimalPrice(int harga){
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        return String.valueOf(kursIndonesia.format(harga));
    }
}
