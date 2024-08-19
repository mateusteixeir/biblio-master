package biblio.master.api.features.genero.controller;

import biblio.master.api.features.genero.model.dto.DadosAtualizaGeneros;
import biblio.master.api.features.genero.model.dto.DadosCadastroGeneros;
import biblio.master.api.features.genero.model.dto.DadosListagemGeneros;
import biblio.master.api.features.genero.model.dto.GenerosDto;
import biblio.master.api.features.genero.model.entity.Generos;
import biblio.master.api.features.genero.repository.GenerosRepository;
import biblio.master.api.features.genero.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GenerosController {

    @Autowired
    private GenerosRepository generosRepository;

    @Autowired
    private GeneroService generoService;

    @PostMapping
    public ResponseEntity<Generos> cadastrar(@RequestBody DadosCadastroGeneros dadosCadastroGeneros) {

        Generos genero = new Generos(dadosCadastroGeneros);

        Generos generoSalvo = generoService.cadastrar(genero);

        return ResponseEntity.ok(generoSalvo);

    }

    @PutMapping("/{idGenero}")
    @Transactional
    public ResponseEntity<Generos> atualizar(@RequestBody DadosAtualizaGeneros dadosAtualizaGeneros, @PathVariable Long idGenero){

        Generos genero = generosRepository.findById(idGenero).orElseThrow(() -> new RuntimeException("Genero não encontrado com id: " + idGenero));

        genero.setTitulo(dadosAtualizaGeneros.titulo());

        Generos generoAtualizado = generoService.atualizar(genero);

        return ResponseEntity.ok(generoAtualizado);


    }

    /*
    @GetMapping
    public List<Generos> listar(){

        return generosRepository.findAll();
    }

     */

    @GetMapping
    public Page<DadosListagemGeneros> listar(Pageable paginacao) {

        return generosRepository.findAll(paginacao).map(DadosListagemGeneros::new);

    }


    @DeleteMapping("/{idGenero}")
    public ResponseEntity<Generos> deletar(@PathVariable Long idGenero){


        Generos generoDeletado = generoService.deletarGeneros(idGenero);

        return ResponseEntity.ok(generoDeletado);

    }



}
