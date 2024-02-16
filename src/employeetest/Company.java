package employeetest;

import java.util.ArrayList;

public class Company {
    private String companyName;
    private ArrayList<Employee> staff;

    public Company() {
        this.companyName = "company";
        this.staff = new ArrayList<>();
    }

    public Company(String companyName) {
        this.companyName = companyName;
        this.staff = new ArrayList<>();
    }  
    
    public void addNewStaff(Employee employee) {
        staff.add(employee);
    }
    
    public int getStaffNumber() {
        return staff.size();
    }
}
