import java.util.List;
import java.util.Scanner;

public class Main {
    private static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private static AuthService authService;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        employeeService.loadData();
        authService = new AuthServiceImpl(employeeService.getAllEmployees());

        while (true) {
            if (!authService.isAuthenticated()) {
                System.out.println();
                showLoginMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                switch (choice) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> {
                        employeeService.saveData();
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                System.out.println();
                showMainMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> updateEmployee();
                    case 3 -> deleteEmployee();
                    case 4 -> viewEmployee();
                    case 5 -> viewAllEmployees();
                    case 6 -> searchEmployeeByName();
                    case 7 -> viewEmployeesByDepartment();
                    case 8 -> {
                        employeeService.saveData();
                        System.out.println("Data saved and exiting...");
                        System.out.println();
                        System.exit(0);
                    }
                    case 9 -> logout();
                    default -> {
                        System.out.println("Invalid choice. Please try again.");
                        System.out.println();
                    }
                }
            }
        }
    }

    private static void showLoginMenu() {
        System.out.println("=== Admin Portal ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    private static void register() {
        System.out.println("=== Registration Menu ===");
        System.out.print("Enter Admin ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Admin Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Admin Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Admin Department: ");
        String department = scanner.nextLine();
        System.out.print("Set Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Set Admin Password: ");
        String password = scanner.nextLine();
        Employee employee = new Employee(id, name, age, department, username, password);
        if (authService.register(employee)) {
            employeeService.addEmployee(employee);
        }
    }

    private static void login() {
        System.out.println("=== Login Menu ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        authService.login(username, password);
    }

    private static void logout() {
        authService.logout();
        System.out.println("Successfully Logged Out...");
    }

    private static void showMainMenu() {
        System.out.println("=== Main Menu ===");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. View Employee by ID");
        System.out.println("5. View All Employees");
        System.out.println("6. Search Employees by Name");
        System.out.println("7. View Employees by Department");
        System.out.println("8. Save and Exit");
        System.out.println("9. Logout");
        System.out.println();
        System.out.print("Enter your choice: ");
    }

    private static void addEmployee() {
        System.out.println("=== Add Employee ===");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Employee Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Employee Password: ");
        String password = scanner.nextLine();
        Employee employee = new Employee(id, name, age, department, username, password);
        employeeService.addEmployee(employee);
    }

    private static void updateEmployee() {
        System.out.println("=== Update Employee ===");
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Employee Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Employee Password: ");
        String password = scanner.nextLine();
        Employee employee = new Employee(id, name, age, department, username, password);
        employeeService.updateEmployee(employee);
    }

    private static void deleteEmployee() {
        System.out.println("=== Delete Employee ===");
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        employeeService.deleteEmployee(id);
    }

    private static void viewEmployee() {
        System.out.println("=== Employee List by ID ===");
        System.out.print("Enter Employee ID to view: ");
        int id = scanner.nextInt();
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    private static void viewAllEmployees() {
        System.out.println("=== All Employee List ===");
        List<Employee> employees = employeeService.getAllEmployees();
        employees.forEach(System.out::println);
    }

    private static void searchEmployeeByName() {
        System.out.println("=== Employee list by Name ===");
        System.out.print("Enter Employee Name to search: ");
        String name = scanner.nextLine();
        List<Employee> employees = employeeService.searchEmployeesByName(name);
        employees.forEach(System.out::println);
    }

    private static void viewEmployeesByDepartment() {
        System.out.println("=== Employee List by Department ===");
        System.out.print("Enter Department to view employees: ");
        String department = scanner.nextLine();
        List<Employee> employees = employeeService.getEmployeesByDepartment(department);
        employees.forEach(System.out::println);
    }
}
