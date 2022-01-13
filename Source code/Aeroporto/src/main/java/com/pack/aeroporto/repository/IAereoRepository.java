package com.pack.aeroporto.repository;

import org.springframework.data.repository.CrudRepository;

import com.pack.aeroporto.entity.Aereo;
import com.pack.aeroporto.entity.Volo;

public interface IAereoRepository extends CrudRepository<Aereo, Long>{
	
	Aereo findByCodiceAereo(Long codiceAereo);
}
