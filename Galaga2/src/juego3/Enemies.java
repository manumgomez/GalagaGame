package juego3;

import edu.uc3m.game.GameBoardGUI;

public class Enemies extends Level {

	protected int health;
	protected int id;
	protected int contadorParaId = 0;
	protected String img;
	protected String img2;
	protected int reward;
	protected int rotation;
	protected int x;
	protected int y;
	protected boolean visible = true;

	public Enemies() {

	}

	public Enemies(GameBoardGUI gui, int id, int health, String img) {

		this.id = id;
		this.gui = gui;
		this.health = health;

	}

	// protected por motivos de herencia
	public void setVis(boolean visible) {
		this.visible = visible;
	}

	public boolean getVis() {
		return visible;
	}

	public int getHealth() {
		return health;
	}

	public String getImg() {
		return img;
	}

	public int getReward() {
		return reward;
	}

	public int getRotation() {
		return rotation;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void enemMuerto() {
		if (img != "explosion20.png" && img != "explosion21.png" && img != "explosion22.png" && img != "explosion23.png"
				&& img != "explosion24.png" && img != "empty.png")
			setImg("explosion20.png");
		if (img == "explosion20.png") {
			setImg("explosion21.png");

		} else if (img == "explosion21.png")

			setImg("explosion22.png");

		else if (img == "explosion22.png")
			setImg("explosion23.png");

		else if (img == "explosion23.png")
			setImg("explosion24.png");

		else if (img == "explosion24.png") {
			setImg("empty.png");
			visible = false;
		}

	}

	public void hitEnem() {
		health--;
	}

}
