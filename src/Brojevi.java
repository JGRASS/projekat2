import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Brojevi extends JPanel {
	private Broj[] brojevi;
	private Random random = new Random();
	private int brojacKliknutih;
	private boolean istekloVreme;
	private boolean predjen;

	public boolean isPredjen() {
		return predjen;
	}

	public void setPredjen(boolean predjen) {
		this.predjen = predjen;
	}

	public Brojevi(int velicina) {
		brojevi = new Broj[velicina];
		brojacKliknutih=0;
		for (int i = 0; i < velicina; i++) {
			brojevi[i] = new Broj();
		}
		istekloVreme=false;
		podesiLokacije();
		podesiVrednosti();	
		sortiraj();
		paintComponents(getGraphics());
	}
	
	public Broj[] getBrojevi() {
		return brojevi;
	}

	public void setBrojevi(Broj[] brojevi) {
		this.brojevi = brojevi;
	}


	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int getBrojacKliknutih() {
		return brojacKliknutih;
	}

	public void setBrojacKliknutih(int brojacKliknutih) {
		this.brojacKliknutih = brojacKliknutih;
	}

	public boolean isIstekloVreme() {
		return istekloVreme;
	}

	public void setIstekloVreme(boolean istekloVreme) {
		this.istekloVreme = istekloVreme;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < brojevi.length; i++) {
			if(!istekloVreme)
				brojevi[i].crtaj(g);
			else brojevi[i].crtajPrazno(g);
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
				Broj a = brojevi[j];
				brojevi[j] = brojevi[iMin];
				brojevi[iMin] = a;
			}

		}
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
			brojevi[i].setLokacija(new Point(50 + random.nextInt(550),
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
	public void proveri(int x,int y,JPanel contentPane){
		for (int i = 0; i < brojevi.length; i++) {
			if(brojevi[i].proveri(x, y))
				if(brojevi[brojacKliknutih].getVrednost()==brojevi[i].getVrednost()) {
					brojevi[i].crtaj(getGraphics());
					brojacKliknutih++;
				}
				else{
					JOptionPane.showMessageDialog(contentPane,
							"GRESKA", "Brojevi",
							JOptionPane.ERROR_MESSAGE);
					setVisible(false);
				}
		}
		if(brojacKliknutih==brojevi.length){
			predjen=true;
			JOptionPane.showMessageDialog(contentPane,
				"SVAKA CAST", "Brojevi",
				JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
