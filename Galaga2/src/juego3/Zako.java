package juego3;

public class Zako extends Enemies {

	public Zako(int id, int y, int x) {

		health = 1;
		img = "enemy3G0.png";
		img2 = "enemy300.png";
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
