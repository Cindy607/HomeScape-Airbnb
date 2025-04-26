package al.sda.Dao;

import al.sda.Entities.Host;
import java.util.ArrayList;
import java.util.List;

public class HostDAO {
    private List<Host> hosts = new ArrayList<>();

    public void addHost(Host host) {
        hosts.add(host);
    }

    public Host findHostById(String id) {
        for (Host host : hosts) {
            if (host.getId().equals(id)) {
                return host;
            }
        }
        return null;
    }

    public List<Host> getAllHosts() {
        return hosts;
    }
}

