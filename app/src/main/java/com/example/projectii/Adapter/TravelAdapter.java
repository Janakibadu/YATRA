package com.example.projectii.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectii.Model.PlacesModel;
import com.example.projectii.R;

import java.util.ArrayList;

public class TravelAdapter extends RecyclerView.Adapter<TravelAdapter.viewHolder> {
        ArrayList<PlacesModel> list;
        Context context;

        public TravelAdapter(ArrayList<PlacesModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_places, parent, false);
            return new viewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        PlacesModel model=list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());
    }


        @Override
        public int getItemCount() {
            return list.size();
        }

        public class viewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            ImageView imageView;

            public viewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.adv);
                textView = itemView.findViewById(R.id.tadv);

            }

            class ItemViewHolder extends RecyclerView.ViewHolder {

                private CardView cardView;


                public ItemViewHolder(@NonNull View itemView) {
                    super(itemView);

                    cardView = itemView.findViewById(R.id.cardview);

                }
            }
        }
}
