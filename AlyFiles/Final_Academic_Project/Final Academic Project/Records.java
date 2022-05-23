import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Records implements ActionListener
{
	private JFrame f;
	private JPanel bg, p1, p2, p3, p4, p5;
	
	private JTextArea area;
	
	private JLabel lSortBy;
	private JComboBox<String> cbMenu;
	private String[] menu;
	
	private JRadioButton rbAscend, rbDescend;
	private JButton bAddRecord, bRemoveRecord, bExport;
	
	private ArrayList<Person> personInput;
	
	public Records()
	{
		f = new JFrame("List of Records");
		
		personInput = new ArrayList<Person>();
		bg = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		area = new JTextArea("\tNAME\t\tBIRTHDAY\t\tAGE\t");
		
		lSortBy = new JLabel("Sort by: ");
		menu = new String[] {"Name", "Birthday", "Age"};
		cbMenu = new JComboBox<>(menu);
		
		rbAscend = new JRadioButton(" Ascending ");
		rbDescend = new JRadioButton(" Descending ");
		
		bAddRecord = new JButton("Add a Record");
		bRemoveRecord = new JButton("Remove a Record");
		bExport = new JButton("Export to CSV File");
	}
	
	public void startApp()
	{
		f.setLayout(new GridLayout(2, 1));
		f.setBounds(400, 150, 500, 400); // frame to center of screen
		bg.setBackground(Color.WHITE);
		
		area.setEditable(false);
		JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		p1.add(scroll);
		
		p2.add(lSortBy);
		p2.add(cbMenu);
		
		p3.add(rbAscend);
		p3.add(rbDescend);
		ButtonGroup ascendDescend = new ButtonGroup();
		ascendDescend.add(rbAscend);
		ascendDescend.add(rbDescend);
		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
		
		p2.add(p3);
		
		p4.add(bAddRecord);
		p4.add(bRemoveRecord);
		p4.add(bExport);

		f.add(p1);
		p5.add(p2);
		p5.add(p4);
		f.add(p5);
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bAddRecord.addActionListener(this);
		bRemoveRecord.addActionListener(this);
		bExport.addActionListener(this);
	}
	
	/*public void sort(ActionEvent ae)
	{
		if(rbAscend.isSelected()) {
			if(cbMenu.getSelectedItem().toString().equals("Name")) {
				
			} else if(cbMenu.getSelectedItem().toString().equals("Birthday")) {
				
			} else if(cbMenu.getSelectedItem().toString().equals("Age")) {
				
			} else ;
		// comparator p1.compareTo(p2)
		} else if(rbDescend.isSelected()) {
			if(cbMenu.getSelectedItem().toString().equals("Name")) {
				
			} else if(cbMenu.getSelectedItem().toString().equals("Birthday")) {
				
			} else if(cbMenu.getSelectedItem().toString().equals("Age")) {
				
			} else ;
		// comparator p2.compareTo(p1)
		}
	}*/
	
	public void actionPerformed(ActionEvent ae)
	{	
		if(ae.getSource() == bAddRecord) {
			AddRecord addR = new AddRecord();
			addR.startApp();
		} else if(ae.getSource() == bRemoveRecord) {
			RemoveRecord removeR = new RemoveRecord();
			removeR.startApp();
		} else if(ae.getSource() == bExport) {
			System.out.println("*exports to a csv file*");
		} else ;
	}

	public void addPerson(Person p){
		System.out.println(p.getName());
		personInput.add(p);
		for(int i = 0; i < personInput.size(); i++){
			System.out.println(personInput.size());
			System.out.println(personInput.get(i).getName());
		}
	}
	
	/*public String updateTextArea(LinkedList<Person> record)
	{
		String input = "";
		for(int i = 0; i < record.size(); i++)
			input += record.get(i)./*sum method here*/ //+ "\n";
//return input;
	//}
}