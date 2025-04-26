package me.dio.domain.repository;

import me.dio.domain.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    boolean existsByNome(String nome);
}
