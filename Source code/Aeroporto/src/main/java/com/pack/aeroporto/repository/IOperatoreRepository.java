package com.pack.aeroporto.repository;

import org.springframework.data.repository.CrudRepository;

import com.pack.aeroporto.entity.*;

public interface IOperatoreRepository extends CrudRepository<Operatore, Long>{

  Operatore findByEmail(String email);
}
