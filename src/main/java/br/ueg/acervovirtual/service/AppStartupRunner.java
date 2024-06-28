package br.ueg.acervovirtual.service;

import br.ueg.acervovirtual.model.Artifact;
import br.ueg.acervovirtual.repository.ArtifactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.Month;


@Component
public class AppStartupRunner implements ApplicationRunner {
    public static final String CREATE_DROP="create-drop";

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    private ArtifactRepository artifactRepository;

    public void initDados(){
        LOG.info("Inicio da execução do InitDados!");
        if(!this.ddlAuto.equalsIgnoreCase(CREATE_DROP)){
            return;
        }
        for(int index = 1; index <= 100; index++){
            Artifact artifact = Artifact.builder()
                    .artifactNumber(Integer.toString(index))
                    .artifactName("Peça " + index)
                    .provenance("Proveniencia " + index)
                    .collectorDonor("Coletor " + index)
                    .familyTaxon("Familia " + index)
                    .collectionYear(2021)
                    .locationInCollection("Localização " + index)
                    .periodEpochAge("Periodo " + index)
                    .collection("Coleção " + index)
                    .artifactDescription("Descrição " + index)
                    .status(true)
                    .tombingDate(LocalDate.of(2024, Month.JANUARY, 1))
                    .registrationDate(LocalDate.now())
                    .build();
            this.artifactRepository.save(artifact);
        }
        LOG.info("Fim da execução");
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            this.initDados();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
