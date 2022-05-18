import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class List_Of_Records implements ActionListener{
	private JFrame f_main;
	private JPanel header;
	private JPanel records;
	private JPanel buttons;
	private JPanel mainPanel;

	private JLabel name;
	private JLabel birthday;
	private JLabel age;

	private JTextArea printer;

	private JButton add_record;
	private JButton remove_record;
	private JButton export_CSV;

	public List_Of_Records(){
		f_main = new JFrame("List of records");
		f_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		header = new JPanel();
		records = new JPanel();
		buttons = new JPanel();
		mainPanel = new JPanel();

		printer = new JTextArea();
		printer.setEditable(false);

		name = new JLabel("NAME     ");
		birthday = new JLabel("     BIRTHDAY     ");
		age = new JLabel("     AGE");

		try{
			File dataBase = new File("database.txt");

			BufferedReader read = new BufferedReader(new FileReader(dataBase));
			String s;

			while((s = read.readLine()) != null)
			{
				printer.append(s + "\n");
			}
		}catch(IOException e){
			System.err.println("Invalid Data Base");
			System.exit(0);
		}


		add_record = new JButton("Add a \nRecord");
		remove_record = new JButton("Remove a \nRecord");
		export_CSV = new JButton("Export to \nCSV File");
	}

	public void startApp(){
		header.add(name);
		header.add(birthday);
		header.add(age);

		records.add(printer);

		buttons.add(add_record);
		buttons.add(remove_record);
		buttons.add(export_CSV);

		f_main.add(header);
		f_main.add(records);
		f_main.add(buttons);

		f_main.add(mainPanel);
		f_main.setSize(500, 500);
		f_main.setLayout(new GridLayout(5, 1)); 
		f_main.setLocationRelativeTo(null);
		f_main.setVisible(true);

		add_record.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == add_record){
			f_main.dispose();
			add_record new_record = new add_record();
			new_record.startApp();
		}
	}
}
