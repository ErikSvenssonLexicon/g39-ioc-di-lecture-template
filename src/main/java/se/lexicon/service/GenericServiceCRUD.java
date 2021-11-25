package se.lexicon.service;

import java.util.Collection;

public interface GenericServiceCRUD <T, FORM> {
    T create(FORM form);
    Collection<T> findAll();
    T findById(Integer id);
    T update(Integer id, FORM form);
    void delete(Integer id);
}
