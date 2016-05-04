package it.polito.tdp.metrodeparis.model;

public class Linea {

	private int idLinea;
	private String nomeLinea;
	private double velocita;
	private double intervallo;
	private String colore;
	
	public Linea(int idLinea, String nomeLinea, double velocita, double intervallo, String colore) {
		super();
		this.idLinea = idLinea;
		this.nomeLinea = nomeLinea;
		this.velocita = velocita;
		this.intervallo = intervallo;
		this.colore = colore;
	}

	public int getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public String getNomeLinea() {
		return nomeLinea;
	}

	public void setNomeLinea(String nomeLinea) {
		this.nomeLinea = nomeLinea;
	}

	public double getVelocita() {
		return velocita;
	}

	public void setVelocita(double velocita) {
		this.velocita = velocita;
	}

	public double getIntervallo() {
		return intervallo;
	}

	public void setIntervallo(double intervallo) {
		this.intervallo = intervallo;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLinea;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Linea other = (Linea) obj;
		if (idLinea != other.idLinea)
			return false;
		return true;
	}
	
	
}
