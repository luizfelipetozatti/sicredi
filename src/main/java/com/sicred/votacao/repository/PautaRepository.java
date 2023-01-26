package com.sicred.votacao.repository;

import com.sicred.votacao.domain.pauta.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer> {
    @Query(value = "SELECT P " +
            "         FROM PAUTA P " +
            "         INNER JOIN VOTO V ON P.ID = V.ID_PAUTA" +
            "         INNER JOIN ASSOCIADO A ON V.ID_ASSOCIADO = A.ID" +
            "         WHERE P.ID = ?1 " +
            "           AND A.ID = ?2 ", nativeQuery = true)
    public Pauta findByIdAndIdAssociado(Integer idPauta, Integer idAssociado);
}