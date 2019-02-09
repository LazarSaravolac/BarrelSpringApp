package jwd.barrel.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jwd.barrel.model.Burad;
import jwd.barrel.repository.BuradRepository;
import jwd.barrel.service.BuradService;

@Service
public class JpaBuradService implements BuradService {
	
	@Autowired
	private BuradRepository bR;
	
	
	@Override
	public Burad save(Burad burad) {
		// TODO Auto-generated method stub
		return bR.save(burad);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		bR.delete(id);
	}

	@Override
	public Burad findOne(Long id) {
		// TODO Auto-generated method stub
		return bR.findOne(id);
	}

	@Override
	public Page<Burad> findAll(int page) {
		// TODO Auto-generated method stub
		return bR.findAll(new PageRequest(page, 5));
	}



	@Override
	public Page<Burad> pretraga(Long id,String naziv, int page) {
		// TODO Auto-generated method stub
		return bR.pretraga(id,naziv, new PageRequest(page, 5));
	}

}
