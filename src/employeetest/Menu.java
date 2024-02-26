package employeetest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final Company company;
    private final Manager manager;
  
    public Menu(Company company, Manager manager) {
        this.scanner = new Scanner(System.in);
        this.company = company;
        this.manager = manager;
    }
    
    public void displayMenu() {
        boolean isRunning = true;
        while (isRunning) {
            // manager login menu
            System.out.println("");
            System.out.println("****************************************************************************");
            System.out.println("Employee Management System for People Managers");
            System.out.println("****************************************************************************");
            System.out.println("1) Login");
            System.out.println("0) Exit");
            System.out.println("");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                
                // check if username and password are valid
                if (username.equals(manager.getUsername()) && password.equals(manager.getPassword())) {
                    System.out.println("");
                    System.out.printf("Welcome %s! \n", manager.getName());
                    
                    // employee administration menu
                    boolean isManagerLoggedIn = true;
                    while (isManagerLoggedIn) {
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
                        int managerChoice = getIntInput();

                        switch (managerChoice) {
                            case 1:
                                System.out.println("");
                                System.out.println("***List of employees***");
                                company.listEmployees(0);
                                break;
                            case 2:
                                addNewStaff();
                                break;
                            case 3:
                                removeStaff();
                                break;
                            case 0:
                                // log out if '0' entered by user
                                System.out.println("***You have been logged out***");
                                isManagerLoggedIn = false;
                                break; 
                            default:
                                System.out.println("!!!Invalid choice!!!");
                        }
                    }
                } else {
                    System.out.println("");
                    System.out.println("!!!Invalid username or password!!!");
                }
            } else if (choice == 0) {
                isRunning = false;
            }            
        }
    }
    
    // add staff to company staff arraylist
    private void addNewStaff() {
        System.out.println("");
        System.out.println("***Add new employee details***");
        
        while (true) {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            System.out.print("Enter employee email: ");
            String email = scanner.nextLine();

            // try and create employee object -> if invalid name or email print out error message
            try {
                Employee newEmp = new Employee(name, email);
                this.company.addNewStaff(newEmp);
                System.out.println("");
                System.out.printf("%s added to employee database.\n", name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    // remove employee from company staff arraylist
    private void removeStaff() {
        System.out.println("");
        System.out.println("***Remove employee from database***");
        System.out.print("Enter ID of employee to be removed: ");
        int empNum = getIntInput();
        
        // get result of removeStaff method and print relevant message to console
        boolean isRemoved = company.removeStaff(empNum);
        
        if (isRemoved) {
            System.out.printf("Employee ID '%d' removed from database.\n", empNum);
        } else {
            System.out.printf("!!!Employee ID '%d' not found!!!\n", empNum);
        }
    }
    
    // get input from console
    private int getIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                // consume any newline characters left in scanner buffer
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("!!!Invalid input. Please enter a number!!!");
                // consume the invalid input
                scanner.nextLine();
            }
        }
    }    
}
