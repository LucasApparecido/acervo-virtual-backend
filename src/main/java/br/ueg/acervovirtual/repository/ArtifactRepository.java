package br.ueg.acervovirtual.repository;

import br.ueg.acervovirtual.model.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    Optional<Artifact> findByPieceNumber(String numberPiece);

    @Query("SELECT a FROM Artifact a ORDER BY a.collectionYear DESC")
    List<Artifact> findAllArtifactsByCollectionYear();
}
