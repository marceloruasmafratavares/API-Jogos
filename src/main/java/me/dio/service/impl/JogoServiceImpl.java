package me.dio.service.impl;

import me.dio.domain.model.Jogo;
import me.dio.domain.repository.JogoRepository;
import me.dio.service.JogoService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class JogoServiceImpl implements JogoService {

    private final JogoRepository jogoRepository;

    public JogoServiceImpl(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    @Override
    public Jogo findById(Long id) {
        return jogoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Jogo create(Jogo jogoToCreate) {
        if (jogoRepository.existsByNome(jogoToCreate.getNome())){
            throw new IllegalArgumentException("Esse jogo já foi colocado");
        }
        return jogoRepository.save(jogoToCreate);
    }
}
