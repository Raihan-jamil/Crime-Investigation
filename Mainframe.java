import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Mainframe {

	private JFrame frame;
	private CardLayout card;
	private JTextField txt1user;
	private JPasswordField txt2user;
	private JTextField txt1admin;
	private JPasswordField txt2admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe window = new Mainframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 744, 515);
		frame.setTitle("Crime Investigation System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel contentpanel = new JPanel();
		frame.getContentPane().add(contentpanel, BorderLayout.CENTER);
		card=new CardLayout();
		contentpanel.setLayout(card);
		
		JPanel panel = new JPanel();
		contentpanel.add(panel, "name_6438825774869");
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		contentpanel.add(panel_1, "panel1");
		panel_1.setLayout(null);
		
		txt1user = new JTextField();
		txt1user.setBounds(328, 136, 173, 36);
		panel_1.add(txt1user);
		txt1user.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(219, 146, 91, 15);
		panel_1.add(lblNewLabel);
		
		txt2user = new JPasswordField();
		txt2user.setBounds(328, 187, 173, 46);
		panel_1.add(txt2user);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(219, 202, 70, 15);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String name=txt1user.getText().toString().trim();
				String userName, password;
				userName = txt1user.getText();
				password = txt2user.getText();
				Database db = new Database();
				
				try {
					db.connect();
					String check = db.login(userName, password);
					if (check == "Connected") {
						// new MainFrame();
						JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success",
								JOptionPane.INFORMATION_MESSAGE);
								card.show(contentpanel, "panel3");
						db.disconnect();
					} else {
						JOptionPane.showMessageDialog(null, "Login failed!", "Failed!!", JOptionPane.ERROR_MESSAGE);

					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Problem in Connection");
				}
				
				
			}
		});
		btnNewButton_2.setBounds(518, 292, 117, 46);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		contentpanel.add(panel_2, "panel2");
		JPanel panel_3 = new JPanel();
		contentpanel.add(panel_3, "panel3");
		panel_3.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Insert crimer info");
		btnNewButton_3.setBounds(306, 73, 216, 54);
		panel_3.add(btnNewButton_3);
		
		JButton btnUpdateCrimerInfo = new JButton("update crimer info");
		btnUpdateCrimerInfo.setBounds(306, 168, 216, 46);
		panel_3.add(btnUpdateCrimerInfo);
		
		JButton btnDeleteCrimerInfo = new JButton("delete crimer info");
		btnDeleteCrimerInfo.setBounds(306, 255, 216, 61);
		panel_3.add(btnDeleteCrimerInfo);
		
		JButton btnViewCrimerInfo = new JButton("view crimer info");
		btnViewCrimerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentpanel, "panel5");
			}
		});
		btnViewCrimerInfo.setBounds(306, 348, 225, 63);
		panel_3.add(btnViewCrimerInfo);
		
		JPanel panel_4 = new JPanel();
		contentpanel.add(panel_4, "panel4");
		panel_4.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("view crimer list");
		btnNewButton_4.setBounds(297, 58, 200, 54);
		panel_4.add(btnNewButton_4);
		
		JButton btnViewCrimerInfo_1 = new JButton("view crimer info");
		btnViewCrimerInfo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentpanel, "panel5");
			}
		});
		btnViewCrimerInfo_1.setBounds(297, 129, 200, 54);
		panel_4.add(btnViewCrimerInfo_1);
		
		JButton btnViewRegistrationFor = new JButton("view registration for FIR");
		btnViewRegistrationFor.setBounds(307, 195, 190, 54);
		panel_4.add(btnViewRegistrationFor);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExit.setBounds(307, 346, 190, 54);
		panel_4.add(btnExit);
		
		JButton btnRegistrationCrimer = new JButton("registration crimer");
		btnRegistrationCrimer.setBounds(307, 261, 190, 54);
		panel_4.add(btnRegistrationCrimer);
		
		JPanel panel_5 = new JPanel();
		contentpanel.add(panel_5, "panel5");
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("name");
		lblNewLabel_2.setBounds(39, 40, 70, 15);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("address");
		lblNewLabel_3.setBounds(39, 105, 70, 15);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblMrJhon = new JLabel("Mr Jhon");
		lblMrJhon.setBounds(140, 40, 70, 15);
		panel_5.add(lblMrJhon);
		
		JLabel lblDallas = new JLabel("Dallas");
		lblDallas.setBounds(140, 105, 70, 15);
		panel_5.add(lblDallas);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("/home/aditya/Desktop/crimer.jpg"));
		lblNewLabel_4.setBounds(234, 19, 332, 187);
		panel_5.add(lblNewLabel_4);
		
		JLabel label_2 = new JLabel("name");
		label_2.setBounds(39, 294, 70, 15);
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("address");
		label_3.setBounds(39, 359, 70, 15);
		panel_5.add(label_3);
		
		JLabel lblMrCena = new JLabel("Mr Cena");
		lblMrCena.setBounds(140, 294, 70, 15);
		panel_5.add(lblMrCena);
		
		JLabel lblHouston = new JLabel("houston");
		lblHouston.setBounds(140, 359, 70, 15);
		panel_5.add(lblHouston);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("/home/aditya/Desktop/crimer2.jpeg"));
		label_4.setBounds(234, 240, 332, 187);
		panel_5.add(label_4);
		
		JPanel panel_6 = new JPanel();
		contentpanel.add(panel_6, "panel6");
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentpanel,"panel1" );
			}
		});
		btnNewButton.setBounds(306, 150, 182, 68);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentpanel, "panel2");
			}
		});
		btnNewButton_1.setBounds(306, 259, 182, 68);
		panel.add(btnNewButton_1);
		panel_2.setLayout(null);
		
		txt1admin = new JTextField();
		txt1admin.setColumns(10);
		txt1admin.setBounds(371, 170, 173, 36);
		panel_2.add(txt1admin);
		
		JLabel label = new JLabel("Username");
		label.setBounds(252, 175, 91, 15);
		panel_2.add(label);
		
		txt2admin = new JPasswordField();
		txt2admin.setBounds(374, 251, 173, 46);
		panel_2.add(txt2admin);
		
		JLabel label_1 = new JLabel("password");
		label_1.setBounds(245, 259, 70, 15);
		panel_2.add(label_1);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName, password;
				userName = txt1admin.getText();
				password = txt2admin.getText();
				Database db = new Database();
				
				try {
					db.connect();
					String check = db.loginUser(userName, password);
					if (check == "Connected") {
						// new MainFrame();
						JOptionPane.showMessageDialog(null, "You have logged in successfully", "Success",
								JOptionPane.INFORMATION_MESSAGE);
								card.show(contentpanel, "panel3");
						db.disconnect();
					} else {
						JOptionPane.showMessageDialog(null, "Login failed!", "Failed!!", JOptionPane.ERROR_MESSAGE);

					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Problem in Connection");
				}
				
				
			}
		});
		button.setBounds(553, 334, 117, 46);
		panel_2.add(button);
		
		
	}
}
