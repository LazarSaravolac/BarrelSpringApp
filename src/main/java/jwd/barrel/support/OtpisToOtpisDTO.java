package jwd.barrel.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.barrel.model.Otpis;
import jwd.barrel.web.dto.OtpisDTO;

@Component
public class OtpisToOtpisDTO implements Converter<Otpis, OtpisDTO>{

	@Override
	public OtpisDTO convert(Otpis otpis) {
		// TODO Auto-generated method stub
		OtpisDTO dto=new OtpisDTO();
		dto.setId(otpis.getId());
		dto.setKolicina(otpis.getKolicina());
		dto.setNaziv(otpis.getNaziv());
		dto.setDatums(otpis.getDatum());
		dto.setBure(otpis.getBure());
		return dto;
	}
	
	public List<OtpisDTO>convert(List<Otpis>otpisi){
		List<OtpisDTO>dto=new ArrayList<>();
		for(Otpis o:otpisi) {
			dto.add(convert(o));
		}
		return dto;
	}

}
