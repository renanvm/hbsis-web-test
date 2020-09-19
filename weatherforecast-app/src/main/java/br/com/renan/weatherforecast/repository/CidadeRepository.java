package br.com.renan.weatherforecast.repository;

import br.com.renan.weatherforecast.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
