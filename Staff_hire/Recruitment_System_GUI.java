import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
/*
 * Class: Recruitment_System_GUI
 * 
 * Description: Main class for the recruitment GUI
 * 
 * Displays welcome screen and opens the staff form.
 */
public class Recruitment_System_GUI implements ActionListener
{
    /*  **** Declare variables for GUI components and data storage ****  */
    private ArrayList<Staff_Hire> staffList; // Stores full-time and part-time staff records

    /*  **** Labels for various fields ****  */
    private JLabel vacancy ;
    private JLabel jobType;
    private JLabel designation;
    private JLabel jobDate;
    private JLabel staffName;
    private JLabel appointedBy;
    private JLabel qualification;
    private JLabel salary;
    private JLabel joined;
    private JLabel weeklyFractionalHour;
    private JLabel workingHours;
    private JLabel wagesPerHour;
    private JLabel shifts;
    private JLabel displayNumber;

    /*   Text fields for user input  */
    private JTextField vacancyField;//T is for Text field
    private JComboBox<String> jobTypeCombo;//JComboBox including permanent, temporary and contract
    private JTextField designationT;//T is for Text field
    private JTextField jobDateT;
    private JTextField staffNameT;
    private JTextField appointedByT;
    private JTextField qualificationT;
    private JTextField salaryT;
    private JTextField weeklyFractionalHourT;
    private JTextField workingHoursT;
    private JTextField wagesPerHourT;
    private JComboBox<String> shiftsCombo;//JComboBox for shift including Moring, day and evening
    private JTextField displayNumberT;

    /*  **** Buttons for form actions ****  */
    private JButton addFullTimeStaff;
    private JButton addPartTimeStaff;
    private JButton addSalary;
    private JButton addShift;
    private JButton terminate;
    private JButton clearFrame1;
    private JButton displayNumberB;

    /*  **** Frames and container ****  */
    private JFrame frame;//Welcome frame
    private JFrame frame1;//Staff hiring frame
    private Container ContentPane;

    /*  **** Checkboxes ****  */
    private JCheckBox join, terminated;
    private JLabel pageTitle;

    /*  
     * Constructor to build GUI 
     * 
     * Initialise two frames called staff hiring frame and welcome frame
     * welcome frame will be default frame while staff hiring frame will be 
     * implemented later through actionPerform method
     */
    public Recruitment_System_GUI()
    {
        staffList = new ArrayList<Staff_Hire>();// Initialize the staff list
        Font font = new Font("Segoe UI", Font.BOLD, 16);//font set up

        /*
         * Creating frame for staff hiring
         * 
         * Create frame with gridLayout(3,1), three JPanel will be implemented
         * in the layout. frame will be set visible via actionPerform
         */
        frame = new JFrame("Staff Hiring System");
        frame.setSize(750, 500);
        frame.setResizable(false);
        ContentPane = frame.getContentPane();
        JMenuBar menuBar = new JMenuBar();
        pageTitle = new JLabel("Staff Form");
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(pageTitle);
        menuBar.add(Box.createHorizontalGlue());
        pageTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        frame.setJMenuBar(menuBar);
        ContentPane.setLayout(new GridLayout(3, 1));//three jpanel will be add later
        frame.setVisible(false);//Frame will be finished setting up inside a method later

        /*
         * Defult frame(Welcome Frame) setup
         * 
         * Welcome message and buttons for full time and part time forms 
         * will be appeared in the frame.
         */ 
        frame1 = new JFrame("Staff Hiring System - Welcome");
        frame1.setSize(750, 500);
        frame1.setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Labels for welcome messages
        JLabel welcomeLabel = new JLabel("Welcome to the Staff Hiring System. CS4001 :)");
        welcomeLabel.setFont(new Font("Ariel", Font.BOLD, 25));
        welcomeLabel.setForeground(new Color(0, 102, 204));//changing font color

        JLabel optionLabel = new JLabel("Please select an option below to get started.");
        optionLabel.setFont(new Font("Ariel", Font.PLAIN, 20));

        JLabel tipLabel = new JLabel("Tip: You needs to come back here to switch registeration form. Please do not close");
        tipLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
        tipLabel.setForeground(new Color(0, 128, 0));

        //Form selector buttons
        JButton fullTime = new JButton("Open Full-Time Form");
        fullTime.addActionListener(this);
        JButton partTime = new JButton("Open Part-Time Form");
        partTime.addActionListener(this);
        //Center alignment of labels and buttons
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        optionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        tipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        fullTime.setAlignmentX(Component.CENTER_ALIGNMENT);
        partTime.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Spacing and layout
        panel.add(Box.createVerticalStrut(40));
        panel.add(welcomeLabel);
        panel.add(Box.createVerticalStrut(40));
        panel.add(optionLabel);
        panel.add(Box.createVerticalStrut(40));
        panel.add(fullTime);
        panel.add(Box.createVerticalStrut(20));
        panel.add(partTime);
        panel.add(Box.createVerticalStrut(60));
        panel.add(tipLabel);
        panel.setBackground(new Color(144, 238, 144));
        frame1.add(panel);
        frame1.setVisible(true);// Default frame

    }

