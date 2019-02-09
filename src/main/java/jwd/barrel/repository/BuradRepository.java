package jwd.barrel.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.barrel.model.Burad;

@Repository
public interface BuradRepository extends PagingAndSortingRepository<Burad, Long> {

	Page<Burad>findBuradById(Long buradId,Pageable pageRequest);
	
	@Query("SELECT b FROM Burad b WHERE "
			+ "(:naziv IS NULL or b.naziv like :naziv ) AND"
			+ "(:id IS NULL OR b.id = :id)"
			)
	Page<Burad> pretraga(
			@Param("id") Long id, 
			@Param("naziv") String naziv, 
			Pageable pageRequest);
			
}
