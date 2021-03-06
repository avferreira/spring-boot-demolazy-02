package com.devsuperior.demolazy.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demolazy.util.Convertible;

public interface GenericService<T extends Convertible<DTO>, DTO, ID> {	
	JpaRepository<T, ID> getRepository();
	
	default DTO findById(ID id) {
		Optional<T> result = getRepository().findById(id);  	
		return result.get().convertToDTO();
	};
		
	default List<DTO> findAll() {
		List<T> list = getRepository().findAll();
		return list.stream().map(x -> x.convertToDTO()).collect(Collectors.toList());
	}
	
	default List<DTO> findAll(Sort sort) {
		List<T> list = getRepository().findAll(sort);
		return list.stream().map(x -> x.convertToDTO()).collect(Collectors.toList());
	}
		
}
