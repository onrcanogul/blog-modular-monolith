package com.example.demo.starter.shared.kernel.domain;

import java.util.Arrays;

public abstract class ValueObject {
    protected abstract Object[] equalityFields();

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) return false;
        return Arrays.equals(equalityFields(), ((ValueObject) o).equalityFields());
    }
}

