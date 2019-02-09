package jwd.barrel;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import jwd.barrel.model.Burad;

import jwd.barrel.model.Otpis;

import jwd.barrel.service.BuradService;

import jwd.barrel.service.OtpisService;



@Component
public class TestData {
	public static SimpleDateFormat DATUMP = new SimpleDateFormat("dd.MM.yyyy.");
	public static Date ocitajDatumPravi(String datumS) {
		Date datum = null;
	
			String tekst = datumS;
			try {
				java.util.Date utilDatum = DATUMP.parse(tekst);
				datum = new Date(utilDatum.getTime());
			} catch (ParseException ex) {
				System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			}
		
		return datum;
	}

	
	@Autowired
	BuradService buradService;

	@Autowired
	OtpisService os;
	
	@PostConstruct
	public void init(){
//		Burad b1=new Burad();
//		b1.setNaziv("bure1");
//		b1.setOtpis(2.1);
//		b1.setTezinaPrazno(1.2);
//		b1.setStiglo(ocitajDatumPravi("12.12.2012."));
//		b1.setTezina(21.1);
//		b1.setKacenje(ocitajDatumPravi("11.11.2013."));
//		b1.setPrazno(false);
//		buradService.save(b1);
//	
//		
//		Burad b2=new Burad();
//		b2.setNaziv("bure2");
//		b2.setOtpis(2.1);
//		b2.setTezinaPrazno(1.2);
//		b2.setStiglo(ocitajDatumPravi("02.12.2012."));
//		b2.setTezina(21.1);
//		b2.setKacenje(ocitajDatumPravi("11.11.2013."));
//		b2.setPrazno(true);
//		buradService.save(b2);
//	
//		Otpis o1=new Otpis();
//		o1.setDatum(ocitajDatumPravi("11.11.2010."));
//		o1.setKolicina(21.2);
//		o1.setNaziv("Sunshine");
//		o1.setBure(2L);
//		os.save(o1);
//		
//		
//		Otpis o2=new Otpis();
//		o2.setDatum(ocitajDatumPravi("12.11.2010."));
//		o2.setKolicina(31.2);
//		o2.setNaziv("APA");
//		o2.setBure(1L);
//		os.save(o2);

		
		
		
		
		
	}
}
