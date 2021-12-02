package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{

	@FXML
	private MenuItem menuItemSeller; 
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentList.fxml");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");
	}
	
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	
	// Insere os filhos da janela About na janela principal, mostrando o conteúdo da janela About na 
	// janela principal
	private synchronized void loadView(String absoluteName) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
		try {
			VBox newVBox = loader.load();
			
			// Carrega a cena principal
			Scene mainScene = Main.getMainScene();
			
			
			// Converte e recebe o primeiro elemento da view para ScrollPane, 
			// acessa o conteúdo, e converte tudo para um objeto VBox
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			// Recebe o primeiro elemento da VBox principal
			Node mainMenu = mainVBox.getChildren().get(0);
			// Limpa todos os filhos do mainVbox
			mainVBox.getChildren().clear();
			// Adiciona o mainMenu ao mainVBox
			mainVBox.getChildren().add(mainMenu);
			// Adiciona uma coleção com os filhos do newVbox na mainVbox
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
