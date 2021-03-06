package com.devsuperior.demolazy.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demolazy.util.Convertible;

public interface GenericServiceDelete<T extends Convertible<DTO>, DTO, ID> {
    JpaRepository<T, ID> getRepository();    
    
    default void delete(T entity) {        
        getRepository().delete(entity);
    };
    
    default void deleteById(ID id) {        
        getRepository().deleteById(id);
    };

}
