package model;

public class Barca {
	
	private String nome;
	private Nazione nazionalita;
	private final double lunghezza;
	private double peso;
	private Tipi motore;
	
	
	public Barca(double lunghezza, double peso){
		
		if(lunghezza<=4) {
			
			throw new IllegalArgumentException ("La lunghezza deve essere almeno 4 metri");
			
		}else {
			
			this.lunghezza=lunghezza;
			
		}
		
		if(peso<=1000) {
			
			throw new IllegalArgumentException ("il peso deve esse almeno 1000 kg");

		}else {
			
			this.peso=peso;
			
		}
		        
    }
	
	public double calcolaspesa (int input) {
		
		if(motore==Tipi.VELA) {
			double spesa=input*10*lunghezza;
			return spesa;
		}else {
			double spesa=input*20*lunghezza;
			return spesa;

		}
		
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Nazione getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(Nazione nazionalita) {
		this.nazionalita = nazionalita;
	}

	public double getLunghezza() {
		return lunghezza;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setMotore(Tipi motore) {
		
		this.motore=motore;
	}
	
	public Tipi getMotore() {
		return motore;
	}

	public String toString() {
		return "nome=" + nome + ", nazionalita=" + nazionalita + ", lunghezza=" + lunghezza + ", peso=" + peso
				+ ", motore=" + motore;
	}
	

}
