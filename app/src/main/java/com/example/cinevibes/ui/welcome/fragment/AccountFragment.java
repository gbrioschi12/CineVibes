package com.example.cinevibes.ui.welcome.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

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
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {
    private TextInputEditText editTextEmail, editTextPassword, editTextNome, editTextCognome;

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance() {
        AccountFragment fragment = new AccountFragment();
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
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextEmail = view.findViewById(R.id.textInputEmailAccount);
        editTextPassword = view.findViewById(R.id.textInputPasswordAccount);
        editTextNome = view.findViewById(R.id.textInputNome);
        editTextCognome = view.findViewById(R.id.textInputCognome);

        Button confermaAccountButton = view.findViewById(R.id.creaAccountButtonAccountFragment);

        confermaAccountButton.setOnClickListener(v -> {
            //if(editTextNome.getText()!=null) {
               // if(editTextCognome.getText()!=null) {
                    if (editTextEmail.getText() != null && isEmailOk(editTextEmail.getText().toString())) {
                        if (editTextPassword.getText() != null && isPasswordOk(editTextPassword.getText().toString())) {
                            Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_home2Activity);
                        } else {
                            editTextPassword.setError("La password deve avere almeno 8 caratteri");
                        }
                    } else {
                        editTextEmail.setError("email non valida");
                    }
               // } else { editTextCognome.setError("Inserisci un cognome");}
            //} else {
            // editTextNome.setError("Inserisci un nome");
                //Snackbar.make(requireView(), "Inserisci correttamente Nome, Cognome ed Età", Snackbar.LENGTH_SHORT).show();
            //}
        });
    }
    private boolean isEmailOk (String email) {
        return EmailValidator.getInstance().isValid(email);
    }
    private boolean isPasswordOk (String password) {
        return password.length() > 7;
    }
}