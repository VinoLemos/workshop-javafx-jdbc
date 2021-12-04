package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

	// Acessa o Stage em que o controller que receber um evento está localizado
	public static Stage currentStage(ActionEvent event) {
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}
	
	// Converte o conteúdo da TextField para um valor inteiro
	public static Integer tryParseToInt(String str) {
		try {
		return Integer.parseInt(str);
		}
		// Retorna nulo caso seja digitado um valor inválido
		catch (NumberFormatException e) {
			return null;
		}
	}
}
