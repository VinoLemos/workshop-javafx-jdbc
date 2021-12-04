package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {

	// Dependência de Department
	private Department entity;

	public void setDepartment(Department entity) {
		this.entity = entity;
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
	public void onBtSaveAction() {
		System.out.println("onBtSaveAction");
	}

	@FXML
	public void onBtCancelAction() {
		System.out.println("onBtCancelAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TextField receberá apenas valores Integer
		Constraints.setTextFieldInteger(txtId);
		// TextField terá limite de 30 caracteres
		Constraints.setTextFieldMaxLenght(txtName, 30);
	}

	// Método responsável por popular os textFields com os dados do departamento
	public void updateFormaData() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
			txtId.setText(String.valueOf(entity.getId()));
			txtName.setText(entity.getName());
	}
}
