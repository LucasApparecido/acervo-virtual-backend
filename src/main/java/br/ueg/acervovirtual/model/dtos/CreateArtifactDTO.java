package br.ueg.acervovirtual.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateArtifactDTO {
   @Schema(description = "Número da peça",example = "22222")
   private String pieceNumber;

    @Schema(description = "Nome da peça", example = "nome da peça")
    private String pieceName;

    @Schema(description = "Proveniência", example = "proveniência")
    private String provenance;

    @Schema(description = "Coletor/Doador", example = "coletor/doador")
    private String collectorDonor;

    @Schema(description = "Família Taxonômica", example = "família taxonômica")
    private String familyTaxon;

    @Schema(description = "Ano de Coleta", example = "2021")
    private Integer collectionYear;

    @Schema(description = "Localização no Acervo", example = "localização no acervo")
    private String locationInCollection;

    @Schema(description = "Período/Época/Idade", example = "período/época/idade")
    private String periodEpochAge;

    @Schema(description = "Coleção", example = "coleção")
    private String collection;

    @Schema(description = "Descrição da Peça", example = "descrição da peça")
    private String pieceDescription;

    @Schema(description = "Status", example = "true")
    private Boolean Status;

    @Schema(description = "Data de Tombamento", example = "2021-09-01")
    private LocalDate registrationDate;
}
