package al.sda.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role; // gjithmonë "client"
//    private List<Long> reservationIds;
    public Client(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "client";
//        this.reservationIds = new ArrayList<>();
    }

    public Client() {

    }

    // Getters dhe Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
//    public List<Long> getReservationIds() {
//        return reservationIds;
//    }
//    public void setReservationIds(List<Long> reservationIds) {
//        this.reservationIds = reservationIds;
//    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
//                ", reservationIds=" + reservationIds +
                '}';
    }
}



