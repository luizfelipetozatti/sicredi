package com.sicred.votacao.repository;

import com.sicred.votacao.domain.associado.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Integer> {
}

