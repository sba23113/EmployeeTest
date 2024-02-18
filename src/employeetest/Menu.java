package employeetest;

import java.util.InputMismatchException;
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
        boolean isRunning = true;
        while (isRunning) {
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
                
                if (username.equals(manager.getUsername()) && password.equals(manager.getPassword())) {
                    System.out.println("");
                    System.out.printf("Welcome %s! \n", manager.getName());
                    
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
                                System.out.println("***Current employees***");
                                company.listEmployees(0);
                                break;
                            case 2:
                                addNewStaff();
                                break;
                            case 3:
                                removeStaff();
                                break;
                            case 0:
                                System.out.println("You have been logged out!");
                                isManagerLoggedIn = false;
                                break; 
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    }
                } else {
                    System.out.println("");
                    System.out.println("!! Invalid username or password !!");
                }
            } else if (choice == 0) {
                isRunning = false;
            }            
        }
    }
    
    private void addNewStaff() {
        System.out.println("***Add new employee details***");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();        
        System.out.print("Enter employee email: ");
        String email = scanner.nextLine();
        
        Employee newEmp = new Employee(name, email);
        this.company.addNewStaff(newEmp);
        
        System.out.printf("%s added to employee database.\n", name);
    }
    
    private void removeStaff() {
        System.out.println("***Remove employee from database***");
        System.out.print("Enter ID of employee to be removed: ");
        int empNum = getIntInput();
        
        boolean isRemoved = company.removeStaff(empNum);
        
        if (isRemoved) {
            System.out.printf("Employee ID '%d' removed from employee database.\n", empNum);
        } else {
            System.out.printf("Employee ID '%d' not found.\n", empNum);
        }
    }
    
    private int getIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                // consume any newline characters left in scanner buffer
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number!");
                // Consume the invalid input
                scanner.nextLine();
            }
        }
    }
}
