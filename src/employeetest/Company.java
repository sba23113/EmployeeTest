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
    
    public void listEmployees(int employeeNumber) {
        Iterator<Employee> iterator = staff.iterator();
        
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpNum() > employeeNumber) {
                System.out.println(employee.getName());
            }
        }
    }
    
    public void removeStaff(int empNum) {
        Iterator<Employee> iterator = staff.iterator();
        
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getEmpNum() == empNum) {
                iterator.remove();
                break;
            }
        }
    }
}
