package biblio.master.api.features.livros.controller;

import biblio.master.api.features.genero.model.entity.Generos;
import biblio.master.api.features.genero.repository.GenerosRepository;
import biblio.master.api.features.livros.model.dto.DadosAtualizaLivros;
import biblio.master.api.features.livros.model.dto.DadosCadastroLivros;
import biblio.master.api.features.livros.model.dto.DadosListagemLivros;
import biblio.master.api.features.livros.model.dto.LivrosDto;
import biblio.master.api.features.livros.model.entity.Livros;
import biblio.master.api.features.livros.repository.LivrosRepository;
import biblio.master.api.features.livros.service.LivrosService;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livros")
public class LivrosController {

    @Autowired
    private GenerosRepository generoRepository;

    @Autowired
    private LivrosRepository livrosRepository;

    @Autowired
    private LivrosService livrosService;

    @PostMapping
    public ResponseEntity<Livros> cadastrar(@RequestBody DadosCadastroLivros dadosCadastroLivros) {
        Livros livro = new Livros(dadosCadastroLivros);

        Set<Generos> generos = dadosCadastroLivros.idGeneros().stream()
                .map(id -> generoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genero não encontrado com id: " + id)))
                .collect(Collectors.toSet());

        livro.setGeneros(generos);
        Livros livroSalvo = livrosService.cadastrarLivro(livro);

        return ResponseEntity.ok(livroSalvo);


    }
    /*
    @GetMapping
    public List<DadosListagemLivros> listar() {
        return livrosRepository.findAll().stream().map(DadosListagemLivros::new).toList();
    }

     */
    //localhost:8080/livros?size=1&page=1
    @GetMapping
    public Page<DadosListagemLivros> listar(Pageable paginacao){
        return livrosRepository.findAll(paginacao).map(DadosListagemLivros::new);
    }

    @PutMapping("/{idLivro}")
    @Transactional
    public ResponseEntity<Livros> atualizar(@PathVariable Long idLivro, @RequestBody DadosAtualizaLivros atualizaLivros){


        Livros livro = livrosRepository.findById(idLivro).get();
        livro.setTitulo(atualizaLivros.titulo());
        livro.setAutor(atualizaLivros.autor());
        livro.setEditora(atualizaLivros.editora());

        Set<Generos> generos = atualizaLivros.idGeneros().stream()
                .map(id -> generoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Genero não encontrado com id: " + id)))
                .collect(Collectors.toSet());

        livro.setGeneros(generos);

        Livros livroAtualizado = livrosService.atualizarLivros(livro);

        return ResponseEntity.ok(livroAtualizado);
    }
    /*
    @DeleteMapping("{idLivro}")
    public ResponseEntity<void> deletar(@PathVariable Long idLivro){

        Livros livroExcluido = livrosService.deletarLivro(idLivro);

        return ResponseEntity.ok(livrooExcluido);

    }
     */


    @DeleteMapping("{idLivro}")
    public ResponseEntity<Livros> deletar(@PathVariable Long idLivro){

        Livros livroExcluido = livrosService.deletarLivro(idLivro);

        return ResponseEntity.ok(livroExcluido);

    }
}
