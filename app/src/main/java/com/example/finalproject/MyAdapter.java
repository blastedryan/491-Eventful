package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String s1[], s2[], s3[], s4[];
    int icon;
    Context context;

    public MyAdapter(Context ct, String titles[], String dates[], String notes[], String priorities[], int image) {
        context = ct;
        s1 = titles;
        s2 = dates;
        s3 = notes;
        s4 = priorities;
        icon = image;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myTitle.setText(s1[position]);
        holder.myDate.setText(s2[position]);
        holder.myNote.setText(s3[position]);
        holder.myPriority.setText(s4[position]);
        holder.myIcon.setImageResource(icon);
    }

    @Override
    public int getItemCount() {
        return s1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myTitle, myDate, myNote, myPriority;
        ImageView myIcon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myTitle = itemView.findViewById(R.id.myTitle);
            myDate = itemView.findViewById(R.id.myDate);
            myNote = itemView.findViewById(R.id.myNote);
            myPriority = itemView.findViewById(R.id.myPriority);
            myIcon = itemView.findViewById(R.id.myIcon);
        }
    }
}
