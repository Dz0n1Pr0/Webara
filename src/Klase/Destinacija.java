package Klase;

public class Destinacija {
	private String destinacija,drzava,naziv,kod,lokacija,slika,stanje;

	public Destinacija(String destinacija, String drzava, String naziv, String kod, String lokacija, String slika,
			String stanje) {
		super();
		this.destinacija = destinacija;
		this.drzava = drzava;
		this.naziv = naziv;
		this.kod = kod;
		this.lokacija = lokacija;
		this.slika = slika;
		this.stanje = stanje;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getLokacija() {
		return lokacija;
	}

	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public String getStanje() {
		return stanje;
	}

	public void setStanje(String stanje) {
		this.stanje = stanje;
	}
	
	
}
