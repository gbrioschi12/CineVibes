package com.example.cinevibes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cinevibes.R;
import com.example.cinevibes.model.Film;

import java.util.List;

public class FilmRecyclerAdapter extends RecyclerView.Adapter<FilmRecyclerAdapter.ViewHolder> {

    private int layout;
    private List<Film> filmList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewRating;
        private final TextView textViewTitle;

        public ViewHolder(View view) {
            super(view);


            textViewRating = view.findViewById(R.id.textViewRating);
            textViewTitle= view.findViewById(R.id.textViewTitle);
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }

        public TextView getTextViewRating() {
            return textViewRating;
        }
    }

    public FilmRecyclerAdapter(int layout, List<Film> filmList) {
        this.layout = layout;
        this.filmList = filmList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextViewTitle().setText(filmList.get(position).getTitle());
        viewHolder.getTextViewRating().setText((int) filmList.get(position).getVote_average());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return filmList.size();
    }
}
