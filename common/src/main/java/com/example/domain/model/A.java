package com.example.domain.model;

import java.util.ArrayList;

public class A extends AbstractEntity<A> {

    public A addNested(final Nested nested) {
        if (null == this.nesteds) {
            this.nesteds = new ArrayList<>();
        }
        this.nesteds.add(nested);
        return this;
    }
}
