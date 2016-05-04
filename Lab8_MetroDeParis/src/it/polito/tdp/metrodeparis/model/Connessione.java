package it.polito.tdp.metrodeparis.model;

public class Connessione {

	private int idLinea;
	private int idP;
	private int idA;
	
	public Connessione(int idLinea, int idP, int idA) {
		super();
		this.idLinea = idLinea;
		this.idP = idP;
		this.idA = idA;
	}

	public int getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public int getIdA() {
		return idA;
	}

	public void setIdA(int idA) {
		this.idA = idA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idA;
		result = prime * result + idLinea;
		result = prime * result + idP;
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
		Connessione other = (Connessione) obj;
		if (idA != other.idA)
			return false;
		if (idLinea != other.idLinea)
			return false;
		if (idP != other.idP)
			return false;
		return true;
	}
	
}
