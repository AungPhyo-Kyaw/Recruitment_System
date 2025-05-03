/*
 * Class: Staff_hire
 * 
 * This class represents a general staff member and stores core information
 * such as vacancy details, personal attributes, and hiring status.
 * It serves as a superclass for specific types of staff: full time and part time.
 */
public class Staff_Hire
{
    //Declaring private fields to store staff data
    private int vacancyNumber;
    private String designation;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined ;
    
    /*
     * Constructor: Staff_hire
     * 
     * Initializes all fields of a staff hire object with values passed as arguments.
     */
    public Staff_Hire(int Vacancy_Number, String Designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined)
    {
        this.vacancyNumber = Vacancy_Number;
        this.designation    = Designation;
        this.jobType        = jobType;
        this.staffName      = staffName;
        this.joiningDate    = joiningDate;
        this.qualification  = qualification;
        this.appointedBy    = appointedBy;
        this.joined         = joined;
    }
    
    /*
     * Getter methods for each attribute
     * 
     * Return information for each method
     */
    public int getVacancyNo()
    {
        return vacancyNumber; //getter method for vacancy number
    }
    
    public String getDesignation()
    {
        return designation;//getter method for designation
    }
    
    public String getJobType()
    {
        return jobType;//getter method for job type
    }
    
    public String getStaffName()
    {
        return staffName;//getter method for staff name
    }
    
    public String getJoiningDate()
    {
        return joiningDate;//getter method for joining date
    }
    
    public String getQualification()
    {
        return qualification;//getter method for qualification of the staff
    }
    
    public String getAppointedBy()
    {
        return appointedBy;//getter method for name of the staff who appointed 
    }
    
    public boolean getJoined()
    {
        return joined;//getter method for whwther the staff joined or not
    }
    
    /*
     * Setter methods for each attribute
     * 
     * Update new input as the staff' s information
     * 
     */
    public void changeVacancyNo(int vacancy)
    {
        this.vacancyNumber = vacancy;//setter method for unique vacancy number
    }
    
    public void changeDesignation(String designation)
    {
        this.designation = designation;//setter method to change designation
    }
    public void changeJobType(String jobType)
    {
        this.jobType = jobType; //setter method to change jobe type
    }
    public void changeStaffName(String name)
    {
        this.staffName = name;//setter method to change the name of the staff
    }
    
    public void changeJoiningDate(String date)
    {
        this.joiningDate = date;//setter method to change the joining date
    }
    
    public void changeQualification(String Qualification)
    {
        this.qualification = Qualification;//setter method to change the qualification
    }
    
    public void changeAppointedBy(String appointedBy)
    {
        this.appointedBy = appointedBy;//setter method to change the appointedBy name
    }
    
    public void Hired(boolean joined)
    {
        this.joined = joined;//setter method to change status of the application
    }
    /*
     * Method: printStaffInfo
     * 
     * Prints all available information about the staff member.
     * Indicates whether the staff has joined or not.
     */
    public void printStaffInfo()
    {
        System.out.println("Vacancy number is       : " + vacancyNumber );
        System.out.print("Staff name              : "   + staffName);
        if (joined)
            System.out.println("  (joined)");
        else if (!joined)
            System.out.println("  (not joined yet)");
        System.out.println("Designation             : " + designation);
        System.out.println("Qualification           : " + qualification);
        System.out.println("Job type                : " + jobType );
        System.out.println("Date of join            : " + joiningDate);
        System.out.println("Appointed by            : " + appointedBy);
        
    }
    /*
     * Method to reset all staff information
     * 
     * will be used when part time staff is terminated
     */
    public void clearInfo()
    {
        this.designation    = "";
        this.jobType        = "";
        this.staffName      = "";
        this.joiningDate    = "";
        this.qualification  = "";
        this.appointedBy    = "";

    }
    
}
