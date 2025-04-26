package al.sda;

import al.sda.Config.HibernateConfiguration;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateConfiguration.getSessionFactory().createEntityManager();    }
}