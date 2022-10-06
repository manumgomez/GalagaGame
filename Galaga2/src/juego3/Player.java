package juego3;

import edu.uc3m.game.GameBoardGUI;

public class Player {

	protected int health;
	protected int id;
	protected String img;
	protected int x;
	protected int y;
	protected GameBoardGUI gui;
	protected int[] disparoId = new int[11]; // Numero de proyectiles que puede haber en la pantalla

	{// rellena las Id de los disparos del 2 al 12
		for (int k = 0; k < disparoId.length; k++)
			disparoId[k] = (k + 2);
	}

	// CONSTRUCTOR
	public Player(GameBoardGUI gui, int id, int health, String img, int x, int y) {

		// Establezco datos por defecto al jugador
		this.gui = gui;
		this.health = health;
		this.id = id;
		this.x = x;
		this.y = y;
		this.img = img;

		// Establezco la imagen del jugador
		gui.gb_addSprite(this.id, this.img, true);
		gui.gb_setSpriteVisible(this.id, true);
		gui.gb_moveSpriteCoord(this.id, this.x, this.y);

	}

	// GETTERS & SETTERS

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		if (x <= 5)
			this.x = 5;

		if (x >= 165)
			this.x = 165;
	}

	public int getY() {
		return y;
	}

	public int getId() {
		return id;
	}
	

	// METODOS

	// declaro variables para el disparo
	protected int PosXDisp[] = new int[disparoId.length];
	protected int PosYDisp[] = new int[disparoId.length];
	protected boolean dispVisib[] = new boolean[disparoId.length];
	protected int j = 0;
	protected int[] PosInicioDisparo = new int[disparoId.length];
	 
	public void setDispVis(int i, boolean visible) {
		dispVisib[i] = visible;
	}
	
	public boolean isDispVisible(int i) {
		return dispVisib[i];
	}
	public int getXDisp(int i) {
		return PosXDisp[i];
	}
	public int getYDisp(int i) {
		return PosYDisp[i]-PosInicioDisparo[i];
	}
	public int getDispId(int i) {
		return disparoId[i];
	}
	// dispara el jugador
	public void disparoPlayer() {
		gui.gb_addSprite(disparoId[j], "torpedo100.png", true);
		gui.gb_setSpriteVisible(disparoId[j], true);
		dispVisib[j] = true;
		PosXDisp[j] = x;
		PosYDisp[j] = y;
		PosInicioDisparo[j] = 0;
		gui.gb_moveSpriteCoord(disparoId[j], PosXDisp[j], PosYDisp[j]);
		j++;
		if (j >= disparoId.length)
			j = 0;
	}
	// mueve el proyectil

	public void movimDisparoPlayer() {
		for (int jj = 0; jj < disparoId.length; jj++) {
			gui.gb_moveSpriteCoord(disparoId[jj], PosXDisp[jj], (PosYDisp[jj] - PosInicioDisparo[jj]));
			PosInicioDisparo[jj]+=6;
			if (PosYDisp[jj] > 220) {
				gui.gb_setSpriteVisible(disparoId[jj], false);
				dispVisib[jj] = false;
				gui.gb_moveSprite(disparoId[jj], 0, 0);
			}
		}
	}

	protected double cadDisparoPlayer = 0;

	public boolean getCadenciaDispPlayer() {// evita que dispare seguido
		if ((System.currentTimeMillis() - cadDisparoPlayer) > 200/* tiempo entre disparo y disparo milisegundos */) {
			cadDisparoPlayer = System.currentTimeMillis();
			return true;
		} else
			return false;
	}

}
