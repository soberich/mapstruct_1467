package com.example.domain.model;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {
    T getId();
    // N.B. This setter is not supposed to be here, but to show weird output of
    //    @Mapping(target = "id", source = "id")
    //    Identifiable mapI(CommonDTO source);
    Identifiable<T> setId(T id);
}
