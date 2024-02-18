package employeetest;

public class Employee {
    private String name;
    private String email;
    private int empNum;
    private static int nextEmpNum = 1;

    public Employee() {
        this.name = "John Doe";
        this.email = "john.doe@gnomes.com";
        this.empNum = nextEmpNum++;
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.empNum = nextEmpNum++;
    }    

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getEmpNum() {
        return empNum;
    }
    
    public void setEmail(String email) {
        if (email.length() > 3) {
            this.email = email;
        }
    }
    
    public static int getNextEmpNum() {
        return nextEmpNum;
    }
}
