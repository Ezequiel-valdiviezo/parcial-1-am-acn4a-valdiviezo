package com.example.parcial_am_valdiviezo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EmpleadosActivity extends AppCompatActivity {

    private ArrayList<Empleado> empleados;
    private LinearLayout contenedorEmpleados;

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

            TextView nombre = new TextView(this);
            nombre.setText("Nombre: " + empleado.getNombre());

            TextView legajo = new TextView(this);
            legajo.setText("Legajo: " + empleado.getLegajo());

            TextView sede = new TextView(this);
            sede.setText("Área: " + empleado.getSede());

            TextView puesto = new TextView(this);
            puesto.setText("Puesto: " + empleado.getPuesto());

            tarjeta.addView(nombre);
            tarjeta.addView(legajo);
            tarjeta.addView(sede);
            tarjeta.addView(puesto);

            contenedorEmpleados.addView(tarjeta);
        }
    }
}