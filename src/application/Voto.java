package application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cod;
	
	@Column
	String candidato;
	
	@Column
	String eleitor;
	
	@Column
	int nCandidato;
	
	
	
	public int getnCandidato() {
		return nCandidato;
	}

	public void setnCandidato(int nCandidato) {
		this.nCandidato = nCandidato;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getCandidato() {
		return candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}

	public String getEleitor() {
		return eleitor;
	}

	public void setEleitor(String eleitor) {
		this.eleitor = eleitor;
	}

	
	
	
	
	
	
}
