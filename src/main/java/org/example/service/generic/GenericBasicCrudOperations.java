package org.example.service.generic;

import org.example.DTO.ResponseDTO;

public interface GenericBasicCrudOperations<T, K, ID> {

    T create(K object);
    ResponseDTO deleteById(ID id);

}
