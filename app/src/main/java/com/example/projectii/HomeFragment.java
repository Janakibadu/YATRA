package com.example.projectii;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectii.Adapter.PlacesAdapter;
import com.example.projectii.Adapter.TravelAdapter;
import com.example.projectii.Model.PlacesModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    private ImageView imvtravel;
    private ImageView imvhospital;
    private ImageView imvhotels;
    private ImageView imvcafe;
    private ImageView imvadv;
    private SearchView searchView;
    private List<PlacesModel> itemlist;
    View view;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        searchView=view.findViewById(R.id.searchview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String Query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
        recyclerView=view.findViewById(R.id.recyclerview);
        imvtravel=view.findViewById(R.id.travel);
        imvhospital=view.findViewById((R.id.hospital));
        imvhotels=view.findViewById(R.id.hotels);
        imvtravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(), TravelActivity.class));
            }
        });


        imvhospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(), HospitalsActivity.class));
            }
        });
        imvhotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(),HotelActivity.class));
            }
        });
        imvadv=view.findViewById(R.id.adventure);
        imvadv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(),AdventureActivity.class));
            }
        });
        imvcafe=view.findViewById(R.id.cafe);
        imvcafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(),CafeActivity.class));
            }
        });
        itemlist=new ArrayList<>();
        ArrayList<PlacesModel> list=new ArrayList<>();
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
        TravelAdapter adapter=new TravelAdapter(list,getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
    private void filter(String text) {
        List<PlacesModel> filteredList = new ArrayList<>();
        for (PlacesModel list : itemlist){
            if (list.getText().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(list);
            }

        }
        // PlacesAdapter.filterList(filteredList);

        if(filteredList.isEmpty()){
            Toast.makeText(getActivity().getApplicationContext(), "No data found", Toast.LENGTH_SHORT).show();
        }
        else{
            PlacesAdapter.filterList(filteredList);
        }
    }




    }



