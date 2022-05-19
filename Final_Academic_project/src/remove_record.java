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

	public remove_record(){
		main = new JPanel();

		frame_remove = new JFrame("Remove Record");
		frame_remove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		name_label = new JLabel("Name: ");
		name_input = new JTextField(20);
		remove_name = new JPanel();

		remove_back = new JButton("Remove and Go Back");
		save_remove = new JButton("Save & Remove");
		back = new JButton("Back");
		buttons = new JPanel();
	}

	public void startApp(){
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

		remove_back.addActionListener(this);
		save_remove.addActionListener(this);
		back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == back){
			frame_remove.dispose();
			List_Of_Records main_menu = new List_Of_Records();
			main_menu.startApp();
		}

		else if(e.getSource() == remove_back){
			System.out.println("Removed person!");
			System.out.println("Name: " + name_input.getText());
			System.out.println();
		}

		else if(e.getSource() == save_remove){
			System.out.println("Removed person!");
			System.out.println("Name: " + name_input.getText());
			System.out.println();
		}
	}
}