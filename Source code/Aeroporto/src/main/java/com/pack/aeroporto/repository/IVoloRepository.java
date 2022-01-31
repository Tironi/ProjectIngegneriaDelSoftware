package com.pack.aeroporto.repository;

import org.springframework.data.repository.CrudRepository;

import com.pack.aeroporto.entity.Aereo;
import com.pack.aeroporto.entity.Volo;

public interface IVoloRepository extends CrudRepository<Volo, Long>{
	
	Volo findByCodiceVolo(Long codiceVolo);
}
