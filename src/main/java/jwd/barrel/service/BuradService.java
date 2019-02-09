package jwd.barrel.service;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.barrel.model.Burad;



public interface BuradService {
	Burad save(Burad burad);
	void delete(Long id);
	Burad findOne(Long id);
	Page<Burad>findAll(int page);
	
	
	Page<Burad> pretraga(

			@Param("id") Long id,
			@Param("naziv") String naziv, 
			int page);
}
