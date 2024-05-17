package br.ueg.acervovirtual.mapper;

import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.model.dtos.CreateArtifactDTO;
import br.ueg.acervovirtual.model.dtos.UpdateArtifactDTO;
import org.springframework.stereotype.Component;

@Component
public class ArtifactMapper {
    public Artifact toModel(CreateArtifactDTO dto){
        Artifact a = new Artifact();
        a.setArtifactNumber(dto.getArtifactNumber());
        a.setArtifactName(dto.getArtifactName());
        a.setProvenance(dto.getProvenance());
        a.setCollectorDonor(dto.getCollectorDonor());
        a.setFamilyTaxon(dto.getFamilyTaxon());
        a.setCollectionYear(dto.getCollectionYear());
        a.setLocationInCollection(dto.getLocationInCollection());
        a.setPeriodEpochAge(dto.getPeriodEpochAge());
        a.setCollection(dto.getCollection());
        a.setArtifactDescription(dto.getArtifactDescription());
        a.setStatus(dto.getStatus());
        a.setTombingDate(dto.getTombingDate());
        a.setRegistrationDate(dto.getRegistrationDate());
        return a;
    }
    public Artifact toModel(UpdateArtifactDTO dto){
        Artifact a = new Artifact();
        a.setArtifactNumber(dto.getArtifactNumber());
        a.setArtifactName(dto.getArtifactName());
        a.setProvenance(dto.getProvenance());
        a.setCollectorDonor(dto.getCollectorDonor());
        a.setFamilyTaxon(dto.getFamilyTaxon());
        a.setCollectionYear(dto.getCollectionYear());
        a.setLocationInCollection(dto.getLocationInCollection());
        a.setPeriodEpochAge(dto.getPeriodEpochAge());
        a.setCollection(dto.getCollection());
        a.setArtifactDescription(dto.getArtifactDescription());
        a.setStatus(dto.getStatus());
        a.setTombingDate(dto.getTombingDate());
        a.setRegistrationDate(dto.getRegistrationDate());
        return a;
    }
}
