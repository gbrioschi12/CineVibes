
package com.example.cinevibes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cinevibes.R;
import com.example.cinevibes.database.FilmRoomDatabase;
import com.example.cinevibes.model.Film;

import java.util.List;

public class FilmRecyclerAdapter extends RecyclerView.Adapter<FilmRecyclerAdapter.ViewHolder> {

    private final int layout;
    private final List<Film> filmList;
    private final boolean heartVisible;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewRating;
        private final TextView textViewTitle;
        private final CheckBox favoriteCheckBox;

        public ViewHolder(View view) {
            super(view);


            textViewRating = view.findViewById(R.id.textViewRating);
            textViewTitle= view.findViewById(R.id.textViewTitle);
            favoriteCheckBox= view.findViewById(R.id.favoriteButton);
        }

        public TextView getTextViewTitle() {

            return textViewTitle;
        }

        public TextView getTextViewRating() {

            return textViewRating;
        }

        public CheckBox getFavoriteCheckBox() {
            return favoriteCheckBox;
        }
    }

    public FilmRecyclerAdapter(int layout, List<Film> filmList, boolean heartVisible) {
        this.layout = layout;
        this.filmList = filmList;
        this.heartVisible = heartVisible;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        double voteAverage = filmList.get(position).getVote_average();
        String ratingText = String.format("%.1f", voteAverage);
        viewHolder.getTextViewTitle().setText(filmList.get(position).getTitle());
        viewHolder.getTextViewRating().setText(ratingText);
        viewHolder.getFavoriteCheckBox().setChecked(filmList.get(position).getLiked());

        viewHolder.getFavoriteCheckBox().setOnCheckedChangeListener((compoundButton, isChecked) -> {
            FilmRoomDatabase database = FilmRoomDatabase.getDatabase(viewHolder.itemView.getContext());

            new Thread(() -> {
                Film film = filmList.get(viewHolder.getAdapterPosition());
                film.setLiked(isChecked);

                database.filmDao().setFilmLiked(film.getId(), isChecked);

                ((android.app.Activity) viewHolder.itemView.getContext()).runOnUiThread(() -> {
                    String message = isChecked ? "Aggiunto ai preferiti" : "Rimosso dai preferiti";
                    Toast.makeText(viewHolder.itemView.getContext(), film.getTitle() + " " + message, Toast.LENGTH_SHORT).show();
                });

            }).start();
        });








    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return filmList.size();
    }
}
