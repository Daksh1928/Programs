# Student Grade Tracker 🎓

An interactive, console-based Java application designed to input, manage, and analyze student grades. Built with Object-Oriented Programming principles, this tool utilizes Java Collections and robust error handling to provide a seamless, crash-free user experience.

## 🚀 Features

- **Interactive Menu System:** A user-friendly, loop-driven interface that allows continuous data entry, viewing, and analysis without restarting the program.
- **Dynamic Data Management:** Utilizes Java `ArrayList` to handle an arbitrary number of students, meaning the system scales automatically as more records are added.
- **Robust Input Validation:** Implements strict error handling using `try-catch` blocks to prevent program crashes from incorrect data types (e.g., typing text instead of numbers) and enforces a strict 0–100 grading scale.
- **Automated Sorting:** Implements the `Comparable` interface to automatically sort the student roster from highest to lowest score before displaying the report.
- **Statistical Analysis:** Instantly calculates class metrics, including the total number of students, class average, highest score, and lowest score.
- **Letter Grade Conversion:** Automatically translates raw numeric scores into standard academic letter grades (A, B, C, D, F).

## 📂 Project Structure

The project is contained within `EnhancedGradeTracker.java` and consists of two main components:

1. `Student`: A custom class representing a single student entity. It encapsulates their name and numeric grade, handles the letter grade conversion logic, and dictates sorting behavior via the `Comparable` interface.
2. `EnhancedGradeTracker`: The main driver class that manages the `ArrayList` of students, handles standard input parsing (`Scanner`), and directs the application flow through its menu.

## 🛠️ Prerequisites

- **Java Development Kit (JDK):** Version 8 or higher must be installed on your system.

## 💻 How to Run

1. **Download/Clone** the repository to your local machine.
2. **Open your terminal or command prompt** and navigate to the directory containing the file.
3. **Compile the code** using the Java compiler:
   ```bash
   javac EnhancedGradeTracker.java
   ```
