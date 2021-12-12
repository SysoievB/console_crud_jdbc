package com.console.crud.jdbc.app.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    T save(T data);

    List<T> getAll();

    T getById(ID id);

    void update(ID id, T data);

    void deleteById(ID id);
}