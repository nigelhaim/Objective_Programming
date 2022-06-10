package FinalAcademicProject;
//Import 
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class LoginWindow implements ActionListener{
    //Initiates the elements of a frame
    private JFrame f; 
    private JPanel loginPanel;
    private JPanel loginPanelUser;
    private JPanel loginPanelPass;

    private JLabel user;
    private JLabel pass;

    private JTextField username;
    private JPasswordField password;

    private String username_Value;
    
    private JButton login;

    private int login_attempt;

    private ArrayList<person> personList;
    
    public LoginWindow(){
        
        personList = new ArrayList<person>();//Initiates the array of the whole program
        f = new JFrame("Login");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPanel = new JPanel();
        loginPanelUser = new JPanel();
        loginPanelPass = new JPanel();
        
        username = new JTextField(20);
        password = new JPasswordField(20);      

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
        f.setSize(330, 160); 
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        login.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e)
    {
        //Gets the user input 
        String user_Value = username.getText();
        String pass_Value = password.getText();
        try{
            //If the user does not input the user name throws IOException
            if(username.getText().equals("") || password.getText().equals("")){
                throw new IOException("Err");
            }

            boolean access = access(user_Value, pass_Value);//Calls the mathod to check if the user credentials is valid 

            //If it is ture then prints access granted in the system and creates the records and start app
            if (access){
                System.out.println("Access Granted!");
                f.dispose();
                List_Of_Records main_App = new List_Of_Records(personList);
                main_App.startApp();
            }
            else{//Else denied and when input the incorrect credentials for the 3rd time the system will exit
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
            JOptionPane.showMessageDialog(f, "Missing input credentials", "Error Screen", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //Method that checks for credetials
    public boolean access(String user_Value, String pass_Value) throws IOException{
        
        //Gets the userList.txt file for the data base of 
        File userList = new File("loginCredentials.txt");

        boolean access = false;
        //Reads the text file through its lines 
        BufferedReader read = new BufferedReader(new FileReader(userList));
        String s;
                //Key   Value
        HashMap<String, String> users = new HashMap<String, String>();//A collection for the credentials

        int user = 1;
        int pass = 2; 
        while((s = read.readLine()) != null){//Loops the text file      
            String username = s;
            s = read.readLine();
            String password = s;

            users.put(username, password);
        }

        if(users.containsKey(user_Value)){
            String password_user = users.get(user_Value);//gets the value from a given key 
            if(password_user.equals(pass_Value)){//Compares the input password with the corresponding value 
                access = true;
            }
        }
        else{
            access = false;
        }
        return access;
    }
}