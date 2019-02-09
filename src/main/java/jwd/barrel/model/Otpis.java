package jwd.barrel.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eotpis")
public class Otpis {

	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	private Double kolicina;
	private Date datum;
	private Long bure;
	public Long getBure() {
		return bure;
	}
	public void setBure(Long bure) {
		this.bure = bure;
	}
	public Otpis() {
		super();
	}
	public Otpis(Long id, String naziv, Double kolicina, Date datum) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.datum = datum;
	}
	public Otpis(String naziv, Double kolicina, Date datum) {
		super();
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.datum = datum;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Double getKolicina() {
		return kolicina;
	}
	public void setKolicina(Double kolicina) {
		this.kolicina = kolicina;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
}
