import java.util.*;

public class ParkingApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingDAO dao = new ParkingDAO();

        System.out.println("=== Online Parking Slot Booking ===");

        System.out.println("\nAvailable Slots:");
        ArrayList<String> slots = dao.getAvailableSlots();
        for (String s : slots) System.out.println("Slot: " + s);

        System.out.print("\nEnter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter Slot Number to Book: ");
        String slot = sc.nextLine();

        if (dao.bookSlot(slot, name)) {
            System.out.println("\nBooking Successful!");
            System.out.println("Booked Slot: " + slot);
            System.out.println("Booked By: " + name);
        } else {
            System.out.println("\nBooking Failed! Slot may already be booked.");
        }
    }
}
