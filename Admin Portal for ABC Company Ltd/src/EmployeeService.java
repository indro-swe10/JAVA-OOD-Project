import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    List<Employee> searchEmployeesByName(String name);
    List<Employee> getEmployeesByDepartment(String department);
    void saveData();
    void loadData();
}
