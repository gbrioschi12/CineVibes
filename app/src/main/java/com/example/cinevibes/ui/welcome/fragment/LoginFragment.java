package com.example.cinevibes.ui.welcome.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cinevibes.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import org.apache.commons.validator.routines.EmailValidator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    private TextInputEditText editTextEmail, editTextPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        Log.d("DEBUG", "Sono qui");
        return inflater.inflate(R.layout.fragment_login, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextEmail = view.findViewById(R.id.textInputEmail);
        editTextPassword = view.findViewById(R.id.textInputPassword);

        Button accediButton = view.findViewById(R.id.accediButton);
        Button creaAccountButton = view.findViewById(R.id.creaAccountButton);

        accediButton.setOnClickListener(v -> {
            if(editTextEmail.getText() != null && isEmailOk(editTextEmail.getText().toString())) {
                if(editTextPassword.getText() != null && isPasswordOk(editTextPassword.getText().toString())) {
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_home2Activity);
                } else {
                    editTextPassword.setError("La password deve avere almeno 8 caratteri");
                    //Snackbar.make(requireView(), "Controlla la tua password", Snackbar.LENGTH_SHORT).show();
                }
            } else {
                editTextEmail.setError("email non valida");
                //Snackbar.make(requireView(), "Inserisci una mail corretta", Snackbar.LENGTH_SHORT).show();
            }
        });

        creaAccountButton.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_accountFragment);
        });
    }

    private boolean isEmailOk (String email) {
        return EmailValidator.getInstance().isValid(email);
    }
    private boolean isPasswordOk (String password) {
        return password.length() > 7;
    }
}
