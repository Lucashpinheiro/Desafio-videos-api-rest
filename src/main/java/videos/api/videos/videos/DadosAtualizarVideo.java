package videos.api.videos.videos;

import jakarta.validation.constraints.NotNull;
import videos.api.videos.categoria.DadosCategoria;

public record DadosAtualizarVideo(
        @NotNull
        Long id,
        String titulo,
        String descricao,
        String url,
        DadosCategoria categoria) {
}
