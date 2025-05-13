package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private Button btnStart;
    private TextView tvWelcome, tvLogout;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Initialiser SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        // Initialiser les vues
        btnStart = findViewById(R.id.btn_start);
        tvWelcome = findViewById(R.id.tv_welcome);
        tvLogout = findViewById(R.id.tv_logout);

        // Afficher un message de bienvenue personnalisé
        String username = sharedPreferences.getString("username", "Utilisateur");
        tvWelcome.setText("Bienvenue, " + username + " !");

        // Configurer le bouton "Commencer"
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rediriger vers l'activité principale
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Configurer le lien de déconnexion
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Déconnecter l'utilisateur
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                // Rediriger vers l'activité de connexion
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Empêcher l'utilisateur de revenir à l'écran de connexion en appuyant sur le bouton Retour
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}