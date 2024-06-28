package br.ueg.acervovirtual.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ArtifactDTO {

    private Long Id;

    private String artifactNumber;

    private String artifactName;

    private String provenance;

    private String collectorDonor;

    private String familyTaxon;

    private Integer collectionYear;

    private String locationInCollection;

    private String periodEpochAge;

    private String collection;

    private String artifactDescription;

    private Boolean Status;

    private LocalDate tombingDate;

    private LocalDate registrationDate;
}
