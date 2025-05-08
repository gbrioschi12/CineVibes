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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.concurrent.Executor;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    private static final String TAG = LoginFragment.class.getSimpleName();
    private TextInputEditText editTextEmail, editTextPassword;
    //private SignInClient oneTapClient;
    //private BeginSignInRequest signInRequest;

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

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

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



            /*
            mAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());

                                // updateUI(null);
                            }
                        }
                    });


            oneTapClient = Identity.getSignInClient(requireActivity());
            signInRequest = BeginSignInRequest.builder()
                    .setPasswordRequestOptions(BeginSignInRequest.PasswordRequestOptions.builder()
                            .setSupported(true)
                            .build())
                    .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                            .setSupported(true)
                            // Your server's client ID, not your Android client ID.
                            .setServerClientId(getString(R.string.default_web_client_id))
                            // Only show accounts previously used to sign in.
                            .setFilterByAuthorizedAccounts(false)
                            .build())
                    // Automatically sign in when exactly one credential is retrieved.
                    .setAutoSelectEnabled(true)
                    .build();
        */
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
