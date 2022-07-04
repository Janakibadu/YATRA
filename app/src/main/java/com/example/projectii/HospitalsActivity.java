package com.example.projectii;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectii.Adapter.PlacesAdapter;
import com.example.projectii.Model.PlacesModel;

import java.util.ArrayList;

public class HospitalsActivity extends AppCompatActivity {
  RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        getSupportActionBar().hide();
        recyclerView=findViewById((R.id.recyclerview));

    ArrayList<PlacesModel> list = new ArrayList<>();
        list.add(new PlacesModel(R.drawable.ciewic, "Ciewic Hospital"));
                list.add(new PlacesModel(R.drawable.manipal, "Manipal Hospital"));
                list.add(new PlacesModel(R.drawable.metrocity, "Metrocity Hospital"));
                list.add(new PlacesModel(R.drawable.fishtail, "Fishtail Hospital"));
                // list.add(new PlacesModel(R.drawable.text,"Gupteswar Gupha"));
                list.add(new PlacesModel(R.drawable.charak,"Charak Hospital"));
                list.add(new PlacesModel(R.drawable.westernregional,"Regional Hospital"));

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