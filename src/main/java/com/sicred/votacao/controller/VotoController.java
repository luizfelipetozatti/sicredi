package com.sicred.votacao.controller;

import com.sicred.votacao.domain.pauta.Pauta;
import com.sicred.votacao.domain.pauta.PautaDTO;
import com.sicred.votacao.domain.pauta.VotoDTO;
import com.sicred.votacao.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votacao")
public class VotoController {
    @Autowired
    VotoService votoService;

    @PostMapping("/abrirSessao")
    public ResponseEntity<Pauta> abrirSessao(PautaDTO pautaDTO) {
        return ResponseEntity.ok(votoService.abrirSessao(pautaDTO));
    }

    @PostMapping("/votar")
    public ResponseEntity<?> votar(VotoDTO votoDTO) {
        try {
            return ResponseEntity.ok(votoService.votar(votoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }
}