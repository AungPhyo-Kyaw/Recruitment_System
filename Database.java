import java.util.ArrayList;

public class Database
{
    private ArrayList<Staff_Hire> Staffes;
    
    public Database()
    {
        Staffes = new ArrayList<Staff_Hire>();
    }
    
    public void addStaff(Staff_Hire staff)
    {
        Staffes.add(staff);
    
    }
    
    public void staffList()
    {
        for(int i = 0; i < Staffes.size(); i++)
        
        {

            Staff_Hire staff = Staffes.get(i);
            if(staff instanceof FullTimeStaffHire)
            {
                System.out.println("You have a FullTime staff at index: " + i);
                FullTimeStaffHire staffs = (FullTimeStaffHire) staff; 
                staffs.printStaffInfo();
            } 
            else if(staff instanceof PartTimeStaffHire)
            {
                System.out.println("You have a policeman at index: " + i);
                PartTimeStaffHire staffs = (PartTimeStaffHire) staff; 
                staffs.PartTimeStaff_details();
                
            }
            
        }
    }
}