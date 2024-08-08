package biblio.master.api.features.genero.model.entity;

import biblio.master.api.features.genero.model.dto.GenerosDto;
import biblio.master.api.features.livros.model.entity.Livros;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity(name = "generos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Generos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    //@JsonIgnore //Evita recursividade ou utilizar:  @JsonManagedReference e @JsonBackReference
    @ManyToMany(mappedBy = "generos")
    @JsonBackReference
    private Set<Livros> livros;

    public Generos(GenerosDto dtoGeneros) {
        this.titulo = dtoGeneros.titulo();
    }
}
