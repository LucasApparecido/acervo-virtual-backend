package br.ueg.acervovirtual.controllers;

import br.ueg.acervovirtual.mapper.ArtifactMapper;
import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.service.ArtifactService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "${api.version}/artefacts")
public class ArtifactController {

    @Autowired
    private ArtifactService service;

    @Autowired
    private ArtifactMapper mapper;

    @PostMapping
    @Operation(description = "End point para inclusão de artefato")
    public ResponseEntity<Artifact> create (@RequestBody Artifact artifact ){
        var artifactCreate = service.createArtifact(artifact);
        return ResponseEntity.ok(artifactCreate);
    }


    @GetMapping
    @Operation(description = "Lista todos os artefatos registrados")
    public ResponseEntity<List<Artifact>> listAllArtifacts() {
        List<Artifact> artifactList = new ArrayList<>();
        try{
            artifactList = service.listALLArtifacts();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.of(Optional.ofNullable(artifactList));
    }
}
