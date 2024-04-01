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

    @Column(name = "Numero_da_peca", length = 20)
    private String pieceNumber;

    @Column(name = "Proveniencia", length = 100)
    private String provenance;

    @Column(name = "Coletor_Doador", length = 100)
    private String collectorDonor;

    @Column(name = "Familia_Taxon", length = 250)
    private String familyTaxon;

    @Column(name = "Ano_de_Coleta", length = 4)
    private Integer collectionYear;

    @Column(name = "Localizacao_no_Acervo", length = 20)
    private String locationInCollection;

    @Column(name = "Periodo_Epoca_Idade", length = 50)
    private String periodEpochAge;

    @Column(name = "Colecao", length = 30)
    private String collection;

    @Column(name = "Descricao_da_Peca", length = 500)
    private String pieceDescription;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "Data_de_tombamento")
    private LocalDate tombingDate;
}
