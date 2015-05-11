package memorygame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JButton btnNewButton;

	/** Konstruktor za kreiranje prozora sa igricom */
	public MemoryGame() {
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
		getContentPane().add(getBtnNewButton());
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

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New Game");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					MemoryGame mg = new MemoryGame();
					mg.setVisible(true);
					MemoryGame.this.setVisible(false);

				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnNewButton.setBounds(250, 201, 220, 39);
		}
		return btnNewButton;
	}
	

}