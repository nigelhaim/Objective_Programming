import java.io.*;
import java.util.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import javax.swing.*;

public class FinalAcademicProject 
{
    //creating HashMap with String for keys and values named map
    static HashMap<String, String> map = new HashMap<>();
    //creating a userInterface object named frame
    static userInterface frame = new userInterface();
    
    //a getter for the HashMap
    public HashMap<String, String> getMap()
    {
        return map;
    }

    public static void main(String args[]) throws IOException
    {   
        //creating File object userList passing the args[0] value (file name of txt file)
        File loginCredentials = new File("loginCredentials.txt");

        //accessing lines of userList object using BufferedReader passing
        //FileReader that passes the File Object
        BufferedReader br = new BufferedReader(new FileReader(loginCredentials));

        String username;
        String password;

        //while loop to continue accessing the line of file until the next line is null
        //storing the br.readLine() that contains the username to String username
        while((username = br.readLine()) != null)
        {
            //storing the next br.readLine() that contains the password to String password
            password = br.readLine();
            //adding the element of the HashMap using .put passing username and password (username=password)
            map.put(username, password);
        }

        //calling constructor and start up methods on frame
        frame.loginStartUp();
        frame.recordsListStartUp();
        frame.addStartUp();
        frame.removeStartUp();

        br.close();
    }
}

//class userInterface containing all objects for the gui
class userInterface extends WindowAdapter  //extending WindowAdapter for the close button
{
    //declaring all private objects to be used
    
    //ArrayList that will contain Person objects
    private static ArrayList<Person> person = new ArrayList<>();
    
    private static HashMap<String, Person> nameMap = new HashMap<>();
    
    private static StringBuilder forExport = new StringBuilder();
    
    private static int ctr = 0;
    
    private boolean lettersOnly = true;

    private JFrame loginScreen, listOfRecords, addRecords, removeRecords;

    private JPanel loginP1, halfP, loginP2, loginP3, 
            listP1, listP2, listP3, orderP, 
            addP1, addP2, addP3, bdayP, monthP, dayP, yearP,
            removeP1, removeP2 ;

    private JButton loginB, addRecordB, removeRecordB, exportB,
    backB, saveBackB, saveAddB, removeBackB, saveRemoveB, backB2;
    
    private JRadioButton ascend, descend;
    
    private JComboBox<String> sort, month, day, year;
    
    private String[] sortBy,monthValues, dayValues, yearValues;
    
    private JTextArea records;

    private JLabel userL, passL, sortL, nameL, bdayL, monthL, dayL, yearL, nameL2;

    private JTextField userTF, passTF, nameTF, nameTF2;
    
    //creating a FinalAcademicProject x so we can use the getMap()
    FinalAcademicProject x = new FinalAcademicProject();
    
    //method for the close button to display logout screen
    public void windowClosing(WindowEvent we)
    {
        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f,"Logging out...","Logout Screen",JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }
    
    //constructor to initialize all components
    public userInterface()
    {
        //all JFrames
        loginScreen = new JFrame("Login Screen");
        listOfRecords = new JFrame("List of Records");
        addRecords = new JFrame("Add Record");
        removeRecords = new JFrame("Remove Record");
        
        //loginScreen components
        loginP1 = new JPanel();
        loginP2 = new JPanel();
        loginP3 = new JPanel();
        loginB = new JButton("    Login    ");
        userL = new JLabel("Username:");
        passL = new JLabel("Password:");
        userTF = new JTextField("", 20);
        passTF = new JTextField("", 20);

        //listOfRecords components
        listP1 = new JPanel();
        listP2 = new JPanel();
        listP3 = new JPanel();
        orderP = new JPanel();
        halfP = new JPanel();
        //set the default text in TextArea and set its size
        records = new JTextArea("\tNAME\tBIRTHDAY\tAGE\t", 10, 35);//rows columns
        
        sortL = new JLabel("Sort by:");
        sortBy = new String[]{"Name", "Birthday", "Age"};
        sort = new JComboBox<>(sortBy);
        
        ascend = new JRadioButton(" Ascending ");
        descend = new JRadioButton(" Descending ");
        
        addRecordB = new JButton("Add a Record");
        removeRecordB = new JButton("Remove a Record");
        exportB = new JButton("Export to CSV File");
        
        //addRecords components
        addP1 = new JPanel();
        addP2 = new JPanel();
        addP3 = new JPanel();
        bdayP = new JPanel();
        monthP = new JPanel();
        dayP = new JPanel();
        yearP = new JPanel();
        
        nameTF = new JTextField("", 20);
        
        nameL = new JLabel("Name:");
        bdayL = new JLabel("Birthday:");
        monthL= new JLabel("mm");
        dayL = new JLabel("dd");
        yearL = new JLabel("yyyy");
        //for the month values in mm format
        monthValues = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11" , "12"};
        month = new JComboBox<>(monthValues);
        
        //for the days in dd format
        dayValues = new String[31];
        //for loop to add 1-31 to dayValues[]
        for(int i = 0, d = 1; i < dayValues.length; i++, d++)
        {
            String temp;
            //if d is 1-9 add a 0 at the start to make it in dd format
            if(d < 10)
            {
                temp = "0" + String.valueOf(d);
                dayValues[i] = temp;
            }
            else
            {
                dayValues[i] = String.valueOf(d);
            }     
        }
        day = new JComboBox<>(dayValues);
        
        //for the years in yyyy format
        yearValues = new String[123];
        //for loop to add 1900-2022 to yearValues
        for(int i = 0, d = 1900; i < yearValues.length; i++, d++)
        {
           yearValues[i] = String.valueOf(d);
                
        }
        year = new JComboBox<>(yearValues);       
        
        saveBackB = new JButton("Save and Go Back");
        saveAddB = new JButton("Save & Add Another");
        backB = new JButton("    Back    ");
        
        //remove record components
        removeP1 = new JPanel();
        removeP2 = new JPanel();
        
        nameL2 = new JLabel("Name:");
        nameTF2 = new JTextField("", 20);
        
        removeBackB = new JButton("Remove and Go Back");
        saveRemoveB = new JButton("Save & Remove");
        backB2 = new JButton("    Back    ");

    }
    
