package br.com.system.dao;

import java.util.List;

public interface GenericDAO<T, K> {
    void save(T entity);
    void delete(K id);
}
