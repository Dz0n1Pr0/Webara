package paket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.Resource;

import Klase.Destinacija;
import Klase.Korisnik;
import Klase.Let;
import Klase.Rezervacija;
import View.Prikazi;

/**
 * Jednostavan web server
 */
public class httpd {
	public static HashMap<String,Korisnik> korisnici = new HashMap<String,Korisnik>();
	public static HashMap<String,Destinacija> destinacije = new HashMap<String,Destinacija>();
	public static HashMap<String,Let> letovi = new HashMap<String,Let>();
	public static HashMap<String,Rezervacija> rezervacije = new HashMap<String,Rezervacija>();
	public static Korisnik korisnik = new Korisnik();
	public static boolean admin=false;
	
	public static void main(String args[]) throws IOException {
		int port = 80;
		
		@SuppressWarnings("resource")
		ServerSocket srvr = new ServerSocket(port);

		System.out.println("httpd running on port: " + port);
		System.out.println("document root is: "
				+ new File(".").getAbsolutePath() + "\n");

		Socket skt = null;

		UcitavanjeFajlova();
		
		while (true) {
			try {
				skt = srvr.accept();
				InetAddress addr = skt.getInetAddress();
				
				System.out.println("/n----------------------------/nRESOURCE:\n\n");
				String resource = getResource(skt.getInputStream());
				System.out.println("/n----------------------------/n");

				if (resource.equals(""))
					resource = "index.html";
				
				
				if(korisnik.getTip()!=null && korisnik.getTip().equals("admin")){
					if(resource.contains("glavni")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						postRequest(resource,skt.getOutputStream());
						skt.close();
						skt = null;
						
					}else if(resource.contains("registerApply")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.registerPopuna(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("blokUnos")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.blokUnos(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("blokSuc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						blokSuccess(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("addDest")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.addDestination(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("addDesSuc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						addDestSuccess(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("izmenaDestPoc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.izmenaDestPoc(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("izmeniDestPoc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.izmenaDestPopuna(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("changeDesSuc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						izmenaDestUspeh(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("deleteDestSuc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						deleteDest(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("addLet")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.addLet(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("letAddSucc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						addLetSucc(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("izmenaLetPoc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.izmenaLetPoc(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("izmeniLet")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.izmenaLetUnos(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("letChangeOK")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						izmenaLetSucc(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("obrisiLet")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						obrisiLet(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("izmenaPoc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.izmenaAdmin(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("izmenaComp")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						izmenaCompleteAdmin(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("FiPi")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						filterPretragaLet(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("PretragaFilter")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.filterPretraga(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("logout")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Logout(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else{
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);

						sendResponse(resource, skt.getOutputStream());
						skt.close();
						skt = null;
					}
				
				}else{

					if(resource.contains("glavni")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						postRequest(resource,skt.getOutputStream());
						skt.close();
						skt = null;
						
					}else if(resource.contains("registerApply")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.registerPopuna(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("registerNo")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						registerRequest(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("rezUnos")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.reservationPopuna(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("rezPrikaz")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						reservationPrikaz(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("rezProba")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.reservationPopuna2(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("rezComplete")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						reservationComplete(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("izmenaPoc")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.izmena(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("izmenaComp")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						izmenaComplete(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("mojRez")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.reservationPrint(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("obrisiRez")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						reservationDelete(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("filter")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.filterLet(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("filtPrikaz")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.filterPrikazLet(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("pretLet")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Prikazi.pretragaLet(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("letPret")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						pretragaPrikazLet(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else if(resource.contains("logout")){
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);
						
						Logout(resource,skt.getOutputStream());
						skt.close();
						skt = null;
					}else{
						System.out.println("Request from " + addr.getHostName() + ": "
								+ resource);

						sendResponse(resource, skt.getOutputStream());
						skt.close();
						skt = null;
					}
				
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}

	public static void Logout(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		Prikazi.PrintRes(outputStream);
	}

	public static void filterPretragaLet(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		HashMap<String,String> podaci = getParameter(resource);
		
		HashMap<String,Let> temp = new HashMap<String,Let>();
		
		for(Let let : letovi.values()){
			boolean dodaj=true;
			if(!podaci.get("poc").equals("")){
				if(!podaci.get("poc").equals(let.getPocetna()))
					dodaj=false;
			}
			if(!podaci.get("kraj").equals("")){
				if(!podaci.get("kraj").equals(let.getKrajnja()))
					dodaj=false;
			}
			if(!podaci.get("date").equals("")){
				if(!podaci.get("date").equals(let.getDate()))
					dodaj=false;
			}
			if(!podaci.get("drzava").equals("")){
				if(!podaci.get("drzava").equals(let.getPocetna().getDrzava()) || !podaci.get("drzava").equals(let.getKrajnja().getDrzava()))
					dodaj=false;
			}
			
			
			if(!let.getPocetna().getStanje().equals("aktivna") || !let.getKrajnja().getStanje().equals("aktivna")){
				dodaj=false;
			}
			
			if(dodaj)
			temp.put(let.getBr(), let);
			
		}
		
		List<Let> letList = new ArrayList<>(temp.values());
		if(podaci.get("nacin").equals("Datum")){
			Collections.sort(letList, Comparator.comparing(Let::getDate));
		}else if(podaci.get("nacin").equals("Klasa")){
			Collections.sort(letList, Comparator.comparing(Let::getKlasa));
		}else{
			Collections.sort(letList, Comparator.comparing(Let::getBr));
		}
		
		
		Prikazi.filterPretragaLetNastavak(resource,outputStream,letList);
		
		
	}

	

	public static void pretragaPrikazLet(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		HashMap<String,String> podaci = getParameter(resource);
		
		HashMap<String,Let> temp = new HashMap<String,Let>();
		
		for(Let let : letovi.values()){
			boolean dodaj=true;
			if(!podaci.get("poc").equals("")){
				if(!podaci.get("poc").equals(let.getPocetna()))
					dodaj=false;
			}
			if(!podaci.get("kraj").equals("")){
				if(!podaci.get("kraj").equals(let.getKrajnja()))
					dodaj=false;
			}
			if(!podaci.get("date").equals("")){
				if(!podaci.get("date").equals(let.getDate()))
					dodaj=false;
			}
			if(!podaci.get("drzava").equals("")){
				if(!podaci.get("drzava").equals(let.getPocetna().getDrzava()) || !podaci.get("drzava").equals(let.getKrajnja().getDrzava()))
					dodaj=false;
			}
			
			
			if(!let.getPocetna().getStanje().equals("aktivna") || !let.getKrajnja().getStanje().equals("aktivna")){
				dodaj=false;
			}
			
			if(dodaj)
			temp.put(let.getBr(), let);
		}
		
		Prikazi.pretragaPrikazLet(resource,outputStream,temp);

		
	}



	

	public static void obrisiLet(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		HashMap<String,String> podaci = getParameter(resource);
		
		
		if(letovi.get(podaci.get("let")).getRezervacije().size()>0){
			Prikazi.PrintGlavAdmin(outputStream);
		}else{
			letovi.remove(podaci.get("let"));
			UpisFajl();
			Prikazi.PrintGlavAdmin(outputStream);
		}
	}

	public static void izmenaLetSucc(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		HashMap<String,String> podaci = getParameter(resource);
		
		//String br, String model, String klasa, Destinacija pocetna, Destinacija krajnja,
		//HashMap<String, Rezervacija> rezervacije, int cena, int mestab, int mestap, int mestae, String date
		
		Let let = new Let(podaci.get("let"),podaci.get("model"),podaci.get("klasa"),destinacije.get(podaci.get("poc")),destinacije.get(podaci.get("kraj")),letovi.get(podaci.get("letStari")).getRezervacije(),Integer.parseInt(podaci.get("cena")),
				Integer.parseInt(podaci.get("mestab")),Integer.parseInt(podaci.get("mestap")),Integer.parseInt(podaci.get("mestae")),podaci.get("date"));
		
		letovi.remove(podaci.get("letStari"));
		letovi.put(let.getBr(),let);
		UpisFajl();
		Prikazi.PrintGlavAdmin(outputStream);
	}

	

	public static void addLetSucc(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub

		HashMap<String,String> podaci = getParameter(resource);
		
			
			//String br, String model, String klasa, Destinacija pocetna, Destinacija krajnja,
			//HashMap<String, Rezervacija> rezervacije, int cena, int mestab, int mestap, int mestae, String date
			
			Let let = new Let(podaci.get("let"),podaci.get("model"),podaci.get("klasa"),destinacije.get(podaci.get("poc")),destinacije.get(podaci.get("kraj")),new HashMap<String,Rezervacija>(),Integer.parseInt(podaci.get("cena")),
					Integer.parseInt(podaci.get("mestab")),Integer.parseInt(podaci.get("mestap")),Integer.parseInt(podaci.get("mestae")),podaci.get("date"));
			
			letovi.put(let.getBr(),let);
			System.out.println(" ID JE " + letovi.get(podaci.get("let")).getBr());
			UpisFajl();
			Prikazi.PrintGlavAdmin(outputStream);
	}

	

	public static void deleteDest(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub

		HashMap<String,String> podaci = getParameter(resource);
		if(destinacije.get(podaci.get("dest")).getStanje().equals("arhivirana")){
			destinacije.get(podaci.get("dest")).setStanje("aktivna");
		}else{
			destinacije.get(podaci.get("dest")).setStanje("arhivirana");
		}
		
		for(Let lt : letovi.values()){
			if(lt.getPocetna().getDestinacija().equals(podaci.get("dest"))){
				lt.setPocetna(destinacije.get(podaci.get("dest")));
			}else if(lt.getKrajnja().getDestinacija().equals(podaci.get("dest"))){
				lt.setKrajnja(destinacije.get(podaci.get("dest")));
			}
		}
		
		UpisFajl();
		Prikazi.PrintGlavAdmin(outputStream);
	}

	public static void izmenaDestUspeh(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub

		HashMap<String,String> podaci = getParameter(resource);
		Destinacija dest = new Destinacija(podaci.get("dest"), podaci.get("drzava"), podaci.get("naziv"), podaci.get("kod"), podaci.get("lok"), podaci.get("img"), "aktivno");
		destinacije.remove(podaci.get("destStara"));
		destinacije.put(dest.getDestinacija(), dest);
		
		for(Let lt : letovi.values()){
			if(lt.getPocetna().getDestinacija().equals(podaci.get("destStara"))){
				lt.setPocetna(dest);
			}else if(lt.getKrajnja().getDestinacija().equals(podaci.get("destStara"))){
				lt.setKrajnja(dest);
			}
		}
		
		UpisFajl();
		Prikazi.PrintGlavAdmin(outputStream);
		
	}

	

	public static void addDestSuccess(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		HashMap<String,String> podaci = getParameter(resource);
		
		Destinacija dest = new Destinacija(podaci.get("dest"), podaci.get("drzava"), podaci.get("naziv"), podaci.get("kod"), podaci.get("lok"), podaci.get("img"), "aktivno");
		destinacije.put(dest.getDestinacija(), dest);
		UpisFajl();
		Prikazi.PrintGlavAdmin(outputStream);
		
	}

	

	public static void blokSuccess(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		if(korisnici.get(podaci.get("user")).getStanje().equals("normalno")){
			korisnici.get(podaci.get("user")).setStanje("blokirano");
		}else{
			korisnici.get(podaci.get("user")).setStanje("normalno");
		}
		
		Prikazi.PrintGlavAdmin(outputStream);
		out.flush();
	}


	public static void reservationDelete(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = getParameter(resource);
		
		rezervacije.remove(podaci.get("rez"));
		for(Let let : letovi.values()){
			if(let.getRezervacije().containsKey(podaci.get("rez"))){
				let.getRezervacije().remove(podaci.get("rez"));
			}
		}
		
		UpisFajl();
		Prikazi.PrintGlav(outputStream);
		out.flush();
		
	}


	public static void izmenaComplete(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		korisnik.setIme(podaci.get("ime"));
		korisnik.setPrezime(podaci.get("prezime"));
		korisnik.setEmail(podaci.get("email"));
		korisnik.setLozinka(podaci.get("pass"));
		korisnik.setSlika(podaci.get("slika"));
		korisnik.setTelefon(podaci.get("telefon"));
		
		korisnici.put(korisnik.getKorime(), korisnik);
		
		UpisFajl();
		Prikazi.PrintGlav(outputStream);
		out.flush();
		
	}
	
	public static void izmenaCompleteAdmin(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		korisnik.setIme(podaci.get("ime"));
		korisnik.setPrezime(podaci.get("prezime"));
		korisnik.setEmail(podaci.get("email"));
		korisnik.setLozinka(podaci.get("pass"));
		korisnik.setSlika(podaci.get("slika"));
		korisnik.setTelefon(podaci.get("telefon"));
		
		korisnici.put(korisnik.getKorime(), korisnik);
		
		UpisFajl();
		Prikazi.PrintGlavAdmin(outputStream);
		out.flush();
		
	}

	public static void UpisFajl() throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = new PrintWriter(new FileWriter("users.txt"));
		
		for(Korisnik kr : korisnici.values()){
			System.out.println(kr.getKorime()+";"+kr.getLozinka()+";"+kr.getIme()+";"+kr.getPrezime()+";"+kr.getTelefon()+";"+kr.getEmail()+";"+kr.getSlika()+";"+kr.getStanje()+";"+kr.getTip());
			pw.write(kr.getKorime()+";"+kr.getLozinka()+";"+kr.getIme()+";"+kr.getPrezime()+";"+kr.getTelefon()+";"+kr.getEmail()+";"+kr.getSlika()+";"+kr.getStanje()+";"+kr.getTip());
			pw.write("\n");
		}
		
		pw.close();
		pw = new PrintWriter(new FileWriter("destinacija.txt"));
		
		//String destinacija, String drzava, String naziv, String kod, String lokacija, String slika, String stanje
		for(Destinacija de : destinacije.values()){
			
			pw.write(de.getDestinacija()+";"+de.getDrzava()+";"+de.getNaziv()+";"+de.getKod()+";"+de.getLokacija()+";"+de.getSlika()+";"+de.getStanje());
			pw.write("\n");
		}
		
		pw.close();
		pw = new PrintWriter(new FileWriter("rezervacija.txt"));
		
		for(Rezervacija rz : rezervacije.values()){
			pw.write(rz.getBrrez()+";"+rz.getKlasa()+";"+rz.getDate()+";"+rz.getKorisnik().getKorime()+";"+rz.getBrputnika());
			pw.write("\n");
		}
		
		//String br, String model, String klasa, Destinacija pocetna, Destinacija krajnja,
		//HashMap<String, Rezervacija> rezervacije, int cena, int mestab, int mestap, int mestae, String date
		pw.close();
		pw = new PrintWriter(new FileWriter("let.txt"));
		for(Let let : letovi.values()){
			String temp="";
			for(String rz : let.getRezervacije().keySet()){
				System.out.println(rz + " KAKA JE OVO REZ");
				temp+=rz+"-";
			}
			System.out.println(" ------ " + let.getPocetna().getDestinacija());
			pw.write(let.getBr()+";"+let.getModel()+";"+let.getKlasa()+";"+let.getPocetna().getDestinacija()+";"+let.getKrajnja().getDestinacija()+";"+temp+";"+let.getCena()+";"+
					let.getMestap()+";"+let.getMestab()+";"+let.getMestae()+";"+let.getDate());
			
			//System.out.println(destinacije.get(let.getPocetna()).getDestinacija()+ " ------ " + let.getPoc);
			pw.write("\n");
		}
		
		pw.close();
	}

	

	public static void reservationComplete(String resource, OutputStream outputStream) throws IOException {
		// TODO Auto-generated method stub
		PrintStream out = new PrintStream(outputStream);
		HashMap<String,String> podaci = getParameter(resource);
		out.print("HTTP/1.0 200 OK\r\n\r\n");
		
		Rezervacija rez = new Rezervacija();
		double rand = Math.random()*9999+1;
		while(rezervacije.containsKey(""+rand)){
			rand = Math.random()*9999+1;
		}
		rez.setBrrez(""+rand);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		rez.setDate(dateFormat.format(date));
		
		rez.setKlasa(podaci.get("klasa"));
		rez.setKorisnik(korisnik);
		rez.setBrputnika(Integer.parseInt(podaci.get("br")));
		boolean moze=true;
		
		if(podaci.get("klasa").equals("prva")){
			if(letovi.get(podaci.get("let")).getMestap()-rez.getBrputnika()<0){
				Prikazi.mesta(letovi.get(podaci.get("let")).getMestap(),outputStream);
				moze=false;
			}else{
				
			}
			
		}else if(podaci.get("klasa").equals("biznis")){
			if(letovi.get(podaci.get("let")).getMestab()-rez.getBrputnika()<0){
				moze=false;
				Prikazi.mesta(letovi.get(podaci.get("let")).getMestab(),outputStream);
			}else{
				
			}
			
		}else{
			if(letovi.get(podaci.get("let")).getMestae()-rez.getBrputnika()<0){
				System.out.println(" KAKO JE MNAJE?");
				Prikazi.mesta(letovi.get(podaci.get("let")).getMestae(),outputStream);
				moze=false;
			}else{
				System.out.println(" GLE PA NARAVNO DA RADI ");
			}
		}
		
		if(moze){
			letovi.get(podaci.get("let")).getRezervacije().put(rez.getBrrez(), rez);
			rezervacije.put(rez.getBrrez(), rez);
			UpisFajl();
			Prikazi.PrintGlav(outputStream);
			out.flush();
		}
		
	}




	public static void reservationPrikaz(String resource, OutputStream outputStream) {
		// TODO Auto-generated method stub
		
		HashMap<String,String> podaci = getParameter(resource);
		
		HashMap<String,Let> temp = new HashMap<String,Let>();
		
		for(Let let : letovi.values()){
			boolean dodaj=true;
			if(!podaci.get("pocetak").equals("")){
				if(!podaci.get("pocetak").equals(let.getPocetna()))
					dodaj=false;
			}
			if(!podaci.get("kraj").equals("")){
				if(!podaci.get("kraj").equals(let.getKrajnja()))
					dodaj=false;
			}
			if(!podaci.get("date").equals("")){
				if(!podaci.get("date").equals(let.getDate()))
					dodaj=false;
			}
			
			if(!let.getPocetna().getStanje().equals("aktivna") || !let.getKrajnja().getStanje().equals("aktivna")){
				dodaj=false;
			}
			
			if(dodaj)
			temp.put(let.getBr(), let);
		}
		
		Prikazi.rezervationPrikazNastavak(resource ,outputStream,temp);
		
	}

	

	public static void UcitavanjeFajlova() throws IOException {
		// TODO Auto-generated method stub
		  File file = new File("users.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st;
		  while ((st = br.readLine()) != null){
			  String[] pod = st.split(";");
			  korisnici.put(pod[0], new Korisnik(pod[0],pod[1],pod[2],pod[3],pod[4],pod[5],pod[6],pod[7]));
			  System.out.println(pod[8] + " OVO JE JO");
			  korisnici.get(pod[0]).setTip(pod[8]);
		  }
		  br.close();
		  
		  file = new File("destinacija.txt"); 
		  
		  br = new BufferedReader(new FileReader(file)); 
		  
		  while ((st = br.readLine()) != null){
			  String[] pod = st.split(";");
			  destinacije.put(pod[0], new Destinacija(pod[0],pod[1],pod[2],pod[3],pod[4],pod[5],pod[6]));
			  System.out.println(destinacije.get(pod[0]).getStanje() + " HEHHAEHEA" + pod[6]);
		  }
		  

		  file = new File("rezervacija.txt"); 
		  
		  br = new BufferedReader(new FileReader(file)); 
		  
		  while ((st = br.readLine()) != null){

			  String[] pod = st.split(";");
			  rezervacije.put(pod[0], new Rezervacija(pod[0],pod[1],pod[2],korisnici.get(pod[3]),Integer.parseInt(pod[4])));

			  
		  }
		  
		  
		  file = new File("let.txt"); 
		  
		  br = new BufferedReader(new FileReader(file)); 
		  
		  while ((st = br.readLine()) != null){
			  String[] pod = st.split(";");
			  
			  String[] reg = pod[5].split("-");
			  
			  HashMap<String,Rezervacija> temp = new HashMap<String,Rezervacija>();
			  for(int i=0;i<reg.length;i++){
				  if(rezervacije.containsKey(reg[i]))
					  temp.put(reg[i], rezervacije.get(reg[i]));
			  }
			  
			  
			  letovi.put(pod[0], new Let(pod[0],pod[1],pod[2],destinacije.get(pod[3]),destinacije.get(pod[4]),temp,Integer.parseInt(pod[6]),Integer.parseInt(pod[7]),Integer.parseInt(pod[8]),Integer.parseInt(pod[9]),pod[10]));
			  System.out.println(destinacije.get(pod[4]).getStanje() + " OVO JE STANJE POCETNE");
		  }
		  
		  br.close();
		  
	}

	

	public static void registerRequest(String resource, OutputStream outputStream) {
		
		PrintStream ps = new PrintStream(outputStream);
		HashMap<String,String> podaci = getParameter(resource);
		ps.print("HTTP/1.0 200 OK\r\n\r\n");
		
		try {
			  
			  if(korisnici.containsKey(podaci.get("user"))){
				  Prikazi.registerPopuna(resource,ps);
				  ps.flush();
			  }else{
				  System.out.println("\nKAKO NECE REGISTER------------------------------------------------------------\n");
				  Korisnik kr = new Korisnik();
				  kr.setKorime(podaci.get("user"));
				  kr.setIme(podaci.get("ime"));
				  kr.setPrezime(podaci.get("prezime"));
				  kr.setEmail(podaci.get("email"));
				  kr.setLozinka(podaci.get("pass"));
				  kr.setSlika(podaci.get("slika"));
				  kr.setTelefon(podaci.get("telefon"));
				  kr.setStanje("normalno");
				  kr.setTip("user");
					
					korisnici.put(kr.getKorime(), kr);
				  UpisFajl();
				  Prikazi.PrintRes(outputStream);
				  ps.flush();
			  }
			    
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	static void postRequest(String resource, OutputStream os)
			throws IOException {
		PrintStream ps = new PrintStream(os);

		HashMap<String,String> podaci = getParameter(resource);
		ps.print("HTTP/1.0 200 OK\r\n\r\n");
		
		try {
			  boolean nasao=false;
			  
				  if(korisnici.containsKey(podaci.get("user")) && korisnici.get(podaci.get("user")).getLozinka().equals(podaci.get("pass")) && korisnici.get(podaci.get("user")).getStanje().equals("normalno")){
					  korisnik = korisnici.get(podaci.get("user"));
					  nasao=true;
				  }
			  
			  if(!nasao){
				  Prikazi.PrintRes(os);
				  ps.flush();
			  }else{
				  if(korisnik.getTip().equals("user"))
					  Prikazi.PrintGlav(os);
				  else
					  Prikazi.PrintGlavAdmin(os);
				  ps.flush();
			  }
			    
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	

	
	
	static String getResource(InputStream is) throws IOException {
		BufferedReader dis = new BufferedReader(new InputStreamReader(is));
		String s = dis.readLine();
		System.out.println(s);

		String[] tokens = s.split(" ");

		// prva linija HTTP zahteva: METOD /resurs HTTP/verzija
		// obradjujemo samo GET metodu
		String method = tokens[0];
		if (!method.equals("GET")) {
			return null;
		}

		String rsrc = tokens[1];

		// izbacimo znak '/' sa pocetka
		rsrc = rsrc.substring(1);

		// ignorisemo ostatak zaglavlja
		String s1;
		while (!(s1 = dis.readLine()).equals(""))
			System.out.println(s1);

		return rsrc;
	}

	static void sendResponse(String resource, OutputStream os)
			throws IOException {
		PrintStream ps = new PrintStream(os);
		// zamenimo web separator sistemskim separatorom
		resource = resource.replace('/', File.separatorChar);
		File file = new File(resource);

		if (!file.exists()) {
			// ako datoteka ne postoji, vratimo kod za gresku
			ps.print("HTTP/1.0 404 File not found\r\n"
					+ "Content-type: text/html; charset=UTF-8\r\n\r\n<b>404 Нисам нашао:"
					+ file.getName() + "</b>");
			// ps.flush();
			System.out.println("Could not find resource: " + file);
			return;
		}

		// ispisemo zaglavlje HTTP odgovora
		ps.print("HTTP/1.0 200 OK\r\n\r\n");

		// a, zatim datoteku
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[8192];
		int len;

		while ((len = fis.read(data)) != -1) {
			ps.write(data, 0, len);
		}

		ps.flush();
		fis.close();
	}
	
	public static HashMap<String, String> getParameter(String requestLine) {
		HashMap<String, String> retVal = new HashMap<String, String>();

		String request = requestLine.split("\\?")[0];
		retVal.put("request", request);
		String parameters = requestLine.substring(requestLine.indexOf("?") + 1);
		StringTokenizer st = new StringTokenizer(parameters, "&");
		while (st.hasMoreTokens()) {
			String key = "";
			String value = "";
			StringTokenizer pst = new StringTokenizer(st.nextToken(), "=");
			key = pst.nextToken();
			if (pst.hasMoreTokens())
				value = pst.nextToken();

			retVal.put(key, value);
		}

		return retVal;
	}
}


