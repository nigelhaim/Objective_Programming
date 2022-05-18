import java.io.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class add_record implements ActionListener{
	private JFrame frame_add;
	private JPanel add_name; 
	private JPanel add_bday;
	private JPanel buttons;
	private JPanel main;

	private JLabel name;
	private JLabel bday;

	private JTextField name_input;

	private JComboBox month_select;
	private JComboBox day_select;
	private JComboBox year_select;

	private JButton save_Back;
	private JButton save_Add;
	private JButton back;
	
	public add_record(){

		main = new JPanel();

		frame_add = new JFrame("Add Records");
		frame_add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		name = new JLabel("Name: ");
		name_input = new JTextField(20);
		add_name = new JPanel();

		bday = new JLabel("Birthday    ");
		month_select = day_monthplacer(12);
		day_select = day_monthplacer(31);
		year_select = yearPlacer(Calendar.getInstance().get(Calendar.YEAR));
		add_bday = new JPanel();

		save_Back = new JButton("Save and Go Back");
		save_Add = new JButton("Save & Add Another");
		back = new JButton("Back");
		buttons = new JPanel();
	}

	public void startApp(){
		add_name.add(name);
		add_name.add(name_input);

		add_bday.add(bday);
		add_bday.add(month_select);
		add_bday.add(day_select);
		add_bday.add(year_select);

		buttons.add(save_Back);
		buttons.add(save_Add);
		buttons.add(back);

		main.add(add_name);
		main.add(add_bday);
		main.add(buttons);
		frame_add.add(main);
		frame_add.setSize(400,190);
		frame_add.setLocationRelativeTo(null);
		frame_add.setVisible(true);

		back.addActionListener(this);
		save_Back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == back){
			frame_add.dispose();
			List_Of_Records main_menu = new List_Of_Records();
			main_menu.startApp();
		}

		else if(e.getSource() == save_Back){
			System.out.println("Registered new person!");
			System.out.println("Name: " + name_input.getText());
			System.out.println("Birthday: " + month_select.getSelectedItem() + " | " + day_select.getSelectedItem() + " | " + year_select.getSelectedItem());
			System.out.println();
		}

		else if(e.getSource() == save_Back){
			System.out.println("Registered new person!");
			System.out.println("Name: " + name_input.getText());
			System.out.println("Birthday: " + month_select.getSelectedItem() + " | " + day_select.getSelectedItem() + " | " + year_select.getSelectedItem());
			System.out.println();
		}
	}
	public JComboBox day_monthplacer(int length){
		JComboBox time = new JComboBox<Integer>();
		for(int i = 1; i <= length; i++){
			time.addItem(i);
		}
		return time;
	}

	public JComboBox yearPlacer(int CurrentYear){
		JComboBox year = new JComboBox<Integer>();
		for(int i = 0; i < 100; i++){
			year.addItem(CurrentYear);
			CurrentYear--;
		}
		return year;
	}
}