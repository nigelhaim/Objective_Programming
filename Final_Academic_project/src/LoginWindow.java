import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class LoginWindow implements ActionListener{
    private JFrame f; 
    private JPanel loginPanel;
    private JPanel loginPanelUser;
    private JPanel loginPanelPass;

    private JLabel user;
    private JLabel pass;

    private JTextField username;
    private JTextField password;

    private String username_Value;
    
    private JButton login;

    private int login_attempt;
    public LoginWindow(){
        f = new JFrame("Login");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPanel = new JPanel();
        loginPanelUser = new JPanel();
        loginPanelPass = new JPanel();
        
        username = new JTextField(20);
        password = new JTextField(20);      

        user = new JLabel("Username: ");
        pass = new JLabel("Password:  ");

        login = new JButton("Login");
        login_attempt = 0;
    }

    public void startApp(){ 
  

        loginPanelUser.add(user);
        loginPanelUser.add(username);

        loginPanelPass.add(pass);
        loginPanelPass.add(password);

        loginPanel.add(loginPanelUser);
        loginPanel.add(loginPanelPass);

        loginPanel.add(login);

        f.add(loginPanel);
        f.setSize(310, 190); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        login.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e)
    {

        String user_Value = username.getText();
        String pass_Value = password.getText();
        try{
            if(username.getText().equals("") || password.getText().equals(""))
            {
                throw new IOException("Err");
            }

            boolean access = access(user_Value, pass_Value);

            if (access){
                System.out.println("Access Granted!");
                f.dispose();
                List_Of_Records main_App = new List_Of_Records();
                main_App.startApp();
            }
            else{
                System.out.println("Access Denied!");
                JOptionPane.showMessageDialog(f, "Incorrect Username / Password", "Error Screen", JOptionPane.INFORMATION_MESSAGE);
                login_attempt++;

                if(login_attempt > 2)
                {
                    JOptionPane.showMessageDialog(f, "Sorry, you have reached the limit of 3 tries, good bye!", "Error Screen", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            }
        }catch(IOException err){
            System.out.print(err.getMessage());
        }
    }

    public boolean access(String user_Value, String pass_Value) throws IOException{
        File userList = new File("userList.txt");

        boolean access = false;

        BufferedReader read = new BufferedReader(new FileReader(userList));
        String s;
                //Key   Value
        HashMap<String, String> users = new HashMap<String, String>();

        int user = 1;
        int pass = 2; 
        while((s = read.readLine()) != null){       
            String username = s;
            s = read.readLine();
            String password = s;

            users.put(username, password);
        }

        if(users.containsKey(user_Value)){
            String password_user = users.get(user_Value);
            if(password_user.equals(pass_Value)){
                access = true;
            }
        }
        else{
            access = false;
        }
        return access;
    }
}