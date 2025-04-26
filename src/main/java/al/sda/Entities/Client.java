package al.sda.Entities;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private List<String> reservationIds;

    public Client(String id, String name, String email, String password) {
        super(id, name, email, password, "client");
        this.reservationIds = new ArrayList<>();
    }

    public List<String> getReservationIds() {
        return reservationIds;
    }

    public void setReservationIds(List<String> reservationIds) {
        this.reservationIds = reservationIds;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Reservations: " + reservationIds.size());
        System.out.println("Reservations: " + reservationIds);
    }

}
