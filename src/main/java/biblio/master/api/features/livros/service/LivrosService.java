package biblio.master.api.features.livros.service;

import biblio.master.api.features.genero.model.entity.Generos;
import biblio.master.api.features.genero.repository.GenerosRepository;
import biblio.master.api.features.livros.model.entity.Livros;
import biblio.master.api.features.livros.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    @Autowired
    private GenerosRepository generosRepository;

    @Transactional
    public Livros cadastrarLivro(Livros livros){

        return livrosRepository.save(livros);


    }

    @Transactional
    public Livros atualizarLivros(Livros livros){

        return livrosRepository.save(livros);


    }
    /*
    //deleção de livro
    public Livros deletarLivro(Long idLivro) {

        Livros livro = livrosRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + idLivro));
        livrosRepository.delete(livro);
    }
    */
    //deleção lógica


    public Livros deletarLivro(Long idLivro) {

        Livros livro = livrosRepository.findById(idLivro).orElseThrow(() -> new RuntimeException("Livro não encontrado com id: " + idLivro));
        livro.setAtivo(false);
        return livrosRepository.save(livro);
    }
}
