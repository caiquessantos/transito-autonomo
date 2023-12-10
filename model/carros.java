/* ***************************************************************
* Autor............: Caique Santos Santana
* Matricula........: 202010643
* Inicio...........: 25/11/2023
* Ultima alteracao.: 04/12/2023
* Nome.............: Controle do Transito Autonomo
* Funcao...........: A classe carros encapsula o comportamento de movimento dos carros em um ambiente controlado por semaforos, representando possivelmente uma simulacao de trafego rodoviario.
****************************************************************/
package model;

import static controller.controle.Semaforo_Percursos_2_E_7;
import static controller.controle.Semaforo_Percursos_2_E_12;
import static controller.controle.Semaforo_Percursos_7_E_12;
import static controller.controle.Semaforo_Percursos_2_E_14;
import static controller.controle.Semaforo_Percursos_7_E_14;
import static controller.controle.Semaforo_Percursos_12_E_14;
import static controller.controle.Semaforo_Percursos_2_E_17;
import static controller.controle.Semaforo_Percursos_7_E_17;
import static controller.controle.Semaforo_Percursos_14_E_17;
import static controller.controle.Semaforo_Percursos_12_E_17;
import static controller.controle.Semaforo_Percursos_7_E_22;
import static controller.controle.Semaforo_Percursos_2_E_22;
import static controller.controle.Semaforo_Percursos_12_E_22;
import static controller.controle.Semaforo_Percursos_14_E_22;
import controller.controle;
import javafx.application.Platform;

public class carros extends Thread {

	private controle controle;
	private int percurso;
	private int carro;

	// Construtor
	public carros(controle c, int p, int car) {
		this.controle = c;
		this.percurso = p;
		this.carro = car;
	}

	/**
	 * Metodo: run
	 * Inicia a execucao da thread
	 * 
	 * @retun void
	 */
	public void run() {
		moverCarros();
	}

