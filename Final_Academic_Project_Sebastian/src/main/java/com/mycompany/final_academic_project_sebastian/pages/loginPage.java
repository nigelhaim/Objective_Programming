package com.mycompany.final_academic_project_sebastian;

import java.awt.*;
class loginPage {
    private Frame f; 
    private Panel loginPanelUser;
    private Panel loginPanelPass;
    private Panel loginPanelButton;

    private Label user;
    private Label pass;

    private TextField username;
    private TextField password; 
    private Button login;

    public loginPage()      
    {
        f = new Frame("Login Screen");
        
        loginPanelUser = new Panel();
        loginPanelPass = new Panel();
        loginPanelButton = new Panel();
        
        username = new TextField(20);
        password = new TextField(20);

        user = new Label("Username: ");
        pass = new Label("Password: ");

        login = new Button("Login");
    }

    public void startApp(){
        loginPanelUser.add(user);
        loginPanelUser.add(username);

        loginPanelPass.add(pass);
        loginPanelPass.add(password);

        loginPanelButton.add(login);
        f.setSize(700, 300);
        f.add(loginPanelButton);
        f.add(loginPanelUser);
        f.add(loginPanelPass);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
