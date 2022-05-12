import java.io.*;
import javax.swing.*;
public class List_Of_Records{
	private JFrame f_main;
	private JPanel p_panel;

	public List_Of_Records(){
		f_main = new JFrame("List of records");
		f_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p_panel = new JPanel();
	}

	public void startApp(){
		f_main.add(p_panel);
		f_main.setSize(500, 500);
		f_main.setLocationRelativeTo(null);
		f_main.setVisible(true);
	}
}