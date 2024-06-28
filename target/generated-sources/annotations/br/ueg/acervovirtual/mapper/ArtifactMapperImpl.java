package br.ueg.acervovirtual.mapper;

import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.model.dtos.ArtifactDTO;
import br.ueg.acervovirtual.model.dtos.ArtifactDataDTO;
import br.ueg.acervovirtual.model.dtos.ArtifactListDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-27T21:19:03-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ArtifactMapperImpl implements ArtifactMapper {

    @Override
    public void updateModelFromModel(Artifact entity, Artifact updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        if ( updateEntity.getId() != null ) {
            entity.setId( updateEntity.getId() );
        }
        if ( updateEntity.getArtifactNumber() != null ) {
            entity.setArtifactNumber( updateEntity.getArtifactNumber() );
        }
        if ( updateEntity.getArtifactName() != null ) {
            entity.setArtifactName( updateEntity.getArtifactName() );
        }
        if ( updateEntity.getProvenance() != null ) {
            entity.setProvenance( updateEntity.getProvenance() );
        }
        if ( updateEntity.getCollectorDonor() != null ) {
            entity.setCollectorDonor( updateEntity.getCollectorDonor() );
        }
        if ( updateEntity.getFamilyTaxon() != null ) {
            entity.setFamilyTaxon( updateEntity.getFamilyTaxon() );
        }
        if ( updateEntity.getCollectionYear() != null ) {
            entity.setCollectionYear( updateEntity.getCollectionYear() );
        }
        if ( updateEntity.getLocationInCollection() != null ) {
            entity.setLocationInCollection( updateEntity.getLocationInCollection() );
        }
        if ( updateEntity.getPeriodEpochAge() != null ) {
            entity.setPeriodEpochAge( updateEntity.getPeriodEpochAge() );
        }
        if ( updateEntity.getCollection() != null ) {
            entity.setCollection( updateEntity.getCollection() );
        }
        if ( updateEntity.getArtifactDescription() != null ) {
            entity.setArtifactDescription( updateEntity.getArtifactDescription() );
        }
        if ( updateEntity.getStatus() != null ) {
            entity.setStatus( updateEntity.getStatus() );
        }
        if ( updateEntity.getTombingDate() != null ) {
            entity.setTombingDate( updateEntity.getTombingDate() );
        }
        if ( updateEntity.getRegistrationDate() != null ) {
            entity.setRegistrationDate( updateEntity.getRegistrationDate() );
        }
    }

    @Override
    public Artifact toModel(ArtifactDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Artifact.ArtifactBuilder artifact = Artifact.builder();

        if ( dto.getArtifactNumber() != null ) {
            artifact.artifactNumber( dto.getArtifactNumber() );
        }
        if ( dto.getArtifactName() != null ) {
            artifact.artifactName( dto.getArtifactName() );
        }
        if ( dto.getProvenance() != null ) {
            artifact.provenance( dto.getProvenance() );
        }
        if ( dto.getCollectorDonor() != null ) {
            artifact.collectorDonor( dto.getCollectorDonor() );
        }
        if ( dto.getFamilyTaxon() != null ) {
            artifact.familyTaxon( dto.getFamilyTaxon() );
        }
        if ( dto.getCollectionYear() != null ) {
            artifact.collectionYear( dto.getCollectionYear() );
        }
        if ( dto.getLocationInCollection() != null ) {
            artifact.locationInCollection( dto.getLocationInCollection() );
        }
        if ( dto.getPeriodEpochAge() != null ) {
            artifact.periodEpochAge( dto.getPeriodEpochAge() );
        }
        if ( dto.getCollection() != null ) {
            artifact.collection( dto.getCollection() );
        }
        if ( dto.getArtifactDescription() != null ) {
            artifact.artifactDescription( dto.getArtifactDescription() );
        }
        if ( dto.getStatus() != null ) {
            artifact.status( dto.getStatus() );
        }
        if ( dto.getTombingDate() != null ) {
            artifact.tombingDate( dto.getTombingDate() );
        }
        if ( dto.getRegistrationDate() != null ) {
            artifact.registrationDate( dto.getRegistrationDate() );
        }

        return artifact.build();
    }

    @Override
    public Artifact fromModelCreatedToModel(ArtifactDataDTO dtoCreate) {
        if ( dtoCreate == null ) {
            return null;
        }

        Artifact.ArtifactBuilder artifact = Artifact.builder();

        if ( dtoCreate.getArtifactNumber() != null ) {
            artifact.artifactNumber( dtoCreate.getArtifactNumber() );
        }
        if ( dtoCreate.getArtifactName() != null ) {
            artifact.artifactName( dtoCreate.getArtifactName() );
        }
        if ( dtoCreate.getProvenance() != null ) {
            artifact.provenance( dtoCreate.getProvenance() );
        }
        if ( dtoCreate.getCollectorDonor() != null ) {
            artifact.collectorDonor( dtoCreate.getCollectorDonor() );
        }
        if ( dtoCreate.getFamilyTaxon() != null ) {
            artifact.familyTaxon( dtoCreate.getFamilyTaxon() );
        }
        if ( dtoCreate.getCollectionYear() != null ) {
            artifact.collectionYear( dtoCreate.getCollectionYear() );
        }
        if ( dtoCreate.getLocationInCollection() != null ) {
            artifact.locationInCollection( dtoCreate.getLocationInCollection() );
        }
        if ( dtoCreate.getPeriodEpochAge() != null ) {
            artifact.periodEpochAge( dtoCreate.getPeriodEpochAge() );
        }
        if ( dtoCreate.getCollection() != null ) {
            artifact.collection( dtoCreate.getCollection() );
        }
        if ( dtoCreate.getArtifactDescription() != null ) {
            artifact.artifactDescription( dtoCreate.getArtifactDescription() );
        }
        if ( dtoCreate.getStatus() != null ) {
            artifact.status( dtoCreate.getStatus() );
        }
        if ( dtoCreate.getTombingDate() != null ) {
            artifact.tombingDate( dtoCreate.getTombingDate() );
        }
        if ( dtoCreate.getRegistrationDate() != null ) {
            artifact.registrationDate( dtoCreate.getRegistrationDate() );
        }

        return artifact.build();
    }

    @Override
    public Artifact fromModelUpdatedToModel(ArtifactDataDTO dtoUpdate) {
        if ( dtoUpdate == null ) {
            return null;
        }

        Artifact.ArtifactBuilder artifact = Artifact.builder();

        if ( dtoUpdate.getArtifactNumber() != null ) {
            artifact.artifactNumber( dtoUpdate.getArtifactNumber() );
        }
        if ( dtoUpdate.getArtifactName() != null ) {
            artifact.artifactName( dtoUpdate.getArtifactName() );
        }
        if ( dtoUpdate.getProvenance() != null ) {
            artifact.provenance( dtoUpdate.getProvenance() );
        }
        if ( dtoUpdate.getCollectorDonor() != null ) {
            artifact.collectorDonor( dtoUpdate.getCollectorDonor() );
        }
        if ( dtoUpdate.getFamilyTaxon() != null ) {
            artifact.familyTaxon( dtoUpdate.getFamilyTaxon() );
        }
        if ( dtoUpdate.getCollectionYear() != null ) {
            artifact.collectionYear( dtoUpdate.getCollectionYear() );
        }
        if ( dtoUpdate.getLocationInCollection() != null ) {
            artifact.locationInCollection( dtoUpdate.getLocationInCollection() );
        }
        if ( dtoUpdate.getPeriodEpochAge() != null ) {
            artifact.periodEpochAge( dtoUpdate.getPeriodEpochAge() );
        }
        if ( dtoUpdate.getCollection() != null ) {
            artifact.collection( dtoUpdate.getCollection() );
        }
        if ( dtoUpdate.getArtifactDescription() != null ) {
            artifact.artifactDescription( dtoUpdate.getArtifactDescription() );
        }
        if ( dtoUpdate.getStatus() != null ) {
            artifact.status( dtoUpdate.getStatus() );
        }
        if ( dtoUpdate.getTombingDate() != null ) {
            artifact.tombingDate( dtoUpdate.getTombingDate() );
        }
        if ( dtoUpdate.getRegistrationDate() != null ) {
            artifact.registrationDate( dtoUpdate.getRegistrationDate() );
        }

        return artifact.build();
    }

    @Override
    public ArtifactDTO toDTO(Artifact model) {
        if ( model == null ) {
            return null;
        }

        ArtifactDTO.ArtifactDTOBuilder<?, ?> artifactDTO = ArtifactDTO.builder();

        if ( model.getArtifactNumber() != null ) {
            artifactDTO.artifactNumber( model.getArtifactNumber() );
        }
        if ( model.getArtifactName() != null ) {
            artifactDTO.artifactName( model.getArtifactName() );
        }
        if ( model.getProvenance() != null ) {
            artifactDTO.provenance( model.getProvenance() );
        }
        if ( model.getCollectorDonor() != null ) {
            artifactDTO.collectorDonor( model.getCollectorDonor() );
        }
        if ( model.getFamilyTaxon() != null ) {
            artifactDTO.familyTaxon( model.getFamilyTaxon() );
        }
        if ( model.getCollectionYear() != null ) {
            artifactDTO.collectionYear( model.getCollectionYear() );
        }
        if ( model.getLocationInCollection() != null ) {
            artifactDTO.locationInCollection( model.getLocationInCollection() );
        }
        if ( model.getPeriodEpochAge() != null ) {
            artifactDTO.periodEpochAge( model.getPeriodEpochAge() );
        }
        if ( model.getCollection() != null ) {
            artifactDTO.collection( model.getCollection() );
        }
        if ( model.getArtifactDescription() != null ) {
            artifactDTO.artifactDescription( model.getArtifactDescription() );
        }
        if ( model.getTombingDate() != null ) {
            artifactDTO.tombingDate( model.getTombingDate() );
        }
        if ( model.getRegistrationDate() != null ) {
            artifactDTO.registrationDate( model.getRegistrationDate() );
        }

        return artifactDTO.build();
    }

    @Override
    public ArtifactListDTO toDTOList(Artifact model) {
        if ( model == null ) {
            return null;
        }

        Artifact.ArtifactBuilder artifactListDTO = Artifact.builder();

        if ( model.getArtifactNumber() != null ) {
            artifactListDTO.artifactNumber( model.getArtifactNumber() );
        }
        if ( model.getArtifactName() != null ) {
            artifactListDTO.artifactName( model.getArtifactName() );
        }
        if ( model.getProvenance() != null ) {
            artifactListDTO.provenance( model.getProvenance() );
        }
        if ( model.getCollectorDonor() != null ) {
            artifactListDTO.collectorDonor( model.getCollectorDonor() );
        }
        if ( model.getFamilyTaxon() != null ) {
            artifactListDTO.familyTaxon( model.getFamilyTaxon() );
        }
        if ( model.getCollectionYear() != null ) {
            artifactListDTO.collectionYear( model.getCollectionYear() );
        }
        if ( model.getLocationInCollection() != null ) {
            artifactListDTO.locationInCollection( model.getLocationInCollection() );
        }
        if ( model.getPeriodEpochAge() != null ) {
            artifactListDTO.periodEpochAge( model.getPeriodEpochAge() );
        }
        if ( model.getCollection() != null ) {
            artifactListDTO.collection( model.getCollection() );
        }
        if ( model.getArtifactDescription() != null ) {
            artifactListDTO.artifactDescription( model.getArtifactDescription() );
        }
        if ( model.getStatus() != null ) {
            artifactListDTO.status( model.getStatus() );
        }
        if ( model.getTombingDate() != null ) {
            artifactListDTO.tombingDate( model.getTombingDate() );
        }
        if ( model.getRegistrationDate() != null ) {
            artifactListDTO.registrationDate( model.getRegistrationDate() );
        }

        return artifactListDTO.build();
    }

    @Override
    public List<ArtifactListDTO> fromModelToDTOList(List<Artifact> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<ArtifactListDTO> list = new ArrayList<ArtifactListDTO>( modelList.size() );
        for ( Artifact artifact : modelList ) {
            list.add( toDTOList( artifact ) );
        }

        return list;
    }
}
