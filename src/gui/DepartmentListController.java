package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable{

// 	Seção de referências aos componentes visuais 
	
	// TableView
	@FXML
	private TableView<Department> tableViewDepartment;
	
	// Colunas
	@FXML
	private TableColumn<Department, Integer> tableColumnId;
	
	@FXML 
	private TableColumn<Department, String> tableColumnName;
	
	// Botão
	@FXML
	private Button btNew;

//	Actions a serem executadas 
	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}

	// Inicia um componente
	private void initializeNodes() {
		// Inicia o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		// Acessa a classe principal, e recebe a janela do stage, fazendo downcasting para Stage
		Stage stage = (Stage) Main.getMainScene().getWindow();
		
		// Tabela de departamentos acompanhará a altura da janela principal
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}

}
