/*
 * ICS2606 - Computer Programming 2
 * Final Academic Project
 * Alyza Paige L. Ng - 1CSA
 * May 30, 2022
 * 2nd Term 2021-2022
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.text.*;
import java.time.*;
import java.util.*;


public class FinalNaTalaga
{
	public static void main(String[] args)
	{
		Login l = new Login();
		l.startApp();
	}
}

class Login implements ActionListener
{
	// containers
	private JFrame f;
	private JPanel pUser, pPass, pButton;
	
	// components
	private JLabel lUser, lPass;
	private JTextField tfUser, tfPass;
	private JButton bLogin;
	
	private int attempt = 0; // default number of attempts
	
	public Login()
	{
		// containers
		f = new JFrame("Login Screen");
		
		pUser = new JPanel();
		pPass = new JPanel();
		pButton = new JPanel();
		
		// components
		lUser = new JLabel("Username: ");
		tfUser = new JTextField(15);
		lPass = new JLabel("Password: ");
		tfPass = new JPasswordField(15);
		
		bLogin = new JButton("Login");
	}
	
	public void startApp()
	{
		// frame
		f.setLayout(new GridLayout(3, 1));
		
		// panels
		pUser.add(lUser);
		pUser.add(tfUser);
		
		pPass.add(lPass);
		pPass.add(tfPass);
		
		pButton.add(bLogin);
		
		// grid
		f.add(pUser);
		f.add(pPass);
		f.add(pButton);
		
		// center
		f.setLocationRelativeTo(null);
		f.setBounds(500, 250, 300, 200); // x, y, width, length
		
		f.setVisible(true);
		
		// buttons
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bLogin.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Map<String, String> login = checkCredentials();
		boolean access = loginCheck(login, tfUser.getText(), tfPass.getText());
		if(!access) {
			attempt++; // increments the attempt
			if(attempt < 3)
				JOptionPane.showMessageDialog(null, "Incorrect Username / Password.", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				JOptionPane.showMessageDialog(null, "Sorry, you have reached the limit of 3 tries. Good bye!", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		} else {
			Record records = new Record();
			records.startApp(); // opens the "List of Records" window
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

class Record implements ActionListener
{
	// containers
	private JFrame f;
	private JPanel p1, p2, p3, p4, p5;
	
	// components
	private JTextArea ta;
	private JLabel lSort;
	private JComboBox<String> cbMenu;
	private String[] sMenu;
	private JRadioButton rbAscend, rbDescend;
	private JButton bAdd, bRemove, bExport;
	
	private LinkedList<Person> list;
	public Record()
	{
		list = new LinkedList<Person>();
		// containers
		f = new JFrame("List of Records");
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		// components
		ta = new JTextArea("\tNAME\tBIRTHDAY\tAGE\t", 400, 300);
		
		lSort = new JLabel("Sort by: ");
		sMenu = new String[] {"Name", "Birthday", "Age"};
		cbMenu = new JComboBox(sMenu);
		
		rbAscend = new JRadioButton(" Ascending ");
		//rbAscend.setSelected(true);
		rbDescend = new JRadioButton(" Descending ");
		
		bAdd= new JButton("Add a Record");
		bRemove = new JButton("Remove a Record");
		bExport = new JButton("Export to CSV File");
	}
	
	public void startApp()
	{
		// frame
		f.setLayout(new GridLayout(2, 1));
		f.setBounds(400, 125, 500, 400);
		
		// text area
		ta.setEditable(false);
		JScrollPane scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		// panels
		p1.add(scroll);
		
		p2.add(lSort);
		p2.add(cbMenu);
		
		p3.add(rbAscend);
		p3.add(rbDescend);
		ButtonGroup ascendDescend = new ButtonGroup();
		ascendDescend.add(rbAscend);
		ascendDescend.add(rbDescend);
		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
		
		p2.add(p3);
		
		p4.add(bAdd);
		p4.add(bRemove);
		p4.add(bExport);

		// grid
		f.add(p1);
		p5.add(p2);
		p5.add(p4);
		f.add(p5);
		
		// center
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		// buttons
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		rbAscend.addActionListener(this);
		rbDescend.addActionListener(this);
		
		bAdd.addActionListener(this);
		bRemove.addActionListener(this);
		bExport.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == rbAscend) {
			sortList(list, true);
			display();
		}
		else if(ae.getSource() == rbDescend) {
			sortList(list, false);
			display();
		}
		else ;
		
		if(ae.getSource() == bAdd) {
			Add a = new Add();
			a.startApp();
			a.transfer(list);
		} else if(ae.getSource() == bRemove) {
			//Remove r = new Remove();
			//r.startApp();
			// access LinkedList<Person> from Record
		} else if(ae.getSource() == bExport) {
			// export
		} else ;
	}
	
	public void windowGainedFocus(WindowEvent we)
	{
		ta.setText(null);
		display();
	}
	
	public void display()
	{	
		Format f = new SimpleDateFormat("MM/dd/yyyy");
		ta.setText("\tNAME\tBIRTHDAY\tAGE\t");
		
		for(int i = 0; i < list.size(); i++)
			ta.append("\n\t" + list.get(i).getName() + "\t" + list.get(i).getBirthDay() + "\t" + list.get(i).getAge() + "\t");
	}
	
	public void sortList(LinkedList<Person> list, boolean selectA)
	{
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = 0; j < (list.size() - i) - 1; j++) {
				Person present = list.get(j);
				Person next = list.get(j + 1);
				
				if(cbMenu.getSelectedItem().toString().equals("Name")) {
					int name = present.getName().compareToIgnoreCase(next.getName());
					if(selectA) {
						if(name > 0) Collections.swap(list, j, j + 1);
					} else
						if(name < 0) Collections.swap(list, j, j + 1);
				} else if(cbMenu.getSelectedItem().toString().equals("Birthday")) {
					boolean bday = present.getBirthDay().after(next.getBirthDay());
					if(selectA) {
						if(bday) Collections.swap(list, j, j + 1);
					} else
						if(!bday) Collections.swap(list, j, j + 1);
				} else if(cbMenu.getSelectedItem().toString().equals("Age")) {
					if(selectA) {
						if(present.getAge() > next.getAge()) Collections.swap(list, j, j + 1);
					} else
						if(present.getAge() < next.getAge()) Collections.swap(list, j, j + 1);
				} else ;
			}
		}
	}
}

class Add implements ActionListener
{
	// containers
	private JFrame f;
	private JPanel p1, p2, p3, p4, p5;
	
	// components
	private JLabel lName, lBirthday;
	private JTextField tfName;
	private JComboBox<String> cbMonth;
	private String[] month;
	private JComboBox<Integer> cbDay, cbYear;
	private JButton bSB, bSA, bB;
	
	private LinkedList<Person> list;
	
	public Add()
	{
		// containers
		f = new JFrame("Add Record");
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		// components
		lName = new JLabel("Name: ");
		tfName = new JTextField(35);
		
		lBirthday = new JLabel("Birthday: ");
		
		month = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		cbMonth = new JComboBox<>(month);
		
		cbDay = new JComboBox<Integer>();
		for(int i = 0; i < 31; i++)
			cbDay.addItem(i);
		
		
		cbYear = new JComboBox<Integer>();
		for(int i = 0; i < 2023 - 1900; i++)
			cbYear.addItem(i + 1900);
		
		
		bSB = new JButton("Save and Go Back");
		bSA = new JButton("Save and Add Another");
		bB = new JButton("Back");
	}
	
	public void startApp()
	{
		// frame
		f.setLayout(new GridLayout(3, 1));
		
		// panels
		p1.add(lName);
		p1.add(tfName);
		
		p2.add(lBirthday);
		p2.add(cbMonth);
		p2.add(cbDay);
		p2.add(cbYear);
		
		p3.add(bSB);
		p3.add(bSA);
		p3.add(bB);
		
		// grid
		f.add(p1);
		f.add(p2);
		f.add(p3);
		
		// center
		f.setLocationRelativeTo(null);
		f.setBounds(400, 250, 500, 250);
		f.setVisible(true);
		
		// buttons
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bSB.addActionListener(this);
		bSA.addActionListener(this);
		bB.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		int mm = cbMonth.getSelectedIndex();
		int dd = (int) cbDay.getSelectedItem();
		int yy = (int) cbYear.getSelectedItem();

		try {
			if(tfName.getText().equals("")){
				throw new IOException("Err");
			}
			if(verify(mm, dd, yy)) {
				Calendar cal = Calendar.getInstance();
				cal.set(yy, mm, dd);
				Person p = new Person(tfName.getText(), cal.getTime());
				list.add(p);
			}
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).getName().equalsIgnoreCase(tfName.getText())){
					throw new IllegalArgumentException("Err");
			}
			}
		} catch(IOException ioe) {
				reset();
				JOptionPane.showMessageDialog(null, "An IOException is caught. There is no name entered.", "Error", JOptionPane.ERROR_MESSAGE);
			} /*catch(IllegalArgumentException iae) {
			if(list.get(i).getName().equalsIgnoreCase(tfName.getText())) {
				reset();
				JOptionPane.showMessageDialog(null, "An IllegalArgumentException is caught. The name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				reset();
				JOptionPane.showMessageDialog(null, "An IllegalArgumentException is caught. The date does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
			}*/

			catch(IllegalArgumentException iae) {
				reset();
				JOptionPane.showMessageDialog(null, "An IllegalArgumentException is caught. The name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			finally {
			if(ae.getSource() == bSB) {
				reset();
				JOptionPane.showMessageDialog(null, "Input is added.", "Add Record", JOptionPane.INFORMATION_MESSAGE);
				f.setVisible(false); // hides frame
			} else if(ae.getSource() == bSA) {
				reset();
				JOptionPane.showMessageDialog(null, "Input is added.", "Add Record", JOptionPane.INFORMATION_MESSAGE);
			} else if(ae.getSource() == bB)
				f.setVisible(false);
			else ;
		}
		
		/*catch(IOException | IllegalArgumentException ex)
		{
			if(tfName.getText().equals(""))
				JOptionPane.showMessageDialog(null, "An IOException is caught. There is no name entered.", "Error", JOptionPane.ERROR_MESSAGE);
			else {
			String strIAE = if(list.get(i).getName().equalsIgnoreCase(tfName.getText())) ? "The name already exists." : "The date does not exist.";
			if(list.get(i).getName().equalsIgnoreCase(tfName.getText()))
				JOptionPane.showMessageDialog(null, "An IllegalArgumentException is caught. " + str, "Error", JOptionPane.ERROR_MESSAGE);
			}
			reset();
		}*/
	}
	
	// setter
	public void transfer(LinkedList<Person> list) { this.list = list; }
	
	// resets user inputs
	public void reset()
	{
		tfName.setText(null); // clears text field
		cbMonth.setSelectedIndex(0); // resets month combo box
		cbDay.setSelectedIndex(0); // resets day combo box
		cbYear.setSelectedIndex(0); // resets year combo box
	}
	
	// checks whether the given date is valid or not & if the name already exists
	public boolean verify(int month, int day, int year)
	{
		try {
				Calendar cal = Calendar.getInstance();
				cal.set(year, month, day);// sets cal from current date to birth date
			if(tfName.getText().equals("")) // empty text field
				throw new IOException("Err");
			if(cal.get(Calendar.MONTH) != month) // checks if it's a valid date
				throw new IllegalArgumentException();
			else if(cal.getTime().after(new Date())) // birthday cannot be after the current date
				throw new IllegalArgumentException();

			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getName().equalsIgnoreCase(tfName.getText()))
					throw new IOException();
			}
		}catch(IOException IOE){
			System.out.println("IOException");
		}

		
		return true;
	}
}

