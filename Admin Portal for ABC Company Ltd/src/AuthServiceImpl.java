import java.util.List;

public class AuthServiceImpl implements AuthService {
    private List<Employee> employees;
    private Employee loggedInEmployee = null;

    public AuthServiceImpl(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean login(String username, String password) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username) && employee.getPassword().equals(password)) {
                loggedInEmployee = employee;
                System.out.println("Login successful for user: " + username);
                return true;
            }
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    @Override
    public void logout() {
        if (loggedInEmployee != null) {
            System.out.println("Logout successful for user: " + loggedInEmployee.getUsername());
            loggedInEmployee = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    @Override
    public boolean isAuthenticated() {
        return loggedInEmployee != null;
    }

    @Override
    public Employee getLoggedInEmployee() {
        return loggedInEmployee;
    }

    @Override
    public boolean register(Employee employee) {
        for (Employee emp : employees) {
            if (emp.getUsername().equals(employee.getUsername())) {
                System.out.println("Username already exists. Please choose another username.");
                return false;
            }
        }
        employees.add(employee);
        System.out.println("Registration successful for user: " + employee.getUsername());
        return true;
    }
}
