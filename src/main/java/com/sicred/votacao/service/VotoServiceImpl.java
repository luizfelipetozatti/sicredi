package com.sicred.votacao.service;

import com.sicred.votacao.domain.associado.Associado;
import com.sicred.votacao.domain.pauta.*;
import com.sicred.votacao.repository.AssociadoRepository;
import com.sicred.votacao.repository.PautaRepository;
import com.sicred.votacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VotoServiceImpl implements VotoService {
    @Autowired
    VotoRepository votoRepository;
    @Autowired
    PautaService pautaService;

    @Autowired
    PautaRepository pautaRepository;

    @Autowired
    AssociadoRepository associadoRepository;

    @Override
    public Voto votar(VotoDTO votoDTO) throws Exception {
        if (!pautaService.sessaoAberta(votoDTO.getIdPauta())) {
            throw new Exception("Sessão fechada!");
        }

        if (pautaService.associadoJaVotou(votoDTO.getIdPauta(), votoDTO.getIdAssociado())) {
            throw new Exception("Associado já votou nessa pauta!");
        }

        Associado associado = associadoRepository.findById(votoDTO.getIdAssociado()).get();
        Pauta pauta = pautaRepository.findById(votoDTO.getIdPauta()).get();
        Voto voto = Voto.builder()
                .pauta(pauta)
                .associado(associado)
                .voto(votoDTO.getVoto())
                .build();
        return votoRepository.save(voto);
    }

    @Override
    public Pauta abrirSessao(PautaDTO pautaDTO) {
        Pauta pauta = Pauta.builder()
                .nome(pautaDTO.getNome())
                .sessao(SessaoEnum.ABERTA)
                .aberturaSessao(LocalDateTime.now())
                .build();
        return pautaService.salvar(pauta);
    }
}