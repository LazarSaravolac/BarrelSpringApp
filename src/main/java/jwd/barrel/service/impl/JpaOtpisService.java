package jwd.barrel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.barrel.model.Otpis;
import jwd.barrel.repository.OtpisRepository;
import jwd.barrel.service.OtpisService;

@Service
public class JpaOtpisService implements OtpisService {

	@Autowired
	OtpisRepository or;
	
	
	@Override
	public Otpis save(Otpis otpis) {
		// TODO Auto-generated method stub
		return or.save(otpis);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		or.delete(id);
	}

	@Override
	public Otpis findOne(Long id) {
		// TODO Auto-generated method stub
		return or.findOne(id);
	}

	@Override
	public List<Otpis> findAll() {
		// TODO Auto-generated method stub
		return or.findAll();
	}

}
