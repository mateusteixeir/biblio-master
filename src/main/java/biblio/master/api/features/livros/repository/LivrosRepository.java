package biblio.master.api.features.livros.repository;


import biblio.master.api.features.livros.model.entity.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
}
