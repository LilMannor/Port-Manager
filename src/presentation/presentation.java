package presentation;
import model.*;
import java.io.*; 

public class presentation {
	
	private Barca posti[] = new Barca[100]; //creo un array vuoto
	private String elenco[] = new String[100]; 

	int scelta=0;
	
	public void menu() {
		
		System.out.println("1) assegna un posto a una barca");
		System.out.println("2) rilascia barca e stampa ricevuta");
		System.out.println("3) ottieni informazioni della barca");
		System.out.println("4) salva lo stato");
		System.out.println("5) ottieni una visione di tutte le barche di un paese");
		System.out.println("6) ESCI");

	}
	
	public void eseguimenu() {
		
		while(scelta!=6) {
			
			menu();
			System.out.println("fai una scelta ");
			scelta=Integer.parseInt(IO.readln());
			casi();
			
		}

	}
		
	public void casi() {
		
		switch (scelta) {
		
			case 1:
				
				System.out.println("inserisci la lunghezza");
				
				double lung=Double.parseDouble(IO.readln());
				
				System.out.println("in che posto vuoi mettere la barca");
				
				int pos=Integer.parseInt(IO.readln());
				
				while(pos>100 || pos<0) {
					
					System.out.println("ci sono solo 100 posti reinserisci");
					
					pos=Integer.parseInt(IO.readln());	
					
				}
				
				while(posti[pos]!=null) {
					
					System.out.println("il posto e' occupato");
					
					System.out.println("in che posto vuoi mettere la barca");
					
					pos=Integer.parseInt(IO.readln());
					
				}
					
				while(lung>10 && pos<50) {
					System.out.println("nei posti minori del 50 ci possono stare solo barche piu piccole di 10 metri");
					System.out.println("in che posto vuoi mettere la barca");
					pos=Integer.parseInt(IO.readln());
				}
				
				System.out.println("inserisci il peso");
				double weight=Double.parseDouble(IO.readln());
				
				try {
					
					posti[pos] = new Barca(lung, weight);
					System.out.println("inserisci il nome");
					posti[pos].setNome(IO.readln());
					
					System.out.println("inserisci il tipo motore o vela");
					Tipi mot=Tipi.valueOf(IO.readln().trim().toUpperCase());
					posti[pos].setMotore(mot);
					
					System.out.println("inserisci la nazionalita");
					Nazione nation=Nazione.valueOf(IO.readln().trim().toUpperCase());
					posti[pos].setNazionalita(nation);
					

					
				}catch (IllegalArgumentException e) {
					
					System.out.println(e.getMessage());
					posti[pos]=null;
				}
			
				
			break;
			
			case 2:
				
				System.out.println("quale e il posto in qui sta la barca che vuoi far uscire");
				
				pos=Integer.parseInt(IO.readln());
				
				while(pos>100 || pos<0) {
					
					System.out.println("ci sono solo 100 posti reinserisci");
					
					pos=Integer.parseInt(IO.readln());	
					
				}
				
				while(posti[pos]==null) {
					System.out.println("il posto e vuoto reinserisci");
					pos=Integer.parseInt(IO.readln());	
				}
				
				double spesa=0;
				System.out.println("quanti giorni e stata la barca");
				int g=Integer.parseInt(IO.readln());

				spesa=posti[pos].calcolaspesa(g);
				System.out.println("il posto e "+pos+" hai speso"+spesa+" $");

				posti[pos]=null;
				
			break;
			
			case 3:
				
				System.out.println("quale e il posto in qui sta la barca sulla quale vuoi informazioni");
				
				pos=Integer.parseInt(IO.readln());
				
				while(pos>100 || pos<0) {
					
					System.out.println("ci sono solo 100 posti reinserisci");
					
					pos=Integer.parseInt(IO.readln());	
					
				}
				
				while(posti[pos]==null) {
					System.out.println("il posto e vuoto reinserisci");
					pos=Integer.parseInt(IO.readln());	
				}
				
				System.out.println(posti[pos].toString());
			
			break;
			
			case 4:
				try (PrintWriter writer = new PrintWriter(new FileWriter("stato_porto.txt"))) {
					writer.println("--- STATO ATTUALE PORTO ---");
					for (int i = 0; i < posti.length; i++) {
						if (posti[i] != null) {
							writer.println("Posto " + i + ": " + posti[i].toString());
						}
					}
					System.out.println("Stato salvato con successo nel file 'stato_porto.txt'!");
				} catch (IOException e) {
					System.out.println("Errore durante il salvataggio del file: " + e.getMessage());
				}
			break;
			
			case 5:
				
				System.out.println("inserisci la nazionalita che cerchi:");
				try {
					Nazione paeseCercato = Nazione.valueOf(IO.readln().trim().toUpperCase());
					boolean trovate = false;
					
					System.out.println("Barche registrate per la nazione " + paeseCercato + ":");
					for (int i = 0; i < posti.length; i++) {
						// Assicurati che la classe Barca abbia un metodo getNazionalita() o simile
						if (posti[i] != null && posti[i].getNazionalita() == paeseCercato) {
							System.out.println("- Posto [" + i + "]: " + posti[i].toString());
							trovate = true;
						}
					}
					
					if (!trovate) {
						System.out.println("Nessuna barca trovata per questa nazionalita.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println("Nazionalita non valida o non esistente nell'enum.");
				}
				
			break;
			
			case 6:
				System.out.println("ARRIVEDERCI");
				
			break;
			
			default:
				
				System.out.println("scegli un opzione disponibile");
				
			break;
				
		}
		
	}
}
