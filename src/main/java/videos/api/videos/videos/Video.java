package videos.api.videos.videos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import videos.api.videos.categoria.Categoria;
@Table(name = "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    @ManyToOne
    private Categoria categoria;

    private Boolean ativo;

    public Video(DadosCadastroVideo dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();
        this.categoria = new Categoria(dados.categoria());
    }

    public void atualizarinformacoes(DadosAtualizarVideo dados) {
        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if(dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if(dados.url() != null) {
            this.url = dados.url();
        }
        if(dados.categoria() != null) {
            this.categoria.atualizarInformacoes(dados.categoria());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
