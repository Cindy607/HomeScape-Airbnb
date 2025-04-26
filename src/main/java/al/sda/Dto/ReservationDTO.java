package al.sda.Dto;

import java.time.LocalDate;

public class ReservationDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private String clientName;
    private String apartmentName;
    private boolean status; // true = active, false = cancelled

    public ReservationDTO() {}

    public ReservationDTO(LocalDate startDate, LocalDate endDate, String clientName, String apartmentName, boolean status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientName = clientName;
        this.apartmentName = apartmentName;
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", clientName='" + clientName + '\'' +
                ", apartmentName='" + apartmentName + '\'' +
                ", status=" + status +
                '}';
    }
}
