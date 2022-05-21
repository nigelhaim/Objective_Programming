import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.time.*;
public class List_Of_Records implements ActionListener{
	private JFrame f_main;
	private JPanel header;
	private JPanel records;
	private JPanel buttons;
	private JPanel mainPanel;
	private JPanel sorter;

	private JLabel name;
	private JLabel birthday;
	private JLabel age;
	private JLabel sortBy;

	private JTextArea printer;

	private JButton add_record;
	private JButton sub_record;
	private JButton export_CSV;

	private JComboBox sort_selection;

	private JRadioButton asc;
	private JRadioButton des;


	private String[] selection = {"Name", "Birthday", "Age"};
	private person append_person;
	private ArrayList<person> database;
	
	public List_Of_Records(){

		database = new ArrayList<person>();

		f_main = new JFrame("List of records");
		f_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		header = new JPanel();
		records = new JPanel();
		buttons = new JPanel();
		mainPanel = new JPanel();
		sorter = new JPanel();

		printer = new JTextArea();
		printer.setEditable(false);

		name = new JLabel("NAME     ");
		birthday = new JLabel("     BIRTHDAY     ");
		age = new JLabel("     AGE");
		sortBy = new JLabel("Sort by: ");

		try{
			File dataBase = new File("database.txt");

			BufferedReader read = new BufferedReader(new FileReader(dataBase));
			String s;

			while((s = read.readLine()) != null)
			{
				append_person = setPersonValue(s);
				System.out.println("Append person\n" + append_person.getString());
				database.add(append_person);
			}
		}catch(IOException e){
			System.err.println("Invalid Database");
			System.exit(0);
		}

		for(int i = 0; i < database.size(); i++){
			String print = database.get(i).program_printer();
			printer.append(print + "\n");
		}

		add_record = new JButton("Add a \nRecord");
		sub_record = new JButton("Remove a \nRecord");
		export_CSV = new JButton("Export to \nCSV File");

		sort_selection = new JComboBox<String>(selection);

		asc = new JRadioButton("Ascending");
		des = new JRadioButton("Descending");
	}

	public void startApp(){
		header.add(name);
		header.add(birthday);
		header.add(age);

		records.add(printer);

		sorter.add(sortBy);
		sorter.add(sort_selection);
		sorter.add(asc);
		sorter.add(des);

		ButtonGroup group = new ButtonGroup();

		group.add(asc);
		group.add(des);

		buttons.add(add_record);
		buttons.add(sub_record);
		buttons.add(export_CSV);

		f_main.add(header);
		f_main.add(records);
		f_main.add(sorter);
		f_main.add(buttons);
		f_main.add(mainPanel);
		f_main.setSize(500, 500);
		f_main.setLayout(new GridLayout(5, 1)); 
		f_main.setLocationRelativeTo(null);
		f_main.setVisible(true);

		add_record.addActionListener(this);
		sub_record.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == add_record){
			f_main.dispose();
			add_record new_record = new add_record();
			new_record.startApp();
		}

		else if(e.getSource() == sub_record){
			f_main.dispose();
			remove_record subt_record = new remove_record();
			subt_record.startApp(database);
		}
	}

	public person setPersonValue(String s){
		
		String splitter[] = s.split(",");
		String name = splitter[0];
		LocalDate birthday = LocalDate.parse(splitter[1]);
		int age = Integer.parseInt(splitter[2]);
		person person = new person(name, birthday, age);
		return person;
	}
}
