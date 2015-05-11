package memorygame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;

public class MemoryGame extends javax.swing.JFrame {
	/**
	 * Slika koja ce se koristiti za pozadinu
	 */
	private ImageIcon bkgndIcon;
	/**
	 * Memory
	 */
	private JLabel jLabel1;
	/**
	 * Game
	 */
	private JLabel jLabel2;
	/**
	 * Panel na kom se nalaze kartice  i metode za
	 * nasumicno generisanje kartica i njihovo poredjenje.
	 */
	private memorygame.MemoryPanel mp;
	/**
	 * Dugme za novu igru.
	 */
	private JButton btnNewGame;
	private JLabel lblHits;
	private JLabel lblMisses;
	/**
	 * Prikazuje broj pogodaka
	 */
	private static JLabel lblHitsVal;
	/**
	 * Prikazuje broj promasaja
	 */
	private static JLabel lblMissesVal;
	/**
	 * Prikazuje dialog sa informacijom o rekordu u najmanjem broju promsaja
	 */
	private JButton btnRecord;

	/** Konstruktor za kreiranje prozora sa igricom */
	public MemoryGame() {
		getContentPane().setBackground(new Color(255, 255, 102));
		setResizable(false);
		initComponents();

		bkgndIcon = new ImageIcon("resources/bojan.jpg");
		mp.displayImage(bkgndIcon);
	}
	/**
	 * Metoda koja inicijalizuje i postavlja elemente prozora i panela mp.
	 */
	private void initComponents() {
		mp = new MemoryPanel();
		mp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		getContentPane().setLayout(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Memory Game");
		mp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0,
				0), 4));
		getContentPane().add(mp);
		mp.setBounds(10, 10, 230, 230);
		jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Memory");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(250, 10, 210, 50);
		jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Game");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(250, 60, 210, 50);
		getContentPane().add(getBtnNewGame());
		
		lblHits = new JLabel("Hits:");
		lblHits.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHits.setBounds(250, 132, 46, 14);
		getContentPane().add(lblHits);
		
		lblMisses = new JLabel("Misses:");
		lblMisses.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMisses.setBounds(250, 176, 62, 14);
		getContentPane().add(lblMisses);
		
		lblHitsVal = new JLabel("0");
		lblHitsVal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHitsVal.setBounds(291, 132, 46, 14);
		getContentPane().add(lblHitsVal);
		
		lblMissesVal = new JLabel("0");
		lblMissesVal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMissesVal.setBounds(320, 178, 46, 14);
		getContentPane().add(lblMissesVal);
		
		btnRecord = new JButton("Record");
		btnRecord.setBackground(new Color(255, 100, 51));
		btnRecord.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new JOptionPane().showMessageDialog(getParent(), "Smallest number of misses: " +MemoryPanel.getRecordMisses());
			}
		});
		btnRecord.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRecord.setBounds(365, 130, 105, 60);
		getContentPane().add(btnRecord);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		setBounds((screenSize.width - 486) / 2, (screenSize.height - 287) / 2,
				486, 287);
	}
	/**
	 * Main metoda koja poziva novi prozor sa igricom.
	 * @param args
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				new MemoryGame().setVisible(true);

			}
		});
	}

	private JButton getBtnNewGame() {
		if (btnNewGame == null) {
			btnNewGame = new JButton("New Game");
			btnNewGame.setBackground(new Color(255, 153, 51));
			btnNewGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					MemoryGame mg = new MemoryGame();
					mg.setVisible(true);
					MemoryGame.this.setVisible(false);

				}
			});
			btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnNewGame.setBounds(250, 201, 220, 39);
		}
		return btnNewGame;
	}
	public static JLabel getLblHitsVal() {
		return lblHitsVal;
	}
	public void setLblHitsVal(JLabel lblHitsVal) {
		this.lblHitsVal = lblHitsVal;
	}
	public static JLabel getLblMissesVal() {
		return lblMissesVal;
	}
	public void setLblMissesVal(JLabel lblMissesVal) {
		this.lblMissesVal = lblMissesVal;
	}
	

}