import java.time.LocalDate;

public class Reservation {
    private String customerName;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalAmount;

    public Reservation(String customerName, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.customerName = customerName;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = room.getPrice() * java.time.temporal.ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    public String getCustomerName(){
        return customerName;
    }
    public Room getRoom(){
        return room;
    }
    public LocalDate getCheckInDate(){
        return checkInDate;
    }
    public LocalDate getCheckOutDate(){
        return checkOutDate;
    }
    public double getTotalAmount(){
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Reservation for " + customerName + " in Room " + room.getRoomNumber() +
                " from " + checkInDate + " to " + checkOutDate + ". Total: $" + totalAmount;
    }
}
