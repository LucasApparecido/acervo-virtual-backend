package br.ueg.acervovirtual.controllers;

import br.ueg.acervovirtual.exceptions.BusinessLogicException;
import br.ueg.acervovirtual.exceptions.DataException;
import br.ueg.acervovirtual.exceptions.MandatoryException;
import br.ueg.acervovirtual.mapper.ArtifactMapper;
import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.model.dtos.CreateArtifactDTO;
import br.ueg.acervovirtual.service.ArtifactService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @Operation(description = "End point para inclusão de artefato")
    public ResponseEntity<Object> create (@RequestBody CreateArtifactDTO dto ){
        Artifact artifactSaved = null;
        try{
            Artifact artifactModel = mapper.toModel(dto);
            artifactSaved = service.createArtifact(artifactModel);
        }catch (MandatoryException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Erro: " + e.getMessage());
        }catch (BusinessLogicException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                    .body("Erro:"+e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: desconhecido aconteceu:" + e.getMessage());
        }
        return ResponseEntity.ok(artifactSaved);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/{id}")
    @Operation(description = "End point para atualização de artefato")
    public ResponseEntity<Object> update(
            @RequestBody CreateArtifactDTO dto,
            @PathVariable("id") Long id){
        Artifact artifactSaved = null;
        try{
            Artifact data = mapper.toModel(dto);
            data.setId(id);
            artifactSaved = service.updateArtifact(data);
        }catch (MandatoryException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                    .body("Erro: " + e.getMessage());
        }catch (BusinessLogicException e){
            return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED)
                    .body("Erro:"+e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: desconhecido aconteceu:" + e.getMessage());
        }
        return ResponseEntity.ok(artifactSaved);
    }

    @CrossOrigin(origins = "http://localhost:4200")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    @Operation(description = "Retorna um artefato pelo seu id")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
        Artifact artifact = Artifact.builder().id(0L).build();
        try{
            artifact = service.getById(id);
        }catch (DataException de){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro de dados ocorreu. Detalhe:"+de.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: desconhecido aconteceu:"+e.getMessage());
        }
        return ResponseEntity.ok(artifact);
    }

    @GetMapping(path = "/collectionYear")
    @Operation(description = "Lista todos os artefatos por ano de coleta")
    public ResponseEntity<List<Artifact>> listOrderByCollectionYear(){
        return ResponseEntity.of(Optional.ofNullable(service.getOrderByCollectionYear()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    @Operation(description = "Deleta um artefato pelo seu id")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        try{
            service.deleteArtifact(id);
        }catch (DataException de){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro de dados ocorreu. Detalhe:"+de.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: desconhecido aconteceu:"+e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}
