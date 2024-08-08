package biblio.master.api.features.genero.controller;

import biblio.master.api.features.genero.model.dto.GenerosDto;
import biblio.master.api.features.genero.model.entity.Generos;
import biblio.master.api.features.genero.repository.GenerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GenerosController {

    @Autowired
    private GenerosRepository generosRepository;

    @PostMapping
    public void cadastrar(@RequestBody GenerosDto dtoGeneros){

        Generos genero = new Generos(dtoGeneros);
        generosRepository.save(genero);

    }

    @GetMapping
    public List<Generos> listar(){

        return generosRepository.findAll();
    }
}
