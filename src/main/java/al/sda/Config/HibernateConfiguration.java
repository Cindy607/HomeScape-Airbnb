package al.sda.Config;

import al.sda.Entities.Apartment;
import al.sda.Entities.Host;
import al.sda.Entities.Reservation;
import al.sda.Entities.Client;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HibernateConfiguration {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create Hibernate configuration object
            Configuration configuration = new Configuration();

            // Load Hibernate properties from hibernate.properties file
            Properties properties = new Properties();
            try (InputStream input = HibernateConfiguration.class.getClassLoader()
                    .getResourceAsStream("hibernate.properties")) {
                if (input == null) {
                    throw new RuntimeException("Unable to find hibernate.properties");
                }
                properties.load(input);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load hibernate.properties", e);
            }

            // Set Hibernate properties
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Apartment.class);
            configuration.addAnnotatedClass(Host.class);
            configuration.addAnnotatedClass(Reservation.class);


            // Build service registry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            // Create SessionFactory from configuration and service registry
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
