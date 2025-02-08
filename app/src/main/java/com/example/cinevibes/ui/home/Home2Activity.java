package com.example.cinevibes.ui.home;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cinevibes.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().
                findFragmentById(R.id.fragmentContainerView);

        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.startFragment, R.id.searchFragment, R.id.listFragment, R.id.settingsFragment
        ).build();


        NavigationUI.setupWithNavController(bottomNav, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }
}