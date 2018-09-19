package com.cmssc.unite.unite.service;

public interface BaseService<T> {

    void save(T entity);

    T get(Integer id);

    void delete(Integer id);

    void delete(T entity);

}
