package com.sicred.votacao.domain.pauta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VotoDTO {
    private Integer idAssociado;
    private Integer idPauta;
    private VotoEnum voto;
}