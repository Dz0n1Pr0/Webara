package Klase;

import java.sql.Date;

public class Rezervacija {
	private String klasa,date,brrez;
	private Korisnik korisnik;
	private int brputnika;
	
	public Rezervacija(String brrez, String klasa, String date, Korisnik korisnik, int brputnika) {
		super();
		this.klasa = klasa;
		this.date = date;
		this.korisnik = korisnik;
		this.brrez = brrez;
		this.brputnika = brputnika;
	}

	public Rezervacija() {
		// TODO Auto-generated constructor stub
	}

	public String getKlasa() {
		return klasa;
	}

	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public String getBrrez() {
		return brrez;
	}

	public void setBrrez(String brrez) {
		this.brrez = brrez;
	}

	public int getBrputnika() {
		return brputnika;
	}

	public void setBrputnika(int brputnika) {
		this.brputnika = brputnika;
	}
	
	
}
