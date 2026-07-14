package edu.bca.hotelreservation;

import java.io.Serializable;

//Serializable allows these objects to be saved directly to a file
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    private int roomNumber;
    private String category; // Standard, Deluxe, Suite
    private double price;
    private boolean isAvailable;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("Room %d [%s] - $%.2f/night", roomNumber, category, price);
    }
}