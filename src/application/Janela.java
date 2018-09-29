package application;

import java.io.File;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.property.Getter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Janela extends Stage {

	AnchorPane layout = new AnchorPane();
	VBox digitos = new VBox();
	HBox hbx1 = new HBox(), hbx2 = new HBox(), hbx3 = new HBox(), hbx4 = new HBox(), hbx5 = new HBox();
	Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnInv, btnConfere;
	Button btnConfirma = new Button("Confirma"), btnCorrige = new Button("Corrige"), btnBranco = new Button("Branco");
	HBox hbxLbl1 = new HBox();
	HBox hbxLbl2 = new HBox();
	HBox hbxOrg = new HBox();
	TextField lbl1=new TextField(),lbl2=new TextField();
	ImageView candidato = new ImageView();
	Label lblName = new Label("Nome do Candidato"),lblPartido= new Label("Nome do Partido");
	
	//teste
	
	File alvaro = new File("Resources/alvaro.jpg");
	Image imgAlvaro = new Image(alvaro.toURI().toString());
	
	File bolo = new File("Resources/bolo.jpg");
	Image imgBolo = new Image(bolo.toURI().toString());
	File ciro = new File("Resources/cirao.jpg");
	Image imgCiro = new Image(ciro.toURI().toString());
	File marina = new File("Resources/dinossaur.jpg");
	Image imgMarina = new Image(marina.toURI().toString());
	File bonoro = new File("Resources/elenao.jpg");
	Image imgBonoro = new Image(bonoro.toURI().toString());
	File haddad = new File("Resources/haddad.jpg");
	Image imgHaddad = new Image(haddad.toURI().toString());
	File amoedo = new File("Resources/itau.jpg");
	Image imgAmoedo = new Image(amoedo.toURI().toString());
	File alckmin = new File("Resources/merenda.jpg");
	Image imgAlckmin = new Image(alckmin.toURI().toString());
	File meireles = new File("Resources/predefunto.jpg");
	Image imgMeireles = new Image(meireles.toURI().toString());
	File deus = new File("Resources/rog.png");
	Image imgDeus = new Image(deus.toURI().toString());
	
	File init = new File("Resources/bonoronao.jpg");
	Image imgInit = new Image(init.toURI().toString());
	int cont=0;
	int n1,n2;
	private String nomeEleitor;
	public Janela() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Operação inválida");
		alert.setContentText("São apenas 2 digitos, favor aperte Corrige ou Confirmar.");
		
		
		btn1 = new Button("1");
		btn1.setPrefHeight(100);
		btn1.setPrefWidth(100);

		btn2 = new Button("2");
		btn2.setPrefHeight(100);
		btn2.setPrefWidth(100);

		btn3 = new Button("3");
		btn3.setPrefHeight(100);
		btn3.setPrefWidth(100);

		btn4 = new Button("4");
		btn4.setPrefHeight(100);
		btn4.setPrefWidth(100);

		btn5 = new Button("5");
		btn5.setPrefHeight(100);
		btn5.setPrefWidth(100);

		btn6 = new Button("6");
		btn6.setPrefHeight(100);
		btn6.setPrefWidth(100);

		btn7 = new Button("7");
		btn7.setPrefHeight(100);
		btn7.setPrefWidth(100);

		btn8 = new Button("8");
		btn8.setPrefHeight(100);
		btn8.setPrefWidth(100);

		btn9 = new Button("9");
		btn9.setPrefHeight(100);
		btn9.setPrefWidth(100);

		btn0 = new Button("0");
		btn0.setPrefHeight(100);
		btn0.setPrefWidth(100);

		btnInv = new Button("1");
		btnInv.setPrefHeight(100);
		btnInv.setPrefWidth(100);
		btnInv.setVisible(false);

		btnConfere = new Button("Conferir");
		btnConfere.setPrefHeight(100);
		btnConfere.setPrefWidth(100);
		btnConfere.setVisible(false);

		btnBranco.setPrefHeight(50);
		btnBranco.setPrefWidth(100);
		btnBranco.setId("Branco");

		btnCorrige.setPrefHeight(50);
		btnCorrige.setPrefWidth(100);
		btnCorrige.setId("Corrige");
		
		btnConfirma.setPrefHeight(50);
		btnConfirma.setPrefWidth(100);
		btnConfirma.setId("Confirma");
		
		hbxLbl1.setId("Numero");
		hbxLbl1.getChildren().add(lbl1);
		hbxLbl2.setId("Numero");
		hbxLbl2.getChildren().add(lbl2);
		hbxOrg.getChildren().addAll(hbxLbl1,hbxLbl2);
		hbxOrg.setSpacing(15);
		
		candidato.setImage(imgInit);
		candidato.setFitHeight(500);
		candidato.setFitWidth(500);
		
		hbx1.getChildren().addAll(btn1, btn2, btn3);
		hbx1.setSpacing(5);
		hbx2.getChildren().addAll(btn4, btn5, btn6);
		hbx2.setSpacing(5);
		hbx3.getChildren().addAll(btn7, btn8, btn9);
		hbx3.setSpacing(5);
		hbx4.getChildren().addAll(btnInv, btn0, btnConfere);
		hbx4.setSpacing(5);
		hbx5.getChildren().addAll(btnBranco, btnCorrige, btnConfirma);
		hbx5.setSpacing(5);
		
		lbl1.setId("textbox");
		lbl1.setPrefHeight(150);
		lbl1.setPrefWidth(100);
		lbl1.setDisable(true);
		
		lbl2.setId("textbox");
		lbl2.setPrefHeight(150);
		lbl2.setPrefWidth(100);
		lbl2.setDisable(true);
		
		//fim visual
		
		
		this.btn1.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("1");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("1");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
			
			
		});
		this.btn2.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("2");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("2");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
		});
		this.btn3.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("3");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("3");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
		});
		this.btn4.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("4");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("4");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
		});
		this.btn5.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("5");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("5");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
		});
		this.btn6.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("6");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("6");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
		});
		this.btn7.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("7");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("7");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
		});
		this.btn8.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("8");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("8");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
		});
		this.btn9.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("9");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("9");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
		});
		this.btn0.setOnAction(e ->{
			if(cont==0) {
				this.lbl1.setText("0");
				cont++;
			}else if(cont==1) {
				this.lbl2.setText("0");
				cont++;
			}else if(cont==2){
				alert.showAndWait();
			}
		});
		lbl1.setText("");
		lbl2.setText("");
		
		this.btnCorrige.setOnAction(e ->{
			lbl1.setText("");
			lbl2.setText("");
			cont=0;
		});
		if(lbl1.getText()=="") {
			n1=0;
		}
		if(lbl2.getText()=="") {
			n2=0;
		}
		
		lbl1.textProperty().addListener((observable, oldValue, newValue) -> {
		    try {
			n1 = Integer.parseInt(lbl1.getText());
		    }catch (Exception e) {
				System.out.println("a");
			}
		    
		});
		
		lbl2.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				n2 = Integer.parseInt(lbl2.getText());
			    }catch (Exception e) {
					System.out.println("a");
				}
			    
		    if(n1==1&&n2==7) {
		    	candidato.setImage(imgBonoro);
		    	this.lblName.setText("Bolsonaro");
		    	this.lblPartido.setText("PSL");
		    }else if(n1==1&&n2==3) {
		    	candidato.setImage(imgHaddad);
		    	this.lblName.setText("Haddad");
		    	this.lblPartido.setText("PT");
		    }else if(n1==1&&n2==2) {
		    	candidato.setImage(imgCiro);
		    	this.lblName.setText("Ciro Gomes");
		    	this.lblPartido.setText("PDT");
		    }else if(n1==4&&n2==5) {
		    	candidato.setImage(imgAlckmin);
		    	this.lblName.setText("Geraldo Alckmin");
		    	this.lblPartido.setText("PSDB");
		    }else if(n1==1&&n2==8) {
		    	candidato.setImage(imgMarina);
		    	this.lblName.setText("Marina Silva");
		    	this.lblPartido.setText("Rede");
		    }else if(n1==1&&n2==9) {
		    	candidato.setImage(imgAlvaro);
		    	this.lblName.setText("Alvaro Dias");
		    	this.lblPartido.setText("Podemos");
		    }else if(n1==1&&n2==5) {
		    	candidato.setImage(imgMeireles);
		    	this.lblName.setText("Henrique Meirelles");
		    	this.lblPartido.setText("MDB");
		    }else if(n1==3&&n2==0) {
		    	candidato.setImage(imgAmoedo);
		    	this.lblName.setText("João Amoedo");
		    	this.lblPartido.setText("Novo");
		    }else if(n1==5&&n2==0) {
		    	candidato.setImage(imgBolo);
		    	this.lblName.setText("Guilherme Boulos");
		    	this.lblPartido.setText("PSOL");
		    }else if(n1==6&&n2==9) {
		    	candidato.setImage(imgDeus);
		    	this.lblName.setText("Roger");
		    	this.lblPartido.setText("PQPREQOROK");
		    }else {
		    	candidato.setImage(imgInit);
		    	this.lblName.setText("Nome do Candidato");
		    	this.lblPartido.setText("Nome do Partido");
		    }
		});
		
		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle("Insira seu nome");
		dialog.setHeaderText("Por favor, insira seu nome");
		dialog.setContentText("Please enter your name:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		
		result.ifPresent(name -> nomeEleitor = name);	
		
		
		
		this.btnConfirma.setOnAction(e->{
			Voto v = new Voto();
			v.setCandidato(this.lblName.getText());
			v.setEleitor(this.nomeEleitor);
			
			this.efetuarVoto(v);
			
			
			lbl1.setText(" ");
			lbl2.setText(" ");
			cont=0;
		});
		
		
	
	
		digitos.getChildren().addAll(hbx1, hbx2, hbx3, hbx4, hbx5);
		digitos.setSpacing(15);

		layout.getChildren().addAll(digitos,hbxOrg,candidato,lblName,lblPartido);
		AnchorPane.setRightAnchor(digitos, 15d);
		AnchorPane.setRightAnchor(hbxOrg, 750d);
		AnchorPane.setRightAnchor(lblName, 750d);
		AnchorPane.setTopAnchor(lblName, 200d);
		AnchorPane.setRightAnchor(lblPartido, 750d);
		AnchorPane.setTopAnchor(lblPartido, 300d);

		Scene cena = new Scene(layout, 1500, 600);
		cena.getStylesheets().add(Janela.class.getResource("application.css").toExternalForm());
		this.setScene(cena);
		this.show();

	}
	
	
	private void efetuarVoto(Voto v) {
		EntityManager em = BancoDeDados.criaGerenciador();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.clear();
		em.close();
	}

}
