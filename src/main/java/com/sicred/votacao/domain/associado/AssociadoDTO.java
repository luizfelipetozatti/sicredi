package com.sicred.votacao.domain.associado;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociadoDTO {
    @ApiModelProperty("nome do associado")
    private String nome;
    @ApiModelProperty("cpf do associado")
    private String cpf;
}
