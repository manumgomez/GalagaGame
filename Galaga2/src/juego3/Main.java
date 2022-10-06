package juego3;

import edu.uc3m.game.GameBoardGUI;

public class Main {

	public static void main(String[] args) throws InterruptedException, ArrayIndexOutOfBoundsException {

		// CREACION DE LA INTERFAZ

		GameBoardGUI gui = new GameBoardGUI(17, 22);
		gui.setVisible(true);

		// CONFIGURACION DE LA INTERFAZ

		Configuration configurate = new Configuration(gui, 0, 0, 0, "galagaLogo.jpg");

		configurate.createInterface();

		gui.setSize(510, 710);
		// CONTADORES

		int q = 0;// para que se produzca el movimiento de los sprites(disparos) cada vez que se
					// ejecute el bucle

		int rightBorder = 165;

		int leftBorder = 5;

		int topBorder = 0;

		int bottomBorder = 220;

		int numZakosFila1 = 10;

		int numZakosFila2 = 10;

		int numGoeisFila1 = 14;

		int numCommandersFila1 = 6;

		boolean boolRightBorder = false;

		int cambiarSprite = 0;
		

		// NIVELES

		Level nivel1 = new Level(gui, 1);

		// CREACION DE OBJETOS

		Player player = new Player(gui, 1, 1, "player.png", 85, 200);

		Zako[] zakoFila1 = new Zako[numZakosFila1];

		Zako[] zakoFila2 = new Zako[numZakosFila2];

		Goei[] goeiFila1 = new Goei[numGoeisFila1];

		// RELLENO DE ARRAYS DE OBJETOS

		// creo array de id's
		int[] id = new int[100];

		for (int i = 0; i < id.length; i++) {
			id[i] = i;
		}
		// crear zako's
		for (int i = 0; i < zakoFila1.length; i++) {
			System.out.println(i);
			zakoFila1[i] = new Zako(nivel1.nivel * 100 + id[i], 40, 40 + (10 * i)); // Asigno a cada zako una id a
																					// partir de
			// las creadas en el array anterior
		}
		for (int i = 0; i < zakoFila1.length; i++) {
			gui.gb_println("" + i + "..." + zakoFila1[i].getId());
			gui.gb_addSprite(zakoFila1[i].getId(), zakoFila1[i].getImg(), true);
			gui.gb_setSpriteVisible(zakoFila1[i].getId(), true);
			zakoFila1[i].setVis(true);
			gui.gb_moveSpriteCoord(zakoFila1[i].getId(), zakoFila1[i].getX(), zakoFila1[i].getY());
		}

		// creo zako's
		for (int i = 0; i < zakoFila2.length; i++) {
			System.out.println(i);
			zakoFila2[i] = new Zako(nivel1.nivel * 100 + id[numZakosFila1 + i], 30, 40 + (10 * i));
		}

		for (int i = 0; i < zakoFila2.length; i++) {
			gui.gb_println("" + i + "..." + zakoFila2[i].getId());
			gui.gb_addSprite(zakoFila2[i].getId(), zakoFila2[i].getImg(), true);
			zakoFila2[i].setVis(true);

			if (zakoFila2[i].getX() < 70 || zakoFila2[i].getX() > 100) {
				gui.gb_setSpriteVisible(zakoFila2[i].getId(), true);
				gui.gb_moveSpriteCoord(zakoFila2[i].getId(), zakoFila2[i].getX(), zakoFila2[i].getY());
			}
		}

		// creo goei's
		for (int i = 0; i < goeiFila1.length; i++) {
			System.out.println(i);
			goeiFila1[i] = new Goei(nivel1.nivel * 100 + id[numZakosFila2 + numZakosFila1 + i], 30, 20 + (10 * i));
		}
		for (int i = 0; i < goeiFila1.length; i++) {
			gui.gb_println("" + i + "..." + goeiFila1[i].getId());
			gui.gb_addSprite(goeiFila1[i].getId(), goeiFila1[i].getImg(), true);
			if (goeiFila1[i].getX() > 10 && goeiFila1[i].getX() < 40) {
				gui.gb_setSpriteVisible(goeiFila1[i].getId(), true);
				gui.gb_moveSpriteCoord(goeiFila1[i].getId(), goeiFila1[i].getX(), goeiFila1[i].getY());
			}
			if (goeiFila1[i].getX() > 130 && goeiFila1[i].getX() < 160) {
				gui.gb_setSpriteVisible(goeiFila1[i].getId(), true);
				gui.gb_moveSpriteCoord(goeiFila1[i].getId(), goeiFila1[i].getX(), goeiFila1[i].getY());
			}
			if (goeiFila1[i].getX() > 60 && goeiFila1[i].getX() < 110) {
				gui.gb_setSpriteVisible(goeiFila1[i].getId(), true);
				gui.gb_moveSpriteCoord(goeiFila1[i].getId(), goeiFila1[i].getX(), goeiFila1[i].getY());
			}
			goeiFila1[i].setVis(true);
		}

		while (true) {

			switch (gui.gb_getLastAction()) {
			case "left":
				player.setX(player.getX() - 3);
				break;
			case "right":
				player.setX(player.getX() + 3);
				break;
			case "up":
			case "space":
				if (player.getCadenciaDispPlayer()) {
					q = 0;
					player.disparoPlayer();
				}
				break;

			}

			// MOVIMIENTO DE ENEMIGOS

			if (goeiFila1[goeiFila1.length - 1].getX() < rightBorder && !boolRightBorder) {

				for (int i = 0; i < goeiFila1.length; i++) {
					goeiFila1[i].setX(goeiFila1[i].getX() + 1);
					gui.gb_moveSpriteCoord(goeiFila1[i].getId(), goeiFila1[i].getX(), goeiFila1[i].getY());
				}
				for (int i = 0; i < zakoFila1.length; i++) {
					zakoFila1[i].setX(zakoFila1[i].getX() + 1);
					gui.gb_moveSpriteCoord(zakoFila1[i].getId(), zakoFila1[i].getX(), zakoFila1[i].getY());
				}
				for (int i = 0; i < zakoFila2.length; i++) {
					zakoFila2[i].setX(zakoFila2[i].getX() + 1);
					gui.gb_moveSpriteCoord(zakoFila2[i].getId(), zakoFila2[i].getX(), zakoFila2[i].getY());
				}

			}

			else {
				boolRightBorder = true;

				if (goeiFila1[0].getX() > leftBorder) {

					for (int i = 0; i < goeiFila1.length; i++) {
						goeiFila1[i].setX(goeiFila1[i].getX() - 1);
						gui.gb_moveSpriteCoord(goeiFila1[i].getId(), goeiFila1[i].getX(), goeiFila1[i].getY());
					}
					for (int i = 0; i < zakoFila1.length; i++) {
						zakoFila1[i].setX(zakoFila1[i].getX() - 1);
						gui.gb_moveSpriteCoord(zakoFila1[i].getId(), zakoFila1[i].getX(), zakoFila1[i].getY());
					}
					for (int i = 0; i < zakoFila2.length; i++) {
						zakoFila2[i].setX(zakoFila2[i].getX() - 1);
						gui.gb_moveSpriteCoord(zakoFila2[i].getId(), zakoFila2[i].getX(), zakoFila2[i].getY());
					}

				}

				else {
					boolRightBorder = false;
				}

			}

			// LIMITES LATERALES DE LA PANTALLA
			if (goeiFila1[goeiFila1.length - 1].getX() == rightBorder || goeiFila1[0].getX() == leftBorder) {

				for (int i = 0; i < goeiFila1.length; i++) {
					goeiFila1[i].setY(goeiFila1[i].getY() + 1);
					gui.gb_moveSpriteCoord(goeiFila1[i].getId(), goeiFila1[i].getX(), goeiFila1[i].getY());
				}
				for (int i = 0; i < zakoFila1.length; i++) {
					zakoFila1[i].setY(zakoFila1[i].getY() + 1);
					gui.gb_moveSpriteCoord(zakoFila1[i].getId(), zakoFila1[i].getX(), zakoFila1[i].getY());
				}
				for (int i = 0; i < zakoFila2.length; i++) {
					zakoFila2[i].setY(zakoFila2[i].getY() + 1);
					gui.gb_moveSpriteCoord(zakoFila2[i].getId(), zakoFila2[i].getX(), zakoFila2[i].getY());
				}
			}

			// LIMITE INFERIOR DE LA PANTALLA
			if (zakoFila1[0].getY() > bottomBorder) {
				for (int i = 0; i < zakoFila1.length; i++) {
					zakoFila1[i].setY(topBorder + 1);
					gui.gb_moveSpriteCoord(zakoFila1[i].getId(), zakoFila1[i].getX(), zakoFila1[i].getY());
				}
			}
			if (goeiFila1[0].getY() > bottomBorder) {
				for (int i = 0; i < goeiFila1.length; i++) {
					goeiFila1[i].setY(topBorder + 1);
					gui.gb_moveSpriteCoord(goeiFila1[i].getId(), goeiFila1[i].getX(), goeiFila1[i].getY());
				}
				for (int i = 0; i < zakoFila2.length; i++) {
					zakoFila2[i].setY(topBorder + 1);
					gui.gb_moveSpriteCoord(zakoFila2[i].getId(), zakoFila2[i].getX(), zakoFila2[i].getY());
				}

			}

			

			// IMPRESION DE DISPAROS
			player.movimDisparoPlayer();

			// ELIMINACION DE ENEMIGOS
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < zakoFila1.length; j++) {
					if(zakoFila1[j].visible && (zakoFila1[j].getImg().equals("enemy3G0.png") || zakoFila1[j].getImg().equals("enemy300.png"))) {
					if (player.isDispVisible(i) && zakoFila1[j].getVis()
							&& ((zakoFila1[j].getX() + 5 >= player.getXDisp(i))
									&& player.getXDisp(i) >= zakoFila1[j].getX() -5)
							&& (zakoFila1[j].getY() + 7 >= player.getYDisp(i))
							&& player.getYDisp(i) >= zakoFila1[j].getY() - 7) {
						zakoFila1[j].hitEnem();
						gui.gb_setSpriteVisible(player.getDispId(i), false);
						player.setDispVis(i, false);
						zakoFila1[j].setVis(false);
						
					}
					}
				}
				for (int j = 0; j < zakoFila2.length; j++) {
					if(zakoFila2[j].visible && (zakoFila2[j].getImg().equals("enemy3G0.png") || zakoFila2[j].getImg().equals("enemy300.png"))) {
					if (player.isDispVisible(i) && (zakoFila2[j].getX() + 5) >= player.getXDisp(i)
							&& player.getXDisp(i) >= (zakoFila2[j].getX() - 5)
							&& (zakoFila2[j].getY() + 5 >= player.getYDisp(i))
							&& player.getYDisp(i) >= zakoFila2[j].getY() - 5 ) {
						zakoFila2[j].hitEnem();
						gui.gb_setSpriteVisible(player.getDispId(i), false);
						player.setDispVis(i, false);
						zakoFila2[j].setVis(false);
					}
					}
				}
				for (int j = 0; j < goeiFila1.length; j++) {
					if(goeiFila1[j].visible && (goeiFila1[j].getImg().equals("enemy2G0.png") || goeiFila1[j].getImg().equals("enemy200.png"))) {
					if (player.isDispVisible(i) && goeiFila1[j].getVis()
							&& (goeiFila1[j].getX() + 5) >= player.getXDisp(i)
							&& player.getXDisp(i) >= (goeiFila1[j].getX() - 5)
							&& (goeiFila1[j].getY() + 5 >= player.getYDisp(i))
							&& player.getYDisp(i) >= goeiFila1[j].getY() - 5) {
						goeiFila1[j].hitEnem();
						gui.gb_setSpriteVisible(player.getDispId(i), false);
						player.setDispVis(i, false);
						goeiFila1[j].setVis(false);
					}
					}
				}
			}

