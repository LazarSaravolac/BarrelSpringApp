package jwd.barrel.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eburad")
public class Burad {

	@Id
	@GeneratedValue
	private Long id;
	private Double tezina;
	private String naziv;
	private Date stiglo;
	private Date kacenje;
	private Date istoceno;
	private Integer dani;
	private Boolean prazno;
	private Double tezinaprazno;
	private Double otpis;
		public Burad() {
			super();
		}
		public Burad(Long id, Double tezina, String naziv, Date stiglo, Date kacenje, Date istoceno, Integer dani,
				Boolean prazno, Double tezinaPrazno, Double otpis) {
			super();
			this.id = id;
			this.tezina = tezina;
			this.naziv = naziv;
			this.stiglo = stiglo;
			this.kacenje = kacenje;
			this.istoceno = istoceno;
			this.dani = dani;
			this.prazno = prazno;
			this.tezinaprazno = tezinaPrazno;
			this.otpis = otpis;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Double getTezina() {
			return tezina;
		}
		public void setTezina(Double tezina) {
			this.tezina = tezina;
		}
		public String getNaziv() {
			return naziv;
		}
		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}
		public Date getStiglo() {
			return stiglo;
		}
		public void setStiglo(Date stiglo) {
			this.stiglo = stiglo;
		}
		public Date getKacenje() {
			return kacenje;
		}
		public void setKacenje(Date kacenje) {
			this.kacenje = kacenje;
		}
		public Date getIstoceno() {
			return istoceno;
		}
		public void setIstoceno(Date istoceno) {
			this.istoceno = istoceno;
		}
		public Integer getDani() {
			return dani;
		}
		public void setDani(Integer dani) {
			this.dani = dani;
		}
		public Boolean getPrazno() {
			return prazno;
		}
		public void setPrazno(Boolean prazno) {
			this.prazno = prazno;
		}
		public Double getTezinaPrazno() {
			return tezinaprazno;
		}
		public void setTezinaPrazno(Double tezinaPrazno) {
			this.tezinaprazno = tezinaPrazno;
		}
		public Double getOtpis() {
			return otpis;
		}
		public void setOtpis(Double otpis) {
			this.otpis = otpis;
		}
	

		
		
}
