package id.aryad.sipasar;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.aryad.sipasar.data.KategoriLapakData;
import id.aryad.sipasar.models.LapakModel;

public class RecyclerAdapterLapak extends RecyclerView.Adapter<RecyclerAdapterLapak.RecyclerViewHolder> implements Filterable{

//  Deklarasi arraylist
    private ArrayList<LapakModel> lapakModels;
    private ArrayList<LapakModel> lapakItemsFullModel;

//  Deklarasi intent
    Intent intenttoDetail;

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        public ImageView foto_pemilik;
        public TextView nama_lapak;
        public TextView nama_pemilik;
        public CardView cardView;
        public TextView textBadgeKategori;
        public LinearLayout badgeKategori;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            foto_pemilik = itemView.findViewById(R.id.foto_pemilik);
            nama_lapak = itemView.findViewById(R.id.nama_lapak);
            cardView = itemView.findViewById(R.id.cardView);
            nama_pemilik = itemView.findViewById(R.id.nama_pemilik);
            textBadgeKategori = itemView.findViewById(R.id.textBadgeKategori);
            badgeKategori = itemView.findViewById(R.id.badgeKategori);
        }
    }

//  Constructor untuk menerima ArrayList ketika pembuatan objek
    public RecyclerAdapterLapak(ArrayList<LapakModel> lapakModels){
        this.lapakModels = lapakModels;
        lapakItemsFullModel = new ArrayList<>(lapakModels);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent,
                false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(v);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        LapakModel currentItem = this.lapakModels.get(position);
        holder.foto_pemilik.setImageResource(currentItem.getFoto_pemilik());
        holder.nama_lapak.setText(currentItem.getNama_lapak());
        holder.nama_pemilik.setText(currentItem.getNama_pemilik());

        holder.textBadgeKategori.setText(getKategori(currentItem.getId_kategori_lapak()));
        holder.badgeKategori.setBackgroundResource(getBadgeKategori(currentItem.getId_kategori_lapak()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intenttoDetail = new Intent(v.getContext(), LapakProfileActivity.class);
                intenttoDetail.putExtra("lapak", currentItem);
                v.getContext().startActivity(intenttoDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lapakModels.size();
    }

    @Override
    public Filter getFilter() {
        return lapakFilter;
    }

    private Filter lapakFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<LapakModel> filteredList = new ArrayList<>();

//          Jika kolom search kosong, maka tampilkan semua lapak
            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(lapakItemsFullModel);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(LapakModel item : lapakItemsFullModel){
                    if(item.getNama_lapak().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            lapakModels.clear();
            lapakModels.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

    protected String getKategori(int id_kategori){
        KategoriLapakData kategoriLapakData = new KategoriLapakData();
        for (int i = 0 ; i<kategoriLapakData.getKategoriLapakData().size(); i++){
            if(kategoriLapakData.getKategoriLapakData().get(i).getId_kategori_lapak() == id_kategori){
                return kategoriLapakData.getKategoriLapakData().get(i).getNama_kategori();
            }
        }
        return "";
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
