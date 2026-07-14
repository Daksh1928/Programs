package edu.bca.hotelreservation;

import java.io.*;
import java.util.*;

public class HotelReservationSystem {
    private static final String DATA_FILE = "hotel_data.dat";
    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadData(); // Load existing data or initialize fresh

        boolean running = true;
        System.out.println("=== Welcome to the Grand Java Hotel ===");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View My Reservation Details");
            System.out.println("4. Cancel a Reservation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayAvailableRooms();
                    break;
                case "2":
                    bookRoom();
                    break;
                case "3":
                    viewReservations();
                    break;
                case "4":
                    cancelReservation();
                    break;
                case "5":
                    System.out.println("Saving data... Goodbye!");
                    saveData();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        boolean found = false;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, the hotel is fully booked!");
        }
    }

    private static void bookRoom() {
        System.out.println("\n--- Make a Reservation ---");
        System.out.print("Enter Room Category (Standard/Deluxe/Suite): ");
        String category = scanner.nextLine();

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.isAvailable() && room.getCategory().equalsIgnoreCase(category)) {
                selectedRoom = room;
                break; // Grab the first available room in this category
            }
        }

        if (selectedRoom == null) {
            System.out.println("Sorry, no available rooms in the '" + category + "' category.");
            return;
        }

        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine();

        // Payment Simulation
        System.out.printf("The total for your %s room is $%.2f.\n", category, selectedRoom.getPrice());
        System.out.print("Proceed to payment? (yes/no): ");
        if (!scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Reservation cancelled.");
            return;
        }

        System.out.println("Processing payment... [SUCCESS]");

        // Finalize Booking
        selectedRoom.setAvailable(false);
        Reservation newRes = new Reservation(guestName, selectedRoom, selectedRoom.getPrice());
        reservations.add(newRes);

        saveData(); // Save state immediately after modifying

        System.out.println("Booking confirmed! Your Reservation ID is: " + newRes.getReservationId());
    }

    private static void viewReservations() {
        System.out.println("\n--- All Active Reservations ---");
        if (reservations.isEmpty()) {
            System.out.println("No active reservations found.");
            return;
        }
        for (Reservation res : reservations) {
            System.out.println(res);
        }
    }

    private static void cancelReservation() {
        System.out.print("\nEnter Reservation ID to cancel: ");
        String resId = scanner.nextLine();

        Reservation toCancel = null;
        for (Reservation res : reservations) {
            if (res.getReservationId().equalsIgnoreCase(resId)) {
                toCancel = res;
                break;
            }
        }

        if (toCancel != null) {
            // Free up the room
            toCancel.getRoom().setAvailable(true);
            reservations.remove(toCancel);
            saveData(); // Save state
            System.out.println("Reservation " + resId + " has been successfully cancelled. Refund initiated.");
        } else {
            System.out.println("Error: Reservation ID not found.");
        }
    }

    // --- File I/O Methods ---

    @SuppressWarnings("unchecked")
    private static void loadData() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                rooms = (List<Room>) ois.readObject();
                reservations = (List<Reservation>) ois.readObject();
            } catch (Exception e) {
                System.out.println("Error loading data. Starting fresh.");
                initializeHotel();
            }
        } else {
            initializeHotel();
        }
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(rooms);
            oos.writeObject(reservations);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void initializeHotel() {
        rooms.add(new Room(101, "Standard", 100.00));
        rooms.add(new Room(102, "Standard", 100.00));
        rooms.add(new Room(201, "Deluxe", 200.00));
        rooms.add(new Room(202, "Deluxe", 200.00));
        rooms.add(new Room(301, "Suite", 350.00));
    }
}