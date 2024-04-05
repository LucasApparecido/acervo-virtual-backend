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
        validateBusinessLogic(data);
        validateBusinessLogicForInsert(data);
        return artifactRepository.save(data);
    }

    @Override
    public Artifact updateArtifact(Artifact dataToUpdate) {
        var dataDB = validateIdArtifactExists(dataToUpdate.getId());
        validateMandatoryFields(dataToUpdate);
        validateBusinessLogic(dataToUpdate);
        validateBusinessLogicForUpdate(dataToUpdate);
        updateDataDBFromUpdate(dataToUpdate, dataDB);
        return artifactRepository.save(dataDB);
    }

    @Override
    public Artifact getById(Long id) {
        return this.validateIdArtifactExists(id);
    }

    private void prepareToCreate(Artifact data) {
        data.setId(null);
    }

    //Talvez um switch case com todos os campos, vale a duvida mais tarde com o professor
    private void validateMandatoryFields(Artifact data) {
        if (data.getPieceNumber() == null || data.getPieceNumber().isEmpty()) {
            throw new MandatoryException("Nome do artefato é obrigatório");
        }
    }

    private void validateBusinessLogic(Artifact data) {}

    private void validateBusinessLogicForInsert(Artifact data) {
        if(Strings.isEmpty(data.getPieceNumber())){
            throw new BusinessLogicException(BusinessLogicError.MANDATORY_FIELD_NOT_FOUND);
        }
        Optional<Artifact> byNumberPiece = artifactRepository.findByPieceNumber(data.getPieceNumber());
        if(byNumberPiece.isPresent()){
            throw new BusinessLogicException(BusinessLogicError.NUMBER_PIECE_DUPLICATED);
        }
    }

    private void validateBusinessLogicForUpdate(Artifact data) {
        if(data.getId() <= 0L ){
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
        dataDB.setPieceNumber(dataToUpdate.getPieceNumber());
        dataDB.setPieceName(dataToUpdate.getPieceName());
        dataDB.setPieceDescription(dataToUpdate.getPieceDescription());
        dataDB.setProvenance(dataToUpdate.getProvenance());
        dataDB.setCollectorDonor(dataToUpdate.getCollectorDonor());
        dataDB.setFamilyTaxon(dataToUpdate.getFamilyTaxon());
        dataDB.setCollectionYear(dataToUpdate.getCollectionYear());
        dataDB.setLocationInCollection(dataToUpdate.getLocationInCollection());
        dataDB.setPeriodEpochAge(dataToUpdate.getPeriodEpochAge());
        dataDB.setCollection(dataToUpdate.getCollection());
        dataDB.setStatus(dataToUpdate.getStatus());
    }

}
