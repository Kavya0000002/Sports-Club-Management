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
<img width="383" height="295" alt="image" src="https://github.com/user-attachments/assets/c568bff8-2ea7-40e9-95fc-455c32dc40b2" />

Fig. 4. Alert message for Invalid ID or Password.
<img width="552" height="345" alt="image" src="https://github.com/user-attachments/assets/cdf7c872-3372-4a03-a860-2234b3316974" />

Fig. 5. The Main page of Admin.
<img width="384" height="296" alt="image" src="https://github.com/user-attachments/assets/88398c0e-d6d6-48fc-b330-b877c0446f33" />

Fig. 6. The "Facilities" Menubar with "Show Facility Names" Menu. 
<img width="384" height="298" alt="image" src="https://github.com/user-attachments/assets/b33c9ea4-82f3-43a6-acc6-db847062a9cb" />

Fig. 7. The Facilities available.
<img width="384" height="361" alt="image" src="https://github.com/user-attachments/assets/22e6f10d-fd12-4104-8be9-f57dfd1ded47" />

Fig. 8. The Details of "Gymnastics" Facility.
<img width="387" height="364" alt="image" src="https://github.com/user-attachments/assets/b65107e8-ccc6-4531-baef-d5fc1f5ce359" />

Fig. 9. The edit option for Admin. (Any changes made here will be updated in the database).
<img width="386" height="363" alt="image" src="https://github.com/user-attachments/assets/2e1cb4d9-cc5a-4cea-9eae-0d47300393ae" />

Fig. 10. Viewing the details of the Facility "Gymnastics" after making changes.
<img width="387" height="361" alt="image" src="https://github.com/user-attachments/assets/6ee75fad-707e-45a6-bc20-8915e1c69f84" />

Fig. 11. Changes updated in the Facility "Gymnastics". 
<img width="384" height="355" alt="image" src="https://github.com/user-attachments/assets/9c242916-d117-44a4-a021-3cfabe62df83" />

Fig. 12. Add and Delete options will also make changes to the database.
<img width="384" height="359" alt="image" src="https://github.com/user-attachments/assets/10959125-e36b-45ef-8e3f-280697654763" />

Fig. 13. Facility details page for adding new Facility.
<img width="407" height="586" alt="image" src="https://github.com/user-attachments/assets/5530f58f-f1b4-4654-ab7f-f6839924d613" />

Fig. 14. Entering the details of new Facility.
<img width="263" height="578" alt="image" src="https://github.com/user-attachments/assets/767d66b1-a67d-463e-9d25-d57fdef0d6aa" />

Fig. 15. New Facility added.
<img width="385" height="358" alt="image" src="https://github.com/user-attachments/assets/33fea18d-4d54-4f17-8a26-248cd2aba006" />

Fig. 16. Displaying the details of the new Facility by fetching from the database.

<img width="384" height="361" alt="image" src="https://github.com/user-attachments/assets/efce2811-4400-4338-ba31-f5b2db8d5694" />

Fig. 17. An Alert message is displayed while deleting Facility when none of the facility is selected.

<img width="576" height="378" alt="image" src="https://github.com/user-attachments/assets/89329d4f-263f-48c7-a736-2efeb752e87f" />

Fig. 18. After the Facility "FootBall" is deleted.

<img width="384" height="359" alt="image" src="https://github.com/user-attachments/assets/5e1f3282-49ea-4e92-bbdd-1563ca6bd1ce" />

Fig. 19. Logging in as Student.

<img width="385" height="295" alt="image" src="https://github.com/user-attachments/assets/cf6b1ae2-34c5-4136-9631-9099eec09541" />

Fig. 20. Sudent Login page.

<img width="382" height="294" alt="image" src="https://github.com/user-attachments/assets/a7f411a9-4f36-4da6-aa2d-236016544825" />

Fig. 21. Main page of Student "John".

<img width="366" height="500" alt="image" src="https://github.com/user-attachments/assets/4ea15c85-e9e5-4dff-97b7-952b476f77ff" />

Fig. 22. Unenrolling from the "Event".

<img width="366" height="500" alt="image" src="https://github.com/user-attachments/assets/2a7e6f06-ab66-4c0d-9cb6-81439f7bcd92" />

Fig. 23. Enrolling again.

<img width="368" height="501" alt="image" src="https://github.com/user-attachments/assets/31bee27b-d0ff-45cd-bce2-db3a2e335e65" />

Fig. 24. Enrollment page.

