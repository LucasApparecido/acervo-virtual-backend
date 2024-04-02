package br.ueg.acervovirtual.service;

import br.ueg.acervovirtual.model.Artifact;

import java.util.List;

public interface ArtifactService {
        //List<Artifact> listAllArtifacts(); // retorna uma lista de objetos do tipo "Artifact"
        Artifact createArtifact (Artifact artifact); // Cria/Adiciona um novo artefato
        Artifact updateArtifact(Artifact artifact); // Atualiza um artefato existente

        List<Artifact> listALLArtifacts();
}
