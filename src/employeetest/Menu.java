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
    
    public void displayMenu() {
        while (true) {
            System.out.println("");
            System.out.println("****************************************************************************");
            System.out.println("Employee Management System for People Managers");
            System.out.println("****************************************************************************");
            System.out.println("1) Login");
            System.out.println("0) Exit");
            System.out.println("");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            System.out.println("");
            // consume any newline characters left in scanner buffer
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (username.equals(manager.getUsername()) && password.equals(manager.getPassword())) {
                    System.out.println("Logged in!");
                }
            } else if (choice == 0) {
                break;
            }
        }
    }
}