	/**
	 * Metodo: moverCarros
	 * Move os carros de acordo com o percurso especificado.
	 *
	 * Este meodo implementa a logica de movimento dos carros para diferentes
	 * percursos.
	 * Utiliza semaforos para controlar o acesso concorrente a recursos
	 * compartilhados.
	 * Cada caso (percurso) contem uma serie de movimentos especificos para o carro.
	 *
	 * @throws InterruptedException Se ocorrer uma interrupcao enquanto a thread
	 *                              estiver aguardando.
	 * @return void
	 */
	private void moverCarros() {
		while (true) {
			switch (percurso) {
				case 2:
					try {
						Semaforo_Percursos_2_E_17[1].acquire();
						Semaforo_Percursos_2_E_7[1].acquire();
						moverXfrente(this.carro, 10, 90);
						Semaforo_Percursos_2_E_12[1].acquire();
						Semaforo_Percursos_2_E_14[0].acquire();
						moverXfrente(this.carro, 70, 90);
						Semaforo_Percursos_2_E_7[1].release();
						moverYbaixo(this.carro, 170, 180);
						moverYbaixo(this.carro, 160, 180);
						Semaforo_Percursos_2_E_22[2].acquire();
						moverYbaixo(this.carro, 190, 180);
						moverXfrente(this.carro, 50, 90);
						Semaforo_Percursos_2_E_22[2].release();
						Semaforo_Percursos_2_E_17[1].release();
						Semaforo_Percursos_2_E_12[1].release();
						moverXfrente(this.carro, 160, 90);
						Semaforo_Percursos_2_E_22[1].acquire();
						Semaforo_Percursos_2_E_22[0].acquire();
						moverXfrente(this.carro, 160, 90);
						Semaforo_Percursos_2_E_17[0].acquire();
						moverYcima(this.carro, 100, 0);
						moverYcima(this.carro, 75, 0);
						moverYcima(this.carro, 175, 0);
						moverYcima(this.carro, 75, 0);
						Semaforo_Percursos_2_E_7[0].acquire();
						moverYcima(this.carro, 300, 0);
						Semaforo_Percursos_2_E_22[1].release();
						Semaforo_Percursos_2_E_22[3].acquire();
						moverYcima(this.carro, 150, 0);
						moverXtras(this.carro, 320, -90);
						moverXtras(this.carro, 60, -90);
						Semaforo_Percursos_2_E_14[0].release();
						Semaforo_Percursos_2_E_12[0].acquire();
						moverXtras(this.carro, 190, -90);
						moverXtras(this.carro, 60, -90);
						Semaforo_Percursos_2_E_22[0].release();
						moverXtras(this.carro, 130, -90);
						moverXtras(this.carro, 50, -90);
						Semaforo_Percursos_2_E_12[0].release();
						moverXtras(this.carro, 120, -90);
						moverYbaixo(this.carro, 125, 180);
						moverYbaixo(this.carro, 50, 180);
						moverYbaixo(this.carro, 105, 180);
						moverYbaixo(this.carro, 70, 180);
						moverYbaixo(this.carro, 50, 180);
						Semaforo_Percursos_2_E_7[0].release();
						moverYbaixo(this.carro, 300, 180);
						moverYbaixo(this.carro, 55, 180);
						Semaforo_Percursos_2_E_22[3].release();
						moverYbaixo(this.carro, 125, 180);
						moverXfrente(this.carro, 105, 90);
						Semaforo_Percursos_2_E_12[2].acquire();
						moverXfrente(this.carro, 80, 90);
						moverXfrente(this.carro, 185, 90);
						moverYcima(this.carro, 44, 0);
						Semaforo_Percursos_2_E_17[0].release();
						Semaforo_Percursos_2_E_12[2].release();
						moverYcima(this.carro, 134, 0);
						moverYcima(this.carro, 173, 0);
						moverYcima(this.carro, 80, 0);
						Semaforo_Percursos_2_E_7[1].acquire();
						Semaforo_Percursos_2_E_17[1].acquire();
						moverYcima(this.carro, 93, 0);
						moverXfrente(this.carro, 50, 90);
						Semaforo_Percursos_2_E_7[1].release();
						moverXfrente(this.carro, 60, 90);
						Semaforo_Percursos_2_E_17[1].release();

					} catch (Exception e) {
						e.printStackTrace();
					}
					controle.posicaoOriginal(this.carro);
					break;
				case 7:
					try {
						moverXtras(this.carro, 175, -90);
						Semaforo_Percursos_7_E_22[0].acquire();
						Semaforo_Percursos_2_E_7[1].acquire();
						moverXtras(this.carro, 75, -90);
						Semaforo_Percursos_7_E_17[0].acquire();
						moverXtras(this.carro, 275, -90);
						moverXtras(this.carro, 50, -90);
						Semaforo_Percursos_2_E_7[1].release();
						moverXtras(this.carro, 125, -90);
						moverXtras(this.carro, 75, -90);
						Semaforo_Percursos_7_E_22[2].acquire();
						Semaforo_Percursos_2_E_7[0].acquire();
						moverXtras(this.carro, 100, -90);
						moverYcima(this.carro, 55, 0);
						Semaforo_Percursos_7_E_17[0].release();
						moverYcima(this.carro, 120, 0);
						moverYcima(this.carro, 55, 0);
						Semaforo_Percursos_7_E_22[2].release();
						moverYcima(this.carro, 120, 0);
						moverXfrente(this.carro, 135, 90);
						Semaforo_Percursos_7_E_12[0].acquire();
						moverXfrente(this.carro, 185, 90);
						moverXfrente(this.carro, 50, 90);
						moverXfrente(this.carro, 135, 90);
						Semaforo_Percursos_7_E_14[0].acquire();
						moverXfrente(this.carro, 50, 90);
						Semaforo_Percursos_7_E_22[0].release();
						Semaforo_Percursos_7_E_12[0].release();
						moverXfrente(this.carro, 375, 90);
						moverYbaixo(this.carro, 125, 180);
						Semaforo_Percursos_7_E_22[1].acquire();
						moverYbaixo(this.carro, 50, 180);
						moverYbaixo(this.carro, 175, 180);
						Semaforo_Percursos_7_E_14[0].release();
						moverXtras(this.carro, 40, -90);
						Semaforo_Percursos_7_E_22[1].release();
						Semaforo_Percursos_2_E_7[0].release();
						moverXtras(this.carro, 15, -90);
					} catch (Exception e) {
						e.printStackTrace();
					}
					controle.posicaoOriginal(this.carro);
					break;
				case 12:
					try {
						Semaforo_Percursos_12_E_14[0].acquire();
						moverYcima(this.carro, 60, 0);
						Semaforo_Percursos_2_E_12[0].acquire();
						Semaforo_Percursos_7_E_12[0].acquire();
						Semaforo_Percursos_12_E_22[0].acquire();
						moverYcima(this.carro, 50, 0);
						moverXfrente(this.carro, 175, 90);
						moverXfrente(this.carro, 185, 90);
						moverYbaixo(this.carro, 50, 180);
						Semaforo_Percursos_2_E_12[0].release();
						Semaforo_Percursos_7_E_12[0].release();
						Semaforo_Percursos_12_E_22[0].release();
						moverYbaixo(this.carro, 125, 180);
						moverYbaixo(this.carro, 60, 180);
						moverYbaixo(this.carro, 65, 180);
						moverYbaixo(this.carro, 300, 180);
						Semaforo_Percursos_12_E_17[0].acquire();
						Semaforo_Percursos_12_E_22[1].acquire();
						moverYbaixo(this.carro, 200, 180);
						moverYbaixo(this.carro, 75, 180);
						moverXtras(this.carro, 30, -90);
						Semaforo_Percursos_12_E_14[0].release();
						Semaforo_Percursos_2_E_12[1].release();
						moverXtras(this.carro, 110, -90);
						Semaforo_Percursos_12_E_22[1].release();
						Semaforo_Percursos_2_E_12[2].acquire();
						moverXtras(this.carro, 220, -90);
						moverYcima(this.carro, 100, 0);
						Semaforo_Percursos_12_E_17[0].release();
						Semaforo_Percursos_2_E_12[2].release();
						moverYcima(this.carro, 250, 0);
						moverYcima(this.carro, 175, 0);
						moverYcima(this.carro, 175, 0);
						moverYcima(this.carro, 65, 0);

					} catch (Exception e) {
						e.printStackTrace();
					}
					controle.posicaoOriginal(this.carro);
					break;
				case 14:
					try {
						Semaforo_Percursos_14_E_22[0].acquire();
						Semaforo_Percursos_12_E_14[0].acquire();
						moverYcima(this.carro, 60, 0);
						Semaforo_Percursos_2_E_14[0].acquire();
						Semaforo_Percursos_7_E_14[0].acquire();
						Semaforo_Percursos_14_E_22[1].acquire();
						moverYcima(this.carro, 58, 0);
						moverXfrente(this.carro, 100, 90);
						Semaforo_Percursos_12_E_14[0].release();
						Semaforo_Percursos_14_E_22[0].release();
						moverXfrente(this.carro, 275, 90);
						moverYbaixo(this.carro, 125, 180);
						moverYbaixo(this.carro, 285, 180);
						Semaforo_Percursos_7_E_14[0].release();
						moverYbaixo(this.carro, 115, 180);
						moverYbaixo(this.carro, 175, 180);
						Semaforo_Percursos_14_E_22[1].release();
						moverYbaixo(this.carro, 175, 180);
						moverXtras(this.carro, 160, -90);
						moverXtras(this.carro, 110, -90);
						Semaforo_Percursos_14_E_17[0].acquire();
						moverXtras(this.carro, 50, -90);
						Semaforo_Percursos_12_E_14[0].acquire();
						Semaforo_Percursos_14_E_22[2].acquire();
						moverXtras(this.carro, 55, -90);
						moverYcima(this.carro, 223, 0);
						Semaforo_Percursos_14_E_22[2].release();
						moverYcima(this.carro, 338, 0);
						Semaforo_Percursos_2_E_14[0].release();
						moverYcima(this.carro, 53, 0);
						Semaforo_Percursos_14_E_17[0].release();
						Semaforo_Percursos_14_E_22[0].acquire();
						moverYcima(this.carro, 80, 0);
						moverYcima(this.carro, 62, 0);
						controle.posicaoOriginal(this.carro);
						Semaforo_Percursos_14_E_22[0].release();
						Semaforo_Percursos_12_E_14[0].release();

					} catch (Exception e) {
						e.printStackTrace();
					}
					controle.posicaoOriginal(this.carro);
					break;
				case 17:
					try {
						Semaforo_Percursos_12_E_17[0].acquire();
						moverXtras(this.carro, 60, -90);
						Semaforo_Percursos_2_E_17[0].acquire();
						moverXtras(this.carro, 40, -90);
						moverXtras(this.carro, 60, -90);
						moverXtras(this.carro, 160, -90);
						moverXtras(this.carro, 60, -90);
						Semaforo_Percursos_12_E_17[0].release();
						moverXtras(this.carro, 100, -90);
						moverYcima(this.carro, 175, 0);
						moverYcima(this.carro, 300, 0);
						Semaforo_Percursos_7_E_17[0].acquire();
						moverYcima(this.carro, 55, 0);
						moverXfrente(this.carro, 50, 90);
						Semaforo_Percursos_2_E_17[0].release();
						moverXfrente(this.carro, 130, 90);
						moverXfrente(this.carro, 140, 90);
						Semaforo_Percursos_2_E_17[1].acquire();
						moverXfrente(this.carro, 50, 90);
						moverXfrente(this.carro, 110, 90);
						Semaforo_Percursos_14_E_17[0].acquire();
						Semaforo_Percursos_12_E_17[1].acquire();
						moverXfrente(this.carro, 70, 90);
						moverYbaixo(this.carro, 55, 180);
						Semaforo_Percursos_7_E_17[0].release();
						moverYbaixo(this.carro, 300, 180);
						moverYbaixo(this.carro, 175, 180);
						Semaforo_Percursos_14_E_17[0].release();
						Semaforo_Percursos_2_E_17[1].release();
						controle.posicaoOriginal(this.carro);
						Semaforo_Percursos_12_E_17[1].release();
						moverXtras(this.carro, 70, -90);
					} catch (Exception e) {
						e.printStackTrace();
					}
					controle.posicaoOriginal(this.carro);
					break;
				case 22:
					try {
						moverXfrente(this.carro, 300, 90);
						moverYcima(this.carro, 110, 0);
						Semaforo_Percursos_7_E_22[0].acquire();
						Semaforo_Percursos_12_E_22[0].acquire();
						Semaforo_Percursos_14_E_22[0].acquire();
						Semaforo_Percursos_2_E_22[0].acquire();
						moverYcima(this.carro, 60, 0);
						moverXfrente(this.carro, 120, 90);
						moverXfrente(this.carro, 60, 90);
						moverYbaixo(this.carro, 60, 180);
						Semaforo_Percursos_2_E_22[0].release();
						Semaforo_Percursos_12_E_22[0].release();
						Semaforo_Percursos_7_E_22[0].release();
						moverYbaixo(this.carro, 110, 180);
						moverXfrente(this.carro, 60, 90);
						Semaforo_Percursos_14_E_22[0].release();
						moverXfrente(this.carro, 180, 90);
						Semaforo_Percursos_2_E_22[1].acquire();
						Semaforo_Percursos_7_E_22[1].acquire();
						Semaforo_Percursos_14_E_22[1].acquire();
						moverXfrente(this.carro, 60, 90);
						moverXfrente(this.carro, 60, 90);
						moverYbaixo(this.carro, 175, 180);
						moverYbaixo(this.carro, 50, 180);
						Semaforo_Percursos_7_E_22[1].release();
						moverYbaixo(this.carro, 125, 180);
						moverYbaixo(this.carro, 175, 180);
						moverXtras(this.carro, 60, -90);
						Semaforo_Percursos_2_E_22[1].release();
						Semaforo_Percursos_14_E_22[1].release();
						moverXtras(this.carro, 120, -90);
						moverXtras(this.carro, 120, -90);
						Semaforo_Percursos_2_E_22[2].acquire();
						Semaforo_Percursos_12_E_22[1].acquire();
						Semaforo_Percursos_14_E_22[2].acquire();
						moverXtras(this.carro, 60, -90);
						moverYbaixo(this.carro, 170, 180);
						moverXtras(this.carro, 60, -90);
						Semaforo_Percursos_14_E_22[2].release();
						Semaforo_Percursos_2_E_22[2].release();
						moverXtras(this.carro, 130, -90);
						Semaforo_Percursos_7_E_22[2].acquire();
						moverYcima(this.carro, 170, 0);
						Semaforo_Percursos_12_E_22[1].release();
						Semaforo_Percursos_2_E_22[3].acquire();
						moverXtras(this.carro, 300, -90);
						moverXtras(this.carro, 60, -90);
						moverYcima(this.carro, 175, 0);
						moverYcima(this.carro, 125, 0);
						moverYcima(this.carro, 75, 0);
						moverYcima(this.carro, 175, 0);
						moverXfrente(this.carro, 60, 90);
						Semaforo_Percursos_2_E_22[3].release();
						Semaforo_Percursos_7_E_22[2].release();
					} catch (Exception e) {
						e.printStackTrace();
					}
					controle.posicaoOriginal(this.carro);
					break;
				default:
					break;
			}
		}
	}

