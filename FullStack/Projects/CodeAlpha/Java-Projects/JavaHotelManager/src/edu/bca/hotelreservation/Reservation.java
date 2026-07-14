package edu.bca.hotelreservation;

import java.io.Serializable;
import java.util.UUID;

public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    private String reservationId;
    private String guestName;
    private Room room;
    private double amountPaid;

    public Reservation(String guestName, Room room, double amountPaid) {
        // Generate a random 6-character ID
        this.reservationId = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        this.guestName = guestName;
        this.room = room;
        this.amountPaid = amountPaid;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Guest: %-15s | %s | Paid: $%.2f",
                reservationId, guestName, room.toString(), amountPaid);
    }
}