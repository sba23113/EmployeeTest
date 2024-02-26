package employeetest;

public class Employee {
    private String name;
    private String email;
    private int empNum;
    private static int nextEmpNum = 1;
    private static final int emailMinLength = 3;
    private static final int emailMaxLength = 320;

    public Employee() {
        this.name = "John Doe";
        this.email = "john.doe@gnomes.com";
        this.empNum = nextEmpNum++;
    }

    public Employee(String name, String email)  throws IllegalArgumentException {        
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("!!!Name cannot be empty!!!\n");
        }
        
        if (!isEmailAddressValid(email)) {
            throw new IllegalArgumentException("!!!Email format incorrect!!!\n");            
        }  
        
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
        this.email = email;
    }
    
    public static int getNextEmpNum() {
        return nextEmpNum;
    }
    
    /*
    email validation regex pattern based on RFC 5322 format sourced from:
    https://emailregex.com
    */
    private boolean isEmailAddressValid(String email) {
        if (email.length() <= emailMinLength || email.length() > emailMaxLength) {
            return false;
        } else if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            return true;
        }
        
        return false;
   }
}