	/**
	 * Metodo: moverYbaixo
	 * Move o carro para baixo ao longo do eixo Y com animacao.
	 *
	 * Este metodo move o carro para baixo ao longo do eixo Y com uma animacao
	 * baseada
	 * na velocidade do carro. A posicao Y eh atualizada em incrementos ate atingir
	 * o valor desejado.
	 * O metodo usa a plataforma JavaFX para atualizar a interface grafica de
	 * usuario de forma segura.
	 *
	 * @param carro   Identificador do carro a ser movido.
	 * @param eixoy   Quantidade de unidades a serem movidas ao longo do eixo Y.
	 * @param rotacao Angulo de rotacao do carro durante o movimento.
	 * @throws InterruptedException Se a thread for interrompida enquanto estiver
	 *                              aguardando.
	 * @return void
	 */
	public void moverYbaixo(int carro, double eixoy, double rotacao) {

		controle.setRotacao(carro, rotacao);// chama o metodo para rotacionar o carro
		double y = controle.getPosicaoY(carro);

		for (int i = 0; i < eixoy; i++) {// incia o loop responsavel pela animacao
			// Pausa o carro se a velocidade do slider for igual a 10
			if (controle.getVelocidadeCarros(carro) == 10) {
				while (controle.getVelocidadeCarros(carro) == 10) {
					try {
						sleep(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			y += 1;
			double finalY = y;

			Platform.runLater(() -> {
				controle.moverY(carro, finalY); // chama o metodo responsavel por setar a nova posicao Y
			});
			try {
				Thread.sleep(controle.getVelocidadeCarros(carro));// transforma o a velocidade do carro em um sleep para a
				// thread, simulando assim uma animacao
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo: moverYcima
	 * Move o carro para cima ao longo do eixo Y com animacao.
	 *
	 * Este metodo move o carro para cima ao longo do eixo Y com uma animacao
	 * baseada
	 * na velocidade do carro. A posicao Y eh atualizada em decrementos ate atingir
	 * o valor desejado.
	 * O metodo usa a plataforma JavaFX para atualizar a interface grafica de
	 * usuario de forma segura.
	 *
	 * @param carro   Identificador do carro a ser movido.
	 * @param eixoy   Quantidade de unidades a serem movidas ao longo do eixo Y.
	 * @param rotacao Angulo de rotacao do carro durante o movimento.
	 * @throws InterruptedException Se a thread for interrompida enquanto estiver
	 *                              aguardando.
	 * @return void
	 */
	public void moverYcima(int carro, double eixoY, double rotacao) {

		controle.setRotacao(carro, rotacao);// chama o metodo para rotacionar o carro
		double y = controle.getPosicaoY(carro);

		for (int i = 0; i < eixoY; i++) {// incia o loop responsavel pela animacao
			// Pausa o carro se a velocidade do slider for igual a 10
			if (controle.getVelocidadeCarros(carro) == 10) {
				while (controle.getVelocidadeCarros(carro) == 10) {
					try {
						sleep(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			y -= 1;

			double finalY = y;
			Platform.runLater(() -> {
				controle.moverY(carro, finalY); // chama o metodo responsavel por setar a nova posicao Y
			});
			try {
				Thread.sleep(controle.getVelocidadeCarros(carro));// transforma o a velocidade do carro em um sleep para a
				// thread, simulando assim uma animacao
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Move o carro para tras ao longo do eixo X com animacao.
	 *
	 * Este metodo move o carro para tras ao longo do eixo X com uma animacao
	 * baseada
	 * na velocidade do carro. A posicao X eh atualizada em decrementos ate atingir
	 * o valor desejado.
	 * O metodo usa a plataforma JavaFX para atualizar a interface grafica de
	 * usuario de forma segura.
	 *
	 * @param carro   Identificador do carro a ser movido.
	 * @param eixox   Quantidade de unidades a serem movidas ao longo do eixo X.
	 * @param rotacao Angulo de rotacao do carro durante o movimento.
	 * @throws InterruptedException Se a thread for interrompida enquanto estiver
	 *                              aguardando.
	 * @return void
	 */
	public void moverXtras(int carro, double eixox, double rotacao) {
		controle.setRotacao(carro, rotacao);// chama o metodo para rotacionar carro
		double x = controle.getPosicaoX(carro);

		for (int i = 0; i < eixox; i++) {// inicia o loop responsavel pela animacao
			// Pausa o carro se o valor de seu slider for 10
			if (controle.getVelocidadeCarros(carro) == 10) {
				while (controle.getVelocidadeCarros(carro) == 10) {
					try {
						sleep(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			x -= 1;
			double finalX = x;
			Platform.runLater(() -> {
				controle.moverX(carro, finalX);// chama o metodo responsavel por setar a nova posicao X
			});
			try {
				Thread.sleep(controle.getVelocidadeCarros(carro));// transforma o a velocidade do carro em um sleep para a
				// thread, simulando assim uma animacao
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Move o carro para frente ao longo do eixo X com animacao.
	 *
	 * Este metodo move o carro para frente ao longo do eixo X com uma animacao
	 * baseada
	 * na velocidade do carro. A posicao X eh atualizada em incrementos ate atingir
	 * o valor desejado.
	 * O metodo usa a plataforma JavaFX para atualizar a interface grafica de
	 * usuario de forma segura.
	 *
	 * @param carro   Identificador do carro a ser movido.
	 * @param eixox   Quantidade de unidades a serem movidas ao longo do eixo X.
	 * @param rotacao Angulo de rotacao do carro durante o movimento.
	 * @throws InterruptedException Se a thread for interrompida enquanto estiver
	 *                              aguardando.
	 * @return void
	 */
	public void moverXfrente(int carro, double eixox, int rotacao) {
		controle.setRotacao(carro, rotacao);// chama o metodo para rotacionar carro
		double x = controle.getPosicaoX(carro);

		for (int i = 0; i < eixox; i++) {// inicia o loop responsavel pela animacao
			// Pausa o carro se o valor de seu slider for 10
			if (controle.getVelocidadeCarros(carro) == 10) {
				while (controle.getVelocidadeCarros(carro) == 10) {
					try {
						sleep(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			x += 1;
			double finalX = x;
			Platform.runLater(() -> {
				controle.moverX(carro, finalX);// chama o metodo responsavel por setar a nova posicao X
			});
			try {
				Thread.sleep(controle.getVelocidadeCarros(carro));// transforma o a velocidade do carro em um sleep para a
				// thread, simulando assim uma animacao
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Metodo: tempoDeReinicio
	 * 
	 * Metodo usado para dar um tempo para a aplicacao reiniciar sua execucao sem
	 * causar bugs
	 * 
	 * @return void
	 */
	public void tempoDeReinicio() {
		try {
			sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
