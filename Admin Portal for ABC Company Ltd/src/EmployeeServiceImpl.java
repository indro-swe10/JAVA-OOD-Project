import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added: " + employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee existingEmployee = getEmployeeById(employee.getId());
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setUsername(employee.getUsername());
            existingEmployee.setPassword(employee.getPassword());
            System.out.println("Employee updated: " + existingEmployee);
        } else {
            System.out.println("Employee not found with ID: " + employee.getId());
        }
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted with ID: " + id);
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public List<Employee> searchEmployeesByName(String name) {
        return employees.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    @Override
    public void saveData() {
        EmployeeDataStorage.saveEmployees(employees);
    }

    @Override
    public void loadData() {
        employees = EmployeeDataStorage.loadEmployees();
    }
}
