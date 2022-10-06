package juego3;

import edu.uc3m.game.GameBoardGUI;

public class Level {

	protected int nivel;
	protected GameBoardGUI gui;
	
	public Level(GameBoardGUI gui, int nivel) {
		this.gui = gui;
		this.nivel = nivel;
	}
	//HACER LOS SPRITE ENEM INVISIBLES (SALE MAL)
	public void desaparecerEnem(int i) {
		gui.gb_setSpriteVisible(i, false);
	}
	
	public Level() {

	}


	

}
