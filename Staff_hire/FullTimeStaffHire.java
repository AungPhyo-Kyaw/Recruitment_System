/*
 * Class: FullTimeStaffHire
 *
 * This class represents a full-time staff member.
 * It extends the base class 'Staff_hire' and includes additional
 * attributes such as salary and weekly working hours.
 */
public class FullTimeStaffHire extends Staff_Hire
{
    // Declaring Fields specific to full time staff
    private double salary;
    private int weeklyFractionalHours;

    /*
     * Constructor: FullTimeStaffHire
     * 
     * initialize all the attributes of a full time staff
     */
    public FullTimeStaffHire(int vacancyNumber, String Designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy,boolean Joined, double salary, int weeklyFractionalHours)
    {
        super(vacancyNumber, Designation, jobType, staffName, joiningDate, qualification, appointedBy,Joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    /*
     * getter method for salary and weekly fractional hours
     * 
     * Return current salary and weekly Fractional hours
     */
    public double getSalary()
    {
        return salary; //Returns salary of staff
    }

    public int getWorkingHours()
    {
        return weeklyFractionalHours; //Returns weekly working hours 
    }

    /*
     * Setter method to update salary and weekly fractional hour
     * 
     * Check if staff has joined and updated the new input
     * Otherwise, display apporate message
     */
    public void setSalary(double salary)
    {
        // Can only update salary if the staff has already joined
        if (super.getJoined())
        {
            this.salary = salary;
            System.out.println("Salary updated for the staff");
        }
        else if (!super.getJoined())
            System.out.println("Staff hasn't hired yet");
    }

    public void setWorkingHours(int weeklyFractionalHours)
    {
        this.weeklyFractionalHours = weeklyFractionalHours;//Updates weekly working hour
    }

     /*
     * print method: FullTimeStaff_details
     * 
     * Prints the complete details of the full-time staff member,
     * including status, general staff info, salary, and working hours.
     */
    public void FullTimeStaff_details()
    {
        System.out.println("Status                  : Full Time");
        super.printStaffInfo();// Print general info from the parent class
        System.out.println("Salary                  : " + salary);
        System.out.println("Weekly fractional hours : " + weeklyFractionalHours);
        System.out.println("***********************************");
    }

}