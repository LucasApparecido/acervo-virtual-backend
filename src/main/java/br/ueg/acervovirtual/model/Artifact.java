package br.ueg.acervovirtual.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ARTEFATO")
public class Artifact {

    @Id
    @SequenceGenerator(
            name = "artifact_sequence",
            sequenceName = "artifact_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artifact_sequence"
    )
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Numero_da_peca", length = 20, nullable = false)
    private String pieceNumber;

    @Column(name = "Proveniencia", length = 100, nullable = false)
    private String provenance;

    @Column(name = "Coletor_Doador", length = 100, nullable = false)
    private String collectorDonor;

    @Column(name = "Familia_Taxon", length = 250, nullable = false)
    private String familyTaxon;

    @Column(name = "Ano_de_Coleta", length = 4, nullable = false)
    private Integer collectionYear;

    @Column(name = "Localizacao_no_Acervo", length = 20, nullable = false)
    private String locationInCollection;

    @Column(name = "Periodo_Epoca_Idade", length = 50, nullable = false)
    private String periodEpochAge;

    @Column(name = "Colecao", length = 30, nullable = false)
    private String collection;

    @Column(name = "Descricao_da_Peca", length = 500)
    private String pieceDescription;

    @Column(name = "Status", nullable = false)
    private Boolean status;

    @Column(name = "Data_de_tombamento", nullable = false)
    private LocalDate tombingDate;
}
