package videos.api.videos.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCategoria(
        @NotBlank
        String categoria,
        @NotNull
        Cor cor) {
}
