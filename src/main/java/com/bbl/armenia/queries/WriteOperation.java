package com.bbl.armenia.queries;

public interface WriteOperation<T> {
    void create(T model);
    void update(Long id, T model);
}
