/* ***************************************************************
* Autor............: Caique Santos Santana
* Matricula........: 202010643
* Inicio...........: 25/11/2023
* Ultima alteracao.: 04/12/2023
* Nome.............: Controle do Transito Autonomo
* Funcao...........: A classe controle serve como um controlador para a interacao entre a logica da simulacao, a interface grafica e a interacao do usuario. Ela encapsula a logica de controle do simulador de percursos de carros.
****************************************************************/
package controller;

import java.util.concurrent.Semaphore;
import model.carros;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class controle {

	// Anotacoes FXML para injetar elementos do arquivo FXML
	@FXML
	ImageView inicio;

	@FXML
	ImageView guia;

	@FXML
	ImageView cenario;

	@FXML
	ImageView carro2;// carro do percurso 2

	@FXML
	ImageView carro3;// carro do percurso 7

	@FXML
	ImageView carro4;// carro do percurso 12

	@FXML
	ImageView carro5;// carro do percurso 14

	@FXML
	ImageView carro6;// carro do percurso 17

	@FXML
	ImageView carro7;// carro do percurso 22

	@FXML
	Button botaoC2;

	@FXML
	ImageView caminho2;

	@FXML
	ImageView caminho7;

	@FXML
	Button botaoC7;

	@FXML
	ImageView caminho12;

	@FXML
	Button botaoC12;

	@FXML
	ImageView caminho14;

	@FXML
	Button botaoC14;

	@FXML
	ImageView caminho17;

	@FXML
	Button botaoC17;

	@FXML
	ImageView caminho22;

	@FXML
	Button botaoC22;

	@FXML
	Slider velocidadeCarro2;

	@FXML
	Slider velocidadeCarro3;

	@FXML
	Slider velocidadeCarro4;

	@FXML
	Slider velocidadeCarro5;

	@FXML
	Slider velocidadeCarro6;

	@FXML
	Slider velocidadeCarro7;

	@FXML
	Button botaoAvancar;

	@FXML
	Button botaoIniciar;

	@FXML
	Button botaoReiniciar;

	// Variaveis para controlar o estado da simulacao
	private boolean rodando = true;
	private carros percurso2;
	private carros percurso7;
	private carros percurso12;
	private carros percurso14;
	private carros percurso17;
	private carros percurso22;
	private int posx = 0;
	private int posy = 0;

	// Arrays de semaforos para controlar o acesso a diferentes percursos
	public static Semaphore[] Semaforo_Percursos_2_E_7 = new Semaphore[2];
	public static Semaphore[] Semaforo_Percursos_2_E_12 = new Semaphore[3];
	public static Semaphore[] Semaforo_Percursos_7_E_12 = new Semaphore[1];
	public static Semaphore[] Semaforo_Percursos_2_E_14 = new Semaphore[1];
	public static Semaphore[] Semaforo_Percursos_7_E_14 = new Semaphore[1];
	public static Semaphore[] Semaforo_Percursos_12_E_14 = new Semaphore[1];
	public static Semaphore[] Semaforo_Percursos_2_E_17 = new Semaphore[3];
	public static Semaphore[] Semaforo_Percursos_7_E_17 = new Semaphore[1];
	public static Semaphore[] Semaforo_Percursos_14_E_17 = new Semaphore[1];
	public static Semaphore[] Semaforo_Percursos_12_E_17 = new Semaphore[2];
	public static Semaphore[] Semaforo_Percursos_7_E_22 = new Semaphore[3];
	public static Semaphore[] Semaforo_Percursos_2_E_22 = new Semaphore[4];
	public static Semaphore[] Semaforo_Percursos_12_E_22 = new Semaphore[2];
	public static Semaphore[] Semaforo_Percursos_14_E_22 = new Semaphore[3];

	/**
	 * Metodo: Initialize
	 * Inicializa o estado da interface grafica e dos elementos da simulacao.
	 * Oculta controles, carros, e caminhos, alem de configurar inicialmente
	 * desabilitados.
	 * 
	 * @return void
	 */
	public void initialize() {
		// Oculta os controles de velocidade
		velocidadeCarro2.setVisible(false);
		velocidadeCarro3.setVisible(false);
		velocidadeCarro4.setVisible(false);
		velocidadeCarro5.setVisible(false);
		velocidadeCarro6.setVisible(false);
		velocidadeCarro7.setVisible(false);

		// Oculta elementos visuais como guia, cenario e botoes de iniciar/reiniciar
		guia.setVisible(false);
		cenario.setVisible(false);
		botaoIniciar.setVisible(false);
		botaoIniciar.setDisable(true);
		botaoReiniciar.setVisible(false);
		botaoReiniciar.setDisable(true);

		// Oculta os carros da simulacao
		carro2.setVisible(false);
		carro3.setVisible(false);
		carro4.setVisible(false);
		carro5.setVisible(false);
		carro6.setVisible(false);
		carro7.setVisible(false);

		// Configura os botoes de caminho e os oculta
		botaoC2.setDisable(true);
		botaoC2.setVisible(false);
		caminho2.setVisible(false);

		botaoC7.setDisable(true);
		botaoC7.setVisible(false);
		caminho7.setVisible(false);

		botaoC12.setDisable(true);
		botaoC12.setVisible(false);
		caminho12.setVisible(false);

		botaoC14.setDisable(true);
		botaoC14.setVisible(false);
		caminho14.setVisible(false);

		botaoC17.setDisable(true);
		botaoC17.setVisible(false);
		caminho17.setVisible(false);

		botaoC22.setDisable(true);
		botaoC22.setVisible(false);
		caminho22.setVisible(false);

	}

	/**
	 * Metodo: mostrarC2
	 * Alterna a visibilidade do caminho 2.
	 * Este metodo eh chamado quando o botao associado ao caminho 2 eh pressionado.
	 * 
	 * @param event O evento de acao associado ao botao.
	 */
	@FXML
	private void mostrarC2(ActionEvent event) {
		if (!caminho2.isVisible()) {
			caminho2.setVisible(true);
			caminho2.setDisable(true);
		} else {
			caminho2.setVisible(false);
		}
	}

	/**
	 * Metodo: mostrarC7
	 * Alterna a visibilidade do caminho 7.
	 * Este metodo eh chamado quando o botao associado ao caminho 7 eh pressionado.
	 * 
	 * @param event O evento de acao associado ao botao.
	 */
	@FXML
	private void mostrarC7(ActionEvent event) {
		if (!caminho7.isVisible()) {
			caminho7.setVisible(true);
			caminho7.setDisable(true);
		} else {
			caminho7.setVisible(false);
		}
	}

	/**
	 * Metodo: mostrarC12
	 * Alterna a visibilidade do caminho 12.
	 * Este metodo eh chamado quando o botao associado ao caminho 12 eh pressionado.
	 * 
	 * @param event O evento de acao associado ao botao.
	 */
	@FXML
	private void mostrarC12(ActionEvent event) {
		if (!caminho12.isVisible()) {
			caminho12.setVisible(true);
			caminho12.setDisable(true);
		} else {
			caminho12.setVisible(false);
		}
	}

	/**
	 * Metodo: mostrarC14
	 * Alterna a visibilidade do caminho 14.
	 * Este metodo eh chamado quando o botao associado ao caminho 14 eh pressionado.
	 * 
	 * @param event O evento de acao associado ao botao.
	 */
	@FXML
	private void mostrarC14(ActionEvent event) {
		if (!caminho14.isVisible()) {
			caminho14.setVisible(true);
			caminho14.setDisable(true);
		} else {
			caminho14.setVisible(false);
		}
	}

	/**
	 * Metodo: mostrarC17
	 * Alterna a visibilidade do caminho 17.
	 * Este metodo eh chamado quando o botao associado ao caminho 17 eh pressionado.
	 * 
	 * @param event O evento de acao associado ao botao.
	 */
	@FXML
	private void mostrarC17(ActionEvent event) {
		if (!caminho17.isVisible()) {
			caminho17.setVisible(true);
			caminho17.setDisable(true);
		} else {
			caminho17.setVisible(false);
		}
	}

	/**
	 * Metodo: mostrarC22
	 * Alterna a visibilidade do caminho 22.
	 * Este metodo eh chamado quando o botao associado ao caminho 22 eh pressionado.
	 * 
	 * @param event O evento de acao associado ao botao.
	 */
	@FXML
	private void mostrarC22(ActionEvent event) {
		if (!caminho22.isVisible()) {
			caminho22.setVisible(true);
			caminho22.setDisable(true);
		} else {
			caminho22.setVisible(false);
		}
	}

	/**
	 * Metodo: inicializarSemaforos
	 * Inicializa os semaforos utilizados para controle de concorrencia nos
	 * percursos.
	 * Cria semaforos para cada par de percursos que podem interagir.
	 * 
	 * @return void
	 */
	private void inicializarSemaforos() {
		// Inicializa semaforos para os percursos 2 e 7
		for (int i = 0; i < Semaforo_Percursos_2_E_7.length; i++) {
			Semaforo_Percursos_2_E_7[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 2 e 12
		for (int i = 0; i < Semaforo_Percursos_2_E_12.length; i++) {
			Semaforo_Percursos_2_E_12[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 7 e 12
		for (int i = 0; i < Semaforo_Percursos_7_E_12.length; i++) {
			Semaforo_Percursos_7_E_12[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 2 e 14
		for (int i = 0; i < Semaforo_Percursos_2_E_14.length; i++) {
			Semaforo_Percursos_2_E_14[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 7 e 14
		for (int i = 0; i < Semaforo_Percursos_7_E_14.length; i++) {
			Semaforo_Percursos_7_E_14[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 12 e 14
		for (int i = 0; i < Semaforo_Percursos_12_E_14.length; i++) {
			Semaforo_Percursos_12_E_14[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 2 e 17
		for (int i = 0; i < Semaforo_Percursos_2_E_17.length; i++) {
			Semaforo_Percursos_2_E_17[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 7 e 17
		for (int i = 0; i < Semaforo_Percursos_7_E_17.length; i++) {
			Semaforo_Percursos_7_E_17[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 14 e 17
		for (int i = 0; i < Semaforo_Percursos_14_E_17.length; i++) {
			Semaforo_Percursos_14_E_17[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 12 e 17
		for (int i = 0; i < Semaforo_Percursos_12_E_17.length; i++) {
			Semaforo_Percursos_12_E_17[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 7 e 22
		for (int i = 0; i < Semaforo_Percursos_7_E_22.length; i++) {
			Semaforo_Percursos_7_E_22[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 2 e 22
		for (int i = 0; i < Semaforo_Percursos_2_E_22.length; i++) {
			Semaforo_Percursos_2_E_22[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 12 e 22
		for (int i = 0; i < Semaforo_Percursos_12_E_22.length; i++) {
			Semaforo_Percursos_12_E_22[i] = new Semaphore(1);
		}
		// Inicializa semaforos para os percursos 14 e 22
		for (int i = 0; i < Semaforo_Percursos_14_E_22.length; i++) {
			Semaforo_Percursos_14_E_22[i] = new Semaphore(1);
		}
	}

	/**
	 * Metodo: avancar
	 * Realiza a transicao para a fase de avanco do cenario.
	 * Oculta o botao de avanco, desabilita-o, oculta a tela inicial,
	 * exibe a guia e habilita o botao de inicio.
	 * 
	 * @return void
	 */
	public void avancar() {
		botaoAvancar.setVisible(false);
		botaoAvancar.setDisable(true);
		inicio.setVisible(false);
		guia.setVisible(true);
		botaoIniciar.setVisible(true);
		botaoIniciar.setDisable(false);
	}

	/**
	 * Metodo: iniciar
	 * Inicia a simulacao do percurso, configurando o cenario e inicializando os
	 * carros.
	 * Oculta a guia, exibe o cenario, oculta o botao de inicio, desabilita-o,
	 * exibe o botao de reinicio, habilita-o, exibe e configura os controles de
	 * velocidade,
	 * exibe e configura os botoes dos percursos, posiciona os carros no cenario e
	 * inicializa os semaforos para controle de concorrencia.
	 */
	public void iniciar() {
		// Oculta a guia
		guia.setVisible(false);
		// Exibe o cenario
		cenario.setVisible(true);
		// Oculta o botao de inicio e desabilita-o
		botaoIniciar.setVisible(false);
		botaoIniciar.setDisable(true);
		// Exibe o botao de reinicio e habilita-o
		botaoReiniciar.setVisible(true);
		botaoReiniciar.setDisable(false);
		// Exibe e configura os controles de velocidade
		velocidadeCarro2.setVisible(true);
		velocidadeCarro3.setVisible(true);
		velocidadeCarro4.setVisible(true);
		velocidadeCarro5.setVisible(true);
		velocidadeCarro6.setVisible(true);
		velocidadeCarro7.setVisible(true);
		velocidadeCarro2.setValue(5);
		velocidadeCarro3.setValue(5);
		velocidadeCarro4.setValue(5);
		velocidadeCarro5.setValue(5);
		velocidadeCarro6.setValue(5);
		velocidadeCarro7.setValue(5);

		// Exibe e habilita os botoes dos percursos
		botaoC2.setDisable(false);
		botaoC2.setVisible(true);

		botaoC7.setDisable(false);
		botaoC7.setVisible(true);

		botaoC12.setDisable(false);
		botaoC12.setVisible(true);

		botaoC14.setDisable(false);
		botaoC14.setVisible(true);

		botaoC17.setDisable(false);
		botaoC17.setVisible(true);

		botaoC22.setDisable(false);
		botaoC22.setVisible(true);

		// Posiciona os carros
		carro2.setX(470);
		carro2.setY(335);
		carro2.setVisible(true);

		carro3.setX(870);
		carro3.setY(335);
		carro3.setVisible(true);

		carro4.setX(175);
		carro4.setY(100);
		carro4.setRotate(0);
		carro4.setVisible(true);

		carro5.setX(545);
		carro5.setY(100);
		carro5.setVisible(true);

		carro6.setX(480);
		carro6.setY(860);
		carro6.setRotate(-90);
		carro6.setVisible(true);

		carro7.setX(60);
		carro7.setY(160);
		carro7.setRotate(90);
		carro7.setVisible(true);

		// Inicializa os semaforos
		inicializarSemaforos();

		// Inicializa e configura os carros
		percurso2 = new carros(this, 2, 2);
		percurso7 = new carros(this, 7, 3);
		percurso12 = new carros(this, 12, 4);
		percurso14 = new carros(this, 14, 5);
		percurso17 = new carros(this, 17, 6);
		percurso22 = new carros(this, 22, 7);

		// Configura os carros como threads daemon
		percurso2.setDaemon(true);
		percurso7.setDaemon(true);
		percurso12.setDaemon(true);
		percurso14.setDaemon(true);
		percurso17.setDaemon(true);
		percurso22.setDaemon(true);

		// Inicia as threads dos carros
		percurso14.start();
		percurso2.start();
		percurso7.start();
		percurso12.start();
		percurso17.start();
		percurso22.start();
	}

	/**
	 * Metodo: posicaoOriginal
	 * Reposiciona o carro na sua posicao original no cenario com base no
	 * identificador do carro.
	 * Utiliza a classe Platform para executar as operacoes na thread de interface
	 * grafica.
	 *
	 * @param carro Identificador do carro cuja posicao sera restaurada.
	 * @return void
	 */
	public void posicaoOriginal(int carro) {
		Platform.runLater(() -> {
			switch (carro) {
				case 2:
					carro2.setX(470);
					carro2.setY(335);
					break;
				case 3:
					carro3.setX(870);
					carro3.setY(335);
					break;
				case 4:
					carro4.setX(175);
					carro4.setY(100);
					break;
				case 5:
					carro5.setX(545);
					carro5.setY(100);
					break;
				case 6:
					carro6.setX(480);
					carro6.setY(860);
					break;
				case 7:
					carro7.setX(60);
					carro7.setY(160);
					break;
				default:
					break;
			}
		});
	}

	/**
	 * Reinicia o estado do cenario e reinicia as threads dos carros.
	 * Usa a anotacao @SuppressWarnings("deprecation") para evitar warnings
	 * relacionados ao metodo stop().
	 */
	@SuppressWarnings("deprecation")
	public void reiniciar() {
		// para as threads
		percurso2.stop();
		percurso7.stop();
		percurso12.stop();
		percurso14.stop();
		percurso17.stop();
		percurso22.stop();

		// reposiciona os carros
		carro2.setX(470);
		carro2.setY(335);
		carro2.setVisible(true);

		carro3.setX(870);
		carro3.setY(335);
		carro3.setVisible(true);

		carro4.setX(175);
		carro4.setY(100);
		carro4.setRotate(0);
		carro4.setVisible(true);

		carro5.setX(545);
		carro5.setY(100);
		carro5.setVisible(true);

		carro6.setX(480);
		carro6.setY(860);
		carro6.setRotate(-90);
		carro6.setVisible(true);

		carro7.setX(60);
		carro7.setY(160);
		carro7.setRotate(90);
		carro7.setVisible(true);

		percurso2.tempoDeReinicio();

		// torna os caminhos invisiveis
		caminho2.setVisible(false);
		caminho7.setVisible(false);
		caminho12.setVisible(false);
		caminho14.setVisible(false);
		caminho17.setVisible(false);
		caminho22.setVisible(false);

		// chama o metodo iniciar
		iniciar();

	}

	/**
	 * Metodo: moverY
	 * Move um carro na direcao vertical para a posicao especificada.
	 * Utiliza a classe Platform.runLater para garantir a execucao na thread de
	 * JavaFX.
	 *
	 * @param carro   Numero do carro a ser movido.
	 * @param posicao Posicao Y para a qual o carro deve ser movido.
	 * @return void
	 */
	public void moverY(int carro, double posicao) {
		Platform.runLater(() -> {
			switch (carro) {
				case 2:
					if (carro2 != null) {
						carro2.setY(posicao);
					}
					break;
				case 3:
					if (carro3 != null) {
						carro3.setY(posicao);
					}
					break;
				case 4:
					if (carro4 != null) {
						carro4.setY(posicao);
					}
					break;
				case 5:
					if (carro5 != null) {
						carro5.setY(posicao);
					}
					break;
				case 6:
					if (carro6 != null) {
						carro6.setY(posicao);
					}
					break;
				case 7:
					if (carro7 != null) {
						carro7.setY(posicao);
					}
					break;

			}
		});
	}

	/**
	 * Metodo: moverX
	 * Move um carro na direcao horizontal para a posicao especificada.
	 * Utiliza a classe Platform.runLater para garantir a execucao na thread de
	 * JavaFX.
	 *
	 * @param carro   Numero do carro a ser movido.
	 * @param posicao Posicao X para a qual o carro deve ser movido.
	 * @return void
	 */
	public void moverX(int carro, double posicao) {
		Platform.runLater(() -> {
			switch (carro) {
				case 2:
					if (carro2 != null) { // Verifique se carro2 esta inicializado
						carro2.setX(posicao);// coloca o carro2 na sua nova posicao
					}
					break;
				case 3:
					if (carro3 != null) { // Verifique se carro3 esta inicializado
						carro3.setX(posicao);// coloca o carro3 na sua nova posicao
					}
					break;
				case 4:
					if (carro4 != null) { // Verifique se carro4 esta inicializado
						carro4.setX(posicao);// coloca o carro4 na sua nova posicao
					}
					break;
				case 5:
					if (carro5 != null) { // Verifique se carro5 esta inicializado
						carro5.setX(posicao);// coloca o carro5 na sua nova posicao
					}
					break;
				case 6:
					if (carro6 != null) { // Verifique se carro6 esta inicializado
						carro6.setX(posicao);// coloca o carro6 na sua nova posicao
					}
					break;
				case 7:
					if (carro7 != null) { // Verifique se carro7 esta inicializado
						carro7.setX(posicao);// coloca o carro7 na sua nova posicao
					}
					break;
			}
		});
	}

	/**
	 * Metodo: setRotacao
	 * Define a rotacao de um carro.
	 * Utiliza a classe Platform.runLater para garantir a execucao na thread de
	 * JavaFX.
	 *
	 * @param carro   Numero do carro para o qual a rotacao sera definida.
	 * @param rotacao Valor da rotacao a ser definido para o carro.
	 * @return void
	 */
	public void setRotacao(int carro, double rotacao) {
		Platform.runLater(() -> {
			switch (carro) {
				case 2:
					carro2.setRotate(rotacao);
					break;
				case 3:
					carro3.setRotate(rotacao);
					break;
				case 4:
					carro4.setRotate(rotacao);
					break;
				case 5:
					carro5.setRotate(rotacao);
					break;
				case 6:
					carro6.setRotate(rotacao);
					break;
				case 7:
					carro7.setRotate(rotacao);
					break;
			}
		});
	}

	/**
	 * Metodo:getPosicaoX
	 * Obtem a posicao X de um carro.
	 *
	 * @param carro Numero do carro para o qual a posicao X sera obtida.
	 * @return A posicao X do carro.
	 */
	public double getPosicaoX(int carro) {
		double posicao = posx;
		switch (carro) {// verifica qual o carro especifico
			case 2:
				posicao = carro2.getX();
				break;
			case 3:
				posicao = carro3.getX();
				break;
			case 4:
				posicao = carro4.getX();
				break;
			case 5:
				posicao = carro5.getX();
				break;
			case 6:
				posicao = carro6.getX();
				break;
			case 7:
				posicao = carro7.getX();
				break;
		}
		return posicao; // retorna a posicao X do mesmo
	}

	/**
	 * Metodo:getPosicaoY
	 * Obtem a posicao Y de um carro.
	 *
	 * @param carro Numero do carro para o qual a posicao Y sera obtida.
	 * @return A posicao Y do carro.
	 */
	public double getPosicaoY(int carro) {
		double posicao = posy;
		switch (carro) {// verifica qual o carro especifico
			case 2:
				posicao = carro2.getY();
				break;
			case 3:
				posicao = carro3.getY();
				break;
			case 4:
				posicao = carro4.getY();
				break;
			case 5:
				posicao = carro5.getY();
				break;
			case 6:
				posicao = carro6.getY();
				break;
			case 7:
				posicao = carro7.getY();
				break;
		}
		return posicao; // retorna a posicao Y do mesmo
	}

	/**
	 * Metodo: getVelocidadeCarros
	 * Obtem a velocidade de um carro pegando o valor do seu reespectivo slider e
	 * tranformando em inteiro
	 *
	 * @param carro Numero do carro para o qual a velocidade sera obtida.
	 * @return A velocidade do carro.
	 */
	public int getVelocidadeCarros(int carro) {
		int retorno = 0;
		double aux = 0;
		switch (carro) {
			case 2:
				aux = velocidadeCarro2.getValue();// pega o valor do slider e armazena em uma vriavel auxiliar
				retorno = (int) aux;// transforma o valor em inteiro
				break;
			case 3:
				aux = velocidadeCarro3.getValue();// pega o valor do slider e armazena em uma vriavel auxiliar
				retorno = (int) aux;// transforma o valor em inteiro
				break;
			case 4:
				aux = velocidadeCarro4.getValue();// pega o valor do slider e armazena em uma vriavel auxiliar
				retorno = (int) aux;// transforma o valor em inteiro
				break;
			case 5:
				aux = velocidadeCarro5.getValue();// pega o valor do slider e armazena em uma vriavel auxiliar
				retorno = (int) aux;// transforma o valor em inteiro
				break;
			case 6:
				aux = velocidadeCarro6.getValue();// pega o valor do slider e armazena em uma vriavel auxiliar
				retorno = (int) aux;// transforma o valor em inteiro
				break;
			case 7:
				aux = velocidadeCarro7.getValue();// pega o valor do slider e armazena em uma vriavel auxiliar
				retorno = (int) aux;// transforma o valor em inteiro
				break;
			default:
				break;
		}
		return retorno;
	}

	public boolean isRodando() {
		return rodando;
	}

	public void setRodando(boolean rodando) {
		this.rodando = rodando;
	}

}
