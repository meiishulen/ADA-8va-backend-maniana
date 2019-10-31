package ar.com.ada.mongo.nefly.entities;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Peli
 */
@Document(collection = "Peliculas")
public class Peli  extends Contenido{
    public boolean ganoOscar;
    
    
}