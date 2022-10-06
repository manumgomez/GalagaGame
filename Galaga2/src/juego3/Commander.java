package juego3;

public class Commander extends Enemies {

	public Commander(int id, int y, int x) {
		super();
		health = 1;
		img = "enemy1G0.png";
		img2 = "enemy100.png";
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
