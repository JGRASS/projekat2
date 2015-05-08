import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;

public class Brojevi extends JPanel {
	private Broj[] brojevi;
	private Random random = new Random();

	public Brojevi(int velicina) {
		brojevi = new Broj[velicina];
		for (int i = 0; i < velicina; i++) {
			brojevi[i] = new Broj();
			// brojevi[i].setVrednost(random.nextInt(20));
			// brojevi[i].setLokacija(new
			// Point(50+random.nextInt(750),50+random.nextInt(450)));
		}
		podesiVrednosti();
		podesiLokacije();
		sortiraj();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < brojevi.length; i++) {

			brojevi[i].crtaj(g);
		}
	}

	private void sortiraj() {
		int iMin;
		for (int j = 0; j < brojevi.length; j++) {
			iMin = j;
			for (int i = j + 1; i < brojevi.length; i++) {
				if (brojevi[i].getVrednost() < brojevi[iMin].getVrednost()) {
					iMin = i;
				}
			}

			if (iMin != j) {
				zameni(brojevi[j].getVrednost(), brojevi[iMin].getVrednost());
			}

		}
	}

	private void zameni(int x, int y) {
		int a = y;
		y = x;
		x = a;
	}

	private void podesiVrednosti() {
		for (int i = 0; i < brojevi.length; i++) {
			brojevi[i].setVrednost(random.nextInt(30));
			if (postoji(brojevi[i].getVrednost(), i-1)) {
				i--;
			}
		}
	}

	private boolean postoji(int x, int j) {
		if (x == 0)
			return true;
		for (int i = j; i >=0; i--) {
			if (brojevi[i].getVrednost() == x)
				return true;
		}
		return false;
	}

	private void podesiLokacije() {
		for (int i = 0; i < brojevi.length; i++) {
			brojevi[i].setLokacija(new Point(50 + random.nextInt(600),
					50 + random.nextInt(300)));
			if (postoji(brojevi[i].getLokacija(), i-1)) {
				i--;
			}
		}
	}

	private boolean postoji(Point lokacija, int j) {
		int x = lokacija.x;
		int y = lokacija.y;
		for (int i = j; i >= 0; i--) {
			int bX = brojevi[i].getLokacija().x;
			int bY = brojevi[i].getLokacija().y;
			if  ((x > bX - Broj.POLUPRECNIK && x < bX + Broj.POLUPRECNIK) || (y > bY
							- Broj.POLUPRECNIK && y < bY + Broj.POLUPRECNIK))
				return true;
		}
		return false;
	}
}
