package al.sda.Entities;
import java.util.ArrayList;
import java.util.List;
public class Host {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role; // gjithmonë "host"
    private List<String> propertyIds;
    public Host(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "host";
        this.propertyIds = new ArrayList<>();
    }
    // Getters dhe Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public List<String> getPropertyIds() {
        return propertyIds;
    }
    public void setPropertyIds(List<String> propertyIds) {
        this.propertyIds = propertyIds;
    }
    // Display info
    public void displayInfo() {
        System.out.println("Host ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
        System.out.println("Number of Properties: " + propertyIds.size());
        System.out.println("Properties: " + propertyIds);
    }
}








