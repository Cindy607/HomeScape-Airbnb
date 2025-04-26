package al.sda.Dao;
import al.sda.Entities.Apartment;

import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO {

        private List<Apartment> apartmentList = new ArrayList<>();

        public void addProperty(Apartment property) {
            apartmentList.add(property);
        }

        public Apartment findPropertyById(String id) {
            for (Apartment property : apartmentList) {
                if (property.getId().equals(id)) {
                    return property;
                }
            }
            return null;
        }

        public List<Apartment> getAllProperties() {
            return apartmentList;
        }
    }


