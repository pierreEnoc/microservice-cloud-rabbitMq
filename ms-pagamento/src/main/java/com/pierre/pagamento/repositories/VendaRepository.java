package com.pierre.pagamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pierre.pagamento.entities.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
