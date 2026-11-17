package com.example.parcial_am_valdiviezo;

public class Empleado {
    private String legajo;
    private String apellido;
    private String area;
    private String puesto;

    public Empleado(String legajo, String apellido, String area, String puesto) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.area = area;
        this.puesto = puesto;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public String getArea() {
        return area;
    }

    public String getPuesto() {
        return puesto;
    }
}
