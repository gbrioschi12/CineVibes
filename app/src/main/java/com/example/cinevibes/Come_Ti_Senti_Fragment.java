package com.example.cinevibes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Come_Ti_Senti_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Come_Ti_Senti_Fragment extends Fragment {


    public Come_Ti_Senti_Fragment() {
        // Required empty public constructor
    }

    public static Come_Ti_Senti_Fragment newInstance(String param1, String param2) {
        Come_Ti_Senti_Fragment fragment = new Come_Ti_Senti_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_come_ti_senti_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}