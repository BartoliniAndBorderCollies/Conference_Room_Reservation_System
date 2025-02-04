package org.example.service.generic;

import org.example.DTO.ResponseDTO;

public interface GenericBasicCrudOperations<T, K> {

    T create(K object);
    ResponseDTO delete(K object);

}
