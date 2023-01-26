package com.sicred.votacao.service;

import com.sicred.votacao.domain.pauta.Pauta;

public interface PautaService {
    public boolean sessaoAberta(Integer idPauta);

    public boolean associadoJaVotou(Integer idPauta, Integer idAssociado);

    public Pauta salvar(Pauta pauta);
}