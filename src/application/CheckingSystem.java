package application;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckingSystem extends Stage{
	
	VBox layout = new VBox();
	Label name = new Label("False"),bool = new Label("true");
	TextField txtName=new TextField();
	Button btnConfere = new Button("Conferir");
	
	String nameCrypted;
	String crypted;
	EntityManager em = BancoDeDados.criaGerenciador();
	
	public CheckingSystem() {
		
		Voto v = new Voto();
		
		
		
		
		btnConfere.setOnAction(e->{
			crypted = crypt(txtName.getText());
			this.name.setText(crypted);
			
			
			
			
			if(senhaBate(v)==true) {
				this.bool.setText("true");
				alerta(name.getText());
			}else {
				this.bool.setText("false");
			}
			em.close();
		});
		
		layout.getChildren().addAll(name,txtName,bool,btnConfere);
		Scene cena = new Scene(layout,200,200);
		this.setScene(cena);
		this.show();
	}
	
	private String crypt(String name) {
		
		
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    md.update(name.getBytes(),0,name.length());
	    this.nameCrypted = new BigInteger(1,md.digest()).toString(16);
		
	    return nameCrypted;
	}
	
	private void alerta(String cryp) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("FOI PORRA");
		alert.setHeaderText("OPERAÇÃO FOI PORRAAAA");
		alert.setContentText("ESSA CARAIA DO "+cryp+"É IGUAL O ROLE");
		
		alert.showAndWait();
	}
	
	private boolean senhaBate(Voto v) {
		boolean resultado;
		
		EntityManager em = BancoDeDados.criaGerenciador();

		Query q = em.createQuery("from Voto where eleitor=:eleitor");
		q.setParameter("eleitor", crypt(this.txtName.getText()));

		if (q.getResultList().size() > 0) {
			resultado = true;
		}else {
			resultado = false;
		}

		em.clear();
		em.close();
		return resultado;
	}
}
