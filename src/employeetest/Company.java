package employeetest;

import java.util.ArrayList;
import java.util.Iterator;

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
    
    // find in the staff arraylist all employees above a given employee number value and print the names of these employees
    public void listEmployees(int employeeNumber) {
        Iterator<Employee> iterator = staff.iterator();
        
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpNum() > employeeNumber) {
                System.out.printf("ID: %d - %s\n", employee.getEmpNum(), employee.getName());
            }
        }
    }
    
    // remove an employee (ID given as parameter) from the staff arrayist
    public boolean removeStaff(int empNum) {
        Iterator<Employee> iterator = staff.iterator();
        
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpNum() == empNum) {
                iterator.remove();
                return true;
            }
        }
        
        return false;
    }
}
