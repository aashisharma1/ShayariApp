package com.example.shayariapp;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;

public class LoadingBar {
    private final Activity mainActivity;
    private AlertDialog alertDialog;

    LoadingBar(Activity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void loadDailoge() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(mainActivity);
        LayoutInflater layoutInflater = mainActivity.getLayoutInflater();
        builder1.setView(layoutInflater.inflate(R.layout.customloading, null));
        builder1.setCancelable(true);
        alertDialog = builder1.create();
        alertDialog.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(alertDialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        alertDialog.getWindow().setAttributes(layoutParams);

    }

    public void cancleDailoge() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                alertDialog.dismiss();
            }
        }, 2500);
    }
}
