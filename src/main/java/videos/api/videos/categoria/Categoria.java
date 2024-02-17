package videos.api.videos.categoria;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "categorias")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String categoria;

    @Enumerated(EnumType.STRING)
    private Cor cor;

    public Categoria(DadosCategoria dados) {
        this.categoria = dados.categoria();
        this.cor = dados.cor();
    }

    public void atualizarInformacoes(DadosCategoria dados) {
        if(this.categoria != null) {
            this.categoria = dados.categoria();
        }
    }
}
