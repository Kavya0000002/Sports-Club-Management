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


Fig. 1. The Main page of Sports Club Management System.

<img width="511" height="362" alt="image" src="https://github.com/user-attachments/assets/858ed734-3a0d-4fa0-bd4b-ae70c93ab594" />

Fig. 2. The Login option page for Administrator, Student and Couch.

<img width="382" height="295" alt="image" src="https://github.com/user-attachments/assets/a71f3313-3d7c-4007-9e9e-804973544d8c" />


Fig. 3. The Admin Login page.

Fig. 4. Alert message for Invalid ID or Password.

Fig. 5. The Main page of Admin.

Fig. 6. The "Facilities" Menubar with "Show Facility Names" Menu. 

Fig. 7. The Facilities available.


Fig. 8. The Details of "Gymnastics" Facility.


Fig. 9. The edit option for Admin. (Any changes made here will be updated in the database).

Fig. 10. Viewing the details of the Facility "Gymnastics" after making changes.

Fig. 11. Changes updated in the Facility "Gymnastics". 

Fig. 12. Add and Delete options will also make changes to the database.

Fig. 13. Facility details page for adding new Facility.

Fig. 14. Entering the details of new Facility.

Fig. 15. New Facility added.

Fig. 16. Displaying the details of the new Facility by fetching from the database.

Fig. 17. An Alert message is displayed while deleting Facility when none of the facility is selected.

Fig. 18. After the Facility "FootBall" is deleted.

Fig. 19. Logging in as Student.

Fig. 20. Sudent Login page.

Fig. 21. Main page of Student "John".

Fig. 22. Unenrolling from the "Event".

Fig. 23. Enrolling again.

Fig. 24. Enrollment page.

Fig. 25. Entering the StudentID will automatically fetch the other details of the student from the database.

Fig. 26.  Dropdown for Selecting Events available.

Fig. 27. DatePicker for selecting the date of Birth.

Fig. 28. Submitting the data will update the details to the database and will be added to the wait list page of the Trainer.

Fig. 29. The "Facilities" Menubar with menu "Show Student Events".

Fig. 30. The Events available will be displayed.

Fig. 31. The Event details of the event "Swimming".

Fig. 32. Logging in as Trainer.

Fig. 33. The Login page of the Couch.

Fig. 34. The Main page of the Couch.

Fig. 35. The "Show Facility Names" menu in the "Events" Menubar.

Fig. 36. The Event Available.

Fig. 37. The Students enrolled in that particular Event.

Fig. 38. The details of the Student.

Fig. 39. The "Wait List" menubar with "Show Wait List" menu.

Fig. 40. The "Wait List" page for students who are waiting to be enrolled.

Fig. 41. The Student details page for the students in Wait List.

Fig. 42. An Alert Message is shown when the Availability of that particular Event is full.

Fig. 43. After accepting the student in Wait List.

Fig. 44. And Finally, the "Back" button in all the 3 main pages of the Admin, Couch and the Student, it takes back to the "Login" option page.


