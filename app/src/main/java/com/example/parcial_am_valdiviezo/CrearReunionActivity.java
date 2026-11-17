package com.example.parcial_am_valdiviezo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CrearReunionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_reunion);

        EditText editTitulo = findViewById(R.id.editTitulo);
        EditText editFecha = findViewById(R.id.editFecha);
        EditText editHora = findViewById(R.id.editHora);
        EditText editArea = findViewById(R.id.editArea);
        EditText editDescripcion = findViewById(R.id.editDescripcion);

        Button buttonGuardar = findViewById(R.id.buttonGuardarReunion);
        Button buttonCancelar = findViewById(R.id.buttonCancelarReunion);

        buttonGuardar.setOnClickListener(v -> {

            String titulo = editTitulo.getText().toString().trim();
            String fecha = editFecha.getText().toString().trim();
            String hora = editHora.getText().toString().trim();
            String area = editArea.getText().toString().trim();
            String descripcion = editDescripcion.getText().toString().trim();

            // Validamos los campos obligatorios
            if (titulo.isEmpty() || fecha.isEmpty() ||
                    hora.isEmpty() || area.isEmpty() ||
                    descripcion.isEmpty()) {

                Toast.makeText(
                        this,
                        "Completá todos los campos",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Enviamos los datos a ReunionesActivity
            Intent intent = new Intent();

            intent.putExtra("titulo", titulo);
            intent.putExtra("fecha", fecha);
            intent.putExtra("hora", hora);
            intent.putExtra("area", area);
            intent.putExtra("descripcion", descripcion);

            setResult(RESULT_OK, intent);
            finish();
        });

        // Botón cancelar
        buttonCancelar.setOnClickListener(v -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );
    }
}
