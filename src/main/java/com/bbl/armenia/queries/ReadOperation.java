package com.bbl.armenia.queries;

import java.util.List;

public interface ReadOperation<T> {
    List<T> getAll();
    T getById(Long id);
}
