package biblio.master.api.features.livros.model.dto;

import biblio.master.api.features.genero.model.entity.Generos;
import biblio.master.api.features.livros.model.entity.Livros;

import java.util.List;
import java.util.Set;

public record DadosListagemLivros(Long id, String Titulo, String Autor, String Editora, Set<Generos> generos) {

    public DadosListagemLivros(Livros livros){
        this(livros.getId(), livros.getTitulo(), livros.getAutor(), livros.getEditora(), livros.getGeneros());

    }


}
