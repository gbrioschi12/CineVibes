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
    private TextInputEditText editTextEmail, editTextPassword;

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

        editTextEmail = view.findViewById(R.id.textInputEmailAccountFragment);
        editTextPassword = view.findViewById(R.id.textInputPasswordAccountFragment);

        Button creaAccountButtonFragmentAccount = view.findViewById(R.id.creaAccountButtonAccountFragment);

        creaAccountButtonFragmentAccount.setOnClickListener(v -> {
            if(editTextEmail.getText() != null && isEmailOk(editTextEmail.getText().toString())) {
                if(editTextPassword.getText() != null && isPasswordOk(editTextPassword.getText().toString())) {
                    //  Intent intent = new Intent(this, HomeActivity.class );
                    // startActivity(intent);
                    Navigation.findNavController(v).navigate(R.id.action_accountFragment_to_mainActivity);                } else {
                    editTextPassword.setError("La password deve avere almeno 8 caratteri");
                    Snackbar.make(requireView(), "Controlla la tua password", Snackbar.LENGTH_SHORT).show();


                }
            } else {
                editTextEmail.setError("Controlla la tua email");
                Snackbar.make(requireView(), "Inserisci una mail corretta", Snackbar.LENGTH_SHORT).show();
            }

        });

    }
    private boolean isEmailOk (String email) {
        return EmailValidator.getInstance().isValid(email);
    }
    private boolean isPasswordOk (String password) {
        return password.length() > 8;
    }
}