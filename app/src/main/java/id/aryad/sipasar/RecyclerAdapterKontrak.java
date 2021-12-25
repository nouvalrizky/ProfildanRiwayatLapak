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

import id.aryad.sipasar.data.AdminData;
import id.aryad.sipasar.data.KontrakData;
import id.aryad.sipasar.data.PegawaiData;
import id.aryad.sipasar.helpers.DateFormatter;
import id.aryad.sipasar.models.IuranModel;
import id.aryad.sipasar.models.KontrakModel;


public class RecyclerAdapterKontrak extends RecyclerView.Adapter<RecyclerAdapterKontrak.KontrakViewHolder> {

    private int id_lapak;
    private ArrayList<KontrakModel> kontrakData;

    public static class KontrakViewHolder extends RecyclerView.ViewHolder{

        public TextView periode_kontrak;
        public TextView tanggal_bayar_kontrak;
        public TextView admin_kontrak;
        public TextView harga_kontrak;

        public KontrakViewHolder(@NonNull View itemView) {
            super(itemView);

            periode_kontrak = itemView.findViewById(R.id.periode_kontrak);
            tanggal_bayar_kontrak = itemView.findViewById(R.id.tanggal_bayar_kontrak);
            admin_kontrak = itemView.findViewById(R.id.admin_kontrak);
            harga_kontrak = itemView.findViewById(R.id.harga_kontrak);

        }
    }

    public RecyclerAdapterKontrak(int id_lapak, ArrayList<KontrakModel> kontrakData){
        this.id_lapak = id_lapak;
        this.kontrakData = kontrakData;
    }

    @NonNull
    @Override
    public KontrakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kontrak_lapak,
                parent, false);
        KontrakViewHolder kontrakViewHolder = new KontrakViewHolder(v);
        return kontrakViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KontrakViewHolder holder, int position) {
        KontrakModel currentItem = kontrakData.get(position);

        if (currentItem.getId_lapak()!=id_lapak){
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }else{
            holder.harga_kontrak.setText(getDecimalPrice(currentItem.getNilai()));
            holder.admin_kontrak.setText("Admin : " + getAdmin(currentItem.getId_admin()));
            try {

                String date1 = DateFormatter.formatTanggal(currentItem.getTanggal_kontrak_awal());
                String date2 = DateFormatter.formatTanggal(currentItem.getTanggal_kontrak_akhir());
                holder.periode_kontrak.setText("Masa " + date1 + " - " + date2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                holder.tanggal_bayar_kontrak.setText(DateFormatter.formatTanggal(currentItem.getTanggal_bayar()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public int getItemCount() {
        return kontrakData.size();
    }

    protected String getAdmin(int id_admin){
        AdminData adminData = new AdminData();
        for (int i = 0 ; i<adminData.getAkunAdmin().size() ; i++){
            if (adminData.getAkunAdmin().get(i).getId_admin()==id_admin){
                return getPegawai(adminData.getAkunAdmin().get(i).getId_pegawai());
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
