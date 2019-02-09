package jwd.barrel.web.dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.format.annotation.DateTimeFormat;

import jwd.barrel.model.PomocnaKlasa;

public class BuradDTO {
	public static SimpleDateFormat DATUMP = new SimpleDateFormat("dd.MM.yyyy.");
	public static Date ocitajDatumPravi(String stiglos) {
		Date datum = null;
		 
			String tekst = stiglos;
			try {
				java.util.Date utilDatum = DATUMP.parse(tekst);
				datum = new Date(utilDatum.getTime());
			} catch (ParseException ex) {
				System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			}
		
		return datum;
	}
	private Long id;
	private String naziv;
	private String stiglos;
	private String ds;
	private String dk;
	private String di;
		private String kacenjes;
		private String istocenos;
		private Integer dani;
		private Double tezina;
		private String praznoS;
		private Boolean prazno;
		private Double tp;
		private Double tezinaprazno;
		private Double otpis;
		private Date stiglo;
		private Date kacenje;
		private Date istoceno;
		
		public BuradDTO() {
			super();
		}
		
		public BuradDTO(String naziv, String stigloS, String istocenoS, Double tezina, Double tezinaPrazno,
				Double otpis) {
			super();
			this.naziv = naziv;
			this.stiglos = stigloS;
			this.istocenos = istocenoS;
			this.tezina = tezina;
			this.tezinaprazno = tezinaPrazno;
			this.otpis = otpis;
		}

		public Date stigloM() {
			Date datum=null;
			datum=ocitajDatumPravi(getStigloS());
			return datum;
		}
		public Date kacenjeM() {
			Date datum=null;
			datum=ocitajDatumPravi(getKacenjeS());
			return datum;
		}
		public Date istocenoM() {
			Date datum=null;
			datum=ocitajDatumPravi(getIstocenoS());
			return datum;
		}
//		public void praznoB() {
//			if(isPrazno()==false) {
//				setPraznoS("prazno");
//			}else {
//				setPraznoS("nije prazno");
//			}
//		}
		public boolean vratiPraznoBoolean(String s) {
			boolean b=false;
			if(s.equals("prazno")) {
				b=true;
			}
			return b;
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
	
		public Integer getDani() {
			return dani;
		}
		public void setDani(Integer dani) {
			this.dani = dani;
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
		public String getStigloS() {
			return stiglos;
		}
		public void setStigloS(Date d) {
			String s="";
			if(d!=null) {
				
				 s=PomocnaKlasa.DATUMP.format(d);
			}
			this.stiglos = s;
		}
		public String getKacenjeS() {
			return kacenjes;
		}
		public void setKacenjeS(Date d) {
			String s="";	
			if(d!=null) {
				
				 s=PomocnaKlasa.DATUMP.format(d);
			}
			this.kacenjes = s;
		}
		public String getIstocenoS() {
			return istocenos;
		}
		public void setIstocenoS(Date d) {
			String s="";
			if(d!=null) {
				
				 s=PomocnaKlasa.DATUMP.format(d);
			}
			this.istocenos = s;
		}
		public String getPraznoS() {
			return praznoS;
		}
		public void setPraznoS(Boolean p) {
			String praznoS="prazno";
			if(p==null || p==false) {
				praznoS="nije prazno";
			}
			this.praznoS = praznoS;
		}
		public Double getTezina() {
			return tezina;
		}
		public void setTezina(Double tezina) {
			this.tezina = tezina;
		}
		public Boolean getPrazno() {
			return prazno;
		}
		public void setPrazno(Boolean prazno) {
			this.prazno = prazno;
		}

		public String getDs() {
			return ds;
		}
		public String getDk() {
			return dk;
		}
		public String getDi() {
			return di;
		}
		public Double getTp() {
			return tp;
		}
		public void setDk(String naziv) {
			this.dk = naziv;
		}
		public void setDs(String naziv) {
			this.ds = naziv;
		}
		public void setDi(String naziv) {
			this.di = naziv;
		}
	
	

		

		
		
}
