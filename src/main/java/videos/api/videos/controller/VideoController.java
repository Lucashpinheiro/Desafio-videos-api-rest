package videos.api.videos.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import videos.api.videos.categoria.Categoria;
import videos.api.videos.videos.DadosAtualizarVideo;
import videos.api.videos.videos.DadosCadastroVideo;
import videos.api.videos.videos.Video;
import videos.api.videos.videos.VideoRepository;

import java.util.List;



@RestController
@RequestMapping("videos")
public class VideoController {
    @Autowired
    private VideoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroVideo dados){

        repository.save(new Video(dados));
    }

    @GetMapping
    public List<Video> listar(){
        return repository.findAll();

    }
    @GetMapping(path = {"/categoria"})
    public List<Video> Categorialistar(){
        return repository.findAll();

    }
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id) {
            return repository.findById(id)
                    .map(record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build());

    }
    @GetMapping(path = {"categoria/{id}"})
    public ResponseEntity findCategoriaById(@PathVariable Long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarVideo dados){
        var video = repository.getReferenceById(dados.id());
        video.atualizarinformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var video = repository.getReferenceById(id);
        video.excluir();
    }
}
