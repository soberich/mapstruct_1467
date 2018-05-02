package com.example.domain;

import com.example.domain.model.A;
import com.example.domain.model.AbstractEntity;
import com.example.domain.model.B;
import com.example.domain.model.CommonDTO;
import org.mapstruct.Mapper;

@Mapper(config = AbstractMapperConfig.class)
public interface RawCollectionGeneratingMapper {

    A mapA(CommonDTO dto);

    B mapB(CommonDTO dto);

    /*-------------------------------------------
    |            F O R B B I D  RAW              |
    ============================================*/
    //FIXME:  It COMPILES !
    //FIXME:  Generates RAW Collection and assignes inappropriate type
    //FIXME:  ...
    //FIXME:  List list = a.getNesteds();
    //FIXME:    if ( list != null ) {
    //FIXME:      commonDTO.setNesteds( new ArrayList<NestedDTO>( list ) );
    //FIXME:    }
    //FIXME:   ...
    //FIXME:   Solution is to add bound <?>
    //TODO:   Forbid Raw types?
    CommonDTO mapRaw(AbstractEntity a);

    // FINE
    CommonDTO mapWithUnboundWildcard(AbstractEntity<?> a);
    /*-------------------------------------------
    |            F O R B B I D  RAW              |
    ============================================*/
}
