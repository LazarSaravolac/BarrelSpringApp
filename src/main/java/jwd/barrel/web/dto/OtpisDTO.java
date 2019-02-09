package jwd.barrel.web.dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jwd.barrel.model.PomocnaKlasa;

public class OtpisDTO {
	
	private Long id;
	private String naziv;
	private Double kolicina;
	private String datums;
	private String ds;
	private Long bure;
	
	
	
	
	
	
	
	
	
	public OtpisDTO() {
		super();
	}
	public OtpisDTO(String naziv, Double kolicina, String datums) {
		super();
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.datums = datums;
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
	public String getDatums() {
		return datums;
	}
	public void setDatums(Date d) {
		String s="";
		if(d!=null) {
			
			 s=PomocnaKlasa.DATUMP.format(d);
		}
		this.datums = s;
	}
	public String getDs() {
		return ds;
	}
	public void setDs(String ds) {
		this.ds = ds;
	}
	public Long getBure() {
		return bure;
	}
	public void setBure(Long bure) {
		this.bure = bure;
	}
	
	
	
	
}
