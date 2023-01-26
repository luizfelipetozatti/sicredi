package com.sicred.votacao.domain.pauta;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PautaDTO {
    @ApiModelProperty("nome da pauta")
    private String nome;
}