package com.example.shayariapp.BottomSheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shayariapp.Fragments.Settings;
import com.example.shayariapp.R;
import com.example.shayariapp.SharingOptingsAndOther;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheet extends BottomSheetDialogFragment {
    String text;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BottomSheet(String text) {
        this.text = text;
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
        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        TextView textView = view.findViewById(R.id.bottomTextId);
        textView.setText(text);

        //  AppCompatDelegate
        ManageOpyions(text, view);
        return view;
    }


    private void ManageOpyions(String text, View view) {
        SharingOptingsAndOther sharingOptingsAndOther = new SharingOptingsAndOther(getActivity());
        com.google.android.material.button.MaterialButton copy, share, whatsapp;
        copy = view.findViewById(R.id.copyCard);
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharingOptingsAndOther.copyText(text);
            }
        });
        share = view.findViewById(R.id.sharecard);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharingOptingsAndOther.shareToApps(text);
            }
        });
        whatsapp = view.findViewById(R.id.whatsappcard);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharingOptingsAndOther.whatsappShare(text);
            }
        });
    }

}