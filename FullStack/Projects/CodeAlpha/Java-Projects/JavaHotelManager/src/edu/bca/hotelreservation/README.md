# Hotel Reservation System 🏨

A robust, console-based Java application designed to streamline hotel room bookings, cancellations, and management. Built using core Object-Oriented Programming (OOP) principles, this project implements a complete reservation lifecycle with automated data persistence using Java File I/O.

## 🚀 Features

- **Room Management:** Tracks availability across different room categories (Standard, Deluxe, Suite) with varied pricing.
- **Smart Booking System:** Automatically assigns the first available room in the requested category and generates a unique 6-character alphanumeric Reservation ID.
- **Payment Simulation:** Displays total costs and prompts for payment confirmation before finalizing the booking.
- **Reservation Control:** Allows users to view all active reservations or cancel a booking using their specific ID, which automatically frees up the room for future guests.
- **Data Persistence:** Uses Java Object Serialization to save all rooms and active reservations to a local `hotel_data.dat` file. The state is perfectly preserved between program restarts without requiring a complex SQL database setup.

## 📂 Project Structure

The system is divided into three distinct, modular Java classes for better clarity and maintainability:

1. `Room.java`: Defines the attributes and behaviors of individual hotel rooms (number, category, price, availability).
2. `Reservation.java`: Handles booking details, linking a guest's name with a specific `Room` object and their unique ID.
3. `HotelReservationSystem.java`: The main driver class containing the interactive console menu, application logic, and File I/O operations.

## 🛠️ Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher must be installed on your system.

## 💻 How to Run

1. **Download/Clone** the repository and ensure all three `.java` files are in the same directory.
2. **Open your terminal or command prompt** and navigate to that directory.
3. **Compile the code** using the Java compiler:
   ```bash
   javac HotelReservationSystem.java Room.java Reservation.java
   ```
