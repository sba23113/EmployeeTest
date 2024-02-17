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
            System.out.println("****************************************************************************");
            System.out.println("Employee Management System for People Managers");
            System.out.println("****************************************************************************");
            System.out.println("1) Login");
            System.out.println("0) Exit");
            System.out.println("");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            // consume any newline characters left in scanner buffer
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (username.equals(manager.getUsername()) && password.equals(manager.getPassword())) {
                    System.out.println("");
                    System.out.printf("Welcome %s! \n", manager.getName());
                    while (true) {
                        System.out.println("");
                        System.out.println("****************************************************************************");
                        System.out.printf("Staff Administration (Logged in as '%s') \n", username);
                        System.out.println("****************************************************************************");
                        System.out.println("1) View staff");
                        System.out.println("2) Add new member of staff");
                        System.out.println("3) Remove member of staff");
                        System.out.println("0) Logout");
                        System.out.println("");
                        System.out.print("Enter your choice: ");
                        int managerChoice = scanner.nextInt();
                        System.out.println("");
                        // consume any newline characters left in scanner buffer
                        scanner.nextLine();

                        if (managerChoice == 1) {
                            System.out.println("Current employees:");
                            company.listEmployees(0);
                        } else if (managerChoice == 2) {
                            System.out.println("Add new employee's details:");
                            System.out.print("Enter employee's name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter employee's email: ");
                            String email = scanner.nextLine();
                            Employee newEmp = new Employee(name, email);
                            company.addNewStaff(newEmp);
                        } else if (managerChoice == 3) {
                            System.out.println("3");
                        } else if (managerChoice == 0) {
                            break;
                        }
                    }
                } else {
                    System.out.println("");
                    System.out.println("!! Invalid username or password !!");
                }
            } else if (choice == 0) {
                break;
            }
        }
    }
}
