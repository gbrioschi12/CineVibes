package com.example.cinevibes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PiattaformeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PiattaformeFragment extends Fragment {


    public PiattaformeFragment() {
        // Required empty public constructor
    }


    public static PiattaformeFragment newInstance() {
        PiattaformeFragment fragment = new PiattaformeFragment();

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
        return inflater.inflate(R.layout.fragment_piattaforme, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button confermaPiattaformeButton = view.findViewById(R.id.confermaPiattaformeButton);
        confermaPiattaformeButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_piattaformeFragment3_to_filtroTipoFragment);

        });
    }
}