<img width="369" height="502" alt="image" src="https://github.com/user-attachments/assets/9121e7d7-0f85-4cea-86cd-c14793e631fe" />

Fig. 25. Entering the StudentID will automatically fetch the other details of the student from the database.

<img width="368" height="497" alt="image" src="https://github.com/user-attachments/assets/cc035e5c-4b3c-45ba-b69b-bd0ab3f1db08" />

Fig. 26.  Dropdown for Selecting Events available.

<img width="365" height="503" alt="image" src="https://github.com/user-attachments/assets/6e78d14d-0615-4e2e-9ce3-4140cf69aa0c" />

Fig. 27. DatePicker for selecting the date of Birth.

<img width="368" height="639" alt="image" src="https://github.com/user-attachments/assets/e63bbbbf-f0ec-43f9-8821-02c64fd2f60d" />

Fig. 28. Submitting the data will update the details to the database and will be added to the wait list page of the Trainer.

<img width="366" height="499" alt="image" src="https://github.com/user-attachments/assets/3682f54e-7115-49b7-aff5-d202a916af57" />

Fig. 29. The "Facilities" Menubar with menu "Show Student Events".

<img width="365" height="497" alt="image" src="https://github.com/user-attachments/assets/73fa4bd7-7cfc-4448-98e2-ed0294f26888" />

Fig. 30. The Events available will be displayed.

<img width="382" height="358" alt="image" src="https://github.com/user-attachments/assets/6c3a5a7e-0f78-4f9f-80a2-2a56a5745015" />

Fig. 31. The Event details of the event "Swimming".

<img width="385" height="359" alt="image" src="https://github.com/user-attachments/assets/e0063f37-e8e1-4b18-908d-a089df5afb90" />

Fig. 32. Logging in as Trainer.

<img width="367" height="499" alt="image" src="https://github.com/user-attachments/assets/05cef714-bfaf-4073-96cd-e5af9c313073" />

Fig. 33. The Login page of the Couch.

<img width="383" height="295" alt="image" src="https://github.com/user-attachments/assets/fdeeb4a7-7707-442d-a040-49f63e2fd62f" />

Fig. 34. The Main page of the Couch.

<img width="364" height="314" alt="image" src="https://github.com/user-attachments/assets/837887bc-e8d0-4ee5-a660-78fee4992601" />

Fig. 35. The "Show Facility Names" menu in the "Events" Menubar.

<img width="363" height="312" alt="image" src="https://github.com/user-attachments/assets/343bc58d-7f84-4046-81b7-1be449f7e6ca" />

Fig. 36. The Event Available.

<img width="383" height="357" alt="image" src="https://github.com/user-attachments/assets/9c91e1f7-1bb5-4e0b-b266-62b274b2ac69" />

Fig. 37. The Students enrolled in that particular Event.

<img width="382" height="359" alt="image" src="https://github.com/user-attachments/assets/4af7839e-d72b-4787-bf28-4a9ea9044f3e" />

Fig. 38. The details of the Student.

<img width="383" height="422" alt="image" src="https://github.com/user-attachments/assets/b365b691-c17e-46cc-bf3c-e5c2e7aae398" />

Fig. 39. The "Wait List" menubar with "Show Wait List" menu.

<img width="365" height="313" alt="image" src="https://github.com/user-attachments/assets/df21c105-a47d-4aa5-a9e5-b0858383ff56" />

Fig. 40. The "Wait List" page for students who are waiting to be enrolled.

<img width="384" height="358" alt="image" src="https://github.com/user-attachments/assets/e19cce9b-8777-4d8a-a355-0195b327bd9b" />

Fig. 41. The Student details page for the students in Wait List.

<img width="386" height="421" alt="image" src="https://github.com/user-attachments/assets/b5560044-c5c6-4027-bf40-14599731d7cc" />

Fig. 42. An Alert Message is shown when the Availability of that particular Event is full.

<img width="586" height="446" alt="image" src="https://github.com/user-attachments/assets/04d768fa-5241-472b-8960-338fb16f3c87" />

Fig. 43. After accepting the student in Wait List.

<img width="381" height="358" alt="image" src="https://github.com/user-attachments/assets/ed7f4ca5-9984-4dcc-9893-60af15e3cf83" />

Fig. 44. And Finally, the "Back" button in all the 3 main pages of the Admin, Couch and the Student, it takes back to the "Login" option page.

<img width="368" height="303" alt="image" src="https://github.com/user-attachments/assets/e5c1509b-aaba-43d3-a96e-6d75afbce5df" />


