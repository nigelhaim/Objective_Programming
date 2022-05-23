import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RemoveRecord
{
	private JFrame f;
	private JPanel bg, p1, p2;
	
	private JLabel lName;
	private JTextField tfName;
	private JButton bRemoveGo, bSaveRemove, bBack;
	
	public RemoveRecord()
	{
		f = new JFrame("Remove Record");
		
		bg = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		
		lName = new JLabel("Name: ");
		tfName = new JTextField(35);
		
		bRemoveGo = new JButton("Remove and Go Back");
		bSaveRemove = new JButton("Save and Remove Another");
		bBack = new JButton("Back");
	}
	
	public void startApp()
	{
		f.setLayout(new GridLayout(2, 1));
		bg.setBackground(Color.WHITE);
		
		p1.add(lName);
		p1.add(tfName);
		
		p2.add(bRemoveGo);
		p2.add(bSaveRemove);
		p2.add(bBack);
		
		f.add(p1);
		f.add(p2);
		
		f.setLocationRelativeTo(null);
		f.setBounds(400, 250, 500, 250);
		f.setVisible(true);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}