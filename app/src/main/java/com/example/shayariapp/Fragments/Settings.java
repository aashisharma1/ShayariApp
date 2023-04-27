package com.example.shayariapp.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.shayariapp.R;
import com.example.shayariapp.SharingOptingsAndOther;

import java.util.Objects;

//StaggeredGridLayoutManager
public class Settings extends Fragment {

    private com.google.android.material.card.MaterialCardView aboutUs, exitcard,contactus,rateus,bookmark;

    com.google.android.material.button.MaterialButton insta;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Settings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Settings.
     */
    // TODO: Rename and change types and number of parameters
    public static Settings newInstance(String param1, String param2) {
        Settings fragment = new Settings();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        contactus=view.findViewById(R.id.contactus);
        rateus=view.findViewById(R.id.rateus);
        bookmark=view.findViewById(R.id.bookmarkTab);
        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Please purchase Premium Version", Toast.LENGTH_SHORT).show();
            }
        });
        rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "On the way", Toast.LENGTH_SHORT).show();
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDialoge(view);
            }
        });


        clickMethods(view);

        com.google.android.material.switchmaterial.SwitchMaterial switchMaterial;
        switchMaterial = view.findViewById(R.id.DarkmodeSwitch);
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("MODE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(sharedPreferences.getInt("MODE",1)==2)
        {
            switchMaterial.setChecked(true);
        }
        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {



                int modeNightYes;
                if (switchMaterial.isChecked()) {
                    modeNightYes = AppCompatDelegate.MODE_NIGHT_YES;
                    switchMaterial.setChecked(true);
                } else {
                    modeNightYes = AppCompatDelegate.MODE_NIGHT_NO;
                    switchMaterial.setChecked(false);
                }
                AppCompatDelegate.setDefaultNightMode(modeNightYes);
                editor.putInt("MODE", modeNightYes);
                editor.apply();


            }
        });

        return view;
    }

    private void clickMethods(View view) {


        exitcard = view.findViewById(R.id.Exit);
        exitcard.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
                builder.setTitle(getResources().getString(R.string.asking));
                builder.setIcon(getResources().getDrawable(R.drawable.exit));
                builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        requireActivity().finishAffinity();
                        getActivity().finish();
                       // Toast.makeText(getActivity(), "Ho jayega", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton(getResources().getString(R.string.No), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // Toast.makeText(getActivity(), "working thius one to", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });


        aboutUs = view.findViewById(R.id.about_Us);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callDialoge(view);

            }
        });

    }

    private void callDialoge(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        ViewGroup viewGroup = view.findViewById(android.R.id.content);
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.about_me_layout_file, viewGroup, false);
        insta = view1.findViewById(R.id.instaProfile);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SharingOptingsAndOther(getActivity()).instgramMethod();
            }
        });

        builder.setView(view1);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}