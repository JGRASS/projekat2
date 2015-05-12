package brojevi;
import gui.GUIKontoler;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;


public class BrojeviGUI extends JFrame {
	/**
	 * panel koji sadrzi ceo izgled igrice
	 */
	private JPanel contentPane;
	/**
	 * panel koji sadrzi dugmice i informacije o rezultatu
	 */
	private JPanel panel;
	/**
	 * labela HighScore
	 */
	private JLabel lblHighScore;
	/**
	 * polje gde pise najbolji rezultat
	 */
	private JTextField txtHighScore;
	/**
	 * labela Trenutni nivo
	 */
	private JLabel lblTrenutniNivo;
	/**
	 * polje gde pise trenutni rezultat
	 */
	private JTextField txtTrenutniNivo;
	/**
	 * dugme koje resetuje igru
	 */
	private JButton btnIgraj;
	/**
	 * dugme koje izlazi iz igrice
	 */
	private JButton btnIzadji;
	/**
	 * Brojevi koji se postavljaju i pogadjaju
	 */
	private  Brojevi brojevi;
	/**
	 * tajmer
	 */
	private Timer timer;
	/**
	 * broj sekundi koliko se gleda u brojeve
	 */
	private int vreme;
	/**
	 * trenutni nivo
	 */
	private int nivo;
	/**
	 * najbolji ostvaren nivo
	 */
	private int highScore;

	/**
	 * Create the frame.
	 */
	public BrojeviGUI() {
		setBackground(new Color(255, 255, 102));
		addWindowListener(new WindowAdapter() {		
			@Override
			public void windowClosing(WindowEvent arg0) {
					izadji();
			}
		
		});
		setResizable(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		contentPane.add(getPanel(), BorderLayout.EAST);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BrojeviGUI.class.getResource("/brojevi/kuglica.png")));
		getTxtHighScore();
		getTxtTrenutniNivo();
		timer=new Timer();
		highScore=GUIKontoler.ucitajRez("highScoreBrojevi.out");
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				vreme--;
				if(vreme==0) {
					brojevi.setIstekloVreme(true);	
					brojevi.repaint();
					brojevi.setEnabled(true);
				}				
			}
		};
		timer.schedule(task, 0,1000);
		
		
		
	}
	/**
	 * metoda koja postavlja nove brojeve na ekran
	 */
	private void postavi(){
		if(brojevi!=null) brojevi.setVisible(false);
		brojevi=new Brojevi(5+nivo);
		brojevi.setVisible(true);
		if(nivo>highScore) highScore=nivo;
		txtTrenutniNivo.setText(Integer.toString(nivo));
		txtHighScore.setText(Integer.toString(highScore));		
		nivo++;		
		brojevi.setEnabled(false);
		brojevi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(brojevi.isEnabled())
				{
				brojevi.proveri(e.getX(), e.getY(), brojevi);		
				if (brojevi.isPredjen()){
					postavi();
				}
				}
			}
		});
		brojevi.setPreferredSize(new Dimension(700, 400));
		brojevi.setLayout(null);
		brojevi.paintComponents(getGraphics());
		if(nivo>=10) vreme=15;
		if(nivo<10)
			vreme=8;
		if(nivo<7)
			vreme=6;
		if(nivo<4)
			vreme=4;
		contentPane.add(brojevi, BorderLayout.CENTER);
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(150, 10));
			panel.setLayout(null);
			panel.add(getLblHighScore());
			panel.add(getTxtHighScore());
			panel.add(getLblTrenutniNivo());
			panel.add(getTxtTrenutniNivo());
			panel.add(getBtnIgraj());
			panel.add(getBtnIzadji());
		}
		return panel;
	}
	private JLabel getLblHighScore() {
		if (lblHighScore == null) {
			lblHighScore = new JLabel("HighScore");
			lblHighScore.setBounds(21, 5, 105, 14);
		}
		return lblHighScore;
	}
	private JTextField getTxtHighScore() {
		if (txtHighScore == null) {
			txtHighScore = new JTextField();
			txtHighScore.setEnabled(false);
			txtHighScore.setBounds(21, 24, 105, 20);
			txtHighScore.setColumns(10);
		}
		return txtHighScore;
	}
	private JLabel getLblTrenutniNivo() {
		if (lblTrenutniNivo == null) {
			lblTrenutniNivo = new JLabel("Trenutni nivo");
			lblTrenutniNivo.setBounds(18, 49, 96, 14);
		}
		return lblTrenutniNivo;
	}
	private JTextField getTxtTrenutniNivo() {
		if (txtTrenutniNivo == null) {
			txtTrenutniNivo = new JTextField();
			txtTrenutniNivo.setEnabled(false);
			txtTrenutniNivo.setBounds(21, 68, 105, 20);
			txtTrenutniNivo.setColumns(10);
		}
		return txtTrenutniNivo;
	}
	private JButton getBtnIgraj() {
		if (btnIgraj == null) {
			btnIgraj = new JButton("Igraj");
			btnIgraj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					nivo=0;
					postavi();
				}
			});
			btnIgraj.setBounds(22, 93, 104, 23);
		}
		return btnIgraj;
	}
	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
			btnIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					izadji();
				}
			});
			btnIzadji.setBounds(21, 121, 105, 23);
		}
		return btnIzadji;
	}
	
	/**
	 * metoda koja izlazi iz igrice
	 */
	 private void izadji(){
		GUIKontoler.sacuvajRez("highscoreBrojevi.out",highScore);
		dispose();		
	}
}
