package juego3;

public class Goei extends Enemies {

	public Goei(int id, int y, int x) {
		super();
		health = 1;
		img = "enemy2G0.png";
		img2 = "enemy200.png";
		reward = 100;
		this.id = id;
		this.y = y;
		this.x = x;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