    //start up method for loginScreen starUp
    public void loginStartUp()
    {
        //adding components to panels
        loginP1.add(userL);
        loginP1.add(userTF);
        loginP2.add(passL);
        loginP2.add(passTF);
        loginP3.add(loginB);

        //setting layout
        loginScreen.setLayout(new GridLayout(3,1));

        //adding panels to frame
        loginScreen.add(loginP1);
        loginScreen.add(loginP2);
        loginScreen.add(loginP3);

        //setting size to pack panels, set location relative to null to center the window, and set visibility to true
        loginScreen.pack();
        loginScreen.setLocationRelativeTo(null);
        loginScreen.setVisible(true);
        
        //adding the close button windowListerner method
        loginScreen.addWindowListener(this);

        //using an anonymous ActionListner for loginB
        loginB.addActionListener(
                                e ->{
                                        //using getMap() on x to return the HashMap from the class FinalAcademicProject
                                        HashMap<String, String> map = x.getMap();
                                    
                                        //storing values in JTextFields
                                        String username = userTF.getText();
                                        String password = passTF.getText();

                                        //checking if the username and password inputed match in the HashMap
                                        if(password.equals(map.get(username)))
                                        {
                                            //if yes go to phase 2, by setting visibility of loginB to false
                                            //and listOfRecords to false
                                            loginScreen.setVisible(false);
                                            listOfRecords.setVisible(true);
                                        }
                                        else
                                        {
                                            //else increment counter
                                            ctr++;
                                            JFrame f = new JFrame();
                                            
                                            //if ctr < 3
                                            if(ctr < 3)
                                            {
                                                //show error message
                                                JOptionPane.showMessageDialog(f,"Incorrect Username/ Password","Error Screen",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                            {
                                                //if ctr reaches 3, error message and exit program
                                                JOptionPane.showMessageDialog(f,"Sorry, you have reached the limit of 3 tries, goodbye!","Error Screen",JOptionPane.ERROR_MESSAGE);
                                                System.exit(0);
                                            }
                                        }
                                    }
                                );
    }
    
    //method for listOfRecords start up
    public void recordsListStartUp() throws IOException
    {
        //setting if TextArea records in editable to false
        records.setEditable(false);
        //adding a vertical scroll bar on the TextArea
        JScrollPane scroll = new JScrollPane(records, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        //adding to listP1
        listP1.add(scroll);
        
        //adding components to listP2
        listP2.add(sortL);
        listP2.add(sort);
        
        //adding to panels and setting layout for the ascend and descned JRadioButton
        orderP.add(ascend);
        orderP.add(descend);
        ButtonGroup order = new ButtonGroup();
        order.add(ascend);
        order.add(descend);
        orderP.setLayout(new BoxLayout(orderP, BoxLayout.Y_AXIS));
        
        //adding orderP to listP2
        listP2.add(orderP);
        
        //adding the buttons to listP3
        listP3.add(addRecordB);
        listP3.add(removeRecordB);
        listP3.add(exportB);
        
        //setting the layout of the frame 
        listOfRecords.setLayout(new GridLayout(2,1));
        
        //adding listP1 to frame
        listOfRecords.add(listP1);
        //adding listP2 and listP3 to halfP
        halfP.add(listP2);
        halfP.add(listP3);
        //adding halfP to frame
        listOfRecords.add(halfP);
        
        //setting size and centering the window
        listOfRecords.setSize(450, 400);
        listOfRecords.setLocationRelativeTo(null);
        
        //adding window listener for close button
        listOfRecords.addWindowListener(this);
        
        //adding anonymous action listeners to JRadioButton ascend, descend , and JComboBox sort 
        //which calls the method displayRecord()
        ascend.addActionListener(e-> {displayRecord();});
        descend.addActionListener(e-> {displayRecord();});
        sort.addActionListener(e-> {displayRecord();});
        
        //anonymous action listener for addRecordB that makes listOfRecords not visible and addRecords visibile
        addRecordB.addActionListener(e->{
                                            listOfRecords.setVisible(false);  
                                            addRecords.setVisible(true);
                                        });
        //anonymous action listener for removeRecordB that makes listOfRecords not visible and addRecords visibile
        removeRecordB.addActionListener(e-> {
                                                listOfRecords.setVisible(false);  
                                                removeRecords.setVisible(true);
                                            });
        //anonymous action listener for exportB
        exportB.addActionListener(e-> {
                                            //if statement to check if person<> is not empty
                                            if(!person.isEmpty())
                                            {
                                                //call displayRecords to update forExport
                                                displayRecord();
                                                
                                                //creating Format and Date objects for the .csv file name
                                                Format dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); 
                                                Date date = new Date();  
                                                
                                                //creating File object passing the file name dateFormat.format(date) with file extension .csv
                                                File export = new File(dateFormat.format(date) + ".csv");
                                                
                                                //try-catch for the IOException
                                                try(PrintWriter output = new PrintWriter(new FileWriter(export)))
                                                {
                                                    //print forExport.toString() on output
                                                    output.println(forExport.toString());
                                                    output.close();
                                                }
                                                catch(IOException ioe)
                                                {

                                                }
                                                
                                                //show a message that file has been exported
                                                JFrame f = new JFrame();
                                                JOptionPane.showMessageDialog(null, "Exported as CSV file! \nFile name: " + dateFormat.format(date) + ".csv", "Export Screen", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                            else
                                            {
                                                //else, meaning there is no record or forExport has no entries, show warnign screen
                                                JFrame f = new JFrame();
                                                JOptionPane.showMessageDialog(f,"There is no existing record!","Warning Screen",JOptionPane.WARNING_MESSAGE);
                                            }
                                        });
        
    }
    
    //method to print on the TextArea at listOfRecords frame and append on forExport
    public void displayRecord()
    {
        //setting the length of forExport to 0 to remove its contents
        forExport.setLength(0);
        
        //creating the arraylists for the different sorting: names, dates, ages
        ArrayList<String> names = new ArrayList<>();
        
        ArrayList<HashMap> dateArray = new ArrayList<>();
        ArrayList<Date> dates = new ArrayList<>();
        
        ArrayList<HashMap> ageArray = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        
        //if statement to check if person<> is not empty
        if(!person.isEmpty())
        {
            //Format object to format Date to required format
            Format f = new SimpleDateFormat("MM/dd/yyyy");
            //setting the text in TextArea records to reset it to its headers
            records.setText("\tNAME\tBIRTHDAY\tAGE\t");
            
            //for loop for the name sorting
            for(int i = 0; i < person.size(); i++)
            {
                //puting Person person.get(i).getName() as key, and person.get(i) as the value to nameMap<>
                nameMap.put(person.get(i).getName(), person.get(i));
                //adding person.get(i).getName() on names<>
                names.add(person.get(i).getName());
            }
            
            //for loop for date sorting
            for(int i = 0; i < person.size(); i++)
            {
                //creating a HashMap<> temp that stores Date for keys and Person objects for value
                HashMap<Date, Person> tempMap = new HashMap<>();
                //putting person.get(i).getBirthDay() for key, and person.get(i) for value
                tempMap.put(person.get(i).getBirthDay(), person.get(i));
                //adding the HashMap tempMap to dateArray<>
                dateArray.add(tempMap);
                //adding person.get(i).getBirthDay() to dates<>
                dates.add(person.get(i).getBirthDay());
            }
            
            //for loop for age sorting
            for(int i = 0; i < person.size(); i++)
            {
                //creating a HashMap<> temp that stores Integer for keys and Person objects for value
                HashMap<Integer, Person> tempMap = new HashMap<>();
                //putting person.get(i).computeAge(person.get(i).getBirthDay()) as key, and person.get(i) for value
                tempMap.put(person.get(i).computeAge(person.get(i).getBirthDay()), person.get(i));
                //adding the HashMap tempMap<> to ageArray<>
                ageArray.add(tempMap);
                //adding person.get(i).computeAge(person.get(i).getBirthDay()) to ages<>
                ages.add(person.get(i).computeAge(person.get(i).getBirthDay()));
            }
            
            //sorting names<>, dates<>, and ages<>
            Collections.sort(names);
            Collections.sort(dates);
            Collections.sort(ages);

            //if statement to check if JRadioButton ascend is selected
            if(ascend.isSelected())
            {
                //switch case checking if sort.getSelectedIndex() is 0 for name sort, 1 for birthday sort, or 2 for age sort
                switch (sort.getSelectedIndex()) {
                    case 0:
                        //for loop to traverse person<>
                        for(int i = 0; i < person.size(); i++)
                        {
                            //concatinating and storing \n\tNAME\tBIRTHDAY\tAGE to String temporary
                            //using the arrangement in names<> since it has been sorted
                            String temporary = "\n\t" + names.get(i)
                                    //using the key names.get(i), to get the value Person object from nameMap<> and calling getBirthday() to get the BIRTHDAY at proper format
                                    + "\t" + f.format(nameMap.get(names.get(i)).getBirthDay())
                                    //getting the BIRTHDAY again and passing it to computeAge() to get the AGE
                                    + "\t" + nameMap.get(names.get(i)).computeAge(nameMap.get(names.get(i)).getBirthDay());
                            
                            //appending temporary to records TextArea
                            records.append(temporary);
                            
                            //appending NAME,BIRTHDAY,AGE\n to StringBuilder forExport
                            forExport.append(names.get(i)).append(",").append(f.format(nameMap.get(names.get(i)).getBirthDay())).append(",").append(nameMap.get(names.get(i)).computeAge(nameMap.get(names.get(i)).getBirthDay())).append("\n");
                        }   
                        break;
                    case 1:
                        //for loop to traverse person<>
                        for(int i = 0; i < person.size(); i++)
                        {
                            //creating a HashMap temporay with Dates for keys, and Person for values
                            HashMap<Date, Person> temporary;
                            
                            //inner for loop to traverse dateArray
                            for(int j = 0; j < dateArray.size();j++)
                            {
                                //for loop to find the HashMap in dateArray that has the key dates.get(i)
                                if(dateArray.get(j).containsKey(dates.get(i)))
                                {
                                    //the HashMap with the key dates.get(i) has been found stored to temporary<>
                                    temporary = dateArray.get(j); 
                                    //deleting the specified HashMap from dateArray
                                    //this is so we can look for other HashMaps that may possibly contains the same Date keys (people with same Birthday)
                                    dateArray.remove(j);
                                    
                                    //concatinating and storing \n\tNAME\tBIRTHDAY\tAGE to String temporary
                                    //using dates.get(i) as key for temporary HashMap to get the value which is a Person object
                                    //calling .getName() to get the NAME
                                    String temp = "\n\t" + temporary.get(dates.get(i)).getName() +
                                                //calling .getBirthday() to get the BIRTHDAY
                                                "\t" + f.format(temporary.get(dates.get(i)).getBirthDay()) +
                                                //calling .computeAge() passng the BIRTHDAY to get the AGE
                                                "\t" + temporary.get(dates.get(i)).computeAge(temporary.get(dates.get(i)).getBirthDay());
                                    
                                    //appending temporary to records TextArea
                                    records.append(temp);
                                    
                                    //appending NAME,BIRTHDAY,AGE\n to StringBuilder forExport
                                    forExport.append(temporary.get(dates.get(i)).getName()).append(",").append(f.format(temporary.get(dates.get(i)).getBirthDay())).append(",").append(temporary.get(dates.get(i)).computeAge(temporary.get(dates.get(i)).getBirthDay())).append("\n");
                                }
                            } 
                            
                        }
                        break;
                    case 2:
                        for(int i = 0; i < person.size(); i++)
                        {
                            //creating a HashMap temporay with Integer for keys, and Person for values
                            HashMap<Integer, Person> temporary;
                            
                            //inner for loop to traverse ageArray
                            for(int j = 0; j < ageArray.size();j++)
                            {
                                //for loop to find the HashMap in ageArray that has the key ages.get(i)
                                if(ageArray.get(j).containsKey(ages.get(i)))
                                {
                                    //the HashMap with the key ages.get(i) has been found stored to temporary<>
                                    temporary = ageArray.get(j);
                                    //deleting the specified HashMap from ageArray
                                    //this is so we can look for other HashMaps that may possibly contains the same Integer keys (people with same Birthday)
                                    ageArray.remove(j);
                                    
                                    //concatinating and storing \n\tNAME\tBIRTHDAY\tAGE to String temporary
                                    //using ages.get(i) as key for temporary HashMap to get the value which is a Person object
                                    //calling .getName() to get the NAME
                                    String temp = "\n\t" + temporary.get(ages.get(i)).getName() +
                                            //calling .getBirthday() to get the BIRTHDAY
                                            "\t" + f.format(temporary.get(ages.get(i)).getBirthDay()) +
                                            //calling .computeAge() passng the BIRTHDAY to get the AGE
                                            "\t" + temporary.get(ages.get(i)).computeAge(temporary.get(ages.get(i)).getBirthDay());
                                    
                                    //appending temporary to records TextArea
                                    records.append(temp);
                                    
                                    //appending NAME,BIRTHDAY,AGE\n to StringBuilder forExport
                                    forExport.append(temporary.get(ages.get(i)).getName()).append(",").append(f.format(temporary.get(ages.get(i)).getBirthDay())).append(",").append(temporary.get(ages.get(i)).computeAge(temporary.get(ages.get(i)).getBirthDay())).append("\n");
                                }
                            }   
                            
                        }
                        break;
                    default:
                        break;
                }
            }
            else if(descend.isSelected()) //else if descend JRadioButton is selected
            {
                //switch case checking if sort.getSelectedIndex() is 0 for name sort, 1 for birthday sort, or 2 for age sort
                //the codes inside the for loops are the same as if ascend is selected but the for loop is reversed for descend
                //starting with index person.size()-1 till 0 instead of 0 to person.size()
                switch (sort.getSelectedIndex()) {
                    case 0:
                        for(int i = person.size()-1; i >= 0; i--)
                        {
                            String temporary = "\n\t" + names.get(i)
                                    + "\t" + f.format(nameMap.get(names.get(i)).getBirthDay())
                                    + "\t" + nameMap.get(names.get(i)).computeAge(nameMap.get(names.get(i)).getBirthDay());
                            
                            records.append(temporary);
                            
                            forExport.append(names.get(i)).append(",").append(f.format(nameMap.get(names.get(i)).getBirthDay())).append(",").append(nameMap.get(names.get(i)).computeAge(nameMap.get(names.get(i)).getBirthDay())).append("\n");
                        
                        }  
                        
                        break;
                    case 1:
                        for(int i = person.size()-1; i >= 0; i--)
                        {
                            HashMap<Date, Person> temporary;
                            
                            for(int j = 0; j < dateArray.size();j++)
                            {
                                if(dateArray.get(j).containsKey(dates.get(i)))
                                {
                                    temporary = dateArray.get(j);
                                    dateArray.remove(j);
                                    
                                    String temp = "\n\t" + temporary.get(dates.get(i)).getName() +
                                                "\t" + f.format(temporary.get(dates.get(i)).getBirthDay()) +
                                                "\t" + temporary.get(dates.get(i)).computeAge(temporary.get(dates.get(i)).getBirthDay());
                                    
                                    records.append(temp);
                                    
                                    forExport.append(temporary.get(dates.get(i)).getName()).append(",").append(f.format(temporary.get(dates.get(i)).getBirthDay())).append(",").append(temporary.get(dates.get(i)).computeAge(temporary.get(dates.get(i)).getBirthDay())).append("\n");
                                }
                            }
                        } 
                        
                        break;
                    case 2:
                        for(int i = person.size()-1; i >= 0; i--)
                        {
                           HashMap<Integer, Person> temporary;
                            
                            for(int j = 0; j < ageArray.size();j++)
                            {
                                if(ageArray.get(j).containsKey(ages.get(i)))
                                {
                                    temporary = ageArray.get(j);
                                    ageArray.remove(j);
                                    
                                    String temp = "\n\t" + temporary.get(ages.get(i)).getName() +
                                            "\t" + f.format(temporary.get(ages.get(i)).getBirthDay()) +
                                            "\t" + temporary.get(ages.get(i)).computeAge(temporary.get(ages.get(i)).getBirthDay());
                                    
                                    records.append(temp);
                                    forExport.append(temporary.get(ages.get(i)).getName()).append(",").append(f.format(temporary.get(ages.get(i)).getBirthDay())).append(",").append(temporary.get(ages.get(i)).computeAge(temporary.get(ages.get(i)).getBirthDay())).append("\n");
                                }
                            }  
                        } 
                        
                        break;
                    default:
                        break;
                }
            }
            else //else, meaning none of the two is selected
            {
                //for loop to traverse person<>
                for(int i = 0; i < person.size(); i++)
                {
                    //since no sorting has been selected just call .getName .getBirthday and .computeAge()
                    //and append values to records with format \n\tNAME\tBIRTHDAY\tAGE
                    records.append("\n\t" + person.get(i).getName() 
                        + "\t" + f.format(person.get(i).getBirthDay())
                        + "\t" + person.get(i).getAge());
                    
                    //appending NAME,BIRTHDAY,AGE\n on forExport StringBuilder
                    forExport.append(person.get(i).getName()).append(",").append(f.format(person.get(i).getBirthDay())).append(",").append(person.get(i).getAge()).append("\n");
                }
            }
        }
        else
        {
            //no radio is selected, set text of records TextArea
            records.setText("\tNAME\tBIRTHDAY\tAGE\t");
        }
    }
    
    //method for addRecord start up
    public void addStartUp()
    {
        //adding components to addP1
        addP1.add(nameL);
        addP1.add(nameTF);
        
        //adding componenets to addP2
        bdayP.add(bdayL);
        bdayP.add(new JLabel(" "));
        bdayP.setLayout(new BoxLayout(bdayP, BoxLayout.Y_AXIS));
        monthP.add(month);
        monthP.add(monthL);
        monthP.setLayout(new BoxLayout(monthP, BoxLayout.Y_AXIS));
        dayP.add(day);
        dayP.add(dayL);
        dayP.setLayout(new BoxLayout(dayP, BoxLayout.Y_AXIS));
        yearP.add(year);
        yearP.add(yearL);
        yearP.setLayout(new BoxLayout(yearP, BoxLayout.Y_AXIS));
        addP2.add(bdayP);
        addP2.add(monthP);
        addP2.add(dayP);
        addP2.add(yearP);
        
        //adding components to addP3
        addP3.add(saveBackB);
        addP3.add(saveAddB);
        addP3.add(backB);
        
        //setting layout of addRecords 
        addRecords.setLayout(new GridLayout(3,1));
        
        //adding addP1, addP2, and addP3 to addRecords JFrame
        addRecords.add(addP1);
        addRecords.add(addP2);
        addRecords.add(addP3);
        
        //using .pack() on records and setting the window to center of screen
        addRecords.pack();
        addRecords.setLocationRelativeTo(null);
        
        //adding window listener for the close button
        addRecords.addWindowListener(this);
        
        //anonymous action listener for saveBackB
        saveBackB.addActionListener(
                                    e-> {
                                            //if statement to check if nameF has no text
                                            if("".equals(nameTF.getText()))
                                            {
                                                //if there is no text, show error message
                                                JFrame f = new JFrame();
                                                JOptionPane.showMessageDialog(f,"An IllegalArgumentException was caught: No name entered!","Error Screen",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                            {
                                                //getting the Integer from year JComboBox - 1900, as stated in the API in creating a Date object the year parameter is year minus 1900
                                                //then store it to yearValue
                                                int yearValue = Integer.parseInt(year.getItemAt(year.getSelectedIndex()))-1900;
                                                //getting the Integer value from month JComboBox - 1, as stated in the API, the month parameter is 0-11(0 = Jan, 1 = Feb, ..., 11= Dec)
                                                //then store it to monthValue
                                                int monthValue = Integer.parseInt(month.getItemAt(month.getSelectedIndex()))-1;
                                                //getting the Integer value from day JComboBox, then store it to dayValue
                                                int dayValue = Integer.parseInt(day.getItemAt(day.getSelectedIndex()));
                                                
                                                //if statement that uses boolean values from checkName(), checkDate(), and lettersOnly
                                                if(!checkName(nameTF.getText()) && checkDate(yearValue+1900, monthValue+1, dayValue) && lettersOnly)
                                                {
                                                    //if all validations are true
                                                    //call addPerson passing the parameters and adding it to person<>
                                                    person.add(addPerson(nameTF.getText(), yearValue, monthValue, dayValue));
                                                    //then setVisible of addRecords to false, and listOfRecords to true;
                                                    addRecords.setVisible(false);    
                                                    listOfRecords.setVisible(true); 
                                                    //calling displayRecord() to update records TextArea and forExport StringBuilder
                                                    displayRecord();
                                                }
                                                
                                                //reseting lettersOnly to true;
                                                lettersOnly = true;
                                                
                                                //reseting nameTF, year, month, and day
                                                nameTF.setText("");
                                                year.setSelectedIndex(0);
                                                month.setSelectedIndex(0);
                                                day.setSelectedIndex(0);

                                            }
                                        }
                                    );
        
        //anonymous action listener for saveAddB
        //the code is almost the same for action listener of saveBackB but wihthout setVisible of addRecords to false, and listOfRecords to true, and calling displayRecord()
        //so the after adding the entry, it would stay in addRecord JFrame
        saveAddB.addActionListener(
                                    e-> {
                                            if("".equals(nameTF.getText()))
                                            {
                                                JFrame f = new JFrame();
                                                JOptionPane.showMessageDialog(f,"An IllegalArgumentException was caught: No name entered!","Error Screen",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                            {
                                                int yearValue = Integer.parseInt(year.getItemAt(year.getSelectedIndex()))-1900;
                                                int monthValue = Integer.parseInt(month.getItemAt(month.getSelectedIndex()))-1;
                                                int dayValue = Integer.parseInt(day.getItemAt(day.getSelectedIndex()));

                                                if(!checkName(nameTF.getText()) && checkDate(yearValue+1900, monthValue+1, dayValue) && lettersOnly)
                                                {
                                                    person.add(addPerson(nameTF.getText(), yearValue, monthValue, dayValue));
                                                    
                                                    //no code to setVisible of addRecords to false, and listOfRecords to true, and calling displayRecord()
                                                }

                                                lettersOnly = true;

                                                nameTF.setText("");
                                                year.setSelectedIndex(0);
                                                month.setSelectedIndex(0);
                                                day.setSelectedIndex(0);  
                                            }
                                            
                                        }
                                    );
        
        //anonymous action listener for backB
        backB.addActionListener(
                                    e-> {
                                            //setVisible of addRecords to false, and listOfRecords to true
                                            addRecords.setVisible(false);    
                                            listOfRecords.setVisible(true); 
                                            //calling displayRecord() to update records TextArea and forExport StringBuilder
                                            displayRecord();
                                        }
                                    );
        
    }
    
    //method that returns a Person object
    public Person addPerson(String name, int year, int month, int day)
    {
        //create new Date object date passing int year, month, and day as parameters
        Date date = new Date(year, month, day);
        
        boolean validDate = false;
        
        //try catch to catch IllegalArgumentException
        try
        {
            //check if date given is in the future, else throw exception
            if(date.after(new Date()))
            {
                throw new IllegalArgumentException();
            }
            
            //if no exceptions were thrown, set validDate to true
            validDate = true;
        }
        catch(IllegalArgumentException iae) //if an exception was caught
        {
            //display error message
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,"An IllegalArgumentException was caught: Date given is in the future!","Error Screen",JOptionPane.ERROR_MESSAGE);
        }
        
        //validDate is true, create a Person object newPerson passing name and date as parameters
        if(validDate == true)
        {
            Person newPerson = new Person(name, date);
            
            //then return newPerson
            return newPerson;
        }
        else
        {
            //else return null
            return null;
        }
        
    }
    
    //method that validates String name and returns boolean
    public boolean checkName(String name)
    {
        boolean exists = false;
        
        try
        {
            //if statement name does not only consists of letters and spaces, throw exception
            if(!name.matches("^[ a-zA-Z]+$"))
            {
                throw new IllegalArgumentException();
            }   
        }
        catch(IllegalArgumentException iae)
        {
            //setting lettersOnly to false
            lettersOnly = false;
            //display error message
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,"An IllegalArgumentException was caught: Name must be composed of letters only!","Error Screen",JOptionPane.ERROR_MESSAGE);
        }
        
        //for loop to check if name already exist in a Person object in person<>
        for(int i = 0; i < person.size(); i++)
        {
            Person temporary = person.get(i);
            
            //if a duplicate name is found
            if(temporary.getName().equals(name))
            {
                //set exists to true
                exists = true;
            }
        }

        try
        {
            //if exists == true, throw exception
            if(exists)
            {
                throw new IllegalArgumentException();
            }
            
        }
        catch(IllegalArgumentException iae)
        {
            //display error message
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,"An IllegalArgumentException was caught: Name already exists in the record!","Error Screen",JOptionPane.ERROR_MESSAGE);
        }
        
        //return boolean exists
        return exists;
    }
    
    //method that validates parameters for Birthday is valid and returns boolean
    public boolean checkDate(int yearValue, int monthValue, int dayValue)
    {
        boolean correct = true;
        
        try
        {
            //switch case using monthValue
            switch (monthValue) 
            {
                case 4:
                case 6:
                case 9:
                case 11:
                    //to check if months with only 30 days gets a 31 for the day, else throw exception
                    if(dayValue == 31)
                    {
                        correct = false;
                        throw new IllegalArgumentException();
                    }
                    break;
                case 2:
                    //check if the year is a leap year
                    if(yearValue%4 == 0)
                    {
                        //check if the day of Feb. on that leap year doesn't exceed day 29, else throw exception
                        if(dayValue > 29)
                        {
                            correct = false;
                            throw new IllegalArgumentException();
                        }
                    }
                    else
                    {
                        //for non leap years, check if it doesn't exceed day 28, else throw exception
                        if(dayValue > 28)
                        {
                            correct = false;
                            throw new IllegalArgumentException();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        catch(IllegalArgumentException iae)
        {
            //display error message
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f,"An IllegalArgumentException was caught: Invalid Date!","Error Screen",JOptionPane.ERROR_MESSAGE);
        }
        finally
        {
            //finally return correct whether an exception si caught or not
            return correct;
        }
        
        
    }
    
    //method for removeRecods start up
    public void removeStartUp()
    {
        //adding components to removeP1
        removeP1.add(nameL2);
        removeP1.add(nameTF2);
        
        //adding components to removeP2
        removeP2.add(removeBackB);
        removeP2.add(saveRemoveB);
        removeP2.add(backB2);
        
        //setting layout of removeRecords
        removeRecords.setLayout(new GridLayout(2,1));
        
        //adding removeP1 and removeP2 to removeRecords JFrame
        removeRecords.add(removeP1);
        removeRecords.add(removeP2);
        
        //using .pack() on removeRecords and setting window to center
        removeRecords.pack();
        removeRecords.setLocationRelativeTo(null);
        
        //anonymous action listener for removeBackB
        removeBackB.addActionListener(
                                    e-> {
                                            //storing nameTF2.getText() to String name
                                            String name = nameTF2.getText();
                                            boolean exists = false;
                                            
                                            //for loop to traverse person<>
                                            for(int i = 0; i < person.size(); i++)
                                            {
                                                //storing person.get(i) to temporary
                                                Person temporary = person.get(i);
                                                
                                                //if the temporary.getName() == name
                                                if(temporary.getName().equals(name))
                                                {
                                                    //remove the Person object at i from person<>
                                                    person.remove(i);
                                                    //set exists to true
                                                    exists = true;
                                                }
                                            }
                                            
                                            try
                                            {
                                                //if exists == false, throw exception
                                                if(!exists)
                                                {
                                                    throw new IllegalArgumentException();
                                                }
                                                
                                                //if no exception were thrown, set visibility of removeRecord to false, and listOfRecords to true
                                                removeRecords.setVisible(false);    
                                                listOfRecords.setVisible(true);
                                                //call displayRecords() to update records TextArea and forExport StringBuilder
                                                displayRecord();
                                            }
                                            catch(IllegalArgumentException iae)
                                            {
                                                //display error messafe
                                                JFrame f = new JFrame();
                                                JOptionPane.showMessageDialog(f,"An IllegalArgumentException was caught: Name Not Found!","Error Screen",JOptionPane.ERROR_MESSAGE);
                                            }
                                            
                                            //reset nameTF2
                                            nameTF2.setText("");
                                        }
                                    );
        
        //anonymous action listener for saveRemoveB
        //the code inside the action listener is similar to the action listener of removeBackB but without set visibility of removeRecord to false, and listOfRecords to true, and calling displayRecord()
        saveRemoveB.addActionListener(
                                    e-> {
                                            String name = nameTF2.getText();
                                            boolean exists = false;
                                            
                                            for(int i = 0; i < person.size(); i++)
                                            {
                                                Person temporary = person.get(i);
                                                
                                                if(temporary.getName().equals(name))
                                                {
                                                    person.remove(i);
                                                    exists = true;
                                                }
                                            }
                                            
                                            try
                                            {
                                                if(!exists)
                                                {
                                                    throw new IllegalArgumentException();
                                                }
                                                
                                                //no code for set visibility of removeRecord to false, and listOfRecords to true, and calling displayRecord()
                                            }
                                            catch(IllegalArgumentException iae)
                                            {
                                                JFrame f = new JFrame();
                                                JOptionPane.showMessageDialog(f,"An IllegalArgumentException was caught: Name Not Found!","Error Screen",JOptionPane.ERROR_MESSAGE);
                                            }
                                            
                                            nameTF2.setText("");
                                        }
                                    );
        
        //anonymous action listener for backB2
        backB2.addActionListener(
                                    e-> {
                                            //set visibility of removeRecord to false, and listOfRecords to true
                                            removeRecords.setVisible(false);    
                                            listOfRecords.setVisible(true);  
                                            //call displayRecords() to update records TextArea and forExport StringBuilder
                                            displayRecord();
                                        }
                                    );
    }
}

//class Person for initializing Person objects
class Person
{
    //instance variables
    private String name;
    private Date birthDay;
    private int age;
    
    //empty constructor
    public Person()
    {
        
    }

    //constructor that accepts String name and Date birthDay
    public Person(String name, Date birthDay)
    {
        setName(name); //calling setName() passing name
        setBirthDay(birthDay); //calling setBirthDay passing birthDay
        //calling computeAge() passing birthDay and storing returned value to age
        age = computeAge(birthDay);
    }
    
    //setter that accepts String name, using .this to store the value in the class
    public void setName(String name)
    {
        this.name = name;
    }

    //setter that accepts Date birthDay, using .this to store the value in the class
    public void setBirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
    }
    
    //getter that returns name
    public String getName()
    {
        return name;
    }
    
    //getter that returns birthDay
    public Date getBirthDay()
    {
        return birthDay;
    }

    //getter that returns age
    public int getAge()
    {
        return age;
    }

    //method that accepts Date birthday and returns int
    public int computeAge(Date birthDay)
    {
        //using the provided guide
        //LocalDate today to store current date 
        LocalDate today = LocalDate.now();
        
        //converting birthDay to LocalDate object birthday
        LocalDate birthday = birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        //using Period.between(birthday, today) and storing to Period p
        Period p = Period.between(birthday, today);
        
        //returning p.getYears() to get the actual age
        return p.getYears();
    }
}
