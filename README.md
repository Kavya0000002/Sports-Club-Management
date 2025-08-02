🏀 Sports Club Management System

📋 Description
The Sports Club Management System is a JavaFX-based desktop application that enables trainers and administrators to manage sports facilities, student enrollments, waitlists, and event information. It integrates with an SQLite database for data persistence and uses JavaFX for building a user-friendly GUI.

This project showcases how core Java, JavaFX, and JDBC can work together to create real-world applications with a responsive interface and functional database backend.

🧰 Technology Stack
Java – for application logic and platform independence

JavaFX – for GUI components and layout (buttons, menus, scenes, etc.)

SQLite – lightweight database for storing facilities, student, and event data

JDBC (sqlite-jdbc) – to connect Java with SQLite seamlessly

🚀 How to Run This Project:

💡 These steps use JavaFX SDK 21.0.1 and sqlite-jdbc-3.44.1.0.jar. Paths are written generically so they can be adapted easily.

📁 1. Project Structure

/YourProject/
│
├─ Fxjd.java                    // Main class
├─ sqlite-jdbc-3.44.1.0.jar     // SQLite JDBC driver
├─ db/                          // Folder containing your SQLite DB
└─ javafx-sdk-21.0.1/           // JavaFX SDK folder
   └─ lib/
   
✅ 2. Compile the Project

javac -cp ".;sqlite-jdbc-3.44.1.0.jar" ^
    --module-path "path/to/javafx-sdk-21.0.1/lib" ^
    --add-modules javafx.controls ^
    Fxjd.java
Replace "path/to/javafx-sdk-21.0.1/lib" with the correct path to your JavaFX SDK lib folder.

▶️ 3. Run the Application

java -cp ".;sqlite-jdbc-3.44.1.0.jar" ^
    --module-path "path/to/javafx-sdk-21.0.1/lib" ^
    --add-modules javafx.controls ^
    Fxjd
🔄 Make sure the compiled class name (Fxjd) matches your main class with public static void main(String[] args).

🧪 Features:

View and manage facility names

View enrolled students and waitlist

Accept/decline students from waitlist

Auto-update facility availability

Rich JavaFX GUI (menu bars, buttons, styling)

Embedded SQLite for lightweight and persistent data

📌 Note
If you're using additional JavaFX modules (e.g., javafx.fxml, javafx.graphics), include them like this:

--add-modules javafx.controls,javafx.fxml,javafx.graphics
