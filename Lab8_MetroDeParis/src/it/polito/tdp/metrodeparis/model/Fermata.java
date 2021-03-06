package it.polito.tdp.metrodeparis.model;

public class Fermata {

	private int idFermata;
	private String nomeFermata;
	private double coordX;
	private double coordY;
	
	public Fermata(int idFermata, String nome, double coordX, double coordY) {
		super();
		this.idFermata = idFermata;
		this.nomeFermata = nome;
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public int getIdFermata() {
		return idFermata;
	}

	public void setIdFermata(int idFermata) {
		this.idFermata = idFermata;
	}

	public String getNome() {
		return nomeFermata;
	}

	public void setNome(String nome) {
		this.nomeFermata = nome;
	}

	public double getCoordX() {
		return coordX;
	}

	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFermata;
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
		Fermata other = (Fermata) obj;
		if (idFermata != other.idFermata)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nomeFermata;
	}
	
	
	
	
}
