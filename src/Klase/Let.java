package Klase;

import java.util.Date;
import java.util.HashMap;

public class Let {
	private String br,model,klasa,date;
	private Destinacija pocetna,krajnja;
	private HashMap<String,Rezervacija> rezervacije = new HashMap<String,Rezervacija>();
	private int cena,mestab,mestap,mestae;
	
	public Let(String br, String model, String klasa, Destinacija pocetna, Destinacija krajnja,
			HashMap<String, Rezervacija> rezervacije, int cena, int mestab, int mestap, int mestae, String date) {
		super();
		this.br = br;
		this.model = model;
		this.klasa = klasa;
		this.pocetna = pocetna;
		this.krajnja = krajnja;
		this.rezervacije = rezervacije;
		this.cena = cena;
		this.mestab = mestab;
		this.mestap = mestap;
		this.mestae = mestae;
		this.date = date;
	}

	public String getBr() {
		return br;
	}

	public void setBr(String br) {
		this.br = br;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getKlasa() {
		return klasa;
	}

	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}

	public Destinacija getPocetna() {
		return pocetna;
	}

	public void setPocetna(Destinacija pocetna) {
		this.pocetna = pocetna;
	}

	public Destinacija getKrajnja() {
		return krajnja;
	}

	public void setKrajnja(Destinacija krajnja) {
		this.krajnja = krajnja;
	}

	public HashMap<String, Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(HashMap<String, Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public int getMestab() {
		return mestab;
	}

	public void setMestab(int mestab) {
		this.mestab = mestab;
	}

	public int getMestap() {
		return mestap;
	}

	public void setMestap(int mestap) {
		this.mestap = mestap;
	}

	public int getMestae() {
		return mestae;
	}

	public void setMestae(int mestae) {
		this.mestae = mestae;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
