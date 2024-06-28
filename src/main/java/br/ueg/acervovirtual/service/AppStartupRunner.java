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
        Artifact artifact = Artifact.builder()
                .Id(1L)
                .artifactNumber("123456")
                .artifactName("Peça 1")
                .provenance("Proveniencia 1")
                .collectorDonor("Coletor 1")
                .familyTaxon("Familia 1")
                .collectionYear(2021)
                .locationInCollection("Localização 1")
                .periodEpochAge("Periodo 1")
                .collection("Coleção 1")
                .artifactDescription("Descrição 1")
                .status(true)
                .tombingDate(LocalDate.of(2021, Month.JANUARY, 1))
                .registrationDate(LocalDate.now())
                .build();
        this.artifactRepository.save(artifact);
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
