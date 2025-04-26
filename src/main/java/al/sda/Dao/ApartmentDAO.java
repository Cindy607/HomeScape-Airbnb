package al.sda.Dao;
import al.sda.Entities.Apartment;

import java.util.ArrayList;
import java.util.List;

public class ApartmentDAO {

        private List<Apartment> apartmentList = new ArrayList<>();

        public void addApartment(Apartment apartment) {
            apartmentList.add(apartment);
        }

        public Apartment findApartmentById(String id) {
            for (Apartment apartment : apartmentList) {
                if (apartment.getId().equals(id)) {
                    return apartment;
                }
            }
            return null;
        }

        public List<Apartment> getAllApartments() {
            return apartmentList;
        }
    }


