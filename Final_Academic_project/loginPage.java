package Final_Academic_project;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.io.*;

public class loginPage implements java.awt.event.ActionListener{
    private JFrame f; 
    private JPanel loginPanel;
    private JPanel loginPanelUser;
    private JPanel loginPanelPass;

    private JLabel user;
    private JLabel pass;

    private JTextField username;
    private JTextField password;
    
    private JButton login;
    public loginPage(){
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPanel = new JPanel();
        loginPanelUser = new JPanel();
        loginPanelPass = new JPanel();
        
        username = new JTextField(20);        
        password = new JTextField(20);
       

        user = new JLabel("Username: ");
        pass = new JLabel("Password:  ");

        login = new JButton("Login");
    }

    public void startApp(){        
        loginPanelUser.add(user);
        loginPanelUser.add(username);

        loginPanelPass.add(pass);
        loginPanelPass.add(password);

        loginPanel.add(loginPanelUser);
        loginPanel.add(loginPanelPass);
        login.addActionListener(new loginPage());
        loginPanel.add(login);
        f.add(loginPanel);
        f.setSize(310, 190); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if()
    }
}
