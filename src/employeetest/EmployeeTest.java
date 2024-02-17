package employeetest;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee1 = new  Employee("Joe Bloggs", "jb@gmail.com");
        Employee employee2 = new  Employee("Ann Banana", "ab@gmail.com");
        Employee employee3 = new  Employee("Tom Thumb", "tt@gmail.com");
        
        Employee[] projectGroup = new Employee[3];
        
        projectGroup[0] = employee1;
        projectGroup[1] = employee2;
        projectGroup[2] = employee3;
        
        System.out.println(Employee.getNextEmpNum());
        
        int m = 1;
        for (Employee e : projectGroup) {
            if (e.getEmpNum() > m) {
                System.out.println(e.getName());
            }
        }
        
        Company company = new Company("Business Gnómes Ltd");
        Manager manager = new Manager("Tim Apple", "tim.apple@gnomes.com", "Gnomeo", "smurf");
        Menu menu = new Menu(company, manager);
    }
    
}
