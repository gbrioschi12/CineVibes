
package com.example.cinevibes.ui.home.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cinevibes.R;
import com.example.cinevibes.adapter.FilmRecyclerAdapter;
import com.example.cinevibes.database.FilmRoomDatabase;
import com.example.cinevibes.model.Film;
import com.example.cinevibes.model.FilmApiResponse;
import com.example.cinevibes.util.Constants;
import com.example.cinevibes.util.JSONParserUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private FilmRecyclerAdapter adapter;
    private List<Film> filmList = new ArrayList<>();

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        adapter = new FilmRecyclerAdapter(R.layout.card_film, filmList, false);
        recyclerView.setAdapter(adapter);

        loadFavorites();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadFavorites();
    }


    private void loadFavorites() {
        FilmRoomDatabase database = FilmRoomDatabase.getDatabase(getContext());

        new Thread(() -> {
            List<Film> likedFilms = database.filmDao().getLiked();

            if (getActivity() == null) return;

            getActivity().runOnUiThread(() -> {
                filmList.clear();
                filmList.addAll(likedFilms);
                adapter.notifyDataSetChanged();

                Toast.makeText(getContext(), "Film Preferiti: " + likedFilms.size(), Toast.LENGTH_SHORT).show();
            });
        }).start();
    }



}
