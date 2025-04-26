package al.sda.Service;
import al.sda.Dao.ApartmentDAO;
import al.sda.Dao.ReservationDAO;
import al.sda.Entities.Apartment;
import al.sda.Entities.Host;
import al.sda.Entities.Reservation;
import java.time.LocalDate;
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
        Apartment apartment = new Apartment(apartmentId, name, location, pricePerNight, host.getId());
        apartmentDAO.addApartment(apartment);
        host.getPropertyIds().add(apartmentId);
        System.out.println("Apartment added successfully: " + name);
    }
    // Hosti fshin një apartament që i përket atij
    public void removeApartment(Host host, String apartmentId) {
        if (!host.getPropertyIds().contains(apartmentId)) {
            System.out.println("Apartment not found in your list!");
            return;
        }
        apartmentDAO.removeApartment(apartmentId);
        host.getPropertyIds().remove(apartmentId);
        System.out.println("Apartment removed successfully: " + apartmentId);
    }
    // Hosti shikon të gjitha apartamentet që ka
    public void viewOwnApartments(Host host) {
        List<String> propertyIds = host.getPropertyIds();
        if (propertyIds.isEmpty()) {
            System.out.println("You have no apartments yet.");
            return;
        }
        System.out.println("Your apartments:");
        for (String apartmentId : propertyIds) {
            Apartment apartment = apartmentDAO.findApartmentById(apartmentId);
            if (apartment != null) {
                System.out.println(apartment);
            }
        }
    }
    // Hosti shikon rezervimet për apartamentet e tij
    public void viewReservationsForMyApartments(Host host) {
        List<String> propertyIds = host.getPropertyIds();
        if (propertyIds.isEmpty()) {
            System.out.println("You have no apartments, thus no reservations.");
            return;
        }
        List<Reservation> allReservations = reservationDAO.getAllReservations();
        List<Reservation> reservationsForMyApartments = allReservations.stream()
                .filter(r -> propertyIds.contains(r.getPropertyId()))
                .collect(Collectors.toList());
        if (reservationsForMyApartments.isEmpty()) {
            System.out.println("No reservations found for your apartments.");
        } else {
            System.out.println("Reservations for your apartments:");
            for (Reservation r : reservationsForMyApartments) {
                System.out.println(r);
            }
        }
    }
    // Gjeneron një ID unike për apartamentin
    private String generateApartmentId() {
        return "A" + System.currentTimeMillis();
    }
}










