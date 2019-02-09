package jwd.barrel.web.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.barrel.TestData;
import jwd.barrel.model.Burad;
import jwd.barrel.model.Otpis;
import jwd.barrel.service.BuradService;
import jwd.barrel.service.OtpisService;
import jwd.barrel.support.BuradDTOtoBurad;
import jwd.barrel.support.OtpisDTOtoOtpis;
import jwd.barrel.support.OtpisToOtpisDTO;
import jwd.barrel.web.dto.BuradDTO;
import jwd.barrel.web.dto.OtpisDTO;

@RestController
@RequestMapping(value="/api/otpisi")
public class ApiOtpisController {
	@Autowired
	BuradDTOtoBurad toBurad;
	
	@Autowired
	BuradService buradService;
	
	java.sql.Date dateproba = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	
	
	@Autowired
	OtpisService os;
	
	@Autowired
	OtpisDTOtoOtpis toOtpis;
	
	@Autowired
	OtpisToOtpisDTO toDTO;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<OtpisDTO>> get(){
		return new ResponseEntity<>(toDTO.convert(os.findAll()),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,
			value="/{id}")
public ResponseEntity<OtpisDTO> get(@PathVariable Long id){
		Otpis otpis=os.findOne(id);

		if(otpis==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDTO.convert(otpis),HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<OtpisDTO> add(
			 @RequestBody OtpisDTO novOtpis){
		

		
		
		
		
		
	
//		Otpis otpis = toOtpis.convert(novOtpis); 
		Otpis otpis=new Otpis();
		otpis.setKolicina(novOtpis.getKolicina());
		otpis.setNaziv(novOtpis.getNaziv());
		if(novOtpis.getDs()==null || novOtpis.getDs().equals("")) {			
			otpis.setDatum(dateproba);
		}else {
			otpis.setDatum(TestData.ocitajDatumPravi(novOtpis.getDs()));
		}
		otpis.setBure(novOtpis.getBure());
		Burad bure=new Burad();
		bure=buradService.findOne(novOtpis.getBure());
		
		bure.setOtpis(bure.getOtpis()+otpis.getKolicina());
		os.save(otpis);
		buradService.save(bure);
		return new ResponseEntity<>(toDTO.convert(otpis),
				HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<OtpisDTO> edit(
			@PathVariable Long id,
			 @RequestBody OtpisDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		
		Otpis otpis=new Otpis();
		Otpis o=os.findOne(izmenjen.getId());
		otpis.setId(izmenjen.getId());
		otpis.setKolicina(izmenjen.getKolicina());
		otpis.setNaziv(izmenjen.getNaziv());
		otpis.setDatum(TestData.ocitajDatumPravi(izmenjen.getDs()));
		otpis.setBure(izmenjen.getBure());
		
		
		
		Burad bure=new Burad();
		bure=buradService.findOne(izmenjen.getBure());
		bure.setOtpis(bure.getOtpis()+otpis.getKolicina()-o.getKolicina());
		
		os.save(otpis);
		buradService.save(bure);
		return new ResponseEntity<>(toDTO.convert(otpis),
				HttpStatus.OK);
	}
	
	 @RequestMapping(method=RequestMethod.DELETE,
				value="/{id}")
		public ResponseEntity<Otpis> delete(@PathVariable Long id){
		 
		 os.delete(id);
		 
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	
}
