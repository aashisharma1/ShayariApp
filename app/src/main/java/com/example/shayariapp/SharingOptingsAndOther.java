package com.example.shayariapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class SharingOptingsAndOther {
    private final Activity activity;
    private final String INSTAGRAM_URL = "http://instagram.com/Its_Aashi_pandit";

    public SharingOptingsAndOther(Activity activity) {
        this.activity = activity;
    }

    // Open Instagram profile using this method
    public void instgramMethod() {
        Uri uri = Uri.parse(INSTAGRAM_URL);
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.instagram.android");
        activity.startActivity(likeIng);


        try {
            activity.startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            activity.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/Its_Aashi_pandit")));
        }
    }


    // Share text to whatsapp using this method
    @SuppressLint("QueryPermissionsNeeded")
    public void whatsappShare(String text) {
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.putExtra("jid", "@s.whatsapp.net");
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setPackage("com.whatsapp");
        sendIntent.setType("text/plain");
        activity.startActivity(sendIntent);

    }

    // show pop-up or share to other apps using this method
    public void shareToApps(String text) {

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");

// (Optional) Here we're setting the title of the content
        sendIntent.putExtra(Intent.EXTRA_TITLE, "Shayari");
        // sendIntent.setType("text/plain");

// (Optional) Here we're passing a content URI to an image to be displayed
        //  sendIntent.setData(contentUri);
        sendIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

// Show the Sharesheet
        activity.startActivity(Intent.createChooser(sendIntent, null));
    }


    public void copyText(String text) {

        // Gets a handle to the clipboard service.
        ClipboardManager clipboard = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
        // Creates a new text clip to put on the clipboard
        ClipData clip = ClipData.newPlainText(" ", text);
        Toast.makeText(activity, "copied", Toast.LENGTH_SHORT).show();
        // Set the clipboard's primary clip.
        clipboard.setPrimaryClip(clip);
    }


}
