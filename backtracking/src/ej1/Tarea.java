package ej1;

public class Tarea {
    private String name;
    private String descripcion;
    private int duration;

    public Tarea(String name, String descripcion, int duration) {
        this.name = name;
        this.descripcion = descripcion;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
