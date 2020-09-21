package br.com.renan.weatherforecast.controller;

import br.com.renan.weatherforecast.model.Cidade;
import br.com.renan.weatherforecast.repository.CidadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/cidades")
@CrossOrigin()
public class CidadeController {

    private CidadeRepository cidadeRepository;

    public CidadeController(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    @PostMapping
    public ResponseEntity<?> createCidade(@RequestBody Cidade cidade) throws URISyntaxException {
            Cidade result = cidadeRepository.save(cidade);
            return ResponseEntity.created(new URI("/api/cidades/" + result.getId()))
                    .body(result);
    }

    @PutMapping
    public ResponseEntity<?> updateCidade(@RequestBody Cidade cidade) {
        if (cidade.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo Id vazio");
        }
        Cidade result = cidadeRepository.save(cidade);
        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping
    public ResponseEntity<?> getAllCidades() {
        return ResponseEntity.ok().body(cidadeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCidade(@PathVariable Long id) {
        if (cidadeRepository.findById(id).isPresent()) {
            Cidade cidade = cidadeRepository.findById(id).get();
            return ResponseEntity.ok().body(cidade);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> getCidadeByNome(@PathVariable String nome) {
        if (cidadeRepository.findByNome(nome).isPresent()) {
            Cidade cidade = cidadeRepository.findByNome(nome).get();
            return ResponseEntity.ok().body(cidade);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCidade(@PathVariable Long id) {
        if (cidadeRepository.findById(id).isPresent()) {
            cidadeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
