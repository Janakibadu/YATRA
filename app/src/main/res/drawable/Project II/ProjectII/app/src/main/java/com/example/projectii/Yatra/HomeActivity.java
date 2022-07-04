package com.example.projectii.Yatra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.example.projectii.Adapter.PlacesAdapter;
import com.example.projectii.Model.PlacesModel;
import com.example.projectii.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_home);

       recyclerView=findViewById(R.id.recyclerview);

        ArrayList<PlacesModel> list = new ArrayList<>();
        list.add(new PlacesModel(R.drawable.adv, "Adventure Place"));
        list.add(new PlacesModel(R.drawable.nightlfe, "NightLife"));
        list.add(new PlacesModel(R.drawable.rupakot, "Rupakot " + "lake"));
        list.add(new PlacesModel(R.drawable.bungee, "Bungee"));
       // list.add(new PlacesModel(R.drawable.temp,"Gupteswar Gupha"));
        list.add(new PlacesModel(R.drawable.begnas,"Begnas Lake"));
        list.add(new PlacesModel(R.drawable.akeside,"Lakeside"));
        list.add(new PlacesModel(R.drawable.stupa,"Stupa"));
        list.add(new PlacesModel(R.drawable.bindabasani,"Bindabasini"));


        PlacesAdapter adapter=new PlacesAdapter(list,this);
        recyclerView.setAdapter(adapter);

        //PlacesAdapter Adaptor=new PlacesAdapter(list,this);
        //recyclerView.setAdapter(Adaptor);
       GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
      recyclerView.setLayoutManager(gridLayoutManager);
      //  LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //recyclerView.setLayoutManager(layoutManager);
    }
}