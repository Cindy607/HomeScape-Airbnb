package al.sda.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Reservations")
public class Reservation {
    @Id
    @GeneratedValue
        private Long id;
    @Column
        private Long clientId;
        private Long propertyId;
        private LocalDate startDate;
        private LocalDate endDate;
        private Boolean status; // true- active ; false-cancelled

    public Reservation(Long clientId, Long propertyId, LocalDate startDate, LocalDate endDate, Boolean status) {
        this.clientId = clientId;
        this.propertyId = propertyId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Reservation() {

    }

    public Long getId() {
        return id;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
