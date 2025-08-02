import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button studentLoginButton;

    @FXML
    private void handleStudentLogin() {
        // Load student login page
        loadPage("StudentLogin.fxml");
    }

    private void loadPage(String fxmlFileName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Stage stage = new Stage();
            stage.setTitle("Student Login Page");
            stage.setScene(new Scene(root, 300, 200));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
