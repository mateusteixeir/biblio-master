package biblio.master.api.features.livros.model.dto;

import biblio.master.api.features.genero.DadosGenero;
import biblio.master.api.features.genero.model.entity.Generos;

import java.util.List;

public record LivrosDto(String titulo, String autor, String editora, List<Generos> generos) {

}
