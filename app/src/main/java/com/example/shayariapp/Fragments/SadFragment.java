package com.example.shayariapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayariapp.Adapters.SadRecycleAdapter;
import com.example.shayariapp.ModelClass.LoveModelClass;
import com.example.shayariapp.ModelClass.SadModelClass;
import com.example.shayariapp.R;
import com.example.shayariapp.ResourcePool;

import java.util.ArrayList;


public class SadFragment extends Fragment {


    public SadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ArrayList<SadModelClass> arrayList = new ArrayList<SadModelClass>();
        ResourcePool resourcePool=new ResourcePool();
        ArrayList<String> sadResources=  resourcePool.sadResources();

        for (int i = 0; i < sadResources.size(); i++) {
            arrayList.add(new SadModelClass(R.drawable.sadd, sadResources.get(i) ));
        }

        View view = inflater.inflate(R.layout.fragment_sad, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.SadRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        SadRecycleAdapter adp = new SadRecycleAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adp);

        return view;


        // Inflate the layout for this fragment

    }
}