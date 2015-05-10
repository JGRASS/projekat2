package gui;

import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUIKontoler {
	private static IgriceGUI igrice;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					igrice = new IgriceGUI();
					igrice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void prikaziBrojeviGUI() {
		BrojeviGUI prozor = new BrojeviGUI();
		prozor.setLocationRelativeTo(null);
		prozor.setVisible(true);
	}
	/**
	 * metoda koja cuva najbolji rezultat
	 * @param putanja adresa fajla koji se ucitava
	 * @param skor skor koji se upisuje
	 */
	public static void sacuvajRez(String putanja,int skor){
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(putanja)));
			
			out.writeInt(skor);
			
			out.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * metoda koja ucitava najbolji rezultat
	 * @param putanja adresa fajla koji se ucitava
	 * @return vrednost HighScore-a kao int
	 */
	public static int ucitajRez(String putanja){
		try{
			
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(putanja)));
			int highScore;
			if(in.available()!=0)
				highScore=in.readInt();
			else highScore=0;
			
			in.close();
			return highScore;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * metoda koja izlazi iz igrice
	 */
	public static void izadji(String putanja,JFrame frame,int skor){
		GUIKontoler.sacuvajRez(putanja,skor);
		frame.dispose();
	}
	public static void prikaziAutore(JPanel contentPane){
		JOptionPane.showMessageDialog(contentPane,
				"Dusan Radovanovic 123/13\nAleksandar Randjelovic 121/13\n Filip Nedovic Bijelo Polje Drevni grad Samograd", "Brojevi",
				JOptionPane.INFORMATION_MESSAGE);
	}
}
