package com.example.domain.model;


import java.io.Serializable;
import java.util.Objects;

import static java.lang.Long.valueOf;

public class PK<T extends AbstractEntity<T>> implements Serializable {
    private static final long serialVersionUID = -1L;

    private Long id;

    public PK() {}

    public PK(final Long id) {
        this.id = id;
    }

    public static <T extends AbstractEntity<T>> PK<T> of(final Long id) {
        return new PK<>(id);
    }

    public static <T extends AbstractEntity<T>> PK<T> of(final String id) {
        return new PK<>(valueOf(id));
    }

    public PK<T> setId(final Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PK)) return false;
        final PK other = PK.class.cast(o);
        if (!other.canEqual(this)) return false;
        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PK;
    }
}
