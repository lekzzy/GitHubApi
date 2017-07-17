package com.example.aderelemaryidowu.recyclerviewyupdev;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ADERELE MARY IDOWU on 7/13/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    public ArrayList<DataProvider> arrayList = new ArrayList<DataProvider>();
    public Context context;
    public RecyclerViewAdapter(ArrayList<DataProvider> mArrayList, Context mContext)
    {
        arrayList = mArrayList;
        context = mContext;

    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view, context, arrayList);
        return recyclerViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        DataProvider dataProvider = arrayList.get(position);
        holder.filmImageView.setImageResource(dataProvider.getFilmImage());
        holder.filmNameTextView.setText("Film Title: " + dataProvider.getFilmName());
        holder.directorNameTextView.setText("Director Name: " + dataProvider.getDirectorName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public  ArrayList<DataProvider> arrayList = new ArrayList<DataProvider>();
        Context context;

        ImageView filmImageView;
        TextView filmNameTextView;
        TextView directorNameTextView;
        public RecyclerViewHolder(View itemView, Context mContext, ArrayList<DataProvider> mArrayList) {
            super(itemView);
            filmImageView = (ImageView)itemView.findViewById(R.id.film_image);
            filmNameTextView = (TextView)itemView.findViewById(R.id.film_name);
            directorNameTextView = (TextView)itemView.findViewById(R.id.director_name);


            arrayList = mArrayList;
            context = mContext;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            DataProvider dataProvider = arrayList.get(position);
            Intent intent = new Intent(this.context, FilmDetails.class);
            intent.putExtra("image", dataProvider.getFilmImage());
            intent.putExtra("FilmName", dataProvider.getFilmName());
            intent.putExtra("DirectorName", dataProvider.getDirectorName());
            context.startActivity(intent);

        }

    }
    public void searchFilter(ArrayList<DataProvider> mArrayList)
    {
        arrayList = new ArrayList<>();
        arrayList.addAll(mArrayList);
        notifyDataSetChanged();
    }
}
