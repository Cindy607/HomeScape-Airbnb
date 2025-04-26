package al.sda.Functionalities;

import al.sda.Entities.Host;
import al.sda.Entities.Apartment;
import al.sda.Entities.Reservation;
import java.util.ArrayList;
import java.util.List;

public class HostFunctionalities {
    private Host host;
    private List<Apartment> apartments;
    private List<Reservation> reservations;
    public HostFunctionalities(Host host) {
        this.host = host;
        this.apartments = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }
    public void addApartment(Apartment apartment) {
        apartments.add(apartment);
//        host.getPropertyIds().add(apartment.getId());
    }
    public void removeApartment(String apartmentId) {
        apartments.removeIf(a -> a.getId().equals(apartmentId));
//        host.getPropertyIds().remove(apartmentId);
    }
    public void showApartments() {
        if (apartments.isEmpty()) {
            System.out.println("You have no apartments yet.");
            return;
        }
        System.out.println("Your apartments:");
        for (Apartment a : apartments) {
            System.out.println(a);
        }
    }
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
    public void showReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        System.out.println("Reservations for your apartments:");
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }
    public List<Apartment> getApartments() {
        return apartments;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }
}












