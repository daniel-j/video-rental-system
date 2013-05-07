package videoRentalHandlerGUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class GUILogin extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;
	
	private class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) // Executes when button pressed
		{
			String buttonText = e.getActionCommand();
			
			if(buttonText.equals("Log in"))
			{
				if(logIn() == true)
				{
					JOptionPane.showMessageDialog(null, "You have entered the system!");
					clearFields();
					//enterSystem();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong username or password");
					clearFields();
				}
			}
			
		}
	}
	
	private void clearFields() 
	{
		this.userNameField.setText("");
		this.passwordField.setText("");
		
	}
	
	private boolean logIn()
	{
		boolean loggedIn = false;
		
		String username = "user";
		char[] pass = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
		
		String userName = this.userNameField.getText();
		char[] password = this.passwordField.getPassword();
		
		if(userName.equals(username) && Arrays.equals(pass, password))
		{
			loggedIn = true;
		}
		
		return loggedIn;
	}
	
	private void enterSystem()
	{
		
	}
	
	public GUILogin() 
	{
		super();
		initiateInstanceVariables();
		configureFrame();
		createPanel();	
	}
	
	private void initiateInstanceVariables()
	{
		this.contentPane = this.getContentPane();
		this.contentPane.setLayout(new GridLayout(1, 2));
		this.userNameField = new JTextField();
		this.passwordField = new JPasswordField();
		
	}
	
	private void configureFrame()
	{
		this.setSize(800, 400);
		this.setTitle("Log In :: Video Rental System 1.0");
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createPanel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder("Log in"));
		
		this.userNameField.setSize(260, 50);
		this.userNameField.setBorder(BorderFactory.createTitledBorder("Enter username here"));
		this.userNameField.setLocation(20, 30);

		panel.add(userNameField);
		
		this.passwordField.setSize(260, 50);
		this.passwordField.setBorder(BorderFactory.createTitledBorder("Enter password here"));
		this.passwordField.setLocation(20, 120);

		panel.add(passwordField);
		
		addButton(panel);
		
		this.contentPane.add(panel);
	}
	
	private void addButton(JPanel thePanel)
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 3, 5, 5)); // 2 rows, 3 columns, 5 pixels in between
		
		String[] buttonTxt = {"Log in"};
		ButtonListener buttonListener = new ButtonListener();
		
		JButton button = new JButton(buttonTxt[0]);
		Dimension dim = button.getPreferredSize();
		buttonPanel.setSize(3*dim.width + 8, 2 * dim.height + 5);
		buttonPanel.setLocation(20,270);
		
		// Add all buttons to button panel
		for(String str: buttonTxt)
		{
			button = new JButton(str);
			buttonPanel.add(button);	
			// connect listener
			button.addActionListener(buttonListener);
		}
		thePanel.add(buttonPanel);
	}
	
	public static void main(String[] args) 
	{
		GUILogin gui = new GUILogin();
		gui.setVisible(true);

	}
	
}
