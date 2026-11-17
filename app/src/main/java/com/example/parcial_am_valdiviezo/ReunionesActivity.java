
package com.example.parcial_am_valdiviezo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ReunionesActivity extends AppCompatActivity {

    private ArrayList<Reuniones> reuniones;
    private LinearLayout contenedorReuniones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reuniones);

        contenedorReuniones = findViewById(R.id.contenedorReuniones);

        // Creamos la lista
        reuniones = new ArrayList<>();

        // Cargamos reuniones por defecto
        reuniones.add(new Reuniones(
                "Reunión de Sistemas",
                "20/11/2026",
                "14:30",
                "Sistemas",
                "Revisión de proyectos"
        ));

        reuniones.add(new Reuniones(
                "Reunión de Capital Humano",
                "23/11/2026",
                "10:00",
                "Capital Humano",
                "Organización de entrevistas"
        ));

        reuniones.add(new Reuniones(
                "Reunión de Ventas",
                "25/11/2026",
                "11:30",
                "Ventas",
                "Seguimiento de objetivos comerciales"
        ));

        mostrarReuniones();

        // Botón volver
        Button buttonVolver = findViewById(R.id.buttonVolver);

        buttonVolver.setOnClickListener(v -> {
            finish();
        });

        // Botón crear reunión
        Button buttonCrearReunion =
                findViewById(R.id.buttonCrearReunion);

        buttonCrearReunion.setOnClickListener(v -> {
            Toast.makeText(
                    this,
                    "Próximamente: crear reunión",
                    Toast.LENGTH_SHORT
            ).show();
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

    private void mostrarReuniones() {

        for (Reuniones reunion : reuniones) {

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

            TextView titulo = new TextView(this);
            titulo.setText("Título: " + reunion.getTitulo());

            TextView fecha = new TextView(this);
            fecha.setText("Fecha: " + reunion.getFecha());

            TextView hora = new TextView(this);
            hora.setText("Hora: " + reunion.getHora());

            TextView area = new TextView(this);
            area.setText("Área: " + reunion.getArea());

            TextView descripcion = new TextView(this);
            descripcion.setText(
                    "Descripción: " + reunion.getDescripcion()
            );

            tarjeta.addView(titulo);
            tarjeta.addView(fecha);
            tarjeta.addView(hora);
            tarjeta.addView(area);
            tarjeta.addView(descripcion);

            // Botón eliminar reunión
            Button buttonEliminar = new Button(this);
            buttonEliminar.setText("Eliminar reunión");

            buttonEliminar.setOnClickListener(v -> {

                new AlertDialog.Builder(this)
                        .setTitle("Eliminar reunión")
                        .setMessage(
                                "¿Estás seguro de que querés eliminar "
                                        + reunion.getTitulo() + "?"
                        )
                        .setPositiveButton("Eliminar", (dialog, which) -> {

                            reuniones.remove(reunion);

                            contenedorReuniones.removeAllViews();
                            mostrarReuniones();

                            Toast.makeText(
                                    this,
                                    "Reunión eliminada correctamente",
                                    Toast.LENGTH_SHORT
                            ).show();
                        })
                        .setNegativeButton("Cancelar", (dialog, which) -> {
                            dialog.dismiss();
                        })
                        .show();
            });

            tarjeta.addView(buttonEliminar);

            contenedorReuniones.addView(tarjeta);
        }
    }
}
