package com.example.domain.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class AbstractEntity<T extends AbstractEntity<T>> implements Identifiable<PK<T>> {

    protected PK<T> id;

    protected List<Nested> nesteds;

    //FIXME: No matter if addNested(..) exist or not
    //FIXME: Compilation fails on
    //FIXME:    @Mapping(target = "id.id", source = "id")
    //FIXME:    AbstractEntity map(CommonDTO source);
    //FIXME: if it present and not commented out, without even getting to adder resolution
//    public T addNested(final Nested nested) {
//        if (null == this.nesteds) {
//            this.nesteds = new ArrayList<>();
//        }
//        this.nesteds.add(nested);
//        //noinspection unchecked
//        return (T) this;
//    }

    public List<Nested> getNesteds() {
        return nesteds;
    }

    public T setNesteds(final Collection<? extends Nested> nesteds) {
        if (null == this.nesteds) {
            this.nesteds = new ArrayList<>();
        }
        this.nesteds.addAll(nesteds);
        //noinspection unchecked
        return (T) this;
    }

    public T setId(final PK<T> id) {
        this.id = id;
        //noinspection unchecked
        return (T) this;
    }

    @Override
    public PK<T> getId() {
        return this.id;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AbstractEntity)) return false;
        final AbstractEntity other = (AbstractEntity) o;
        if (!other.canEqual(this)) return false;
        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AbstractEntity;
    }
}