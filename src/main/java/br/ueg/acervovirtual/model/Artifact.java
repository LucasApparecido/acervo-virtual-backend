package br.ueg.acervovirtual.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ARTEFATO")
public class Artifact implements GenericModel<Long> {
    public final static String SEQUENCE_NAME = "artifact_sequence";//Mude o nome para criar outro

    @Id
    @SequenceGenerator(
            name=SEQUENCE_NAME,
            sequenceName = SEQUENCE_NAME+"_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = SEQUENCE_NAME
    )
    @Column(name = "Id", nullable = false)
    private Long Id;

    @Column(name = "Numero_da_peca", length = 50, nullable = false)
    private String artifactNumber;

    @Column(name = "Nome_da_Peca", length = 100, nullable = false)
    private String artifactName;

    @Column(name = "Proveniencia", length = 100, nullable = false)
    private String provenance;

    @Column(name = "Coletor_Doador", length = 100, nullable = false)
    private String collectorDonor;

    @Column(name = "Familia_Taxon", length = 250, nullable = false)
    private String familyTaxon;

    @Column(name = "Ano_de_Coleta", length = 4, nullable = false)
    private Integer collectionYear;

    @Column(name = "Localizacao_no_Acervo", length = 50, nullable = false)
    private String locationInCollection;

    @Column(name = "Periodo_Epoca_Idade", length = 50, nullable = false)
    private String periodEpochAge;

    @Column(name = "Colecao", length = 100, nullable = false)
    private String collection;

    @Column(name = "Descricao_da_Peca", length = 500)
    private String artifactDescription;

    @Column(name = "Status", nullable = false)
    private Boolean status;

    @Column(name = "Data_de_tombamento", nullable = false)
    private LocalDate tombingDate;

    @Column(name = "Data_de_cadastro", nullable = false)
    private LocalDate registrationDate;
}
