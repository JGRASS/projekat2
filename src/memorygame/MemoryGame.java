package memorygame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MemoryGame extends javax.swing.JFrame {

	private ImageIcon bkgndIcon; 
	private JLabel jLabel1;
	private JLabel jLabel2;
	private memorygame.MemoryPanel memoryPanel1;
	/** Creates new form MemoryGame */
	public MemoryGame() {
		initComponents();

		bkgndIcon = new javax.swing.ImageIcon("resources/bojan.jpg");
		memoryPanel1.displayImage(bkgndIcon);
	}

	private void initComponents() {
		memoryPanel1 = new MemoryPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		getContentPane().setLayout(null);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Memory Game");
		memoryPanel1.setBorder(new javax.swing.border.LineBorder(
				new java.awt.Color(0, 0, 0), 4));
		getContentPane().add(memoryPanel1);
		memoryPanel1.setBounds(10, 10, 230, 230);
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
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		setBounds((screenSize.width - 486) / 2, (screenSize.height - 287) / 2,
				486, 287);
	}

	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MemoryGame().setVisible(true);
			}
		});
	}


}