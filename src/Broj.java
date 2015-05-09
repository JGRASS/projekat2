import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;


public class Broj {
	public static final int POLUPRECNIK=20;
	private int vrednost;
	private Point lokacija;
	
	
	
	public int getVrednost() {
		return vrednost;
	}
	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	public Point getLokacija() {
		return lokacija;
	}
	public void setLokacija(Point lokacija) {
		this.lokacija = lokacija;
	}
	
	public void crtaj(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(lokacija.x-POLUPRECNIK, lokacija.y-POLUPRECNIK, 2*POLUPRECNIK, 2*POLUPRECNIK);
		Font f=g.getFont();
		f=f.deriveFont((float) (35 / 2));
		f=f.deriveFont(Font.BOLD);
		g.setFont(f);
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(vrednost), lokacija.x-5, lokacija.y+3);
	}
	public boolean proveri(int x,int y){
		if(lokacija.x-Broj.POLUPRECNIK<=x && lokacija.x+Broj.POLUPRECNIK>=x &&
				lokacija.y-Broj.POLUPRECNIK<=y && lokacija.y+Broj.POLUPRECNIK>=y) return true;
		return false;
	}
	
}
