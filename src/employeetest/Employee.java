package employeetest;

public class Employee {
    private String name;
    private String email;
    private int empNum;

    public Employee(int empNum) {
        this.name = "John Doe";
        this.email = "john.doe@email.com";
        this.empNum = empNum;
    }

    public Employee(String name, String email, int empNum) {
        this.name = name;
        this.email = email;
        this.empNum = empNum;
    }    
}
