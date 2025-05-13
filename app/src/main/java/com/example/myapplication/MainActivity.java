package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private ImageView imageView;
    private float currentRotation = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialiser SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        // Vérifier si l'utilisateur est connecté
        if (!sharedPreferences.getBoolean("isLoggedIn", false)) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
            return;
        }

        imageView = findViewById(R.id.imageView);
        Button spinButton = findViewById(R.id.button);
        Button btnTruth = findViewById(R.id.btn1);
        Button btnDare = findViewById(R.id.btn2);

        // Bouton "Tourner la bouteille"
        spinButton.setOnClickListener(v -> spin());

        // Bouton "Vérité"
        btnTruth.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Tu as choisi : Vérité", Toast.LENGTH_SHORT).show()
        );

        // Bouton "Action"
        btnDare.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Tu as choisi : Action", Toast.LENGTH_SHORT).show()
        );
    }

    // Fonction pour faire tourner la bouteille
    public void spin() {
        float angle = (float) (Math.random() * 3600 + 360); // Rotation aléatoire entre 360° et 3960°
        imageView.animate().rotation(currentRotation + angle).setDuration(2000);
        currentRotation += angle;
    }

    // Empêcher le retour direct à StartActivity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, StartActivity.class);
        startActivity(intent);
        finish();
    }
}
