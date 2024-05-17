package br.ueg.acervovirtual.service.impl;

import br.ueg.acervovirtual.exceptions.BusinessLogicError;
import br.ueg.acervovirtual.exceptions.BusinessLogicException;
import br.ueg.acervovirtual.exceptions.MandatoryException;
import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.repository.ArtifactRepository;
import br.ueg.acervovirtual.service.ArtifactService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArtifactServiceImpl implements ArtifactService {

    @Autowired
    private ArtifactRepository artifactRepository;

    @Override
    public List<Artifact> listALLArtifacts(){
        return artifactRepository.findAll();
    }

    @Override
    public Artifact createArtifact(Artifact data) {
        prepareToCreate(data);
        validateMandatoryFields(data);
        validateBusinessLogicForInsert(data);
        return artifactRepository.save(data);
    }

    @Override
    public Artifact updateArtifact(Artifact dataToUpdate) {
        var dataDB = validateIdArtifactExists(dataToUpdate.getArtifactId());
        validateMandatoryFields(dataToUpdate);
        validateBusinessLogicForUpdate(dataToUpdate);
        updateDataDBFromUpdate(dataToUpdate, dataDB);
        return artifactRepository.save(dataDB);
    }

    @Override
    public Artifact getById(Long id) {
        return this.validateIdArtifactExists(id);
    }

    private void prepareToCreate(Artifact data) {
        data.setArtifactId(null);
    }

    //Talvez um switch case com todos os campos, vale a duvida mais tarde com o professor
    private void validateMandatoryFields(Artifact data) {
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

    private void validateBusinessLogicForInsert(Artifact data) {
        if(Strings.isEmpty(data.getArtifactNumber())){
            throw new BusinessLogicException(BusinessLogicError.MANDATORY_FIELD_NOT_FOUND);
        }
        Optional<Artifact> byNumberPiece = artifactRepository.findByArtifactNumber(data.getArtifactNumber());
        if(byNumberPiece.isPresent()) {
            throw new BusinessLogicException(BusinessLogicError.NUMBER_ARTIFACT_DUPLICATED);
        }
    }

    private void validateBusinessLogicForUpdate(Artifact data) {
        if(data.getArtifactId() <= 0L ){
            throw new BusinessLogicException("Id Inválido");
        }
    }

    private Artifact internalGetById(Long id) {

        Optional<Artifact> byId = artifactRepository.findById(id);
        return byId.orElse(null);
    }
    private Artifact validateIdArtifactExists(Long id) {
        boolean valid = true;
        Artifact dataDB = null;

        if(Objects.nonNull(id)) {
            dataDB = this.internalGetById(id);
            if (dataDB == null) {
                valid = false;
            }
        }else{
            valid = false;
        }
        if(Boolean.FALSE.equals(valid)){
            throw new BusinessLogicException("Artefato não existe");
        }
        return dataDB;
    }

    private void updateDataDBFromUpdate(Artifact dataToUpdate, Artifact dataDB) {
        dataDB.setArtifactNumber(dataToUpdate.getArtifactNumber());
        dataDB.setArtifactName(dataToUpdate.getArtifactName());
        dataDB.setArtifactDescription(dataToUpdate.getArtifactDescription());
        dataDB.setProvenance(dataToUpdate.getProvenance());
        dataDB.setCollectorDonor(dataToUpdate.getCollectorDonor());
        dataDB.setFamilyTaxon(dataToUpdate.getFamilyTaxon());
        dataDB.setCollectionYear(dataToUpdate.getCollectionYear());
        dataDB.setLocationInCollection(dataToUpdate.getLocationInCollection());
        dataDB.setPeriodEpochAge(dataToUpdate.getPeriodEpochAge());
        dataDB.setCollection(dataToUpdate.getCollection());
        dataDB.setStatus(dataToUpdate.getStatus());
    }

    @Override
    public List<Artifact> getOrderByCollectionYear() {
        Optional<List<Artifact>> byCollectionYear = Optional.ofNullable(artifactRepository.findOrderByCollectionYear());
        return byCollectionYear.get();
    }

    @Override
    public Artifact deleteArtifact(Long id) {
        Artifact artifact = this.validateIdArtifactExists(id);
        artifactRepository.delete(artifact);
        return artifact;
    }
}
