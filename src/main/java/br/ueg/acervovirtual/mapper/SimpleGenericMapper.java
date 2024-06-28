package br.ueg.acervovirtual.mapper;

import br.ueg.acervovirtual.model.GenericModel;

public interface SimpleGenericMapper<
        DTO,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK
        > extends GenericMapper<
        DTO,
        DTO,
        DTO,
        DTO,
        MODEL,
        TYPE_PK
        > {

}
