import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class BrojeviGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNajveciNivo;
	private JTextField txtNajveciNivo;
	private JLabel lblTrenutniNivo;
	private JTextField txtTrenutniNivo;
	private JButton btnIgraj;
	private JButton btnIzadji;
	private  Brojevi brojevi;
	private Timer timer;
	private int vreme;
	private int nivo;
	private int highScore;
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
		timer=new Timer();
		ucitajRez();
		postavi();
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
	private void postavi(){
		if(brojevi!=null) brojevi.setVisible(false);
		brojevi=new Brojevi(5+nivo);
		getTxtNajveciNivo();
		getTxtTrenutniNivo();
		brojevi.setVisible(true);
		if(nivo>highScore) highScore=nivo;
		txtTrenutniNivo.setText(Integer.toString(nivo));
		txtNajveciNivo.setText(Integer.toString(highScore));		
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
			lblNajveciNivo.setBounds(21, 5, 105, 14);
		}
		return lblNajveciNivo;
	}
	private JTextField getTxtNajveciNivo() {
		if (txtNajveciNivo == null) {
			txtNajveciNivo = new JTextField();
			txtNajveciNivo.setEnabled(false);
			txtNajveciNivo.setBounds(21, 24, 105, 20);
			txtNajveciNivo.setColumns(10);
		}
		return txtNajveciNivo;
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
	private void sacuvajRez(){
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("highscore.out")));
			
			//highScore=Integer.parseInt(txtNajveciNivo.getText());
			out.writeInt(highScore);
			
			out.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	private void ucitajRez(){
		try{
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("highscore.out")));
			if(in.available()!=0)
			 highScore=in.readInt();
			else highScore=0;
			
			in.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	public void izadji(){
		sacuvajRez();
		dispose();		
	}
}
