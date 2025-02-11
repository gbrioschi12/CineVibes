package com.example.cinevibes.ui.home.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cinevibes.EsploraFragment;
import com.example.cinevibes.R;
import com.example.cinevibes.model.Film;
import com.example.cinevibes.model.FilmApiResponse;
import com.example.cinevibes.util.Constants;
import com.example.cinevibes.util.JSONParserUtils;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {


    public static final String TAG = EsploraFragment.class.getName();


    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        //return inflater.inflate(R.layout.fragment_search, container, false);
        JSONParserUtils jsonParserUtils = new JSONParserUtils(getContext());

        try {
            FilmApiResponse response = jsonParserUtils.parseJSONFileWithGSon(Constants.SAMPLE_JSON_FILENAME);
            List<Film> filmList = response.getResults();

            int a = 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return view;
    }


}