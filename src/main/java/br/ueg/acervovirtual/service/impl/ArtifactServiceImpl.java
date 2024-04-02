package br.ueg.acervovirtual.service.impl;

import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.repository.ArtifactRepository;
import br.ueg.acervovirtual.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtifactServiceImpl implements ArtifactService {

    @Autowired
    private ArtifactRepository artifactRepository;

    @Override
    public Artifact createArtifact(Artifact artifact) {
        return null;
    }

    @Override
    public Artifact updateArtifact(Artifact artifact) {
        return null;
    }

    @Override
    public List<Artifact> listALLArtifacts(){
        return artifactRepository.findAll();
    }
}
