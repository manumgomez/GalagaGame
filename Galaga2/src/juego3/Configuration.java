package juego3;

import edu.uc3m.game.GameBoardGUI;

public class Configuration {

	private int colorFondoRed;
	private int colorFondoGreen;
	private int colorFondoBlue;
	private int colorRejilla;
	private String idioma;
	private String fotoJuego;
	private GameBoardGUI gui;
	
	public Configuration(GameBoardGUI gui, int colorFondoRed, int colorFondoBlue, int colorFondoGreen, String fotoJuego) {
		this.colorFondoRed = colorFondoRed;
		this.colorFondoGreen = colorFondoGreen;
		this.colorFondoBlue = colorFondoBlue;
		this.gui = gui;
		this.fotoJuego = fotoJuego;
		gui.gb_setPortraitPlayer(this.fotoJuego);
	}

	//CREAR LA INTERFAZ (FONDO NEGRO, COLOR DE REJILLAS, CAMBIO DE FRASES DEL TABLERO)
	
	public void createInterface() {
		for(int i = 0 ; i < 17 ; i++) {
			for(int j = 0 ; j < 22 ; j++) {
				gui.gb_setSquareColor(i, j, this.colorFondoRed, this.colorFondoGreen, this.colorFondoBlue);
			}
		}
		
		gui.setTitle("Ivan Martín Prieto & Manuel Muñoz Gomez - Universidad Carlos III de Madrid");
		gui.gb_setValueHealthMax(3);
		gui.gb_setValueHealthCurrent(3);
		gui.gb_setTextPlayerName("GALAGA");
		gui.gb_setTextAbility1("Disparos: ");
		gui.gb_setTextAbility2("Disparos acertados: ");
		//gui.gb_setTextLevel();
		gui.gb_setTextPointsDown("Velocidad: ");
		gui.gb_setTextPointsUp("Puntos: ");
	}
}
