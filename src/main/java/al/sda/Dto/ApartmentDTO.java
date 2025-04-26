package al.sda.Dto;

public class ApartmentDTO {
    private String name;
    private String location;
    private double pricePerNight;

    public ApartmentDTO() {}

    public ApartmentDTO(String name, String location, double pricePerNight) {
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "ApartmentDTO{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
}

