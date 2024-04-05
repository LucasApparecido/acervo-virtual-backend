package br.ueg.acervovirtual.service;

import br.ueg.acervovirtual.model.Artifact;

import java.util.List;

public interface ArtifactService {
        List<Artifact> listALLArtifacts();// retorna uma lista de objetos do tipo "Artifact"
        Artifact createArtifact (Artifact artifact); // Cria/Adiciona um novo artefato
        Artifact updateArtifact(Artifact artifact); // Atualiza um artefato existente

        Artifact getById(Long id); // Retorna um artefato pelo seu id
}
