package com.sicred.votacao.service;

import com.sicred.votacao.domain.associado.Associado;
import com.sicred.votacao.domain.associado.AssociadoDTO;
import com.sicred.votacao.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociadoServiceImpl implements AssociadoService {
    @Autowired
    AssociadoRepository associadoRepository;

    @Autowired
    AssociadoConsumer associadoConsumer;

    @Override
    public Associado cadastrar(AssociadoDTO associadoDTO) {
        Associado associado = Associado.builder()
                .nome(associadoDTO.getNome())
                .cpf(associadoDTO.getCpf())
                .build();
        return associadoRepository.save(associado);
    }

    @Override
    public boolean associadoPodeVotar(String cpf) {
        return associadoConsumer.associadoPodeVotar(cpf) == "ABLE_TO_VOTE";
    }
}
