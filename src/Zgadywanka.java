import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Panel;

public class Zgadywanka {

	public JFrame frmZgadywanka;
	public JTextField textWprowadz;
	private JLabel lblInfo, lblInfo2, lblLiczbaProb, lblZgadles, lblWylosowanaLiczba;
	private JButton btnZgaduj, btnRestart;

	
	int liczba;
    int liczbaKomputera = new Random().ints(1, 101).findFirst().getAsInt();
    int counter = 0;
    
	
	/**
	 * Create the application.
	 */
	public Zgadywanka() {
	
	
		frmZgadywanka = new JFrame();
		frmZgadywanka.setTitle("Zgadywanka");
		frmZgadywanka.getContentPane().setBackground(SystemColor.controlDkShadow);
		frmZgadywanka.setResizable(false);
		frmZgadywanka.setForeground(Color.BLACK);
		frmZgadywanka.setBackground(UIManager.getColor("Button.darkShadow"));
		frmZgadywanka.setBounds(100, 100, 450, 300);
		frmZgadywanka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmZgadywanka.getContentPane().setLayout(null);
		frmZgadywanka.setVisible(true);
		
		lblInfo = new JLabel("Komputer wylosowa\u0142 liczbe od 0 do 100");
		lblInfo.setForeground(Color.BLACK);
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(94, 13, 246, 20);
		frmZgadywanka.getContentPane().add(lblInfo);
		
		lblInfo2= new JLabel("Zgadnij jaka to liczba !");
		lblInfo2.setForeground(Color.BLACK);
		lblInfo2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInfo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo2.setBounds(104, 46, 236, 14);
		frmZgadywanka.getContentPane().add(lblInfo2);
		
		textWprowadz = new JTextField();
		textWprowadz.setToolTipText("Wprowadz liczbe od 0 do 100");
		textWprowadz.setBounds(187, 89, 86, 20);
		frmZgadywanka.getContentPane().add(textWprowadz);
		textWprowadz.setColumns(10);
		
		btnZgaduj = new JButton("ZGADUJ");
		btnZgaduj.setToolTipText("Naci\u015Bnij aby zaproponowac liczb\u0119");
		btnZgaduj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					liczba = Integer.parseInt(textWprowadz.getText());
				
					do {
						if (liczba > liczbaKomputera) {
							lblZgadles.setText("Za duzo");
							counter++;
							lblLiczbaProb.setText("Liczba prób: " + counter);
							break;
						} else if (liczba < liczbaKomputera) {
							lblZgadles.setText("Za ma³o");
							counter++;
							lblLiczbaProb.setText("Liczba prób: " + counter);
							break;
						} else {
							lblZgadles.setText("SUPER, TRAFILEŒ, Wylosowana liczba to: " + liczbaKomputera);
							counter++;
							lblLiczbaProb.setText("Liczba prób: " + counter);
							break;
						}
					} while (liczba != liczbaKomputera);
			    
					}
				catch(Exception e1) {
					
					UIManager.put("Button.background" , SystemColor.scrollbar);
					UIManager.put("OptionPane.background", SystemColor.controlDkShadow );
					UIManager.put("text", Color.BLACK );
					//UIManager.put("OptionPane.foreground", SystemColor.controlDkShadow );
					UIManager.put("OptionPane.messgaeforeground", Color.BLACK );
					//UIManager.put("OptionPane.messgaebackground", Color.BLACK );
					//UIManager.put("Panel.backgroud", Color.GRAY );
					//UIManager.put("Panel.foreground", Color.GRAY );
					//UIManager.put("Dialog.backgroud", SystemColor.controlDkShadow );
					//UIManager.put("Dialog.foreground", SystemColor.controlDkShadow );
					//UIManager.put("TextField.background", SystemColor.controlDkShadow );
					//UIManager.put("TextField.foreground", SystemColor.controlDkShadow );
					//UIManager.put("OptionPane.errorDialog.titlePane.foreground", SystemColor.controlDkShadow );
					//UIManager.put("OptionPane.errorDialog.titlePane.background", SystemColor.controlDkShadow );
					//UIManager.put("Label.background", SystemColor.controlDkShadow );
					//UIManager.put("Label.foreground", SystemColor.controlDkShadow );
					//UIManager.put("TextPane.background", SystemColor.controlDkShadow );
					//UIManager.put("TextPane.foreground", SystemColor.controlDkShadow );
					UIManager.getLookAndFeelDefaults().put("Panel.background", SystemColor.controlDkShadow);
					UIManager.put("OptionPane.messageDialogTitle", "B³¹d" );
					JOptionPane.showMessageDialog(null, "Wprowadz liczbê od 0 do 100", "B³¹d",JOptionPane.INFORMATION_MESSAGE);
				
				}
			}
		});
		
		btnZgaduj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnZgaduj.setBackground(SystemColor.scrollbar);
		btnZgaduj.setForeground(Color.BLACK);
		btnZgaduj.setBounds(35, 88, 117, 23);
		frmZgadywanka.getContentPane().add(btnZgaduj);
		
		lblLiczbaProb = new JLabel("Liczba pr\u00F3b: 0");
		lblLiczbaProb.setForeground(Color.BLACK);
		lblLiczbaProb.setBounds(308, 92, 90, 14);
		frmZgadywanka.getContentPane().add(lblLiczbaProb);
		
		btnRestart = new JButton("RESET");
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRestart.setForeground(Color.BLACK);
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				liczbaKomputera = new Random().ints(1, 101).findFirst().getAsInt();
		        counter = 0;
		        lblLiczbaProb.setText("Liczba pr\u00F3b: 0");
		        lblZgadles.setText("");
		        textWprowadz.setText(null);
				
			}
		});
		btnRestart.setBackground(SystemColor.scrollbar);
		btnRestart.setToolTipText("Po klikni\u0119ciu gra rozpocznie si\u0119 od nowa");
		btnRestart.setBounds(251, 222, 89, 23);
		frmZgadywanka.getContentPane().add(btnRestart);
		
		lblZgadles = new JLabel("");
		lblZgadles.setForeground(Color.BLACK);
		lblZgadles.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblZgadles.setHorizontalAlignment(SwingConstants.CENTER);
		lblZgadles.setBounds(35, 120, 363, 40);
		frmZgadywanka.getContentPane().add(lblZgadles);
		
		lblWylosowanaLiczba = new JLabel("");
		lblWylosowanaLiczba.setForeground(Color.BLACK);
		lblWylosowanaLiczba.setHorizontalAlignment(SwingConstants.CENTER);
		lblWylosowanaLiczba.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWylosowanaLiczba.setBounds(71, 171, 291, 23);
		frmZgadywanka.getContentPane().add(lblWylosowanaLiczba);
	}
	}


