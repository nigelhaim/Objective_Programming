import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class remove_record implements ActionListener{
	private JFrame frame_remove;

	private JPanel main;
	private JPanel remove_name;
	private JPanel buttons;

	private JLabel name_label;
	private JTextField name_input;

	private JButton remove_back;
	private JButton save_remove;
	private JButton back;

	private person append_person; 
	private ArrayList<person> database;		
	
	public remove_record(){
		main = new JPanel();

		frame_remove = new JFrame("Remove Record");
		frame_remove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		name_label = new JLabel("Name: ");
		name_input = new JTextField(20);
		remove_name = new JPanel();

		remove_back = new JButton("Remove and Go Back");
		save_remove = new JButton("Remove and remove another");
		back = new JButton("Back");
		buttons = new JPanel();
	}

	public void startApp(ArrayList<person> database){
		remove_name.add(name_label);
		remove_name.add(name_input);

		buttons.add(remove_back);
		buttons.add(save_remove);
		buttons.add(back);

		main.add(remove_name);
		main.add(buttons);

		frame_remove.add(main);
		frame_remove.setSize(400,190);
		frame_remove.setLocationRelativeTo(null);
		frame_remove.setVisible(true);

		this.database = database;

		remove_back.addActionListener(this);
		save_remove.addActionListener(this);
		back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		String input = name_input.getText();
		if(e.getSource() == back){
			frame_remove.dispose();
			List_Of_Records main_menu = new List_Of_Records();
			main_menu.startApp();
		}

		else if(e.getSource() == remove_back){
			try
			{
				if(!validateInput(input)){
					throw new IllegalArgumentException("Name Not Found!");
				}
				remove_person(input);
				System.out.println("Removed person!");
				System.out.println("Name: " + name_input.getText());	
			}catch(IllegalArgumentException err){
				JOptionPane.showMessageDialog(frame_remove, "An IllegalArgumentException Caught: Name Not Found!", "Error Screen", JOptionPane.PLAIN_MESSAGE);
				System.out.print("Name: " + input + " does not exist");
			}
			catch(Exception err){
				System.out.print("Err");
			}
			System.out.println();	
		}

		else if(e.getSource() == save_remove){
			try
			{
				if(!validateInput(input)){
					throw new IllegalArgumentException("Name Not Found!");
				}
				remove_person(input);
				System.out.println("Removed person!");
				System.out.println("Name: " + input);
			}catch(IllegalArgumentException err){
				JOptionPane.showMessageDialog(frame_remove, "An IllegalArgumentException Caught: " + err, "Error Screen", JOptionPane.PLAIN_MESSAGE);
				System.out.print("Name: " + input + " does not exist");
			}
			catch(Exception err){
				System.out.print("Err");
			}
			System.out.println();
		}
	}

	public void remove_person(String name) throws IOException{
		File new_database = new File ("database.txt");
		
		PrintWriter print = new PrintWriter(new FileWriter(new_database));
		for(int i = 0; i < database.size(); i++){
			if(!(database.get(i).getName().equals(name_input.getText()))){
				String data = database.get(i).getName() + "," + database.get(i).getBday() + "," + database.get(i).getAge();
				print.println(data);
			}
		}
		print.close();
		return;
	}

	public boolean validateInput(String name){
		boolean valid = false;
		for(int i = 0; i < database.size(); i++){
			if(database.get(i).equals(name)){
				valid = true;
			}
		}
		return valid;
	}
}