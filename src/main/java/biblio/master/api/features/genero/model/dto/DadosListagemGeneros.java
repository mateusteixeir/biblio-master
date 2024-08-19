package biblio.master.api.features.genero.model.dto;

import biblio.master.api.features.genero.model.entity.Generos;

public record DadosListagemGeneros(Long id, String titulo) {

    public DadosListagemGeneros(Generos generos) {
        this(generos.getId(), generos.getTitulo());
    }

}
