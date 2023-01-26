package com.sicred.votacao.controller;

import com.sicred.votacao.domain.associado.Associado;
import com.sicred.votacao.domain.associado.AssociadoDTO;
import com.sicred.votacao.service.AssociadoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associado")
public class AssociadoController {
    @Autowired
    AssociadoService associadoService;

    @PostMapping({"/v1.0","v1.1"})
    @ApiOperation(value = "endpoint responsável por cadastrar associado")
    public ResponseEntity<Associado> cadastrar(AssociadoDTO associadoDTO) {
        return ResponseEntity.ok(associadoService.cadastrar(associadoDTO));
    }
}
