package FinalAcademicProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.time.*;
import java.io.*;

public class AddRecord extends Records implements ActionListener
{
	// containers
	private JFrame f;
	private JPanel bg, p1, p2, p3, p4;
	
	// components
	private JLabel lName, lBirthday;
	private JTextField tfName;
	private JComboBox<String> cbMonth;
	private String[] month;
	private JComboBox<Integer> cbDay, cbYear;
	private JButton bSaveBack, bSaveAdd, bBack;
	
	// for input
	private LinkedHashMap<String, Integer> months = new LinkedHashMap<>();
	private LinkedList<Person> list = new LinkedList<>();
	
	private Person p;
	public AddRecord()
	{
		f = new JFrame("Add Record");
		
		bg = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		
		lName = new JLabel("Name: ");
		tfName = new JTextField(35);
		
		lBirthday = new JLabel("Birthday: ");
		
		// for day and year combo box size
		Integer[] day = new Integer[31], year = new Integer[2023 - 1900];
		
		// combo box for month
		month = new String[] {"January", "February", "March", "April", "May", "June",
		"July", "August", "September", "October", "November", "December"};
		cbMonth = new JComboBox<>(month);
		
		// for storing the month number in the record
		for(int i = 1; i <= 12; i++)
			months.put(month[i - 1], i); // e.g. January, 1
		
		// combo box for day
		for(int i = 0; i < day.length; i++)
			day[i] = i + 1;
		cbDay = new JComboBox<>(day);
		
		// combo box for year
		for(int i = 0; i < year.length; i++)
			year[i] = i + 1900;
		cbYear = new JComboBox<>(year);
		
		// buttons
		bSaveBack = new JButton("Save and Go Back");
		bSaveAdd = new JButton("Save and Add Another");
		bBack = new JButton("Back");
	}
	
	public void startApp()
	{
		f.setLayout(new GridLayout(3, 1));
		bg.setBackground(Color.WHITE);
		
		p1.add(lName);
		p1.add(tfName);
		
		p2.add(lBirthday);
		p2.add(cbMonth);
		p2.add(cbDay);
		p2.add(cbYear);
		
		p3.add(bSaveBack);
		p3.add(bSaveAdd);
		p3.add(bBack);
		
		f.add(p1);
		f.add(p2);
		f.add(p3);
		
		f.setLocationRelativeTo(null);
		f.setBounds(400, 250, 500, 250);
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bSaveBack.addActionListener(this);
		bSaveAdd.addActionListener(this);
		bBack.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{	
		int choiceMonth = convertStringInt((String) cbMonth.getSelectedItem());
		int choiceDay = (int) cbDay.getSelectedItem();
		int choiceYear = (int) cbYear.getSelectedItem();
		LocalDate bDay = LocalDate.of(choiceYear, choiceMonth, choiceDay);
		String name = tfName.getText();
		Date birthday = convertLocalDate(bDay);
		int age = calculateAge(bDay);
		if(ae.getSource() == bSaveBack) {
			try {
				p = checkInput(name, birthday, age);
				addPerson(p);
				//System.out.println(p);
				//return p;
				//list.add(p);
				f.dispose();
			} catch(IOException ioe) {
				JOptionPane.showMessageDialog(null, "An IOException is caught. There is no name entered.", "Error", JOptionPane.ERROR_MESSAGE);
			} catch(IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "An IllegalArgumentException is caught. The date does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(ae.getSource() == bSaveAdd) {
			try {
				p = checkInput(name, birthday, age);
				addPerson(p);
				//System.out.println(p);
				//return p;
				//list.add(p);
				tfName.setText(null);
				JOptionPane.showMessageDialog(null, "Input is added.", "Add Record", JOptionPane.INFORMATION_MESSAGE);
			} catch(IOException ioe) {
				JOptionPane.showMessageDialog(null, "An IOException is caught. There is no name entered.", "Error", JOptionPane.ERROR_MESSAGE);
			} catch(IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(null, "An IllegalArgumentException is caught. The date does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else if(ae.getSource() == bBack)
			f.setVisible(false);
		else;
	}
	
	/*public LinkedList<Person> getPerson()
	{
		return personInput;
	}*/
	// returns the value (int) of the key (String) of the months
	public int convertStringInt(String monthInput)
	{
		return months.get(monthInput);
	}
	
	public int calculateAge(LocalDate birthDate)
	{
		LocalDate today = LocalDate.now();
		return Period.between(birthDate, today).getYears();
	}
	
	public Date convertLocalDate(LocalDate birthDate)
	{
		return Date.from(birthDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	
	// try-catch blocks
	public Person checkInput(String name, Date birthday, int age) throws IOException, IllegalArgumentException
	{
		Date today = new Date();
		if(name.equals("")) // no name input
			throw new IOException();
		if(birthday.after(today)) // date is in the future
			throw new IllegalArgumentException();
		return new Person(name, birthday, age);
	}
}