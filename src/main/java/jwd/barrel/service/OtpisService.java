package jwd.barrel.service;

import java.util.List;

import jwd.barrel.model.Otpis;

public interface OtpisService {
	Otpis save(Otpis otpis);
	void delete(Long id);
	Otpis findOne(Long id);
	List<Otpis>findAll();
	
}
