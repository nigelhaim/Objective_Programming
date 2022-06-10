package FinalAcademicProject;
//Import packages
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class List_Of_Records implements ActionListener{
	//Initiates the elements of the program
	public JFrame f_main;
	private JPanel header;
	private JPanel buttons;
	private JPanel main_panelbuttons;
	private JPanel sorter;
	private JPanel ascDes;
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

	//Creates the elements for the recordswindow
	public List_Of_Records(ArrayList<person> personList){
		
		this.personList = personList;//Initiates the returned array list everytime the window is called
		f_main = new JFrame("List of records");
		f_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		header = new JPanel();
		
		buttons = new JPanel();
		
		main_panelbuttons = new JPanel();
		
		sorter = new JPanel();

		ascDes = new JPanel();

		//Sets the text area of to show the Information of different persons 
		printer = new JTextArea(10, 35);
		printer.setEditable(false);
		printer.setBackground(Color.decode("#f2f2f2"));

		sortBy = new JLabel("Sort by: ");

		printer.setText(textAreaSet(personList));//Calls the printer method 

		add_record = new JButton("Add a \nRecord");
		sub_record = new JButton("Remove a \nRecord");
		export_CSV = new JButton("Export to \nCSV File");

		sort_selection = new JComboBox<String>(selection);
		
		asc = new JRadioButton("Ascending");
		des = new JRadioButton("Descending");
		scroll = new JScrollPane(printer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}

	public void startApp(){

		main_panelbuttons.setLayout(new GridLayout(2, 1));

		f_main.setBounds(400, 150, 500, 400);
		f_main.setLayout(new GridLayout(2, 1)); 
		f_main.setLocationRelativeTo(null);
		f_main.setVisible(true);

		header.add(scroll);

		sorter.add(sortBy);
		sorter.add(sort_selection);

		sorter.add(ascDes);

		ButtonGroup group = new ButtonGroup();
		
		group.add(asc);
		group.add(des);
		ascDes.add(asc);
		ascDes.add(des);
		ascDes.setLayout(new BoxLayout(ascDes, BoxLayout.Y_AXIS));

		main_panelbuttons.add(sorter);
		main_panelbuttons.add(buttons);

		f_main.add(header);
		f_main.add(main_panelbuttons);

		buttons.add(add_record);
		buttons.add(sub_record);
		buttons.add(export_CSV);

		add_record.addActionListener(this);
		sub_record.addActionListener(this);
		export_CSV.addActionListener(this);
		//Separate action listener for sorting the person
		sort_selection.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				sortBox(evt);
			}
		});
	}
	public void actionPerformed(ActionEvent e)
	{
		//Calls to add a new person
		if(e.getSource() == add_record){
			f_main.dispose();
			add_record add = new add_record(personList);
			add.startApp();
		}
		//Calls to remove a person
		else if(e.getSource() == sub_record){
			f_main.dispose();
			remove_record subt_record = new remove_record(personList);
			subt_record.startApp();
		}
		//Calls to export a csv file 
		else if(e.getSource() == export_CSV){
			//Formats the file name of the csv file 
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
   			LocalDateTime now = LocalDateTime.now(); //Gets teh current date and time 
   			String filename = (dtf.format(now)); 
			try{//Prints the file name 
				PrintWriter pw = new PrintWriter(new File(filename + ".csv"));
				StringBuilder sb = new StringBuilder();
				//Appends the header of the csv file 
				sb.append("Name");
				sb.append(",");
				sb.append("Birthday");
				sb.append(",");
				sb.append("Age");
				sb.append("\n");
				
				//Loops the ArrayList every name, birthday, and age
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
	//Action event that sorts the persons based on the input of the user 
	public void sortBox(ActionEvent evt){
		//If sorted by name
		if(sort_selection.getSelectedItem().toString().equals("Name")){
			//Sorts ascending by name
			if(asc.isSelected()){
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return p1.getName().compareTo(p2.getName());
					}
				});
				//Prints in the command prompt of the sorted persons
				for(person p : personList){
					System.out.println(p.getName());
				}
				//Sends back to the text area of the sorted persons based on name
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Ascending order by Name");
			}
			//Same proccess but descending 
			else if(des.isSelected()){
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
		//If sort by birthday
		else if(sort_selection.getSelectedItem().toString().equals("Birthday")){
			//Sorts ascending by birthday 
			if(asc.isSelected()){
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return p1.getBday().compareTo(p2.getBday());
					}
				});
				//Prints the sorted ArrayList
				for(person p : personList){
					System.out.println(p.getBday());
				}
				//Sets the sorted persons in the text area 
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Ascending order by Bday");
			}
			//Same process but descending 
			else if(des.isSelected()){
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return p2.getBday().compareTo(p1.getBday());
					}
				});
				for(person p : personList){
					System.out.println(p.getBday());
				}
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Descending order by Bday");
			}
		}
		//If sort is by age 
		else if(sort_selection.getSelectedItem().toString().equals("Age")){
			//Sorts ascending by age
			if(asc.isSelected()){
				System.out.println();
				Collections.sort(personList, new Comparator<person>(){
					public int compare(person p1, person p2){
						return Integer.compare(p1.getAge(), p2.getAge());
					}
				});
				for(person p : personList){
					System.out.println(p.getAge());
				} 
				//Returns the new sorted arrayList 
				printer.setText(textAreaSet(personList));
				System.out.println("Sorted in Ascending order by Age");
			}
			//Same process but in descending 
			else if(des.isSelected()){
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
	//prints the array list in the text area based on sort, add, and remove
	public String textAreaSet(ArrayList<person> personList){
		String temp = " \tNAME\tBIRTHDAY\tAGE\n";
		for(int i = 0; i < personList.size(); i++){
			String print = personList.get(i).program_printer() + "\n";
			temp += print;
		}
		return temp;
	}
}