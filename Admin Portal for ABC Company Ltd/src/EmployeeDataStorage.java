import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataStorage {

    private static final String FILE_NAME = "employees.dat";

    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employee data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving employee data: " + e.getMessage());
        }
    }

    public static List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employee data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Employee data file not found. Starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employee data: " + e.getMessage());
        }
        return employees;
    }
}
