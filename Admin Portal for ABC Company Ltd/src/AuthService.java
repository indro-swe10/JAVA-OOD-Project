public interface AuthService {
    boolean login(String username, String password);
    void logout();
    boolean isAuthenticated();
    Employee getLoggedInEmployee();
    boolean register(Employee employee);
}
