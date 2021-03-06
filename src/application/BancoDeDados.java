package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BancoDeDados {

	private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Urna");

	public static EntityManager criaGerenciador() {
		return BancoDeDados.fabrica.createEntityManager();
	}
	
	public static void fechar() {
		BancoDeDados.fabrica.close();
	}

}
