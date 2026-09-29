package com.example.parcial_am_valdiviezo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class InicioActivity extends AppCompatActivity {

    public void irEmpleados(View v){
        Intent intent = new Intent(getApplicationContext(), EmpleadosActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        setContentView(R.layout.activity_inicio);
        Button buttonVerMas = findViewById(R.id.button3);
        LinearLayout layoutProximamente = findViewById(R.id.layoutProximamente);

        buttonVerMas.setOnClickListener(v -> {
            layoutProximamente.setVisibility(View.VISIBLE);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}