package ar.com.ada.api.sueldos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.sueldos.entities.Categoria;
import ar.com.ada.api.sueldos.entities.Empleado;
import ar.com.ada.api.sueldos.models.request.CategoriaRequest;
import ar.com.ada.api.sueldos.models.response.CategoriaReponse;
import ar.com.ada.api.sueldos.services.CategoriaService;

/**
 * CategoriaController
 */
@RestController
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/categorias")
    public ResponseEntity<?> postRegisterUser(@RequestBody CategoriaRequest req) {

        CategoriaReponse r = new CategoriaReponse();
        Categoria c = new Categoria();
        c.setNombre(req.nombre);
        c.setSueldoBase(req.sueldoBase);

        categoriaService.save(c);

        r.isOk = true;
        r.message = "Creaste una categoria con éxito.";
        return ResponseEntity.ok(r);

    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getCategorias() {
        List<Categoria> categorias = categoriaService.getCategorias();

        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/empleados/categorias/{catId}")
    public ResponseEntity<List<Empleado>> getEmpleadoByCatId(@PathVariable int catId) {
        Categoria c = categoriaService.buscarPorId(catId);

        return ResponseEntity.ok(c.empleados);

    }

}