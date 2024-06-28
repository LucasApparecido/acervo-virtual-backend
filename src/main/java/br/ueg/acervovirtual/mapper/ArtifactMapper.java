package br.ueg.acervovirtual.mapper;

import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.model.dtos.ArtifactDataDTO;
import br.ueg.acervovirtual.model.dtos.ArtifactDTO;
import br.ueg.acervovirtual.model.dtos.ArtifactListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ArtifactMapper extends GenericMapper<
        ArtifactDTO, // DTO Geral
        ArtifactDataDTO, // DTO Create
        ArtifactDataDTO, // DTO Update
        ArtifactListDTO, // DTO List
        Artifact, // Model
        Long // PK_TYPE
        > {
}
