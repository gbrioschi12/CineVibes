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
 * Use the {@link FiltroTipoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FiltroTipoFragment extends Fragment {

    public FiltroTipoFragment() {
        // Required empty public constructor
    }

    public static FiltroTipoFragment newInstance() {
        FiltroTipoFragment fragment = new FiltroTipoFragment();
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
        return inflater.inflate(R.layout.fragment_filtro_tipo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button confermaTipoButton = view.findViewById(R.id.confermaTipoButton);
        confermaTipoButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_filtroTipoFragment_to_comeTiSentiFragment);

        });
    }
}