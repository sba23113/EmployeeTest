package employeetest;

public class Manager extends Employee {
    private String username;
    private String password;

    // constuctor calls superclass (Employee) constructor and initializes username and password fields
    public Manager(String name, String email, String username, String password) {
        super(name, email);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
