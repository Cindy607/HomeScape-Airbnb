package al.sda.Dao;
import al.sda.Entities.Reservation;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private List<Reservation> reservations = new ArrayList<>();
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
    public Reservation findReservationById(String id) {
        for (Reservation r : reservations) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }
    public List<Reservation> getAllReservations() {
        return reservations;
    }
    // Update reservation (p.sh. kur anulohet)
    public void updateReservation(Reservation updatedReservation) {
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getId().equals(updatedReservation.getId())) {
                reservations.set(i, updatedReservation);
                break;
            }
        }
    }
}








