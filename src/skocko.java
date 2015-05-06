import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class skocko extends JFrame {

	private JPanel contentPane;
	private JButton btnSkocko;
	private JButton btnZvezda;
	private JButton btnPik;
	private JButton btnSrce;
	private JButton btnTref;
	private JButton btnKaro;
	private JLabel a1;
	private JLabel a2;
	private JLabel a3;
	private JLabel a4;
	private JLabel b1;
	private JLabel b2;
	private JLabel b3;
	private JLabel b4;
	private JLabel c1;
	private JLabel c2;
	private JLabel c3;
	private JLabel c4;
	private JLabel d1;
	private JLabel d2;
	private JLabel d3;
	private JLabel d4;
	private JLabel e1;
	private JLabel e2;
	private JLabel e3;
	private JLabel e4;
	private JLabel f1;
	private JLabel f2;
	private JLabel f3;
	private JLabel f4;
	
	private int brojacKlikova = 1;
	
	private JLabel aa;
	private JLabel ab;
	private JLabel ac;
	private JLabel ad;
	private JLabel ba;
	private JLabel bb;
	private JLabel bc;
	private JLabel bd;
	private JLabel ca;
	private JLabel cb;
	private JLabel cc;
	private JLabel cd;
	private JLabel da;
	private JLabel db;
	private JLabel dc;
	private JLabel dd;
	private JLabel ea;
	private JLabel eb;
	private JLabel ec;
	private JLabel ed;
	private JLabel fa;
	private JLabel fb;
	private JLabel fc;
	private JLabel fd;
	private JProgressBar progressBar;
	private JLabel lblVreme;
	private JButton btnStart;
	private JButton btnReenje;
	private JTextField textField;
	private JLabel r1;
	private JLabel r2;
	private JLabel r3;
	private JLabel r4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					skocko frame = new skocko();
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
	public skocko() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnSkocko());
		contentPane.add(getBtnZvezda());
		contentPane.add(getBtnPik());
		contentPane.add(getBtnSrce());
		contentPane.add(getBtnTref());
		contentPane.add(getBtnKaro());
		contentPane.add(getA1());
		contentPane.add(getA2());
		contentPane.add(getA3());
		contentPane.add(getA4());
		contentPane.add(getB1());
		contentPane.add(getB2());
		contentPane.add(getB3());
		contentPane.add(getB4());
		contentPane.add(getC1());
		contentPane.add(getC2());
		contentPane.add(getC3());
		contentPane.add(getC4());
		contentPane.add(getD1());
		contentPane.add(getD2());
		contentPane.add(getD3());
		contentPane.add(getD4());
		contentPane.add(getE1());
		contentPane.add(getE2());
		contentPane.add(getE3());
		contentPane.add(getE4());
		contentPane.add(getF1());
		contentPane.add(getF2());
		contentPane.add(getF3());
		contentPane.add(getF4());
		
		contentPane.add(getAa());
		contentPane.add(getAb());
		contentPane.add(getAc());
		contentPane.add(getAd());
		contentPane.add(getBa());
		contentPane.add(getBb());
		contentPane.add(getBc());
		contentPane.add(getBd());
		contentPane.add(getCa());
		contentPane.add(getCb());
		contentPane.add(getCc());
		contentPane.add(getCd());
		contentPane.add(getDa());
		contentPane.add(getDb());
		contentPane.add(getDc());
		contentPane.add(getDd());
		contentPane.add(getEa());
		contentPane.add(getEb());
		contentPane.add(getEc());
		contentPane.add(getEd());
		contentPane.add(getFa());
		contentPane.add(getFb());
		contentPane.add(getFc());
		contentPane.add(getFd());
		contentPane.add(getProgressBar());
		contentPane.add(getLblVreme());
		contentPane.add(getBtnStart());
		contentPane.add(getBtnReenje());
		contentPane.add(getTextField());
		contentPane.add(getR1());
		contentPane.add(getR2());
		contentPane.add(getR3());
		contentPane.add(getR4());
		
		setLocationRelativeTo(null);
	}
	
	private JButton getBtnSkocko() {
		if (btnSkocko == null) {
			btnSkocko = new JButton("");
			btnSkocko.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnSkocko);
					brojacKlikova++;
				}
			});
			btnSkocko.setIcon(new ImageIcon(this.getClass().getResource("/skocko.png")));
			btnSkocko.setBounds(10, 10, 50, 50);
		}
		return btnSkocko;
	}
	private JButton getBtnZvezda() {
		if (btnZvezda == null) {
			btnZvezda = new JButton("");
			btnZvezda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnZvezda);
					brojacKlikova++;
				}
			});
			btnZvezda.setIcon(new ImageIcon(this.getClass().getResource("/zvezda.png")));
			btnZvezda.setBounds(10, 70, 50, 50);
		}
		return btnZvezda;
	}
	private JButton getBtnPik() {
		if (btnPik == null) {
			btnPik = new JButton("");
			btnPik.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnPik);
					brojacKlikova++;
				}
			});
			btnPik.setIcon(new ImageIcon(this.getClass().getResource("/tref.png")));
			btnPik.setBounds(10, 130, 50, 50);
		}
		return btnPik;
	}
	private JButton getBtnSrce() {
		if (btnSrce == null) {
			btnSrce = new JButton("");
			btnSrce.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnSrce);
					brojacKlikova++;
				}
			});
			btnSrce.setIcon(new ImageIcon(this.getClass().getResource("/srce.png")));
			btnSrce.setBounds(10, 190, 50, 50);
		}
		return btnSrce;
	}
	private JButton getBtnTref() {
		if (btnTref == null) {
			btnTref = new JButton("");
			btnTref.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnTref);
					brojacKlikova++;
				}
			});
			btnTref.setIcon(new ImageIcon(this.getClass().getResource("/pik.png")));
			btnTref.setBounds(10, 250, 50, 50);
		}
		return btnTref;
	}
	private JButton getBtnKaro() {
		if (btnKaro == null) {
			btnKaro = new JButton("");
			btnKaro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					klik(btnKaro);
					brojacKlikova++;
				}
			});
			btnKaro.setIcon(new ImageIcon(this.getClass().getResource("/karo.png")));
			btnKaro.setBounds(10, 310, 50, 50);
		}
		return btnKaro;
	}
	private JLabel getA1() {
		if (a1 == null) {
			a1 = new JLabel("");
			a1.setOpaque(true);
			a1.setBackground(SystemColor.inactiveCaption);
			a1.setBounds(100, 10, 50, 50);
		}
		return a1;
	}
	private JLabel getA2() {
		if (a2 == null) {
			a2 = new JLabel("");
			a2.setOpaque(true);
			a2.setBackground(SystemColor.inactiveCaption);
			a2.setBounds(160, 10, 50, 50);
		}
		return a2;
	}
	
	private JLabel getA3() {
		if (a3 == null) {
			a3 = new JLabel("");
			a3.setOpaque(true);
			a3.setBackground(SystemColor.inactiveCaption);
			a3.setBounds(220, 10, 50, 50);
		}
		return a3;
	}
	private JLabel getA4() {
		if (a4 == null) {
			a4 = new JLabel("");
			a4.setOpaque(true);
			a4.setBackground(SystemColor.inactiveCaption);
			a4.setBounds(280, 10, 50, 50);
		}
		return a4;
	}
	
	private JLabel getB1() {
		if (b1 == null) {
			b1 = new JLabel("");
			b1.setOpaque(true);
			b1.setBackground(SystemColor.inactiveCaption);
			b1.setBounds(100, 70, 50, 50);
		}
		return b1;
	}
	private JLabel getB2() {
		if (b2 == null) {
			b2 = new JLabel("");
			b2.setOpaque(true);
			b2.setBackground(SystemColor.inactiveCaption);
			b2.setBounds(160, 70, 50, 50);
		}
		return b2;
	}
	
	private JLabel getB3() {
		if (b3 == null) {
			b3 = new JLabel("");
			b3.setOpaque(true);
			b3.setBackground(SystemColor.inactiveCaption);
			b3.setBounds(220, 70, 50, 50);
		}
		return b3;
	}
	private JLabel getB4() {
		if (b4 == null) {
			b4 = new JLabel("");
			b4.setOpaque(true);
			b4.setBackground(SystemColor.inactiveCaption);
			b4.setBounds(280, 70, 50, 50);
		}
		return b4;
	}
	private JLabel getC1() {
		if (c1 == null) {
			c1 = new JLabel("");
			c1.setOpaque(true);
			c1.setBackground(SystemColor.inactiveCaption);
			c1.setBounds(100, 130, 50, 50);
		}
		return c1;
	}
	private JLabel getC2() {
		if (c2 == null) {
			c2 = new JLabel("");
			c2.setOpaque(true);
			c2.setBackground(SystemColor.inactiveCaption);
			c2.setBounds(160, 130, 50, 50);
		}
		return c2;
	}
	
	private JLabel getC3() {
		if (c3 == null) {
			c3 = new JLabel("");
			c3.setOpaque(true);
			c3.setBackground(SystemColor.inactiveCaption);
			c3.setBounds(220, 130, 50, 50);
		}
		return c3;
	}
	private JLabel getC4() {
		if (c4 == null) {
			c4 = new JLabel("");
			c4.setOpaque(true);
			c4.setBackground(SystemColor.inactiveCaption);
			c4.setBounds(280, 130, 50, 50);
		}
		return c4;
	}
	private JLabel getD1() {
		if (d1 == null) {
			d1 = new JLabel("");
			d1.setOpaque(true);
			d1.setBackground(SystemColor.inactiveCaption);
			d1.setBounds(100, 190, 50, 50);
		}
		return d1;
	}
	private JLabel getD2() {
		if (d2 == null) {
			d2 = new JLabel("");
			d2.setOpaque(true);
			d2.setBackground(SystemColor.inactiveCaption);
			d2.setBounds(160, 190, 50, 50);
		}
		return d2;
	}
	
	private JLabel getD3() {
		if (d3 == null) {
			d3 = new JLabel("");
			d3.setOpaque(true);
			d3.setBackground(SystemColor.inactiveCaption);
			d3.setBounds(220, 190, 50, 50);
		}
		return d3;
	}
	private JLabel getD4() {
		if (d4 == null) {
			d4 = new JLabel("");
			d4.setOpaque(true);
			d4.setBackground(SystemColor.inactiveCaption);
			d4.setBounds(280, 190, 50, 50);
		}
		return d4;
	}
	private JLabel getE1() {
		if (e1 == null) {
			e1 = new JLabel("");
			e1.setOpaque(true);
			e1.setBackground(SystemColor.inactiveCaption);
			e1.setBounds(100, 250, 50, 50);
		}
		return e1;
	}
	private JLabel getE2() {
		if (e2 == null) {
			e2 = new JLabel("");
			e2.setOpaque(true);
			e2.setBackground(SystemColor.inactiveCaption);
			e2.setBounds(160, 250, 50, 50);
		}
		return e2;
	}
	
	private JLabel getE3() {
		if (e3 == null) {
			e3 = new JLabel("");
			e3.setOpaque(true);
			e3.setBackground(SystemColor.inactiveCaption);
			e3.setBounds(220, 250, 50, 50);
		}
		return e3;
	}
	private JLabel getE4() {
		if (e4 == null) {
			e4 = new JLabel("");
			e4.setOpaque(true);
			e4.setBackground(SystemColor.inactiveCaption);
			e4.setBounds(280, 250, 50, 50);
		}
		return e4;
	}
	private JLabel getF1() {
		if (f1 == null) {
			f1 = new JLabel("");
			f1.setOpaque(true);
			f1.setBackground(SystemColor.inactiveCaption);
			f1.setBounds(100, 310, 50, 50);
		}
		return f1;
	}
	private JLabel getF2() {
		if (f2 == null) {
			f2 = new JLabel("");
			f2.setOpaque(true);
			f2.setBackground(SystemColor.inactiveCaption);
			f2.setBounds(160, 310, 50, 50);
		}
		return f2;
	}
	
	private JLabel getF3() {
		if (f3 == null) {
			f3 = new JLabel("");
			f3.setOpaque(true);
			f3.setBackground(SystemColor.inactiveCaption);
			f3.setBounds(220, 310, 50, 50);
		}
		return f3;
	}
	private JLabel getF4() {
		if (f4 == null) {
			f4 = new JLabel("");
			f4.setOpaque(true);
			f4.setBackground(SystemColor.inactiveCaption);
			f4.setBounds(280, 310, 50, 50);
		}
		return f4;
	}
	private JLabel getAa() {
		if (aa == null) {
			aa = new JLabel("");
			aa.setBackground(SystemColor.inactiveCaptionBorder);
			aa.setOpaque(true);
			aa.setBounds(340, 10, 22, 22);
		}
		return aa;
	}
	private JLabel getAb() {
		if (ab == null) {
			ab = new JLabel("");
			ab.setBackground(SystemColor.inactiveCaptionBorder);
			ab.setOpaque(true);
			ab.setBounds(368, 10, 22, 22);
		}
		return ab;
	}
	private JLabel getAc() {
		if (ac == null) {
			ac = new JLabel("");
			ac.setBackground(SystemColor.inactiveCaptionBorder);
			ac.setOpaque(true);
			ac.setBounds(340, 38, 22, 22);
		}
		return ac;
	}
	private JLabel getAd() {
		if (ad == null) {
			ad = new JLabel("");
			ad.setBackground(SystemColor.inactiveCaptionBorder);
			ad.setOpaque(true);
			ad.setBounds(368, 38, 22, 22);
		}
		return ad;
	}
	private JLabel getBa() {
		if (ba == null) {
			ba = new JLabel("");
			ba.setBackground(SystemColor.inactiveCaptionBorder);
			ba.setOpaque(true);
			ba.setBounds(340, 70, 22, 22);
		}
		return ba;
	}
	private JLabel getBb() {
		if (bb == null) {
			bb = new JLabel("");
			bb.setBackground(SystemColor.inactiveCaptionBorder);
			bb.setOpaque(true);
			bb.setBounds(368, 70, 22, 22);
		}
		return bb;
	}
	private JLabel getBc() {
		if (bc == null) {
			bc = new JLabel("");
			bc.setBackground(SystemColor.inactiveCaptionBorder);
			bc.setOpaque(true);
			bc.setBounds(340, 98, 22, 22);
		}
		return bc;
	}
	private JLabel getBd() {
		if (bd == null) {
			bd = new JLabel("");
			bd.setBackground(SystemColor.inactiveCaptionBorder);
			bd.setOpaque(true);
			bd.setBounds(368, 98, 22, 22);
		}
		return bd;
	}
	private JLabel getCa() {
		if (ca == null) {
			ca = new JLabel("");
			ca.setBackground(SystemColor.inactiveCaptionBorder);
			ca.setOpaque(true);
			ca.setBounds(340, 130, 22, 22);
		}
		return ca;
	}
	private JLabel getCb() {
		if (cb == null) {
			cb = new JLabel("");
			cb.setBackground(SystemColor.inactiveCaptionBorder);
			cb.setOpaque(true);
			cb.setBounds(368, 130, 22, 22);
		}
		return cb;
	}
	private JLabel getCc() {
		if (cc == null) {
			cc = new JLabel("");
			cc.setBackground(SystemColor.inactiveCaptionBorder);
			cc.setOpaque(true);
			cc.setBounds(340, 158, 22, 22);
		}
		return cc;
	}
	private JLabel getCd() {
		if (cd == null) {
			cd = new JLabel("");
			cd.setBackground(SystemColor.inactiveCaptionBorder);
			cd.setOpaque(true);
			cd.setBounds(368, 158, 22, 22);
		}
		return cd;
	}
	private JLabel getDa() {
		if (da == null) {
			da = new JLabel("");
			da.setBackground(SystemColor.inactiveCaptionBorder);
			da.setOpaque(true);
			da.setBounds(340, 190, 22, 22);
		}
		return da;
	}
	private JLabel getDb() {
		if (db == null) {
			db = new JLabel("");
			db.setBackground(SystemColor.inactiveCaptionBorder);
			db.setOpaque(true);
			db.setBounds(368, 190, 22, 22);
		}
		return db;
	}
	private JLabel getDc() {
		if (dc == null) {
			dc = new JLabel("");
			dc.setBackground(SystemColor.inactiveCaptionBorder);
			dc.setOpaque(true);
			dc.setBounds(340, 218, 22, 22);
		}
		return dc;
	}
	private JLabel getDd() {
		if (dd == null) {
			dd = new JLabel("");
			dd.setBackground(SystemColor.inactiveCaptionBorder);
			dd.setOpaque(true);
			dd.setBounds(368, 218, 22, 22);
		}
		return dd;
	}
	private JLabel getEa() {
		if (ea == null) {
			ea = new JLabel("");
			ea.setBackground(SystemColor.inactiveCaptionBorder);
			ea.setOpaque(true);
			ea.setBounds(340, 250, 22, 22);
		}
		return ea;
	}
	private JLabel getEb() {
		if (eb == null) {
			eb = new JLabel("");
			eb.setBackground(SystemColor.inactiveCaptionBorder);
			eb.setOpaque(true);
			eb.setBounds(368, 250, 22, 22);
		}
		return eb;
	}
	private JLabel getEc() {
		if (ec == null) {
			ec = new JLabel("");
			ec.setBackground(SystemColor.inactiveCaptionBorder);
			ec.setOpaque(true);
			ec.setBounds(340, 278, 22, 22);
		}
		return ec;
	}
	private JLabel getEd() {
		if (ed == null) {
			ed = new JLabel("");
			ed.setBackground(SystemColor.inactiveCaptionBorder);
			ed.setOpaque(true);
			ed.setBounds(368, 278, 22, 22);
		}
		return ed;
	}
	private JLabel getFa() {
		if (fa == null) {
			fa = new JLabel("");
			fa.setBackground(SystemColor.inactiveCaptionBorder);
			fa.setOpaque(true);
			fa.setBounds(340, 310, 22, 22);
		}
		return fa;
	}
	private JLabel getFb() {
		if (fb == null) {
			fb = new JLabel("");
			fb.setBackground(SystemColor.inactiveCaptionBorder);
			fb.setOpaque(true);
			fb.setBounds(368, 310, 22, 22);
		}
		return fb;
	}
	private JLabel getFc() {
		if (fc == null) {
			fc = new JLabel("");
			fc.setBackground(SystemColor.inactiveCaptionBorder);
			fc.setOpaque(true);
			fc.setBounds(340, 338, 22, 22);
		}
		return fc;
	}
	private JLabel getFd() {
		if (fd == null) {
			fd = new JLabel("");
			fd.setBackground(SystemColor.inactiveCaptionBorder);
			fd.setOpaque(true);
			fd.setBounds(368, 338, 22, 22);
		}
		return fd;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setOrientation(SwingConstants.VERTICAL);
			progressBar.setBounds(415, 38, 41, 322);
		}
		return progressBar;
	}
	private JLabel getLblVreme() {
		if (lblVreme == null) {
			lblVreme = new JLabel("VREME");
			lblVreme.setFont(new Font("Eras Bold ITC", Font.PLAIN, 13));
			lblVreme.setBounds(412, 10, 56, 22);
		}
		return lblVreme;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(415, 373, 41, 41);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getR1() {
		if (r1 == null) {
			r1 = new JLabel("");
			r1.setBounds(100, 370, 50, 50);
		}
		return r1;
	}
	private JLabel getR2() {
		if (r2 == null) {
			r2 = new JLabel("");
			r2.setBounds(160, 370, 50, 50);
		}
		return r2;
	}
	private JLabel getR3() {
		if (r3 == null) {
			r3 = new JLabel("");
			r3.setBounds(220, 370, 50, 50);
		}
		return r3;
	}
	private JLabel getR4() {
		if (r4 == null) {
			r4 = new JLabel("");
			r4.setBounds(280, 370, 50, 50);
		}
		return r4;
	}
	private JButton getBtnReenje() {
		if (btnReenje == null) {
			btnReenje = new JButton("RE\u0160ENJE");
			btnReenje.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
			btnReenje.setBounds(220, 427, 110, 42);
		}
		return btnReenje;
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("START");
			btnStart.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
			btnStart.setBounds(100, 427, 110, 42);
		}
		return btnStart;
	}
	public void klik(JButton button) {
		switch(brojacKlikova) {
			case 1:a1.setIcon(button.getIcon()); break;
			case 2:a2.setIcon(button.getIcon()); break;
			case 3:a3.setIcon(button.getIcon()); break;
			case 4:a4.setIcon(button.getIcon()); break; 
			case 5:b1.setIcon(button.getIcon()); break;
			case 6:b2.setIcon(button.getIcon()); break;
			case 7:b3.setIcon(button.getIcon()); break;
			case 8:b4.setIcon(button.getIcon()); break;
			case 9:c1.setIcon(button.getIcon()); break;
			case 10:c2.setIcon(button.getIcon()); break;
			case 11:c3.setIcon(button.getIcon()); break;
			case 12:c4.setIcon(button.getIcon()); break;
			case 13:d1.setIcon(button.getIcon()); break;
			case 14:d2.setIcon(button.getIcon()); break;
			case 15:d3.setIcon(button.getIcon()); break;
			case 16:d4.setIcon(button.getIcon()); break;
			case 17:e1.setIcon(button.getIcon()); break;
			case 18:e2.setIcon(button.getIcon()); break;
			case 19:e3.setIcon(button.getIcon()); break;
			case 20:e4.setIcon(button.getIcon()); break;
			case 21:f1.setIcon(button.getIcon()); break;
			case 22:f2.setIcon(button.getIcon()); break;
			case 23:f3.setIcon(button.getIcon()); break;
			case 24:f4.setIcon(button.getIcon()); break;
		}
	}
}