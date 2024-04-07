package br.ueg.acervovirtual.model.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArtifactDTO {
    private String pieceNumber;

    private String pieceName;

    private String provenance;

    private String collectorDonor;

    private String familyTaxon;

    private Integer collectionYear;

    private String locationInCollection;

    private String periodEpochAge;

    private String collection;

    private String pieceDescription;

    private Boolean Status;

    private LocalDate tombingDate;

    private LocalDate registrationDate;
}
