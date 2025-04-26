package al.sda.Dao;

import al.sda.Entities.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client findClientById(String id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        return null;
    }

    public List<Client> getAllClients() {
        return clients;
    }
}