    /*
     * Utility to apply font styling to labels
     */
    public static void setLabelFont(Container ContentPane, Font font) {
        for (Component comp : ContentPane.getComponents()) {
            if (comp instanceof JLabel) {
                comp.setFont(font);
                comp.setForeground(new Color(0, 102, 204));
            }
        }}

    /*
     * Shared Container for general info section (used in both forms)
     * 
     * Label and Buttons for General informations including vacancy, disignation,
     * name, job type, qualification, joining date, appointedBy and join, 
     * will be designed in this container
     * @Return the container
     */
    public Container generalInfo() {
        Font labelFont = new Font("Arial", Font.BOLD, 16);

        JPanel sharedInfo = new JPanel();
        sharedInfo.setLayout(new BoxLayout(sharedInfo, BoxLayout.Y_AXIS));

        // Row A: Vacancy and Designation
        JPanel rowA = new JPanel(new GridLayout(1,1));
        vacancy = new JLabel("  Vacancy:");
        vacancyField = new JTextField(20);

        designation = new JLabel("Designation:");
        designationT = new JTextField(20);

        rowA.add(vacancy); rowA.add(vacancyField);
        rowA.add(Box.createHorizontalStrut(1));
        rowA.add(designation); rowA.add(designationT);

        //Row B: Staff Name & Job Type
        JPanel rowB = new JPanel(new GridLayout(1,4));
        staffName = new JLabel("  Staff Name:");
        staffNameT = new JTextField(10);
        jobType = new JLabel("Job Type:");
        String[] jobTypes = {"Permanent", "Contract", "Temporary"};
        jobTypeCombo = new JComboBox<>(jobTypes);
        jobTypeCombo.setSelectedIndex(-1);

        rowB.add(staffName); rowB.add(staffNameT);
        rowB.add(Box.createHorizontalStrut(10));
        rowB.add(jobType); rowB.add(jobTypeCombo);

        // Row C: Qualification & Job Date
        JPanel rowC = new JPanel(new GridLayout(1,4));
        qualification = new JLabel("  Qualification:");
        qualificationT = new JTextField(10);
        jobDate = new JLabel("Job Date:");
        jobDateT = new JTextField(10);
        rowC.add(qualification); rowC.add(qualificationT);
        rowC.add(Box.createHorizontalStrut(1));
        rowC.add(jobDate); rowC.add(jobDateT);

        // Row D: Appointed By & Joined Checkbox
        JPanel rowD  = new JPanel(new GridLayout(1,4));
        appointedBy  = new JLabel("  Appointed By:");
        appointedByT = new JTextField(10);
        JLabel click = new JLabel("to join--->");
        join = new JCheckBox("Joined");

        rowD.add(appointedBy); rowD.add(appointedByT);
        rowD.add(Box.createHorizontalStrut(1));
        rowD.add(click);rowD.add(join);

        // Set label fonts
        setLabelFont(rowA, labelFont);
        setLabelFont(rowB, labelFont);
        setLabelFont(rowC, labelFont);
        setLabelFont(rowD, labelFont);

        // Add all rows to shared panel
        sharedInfo.add(rowA);
        sharedInfo.add(rowB);
        sharedInfo.add(rowC);
        sharedInfo.add(rowD);
        sharedInfo.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        return sharedInfo;//Return JPanel
    }

