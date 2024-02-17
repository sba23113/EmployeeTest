package employeetest;

public class Manager extends Employee {
    private String username;
    private String password;

    public Manager(String username, String password, String name, String email) {
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
