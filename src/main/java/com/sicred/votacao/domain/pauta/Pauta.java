package com.sicred.votacao.domain.pauta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PAUTA")
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private SessaoEnum sessao;
    private LocalDate aberturaSessao;
    @Builder.Default
    @OneToMany(mappedBy = "pauta", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<Voto> votos = new ArrayList<>();
}