    /*
     * Container for info specific to full time staff only
     *  
     * Design the container for the full time specific info such as salary and 
     * weekly fractional hour.
     * Return the continer 
     */
    public Container fullTimeOnlyInfo()
    {
        Font font = new Font("Arial", Font.BOLD, 16);
        JPanel fullTimeInfo = new JPanel();
        fullTimeInfo.setLayout(new BoxLayout(fullTimeInfo, BoxLayout.Y_AXIS));

        // First row: Weekly Hours & Salary
        JPanel first = new JPanel(new GridLayout(1,4));
        weeklyFractionalHour = new JLabel ("Weekly Hours");
        weeklyFractionalHourT = new JTextField(10);
        salary = new JLabel("Salary");
        salaryT = new JTextField(10);

        // second row: buttons
        JPanel second = new JPanel();
        second.setLayout(new FlowLayout());
        addFullTimeStaff = new JButton("Add Fulltime Staff");
        addFullTimeStaff.addActionListener(this);
        addSalary = new JButton("Add Salary");
        addSalary.addActionListener(this);
        clearFrame1= new JButton("   clear   ");// change the name
        clearFrame1.addActionListener(this);

        first.add(weeklyFractionalHour);
        first.add(weeklyFractionalHourT);
        first.add(Box.createHorizontalStrut(1));
        first.add(salary);
        first.add(salaryT);

        second.add(addFullTimeStaff);second.add(addSalary);
        second.add(clearFrame1);

        // Add both rows to panel
        fullTimeInfo.add(first);
        fullTimeInfo.add(second);
        setLabelFont(first, font);
        first.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        return fullTimeInfo;

    }

