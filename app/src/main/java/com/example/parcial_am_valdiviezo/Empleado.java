package com.example.parcial_am_valdiviezo;

public class Empleado {
    private String nombre;
    private String legajo;
    private String sede;
    private String puesto;

    public Empleado(String nombre, String legajo, String sede, String puesto){
        this.nombre = nombre;
        this.legajo = legajo;
        this.sede = sede;
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getSede() {
        return sede;
    }

    public String getPuesto() {
        return puesto;
    }
}
