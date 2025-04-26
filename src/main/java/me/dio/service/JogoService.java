package me.dio.service;

import me.dio.domain.model.Jogo;

public interface JogoService {

    Jogo findById(Long id);

    Jogo create(Jogo JogoToCreate);
}
