import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int age;
    private String department;
    private String username;
    private String password;

    public Employee(int id, String name, int age, String department, String username, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.username = username;
        this.password = password;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Employee [ID=" + id + ", Name=" + name + ", Age=" + age + ", Department=" + department + "]";
    }
}
