package videos.api.videos.videos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;
import videos.api.videos.categoria.DadosCategoria;

public record DadosCadastroVideo(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        @URL(regexp = "^(http|ftp).*")
        String url,
        @NotNull
        @Valid
        DadosCategoria categoria) {
}
