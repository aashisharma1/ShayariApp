package com.example.shayariapp.Fragments;

import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.shayariapp.Adapters.RecycleLoveAdapter;
import com.example.shayariapp.ModelClass.LoveModelClass;
import com.example.shayariapp.R;
import com.example.shayariapp.ResourcePool;

import java.util.ArrayList;

public class Love extends Fragment {

    public Love() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<LoveModelClass> arrayList = new ArrayList<LoveModelClass>();

        ResourcePool resourcePool=new ResourcePool();
      ArrayList<String> loveresoure=  resourcePool.loveResources();


        for (int i = 0; i < loveresoure.size(); i++) {
            arrayList.add(new LoveModelClass(R.drawable.love, loveresoure.get(i) ));
        }
        View view = inflater.inflate(R.layout.fragment_love, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.LoveRecycle);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, LinearLayoutManager.HORIZONTAL));
       // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecycleLoveAdapter adapter = new RecycleLoveAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}