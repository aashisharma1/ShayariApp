package com.example.shayariapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayariapp.Adapters.AttitudeAdapter;
import com.example.shayariapp.ModelClass.AttitudemodalClass;
import com.example.shayariapp.R;

import java.util.ArrayList;


public class AttitudeFragments extends Fragment {


    public AttitudeFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<AttitudemodalClass> arrayList = new ArrayList<AttitudemodalClass>();

        for (int i = 0; i <= 25; i++) {
            arrayList.add(new AttitudemodalClass(R.drawable.attitudee, getString(R.string.LoveDemo)));
        }


        View view = inflater.inflate(R.layout.fragment_love, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.LoveRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        AttitudeAdapter adapter = new AttitudeAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);

        return view;

    }
}