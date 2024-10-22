import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> searchAvailableRooms(String roomType) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType().equals(roomType) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public void makeReservation(String customerName, Room room, LocalDate checkIn, LocalDate checkOut) {
        if (room.isAvailable()) {
            Reservation reservation = new Reservation(customerName, room, checkIn, checkOut);
            reservations.add(reservation);
            room.setAvailable(false);
            System.out.println("Reservation successful!");
        } else {
            System.out.println("Room is not available!");
        }
    }

    public void viewReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
