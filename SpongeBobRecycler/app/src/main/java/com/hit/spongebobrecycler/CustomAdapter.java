package com.hit.spongebobrecycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    private final ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel> dataSet) {

        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
       CardView cardView;
       TextView textViewName;
       TextView textViewDescription;
        ImageView imageViewIcon;

       public MyViewHolder (View itemView )
       {
           super(itemView);

           cardView = itemView.findViewById(R.id.card_view);
           textViewName = itemView.findViewById(R.id.textViewName);
           textViewDescription = itemView.findViewById(R.id.textViewDescription);
           imageViewIcon = itemView.findViewById(R.id.imageView);

       }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.cards_layout , parent ,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder,  int listPosition) {

        TextView textViewName = viewHolder.textViewName;
        TextView textViewDescription = viewHolder.textViewDescription;
        ImageView imageView = viewHolder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewDescription.setText(dataSet.get(listPosition).getDescription());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}


