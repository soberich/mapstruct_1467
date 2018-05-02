package com.example.domain;

import com.example.domain.model.AbstractEntity;
import com.example.domain.model.CommonDTO;
import com.example.domain.model.Nested;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = AbstractMapperConfig.class,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface AdderPrefferedMapper {

    /*-------------------------------------------
    |         ABSTRACT GENERIC PARENT            |
    ============================================*/
    // FIXME: error: Internal error in the mapping processor:
    // FIXME: java.lang.IndexOutOfBoundsException: Index 0 out-of-bounds for length 0
//    @Mapping(target = "id", source = "id.id")
//    CommonDTO mapRaw(AbstractEntity/*<?>*/ source);

    @Mapping(target = "id", source = "id.id")
    CommonDTO mapWithUnboundWildcard(AbstractEntity<?> source);
    /*-------------------------------------------
    |         ABSTRACT GENERIC PARENT            |
    ============================================*/
    //FIXME: These two become necessary despite if ACCESSOR_ONLY used this mapping logic generated with no problem
    //FIXME:  why is this necessary then ??
    // TODO: Automatic?
    Nested from(CommonDTO.NestedDTO nestedDTO);
    CommonDTO.NestedDTO from(Nested nested);
}
