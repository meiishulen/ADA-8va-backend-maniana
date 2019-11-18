package ar.com.ada.api.sueldos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.sueldos.entities.Categoria;
import ar.com.ada.api.sueldos.repo.CategoriaRepository;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public List<Categoria> getCategorias() {

        return repo.findAll();
    }

    public Categoria buscarPorNombre(String nombre) {

        return repo.findByNombre(nombre);
    }

    public Categoria buscarPorId(int id) {

        return repo.findById(id);
    }


    public void save(Categoria c) {
        repo.save(c);
    }


    
}