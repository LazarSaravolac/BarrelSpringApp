package jwd.barrel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.barrel.model.Otpis;

@Repository
public interface OtpisRepository extends JpaRepository<Otpis, Long>{

}
