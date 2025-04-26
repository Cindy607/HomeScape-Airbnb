package al.sda.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @Column
        private String name;
    @Column
        private String location;
    @Column
        private double pricePerNight;

    private Long hostId;


    public Apartment(String name, String location, double pricePerNight, Long hostId) {
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.hostId = hostId;
    }

    public Apartment() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", hostId='" + hostId + '\'' +
                '}';
    }
}
