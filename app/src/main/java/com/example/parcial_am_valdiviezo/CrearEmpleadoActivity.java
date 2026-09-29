package com.example.parcial_am_valdiviezo;

import android.os.Bundle;

import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearEmpleadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_empleado);

        EditText editLegajo = findViewById(R.id.editLegajo);
        EditText editApellido = findViewById(R.id.editApellido);
        EditText editArea = findViewById(R.id.editArea);
        EditText editPuesto = findViewById(R.id.editPuesto);

        Button buttonGuardar = findViewById(R.id.buttonGuardarEmpleado);

        buttonGuardar.setOnClickListener(v -> {

            String legajo = editLegajo.getText().toString();
            String apellido = editApellido.getText().toString();
            String area = editArea.getText().toString();
            String puesto = editPuesto.getText().toString();

            if (legajo.isEmpty() || apellido.isEmpty() || area.isEmpty() || puesto.isEmpty()) {
                Toast.makeText(
                        this,
                        "Completá todos los campos",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            Intent intent = new Intent();

            intent.putExtra("legajo", legajo);
            intent.putExtra("apellido", apellido);
            intent.putExtra("area", area);
            intent.putExtra("puesto", puesto);

            setResult(RESULT_OK, intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}