package al.sda.Entities;
import al.sda.Entities.User;
import java.util.ArrayList;
import java.util.List;

public class Host extends User {
    private List<String> propertyIds;

    public Host(String id, String name, String email, String password) {
        super(id, name, email, password, "host");
        this.propertyIds = new ArrayList<>();
    }

    public void addProperty(String propertyId) {
        propertyIds.add(propertyId);
    }

    public void removeProperty(String propertyId) {
        propertyIds.remove(propertyId);
    }

    public List<String> getPropertyIds() {
        return propertyIds;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Properties: " + propertyIds.size());
        System.out.println("Properties: " + propertyIds);
    }
}




