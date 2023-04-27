package com.example.shayariapp.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayariapp.BottomSheet.BottomSheet;
import com.example.shayariapp.MainActivity;
import com.example.shayariapp.ModelClass.SadModelClass;
import com.example.shayariapp.R;

import java.util.ArrayList;

public class SadRecycleAdapter extends RecyclerView.Adapter<SadRecycleAdapter.ViewHolder> {

    Activity activity;
    ArrayList<SadModelClass> arrayList;

    public SadRecycleAdapter(Activity activity, ArrayList<SadModelClass> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public SadRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.demoshayari, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position).textView);
        holder.imageView.setImageResource(arrayList.get(position).imageView);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity activity1 = (MainActivity) activity;
                BottomSheet bottomSheet = new BottomSheet((String) holder.textView.getText());
                bottomSheet.show(activity1.getSupportFragmentManager(), bottomSheet.getTag());
            }
        });

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        androidx.appcompat.widget.AppCompatImageView imageView;
        com.google.android.material.textview.MaterialTextView textView;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.lvImgView);
            textView = itemView.findViewById(R.id.lvTextView);
            layout = itemView.findViewById(R.id.demolayout);
        }
    }
}
