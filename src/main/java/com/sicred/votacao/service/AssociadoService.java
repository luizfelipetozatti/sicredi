package com.sicred.votacao.service;

import com.sicred.votacao.domain.associado.Associado;
import com.sicred.votacao.domain.associado.AssociadoDTO;

public interface AssociadoService {
    public Associado cadastrar(AssociadoDTO associadoDTO);

    public boolean associadoPodeVotar(String cpf);
}