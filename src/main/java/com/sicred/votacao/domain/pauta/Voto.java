package com.sicred.votacao.domain.pauta;

import com.sicred.votacao.domain.associado.Associado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "VOTO")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Associado associado;
    @ManyToOne
    private Pauta pauta;
    private VotoEnum voto;
}
