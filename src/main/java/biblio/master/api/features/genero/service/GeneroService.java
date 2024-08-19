package biblio.master.api.features.genero.service;

import biblio.master.api.features.genero.model.entity.Generos;
import biblio.master.api.features.genero.repository.GenerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneroService {

    @Autowired
    private GenerosRepository generosRepository;

    @Transactional
    public Generos cadastrar(Generos generos){

       return  generosRepository.save(generos);

    }

    @Transactional
    public Generos atualizar(Generos genero) {

        return generosRepository.save(genero);
    }


    public Generos deletarGeneros(Long idGenero){

        Generos genero = generosRepository.findById(idGenero).orElseThrow(() -> new RuntimeException("Genero não encontrado com id: " + idGenero));
        generosRepository.delete(genero);
        return genero;
    }
}
