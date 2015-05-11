package memorygame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MemoryPanel extends JPanel implements Serializable {
	public final static int X_OFFSET = 5;
	public final static int Y_OFFSET = 5;
	public final static int X_INDENT = 5;
	public final static int Y_INDENT = 5;
	public int row = 4;
	public int col = 4;

	private Image currentImage;
	private int panelWidth;
	private int panelHeight;
	private JLabel[] lbl;
	private int selectCounter = 0;
	private int firstPick, secondPick;
	private String[] match;
	private java.util.List<String> matchList = new ArrayList<String>();
	private javax.swing.Timer displayDelay;
	private boolean ignoreInput = false;

	/**
	 * Create the panel.
	 */
	public MemoryPanel() {
		initComponents();
		initPanel();
	}

	private void initPanel() {
		Character c;

		for (int i = 0; i < row * col / 2; i++) {
			c = new Character((char) ('A' + i));
			matchList.add(c.toString());
			matchList.add(c.toString());
		}

		Collections.shuffle(matchList);

		match = new String[row * col];
		lbl = new JLabel[row * col];

		for (int i = 0; i < row * col; i++) {
			match[i] = matchList.get(i);

			lbl[i] = new JLabel();
			lbl[i].setText(Integer.toString(i + 1));
			lbl[i].setFont(new Font("SansSerif", Font.BOLD, 24));
			lbl[i].setOpaque(true);
			lbl[i].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			lbl[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			lbl[i].setForeground(Color.black);
			lbl[i].setBorder(new LineBorder(Color.black));
			lbl[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					mouseClickedHandler(e);
				}
			});

			add(lbl[i]);
		}

		displayDelay = new javax.swing.Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timerActionPerformed();
			}
		});
		displayDelay.setRepeats(false);
	}

	public void setImage(Image img) {
		currentImage = img;
	}

	public void setImage(ImageIcon imgIcon) {
		currentImage = imgIcon.getImage();
	}

	public void displayImage() {
		repaint();
	}

	public void displayImage(ImageIcon imgIcon) {
		setImage(imgIcon);
		repaint();
	}

	public void displayImage(Image img) {
		setImage(img);
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = this.getWidth() - X_OFFSET - X_INDENT;
		int height = this.getHeight() - Y_OFFSET - Y_INDENT;
		g.drawImage(currentImage, X_OFFSET, Y_OFFSET, width, height, this);
	}

	private void timerActionPerformed() {
		if (match[firstPick].equals(match[secondPick])) {
			lbl[firstPick].setBorder(null);
			lbl[secondPick].setBorder(null);
			lbl[firstPick].setOpaque(false);
			lbl[secondPick].setOpaque(false);
			lbl[firstPick].setText("");
			lbl[secondPick].setText("");
			lbl[firstPick].setEnabled(false);
			lbl[secondPick].setEnabled(false);
		} else {
			lbl[firstPick].setText(Integer.toString(firstPick + 1));
			lbl[secondPick].setText(Integer.toString(secondPick + 1));
		}
		ignoreInput = false;
	}

	private void mouseClickedHandler(MouseEvent e) {
		if (ignoreInput)
			return;

		JLabel l = null;

		int index = -1;

		for (int i = 0; i < row * col; i++) {
			if (e.getSource() == lbl[i]) {
				l = lbl[i];
				index = i;

				if (!l.isOpaque())
					return;

				l.setText(match[i]);
				break;
			}
		}

		if (l == null)
			return;

		selectCounter++;
		if (selectCounter == 1) {
			firstPick = index;
		}
		if (selectCounter == 2) {
			if (firstPick == index) {
				selectCounter--;
				return;
			}

			selectCounter = 0;
			secondPick = index;
			ignoreInput = true;
			displayDelay.start();
		}

	}

	private void initComponents() {
		setLayout(new java.awt.GridLayout(4, 4));
	}

}
