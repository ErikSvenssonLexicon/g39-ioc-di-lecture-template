package se.lexicon.dao;

import java.util.Collection;
import java.util.Optional;

public interface GenericCrud <T>{
    T save(T entity);
    Optional<T> findById(Integer id);
    Collection<T> findAll();
    void delete(T entity);
}
