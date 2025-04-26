package al.sda.Dao;

import al.sda.Entities.Apartment;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO {
    private List<Apartment> apartments = new ArrayList<>();

    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
    }

    public Apartment findApartmentById(String id) {
        for (Apartment a : apartments) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public List<Apartment> getAllApartments() {
        return apartments;
    }

    public void removeApartment(String apartmentId) {
        Apartment apartmentToRemove = findApartmentById(apartmentId);
        if (apartmentToRemove != null) {
            apartments.remove(apartmentToRemove);
            System.out.println("Apartment with ID " + apartmentId + " removed successfully.");
        } else {
            System.out.println("Apartment with ID " + apartmentId + " not found.");
        }
    }
}













