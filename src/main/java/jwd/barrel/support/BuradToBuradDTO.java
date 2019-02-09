package jwd.barrel.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.barrel.model.Burad;
import jwd.barrel.web.dto.BuradDTO;

@Component
public class BuradToBuradDTO implements Converter<Burad, BuradDTO> {

	
	
	
	@Override
	public BuradDTO convert(Burad burad) {
		// TODO Auto-generated method stub
		BuradDTO dto=new BuradDTO();
		dto.setId(burad.getId());
		dto.setDani(burad.getDani());
		dto.setStigloS(burad.getStiglo());
		dto.setKacenjeS(burad.getKacenje());
		dto.setIstocenoS(burad.getIstoceno());
		dto.setTezina(burad.getTezina());
		dto.setNaziv(burad.getNaziv());
		dto.setPrazno(burad.getPrazno());
		dto.setPraznoS(burad.getPrazno());
		dto.setOtpis(burad.getOtpis());
		dto.setTezinaPrazno(burad.getTezinaPrazno());
		return dto;
	}
	
	public List<BuradDTO>convert(List<Burad>buradi){
		List<BuradDTO>dto=new ArrayList<>();
		for(Burad b:buradi) {
			dto.add(convert(b));
		}
		return dto;
	}
	
	

}
