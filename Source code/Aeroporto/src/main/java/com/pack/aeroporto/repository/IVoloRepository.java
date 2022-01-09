package com.pack.aeroporto.repository;

import org.springframework.data.repository.CrudRepository;

import com.pack.aeroporto.model.Volo;

public interface IVoloRepository extends CrudRepository<Volo, String>{
	
}
