import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class staffHiring_GUI implements ActionListener
{
    private ArrayList<Staff_Hire> Staffes;
    private JLabel Vacancy;
    private JLabel jobType;
    private JLabel Designation;
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
    private JTextField vacancyT;
    private JTextField jobTypeT;
    private JTextField designation;
    private JTextField jobDateT;
    private JTextField staffNameT;
    private JTextField appointedByT;
    private JTextField qualificationT;
    private JTextField salaryT;
    private JTextField weeklyFractionalHourT;
    private JTextField workingHoursT;
    private JTextField wagesPerHourT;
    private JTextField shiftsT;
    private JTextField displayNumberT;
    
    private JButton addFullTimeStaff;
    private JButton addPartTimeStaff;
    private JButton addSalary;
    private JButton addShift;
    private JButton terminate;
    private JButton displayNumberB;
    private JFrame frame;
    private JFrame frame1;
    private JButton fullTime;
    private JButton partTime;
    
    public staffHiring_GUI()
    {
        Staffes = new ArrayList<Staff_Hire>();
        frame1 = new JFrame(" Original" );
        Container staff = frame1.getContentPane();
        staff.setLayout(new FlowLayout());
        fullTime  = new JButton("ADD Full TIME");
        partTime  = new JButton("Add Part Time");
        staff.add(fullTime);
        staff.add(partTime);
        frame1.pack();
        frame1.setVisible(true);
        
        frame = new JFrame("Staff Hire Page");
        Container contentPane =  frame.getContentPane();
        contentPane.setLayout(new GridLayout(11, 4));
        
        Container row11 = new Container();
        row11.setLayout(new FlowLayout());
        Vacancy = new JLabel("Vacancy");
        row11.add(Vacancy);
        
        Container row12 = new Container();
        row12.setLayout(new FlowLayout());
        vacancyT = new JTextField(10);
        row12.add(vacancyT);
        
        Container row13 = new Container();
        row13.setLayout(new FlowLayout());
        Designation = new JLabel("Designation");
        row13.add(Designation);
        
        Container row14 = new Container();
        row14.setLayout(new FlowLayout());
        designation = new JTextField(10);
        row14.add(designation);
        
        Container row21 = new Container();
        row21.setLayout(new FlowLayout());
        jobType = new JLabel("Job Type");
        row21.add(jobType);
        
        Container row22 = new Container();
        row22.setLayout(new FlowLayout());
        jobTypeT = new JTextField(10);
        row22.add(jobTypeT);
        
        Container row23 = new Container();
        row23.setLayout(new FlowLayout());
        jobDate = new JLabel("Job Date");
        row23.add(jobDate);
        
        Container row24 = new Container();
        row24.setLayout(new FlowLayout());
        jobDateT = new JTextField(10);
        row24.add(jobDateT);
        
        Container row31 = new Container();
        row31.setLayout(new FlowLayout());
        staffName  = new JLabel("staff name");
        row31.add(staffName);

        Container row32 = new Container();
        row32.setLayout(new FlowLayout());
        staffNameT = new JTextField(10);
        row32.add(staffNameT);
        
        Container row33 = new Container();
        row33.setLayout(new FlowLayout());
        appointedBy = new JLabel("Appointed By");
        row33.add(appointedBy);
        
        Container row34 = new Container();
        row34.setLayout(new FlowLayout());
        appointedByT = new JTextField(10);
        row34.add(appointedByT);
        
        Container row41 = new Container();
        row41.setLayout(new FlowLayout());
        qualification = new JLabel ("Qualificaton");
        row41.add(qualification);
        
        Container row42 = new Container();
        row42.setLayout(new FlowLayout());
        qualificationT = new JTextField(10);
        row42.add(qualificationT);
        
        Container row43 = new Container();
        row43.setLayout(new FlowLayout());
        salary = new JLabel ("Salary");
        row43.add(salary);
        
        Container row44 = new Container();
        row44.setLayout(new FlowLayout());
        salaryT = new JTextField(10);
        row44.add(salaryT);
        
        Container row51 = new Container();
        Container row52 = new Container();
        Container row53 = new Container();
        Container row54 = new Container();
        row54.setLayout(new FlowLayout());
        joined = new JLabel("Joined");
        row54.add(joined);
        
        Container row61 = new Container();
        row61.setLayout(new FlowLayout());
        weeklyFractionalHour = new JLabel ("Weekly Fractional Hour");
        row61.add(weeklyFractionalHour);

        Container row62 = new Container();
        row62.setLayout(new FlowLayout());
        weeklyFractionalHourT = new JTextField(10);
        row62.add(weeklyFractionalHourT);
        
        Container row63 = new Container();
        row63.setLayout(new FlowLayout());
        workingHours = new JLabel ("Working Hours");
        row63.add(workingHours);
        
        Container row64 = new Container();
        row64.setLayout(new FlowLayout());
        workingHoursT = new JTextField(10);
        row64.add(workingHoursT);
        
        Container row71 = new Container();
        row71.setLayout(new FlowLayout());
        wagesPerHour = new JLabel("Wages per hour");
        row71.add(wagesPerHour);
        
        Container row72 = new Container();
        row72.setLayout(new FlowLayout());
        wagesPerHourT = new JTextField(10);
        row72.add(wagesPerHourT);
        
        Container row73 = new Container();
        row73.setLayout(new FlowLayout());
        shifts = new JLabel("Shifts");
        row73.add(shifts);
        
        Container row74 = new Container();
        row74.setLayout(new FlowLayout());
        shiftsT = new JTextField(10);
        row74.add(shiftsT);
        
        Container row81 = new Container();
        Container row82 = new Container();
        Container row83 = new Container();
        Container row84 = new Container();
        
        Container row91 = new Container();
        row91.setLayout(new FlowLayout());
        addFullTimeStaff = new JButton("Add Fulltime Staff");
        row91.add(addFullTimeStaff);
        
        Container row92 = new Container();
        row92.setLayout(new FlowLayout());
        addPartTimeStaff = new JButton("Add Parttime Staff");
        row92.add(addPartTimeStaff);
        
        Container row93 = new Container();
        row93.setLayout(new FlowLayout());
        addSalary = new JButton("Add Salary");
        row93.add(addSalary);
        
        Container row94 = new Container();
        row94.setLayout(new FlowLayout());
        addShift = new JButton("Add Working Shifts");
        row94.add(addShift);
        
        Container row01 = new Container();
        Container row02 = new Container();
        row02.setLayout(new FlowLayout());
        terminate = new JButton("Terminate");
        row02.add(terminate);
        
        Container row03 = new Container();
        Container row04 = new Container();
        
        
        Container row1 = new Container();
        row1.setLayout(new FlowLayout());
        displayNumber = new JLabel("display Number:");
        row1.add(displayNumber);
        
        Container row2 = new Container();
        row2.setLayout(new FlowLayout());
        displayNumberT = new JTextField(10);
        row2.add(displayNumberT);
        
        Container row3 = new Container();
        row3.setLayout(new FlowLayout());
        displayNumberB = new JButton("display Number");
        row3.add(displayNumberB);
        
        Container row4 = new Container();
        
        
        contentPane.add(row11);
        contentPane.add(row12);
        contentPane.add(row13);
        contentPane.add(row14);
        contentPane.add(row21);
        contentPane.add(row22);
        contentPane.add(row23);
        contentPane.add(row24);
        contentPane.add(row31);
        contentPane.add(row32);
        contentPane.add(row33);
        contentPane.add(row34);
        contentPane.add(row41);
        contentPane.add(row42);
        contentPane.add(row43);
        contentPane.add(row44);
        contentPane.add(row51);
        contentPane.add(row52);
        contentPane.add(row53);
        contentPane.add(row54);
        contentPane.add(row61);
        contentPane.add(row62);
        contentPane.add(row63);
        contentPane.add(row64);
        contentPane.add(row71);
        contentPane.add(row72);
        contentPane.add(row73);
        contentPane.add(row74);
        contentPane.add(row81);
        contentPane.add(row82);
        contentPane.add(row83);
        contentPane.add(row84);
        contentPane.add(row91);
        contentPane.add(row92);
        contentPane.add(row93);
        contentPane.add(row94);
        contentPane.add(row01);
        contentPane.add(row02);
        contentPane.add(row03);
        contentPane.add(row04);
        contentPane.add(row1);
        contentPane.add(row2);
        contentPane.add(row3);
        contentPane.add(row4);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        staffHiring_GUI GUI = new staffHiring_GUI();
    }
    
    public void actionPerformed(ActionEvent event)
    {
        
    }
}