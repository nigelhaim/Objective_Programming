package FinalAcademicProject;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class List_Of_Records implements ActionListener{
	public JFrame f_main;
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
	private ArrayList<person> personList;
	
	private JScrollPane scroll;

	private DateTimeFormatter dateSlashFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public List_Of_Records(){

	}
	public List_Of_Records(ArrayList<person> personList){
		this.personList = personList;
		f_main = new JFrame("List of records");
		f_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		header = new JPanel();
		records = new JPanel();
		buttons = new JPanel();
		mainPanel = new JPanel();
		sorter = new JPanel();

		printer = new JTextArea(20, 40);
		printer.setEditable(false);
		//printer.setAlignment(TextArea.CENTER);

		name = new JLabel("NAME     ");
		birthday = new JLabel("     BIRTHDAY     ");
		age = new JLabel("     AGE");
		sortBy = new JLabel("Sort by: ");

		printer.setText(textAreaSet(personList));

		add_record = new JButton("Add a \nRecord");
		sub_record = new JButton("Remove a \nRecord");
		export_CSV = new JButton("Export to \nCSV File");

		sort_selection = new JComboBox<String>(selection);
		
		asc = new JRadioButton("Ascending");
		des = new JRadioButton("Descending");

		//scroll = new JScrollPane(printer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
		//f_main.add(scroll);
		f_main.setBounds(400, 150, 500, 400);
		f_main.setLayout(new GridLayout(5, 1)); 
		f_main.setLocationRelativeTo(null);
		f_main.setVisible(true);

		add_record.addActionListener(this);
		sub_record.addActionListener(this);
		export_CSV.addActionListener(this);
		sort_selection.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				sortBox(evt);
			}
		});
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == add_record){
			f_main.dispose();
			add_record add = new add_record(personList);
			add.startApp();
		}

		else if(e.getSource() == sub_record){
			f_main.dispose();
			remove_record subt_record = new remove_record(personList);
			subt_record.startApp();
		}
		else if(e.getSource() == export_CSV){
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
   			LocalDateTime now = LocalDateTime.now();  
   			String filename = (dtf.format(now));  
			try{
				PrintWriter pw = new PrintWriter(new File(filename + ".csv"));
				StringBuilder sb = new StringBuilder();

				sb.append("Name");
				sb.append(",");
				sb.append("Birthday");
				sb.append(",");
				sb.append("Age");
				sb.append("\n");
				
				for(person p : personList){
					String name = p.getName();
					String bday = p.getFormattedBday();
					String age = Integer.toString(p.getAge());

					sb.append(name);
					sb.append(",");
					sb.append(bday);
					sb.append(",");
					sb.append(age);
					sb.append("\n");
				}
				pw.write(sb.toString());
				pw.close();
				System.out.println("Exported to CSV file with file name: " + filename);
			}catch(Exception errUpload){

			}
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

	public void sortBox(ActionEvent evt){
		if(sort_selection.getSelectedItem().toString().equals("Name")){
			if(asc.isSelected()){
				for(person p : personList){
					System.out.println(p.getName());
				}
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return p1.getName().compareTo(p2.getName());
					}
				});
				for(person p : personList)
				{
					System.out.println(p.getName());
				}
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Ascending order by Name");
			}
			else if(des.isSelected()){
				for(person p : personList){
					System.out.println(p.getName());
				}
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return p2.getName().compareTo(p1.getName());
					}
				});
				for(person p : personList)
				{
					System.out.println(p.getName());
				}
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Descending order by Name");
			}
		}
		else if(sort_selection.getSelectedItem().toString().equals("Birthday")){
			if(asc.isSelected()){
				for(person p : personList){
					System.out.println(p.getBday());
				}
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return p1.getBday().compareTo(p2.getBday());
					}
				});
				for(person p : personList)
				{
					System.out.println(p.getBday());
				}
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Ascending order by Bday");
			}
			else if(des.isSelected()){
				for(person p : personList){
					System.out.println(p.getBday());
				}
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return p2.getBday().compareTo(p1.getBday());
					}
				});
				for(person p : personList)
				{
					System.out.println(p.getBday());
				}
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Descending order by Bday");
			}
		}
		else if(sort_selection.getSelectedItem().toString().equals("Age")){
			if(asc.isSelected()){
				for(person p : personList){
					System.out.println(p.getAge());
				}
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return Integer.compare(p1.getAge(), p2.getAge());
					}
				});
				for(person p : personList)
				{
					System.out.println(p.getAge());
				}
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Ascending order by Age");
			}
			else if(des.isSelected()){
				for(person p : personList){
					System.out.println(p.getAge());
				}
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return Integer.compare(p2.getAge(), p1.getAge());
					}
				});
				for(person p : personList)
				{
					System.out.println(p.getAge());
				}
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Descending order by Age");
			}
		}
	}

	public String textAreaSet(ArrayList<person> personList){
		String temp = "";
		for(int i = 0; i < personList.size(); i++){
			String print = personList.get(i).program_printer() + "\n";
			temp += print;
		}
		return temp;
	}
}