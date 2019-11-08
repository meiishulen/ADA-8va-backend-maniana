package ar.com.ada.mongo.nefly.services;

import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.mongo.nefly.entities.Serie;
import ar.com.ada.mongo.nefly.entities.Temporada;
import ar.com.ada.mongo.nefly.repo.SerieRepository;

/**
 * SerieService
 */
@Service
public class SerieService {

    @Autowired
    SerieRepository repo;

    public void grabar(Serie serie) {
        repo.save(serie);
    }

    public Serie buscarPorId(ObjectId id) {
        return repo.findBy_id(id);
    }

    public Serie buscarPorNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    public List<Serie> getCatalogo() {
        return repo.findAll();
    }

    public enum SerieValidationType {

        SERIE_OK,
        TEMPORADAS_NULA, 
        TEMPORADAS_VACIA, 
        TEMPORADA_DUPLICADA, 
        TEMPORADA_INVALIDA,

        SERIE_DATOS_INVALIDOS 
        
    }

    public SerieValidationType verificarSerie(Serie serie) {

        if (serie.getNombre() == null)
            return SerieValidationType.SERIE_OK;

        if (serie.getAño() <= 0)
            return SerieValidationType.SERIE_DATOS_INVALIDOS;

        if (serie.getTemporadas() == null)
            return SerieValidationType.TEMPORADAS_NULA;
        if (serie.getTemporadas().size() == 0)
            return SerieValidationType.TEMPORADAS_VACIA;

        //Armo un hashmap para ver si la temporada esta duplicada
        HashMap<Integer, Temporada> unicasTemps = new HashMap<>();

        for (Temporada t : serie.getTemporadas()) {
            if (unicasTemps.containsKey(new Integer(t.getNumeroTemporada())))
                return SerieValidationType.TEMPORADA_DUPLICADA;
            if (t.getEpisodios().size() == 0)
                return SerieValidationType.TEMPORADA_INVALIDA;
        
        unicasTemps.put(new Integer(t.getNumeroTemporada()), t);
        
            }

        return SerieValidationType.SERIE_OK;
    }

}