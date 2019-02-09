package jwd.barrel.web.dto;

public class ProbaDTO {
	private Long id;
	private String naziv;
	private Double tezina;
	public ProbaDTO() {
		super();
	}
	public ProbaDTO(Long id, String naziv, Double tezina) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tezina = tezina;
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
	public Double getTezina() {
		return tezina;
	}
	public void setTezina(Double tezina) {
		this.tezina = tezina;
	}
}
