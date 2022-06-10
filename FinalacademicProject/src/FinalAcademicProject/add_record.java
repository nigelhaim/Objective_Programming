package FinalAcademicProject;

import java.io.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class add_record extends List_Of_Records implements ActionListener{
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

	private person new_person;

	private ArrayList<person> personList;

	private String[] months = new String[] {
								"January",
								"Febuary",
								"March",
								"April",
								"May",
								"June",
								"July",
								"August",
								"September",
								"October",
								"November",
								"December",};
	
	public add_record(ArrayList<person> personList){

		this.personList = personList;
		
		main = new JPanel();

		frame_add = new JFrame("Add Records");
		frame_add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		name = new JLabel("Name: ");
		name_input = new JTextField(20);
		add_name = new JPanel();

		bday = new JLabel("Birthday    ");
		month_select = new JComboBox(months);
		day_select = day_placer(31);
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
		save_Add.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		String new_name = name_input.getText();
		int buwan =  month_integer((String) month_select.getSelectedItem());
		int araw = (int) day_select.getSelectedItem();
		int taon = (int) year_select.getSelectedItem();

		if(e.getSource() == back){
			frame_add.dispose();
			List_Of_Records main_menu = new List_Of_Records(personList);
			main_menu.startApp();
		}

		else if(e.getSource() == save_Back){			
			try{
				LocalDate new_bday = LocalDate.of(taon, buwan, araw);
				LocalDate today = LocalDate.now();
				if(new_bday.isAfter(today)){
					throw new IllegalArgumentException("Date is on the future!");
				}
				new_person = new person(new_name, new_bday);
				personList.add(new_person);
			}catch(DateTimeException dte){
				JOptionPane.showMessageDialog(frame_add, "Invalid Date: " + dte, "Error Screen", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(IllegalArgumentException ebb){
				JOptionPane.showMessageDialog(frame_add, "Invalid Date: " + ebb, "Error Screen", JOptionPane.INFORMATION_MESSAGE);
			}
			System.out.println("Registered new person!");
			System.out.println(new_person.getString());
			System.out.println();	
			new List_Of_Records(personList);
			frame_add.dispose();
			List_Of_Records main_menu = new List_Of_Records(personList);
			main_menu.startApp();
		}

		else if(e.getSource() == save_Add){
			try{
				LocalDate new_bday = LocalDate.of(taon, buwan, araw);
				LocalDate today = LocalDate.now();
				if(new_bday.isAfter(today)){
					throw new IllegalArgumentException("Date is on the future!");
				}
				new_person = new person(new_name, new_bday);
				personList.add(new_person);
			}catch(DateTimeException dte){
				JOptionPane.showMessageDialog(frame_add, "Invalid Date: " + dte, "Error Screen", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(IllegalArgumentException ebb){
				JOptionPane.showMessageDialog(frame_add, "Invalid Date: " + ebb, "Error Screen", JOptionPane.INFORMATION_MESSAGE);
			}
			System.out.println("Registered new person!");
			System.out.println(new_person.getString());
			System.out.println();
			name_input.setText("");
			month_select.setSelectedIndex(0);
			day_select.setSelectedIndex(0);
			year_select.setSelectedIndex(0);
		}
	}
	public JComboBox day_placer(int length){
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

	public int month_integer(String month){
		int return_num = 0;
		switch(month){
			case "January":
				return_num = 1;
				break;
			case "Febuary":
				return_num = 2;
				break;
			case "March":
				return_num = 3;
				break;
			case "April":
				return_num = 4;
				break;
			case "May":
				return_num = 5;
				break;
			case "June":
				return_num = 6;
				break;
			case "July":
				return_num = 7;
				break;
			case "August":
				return_num = 8;
				break;
			case "September":
				return_num = 9;
				break;
			case "October":
				return_num = 10;
				break;
			case "November":
				return_num = 11;
				break;
			case "December":
				return_num = 12;
				break;
		}
		return return_num;		
	}
}