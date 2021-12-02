package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable{
	
	// Injeta a dependencia da classe DepartmentService
	private DepartmentService service; 
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

// 	Referências aos componentes visuais 
	
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
	
	// Lista que será associada ao TableView
	private ObservableList<Department> obsList;
	
	// Acessa o serviço, carrega os departamentos, e insere na ObservableList obsList
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		// Recebe dos os departamentos
		List<Department> list = service.findAll();
		// Insere os departamentos no ObservableList
		obsList = FXCollections.observableArrayList(list);
		// Insere a lista de departamentos no TableView
		tableViewDepartment.setItems(obsList);
	}

}
