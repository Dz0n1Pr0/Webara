package Klase;

public class Korisnik {
	private String korime,lozinka,ime,prezime,telefon,email,slika,stanje,tip;

	public Korisnik(String korime, String lozinka, String ime, String prezime, String telefon, String email,
			String slika, String stanje) {
		super();
		this.korime = korime;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.email = email;
		this.slika = slika;
		this.stanje = stanje;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Korisnik() {
		// TODO Auto-generated constructor stub
	}

	public String getKorime() {
		return korime;
	}

	public void setKorime(String korime) {
		this.korime = korime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
