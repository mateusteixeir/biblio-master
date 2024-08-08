package biblio.master.api.features.livros.model.entity;

import biblio.master.api.features.genero.model.entity.Generos;
import biblio.master.api.features.livros.model.dto.DadosCadastroLivros;
import biblio.master.api.features.livros.model.dto.LivrosDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity(name = "livros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livros {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titulo;
        private String autor;
        private String editora;

        @ManyToMany
        @JoinTable(
                name = "genero_livros",
                joinColumns = @JoinColumn(name = "id_livro"),
                inverseJoinColumns = @JoinColumn(name = "id_genero")
        )

        @JsonManagedReference
        private Set<Generos> generos;
        public Livros(DadosCadastroLivros dtoLivros) {
                this.titulo = dtoLivros.titulo();
                this.autor = dtoLivros.autor();
                this.editora = dtoLivros.editora();
        }



}
