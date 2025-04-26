package al.sda.Service;
import al.sda.Dao.ApartmentDAO;
import al.sda.Dao.ReservationDAO;
import al.sda.Entities.Apartment;
import al.sda.Entities.Host;
import al.sda.Entities.Reservation;
import java.util.List;
import java.util.stream.Collectors;
public class HostService {
    private ApartmentDAO apartmentDAO;
    private ReservationDAO reservationDAO;
    public HostService(ApartmentDAO apartmentDAO, ReservationDAO reservationDAO) {
        this.apartmentDAO = apartmentDAO;
        this.reservationDAO = reservationDAO;
    }
    // Hosti shton një apartament të ri
    public void addApartment(Host host, String name, String location, double pricePerNight) {
        String apartmentId = generateApartmentId();
        Apartment apartment = new Apartment(name, location, pricePerNight, host.getId());
        apartmentDAO.addApartment(apartment);
        System.out.println("Apartment added successfully: " + name);
    }
    // Hosti fshin një apartament të tij
    public void removeApartment(Host host, String apartmentId) {
        Apartment apartment = apartmentDAO.findApartmentById(apartmentId);
        if (apartment == null) {
            System.out.println("Apartment not found.");
            return;
        }
        if (!apartment.getHostId().equals(host.getId())) {
            System.out.println("You are not authorized to delete this apartment.");
            return;
        }
        apartmentDAO.removeApartment(apartmentId);
        System.out.println("Apartment removed successfully: " + apartmentId);
    }
    // Hosti sheh të gjitha apartamentet që ka
    public void viewOwnApartments(Host host) {
        List<Apartment> hostApartments = apartmentDAO.getAllApartments().stream()
                .filter(apartment -> apartment.getHostId().equals(host.getId()))
                .collect(Collectors.toList());
        if (hostApartments.isEmpty()) {
            System.out.println("You have no apartments yet.");
        } else {
            System.out.println("Your Apartments:");
            for (Apartment a : hostApartments) {
                System.out.println(a);
            }
        }
    }
    // Hosti sheh rezervimet për apartamentet e tij
    public void viewReservationsForMyApartments(Host host) {
        List<Apartment> hostApartments = apartmentDAO.getAllApartments().stream()
                .filter(apartment -> apartment.getHostId().equals(host.getId()))
                .collect(Collectors.toList());
        if (hostApartments.isEmpty()) {
            System.out.println("You have no apartments, thus no reservations.");
            return;
        }
        List<Long> hostApartmentIds = hostApartments.stream()
                .map(Apartment::getId)
                .collect(Collectors.toList());
        List<Reservation> reservationsForHost = reservationDAO.getAllReservations().stream()
                .filter(reservation -> hostApartmentIds.contains(reservation.getPropertyId()))
                .collect(Collectors.toList());
        if (reservationsForHost.isEmpty()) {
            System.out.println("No reservations found for your apartments.");
        } else {
            System.out.println("Reservations for your apartments:");
            for (Reservation r : reservationsForHost) {
                System.out.println(r);
            }
        }
    }
    // Private method për të gjeneruar ID unike
    private String generateApartmentId() {
        return "A" + System.currentTimeMillis();
    }
}











