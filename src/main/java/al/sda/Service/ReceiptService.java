package al.sda.Service;

import al.sda.Entities.Apartment;
import al.sda.Entities.Reservation;
import java.time.temporal.ChronoUnit;

public class ReceiptService {

    public void generateReceipt(Reservation reservation, Apartment apartment) {
        System.out.println("\n----- Reservation Receipt -----");
        System.out.println("Apartment Name: " + apartment.getName());
        System.out.println("Start Date: " + reservation.getStartDate());
        System.out.println("End Date: " + reservation.getEndDate());

        long numberOfNights = ChronoUnit.DAYS.between(reservation.getStartDate(), reservation.getEndDate());

        if (numberOfNights == 0) {
            numberOfNights = 1;
        }

        double totalPrice = numberOfNights * apartment.getPricePerNight();
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.println("Price per Night: " + apartment.getPricePerNight() + " €");
        System.out.println("Total Price: " + totalPrice + " €");
        System.out.println("--------------------------------\n");
    }
}











