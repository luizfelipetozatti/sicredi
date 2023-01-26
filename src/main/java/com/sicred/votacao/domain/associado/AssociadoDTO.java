package com.sicred.votacao.domain.associado;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociadoDTO {
    private String nome;
    private String cpf;
}
