package me.dio.controller;

import me.dio.domain.model.Jogo;
import me.dio.service.JogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/Jogos")
public class JogoController {

    private final JogoService jogoService;

    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> findById(@PathVariable Long id) {
        var jogo = jogoService.findById(id);
        return ResponseEntity.ok(jogo);
    }

    @PostMapping
    public ResponseEntity<Jogo> create(@RequestBody Jogo jogoToCreate) {
        var jogoCreated = jogoService.create(jogoToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(jogoCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(jogoCreated);
    }
}
