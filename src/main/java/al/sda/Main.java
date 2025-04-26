package al.sda;

import al.sda.Dao.*;
import al.sda.Entities.*;
import al.sda.Service.*;
import al.sda.Functionalities.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ApartmentDAO apartmentDAO = new ApartmentDAO();
        ReservationDAO reservationDAO = new ReservationDAO();
        ClientDAO clientDAO = new ClientDAO();
        HostDAO hostDAO = new HostDAO();
        ReceiptService receiptService = new ReceiptService();

        ClientService clientService = new ClientService(apartmentDAO, reservationDAO, receiptService);
        HostService hostService = new HostService(apartmentDAO, reservationDAO);

        while (true) {
            System.out.println("\n=== Welcome to Airbnb Management System ===");
            System.out.println("1. Register Host");
            System.out.println("2. Register Client");
            System.out.println("3. Login Host");
            System.out.println("4. Login Client");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Host Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Host Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Host Password: ");
                    String password = scanner.nextLine();

                    Host host = new Host(name, email, password); // PA generateId()
                    hostDAO.addHost(host);
                    System.out.println("Host registered successfully!");
                }

                case 2 -> {
                    System.out.print("Enter Client Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Client Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Client Password: ");
                    String password = scanner.nextLine();

                    Client client = new Client(name, email, password); // PA generateId()
                    clientDAO.addClient(client);
                    System.out.println("Client registered successfully!");
                }
                case 3 -> {
                    System.out.print("Enter Host ID: ");
                    String hostId = scanner.nextLine();
                    Host host = hostDAO.findHostById(hostId);
                    if (host != null) {
                        System.out.println("Host login successful!");
                        hostMenu(scanner, host, hostService);
                    } else {
                        System.out.println("Host not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter Client ID: ");
                    String clientId = scanner.nextLine();
                    Client client = clientDAO.findClientById(clientId);
                    if (client != null) {
                        System.out.println("Client login successful!");
                        ClientFunctionalities clientFunc = new ClientFunctionalities(client);
                        clientMenu(scanner, client, clientFunc, clientService);
                    } else {
                        System.out.println("Client not found.");
                    }
                }
                case 5 -> {
                    System.out.println("Thank you for using the system. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void hostMenu(Scanner scanner, Host host, HostService hostService) {
        while (true) {
            System.out.println("\n--- Host Menu ---");
            System.out.println("1. Add Apartment");
            System.out.println("2. View My Apartments");
            System.out.println("3. View Reservations");
            System.out.println("4. Remove Apartment");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Apartment Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter Price Per Night: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    hostService.addApartment(host, name, location, price);
                }
                case 2 -> hostService.viewOwnApartments(host);
                case 3 -> hostService.viewReservationsForMyApartments(host);
                case 4 -> {
                    System.out.print("Enter Apartment ID to Remove: ");
                    String apartmentId = scanner.nextLine();
                    hostService.removeApartment(host, apartmentId);
                }
                case 5 -> {
                    System.out.println("Logging out Host...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void clientMenu(Scanner scanner, Client client, ClientFunctionalities clientFunc, ClientService clientService) {
        while (true) {
            System.out.println("\n--- Client Menu ---");
            System.out.println("1. Search Apartments");
            System.out.println("2. Make Reservation");
            System.out.println("3. View My Reservations");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Location to Search: ");
                    String location = scanner.nextLine();
                    clientService.searchApartmentsByLocation(location);
                }
                case 2 -> {
                    System.out.print("Enter Apartment ID to Reserve: ");
                    String apartmentId = scanner.nextLine();
                    Apartment apartment = clientService.getApartmentDAO().findApartmentById(apartmentId);
                    if (apartment != null) {
                        System.out.print("Enter Start Date (yyyy-mm-dd): ");
                        LocalDate startDate = LocalDate.parse(scanner.nextLine());
                        System.out.print("Enter End Date (yyyy-mm-dd): ");
                        LocalDate endDate = LocalDate.parse(scanner.nextLine());
                        clientService.makeReservation(client, clientFunc, apartment, startDate, endDate);
                    } else {
                        System.out.println("Apartment not found.");
                    }
                }
                case 3 -> clientService.viewMyReservations(client, clientFunc);
                case 4 -> {
                    System.out.print("Enter Reservation ID to Cancel: ");
                    String reservationId = scanner.nextLine();
                    clientService.cancelReservation(client, clientFunc, reservationId);
                }
                case 5 -> {
                    System.out.println("Logging out Client...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static String generateId() {
        return "ID" + System.currentTimeMillis();
    }
}