class Remove implements ActionListener
{
	// containers
	private JFrame f;
	private JPanel p1, p2;
	
	// components
	private JLabel lName;
	private JTextField tfName;
	private JButton bRGB, bSRA, bB;
	
	private LinkedList<Person> list;
	
	public Remove()
	{
		// containers
		f = new JFrame("Remove Record");
		
		p1 = new JPanel();
		p2 = new JPanel();
		
		// components
		lName = new JLabel("Name: ");
		tfName = new JTextField(35);
		
		bRGB = new JButton("Remove and Go Back");
		bSRA = new JButton("Save and Remove Another");
		bB = new JButton("Back");
	}
	
	public void startApp()
	{
		// frame
		f.setLayout(new GridLayout(2, 1));
		
		// panels
		p1.add(lName);
		p1.add(tfName);
		
		p2.add(bRGB);
		p2.add(bSRA);
		p2.add(bB);
		
		// grid
		f.setLocationRelativeTo(null);
		f.setBounds(400, 250, 500, 250);
		f.setVisible(true);
		
		// buttons
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bRGB.addActionListener(this);
		bSRA.addActionListener(this);
		bB.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try {
			if(tfName.getText().equals(""))
			{
				throw new IOException("Err");
			}
			if(ae.getSource() == bRGB) {
				remove();
				JOptionPane.showMessageDialog(null, "Input is removed.", "Remove Record", JOptionPane.INFORMATION_MESSAGE);
				f.setVisible(false); // hides frame
			} else if(ae.getSource() == bSRA) {
				remove();
				JOptionPane.showMessageDialog(null, "Input is removed.", "Remove Record", JOptionPane.INFORMATION_MESSAGE);
			} else if(ae.getSource() == bB) {
				f.setVisible(false);
			} else ;
		} catch(IOException ioe) {
			tfName.setText(null);
			JOptionPane.showMessageDialog(null, "An IOException is caught. There is no name entered.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch(IllegalArgumentException iae) {
			tfName.setText(null);
		}
		
		/*catch(IOException | IllegalArgumentException ex)
		{
			if(tfName.getText().equals(""))
				JOptionPane.showMessageDialog(null, "An IOException is caught. There is no name entered.", "Error", JOptionPane.ERROR_MESSAGE);
			tfName.setText(null);
		}*/
	}
	
	// setter
	public void transfer(LinkedList<Person> list) { this.list = list; }
	
	public void remove()
	{
		try{
			boolean found = false;
		
			if(tfName.getText().equals("")) // no name input
				throw new IOException("Err");
			for(int i = 0; i < list.size(); i++) {
				// name already exists
				if(list.get(i).getName().equalsIgnoreCase(tfName.getText())) {
					found = true;
					list.remove(i); // remove the object in the list
				}
			}	
			if(!found) // name already exists
				throw new IllegalArgumentException();
			}catch(IOException ioe)
				{
					System.out.println("IOException");
				}
				catch(IllegalArgumentException IAE){
					System.out.println("IllegalArgumentException");
				}
	}
}

class Person
{
	private String name;
	private Date birthDay;
	private int age, days, months, years;
	
