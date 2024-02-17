package employeetest;

public class Manager extends Employee {
    private String username;
    private String password;

    public Manager(String username, String password, String name, String email) {
        super(name, email);
        this.username = username;
        this.password = password;
    }
    
    
}
