import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login implements ActionListener
{
	private JFrame f;
	private JPanel bg, pUser, pPass, pButton;
	
	private JLabel lUser, lPass;
	private JTextField tfUser, tfPass;
	private JButton bLogin;
	
	private int attempt = 0; // default number of attempt
	
	public Login()
	{
		f = new JFrame("Login Screen");
		
		bg = new JPanel();
		
		pUser = new JPanel();
		pPass = new JPanel();
		pButton = new JPanel();
		
		lUser = new JLabel("Username: ");
		lPass = new JLabel("Password: ");
		
		tfUser = new JTextField(15);
		tfPass = new JPasswordField(15);
		
		bLogin = new JButton("Login");
	}
	
	public void startApp()
	{
		f.setLayout(new GridLayout(3, 1));
		bg.setBackground(Color.WHITE);
		
		pUser.add(lUser);
		pUser.add(tfUser);
		
		pPass.add(lPass);
		pPass.add(tfPass);
		
		pButton.add(bLogin);
		
		f.add(pUser);
		f.add(pPass);
		f.add(pButton);
		
		f.setLocationRelativeTo(null);
		f.setBounds(500, 250, 300, 200); // frame to center of screen
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bLogin.addActionListener(this); // button
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Map<String, String> login = checkCredentials();
		boolean access = loginCheck(login, tfUser.getText(), tfPass.getText());
		if(!access) {
			attempt++; // increments the attempt
			if(attempt < 3)
				JOptionPane.showMessageDialog(null, "Incorrect Username / Password.", "Error", JOptionPane.ERROR_MESSAGE);
			else
			{
				JOptionPane.showMessageDialog(null, "Sorry, you have reached the limit of 3 tries. Good bye!", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} else {
			Records records = new Records();
			records.startApp();
		}
		
	}
	
	// returns the Map of separated usernames and passwords
	public Map<String, String> checkCredentials()
	{
		Map<String, String> login = new HashMap<>();
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("loginCredentials.txt")); // reads the file
			String storage = ""; // for storing the usernames
			int counter = 1; // line number
			for(String str = br.readLine(); str != null; str = br.readLine(), counter++)
			{
				if(counter % 2 != 0) // odd number lines == usernames
					storage = str;
				else
					login.put(storage, str); // adds the username and password (respectively) in the HashMap
			}
		br.close();
		}
		catch(IOException ioe) {}
		return login;
	}
	
	// checks if the inputted texts are in the .txt file
	public boolean loginCheck(Map<String, String> login, String username, String password)
	{
		if(login.containsKey(username)) // checks if the HashMap contains the key
		{
			if(login.get(username).equals(password)) // compares the value (of key) to the inputted password
				return true;
			else
				return false;
		}
		else
			return false;
	}
}