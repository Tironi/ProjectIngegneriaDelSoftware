package com.pack.aeroporto.repository;

import org.springframework.data.repository.CrudRepository;

import com.pack.aeroporto.entity.Aereo;
import com.pack.aeroporto.entity.Cliente;
import com.pack.aeroporto.entity.Operatore;

public interface IClienteRepository extends CrudRepository<Cliente, String>{
	
	Cliente findByCodiceFiscale(String codiceFiscale);
	Cliente findByEmail(String email);
	Cliente findByPSW(String psw);

}
