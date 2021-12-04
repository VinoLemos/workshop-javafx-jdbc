package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	// Dependência de Department e DepartmentService
	private Department entity;
	private DepartmentService service;

	public void setDepartment(Department entity) {
		this.entity = entity;
	}
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

// Botões, Labels e TextFields
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	@FXML
	private Label labelErrorName;
	@FXML
	private Button btSave;
	@FXML
	private Button btCancel;

// Ações a serem executadas	
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		try {
		entity = getFormData();
		service.saveOrUpdate(entity);
		Utils.currentStage(event).close();
		}
		catch (DbException e ) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}

	// Insere os dados do DepartmentForm no objeto
	private Department getFormData() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		return obj;
	}
	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TextField receberá apenas valores Integer
		Constraints.setTextFieldInteger(txtId);
		// TextField terá limite de 30 caracteres
		Constraints.setTextFieldMaxLenght(txtName, 30);
	}

	// Método responsável por popular os textFields com os dados do departamento
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
			txtId.setText(String.valueOf(entity.getId()));
			txtName.setText(entity.getName());
	}
}
