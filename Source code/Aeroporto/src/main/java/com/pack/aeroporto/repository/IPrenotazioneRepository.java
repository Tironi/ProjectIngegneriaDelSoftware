package com.pack.aeroporto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pack.aeroporto.entity.Aereo;
import com.pack.aeroporto.entity.Prenotazione;

public interface IPrenotazioneRepository extends CrudRepository<Prenotazione, String>{
}
