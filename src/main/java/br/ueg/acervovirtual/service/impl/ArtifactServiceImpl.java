package br.ueg.acervovirtual.service.impl;

import br.ueg.acervovirtual.exceptions.BusinessLogicError;
import br.ueg.acervovirtual.exceptions.BusinessLogicException;
import br.ueg.acervovirtual.exceptions.MandatoryException;
import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.repository.ArtifactRepository;
import br.ueg.acervovirtual.service.ArtifactService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtifactServiceImpl extends GenericCrudService<Artifact, Long, ArtifactRepository> implements ArtifactService {

    @Override
    protected void prepareToCreate(Artifact data) {

    }

    @Override
    protected void validateBusinessLogicForInsert(Artifact data) {
        if (Strings.isEmpty(data.getArtifactNumber())) {
            throw new BusinessLogicException(BusinessLogicError.MANDATORY_FIELD_NOT_FOUND);
        }
        Optional<Artifact> byArtifactNumber = repository.findByArtifactNumber(data.getArtifactNumber());
        if (byArtifactNumber.isPresent()) {
            throw new BusinessLogicException(BusinessLogicError.NUMBER_ARTIFACT_DUPLICATED);
        }
    }


    @Override
    protected void validateBusinessLogicForUpdate(Artifact data) {
        if(data.getId() <= 0L ){
            throw new BusinessLogicException("Id Inválido");
        }
    }

    @Override
    protected void validateBusinessLogic(Artifact data) {

    }

    @Override
    protected void validateMandatoryFields(Artifact data) {
        if (data.getArtifactNumber() == null || data.getArtifactNumber().isEmpty()) {
            throw new MandatoryException("Nome do artefato é obrigatório");
        }
        if (data.getArtifactName() == null || data.getArtifactName().isEmpty()) {
            throw new MandatoryException("Nome do artefato é obrigatório");
        }
        if (data.getProvenance() == null || data.getProvenance().isEmpty()) {
            throw new MandatoryException("Proveniência do artefato é obrigatório");
        }
        if (data.getCollectorDonor() == null || data.getCollectorDonor().isEmpty()) {
            throw new MandatoryException("Coletor/Doador do artefato é obrigatório");
        }
        if (data.getFamilyTaxon() == null || data.getFamilyTaxon().isEmpty()) {
            throw new MandatoryException("Família/Taxonomia do artefato é obrigatório");
        }
        if (data.getCollectionYear() == null) {
            throw new MandatoryException("Ano de coleta do artefato é obrigatório");
        }
        if (data.getLocationInCollection() == null || data.getLocationInCollection().isEmpty()) {
            throw new MandatoryException("Localização no acervo do artefato é obrigatório");
        }
        if (data.getPeriodEpochAge() == null || data.getPeriodEpochAge().isEmpty()) {
            throw new MandatoryException("Período/Época/Idade do artefato é obrigatório");
        }
        if (data.getCollection() == null || data.getCollection().isEmpty()) {
            throw new MandatoryException("Coleção do artefato é obrigatório");
        }
        if (data.getStatus() == null) {
            throw new MandatoryException("Status do artefato é obrigatório");
        }
        if (data.getTombingDate() == null) {
            throw new MandatoryException("Data de tombamento do artefato é obrigatório");
        }
    }
}
