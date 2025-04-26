package al.sda.Entities;


import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private List<String> reservationIds;

    public Client(String id, String name, String email, String password) {
        super(id, name, email, password, "client");
        this.reservationIds = new ArrayList<>();
    }


    public void addReservation(String reservationId) {
        reservationIds.add(reservationId);
    }


    public void removeReservation(String reservationId) {
        reservationIds.remove(reservationId);
    }

    public List<String> getReservationIds() {
        return reservationIds;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Reservations: " + reservationIds.size());
        System.out.println("Reservations: " + reservationIds);
    }

}
