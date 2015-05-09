import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BrojeviGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNajveciNivo;
	private JTextField txtNajveciNivo;
	private JLabel lblTrenutniNivo;
	private JTextField txtTrenutniNivo;
	private JButton btnIgraj;
	private JButton btnIzadji;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrojeviGUI frame = new BrojeviGUI();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BrojeviGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(800, 400));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		Brojevi brojevi=new Brojevi(10);
		brojevi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		brojevi.setPreferredSize(new Dimension(700, 400));
		contentPane.add(brojevi);
		brojevi.setLayout(null);
		contentPane.add(getPanel(), BorderLayout.EAST);
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(100, 10));
			panel.add(getLblNajveciNivo());
			panel.add(getTxtNajveciNivo());
			panel.add(getLblTrenutniNivo());
			panel.add(getTxtTrenutniNivo());
			panel.add(getBtnIgraj());
			panel.add(getBtnIzadji());
		}
		return panel;
	}
	private JLabel getLblNajveciNivo() {
		if (lblNajveciNivo == null) {
			lblNajveciNivo = new JLabel("Najveci nivo");
		}
		return lblNajveciNivo;
	}
	private JTextField getTxtNajveciNivo() {
		if (txtNajveciNivo == null) {
			txtNajveciNivo = new JTextField();
			txtNajveciNivo.setColumns(10);
		}
		return txtNajveciNivo;
	}
	private JLabel getLblTrenutniNivo() {
		if (lblTrenutniNivo == null) {
			lblTrenutniNivo = new JLabel("Trenutni nivo");
		}
		return lblTrenutniNivo;
	}
	private JTextField getTxtTrenutniNivo() {
		if (txtTrenutniNivo == null) {
			txtTrenutniNivo = new JTextField();
			txtTrenutniNivo.setColumns(10);
		}
		return txtTrenutniNivo;
	}
	private JButton getBtnIgraj() {
		if (btnIgraj == null) {
			btnIgraj = new JButton("Igraj");
		}
		return btnIgraj;
	}
	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
		}
		return btnIzadji;
	}
}