			// ANIMACION DE MUERTE ENEM
			for (int i = 0; i < 10; i++) {
				if (zakoFila1[i].getHealth() <= 0)
					zakoFila1[i].enemMuerto();
			}
			for (int i = 0; i < 10; i++) {
				if (zakoFila2[i].getHealth() == 0)
					zakoFila2[i].enemMuerto();
			}
			for (int i = 0; i < 14; i++) {
				if (goeiFila1[i].getHealth() == 0)
					goeiFila1[i].enemMuerto();
			}

			// ACTUALIZA LAS IMAGENES
			for (int i = 0; i < zakoFila1.length; i++) {
				gui.gb_setSpriteImage(zakoFila1[i].getId(), zakoFila1[i].getImg());
			}
			for (int i = 0; i < zakoFila2.length; i++) {
				gui.gb_setSpriteImage(zakoFila2[i].getId(), zakoFila2[i].getImg());
			}
			for (int i = 0; i < goeiFila1.length; i++) {
				gui.gb_setSpriteImage(goeiFila1[i].getId(), goeiFila1[i].getImg());
			}

			// CAMBIO DE SPRITES
						if (cambiarSprite > 5) {
							for (int i = 0; i < zakoFila1.length; i++) {
								if (zakoFila1[i].getHealth() > 0)
									gui.gb_setSpriteImage(zakoFila1[i].getId(), zakoFila1[i].getImg2());
							}
							for (int i = 0; i < zakoFila2.length; i++) {
								if (zakoFila2[i].getHealth() > 0)
									gui.gb_setSpriteImage(zakoFila2[i].getId(), zakoFila2[i].getImg2());
							}
							for(int i = 0; i < goeiFila1.length ;i++) {
								if (goeiFila1[i].getHealth() > 0)
									gui.gb_setSpriteImage(goeiFila1[i].getId(), goeiFila1[i].getImg2());
							}
						}

						// REINICIO CONTADOR PARA QUE SE REPITA EL CAMBIO DE SPRITES
						else {
							for (int i = 0; i < zakoFila1.length; i++) {
								gui.gb_setSpriteImage(zakoFila1[i].getId(), zakoFila1[i].getImg());
							}
							for (int i = 0; i < zakoFila2.length; i++) {
								gui.gb_setSpriteImage(zakoFila2[i].getId(), zakoFila2[i].getImg());
							}
							for(int i = 0; i < goeiFila1.length ;i++) {
								if (goeiFila1[i].getHealth() > 0)
									gui.gb_setSpriteImage(goeiFila1[i].getId(), goeiFila1[i].getImg());
							}
						}
						if (cambiarSprite >= 10) {
							cambiarSprite = 0;
						}
			
			// INCREMENTO DE CONTADORES

			q++;
			cambiarSprite++;

			// MOVIMIENTO DEL JUGADOR
			gui.gb_moveSpriteCoord(player.getId(), player.getX(), player.getY());
			Thread.sleep(1000 / 30);
		}

	}

}