	public Person() {}
	
	public Person(String name, Date birthDay)
	{
		this.name = name;
		this.birthDay = birthDay;
		this.age = computeAge(birthDay);
		this.days = 0;
		this.months = 0;
		this.years = 0;
	}

	public String getName() { return this.name; }
	
	public Date getBirthDay() { return this.birthDay; }
	
	public int getAge() { return this.age; }
	
	public int getDays() { return this.days; }
	
	public int getMonths() { return this.months; }
	
	public int getYears() { return this.years; }
	
	public int computeAge(Date birthDay)
	{	
		// birth day

		Calendar person_birthDay = Calendar.getInstance();
		person_birthDay.setTime(birthDay);
		
		// current day
		long now = System.currentTimeMillis();
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(now);
		
		// age
		int pAge = today.get(Calendar.YEAR) - person_birthDay.get(Calendar.YEAR);
		if((person_birthDay.get(Calendar.MONTH) > today.get(Calendar.MONTH)) || 
		(person_birthDay.get(Calendar.MONTH) == today.get(Calendar.MONTH) && person_birthDay.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)))
			pAge--;

		/*// years
		years = today.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
		
		int monthToday = today.get(Calendar.MONTH) + 1;
		int monthBirth = birthDay.get(Calendar.MONTH) + 1;
		
		// months
		months = monthToday - monthBirth;
		
		// if months is negative, then years - 1 and get months
		if(months < 0) {
			years--;
			months = 12 - monthBirth + monthToday;
			if(today.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
				months--;
		} else if(months == 0 && today.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
			years--;
			months = 11;
		}
		
		// days
		if(today.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
			days = today.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
		else if(today.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
			today.add(Calendar.MONTH, -1);
			days = today.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DATE) + today.get(Calendar.DAY_OF_MONTH);
		} else {
			days = 0;
			if(months == 12) {
				years++;
				months = 0;
			}
		}
		
		return years;*/
		return pAge;
	}
	
	public String toString() { 
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		return format.format(birthDay); }
}

class Export
{
	
}