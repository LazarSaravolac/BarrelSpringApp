package jwd.barrel.support;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;



import jwd.barrel.model.Burad;
import jwd.barrel.service.BuradService;
import jwd.barrel.web.dto.BuradDTO;

@Component
public class BuradDTOtoBurad implements Converter<BuradDTO,Burad>{

	public java.sql.Date formatiranje(String tekst) {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
		java.sql.Date sqlDate = null;
		try {
			sqlDate = new java.sql.Date(df.parse(tekst).getTime());
			return sqlDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Burad convert(BuradDTO dto) {
		// TODO Auto-generated method stub
//		Date dtoStiglo=dto.stigloM();
//		Date dtoKacenje=dto.kacenjeM();
//		Date dtoIstoceno=dto.istocenoM();
//		String praznoS=dto.getPraznoS();
//		boolean p=dto.vratiPraznoBoolean(praznoS);
//		DateFormat df = new SimpleDateFormat("mm.MM.yyyy.");
//		
//		java.sql.Date sqlDate = null;
//		try {
//			sqlDate = new java.sql.Date(df.parse(dto.getDs()).getTime());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Burad b=new Burad();
		b.setNaziv(dto.getNaziv());
		if(dto.getDani()!=null) {			
			b.setDani(dto.getDani());
		}else {
			b.setDani(0);
		}
		if(dto.getOtpis()!=null) {	
			b.setOtpis(dto.getOtpis());
		}else {
			b.setOtpis(0.0);
		}
		b.setTezina(dto.getTezina());
		if(dto.getTp()!=null) {
			b.setTezinaPrazno(dto.getTp());			
		}else {
			b.setTezinaPrazno(0.0);
		}
		
		b.setStiglo(formatiranje(dto.getDs()));
		
//		if(dto.getDk()!=null) {
//			
//		if(formatiranje(dto.getDk()).compareTo(formatiranje(dto.getDs()))<0) {
//			b=null;
//		}
//		}
		
		if(dto.getDk()!=null && !dto.getDk().equals(""))
		b.setKacenje(formatiranje(dto.getDk()));
		if(dto.getDi()!=null && !dto.getDi().equals(""))
		b.setIstoceno(formatiranje(dto.getDi()));
		
		
		
//		b.setStiglo(BuradDTO.ocitajDatumPravi(dto.getStigloS()));
//		b.setId(dto.getId());
//		b.setDani(dto.getDani());
//		b.setStiglo(dtoStiglo);
//		b.setIstoceno(dtoIstoceno);
//		b.setKacenje(dtoKacenje);
//		b.setNaziv(dto.getNaziv());
//		b.setOtpis(dto.getOtpis());
//		b.setPrazno(p);
//		b.setTezinaPrazno(dto.getTezinaPrazno());
		
		return b;
	}
	
	public List<Burad>convert(List<BuradDTO>d){
		List<Burad>buradi=new ArrayList<>();
		for(BuradDTO b:d) {
			buradi.add(convert(b));
		}
		return buradi;
		
	}

	
	

}
