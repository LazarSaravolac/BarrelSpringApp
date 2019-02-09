package jwd.barrel.web.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.barrel.TestData;
import jwd.barrel.model.Burad;
import jwd.barrel.service.BuradService;
import jwd.barrel.support.BuradDTOtoBurad;
import jwd.barrel.support.BuradToBuradDTO;
import jwd.barrel.web.dto.BuradDTO;


@RestController
@RequestMapping(value="/api/buradi")
public class ApiBuradController {


DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
	
	@Autowired
	BuradService buradService;
	
	@Autowired
	BuradDTOtoBurad toBurad;
	
	@Autowired
	BuradToBuradDTO toDTO;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/prazno")
	public ResponseEntity<List<BuradDTO>> getprazno(
			@RequestParam(required=false) String naziv,
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="5") Integer velicina){
		
		Page<Burad>buradi;
		if(naziv!=null) {
			buradi=buradService.findAll(page);
		}else {
			buradi=buradService.findAll(page);
		}
	
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(buradi.getTotalPages()) );
		
		List<Burad>bL=new ArrayList<>();
		for(Burad b:buradi.getContent()) {
			if(!b.getPrazno()==true) {
				bL.add(b);
			}
		}
		
		return new ResponseEntity<>(toDTO.convert(bL),headers,HttpStatus.OK);
		
	
	}
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BuradDTO>> get(
			@RequestParam(required=false) Long id,
			@RequestParam(required=false) String naziv,
			@RequestParam(required=false) String dan,
			@RequestParam(required=false) String od,
			@RequestParam(required=false) String doo,
			@RequestParam(defaultValue="0") int page,
			@RequestParam(defaultValue="5") Integer velicina){
	
		HttpHeaders headers = new HttpHeaders();
		Page<Burad>buradi;
		if(naziv!=null || id!=null || dan!=null || od!=null || doo!=null) {
			buradi=buradService.pretraga(id,naziv, page);
			if(dan!=null) {
				List<BuradDTO>dto=new ArrayList<>();
				BuradDTO d=new BuradDTO();
				for(Burad b:buradi.getContent()) {
					d.setDs(df.format(b.getStiglo()));
					if(d.getDs().equals(dan)) {
						dto.add(toDTO.convert(b));
					}
				}
				Integer br=new Integer(dto.size()/5+1);
				headers.add("totalPages", Integer.toString(br) );
				return new ResponseEntity<>(dto,headers,HttpStatus.OK);
				
			}
			
			
			if(od!=null) {
				List<BuradDTO>dto=new ArrayList<>();
				
				Date d1=TestData.ocitajDatumPravi(od);
				Date dati=null;
				for(Burad b:buradi.getContent()) {
					dati=b.getStiglo();
					
					if(d1.compareTo(dati)<=0) {
						dto.add(toDTO.convert(b));
					}
					
				
				}
				Integer br=new Integer(dto.size()/5+1);
				headers.add("totalPages", Integer.toString(br) );
				return new ResponseEntity<>(dto,headers,HttpStatus.OK);
			}
			
			if(doo!=null) {
				List<BuradDTO>dto=new ArrayList<>();
				
				Date d1=TestData.ocitajDatumPravi(doo);
				Date dati=null;
				for(Burad b:buradi.getContent()) {
					dati=b.getStiglo();
					
					if(d1.compareTo(dati)>=0) {
						dto.add(toDTO.convert(b));
					}
					
				
				}
				Integer br=new Integer(dto.size()/5+1);
				headers.add("totalPages", Integer.toString(br) );
				return new ResponseEntity<>(dto,headers,HttpStatus.OK);
			}
			
		}else {
			buradi=buradService.findAll(page);
		}
	
		
		headers.add("totalPages", Integer.toString(buradi.getTotalPages()) );
		
		
		
		return new ResponseEntity<>(toDTO.convert(buradi.getContent()),headers,HttpStatus.OK);
		
	
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public ResponseEntity<BuradDTO> get(@PathVariable Long id){
		Burad bure=buradService.findOne(id);
		
		if(bure==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDTO.convert(bure),HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<BuradDTO> add(
			 @RequestBody BuradDTO novoBure){
		if(novoBure.getDs()!=null && novoBure.getDk()!=null && !novoBure.getDk().equals("")){
			
		
		if(toBurad.formatiranje(novoBure.getDk()).compareTo(toBurad.formatiranje(novoBure.getDs()))<0) {

			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		}
		
		if(novoBure.getDi()!=null && novoBure.getDk()!=null  && !novoBure.getDk().equals("")&& !novoBure.getDi().equals("")){
		if(toBurad.formatiranje(novoBure.getDi()).compareTo(toBurad.formatiranje(novoBure.getDk()))<0) {

			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		}
		if(novoBure.getDi()!=null && novoBure.getDs()!=null && !novoBure.getDi().equals("")){
		if(toBurad.formatiranje(novoBure.getDi()).compareTo(toBurad.formatiranje(novoBure.getDs()))<0) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		}
		
		Burad bure = toBurad.convert(novoBure); 
		if(novoBure.getDi()!=null) {
			bure.setPrazno(true);
		}else {
			bure.setPrazno(false);
		}
		
		if(novoBure.getDi()!=null && novoBure.getDk()!=null && novoBure.getDs()!=null && !novoBure.getDi().equals("") && !novoBure.getDs().equals("") && !novoBure.getDk().equals("")) {
			Date d1=toBurad.formatiranje(novoBure.getDk());
			Date d2=toBurad.formatiranje(novoBure.getDi());
			long broj=getDifferenceDays(d1, d2);
			int broji=(int)broj;
			Integer br=Integer.valueOf(broji);
			br++;
			bure.setDani(br);
		}
		buradService.save(bure);
		
		return new ResponseEntity<>(toDTO.convert(bure),
				HttpStatus.CREATED);
	}
	
	public static long getDifferenceDays(Date d1, Date d2) {
	    long diff = d2.getTime() - d1.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<BuradDTO> edit(
			@PathVariable Long id,
			 @RequestBody BuradDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if(izmenjen.getDs()!=null && izmenjen.getDk()!=null && !izmenjen.getDk().equals("")){
			
			
			if(toBurad.formatiranje(izmenjen.getDk()).compareTo(toBurad.formatiranje(izmenjen.getDs()))<0) {

				 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			}
			
			if(izmenjen.getDi()!=null && izmenjen.getDk()!=null  && !izmenjen.getDk().equals("")&& !izmenjen.getDi().equals("")){
			if(toBurad.formatiranje(izmenjen.getDi()).compareTo(toBurad.formatiranje(izmenjen.getDk()))<0) {

				 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			}
			if(izmenjen.getDi()!=null && izmenjen.getDs()!=null && !izmenjen.getDi().equals("")){
			if(toBurad.formatiranje(izmenjen.getDi()).compareTo(toBurad.formatiranje(izmenjen.getDs()))<0) {
				
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			}
		
			
			
		Burad bure = toBurad.convert(izmenjen);
		if(izmenjen.getDi()!=null) {
			bure.setPrazno(true);
		}else {
			bure.setPrazno(false);
		}
		
		if(izmenjen.getDi()!=null && !izmenjen.getDi().equals("")) {
			bure.setPrazno(true);
		}else {
			bure.setPrazno(false);
		}
		
		if(izmenjen.getDi()!=null && izmenjen.getDk()!=null && izmenjen.getDs()!=null && !izmenjen.getDi().equals("") && !izmenjen.getDs().equals("") && !izmenjen.getDk().equals("")) {
			Date d1=toBurad.formatiranje(izmenjen.getDk());
			Date d2=toBurad.formatiranje(izmenjen.getDi());
			long broj=getDifferenceDays(d1, d2);
			int broji=(int)broj;
			Integer br=Integer.valueOf(broji);
			br++;
			bure.setDani(br);
		}else {
			bure.setDani(0);
		}
		bure.setId(izmenjen.getId());
		buradService.save(bure);
		
		return new ResponseEntity<>(toDTO.convert(bure),
				HttpStatus.OK);
	}
	
	 @RequestMapping(method=RequestMethod.DELETE,
				value="/{id}")
		public ResponseEntity<Burad> delete(@PathVariable Long id){
		 
		 buradService.delete(id);
		 
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	
	
	
	
}
