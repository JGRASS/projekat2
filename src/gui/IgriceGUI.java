package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IgriceGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnBrojevi;
	private JButton btnMemorija;
	private JButton btnSkocko;
	private JButton btnOAutorima;

	/**
	 * Create the frame.
	 */
	public IgriceGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnBrojevi());
		contentPane.add(getBtnMemorija());
		contentPane.add(getBtnSkocko());
		contentPane.add(getBtnOAutorima());
	}
	private JButton getBtnBrojevi() {
		if (btnBrojevi == null) {
			btnBrojevi = new JButton("BROJEVI");
			btnBrojevi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontoler.prikaziBrojeviGUI();
				}
			});
			btnBrojevi.setBounds(32, 161, 108, 79);
		}
		return btnBrojevi;
	}
	private JButton getBtnMemorija() {
		if (btnMemorija == null) {
			btnMemorija = new JButton("MEMORIJA");
			btnMemorija.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontoler.prikaziMemoriju();
				}
			});
			btnMemorija.setBounds(223, 38, 108, 79);
		}
		return btnMemorija;
	}
	private JButton getBtnSkocko() {
		if (btnSkocko == null) {
			btnSkocko = new JButton("SKOCKO");
			btnSkocko.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontoler.prikaziSkocko();
				}
			});
			btnSkocko.setBounds(32, 38, 108, 79);
		}
		return btnSkocko;
	}
	private JButton getBtnOAutorima() {
		if (btnOAutorima == null) {
			btnOAutorima = new JButton("O AUTORIMA");
			btnOAutorima.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontoler.prikaziAutore(null);
				}
			});
			btnOAutorima.setBounds(223, 161, 114, 79);
		}
		return btnOAutorima;
	}
}
