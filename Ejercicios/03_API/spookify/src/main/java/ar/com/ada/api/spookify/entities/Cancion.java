package ar.com.ada.api.spookify.entities;

/**
 * Cancion
 */
public class Cancion {

    private String titulo;
    private double duracion;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the duracion
     */
    public double getDuracion() {
        return duracion;
    }
    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}