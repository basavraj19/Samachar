package com.example.samachar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<HelperClass> arrayList;

    public Adapter(Context context, ArrayList<HelperClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.news_layout,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder,int position) {
         holder.cardView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(context,Websitenews.class);
                 intent.putExtra("url",arrayList.get(holder.getAdapterPosition()).getUrl());
                 context.startActivity(intent);
             }
         });
         holder.author.setText(arrayList.get(holder.getAdapterPosition()).getAuthor());
         holder.headings.setText(arrayList.get(holder.getAdapterPosition()).getTitle());
         holder.content.setText(arrayList.get(holder.getAdapterPosition()).getDescription());
         Glide.with(context).load(arrayList.get(holder.getAdapterPosition()).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView headings,content,author;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            headings=itemView.findViewById(R.id.heading);
            content=itemView.findViewById(R.id.content);
            author=itemView.findViewById(R.id.author);
            cardView=itemView.findViewById(R.id.news_layout_cardView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
