package br.com.tryrun.corridas.repository;

import br.com.tryrun.corridas.model.ECorrida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorridaRepository extends JpaRepository<ECorrida, Long> {

}
