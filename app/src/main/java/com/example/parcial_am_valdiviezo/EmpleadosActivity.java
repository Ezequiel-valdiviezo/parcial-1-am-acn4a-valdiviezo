package com.example.parcial_am_valdiviezo;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import java.util.ArrayList;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmpleadosActivity extends AppCompatActivity {

    private ArrayList<Empleado> empleados;
    private LinearLayout contenedorEmpleados;
    private ActivityResultLauncher<Intent> crearEmpleadoLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_empleados);
        contenedorEmpleados = findViewById(R.id.contenedorEmpleados);

        // Creamos la lista
        empleados = new ArrayList<>();

        // Cargamos empleados por defecto
        empleados.add(new Empleado(
                "1001",
                "Gómez",
                "Sistemas",
                "Desarrollador"
        ));

        empleados.add(new Empleado(
                "1002",
                "Fernández",
                "Capital Humano",
                "Analista"
        ));

        empleados.add(new Empleado(
                "1003",
                "Martínez",
                "Administración",
                "Administrativo"
        ));

        empleados.add(new Empleado(
                "1004",
                "Pérez",
                "Ventas",
                "Ejecutivo Comercial"
        ));

        mostrarEmpleados();

        Button buttonVolver = findViewById(R.id.buttonVolver);

        buttonVolver.setOnClickListener(v -> {
            finish();
        });

        crearEmpleadoLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {

                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                        Intent data = result.getData();

                        String legajo = data.getStringExtra("legajo");
                        String apellido = data.getStringExtra("apellido");
                        String area = data.getStringExtra("area");
                        String puesto = data.getStringExtra("puesto");

                        empleados.add(new Empleado(
                                legajo,
                                apellido,
                                area,
                                puesto
                        ));

                        contenedorEmpleados.removeAllViews();
                        mostrarEmpleados();
                    }
                }
        );

        Button buttonCrearEmpleado = findViewById(R.id.buttonCrearEmpleado);

        buttonCrearEmpleado.setOnClickListener(v -> {
            Intent intent = new Intent(
                    EmpleadosActivity.this,
                    CrearEmpleadoActivity.class
            );

            crearEmpleadoLauncher.launch(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void mostrarEmpleados() {

        for (Empleado empleado : empleados) {

            LinearLayout tarjeta = new LinearLayout(this);

            tarjeta.setOrientation(LinearLayout.VERTICAL);
            tarjeta.setPadding(30, 30, 30, 30);

            LinearLayout.LayoutParams parametros =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            parametros.setMargins(0, 0, 0, 20);

            tarjeta.setLayoutParams(parametros);
            tarjeta.setBackgroundColor(
                    getResources().getColor(R.color.white)
            );

            TextView apellido = new TextView(this);
            apellido.setText("Apellido: " + empleado.getApellido());

            TextView legajo = new TextView(this);
            legajo.setText("Legajo: " + empleado.getLegajo());

            TextView area = new TextView(this);
            area.setText("Área: " + empleado.getArea());

            TextView puesto = new TextView(this);
            puesto.setText("Puesto: " + empleado.getPuesto());

            tarjeta.addView(apellido);
            tarjeta.addView(legajo);
            tarjeta.addView(area);
            tarjeta.addView(puesto);

            // Botón para eliminar empleado
            Button buttonEliminar = new Button(this);
            buttonEliminar.setText("Eliminar empleado");

            // Evento del botón
            buttonEliminar.setOnClickListener(v -> {

                new androidx.appcompat.app.AlertDialog.Builder(this)
                        .setTitle("Eliminar empleado")
                        .setMessage("¿Estás seguro de que querés eliminar a "
                                + empleado.getApellido() + "?")
                        .setPositiveButton("Eliminar", (dialog, which) -> {

                            empleados.remove(empleado);

                            contenedorEmpleados.removeAllViews();
                            mostrarEmpleados();

                            android.widget.Toast.makeText(
                                    this,
                                    "Empleado eliminado correctamente",
                                    android.widget.Toast.LENGTH_SHORT
                            ).show();
                        })
                        .setNegativeButton("Cancelar", (dialog, which) -> {
                            dialog.dismiss();
                        })
                        .show();
            });

            tarjeta.addView(buttonEliminar);

            contenedorEmpleados.addView(tarjeta);
        }
    }


}