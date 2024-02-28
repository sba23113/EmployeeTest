/*
Github repo:
https://github.com/sba23113/EmployeeTest
*/

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
        
        // print out the value of variable nextEmpNum to the terminal window. 
        System.out.println(Employee.getNextEmpNum());
        
        /* search and display the name of each of the employees in the projectGroup array,
            who have an employee number above the value stored in a variable called m.
        */
        int m = 1;
        for (Employee e : projectGroup) {
            if (e.getEmpNum() > m) {
                System.out.println(e.getName());
            }
        }
        
        // create an Instance of Company, Manager and Menu classes
        Company company = new Company("Business Gnómes Ltd");
        Manager manager = new Manager("Gnomeo Mountaindew", "gnomeo.mountaindew@gnomes.com", "Gnomeo", "smurf");
        Menu menu = new Menu(company, manager);        
        
        // launch menu in console
        menu.displayMenu();
    }    
}
