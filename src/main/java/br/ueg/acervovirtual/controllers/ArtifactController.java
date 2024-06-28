package br.ueg.acervovirtual.controllers;

import br.ueg.acervovirtual.mapper.ArtifactMapper;
import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.model.dtos.ArtifactDTO;
import br.ueg.acervovirtual.model.dtos.ArtifactDataDTO;
import br.ueg.acervovirtual.model.dtos.ArtifactListDTO;
import br.ueg.acervovirtual.service.ArtifactService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/person")
public class ArtifactController extends
GenericCRUDController<
        ArtifactDTO, // DTO Geral
        ArtifactDataDTO, // DTO Create
        ArtifactDataDTO, // DTO Update
        ArtifactListDTO,
        Artifact, // Modelo
        Long, // PK_TYPE
        ArtifactService, //Interface Serviço
        ArtifactMapper> // Mapper
{

}
