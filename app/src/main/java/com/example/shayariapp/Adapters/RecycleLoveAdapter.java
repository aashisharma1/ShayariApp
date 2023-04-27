package com.example.shayariapp.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shayariapp.BottomSheet.BottomSheet;
import com.example.shayariapp.MainActivity;
import com.example.shayariapp.ModelClass.LoveModelClass;
import com.example.shayariapp.R;

import java.util.ArrayList;

public class RecycleLoveAdapter extends RecyclerView.Adapter<RecycleLoveAdapter.ViewHolder> {
    Activity activity;
    ArrayList<LoveModelClass> arrayList;

    public RecycleLoveAdapter(Activity activity, ArrayList<LoveModelClass> arrayList) {
        this.arrayList = arrayList;
        this.activity = activity;

    }

    @NonNull
    @Override
    public RecycleLoveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.demoshayari, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleLoveAdapter.ViewHolder holder, int position) {

        holder.textView.setText(arrayList.get(position).textView);
        //holder.textView.setText(HtmlCompat.fromHtml("ok",HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_PARAGRAPH));
        holder.imageView.setImageResource(arrayList.get(position).imageView);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Ok", Toast.LENGTH_SHORT).show();
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
