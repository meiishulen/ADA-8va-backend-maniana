package ar.com.ada.mongo.nefly.entities;

/**
 * Episodio
 */
public class Episodio {

    public int nroEpisodio;
    public String titulo;
    public int duracion;

    public void reproducir()
    {
        System.out.println("Reproduciendo episodio " + this.nroEpisodio + " " + this.titulo);
    }
}