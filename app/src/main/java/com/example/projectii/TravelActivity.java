package com.example.projectii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.projectii.Adapter.PlacesAdapter;
import com.example.projectii.Adapter.TravelAdapter;
import com.example.projectii.Model.PlacesModel;

import java.util.ArrayList;

public class TravelActivity extends AppCompatActivity {
   RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelplaces);
        getSupportActionBar().hide();
        recyclerView=findViewById((R.id.recyclerview));
        ArrayList<PlacesModel>list=new ArrayList<>();
        list.add(new PlacesModel(R.drawable.pcablecar1, "Cable Car"));
        list.add(new PlacesModel(R.drawable.mahendracave, "Mahendra Cave"));
        list.add(new PlacesModel(R.drawable.majhikuna, "Majhi Kuna"));
        list.add(new PlacesModel(R.drawable.barahitemple, "Barahi Temple"));
        list.add(new PlacesModel(R.drawable.begnas,"Begnas Lake"));
        list.add(new PlacesModel(R.drawable.akeside,"Lakeside"));
        list.add(new PlacesModel(R.drawable.bindabasani,"Bindabasini"));
        list.add(new PlacesModel(R.drawable.shantistupa,"Stupa"));
        list.add(new PlacesModel(R.drawable.pumdikot,"Pumdikot view"));
        list.add(new PlacesModel(R.drawable.rangkot,"SarangKot"));
        list.add(new PlacesModel(R.drawable.rupakot,"RupaKot "));
        list.add(new PlacesModel(R.drawable.phewalake,"Lake Side"));
        list.add(new PlacesModel(R.drawable.batcave,"Bat Cave"));
        list.add(new PlacesModel(R.drawable.damside,"Dam Side"));
        list.add(new PlacesModel(R.drawable.pamey,"Pamey"));
        TravelAdapter adapter=new TravelAdapter(list,this);
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}

