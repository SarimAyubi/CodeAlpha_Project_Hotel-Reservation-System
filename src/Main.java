import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel h1 = new Hotel();


        h1.addRoom(new Room(101, "Single", 100.0));
        h1.addRoom(new Room(102, "Double", 150.0));
        h1.addRoom(new Room(103, "Suite", 300.0));
        h1.addRoom(new Room(104, "Single", 100.0));
        h1.addRoom(new Room(105, "Double", 150.0));
        h1.addRoom(new Room(106, "Suite", 300.0));

        Scanner h = new Scanner(System.in);

        System.out.println("\n\t\t***Hotel Reservation System***");

        while (true) {
            System.out.println();
            System.out.println("1. Search for rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = h.nextInt();
            h.nextLine();
            System.out.println();

            switch (option) {
                case 1:
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String roomType = h.nextLine();
                    List<Room> availableRooms = h1.searchAvailableRooms(roomType);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms.");
                    } else {
                        System.out.println("Available rooms:");
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = h.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = h.nextInt();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(h.next());
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(h.next());


                    Room selectedRoom = null;
                    for (Room room : h1.getAllRooms()) {
                        if (room.getRoomNumber() == roomNumber) {
                            selectedRoom = room;
                            break;
                        }
                    }

                    if (selectedRoom != null && selectedRoom.isAvailable()) {
                        h1.makeReservation(customerName, selectedRoom, checkIn, checkOut);
                    } else {
                        System.out.println("Room not available or room number invalid.");
                    }
                    break;

                case 3:
                    h1.viewReservations();
                    break;

                case 4:
                    System.out.println("Thank you for using Hotel Reservation System...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again!");
                    break;
            }
        }
    }
}
