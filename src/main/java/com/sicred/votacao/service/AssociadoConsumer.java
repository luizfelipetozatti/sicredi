package com.sicred.votacao.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "associado-consumer", url = "https://user-info.herokuapp.com")
public interface AssociadoConsumer {
    @GetMapping(value = "/users/{cpf}")
    public String associadoPodeVotar(@PathVariable("cpf") String cpf);
}