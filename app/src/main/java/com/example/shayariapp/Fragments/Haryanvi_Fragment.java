package com.example.shayariapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayariapp.Adapters.HaryanviAdapter;
import com.example.shayariapp.ModelClass.HaryanviModelClass;
import com.example.shayariapp.ModelClass.LoveModelClass;
import com.example.shayariapp.R;
import com.example.shayariapp.ResourcePool;

import java.util.ArrayList;

public class Haryanvi_Fragment extends Fragment {


    public Haryanvi_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<HaryanviModelClass> arrayList = new ArrayList<HaryanviModelClass>();

        ResourcePool resourcePool=new ResourcePool();
        ArrayList<String> haryanviresources=  resourcePool.haryanviResources();


        for (int i = 0; i < haryanviresources.size(); i++) {
            arrayList.add(new HaryanviModelClass(R.drawable.haryanvi, haryanviresources.get(i) ));
        }
        View view = inflater.inflate(R.layout.fragment_haryanvi_, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.Haryanvi_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        HaryanviAdapter adapter = new HaryanviAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}