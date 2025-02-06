package org.klodnicki.service.generic;

import org.klodnicki.exception.NotFoundInDatabaseException;

public interface GenericBasicCrudOperations<T, K, ID> {

    T create(K object);
    void deleteById(ID id) throws NotFoundInDatabaseException;
    T findById(ID id) throws NotFoundInDatabaseException;
}
