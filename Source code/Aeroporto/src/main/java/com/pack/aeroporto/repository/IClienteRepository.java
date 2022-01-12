package com.pack.aeroporto.repository;

import org.springframework.data.repository.CrudRepository;

import com.pack.aeroporto.entity.Aereo;
import com.pack.aeroporto.entity.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, String>{
	Cliente findByCodiceFiscale(String codiceFiscale);

}
