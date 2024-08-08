package biblio.master.api.features.genero.repository;

import biblio.master.api.features.genero.model.entity.Generos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenerosRepository extends JpaRepository<Generos, Long> {
}
