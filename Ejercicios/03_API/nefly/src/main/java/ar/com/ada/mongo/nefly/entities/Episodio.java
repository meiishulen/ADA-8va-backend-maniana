package ar.com.ada.mongo.nefly.entities;

/**
 * Episodio
 */
public class Episodio {

    private int nroEpisodio;
    private String titulo;
    private int duracion;

    public void reproducir() {
        System.out.println("Reproduciendo episodio " + this.nroEpisodio + " " + this.titulo);
    }

    public int getNroEpisodio() {
        return nroEpisodio;
    }

    public void setNroEpisodio(int nroEpisodio) {
        this.nroEpisodio = nroEpisodio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}