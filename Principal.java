/* ***************************************************************
* Autor............: Caique Santos Santana
* Matricula........: 202010643
* Inicio...........: 25/11/2023
* Ultima alteracao.: 04/12/2023
* Nome.............: Principal do Transito Autonomo
* Funcao...........: Importa o que eh necessario para iniciar
Starta as Cenas e carrega o FXML e inicia o programa
****************************************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import controller.controle;

public class Principal extends Application {

	// Metodo principal que inicia a aplicacao JavaFX
	public static void main(String[] args) {
		launch(args);
	}

	// Metodo start() eh chamado quando a aplicacao eh iniciada
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Carrega a interface grafica a partir do arquivo FXML
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PrincipalFXML.fxml"));
		AnchorPane root = loader.load();
		// Cria uma cena (Scene) com o layout carregado e define as dimensoes
		Scene cena = new Scene(root, 1280, 1024);
		// Configura o palco (Stage) com a cena, titulo e outras propriedades
		primaryStage.setScene(cena);
		primaryStage.setTitle("202010643 - Transito Autonomo");
		primaryStage.setResizable(false);
		// Exibe o palco ao usuario
		primaryStage.show();
	}

}
