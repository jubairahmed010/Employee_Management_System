
package Application;

import java.util.*;
import Application.src.*;

public class Main {
    public static ArrayList<Employee> employees = new ArrayList<Employee>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
     while(true){
        System.out.println("\n=== MENU ===");
        System.out.println("1. Add Full time employee");
        System.out.println("2. Add Part Time employees");
        System.out.println("3. Print Employee details");
        System.out.println("4. Print Employees by birth year");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Print age of every employees");
        System.out.println("7. Get total salary given to the employees ");
        System.out.println("8. Remove a full time employee");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addFullTimeEmpployee();
                break;
            case 2:
                AddPartTimeEmployee();
                break;
            case 3:
                printEmployeeDetails();
                break;
            case 4:
                printEmployeesByBirthYear();
                break;
            case 5:
                employeeBySalary();
                break;
            case 6:
                printAgeOfEmployees();
                break;
            case 7:
                getTotalSalary();
                break;
            case 8:
                removeEmployee();
                break;
            case 9:
                exit();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
        
            
    }
    }

    public static void addFullTimeEmpployee() {
        for (int i = 0; i < 3; i++) {

            System.out.println("Enter employee id,name,Birth date,month,year and salary ");
            int id = scanner.nextInt();
            scanner.nextLine();
            String name = scanner.nextLine();
            int day = scanner.nextInt();

            int month = scanner.nextInt();
            int year = scanner.nextInt();
            double salary = scanner.nextDouble();
            boolean idExists = false;
            for (Employee e : employees) {
                if (e.getId() == id) {
                    System.out.println("An employee with the same ID already exists. Please enter a unique ID.");
                    idExists = true;
                    break;
                }
            }
            if (idExists) {
                i--; // decrementing the loop variable to retry creating this employee
                continue;
            }
            FulltimeEmployee employee = new FulltimeEmployee(name, id, day, month, year, salary);
            employees.add(employee);
            System.out.println("FulltimeEmployee created successfully.");
        }

    }

    public static void AddPartTimeEmployee() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter employee id,name,Birth date,month,year hourly rate and hours ");
            int id = scanner.nextInt();
            scanner.nextLine();
            String name = scanner.nextLine();
            int day = scanner.nextInt();

            int month = scanner.nextInt();
            int year = scanner.nextInt();
            double hourlyRate = scanner.nextDouble();
            double hours = scanner.nextDouble();
            boolean idExists = false;
            for (Employee e : employees) {
                if (e.getId() == id) {
                    System.out.println("An employee with the same ID already exists. Please enter a unique ID.");
                    idExists = true;
                    break;
                }
            }
            if (idExists) {
                i--; // decrementing the loop variable to retry creating this employee
                continue;
            }

            ParttimeEmployee employee = new ParttimeEmployee(name, id, day, month, year, hours, hourlyRate);

            employees.add(employee);
            System.out.println("ParttimeEmployee created successfully.");
        }
    }

    public static void printEmployeeDetails() {
        System.out.println("\nEmployee Details: ");
        for (Employee emp : employees) {
            System.out.println("\n--------------------------");
            if (emp instanceof FulltimeEmployee) {
                System.out.println("Fulltime Employee");
            } else if (emp instanceof ParttimeEmployee) {
                System.out.println("Parttime Employee");
            }
            System.out.println("ID: " + emp.getId());
            System.out.println("Name: " + emp.getName());
            System.out.println("Date of Birth: " + emp.getDateOfBirth().get(Calendar.DATE) + "/"
                    + (emp.getDateOfBirth().get(Calendar.MONTH) + 1) + "/"
                    + emp.getDateOfBirth().get(Calendar.YEAR));
            System.out.println("Salary: " + emp.getSalary());
            System.out.println("--------------------------\n");
        }

    }

    public static void printEmployeesByBirthYear() {
        System.out.println(" Enter age to search ");
        int year = scanner.nextInt();
        System.out.println("Employees born in " + year + ":");
        for (Employee emp : employees) {
            Calendar cal = emp.getDateOfBirth();
            if (cal.get(Calendar.YEAR) == year) {
                if (emp instanceof FulltimeEmployee) {
                    System.out.print("Fulltime ");
                } else if (emp instanceof ParttimeEmployee) {
                    System.out.print("Parttime ");
                }
                System.out.println("Employee: " + emp.getName() + ", ID: " + emp.getId() + ", Date of Birth: "
                        + cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/"
                        + cal.get(Calendar.YEAR)
                        + ", Salary: " + emp.getSalary());
            }
        }
    }

    public static void employeeBySalary() {
        Collections.sort(employees);
        for (Employee emp : employees)
            System.out.println(emp.toString());

    }

    public static void printAgeOfEmployees() {

        for (Employee emp : employees) {
            int age = emp.getAge();
            System.out.println(age);

        }

    }

    public static void getTotalSalary() {
        double totalSalary = 0.0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        System.out.println("Total salary given to the employees:" + totalSalary);
    }

    public static void removeEmployee() {
    
        System.out.print("Enter the ID of the employee to be removed: ");
        int id = scanner.nextInt();
        boolean removed = false;
        for (Employee emp: employees) {
            if(emp instanceof FulltimeEmployee){
            if (emp.getId()==id) {
                employees.remove(emp);
                System.out.println("Employee with ID " + id + " has been removed.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("No employee with ID " + id + " was found.");
        }
    }
}

    public static void exit() {
        System.out.println("Exiting the program. Thank you!");
        System.exit(0);
    }
}
