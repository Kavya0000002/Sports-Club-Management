import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLoginController {

    @FXML
    private TextField studentNameField;

    @FXML
    private TextField studentIDField;

    @FXML
    private Button loginButton;

    @FXML
    private void handleLogin() {
        String studentName = studentNameField.getText();
        String studentID = studentIDField.getText();

        if (validateStudentCredentials(studentName, studentID)) {
            // If credentials are valid, load the next page (e.g., Dashboard.fxml)
            // For simplicity, let's just close the current window in this example
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        } else {
            // Display an error message (you can enhance this part)
            System.out.println("Invalid credentials");
        }
    }

    private boolean validateStudentCredentials(String name, String id) {
        String jdbcUrl = "jdbc:sqlite:Sports.db";

        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Students WHERE FirstName = ? AND StudentID = ?")) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // If there is a match, resultSet.next() will be true
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
