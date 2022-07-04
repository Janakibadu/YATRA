package com.example.projectii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectii.Adapter.PlacesAdapter;
import com.example.projectii.Model.PlacesModel;

import java.util.ArrayList;

public class CafeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);
        getSupportActionBar().hide();
        recyclerView=findViewById((R.id.recyclerview));
        ArrayList<PlacesModel> list = new ArrayList<>();
        list.add(new PlacesModel(R.drawable.himalayanjava, "Himlayan Java Cafe"));
        list.add(new PlacesModel(R.drawable.ampmcafe, "AM PM Cafe"));
        list.add(new PlacesModel(R.drawable.busybee, "Busybee Cafe"));
        list.add(new PlacesModel(R.drawable.byanjan, "Byanjan"));
        // list.add(new PlacesModel(R.drawable.text,"Gupteswar Gupha"));
        list.add(new PlacesModel(R.drawable.newaribhoj,"Newari Bhoj"));
        list.add(new PlacesModel(R.drawable.roadhousecafe,"Roadhouse Cafe"));
        list.add(new PlacesModel(R.drawable.moondance,"MoonDance"));
        list.add(new PlacesModel(R.drawable.freshelements,"FreshElements Cafe "));
        list.add(new PlacesModel(R.drawable.ampmcafe,"AM PM Cafe"));
        list.add(new PlacesModel(R.drawable.gusto,"Gusto Restaurant"));
        // list.add(new PlacesModel(R.drawable.cafecamellia, "Cafe Camellia"));
        PlacesAdapter adapter=new PlacesAdapter(list,this);
        recyclerView.setAdapter(adapter);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}
