package biblio.master.api.features.livros.model.dto;

import java.util.Set;

public record DadosAtualizaLivros(Long id, String titulo, String autor, String editora, Set<Long> idGeneros) {
}
