package jwd.barrel.model;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Scanner;


public class PomocnaKlasa {
	public static String ukupnaVrednost() {
		Calendar cal=Calendar.getInstance();
		int godina=cal.get(Calendar.YEAR);
		int dan=cal.get(Calendar.DAY_OF_MONTH);
		int mesec=cal.get(Calendar.MONTH);
		mesec++;
		
		String msc=String.valueOf(mesec);
		if(msc.length()==1) {
			msc="0"+msc;
		}
//		System.out.println(dan);
//		System.out.println(godina);
//		System.out.println(mesec);
		String datumString=""+dan+"."+msc+"."+godina+".";
		return datumString;
	}
	
	public static Date tacanDatum() {
		Date datum = null;
		while (datum == null) {
			String tekst = PomocnaKlasa.ukupnaVrednost();
			try {
				java.util.Date utilDatum = DATUMP.parse(tekst);
				datum = new Date(utilDatum.getTime());
			} catch (ParseException ex) {
				System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			}
		}
		return datum;
	}
	public static SimpleDateFormat DATUMP = new SimpleDateFormat("dd.MM.yyyy.");
public static SimpleDateFormat FORMAT_DATUMA = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
public static SimpleDateFormat DATUM = new SimpleDateFormat("yyyy-MM-dd");
public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
	static Scanner sc = new Scanner(System.in);
	
	//citanje promenljive String
	public static String ocitajTekst(){
		String tekst = "";
		while(tekst == null || tekst.equals(""))
			tekst = sc.nextLine();
		
		return tekst;
	}
		
	//citanje promenljive integer
	public static int ocitajCeoBroj(){
		while (sc.hasNextInt()==false) {
			System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			sc.nextLine();
		}
		int ceoBroj = sc.nextInt();
		sc.nextLine(); //cisti sve sa ulaza sto nije broj ili ostatak teste posla broja
		return ceoBroj;
	}
		
	//citanje promenljive double
	public static float ocitajRealanBroj(){

		while (sc.hasNextFloat()==false) {
			System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			sc.nextLine();
		}
		float realanBroj = sc.nextFloat();
		sc.nextLine(); //cisti sve sa ulaza sto nije broj ili ostatak teste posla broja
		return realanBroj;
	}
	
	
	public static double ocitajRealanBrojDouble(){

		while (sc.hasNextDouble()==false) {
			System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			sc.nextLine();
		}
		double realanBroj = sc.nextDouble();
		sc.nextLine(); //cisti sve sa ulaza sto nije broj ili ostatak teste posla broja
		return realanBroj;
	}
	//citanje promenljive char
	public static char ocitajKarakter(){
		
		String text;
		while ( (text=sc.next())==null || text.length()!=1) {
			System.out.println("GRESKA - Pogresno unsesena vrednost za karakter, pokusajte ponovo: ");
			sc.nextLine();
		}
		char karakter = text.charAt(0);
		return karakter;
	}

	//citanje promenljive char
	public static char ocitajOdlukuOPotvrdi(String tekst){
		System.out.println("Da li zelite " + tekst + " [Y/N]:");
		char odluka = ' ';
		while( !(odluka == 'Y' || odluka == 'N') ){
			odluka = ocitajKarakter();
			if (!(odluka == 'Y' || odluka == 'N')) {
				System.out.println("Opcije su Y ili N");
			}
		}
		return odluka;
	}

	public static Timestamp ocitajDatum() {
		Timestamp datum = null;
		while (datum == null) {
			String tekst = sc.nextLine();
			try {
				java.util.Date utilDatum = FORMAT_DATUMA.parse(tekst);
				datum = new Timestamp(utilDatum.getTime());
			} catch (ParseException ex) {
				System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			}
		}
		return datum;
	}

	
	public static Date ocitajDatumPravi() {
		Date datum = null;
		while (datum == null) {
			String tekst = sc.nextLine();
			try {
				java.util.Date utilDatum = DATUMP.parse(tekst);
				datum = new Date(utilDatum.getTime());
			} catch (ParseException ex) {
				System.out.println("GRESKA - Pogresno unsesena vrednost, pokusajte ponovo: ");
			}
		}
		return datum;
	}
	static boolean isInteger(String s){
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	static boolean isDouble(String s){
		try {
			Double.parseDouble(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	static boolean isBoolean(String s){
		try {
			Boolean.parseBoolean(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	static boolean isDatum(String s) {
		try {
			FORMAT_DATUMA.parse(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
