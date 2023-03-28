package br.com.wandersontimoteo.apilogistica.domain.repository;

import br.com.wandersontimoteo.apilogistica.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
