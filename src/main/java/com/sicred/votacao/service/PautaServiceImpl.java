package com.sicred.votacao.service;

import com.sicred.votacao.domain.pauta.Pauta;
import com.sicred.votacao.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;

@Service
public class PautaServiceImpl implements PautaService {
    @Autowired
    PautaRepository pautaRepository;

    @Override
    public boolean sessaoAberta(Integer idPauta) {
        Pauta pauta = pautaRepository.findById(idPauta).get();
        return (Duration.between(LocalDate.now(),pauta.getAberturaSessao()).toMinutes() <= 1L);

    }

    @Override
    public boolean associadoJaVotou(Integer idPauta, Integer idAssociado) {
        return pautaRepository.findByIdAndIdAssociado(idPauta, idAssociado).getId() > 0;
    }

    @Override
    public Pauta salvar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }
}