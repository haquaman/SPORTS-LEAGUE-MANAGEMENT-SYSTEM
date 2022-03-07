package screens;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import models.FootballLeague;
import models.User;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldUsername;
	private static LoginGUI frame;
	final FootballLeague lg;
	User user;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void updateSelectTeam(JButton [] btnArr,User user,JButton btnLogin) {
		
		for (int i = 0; i < lg.getTeams().size(); i++) {
			JButton btn=btnArr[i];
			int a=i;
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(!txtFieldUsername.getText().equals("")) {
						btnLogin.setEnabled(true);
					}
					btn.setContentAreaFilled(true);
					btn.setBackground(new Color(15,250,210));
					user.setTeam(lg.getTeams().get(a));
					for (int j = 0; j < btnArr.length; j++) {  // deselect other teams
						if(a!=j) {
							btnArr[j].setContentAreaFilled(false);
						}
					
					}

				}
			});
			btn.setBounds(700+(150*(i%4)), 47+((i/4)*150), 150, 150);
			btn.setBorderPainted(false);
			btn.setBorder(null);
			btn.setContentAreaFilled(false);
			
		}
	
		
	}
	public LoginGUI() throws IOException {

		
		lg = FootballLeague.getLeague();  // singleton design pattern
		lg.createAllTeams();
		lg.createFixture();

		// Creating components
		JLabel lblTitle = new JLabel("Sports League Managament System");
		JLabel lblSelectTeam = new JLabel("Select Team ->");
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		ImageIcon imgLogin = new ImageIcon("sportoto.png");
		JLabel lblImage = new JLabel(imgLogin);
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));

		user = new User();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1363, 868);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsername.setBounds(39, 66, 93, 26);
		contentPane.add(lblUsername);

		// txt field
		txtFieldUsername = new JTextField();
		txtFieldUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtFieldUsername.getText().equals("")) {
					btnLogin.setEnabled(false);
				} else {
					if(user.getTeam()!=null)
						btnLogin.setEnabled(true);
				}
				user.setUsername(txtFieldUsername.getText());
			}
		});
		txtFieldUsername.setBounds(142, 65, 208, 34);
		contentPane.add(txtFieldUsername);
		txtFieldUsername.setColumns(10);

		// login button
		btnLogin.setEnabled(false);
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					// Building league and creating teams, players.
					new MainGUI(lg, user);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);

			}
		});
		btnLogin.setBounds(442, 668, 199, 83);
		contentPane.add(btnLogin);

		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTitle.setBounds(29, 10, 294, 45);
		contentPane.add(lblTitle);

		
		lblSelectTeam.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSelectTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTeam.setBounds(533, 89, 162, 34);
		contentPane.add(lblSelectTeam);

		lblImage.setBounds(0, 124, 500, 500);
		contentPane.add(lblImage);
		
		JButton[] btnTeams=new JButton[lg.getTeams().size()];
		for (int i = 0; i < lg.getTeams().size(); i++) {
			btnTeams[i]=new JButton(lg.getTeams().get(i).getLittleImgIcon());
			contentPane.add(btnTeams[i]);
			
		}
		
		updateSelectTeam(btnTeams,user,btnLogin);
		 
		

	}
}
