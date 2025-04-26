package al.sda.Entities;
import java.util.ArrayList;
import java.util.List;
public class Client {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role; // gjithmonë "client"
    private List<String> reservationIds;
    public Client(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "client";
        this.reservationIds = new ArrayList<>();
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
    public List<String> getReservationIds() {
        return reservationIds;
    }
    public void setReservationIds(List<String> reservationIds) {
        this.reservationIds = reservationIds;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", reservationIds=" + reservationIds +
                '}';
    }
}



