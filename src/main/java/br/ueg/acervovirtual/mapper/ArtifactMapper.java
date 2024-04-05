package br.ueg.acervovirtual.mapper;

import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.model.dtos.CreateArtifactDTO;
import br.ueg.acervovirtual.model.dtos.UpdateArtifactDTO;

public class ArtifactMapper {
    public Artifact toModel(CreateArtifactDTO dto){
        Artifact a = new Artifact();
        a.setPieceNumber(dto.getPieceNumber());
        a.setPieceName(dto.getPieceName());
        a.setProvenance(dto.getProvenance());
        a.setCollectorDonor(dto.getCollectorDonor());
        a.setFamilyTaxon(dto.getFamilyTaxon());
        a.setCollectionYear(dto.getCollectionYear());
        a.setLocationInCollection(dto.getLocationInCollection());
        a.setPeriodEpochAge(dto.getPeriodEpochAge());
        a.setCollection(dto.getCollection());
        a.setPieceDescription(dto.getPieceDescription());
        a.setStatus(dto.getStatus());
        a.setRegistrationDate(dto.getRegistrationDate());
        return a;
    }
    public Artifact toModel(UpdateArtifactDTO dto){
        Artifact a = new Artifact();
        a.setPieceNumber(dto.getPieceNumber());
        a.setPieceName(dto.getPieceName());
        a.setProvenance(dto.getProvenance());
        a.setCollectorDonor(dto.getCollectorDonor());
        a.setFamilyTaxon(dto.getFamilyTaxon());
        a.setCollectionYear(dto.getCollectionYear());
        a.setLocationInCollection(dto.getLocationInCollection());
        a.setPeriodEpochAge(dto.getPeriodEpochAge());
        a.setCollection(dto.getCollection());
        a.setPieceDescription(dto.getPieceDescription());
        a.setStatus(dto.getStatus());
        a.setRegistrationDate(dto.getTombingDate());
        return a;
    }
}
