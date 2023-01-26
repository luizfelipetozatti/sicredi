package com.sicred.votacao.repository;

import com.sicred.votacao.domain.pauta.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer> {
    @Query(value = "SELECT COUNT(P.*) " +
            "         FROM PAUTA P " +
            "         INNER JOIN VOTO V ON P.ID = V.PAUTA_ID" +
            "         INNER JOIN ASSOCIADO A ON V.ASSOCIADO_ID = A.ID" +
            "         WHERE P.ID = ?1 " +
            "           AND A.ID = ?2 ", nativeQuery = true)
    public Long findByIdAndIdAssociado(Integer idPauta, Integer idAssociado);
}