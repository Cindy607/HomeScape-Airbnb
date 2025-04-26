package al.sda.Service;
import al.sda.Dao.ApartmentDAO;
import al.sda.Dao.ReservationDAO;
import al.sda.Entities.Apartment;
import al.sda.Entities.Client;
import al.sda.Entities.Reservation;
import al.sda.Functionalities.ClientFunctionalities;
import al.sda.Service.ReceiptService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
public class ClientService {
    private ApartmentDAO apartmentDAO;
    private ReservationDAO reservationDAO;
    private ReceiptService receiptService;
    public ClientService(ApartmentDAO apartmentDAO, ReservationDAO reservationDAO, ReceiptService receiptService) {
        this.apartmentDAO = apartmentDAO;
        this.reservationDAO = reservationDAO;
        this.receiptService = receiptService;
    }
    // Search Apartments by location
    public void searchApartmentsByLocation(String location) {
        List<Apartment> apartments = apartmentDAO.getAllApartments().stream()
                .filter(a -> a.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
        if (apartments.isEmpty()) {
            System.out.println("No apartments found in this location.");
        } else {
            System.out.println("Apartments available in " + location + ":");
            for (Apartment a : apartments) {
                System.out.println(a);
            }
        }
    }
    // Make Reservation
    public void makeReservation(Client client, ClientFunctionalities clientFunc, Apartment apartment, LocalDate startDate, LocalDate endDate) {
        String reservationId = generateReservationId();
        Reservation reservation = new Reservation(reservationId, client.getId(), apartment.getId(), startDate, endDate, true);
        reservationDAO.addReservation(reservation); // ruajmë rezervimin në DAO
        client.getReservationIds().add(reservationId); // ruajmë ID-në në klient
        clientFunc.getReservations().add(reservation); // ruajmë rezervimin e plotë te ClientFunctionalities
        System.out.println("Reservation created successfully!");
        // Gjenero receipt automatikisht
        receiptService.generateReceipt(reservation, apartment);
    }
    // View Client Reservations
    public void viewMyReservations(Client client, ClientFunctionalities clientFunc) {
        List<Reservation> reservations = clientFunc.getReservations();
        if (reservations.isEmpty()) {
            System.out.println("You have no reservations yet.");
            return;
        }
        System.out.println("Your Reservations:");
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }
    // Cancel Reservation
    public void cancelReservation(Client client, ClientFunctionalities clientFunc, String reservationId) {
        List<Reservation> reservations = clientFunc.getReservations();
        boolean found = false;
        for (Reservation r : reservations) {
            if (r.getId().equals(reservationId)) {
                if (r.getClientId().equals(client.getId())) { // kontrollojmë që rezervimi është i klientit
                    if (r.getStatus()) { // nëse është aktive
                        r.setStatus(false); // bëhet e anuluar
                        Reservation realReservation = reservationDAO.findReservationById(reservationId);
                        if (realReservation != null) {
                            realReservation.setStatus(false); // përditësojmë edhe në DAO
                        }
                        System.out.println("Reservation cancelled successfully.");
                    } else {
                        System.out.println("Reservation is already cancelled.");
                    }
                } else {
                    System.out.println("You can only cancel your own reservations.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Reservation with ID " + reservationId + " not found.");
        }
    }
    // Private method: generate Reservation ID
    private String generateReservationId() {
        return "R" + System.currentTimeMillis();
    }
}





