package com.example.projectii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectii.Adapter.PlacesAdapter;
import com.example.projectii.Model.PlacesModel;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        getSupportActionBar().hide();
        recyclerView=findViewById((R.id.recyclerview));

        ArrayList<PlacesModel> list = new ArrayList<>();
        list.add(new PlacesModel(R.drawable.waterfrontresort, "WaterFront Resort"));
        list.add(new PlacesModel(R.drawable.rupakorrestort, "Rupakot Resort"));
        list.add(new PlacesModel(R.drawable.hoteldayatrah, "Hotel Dayatrah"));
        list.add(new PlacesModel(R.drawable.malah, "Hotel Mala"));
        // list.add(new PlacesModel(R.drawable.text,"Gupteswar Gupha"));
        list.add(new PlacesModel(R.drawable.sunshineresort,"Sunshine Resort"));
        list.add(new PlacesModel(R.drawable.cultureh,"Culture Resort"));
        list.add(new PlacesModel(R.drawable.kantipurh,"Hotel Kantipur"));
        list.add(new PlacesModel(R.drawable.lakeviewresort,"LakeView Resort"));
        list.add(new PlacesModel(R.drawable.landmarkh,"Landmark Hotel"));
        list.add(new PlacesModel(R.drawable.kutiresort,"KutiResort"));
        list.add(new PlacesModel(R.drawable.barpeepalr, "BarPeepal Resort"));
        list.add(new PlacesModel(R.drawable.hotelbarahi, "Hotel Barahi"));


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