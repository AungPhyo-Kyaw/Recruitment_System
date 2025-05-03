/*
 * Class: PartTimeStaffHire
 *
 * This class represents a part-time staff member.
 * It extends the base class 'Staff_hire' and adds attributes and methods
 * specific to part-time employment such as working hours, wages, shift type,
 * and termination status.
 */
public class PartTimeStaffHire extends Staff_Hire
{
    // Declaring fields specific to part time staff
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean Terminated;
    
    /*
     * Constructor: PartTimeStaffHire
     * 
     * Initializes a new part-time staff object by setting both inherited
     * and specific fields. The 'Terminated' flag is set to false by default.
     */
    public PartTimeStaffHire(int vacancyNumber, String Designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy,boolean Joined, int hour, double wages, String shifts)
    {
        super(vacancyNumber, Designation, jobType, staffName, joiningDate, qualification, appointedBy, Joined);
        this.workingHour = hour;
        this.wagesPerHour = wages;
        this.shifts = shifts;
        this.Terminated = false; //default value for terminated
    }
    
    /* 
     * Getter method for working hours, wagePerHour, shift, and termination
     * 
     * Return apporiate information
     */

    public int getWorkingHour()
    {
        return workingHour;// Returns how many hours the staff works
    }
    
    public double getWagesPerHour()
    {
        return wagesPerHour;// Returns wage rate of staff
    }
    
    public String getShifts()
    {
        return shifts;// Returns current shift (e.g., morning, evening)
    } 
    
    public boolean getTermination()
    {
        return Terminated;// Returns true if the staff has been terminated
    }
    
    /*
     * Setter method to update working hours,wagesPerHour, and shift
     * 
     * update new informations of the staff
     */
    public void setWorkingHour(int workingHour)
    {
        this.workingHour = workingHour;
    }
    public void setWagesPerHour(double wagesPerHour)
    {
        this.wagesPerHour = wagesPerHour;
    }
    public void setShift(String shift)
    {
        this.shifts = shift;// Updates shift type
    }
    
   /*
     * Method: Fired
     * -------------
     * Terminates the part-time staff member.
     * If already terminated, prints a message.
     * If not, sets Terminated to true and clears staff data from parent class.
     */
    public void Fired()
    {
        if (Terminated == true)
         System.out.println("The staff is already terminated" );
         
        else{
         Terminated = true;// Mark as terminated
         super.clearInfo();// Clear staff details from parent class
         System.out.println("The staff has been terminated");
        }
    }
    
    /*
     * Method: PartTimeStaff_details
     * 
     * Displays detailed information of the part-time staff member,
     * including inherited and its own attributes.
     */
    public void PartTimeStaff_details()
    {
        System.out.println("Status                  : Part Time");
        super.printStaffInfo();// Print common info from parent
        System.out.println("Working hour            : "+ workingHour);
        System.out.println("Wages per hour          : "+ wagesPerHour);
        System.out.println("working shift           : "+ shifts);
        System.out.println("***********************************");
    }
    
}