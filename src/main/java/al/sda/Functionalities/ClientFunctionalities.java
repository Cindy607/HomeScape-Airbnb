package al.sda.Functionalities;
import al.sda.Entities.Client;
import al.sda.Entities.Reservation;
import java.util.ArrayList;
import java.util.List;

public class ClientFunctionalities {
    private Client client;
    private List<Reservation> reservations;
    public ClientFunctionalities(Client client) {
        this.client = client;
        this.reservations = new ArrayList<>();
    }
    // Shto një rezervim te klienti
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
    // Anulo një rezervim nga klienti
    public void cancelReservation(String reservationId) {
        boolean found = false;
        for (Reservation r : reservations) {
            if (r.getId().equals(reservationId)) {
                if (r.getStatus()) {
                    r.setStatus(false);
                    System.out.println("Reservation cancelled successfully.");
                } else {
                    System.out.println("Reservation is already cancelled.");
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Reservation with ID " + reservationId + " not found.");
        }
    }
    public void showReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        System.out.println("Reservations for client: " + client.getName());
        for (Reservation r : reservations) {
            System.out.println(r);
        }
    }
    public List<Reservation> getReservations() {
        return reservations;
    }
}









