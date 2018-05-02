package com.example.domain;

import com.example.domain.model.AbstractEntity;
import com.example.domain.model.CommonDTO;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface AbstractMapperConfig {

    /*-------------------------------------------
    |                  1 4 6 7                   |
    ============================================*/
    // HERE! If uncomment one of @Mapping(..)
    //FIXME: java.util.NoSuchElementException  	at java.base/java.util.ArrayList$Itr.next
//    @Mapping(target = "id", source = "id")
//    AbstractEntity/*<?>*/ mapRaw(CommonDTO source);

    // FINE
    // FIXME: But it'l probably generate a useless/inappropriate mapping => see below
//    @Mapping(target = "id", source = "id")
//    AbstractEntity<?> mapWithUnboundWildcard(CommonDTO source);
    /*-------------------------------------------
    |                  1 4 6 7                   |
    ============================================*/

    //FIXME: This COMPILES (it should not maybe) but produces super weird output!
    //FIXME:
    //FIXME:    protected void longToAPK(Long long1, PK<A> mappingTarget) {
    //FIXME:        if ( long1 == null ) {
    //FIXME:            return;
    //FIXME:        }
    //FIXME:    }
    // TODO: Throw exception or smthing like that maybe.
//    @Mapping(target = "id", source = "id")
//    Identifiable mapIdentifiable(CommonDTO source);

    @Mapping(target = "id", source = "id.id")
    CommonDTO map(AbstractEntity/*<?>*/ source);
}