    /*
     * Container that contains information specific for part time staff
     * 
     * Design the container for the part time info such as working hour, shift,
     * wages and termination.
     * Retrun the container
     */
    public Container partTimeOnlyInfo()
    {
        Font font = new Font("Arial", Font.BOLD, 16);
        JPanel partTimeInfo = new JPanel();
        partTimeInfo.setLayout(new BoxLayout(partTimeInfo, BoxLayout.Y_AXIS));

        // Row a: Working Hour & Wages
        JPanel a = new JPanel(new GridLayout(1,4));
        workingHours = new JLabel (" Working Hour");
        workingHoursT = new JTextField(10);
        wagesPerHour = new JLabel("Wages per Hour");
        wagesPerHourT = new JTextField(10);

        // Row b: Shift, Terminate button and checkbox
        JPanel b = new JPanel(new GridLayout(1,4));
        shifts = new JLabel("Shift");
        String[] shift = {"Morning", "Day", "Evening"};
        shiftsCombo = new JComboBox<>(shift);
        shiftsCombo.setSelectedIndex(-1); // no default selection
        terminate = new JButton("terminate");
        terminate.addActionListener(this);
        terminated = new JCheckBox("Terminated");

        // Row c: Add buttons and clear
        JPanel c = new JPanel(new FlowLayout());
        addPartTimeStaff = new JButton("Add Parttime Staff");
        addPartTimeStaff.addActionListener(this);
        addShift = new JButton("Add Shift");
        addShift.addActionListener(this);
        JButton clearFrame2 = new JButton("   clear   ");
        clearFrame2.addActionListener(this);

        // Add buttons and rows to part-time panel
        a.add(workingHours);
        a.add(workingHoursT);
        a.add(Box.createHorizontalStrut(1));
        a.add(wagesPerHour);
        a.add(wagesPerHourT);
        //creating border as box layout fills all the space for JLabel and Buttons
        a.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30)); 
        b.add(shifts);
        b.add(shiftsCombo);
        b.add(Box.createHorizontalStrut(1));
        b.add(terminate);
        b.add(terminated);
        b.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        c.add(addPartTimeStaff);
        c.add(addShift);
        c.add(clearFrame2);
        c.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        partTimeInfo.add(a);
        partTimeInfo.add(b);
        partTimeInfo.add(c);

        //Set font for all the JLabel component
        setLabelFont(a, font);
        setLabelFont(b, font);
        return partTimeInfo;

    }

    /* 
     * Method to create and return the container holding the display section.
     * It includes a label, text field, and button for displaying staff info.
     *
     * returns:
     * Container: a JPanel containing display UI components.
     */
    public Container display(){
        Font font = new Font("Arial", Font.BOLD, 16);
        // Create a new JPanel to hold display info
        JPanel displayInfo = new JPanel();
        displayInfo.setLayout(new FlowLayout());

        displayNumberB = new JButton("   Display   ");
        displayNumberB.addActionListener(this);
        displayNumberT= new JTextField(15);
        displayNumberT.setBorder(BorderFactory.createEmptyBorder(8, 30, 8, 30));
        displayNumber = new JLabel("Number display:");

        displayInfo.add(displayNumber);
        displayInfo.add(displayNumberT);
        displayInfo.add(displayNumberB);
        setLabelFont(displayInfo, font);

        return displayInfo;
    }

    /*
     * Main method to start the Recruitment System GUI.
     */
    public static void main(String[] args)
    {
        Recruitment_System_GUI GUI = new Recruitment_System_GUI();
    }

    /*
     * Handles actions triggered by button clicks in the GUI.
     * It switches between forms, adds staff, updates salary, and terminates contracts.
     *
     * @param event: ActionEvent - the button click event to be handled.
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        /*
         * Command to open full time staff form
         * 
         * It sets frame visible, clear the whole frame set up as i am only using 
         * one frame for both full time and part time, then add each container
         * and repaint the frame
         */
        if (command.equals("Open Full-Time Form"))
        {
            frame.setVisible(true);
            ContentPane.removeAll();
            pageTitle.setText("Full Time Registeration Form");
            ContentPane.add(generalInfo());
            ContentPane.add(fullTimeOnlyInfo());
            ContentPane.add(display());
            ContentPane.revalidate();
            ContentPane.repaint();

        }
        /*
         * Command to open part time form
         */
        else if (command.equals("Open Part-Time Form"))
        {
            frame.setVisible(true);
            ContentPane.removeAll();
            pageTitle.setText("Part Time Registeration Form");
            ContentPane.add(generalInfo());
            ContentPane.add(partTimeOnlyInfo());
            ContentPane.add(display());
            ContentPane.revalidate();
            ContentPane.repaint();
        }

        else if (command.equals("Add Parttime Staff"))
        {
            addPartTimeStaff();//adding part time staff to a list
        }
        else if (command.equals("Add Fulltime Staff"))
        {
            addFullTimeStaff();// adding full time staff to the list
        }
        else if (command.equals("Add Salary"))
        {
            addSalary(); //Changing salary of full time
        }
        else if (command.equals("   Display   "))
        {
            displayNumberB();// Displaying a staff info
        }
        else if (command.equals("terminate"))
        {
            terminatePartTimeStaff();//terminating part time staff
        }
        else if (command.equals("Add Shift"))
        {
            addShift();// changing shifts
        }
        else if (command.equals("   clear   "))//clearing full time staff page
        {
            vacancyField.setText("");
            jobTypeCombo.setSelectedIndex(-1);
            designationT.setText("");
            jobDateT.setText("");
            staffNameT.setText("");
            appointedByT.setText("");
            qualificationT.setText("");
            join.setSelected(false);
            salaryT.setText("");
            weeklyFractionalHourT.setText("");
            workingHoursT.setText("");
            shiftsCombo.setSelectedIndex(-1);
            wagesPerHourT.setText("");
            displayNumberT.setText("");
        }
    }

    /*
     * Method to handle adding a full-time staff member to the system
     * 
     * It reads the required input fields and checks if all the fields are filled
     * Then parse the salary, vacancy and work hour. then check if staff is already
     * on the list , if not, add the staff to the list
     */
    public void addFullTimeStaff(){
        //getting input fields
        String vacancyNumber   =  vacancyField.getText().trim();
        String designation     =  designationT.getText().trim();
        String jobType         =  (String) jobTypeCombo.getSelectedItem();
        String staffName       =  staffNameT.getText().trim();
        String joiningDate     =  jobDateT.getText().trim();
        String qualification   =  qualificationT.getText().trim();
        String appointedBy     =  appointedByT.getText().trim();
        boolean joined         =  join.isSelected();
        String workingHoursStr =  weeklyFractionalHourT.getText().trim();
        String salaryStr       =  salaryT.getText().trim();

        //validate that all required fields are filled
        if (vacancyNumber.isEmpty() || designation.isEmpty() || jobType == null || staffName.isEmpty() ||
        joiningDate.isEmpty() || qualification.isEmpty() || appointedBy.isEmpty() ||
        workingHoursStr.isEmpty() || salaryStr.isEmpty()) 
        {
            JOptionPane.showMessageDialog(frame, "Please fill all fields for full-time staff.");
            return;
        }

        //parse integer value and catch an error
        int vacancy_no, workingHours;
        double salary;
        try {
            vacancy_no   = Integer.parseInt(vacancyNumber);
            workingHours = Integer.parseInt(workingHoursStr);
            salary = Double.parseDouble(salaryStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Vacancy, Salary and Working Hours must be numbers.");
            return;
        }
        // Check if a staff member already exists with the given vacancy number
        for (Staff_Hire staff : staffList) {
            if (staff.getVacancyNo() == vacancy_no) {
                JOptionPane.showMessageDialog(frame, "Staff with this vacancy number already exists.");
                return;
            }
        }
        // Create a new FullTimeStaffHire object and add it to the list
        FullTimeStaffHire fullTime = new FullTimeStaffHire(vacancy_no, designation, jobType, staffName, joiningDate, qualification, appointedBy,joined, salary, workingHours);
        if (join.isSelected()) {
            fullTime.Hired(true);
            fullTime.getJoined();
        } else {
            fullTime.Hired(false);
        }
        staffList.add(fullTime);
        JOptionPane.showMessageDialog(frame, "Full-time staff '" +vacancy_no+"' added successfully!");

    }

    /*
     * Adds a new part-time staff member to the system after validating input.
     */
    public void addPartTimeStaff(){
        String vacancyNumber  =  vacancyField.getText().trim();
        String Designation    =  designationT.getText().trim();
        String jobType        =  (String) jobTypeCombo.getSelectedItem();
        String staffName      =  staffNameT.getText().trim();
        String joiningDate    =  jobDateT.getText().trim();
        String Qualification  =  qualificationT.getText().trim();
        String appointedBy    =  appointedByT.getText().trim();
        String workingHour    =  workingHoursT.getText().trim();
        boolean joined        =  join.isSelected();
        String wagesPerHour   =  wagesPerHourT.getText().trim();
        String shift = (String) shiftsCombo.getSelectedItem();

        // Validate that all required fields are filled
        if (vacancyNumber.isEmpty() || Designation.isEmpty() || jobType== null || staffName.isEmpty() ||
        joiningDate.isEmpty() || Qualification.isEmpty() || appointedBy.isEmpty() ||
        workingHour.isEmpty() || wagesPerHour.isEmpty() || shift.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields for part time staff.");
            return;
        }

        //parse the input value and catch error
        int vacancy_no, workingHours; 
        double wagesPerHourS;
        try {
            vacancy_no   = Integer.parseInt(vacancyNumber);
            workingHours = Integer.parseInt(workingHour);
            wagesPerHourS = Double.parseDouble(wagesPerHour);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for Vancancy, working hours and salary.");
            return;
        }
        //check if staff alraedy in the list
        for (Staff_Hire staff : staffList) {
            if (staff.getVacancyNo() == vacancy_no) {
                JOptionPane.showMessageDialog(frame, "Staff with this vacancy number already exists.");
                return;
            }
        }
        //creat part time object and add to the list
        PartTimeStaffHire partTime = new PartTimeStaffHire(vacancy_no, Designation, jobType, staffName, joiningDate, Qualification, appointedBy,joined, workingHours, wagesPerHourS, shift);
        if (join.isSelected()) {
            partTime.Hired(true);
            partTime.getJoined();
        } else {
            partTime.Hired(false);
        }
        staffList.add(partTime);
        JOptionPane.showMessageDialog(frame, "Part time staff '" +vacancy_no+"' added successfully!");

    } 

    /*
     * Method to terminates a part-time staff member if conditions are met.
     * 
     * it first gets vacancy and terminate inputs, checks both inputs are filled, 
     * then search part time staff with vacancy in the list and terminate
     */
    public void terminatePartTimeStaff() {
        //getting vacancy and terminate inputs
        String vacancyFieldext = vacancyField.getText().trim();
        boolean Terminate      =  terminated.isSelected();
        if (vacancyFieldext.isEmpty() || !Terminate) {
            JOptionPane.showMessageDialog(frame, "Please enter a vacancy number and tick terminate.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int vacancyNumber = Integer.parseInt(vacancyFieldext);
            boolean found = false;
            //finding staff and checking part time staff
            for (int i = 0; i < staffList.size(); i++) {
                Staff_Hire staff = staffList.get(i);
                if (staff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire partTime = (PartTimeStaffHire) staff;

                    if (partTime.getVacancyNo() == vacancyNumber) {
                        if (!partTime.getTermination()) {
                            partTime.Fired(); // terminate the staff
                            staffList.remove(i); // remove from the ArrayList
                            JOptionPane.showMessageDialog(frame, "Part-time staff terminated and removed from the list.");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Staff already terminated.", "Notice", JOptionPane.INFORMATION_MESSAGE);
                        }
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, "No part-time staff with that vacancy number.", "Not Found", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for the vacancy.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Updates the salary of a full-time staff member if matched by vacancy number and name.
     * 
     */
    public void addSalary() {
        //getting cacancy, name and salary inputs
        String vacancyInput = vacancyField.getText().trim();
        String staffName      =  staffNameT.getText().trim();
        String newSalary = salaryT.getText().trim();

        if (vacancyInput.isEmpty() || staffName.isEmpty() || newSalary.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a vacancy number, name, and salary.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int vacancy;double Salary;
        try{
            vacancy = Integer.parseInt(vacancyInput);
            Salary = Double.parseDouble(newSalary);
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Vacancy & Salary must be numbers.");
            return;
        }
        for (Staff_Hire staff : staffList) {
            if (staff instanceof FullTimeStaffHire) {
                FullTimeStaffHire fullTime = (FullTimeStaffHire) staff;

                if (staff.getVacancyNo()==vacancy && staff.getStaffName().equals(staffName)) {
                    if (fullTime.getJoined()) {
                        fullTime.setSalary(Salary);
                        JOptionPane.showMessageDialog(frame, "Salary updated for " + vacancyInput + ".");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Staff hasn't joined. Cannot update salary.");
                    }
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(frame, "Full-time staff of vacancy no  '" + vacancyInput + "' not found.");
    }

    /*
     * Method to handle changing shift for part time staff
     */
    public void addShift() {
        // Get inputs from text fields and combo box
        String vacancyInput = vacancyField.getText().trim();
        String staffName = staffNameT.getText().trim();
        String newShift = (String) shiftsCombo.getSelectedItem();
        
        // Input validation: Check for empty fields or null shift
        if (vacancyInput.isEmpty() || staffName.isEmpty() || newShift == null || newShift.isBlank()) {
            JOptionPane.showMessageDialog(frame, "Please enter a vacancy number, staff name, and select a shift.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Try parsing vacancy number as an integer and show error message if found error
        int vacancy;
        try {
            vacancy = Integer.parseInt(vacancyInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Vacancy number must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Search through staff list for a matching vacancy number and name

        for (Staff_Hire staff : staffList) {
            if (staff.getVacancyNo() == vacancy && staff.getStaffName().equalsIgnoreCase(staffName)) {
                if (staff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire partStaff = (PartTimeStaffHire) staff;
                    partStaff.setShift(newShift);
                    JOptionPane.showMessageDialog(frame, "Shift updated to '" + newShift + "' for staff: " + staffName);
                } else {
                    JOptionPane.showMessageDialog(frame, "Staff found, but not a part-time staff member.", "Type Error", JOptionPane.WARNING_MESSAGE);
                }
                return; // No need to keep looping
            }
        }
        // No matching staff found
        JOptionPane.showMessageDialog(frame, "No matching part-time staff found for vacancy number '" + vacancy + "'.", "Not Found", JOptionPane.ERROR_MESSAGE);
    }

    /*
     * method to handle display staff from the list
     * 
     * it read the input value as staffList index and print out in terminal
     * 
     */
    public void displayNumberB(){

        int displayNumber = -1; //default value for input

        try {
            // Get and parse the index from the text field 
            displayNumber = Integer.parseInt(displayNumberT.getText());

            // Check if it's in valid range
            if (displayNumber < 0 || displayNumber >= staffList.size()) {
                JOptionPane.showMessageDialog(frame, "Out of range.\nStaff size : " + staffList.size());
                return;
            }

            // Valid index: retrieve the StaffHire object
            Staff_Hire staff = staffList.get(displayNumber);

            // Display info using System.out 
            System.out.println("Staff Information:");
            if (staff instanceof FullTimeStaffHire) {
                ((FullTimeStaffHire) staff).FullTimeStaff_details();
            } else if (staff instanceof PartTimeStaffHire) {
                ((PartTimeStaffHire) staff).PartTimeStaff_details();
            }
            JOptionPane.showMessageDialog(frame,"Staff '"+displayNumber+"' information printed \nStaff size :"+ staffList.size());
        } catch (NumberFormatException e) {
            // Input is not a number
            JOptionPane.showMessageDialog(frame, "Invalid input. try again!!\nStaff size : " + staffList.size());
        }

    }
}