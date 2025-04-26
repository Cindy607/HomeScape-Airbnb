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
        for (Reservation reservation : reservations) {
            if (reservation.getId().equals(id)) {
                return reservation;
            }
        }
        return null;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}

