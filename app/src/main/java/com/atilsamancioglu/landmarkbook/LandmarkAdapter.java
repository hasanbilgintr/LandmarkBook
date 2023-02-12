package com.atilsamancioglu.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atilsamancioglu.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {

    ArrayList<Landmark> landmarkList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkList) {

        this.landmarkList = landmarkList;
    }
    @NonNull
    @Override
    //viewholder sınıfından bir obje oluşturulduğunda çağırılcak olan metot
    //xmlimizi(binding) bağlama işlemini burda yapıcaz
    public LandmarkHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LandmarkHolder(recyclerRowBinding);
    }
    @Override
    //layoutumun içersinde hangi verileri göstermek istersek burda yazıcaz
    public void onBindViewHolder(LandmarkAdapter.LandmarkHolder holder, int position) {

        holder.binding.recyclerViewTextView.setText(landmarkList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                Singleton singleton = Singleton.getInstance();
                //ıntent yöntemi //intent.putExtra("landmark",landmarkList.get(position));
                //intent veriler gönderirken kapasitesi önemli bielli kapasiteden sonra mesela bitmap atılamaz
                //statik yöntem static oluştururuz heryerden get set edilerek veriler çekilebilir
                //buda set bir defa edilebiliyo sonrası için edilemiyor bu şekilde kontrolünü sağalmış oluyoruz
                singleton.setChosenLandmark(landmarkList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //xml kaç kere oluşacağını sölücek yani item sayısı yani 4
        return landmarkList.size();
    }
    //
    //LandmarkHolder isim verilerek görünümlerimizi tutacak yardımcı bir sınıf
    //ViewHolder yani görünüm tutucu
    public class LandmarkHolder extends RecyclerView.ViewHolder {

        //layout ismi binding alındı
        private RecyclerRowBinding binding;


        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
