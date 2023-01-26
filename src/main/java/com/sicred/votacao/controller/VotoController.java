package com.sicred.votacao.controller;

import com.sicred.votacao.domain.pauta.Pauta;
import com.sicred.votacao.domain.pauta.PautaDTO;
import com.sicred.votacao.domain.pauta.VotoDTO;
import com.sicred.votacao.service.VotoService;
import feign.FeignException;
import io.swagger.annotations.ApiOperation;
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

    @PostMapping({"/v1.0/abrirSessao","/v1.1/abrirSessao"})
    @ApiOperation(value = "endpoint responsável por abrir a sessão")
    public ResponseEntity<Pauta> abrirSessao(PautaDTO pautaDTO) {
        return ResponseEntity.ok(votoService.abrirSessao(pautaDTO));
    }

    @PostMapping("/v1.1/votar")
    @ApiOperation(value = "endpoint responsável por efetuar o voto")
    public ResponseEntity<?> votar(VotoDTO votoDTO) {
        try {
            return ResponseEntity.ok(votoService.votar(votoDTO));
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}