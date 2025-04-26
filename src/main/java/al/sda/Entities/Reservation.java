package al.sda.Entities;

import java.time.LocalDate;

public class Reservation {
        private String id;
        private String clientId;
        private String propertyId;
        private LocalDate startDate;
        private LocalDate endDate;
        private Boolean status; // true- active ; false-cancelled

    public Reservation(String id, String clientId, String propertyId, LocalDate startDate, LocalDate endDate, Boolean status) {
        this.id = id;
        this.clientId = clientId;
        this.propertyId = propertyId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public String getPropertyId() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setPropertyId(String propertyId) {
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
