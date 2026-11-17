
package com.example.parcial_am_valdiviezo;

public class Reuniones {

    private String titulo;
    private String fecha;
    private String hora;
    private String area;
    private String descripcion;

    public Reuniones(String titulo, String fecha, String hora,
                   String area, String descripcion) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.area = area;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getArea() {
        return area;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
