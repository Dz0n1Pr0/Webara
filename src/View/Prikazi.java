package View;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import Klase.Destinacija;
import Klase.Korisnik;
import Klase.Let;
import Klase.Rezervacija;
import paket.httpd;

public class Prikazi {
	
	
	public static void filterPretragaLetNastavak(String resource, OutputStream outputStream, List<Let> letList) {
		// TODO Auto-generated method stub
		
		PrintStream out = new PrintStream(outputStream);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo2\">");
		out.println("	<table>");
		
		out.println("		<tr>");
		out.println("			<th>Broj</th>");
		out.println("			<th>Pocetna destinacija</th>");
		out.println("			<th>Krajnja destinacija</th>");
		out.println("			<th>Cena</th>");
		out.println("			<th>Model</th>");
		out.println("			<th>Mesta u prvoj</th>");
		out.println("			<th>Mesta u biznis</th>");
		out.println("			<th>Mesta u ekonomskoj</th>");
		out.println("			<th>Datum</th>");
		out.println("			<th>Klasa</th>");
		out.println("		</tr>");
							for(Let let : letList){
		out.println("		<tr>");
		out.println("			<td> " + let.getBr() + " </td>");
		out.println("			<td>" + let.getPocetna().getDestinacija() +  " </td>");
		out.println("			<td>" + let.getKrajnja().getDestinacija() +  "</td>");
		out.println("			<td>" + let.getCena() +  "</td>");
		out.println("			<td>" + let.getModel() +  "</td>");
		out.println("			<td>" + let.getMestap() +  "</td>");
		out.println("			<td>" + let.getMestab() +  "</td>");
		out.println("			<td>" + let.getMestae() +  "</td>");
		out.println("			<td>" + let.getDate() +  "</td>");
		out.println("			<td>" + let.getKlasa() +  "</td>");
		out.println("		</tr>");
							}
		out.println("	</table>");
		out.println("<a href=\"http://localhost/glavni?user="+httpd.korisnik.getKorime()+"&pass="+httpd.korisnik.getLozinka()+"\">Meni</a>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public static void filterPretraga(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		System.out.println("KAKO NISAM ODOSOSO");
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = httpd.getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/FiPi\">");
		out.println("		<p>Po cemu filtrirati:</p><select name=\"nacin\">");
		out.println("			<option value=\"Datum\">Datum</option>");
		out.println("			<option value=\"Klasa\">Klasa</option>");
		out.println("			<option value=\"Br\">Broj leta</option>");
		out.println("		</select>");
		out.println("		<p>Pocetna destinacija: </p><input type=\"text\" name=\"poc\" />");
		out.println("		<p>Krajnja destinacija: </p><input type=\"text\" name=\"kraj\" /><br>");
		out.println("		<p>Drzava: </p><input type=\"text\" name=\"drzava\" />");
		out.println("		<p>Datum: </p><input type=\"date\" name=\"date\" /><br>");

		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"pretrazi\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
	
	
	public static void pretragaPrikazLet(String resource, OutputStream outputStream, HashMap<String, Let> temp) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo2\">");
		out.println("	<table>");
		
		out.println("		<tr>");
		out.println("			<th>Broj</th>");
		out.println("			<th>Pocetna destinacija</th>");
		out.println("			<th>Krajnja destinacija</th>");
		out.println("			<th>Cena</th>");
		out.println("			<th>Model</th>");
		out.println("			<th>Mesta u prvoj</th>");
		out.println("			<th>Mesta u biznis</th>");
		out.println("			<th>Mesta u ekonomskoj</th>");
		out.println("			<th>Datum</th>");
		out.println("			<th>Klasa</th>");
		out.println("		</tr>");
							for(Let let : temp.values()){
		out.println("		<tr>");
		out.println("			<td> " + let.getBr() + " </td>");
		out.println("			<td>" + let.getPocetna().getDestinacija() +  " </td>");
		out.println("			<td>" + let.getKrajnja().getDestinacija() +  "</td>");
		out.println("			<td>" + let.getCena() +  "</td>");
		out.println("			<td>" + let.getModel() +  "</td>");
		out.println("			<td>" + let.getMestap() +  "</td>");
		out.println("			<td>" + let.getMestab() +  "</td>");
		out.println("			<td>" + let.getMestae() +  "</td>");
		out.println("			<td>" + let.getDate() +  "</td>");
		out.println("			<td>" + let.getKlasa() +  "</td>");
		out.println("		</tr>");
							}
		out.println("	</table>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public static void pretragaLet(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = httpd.getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/letPret\">");
		out.println("		<p>Pocetna destinacija: </p><input type=\"text\" name=\"poc\" />");
		out.println("		<p>Krajnja destinacija: </p><input type=\"text\" name=\"kraj\" /><br>");
		out.println("		<p>Drzava: </p><input type=\"text\" name=\"drzava\" />");
		out.println("		<p>Datum: </p><input type=\"date\" name=\"date\" /><br>");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"pretrazi\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

	public static void filterPrikazLet(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = httpd.getParameter(resource);
		
		List<Let> letList = new ArrayList<>(httpd.letovi.values());
		if(podaci.get("nacin").equals("Datum")){
			Collections.sort(letList, Comparator.comparing(Let::getDate));
		}else if(podaci.get("nacin").equals("Klasa")){
			Collections.sort(letList, Comparator.comparing(Let::getKlasa));
		}else{
			Collections.sort(letList, Comparator.comparing(Let::getBr));
		}
		
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo2\">");
		out.println("	<table>");
		
		out.println("		<tr>");
		out.println("			<th>Broj</th>");
		out.println("			<th>Pocetna destinacija</th>");
		out.println("			<th>Krajnja destinacija</th>");
		out.println("			<th>Cena</th>");
		out.println("			<th>Model</th>");
		out.println("			<th>Mesta u prvoj</th>");
		out.println("			<th>Mesta u biznis</th>");
		out.println("			<th>Mesta u ekonomskoj</th>");
		out.println("			<th>Datum</th>");
		out.println("			<th>Klasa</th>");
		out.println("		</tr>");
							for(Let let : letList){
		out.println("		<tr>");
		out.println("			<td> " + let.getBr() + " </td>");
		out.println("			<td>" + let.getPocetna().getDestinacija() +  " </td>");
		out.println("			<td>" + let.getKrajnja().getDestinacija() +  "</td>");
		out.println("			<td>" + let.getCena() +  "</td>");
		out.println("			<td>" + let.getModel() +  "</td>");
		out.println("			<td>" + let.getMestap() +  "</td>");
		out.println("			<td>" + let.getMestab() +  "</td>");
		out.println("			<td>" + let.getMestae() +  "</td>");
		out.println("			<td>" + let.getDate() +  "</td>");
		out.println("			<td>" + let.getKlasa() +  "</td>");
		out.println("		</tr>");
							}
		out.println("	</table>");
		out.println("<a href=\"http://localhost/glavni?user="+httpd.korisnik.getKorime()+"&pass="+httpd.korisnik.getLozinka()+"\">Meni</a>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		
	}

	public static void filterLet(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = httpd.getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/filtPrikaz\">");
		out.println("		<p>Po cemu filtrirati:</p><select name=\"nacin\">");
		out.println("			<option value=\"Datum\">Datum</option>");
		out.println("			<option value=\"Klasa\">Klasa</option>");
		out.println("			<option value=\"Br\">Broj leta</option>");
		out.println("		</select>");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"filtriraj\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
	}
	
	public static void izmenaLetUnos(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = httpd.getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/letChangeOK\">");
		out.println("		<input type=\"hidden\" name=\"letStari\" value=\""+podaci.get("let")+"\" />");
		out.println("		<p>Broj leta: </p><input type=\"text\" name=\"let\" />");
		out.println("		<p>Pocetna destinacija: </p><select name=\"poc\">");
							for(Destinacija ds : httpd.destinacije.values()){
		out.println("			<option value=\""+ds.getDestinacija()+"\">"+ds.getDestinacija()+"</option>");
							}
		out.println("		</select>");
		out.println("		<p>Krajnja destinacija: </p><select name=\"kraj\">");
							for(Destinacija ds : httpd.destinacije.values()){
		out.println("			<option value=\""+ds.getDestinacija()+"\">"+ds.getDestinacija()+"</option>");
							}
		out.println("		</select>");					
		out.println("		<p>Cena: </p><input type=\"text\" name=\"cena\" />");
		out.println("		<p>Model: </p><input type=\"text\" name=\"model\" />");
		out.println("		<p>Mesta prve klase: </p><input type=\"text\" name=\"mestap\" />");
		out.println("		<p>Mesta biznis klase: </p><input type=\"text\" name=\"mestab\" />");
		out.println("		<p>Mesta ekonomske klase: </p><input type=\"text\" name=\"mestae\" />");
		out.println("		<p>Datum: </p><input type=\"date\" name=\"date\" /><br>");
		out.println("		<p>Klasa: </p><select name=\"klasa\">");
		out.println("			<option value=\"Carter\">Carter</option>");
		out.println("			<option value=\"Regionalni\">Regionalni</option>");
		out.println("			<option value=\"Prekookeanski\">Prekookeanski</option>");
		out.println("		</select>");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"Add\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}

	public static void izmenaLetPoc(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo4\">");
		out.println("	<table>");
		
		out.println("		<tr>");
		out.println("			<th>Broj</th>");
		out.println("			<th>Pocetna destinacija</th>");
		out.println("			<th>Krajnja destinacija</th>");
		out.println("			<th>Cena</th>");
		out.println("			<th>Model</th>");
		out.println("			<th>Mesta u prvoj</th>");
		out.println("			<th>Mesta u biznis</th>");
		out.println("			<th>Mesta u ekonomskoj</th>");
		out.println("			<th>Datum</th>");
		out.println("			<th>Klasa</th>");
		out.println("			<th colspan=\"2\"></th>");
		out.println("		</tr>");
							for(Let let : httpd.letovi.values()){
		out.println("		<tr>");
		out.println("			<td> " + let.getBr() + " </td>");
		out.println("			<td>" + let.getPocetna().getDestinacija() +  " </td>");
		out.println("			<td>" + let.getKrajnja().getDestinacija() +  "</td>");
		out.println("			<td>" + let.getCena() +  "</td>");
		out.println("			<td>" + let.getModel() +  "</td>");
		out.println("			<td>" + let.getMestap() +  "</td>");
		out.println("			<td>" + let.getMestab() +  "</td>");
		out.println("			<td>" + let.getMestae() +  "</td>");
		out.println("			<td>" + let.getDate() +  "</td>");
		out.println("			<td>" + let.getKlasa() +  "</td>");
		out.println("			<td><a href=\"http://localhost/izmeniLet?let="+let.getBr()+"\">Izmeni</a></td>");
		out.println("			<td><a href=\"http://localhost/obrisiLet?let="+let.getBr()+"\">Obrisi</a></td>");
		out.println("		</tr>");
							}
		out.println("	</table>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public static void addLet(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		
		PrintStream out = new PrintStream(outputStream);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/letAddSucc\">");
		out.println("		<p>Broj leta: </p><input type=\"text\" name=\"let\" />");
		out.println("		<p>Pocetna destinacija: </p><select name=\"poc\">");
						for(Destinacija ds : httpd.destinacije.values()){
		out.println("			<option value=\""+ds.getDestinacija()+"\">"+ds.getDestinacija()+"</option>");
						}
		out.println("		</select>");
		out.println("		<p>Krajnja destinacija: </p><select name=\"kraj\">");
						for(Destinacija ds : httpd.destinacije.values()){
		out.println("			<option value=\""+ds.getDestinacija()+"\">"+ds.getDestinacija()+"</option>");
							}
		out.println("		</select>");			
		out.println("		<p>Cena: </p><input type=\"text\" name=\"cena\" />");
		out.println("		<p>Model: </p><input type=\"text\" name=\"model\" />");
		out.println("		<p>Mesta prve klase: </p><input type=\"text\" name=\"mestap\" />");
		out.println("		<p>Mesta biznis klase: </p><input type=\"text\" name=\"mestab\" />");
		out.println("		<p>Mesta ekonomske klase: </p><input type=\"text\" name=\"mestae\" />");
		out.println("		<p>Datum: </p><input type=\"date\" name=\"date\" /><br>");
		out.println("		<p>Klasa: </p><select name=\"klasa\">");
		out.println("			<option value=\"Carter\">Carter</option>");
		out.println("			<option value=\"Regionalni\">Regionalni</option>");
		out.println("			<option value=\"Prekookeanski\">Prekookeanski</option>");
		out.println("		</select>");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"Add\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public static void izmenaDestPopuna(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = httpd.getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/changeDesSuc\">");
		out.println("		<input type=\"hidden\" name=\"destStara\" value=\""+podaci.get("dest")+"\"/>");
		out.println("		<p>Destinacija: </p><input type=\"text\" name=\"dest\" />");
		out.println("		<p>Država: </p><input type=\"text\" name=\"drzava\" />");
		out.println("		<p>Naziv aerodroma: </p><input type=\"text\" name=\"naziv\" />");
		out.println("		<p>Kod aerodroma: </p><input type=\"text\" name=\"kod\" />");
		out.println("		<p>Lokacija: </p><input type=\"text\" name=\"lok\" />");
		out.println("		<p>Slika: </p><input type=\"file\" name=\"img\" /><br>");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"Posalji\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
	}

	public static void izmenaDestPoc(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo3\">");
		out.println("	<table>");
		out.println("		<tr>");
		out.println("			<th></th>");
		out.println("			<th>Destinacija</th>");
		out.println("			<th>Drzava</th>");
		out.println("			<th>Naziv</th>");
		out.println("			<th>Kod</th>");
		out.println("			<th>Lokacija</th>");
		out.println("			<th colspan=\"2\"></th>");
		out.println("		</tr>");
							for(Destinacija ds : httpd.destinacije.values()){
								String brisi = "";
								System.out.println("\n" +ds.getDestinacija() + " IME JE OVO A STANJE JE " + ds.getStanje());
								if(ds.getStanje().equals("aktivna")){
									brisi="Arhiviraj";
								}else{
									brisi="Aktiviraj";
								}
		out.println("		<tr>");
		out.println("			<td><img src=\""+ds.getSlika()+"\"/></td>");
		out.println("			<td>"+ds.getDestinacija()+"</td>");
		out.println("			<td>"+ds.getDrzava()+"</td>");
		out.println("			<td>"+ds.getNaziv()+"</td>");
		out.println("			<td>"+ds.getKod()+"</td>");
		out.println("			<td>"+ds.getLokacija()+"</td>");
		out.println("			<td><a href=\"http://localhost/izmeniDestPoc?dest="+ds.getDestinacija()+"\">Izmeni</a></td>");
		out.println("			<td><a href=\"http://localhost/deleteDestSuc?dest="+ds.getDestinacija()+"\">"+brisi+"</a></td>");
		out.println("		</tr>");
								
							}
		out.println("	</table>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public static void addDestination(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/addDesSuc\">");
		out.println("		<p>Destinacija: </p><input type=\"text\" name=\"dest\" />");
		out.println("		<p>Država: </p><input type=\"text\" name=\"drzava\" />");
		out.println("		<p>Naziv aerodroma: </p><input type=\"text\" name=\"naziv\" />");
		out.println("		<p>Kod aerodroma: </p><input type=\"text\" name=\"kod\" />");
		out.println("		<p>Lokacija: </p><input type=\"text\" name=\"lok\" />");
		out.println("		<p>Slika: </p><input type=\"file\" name=\"img\" /><br>");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"Posalji\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
	}

	public static void blokUnos(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = httpd.getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo2\">");
		out.println("	<table>");
		out.println("		<tr>");
		out.println("			<th>Username</th>");
		out.println("			<th>Ime</th>");
		out.println("			<th>Prezime</th>");
		out.println("			<th>Email</th>");
		out.println("			<th></th>");
		out.println("		</tr>");
						for(Korisnik kr : httpd.korisnici.values()){
							if(kr.getTip().equals("user")){
								String stanje="";
								if(kr.getStanje().equals("normalno"))
									stanje="Blokiraj";
								else
									stanje="Aktiviraj";
		out.println("		<tr>");
		out.println("			<td>"+kr.getKorime()+"</td>");
		out.println("			<td>"+kr.getIme()+"</td>");
		out.println("			<td>"+kr.getPrezime()+"</td>");
		out.println("			<td>"+kr.getEmail()+"</td>");
		out.println("			<td><a href=\"http://localhost/blokSuc?user="+kr.getKorime()+"\">"+stanje+"</a></td>");
		out.println("		</tr>");
							}
							}
		out.println("	</table>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}

	public static void reservationPrint(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo2\">");
		out.println("	<table>");
		out.println("		<tr>");
		out.println("			<th>Br rezervacije</th>");
		out.println("			<th>Klasa</th>");
		out.println("			<th>Datum rez</th>");
		out.println("			<th>Broj putnika</th>");
		out.println("			<th></th>");
		out.println("		</tr>");
							for(Rezervacija rz : httpd.rezervacije.values()){
								if(rz.getKorisnik().getKorime().equals(httpd.korisnik.getKorime())){
		out.println("		<tr>");
		out.println("			<td>"+rz.getBrrez()+"</td>");
		out.println("			<td>"+rz.getKlasa()+"</td>");
		out.println("			<td>"+rz.getDate()+"</td>");
		out.println("			<td>"+rz.getBrputnika()+"</td>");
		out.println("			<td><a href=\"http://localhost/obrisiRez?rez="+rz.getBrrez()+"\">Obrisi</a></td>");
		out.println("		</tr>");
								}
							}
		out.println("	</table>");
		out.print("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	public static void izmena(String resource, OutputStream outputStream) {
		PrintStream out = new PrintStream(outputStream);

		out.print("HTTP/1.0 200 OK\r\n\r\n");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/izmenaComp\">");
		out.println("		<p>Password: </p><input type=\"text\" name=\"pass\" />");
		out.println("		<p>Ime: </p><input type=\"text\" name=\"ime\" />");
		out.println("		<p>Prezime: </p><input type=\"text\" name=\"prezime\" />");
		out.println("		<p>Telefon: </p><input type=\"text\" name=\"telefon\" />");
		out.println("		<p>Email: </p><input type=\"text\" name=\"email\" />");
		out.println("		<p>Slika: </p><input type=\"file\" name=\"slika\" />");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"submit\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		
	}
	
	public static void izmenaAdmin(String resource, OutputStream outputStream) {
		PrintStream out = new PrintStream(outputStream);

		out.print("HTTP/1.0 200 OK\r\n\r\n");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/izmenaComp\">");
		out.println("		<p>Password: </p><input type=\"text\" name=\"pass\" />");
		out.println("		<p>Ime: </p><input type=\"text\" name=\"ime\" />");
		out.println("		<p>Prezime: </p><input type=\"text\" name=\"prezime\" />");
		out.println("		<p>Telefon: </p><input type=\"text\" name=\"telefon\" />");
		out.println("		<p>Email: </p><input type=\"text\" name=\"email\" />");
		out.println("		<p>Slika: </p><input type=\"file\" name=\"slika\" />");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"submit\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		
	}
	
	public static void mesta(int br,OutputStream outputStream){
		
		PrintStream out = new PrintStream(outputStream);
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<p>Broj dovoljnih mesta je "+ br +"</p>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		
	}
	
	
	public static void reservationPopuna2(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = httpd.getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/rezComplete\">");
		out.println("		<p>Klasa: <select name=\"klasa\">");
		out.println("			<option value=\"prva\">Prva</option>");
		out.println("			<option value=\"biznis\">Biznis</option>");
		out.println("			<option value=\"ekonomska\">Ekonomska</option>");
		out.println("		</select>");
		out.println("		</p>");
		out.println("		<p>Broj putnika: <input type=\"text\" name=\"br\"/></p>");
		out.println("		<input type=\"hidden\" name=\"let\" value=\""+ podaci.get("let") + "\"/>");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"reserve\" />");
		out.println("	</form>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	public static void rezervationPrikazNastavak(String resource,OutputStream outputStream,HashMap<String,Let> temp){

		PrintStream out = new PrintStream(outputStream);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo3\">");
		out.println("	<table>");
		
		out.println("		<tr>");
		out.println("			<th>Broj</th>");
		out.println("			<th>Pocetna destinacija</th>");
		out.println("			<th>Krajnja destinacija</th>");
		out.println("			<th>Cena</th>");
		out.println("			<th>Model</th>");
		out.println("			<th>Mesta u prvoj</th>");
		out.println("			<th>Mesta u biznis</th>");
		out.println("			<th>Mesta u ekonomskoj</th>");
		out.println("			<th>Datum</th>");
		out.println("			<th>Klasa</th>");
		out.println("			<th></th>");
		out.println("		</tr>");
							for(Let let : temp.values()){
		out.println("		<tr>");
		out.println("			<td> " + let.getBr() + " </td>");
		out.println("			<td>" + let.getPocetna().getDestinacija() +  " </td>");
		out.println("			<td>" + let.getKrajnja().getDestinacija() +  "</td>");
		out.println("			<td>" + let.getCena() +  "</td>");
		out.println("			<td>" + let.getModel() +  "</td>");
								int prva=let.getMestap();
								for(Rezervacija rez : let.getRezervacije().values()){
									if(rez.getKlasa().equals("prva"))
										prva=prva-rez.getBrputnika();
								}
		out.println("			<td>" + prva +  "</td>");
								int biznis=let.getMestap();
								for(Rezervacija rez : let.getRezervacije().values()){
									if(rez.getKlasa().equals("biznis"))
										biznis=biznis-rez.getBrputnika();
								}
		out.println("			<td>" + biznis +  "</td>");
								int ekonomska=let.getMestap();
								for(Rezervacija rez : let.getRezervacije().values()){
									if(rez.getKlasa().equals("ekonomska"))
										ekonomska=ekonomska-rez.getBrputnika();
								}
		out.println("			<td>" + ekonomska +  "</td>");
		out.println("			<td>" + let.getDate() +  "</td>");
		out.println("			<td>" + let.getKlasa() +  "</td>");
		out.println("			<td><a href=\"http://localhost/rezProba?let="+let.getBr()+"\">Rezervisi</a></td>");
		out.println("		</tr>");
							}
		out.println("	</table>");
		out.println("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public static void reservationPopuna(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("	<form action=\"http://localhost/rezPrikaz\">");
		out.println("		<p>Destinacija pocetna: </p><input type=\"text\" name=\"pocetak\" />");
		out.println("		<p>Krajnja destinacija: </p><input type=\"text\" name=\"kraj\" />");
		out.println("		<p>Datum leta</p> <input type=\"date\" name=\"date\"/><br>");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"posalji\" />");
		out.println("	</form>");
		out.print("</div></div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public static void registerPopuna(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);

		out.print("HTTP/1.0 200 OK\r\n\r\n");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div class=\"center\">");
		out.print("<div class=\"login\">");
		out.println("	<form action=\"http://localhost/registerNo\">");
		out.println("		<p>Username: </p><input type=\"text\" name=\"user\" />");
		out.println("		<p>Password: </p><input type=\"text\" name=\"pass\" />");
		out.println("		<p>Ime: </p><input type=\"text\" name=\"ime\" />");
		out.println("		<p>Prezime: </p><input type=\"text\" name=\"prezime\" />");
		out.println("		<p>Telefon: </p><input type=\"text\" name=\"telefon\" />");
		out.println("		<p>Email: </p><input type=\"text\" name=\"email\" />");
		out.println("		<p>Slika: </p><input type=\"file\" name=\"slika\" />");
		out.println("		<br>");
		out.println("		<input type=\"submit\" value=\"register\" />");
		out.println("	</form>");
		out.print("</div>");
		out.print("</div>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}
	
	public static void PrintGlavAdmin(OutputStream os) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(os);
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkoviA\">");
		out.println("	<a href=\"http://localhost/blokUnos\">Blokiraj korisnike</a>");
		
		out.println("	<a href=\"http://localhost/addDest\">Dodaj destinaciju</a>");
		out.println("	<a href=\"http://localhost/izmenaDestPoc\">Izmeni destinaciju</a>");
		
		out.println("	<a href=\"http://localhost/addLet\">Dodaj let</a>");
		out.println("	<a href=\"http://localhost/izmenaLetPoc\">Izmeni let</a>");
		
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");

		out.println("	<a href=\"http://localhost/PretragaFilter\">Filtriraj i prikazi letove</a>");

		out.println("	<a href=\"http://localhost/logout\">Log out</a>");
		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}
	
	public static void PrintGlav(OutputStream os) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(os);
		
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"center\">");
		out.println("<div class=\"glava\">");
		out.println("	<img src=\""+httpd.korisnik.getSlika()+"\"/>");
		out.println("	<p>Ime: "+httpd.korisnik.getIme()+"</p>");
		out.println("	<p>Prezime: "+httpd.korisnik.getPrezime()+"</p>");
		out.println("	<p>Telefon: "+httpd.korisnik.getTelefon()+"</p>");
		out.println("	<p>Email: "+httpd.korisnik.getEmail()+"</p>");
		out.println("	<br>");
		out.println("</div>");
		out.println("<div class=\"linkovi\">");
		out.println("	<a href=\"http://localhost/rezUnos\">Rezervisi kartu</a>");
		out.println("	<a href=\"http://localhost/mojRez\">Moje rezervacije</a>");
		out.println("	<a href=\"http://localhost/izmenaPoc\">Izmeni profil</a>");
		out.println("	<a href=\"http://localhost/filter\">Filtriraj letove</a>");
		out.println("	<a href=\"http://localhost/pretLet\">Pretrazi letove</a>");
		out.println("	<a href=\"http://localhost/logout\">Log out</a>");

		out.println("</div>");
		out.println("<div class=\"ostalo\">");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		
	}
	

	public static void PrintRes(OutputStream os){
		
		PrintStream ps = new PrintStream(os);
		
		ps.print("<html>");
		ps.print("<head>");
		ps.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		ps.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		ps.print("<title>Insert title here</title>");
		ps.print("</head>");
		ps.print("<body>");
		ps.print("<div class=\"center\">");
		ps.print("<div class=\"login\">");
		ps.print("<form action=\"http://localhost/glavni\">");
		ps.print("	<p>Username: </p><input type=\"text\" name=\"user\" />");
		ps.print("	<p>Password: </p><input type=\"text\" name=\"pass\" /><br>");
		ps.print("	<br>");
		ps.print("	<input type=\"submit\" value=\"log in\" />");
		ps.print("</form>");
		ps.print("<a href=\"http://localhost/registerApply\">Register</a>");
		ps.print("</div>");
		ps.print("</div>");
		ps.print("</body>");
		ps.print("</html>");
		ps.flush();
	}
	
}
