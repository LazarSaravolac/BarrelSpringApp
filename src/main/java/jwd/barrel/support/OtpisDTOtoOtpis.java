package jwd.barrel.support;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.barrel.model.Otpis;

import jwd.barrel.web.dto.OtpisDTO;

@Component
public class OtpisDTOtoOtpis implements Converter<OtpisDTO,Otpis>{

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
	public Otpis convert(OtpisDTO dto) {
		// TODO Auto-generated method stub
		
		Otpis o=new Otpis();
	
		o.setKolicina(dto.getKolicina());
		o.setNaziv(dto.getNaziv());
		o.setDatum(formatiranje(dto.getDatums()));
		o.setBure(dto.getBure());
		return o;
	}
	
	public List<Otpis>convert(List<OtpisDTO>dto){
		List<Otpis>lista=new ArrayList<>();
		for(OtpisDTO d:dto) {
			
			lista.add(convert(d));
		}
		return lista;
	}

}
