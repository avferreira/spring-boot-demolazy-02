package com.devsuperior.demolazy.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demolazy.util.Convertible;

public interface GenericServiceSave<T extends Convertible<DTO>, DTO, ID> {	
	JpaRepository<T, ID> getRepository();	
	T getEntity(DTO dto);	
	
	default T save(DTO dto) {
		T entity = getEntity(dto);
		return getRepository().save(entity);
	};
	
	default List<T> saveAll(List<DTO> listDTO) {
		List<T> list = listDTO.stream().map(x -> getEntity(x)).collect(Collectors.toList());
		return getRepository().saveAll(list);
	};
	
	default T saveAndFlush(DTO dto) {
		T entity = getEntity(dto);
		return getRepository().saveAndFlush(entity);
	};
	
	
    /*
	default T save(T entity) {		
		return getRepository().save(entity);
	};
	
	default List<T> saveAll(List<T> list) {
		return getRepository().saveAll(list);
	};
	
	default T saveAndFlush(T entity) {
		return getRepository().saveAndFlush(entity);
	};
	*/

}
