package com.sicred.votacao.service;

import com.sicred.votacao.domain.pauta.Pauta;
import com.sicred.votacao.domain.pauta.PautaDTO;
import com.sicred.votacao.domain.pauta.Voto;
import com.sicred.votacao.domain.pauta.VotoDTO;

public interface VotoService {
    public Pauta abrirSessao(PautaDTO pautaDTO);

    public Voto votar(VotoDTO votoDTO) throws Exception;
}