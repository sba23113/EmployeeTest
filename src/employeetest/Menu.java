package employeetest;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Company company;
    private Manager manager;
  
    public Menu(Company company, Manager manager) {
        this.scanner = new Scanner(System.in);
        this.company = company;
        this.manager = manager;
    }
}
