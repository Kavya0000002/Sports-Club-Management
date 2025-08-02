import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Optional;
import java.time.LocalDate;
import java.sql.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
public class Fxjd extends Application {
    private DatePicker dateOfBirth = new DatePicker();
    private MenuBar menuBarFacilities;
    private Stage primaryStage;
    private Button adminLoginButton;
    private Button studLoginButton;
    private Button trainLoginButton;
    private static final String JDBC_URL = "jdbc:sqlite:Sports.db";
    public static void main(String[] args) {
        launch(args);
    }
    private String loggedInStudentID;
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Image backgroundImage = new Image("file:C:\\Users\\91877\\Pictures\\sports.png");
        ImageView backgroundImageView = new ImageView(backgroundImage);
        root.getChildren().add(backgroundImageView);
        backgroundImageView.setFitWidth(400); 
        backgroundImageView.setFitHeight(250);
        VBox buttonContainer = new VBox();
        buttonContainer.setAlignment(Pos.BOTTOM_CENTER); 
        buttonContainer.setSpacing(20); 
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-font-size: 18; -fx-background-color: linear-gradient(#FFAD00, #8a3324); -fx-text-fill: white;");
        loginButton.setOnAction(e -> openLoginPage(primaryStage));
        loginButton.setMinSize(90, 40); // Adjust size as needed
        loginButton.setOnMouseEntered(e -> loginButton.setStyle(
                "-fx-font-size: 18; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle(
                "-fx-font-size: 18; -fx-background-color: linear-gradient(#FFAD00, #8a3324); -fx-text-fill: white;"));
        loginButton.setOnMousePressed(e -> loginButton.setStyle(
                "-fx-font-size: 18; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        loginButton.setOnMouseReleased(e -> loginButton.setStyle(
                "-fx-font-size: 18; -fx-background-color: linear-gradient(#FFAD00, #8a3324); -fx-text-fill: white;"));
        buttonContainer.getChildren().add(loginButton);
        StackPane.setAlignment(buttonContainer, Pos.CENTER);
        root.getChildren().add(buttonContainer);
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void openLoginPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Facility Management System");
        VBox mainLayout = new VBox();
        adminLoginButton = new Button("Login as Administrator");
        adminLoginButton.setOnAction(e -> showAdminLoginPage());
        adminLoginButton.setStyle("-fx-font-size: 15; -fx-background-color: linear-gradient(#b7950b, #935116); -fx-text-fill: white;");
        adminLoginButton.setOnMouseEntered(e -> adminLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        adminLoginButton.setOnMouseExited(e -> adminLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#b7950b, #935116); -fx-text-fill: white;"));
        adminLoginButton.setOnMousePressed(e -> adminLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        adminLoginButton.setOnMouseReleased(e -> adminLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#b7950b, #935116); -fx-text-fill: white;"));
        studLoginButton = new Button("Login as Student");
        studLoginButton.setOnAction(e -> showStudentLoginPage());
        studLoginButton.setStyle("-fx-font-size: 15; -fx-background-color: linear-gradient(#b7950b, #935116); -fx-text-fill: white;");
        studLoginButton.setOnMouseEntered(e -> studLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        studLoginButton.setOnMouseExited(e -> studLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#b7950b, #935116); -fx-text-fill: white;"));
        studLoginButton.setOnMousePressed(e -> studLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        studLoginButton.setOnMouseReleased(e -> studLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#b7950b, #935116); -fx-text-fill: white;"));
        trainLoginButton = new Button("Login as Trainer/Couch");
        trainLoginButton.setOnAction(e -> showTrainerLoginPage());
        trainLoginButton.setStyle("-fx-font-size: 15; -fx-background-color: linear-gradient(#b7950b, #935116); -fx-text-fill: white;");
        trainLoginButton.setOnMouseEntered(e -> trainLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        trainLoginButton.setOnMouseExited(e -> trainLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#b7950b, #935116); -fx-text-fill: white;"));
        trainLoginButton.setOnMousePressed(e -> trainLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        trainLoginButton.setOnMouseReleased(e -> trainLoginButton.setStyle(
                "-fx-font-size: 15; -fx-background-color: linear-gradient(#b7950b, #935116); -fx-text-fill: white;"));
        mainLayout.getChildren().addAll(adminLoginButton, studLoginButton, trainLoginButton);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setSpacing(10);
        Scene scene = new Scene(mainLayout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void showAdminLoginPage() {
        Stage adminLoginStage = new Stage();
        adminLoginStage.setTitle("Administrator Login");
        VBox loginLayout = new VBox();
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setSpacing(10);
        loginLayout.setPadding(new Insets(20));
        String textFieldStyle = "-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #eb984e;";     
        TextField adminIdField = new TextField();
        adminIdField.setStyle(textFieldStyle);
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle(textFieldStyle);
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;");

        loginButton.setOnMouseEntered(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
        loginButton.setOnMousePressed(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        loginButton.setOnMouseReleased(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));

        loginButton.setOnAction(e -> handleAdminLogin(adminIdField.getText(), passwordField.getText(), adminLoginStage));

        loginLayout.getChildren().addAll(new Label("Administrator ID:"), adminIdField,
                new Label("Password:"), passwordField, loginButton);

        Scene scene = new Scene(loginLayout, 300, 200);
        adminLoginStage.setScene(scene);
        adminLoginStage.show();
    }
    private void showStudentLoginPage() {
        Stage studLoginStage = new Stage();
        studLoginStage.setTitle("Student Login");
        VBox loginLayout = new VBox();
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setSpacing(10);
        loginLayout.setPadding(new Insets(20));
        TextField studIdField = new TextField();
        PasswordField passwordField = new PasswordField();
        String a = "-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #ff6666;";
        studIdField.setStyle(a);
        passwordField.setStyle(a);

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleStudLogin(studIdField.getText(), passwordField.getText(), studLoginStage));
        loginButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;");

        loginButton.setOnMouseEntered(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));
        loginButton.setOnMousePressed(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        loginButton.setOnMouseReleased(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));

        loginLayout.getChildren().addAll(new Label("Student ID:"), studIdField,
                new Label("Password:"), passwordField, loginButton);
        Scene scene = new Scene(loginLayout, 300, 200);
        studLoginStage.setScene(scene);
        studLoginStage.show();
    }
private void showTrainerLoginPage() {
    Stage trainerLoginStage = new Stage();
    trainerLoginStage.setTitle("Trainer Login");
    VBox loginLayout = new VBox();
    loginLayout.setAlignment(Pos.CENTER);
    loginLayout.setSpacing(10);
    loginLayout.setPadding(new Insets(20));
    TextField trainerIdField = new TextField();
    PasswordField passwordField = new PasswordField();
    String a = "-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #ffcc00;";
    trainerIdField.setStyle(a);
    passwordField.setStyle(a);
    Button loginButton = new Button("Login");
    loginButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #cc9900); -fx-text-fill: white;");

        loginButton.setOnMouseEntered(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        loginButton.setOnMouseExited(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #cc9900); -fx-text-fill: white;"));
        loginButton.setOnMousePressed(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        loginButton.setOnMouseReleased(e -> loginButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #cc9900); -fx-text-fill: white;"));
    loginButton.setOnAction(e -> handleTrainerLogin(trainerIdField.getText(), passwordField.getText(), trainerLoginStage));

    loginLayout.getChildren().addAll(new Label("Trainer ID:"), trainerIdField,
            new Label("Password:"), passwordField, loginButton);
    Scene scene = new Scene(loginLayout, 300, 200);
    trainerLoginStage.setScene(scene);
    trainerLoginStage.show();
}
private void handleTrainerLogin(String trainerId, String password, Stage trainerLoginStage) {
    if (!trainerId.isEmpty() && !password.isEmpty()) {
        if (isTrainerCredentialsValid(trainerId, password)) {
            System.out.println("Trainer login successful");
            trainerLoginStage.close();

            VBox mainLayout = (VBox) primaryStage.getScene().getRoot();
            mainLayout.getChildren().removeAll(adminLoginButton, studLoginButton, trainLoginButton);

            showTrainerMenu();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Trainer ID or Password. Please try again.");
            alert.showAndWait();
        }
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText("Please enter both Trainer ID and Password.");
        alert.showAndWait();
    }
}
private boolean isTrainerCredentialsValid(String trainerID, String password) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Couch WHERE CouchID = ? AND Passwd = ?")) {
        preparedStatement.setString(1, trainerID);
        preparedStatement.setString(2, password);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            return resultSet.next();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    private void handleAdminLogin(String adminId, String password, Stage adminLoginStage) {
    if (!adminId.isEmpty() && !password.isEmpty()) {
        if (isAdminCredentialsValid(adminId, password)) {
            System.out.println("Administrator login successful");
            adminLoginStage.close();
            VBox mainLayout = (VBox) primaryStage.getScene().getRoot();
            mainLayout.getChildren().removeAll(adminLoginButton, studLoginButton, trainLoginButton);
            showFacilitiesMenu();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Administrator ID or Password. Please try again.");
            alert.showAndWait();
        }
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText("Please enter both Administrator ID and Password.");
        alert.showAndWait();
    }
}
private boolean isAdminCredentialsValid(String adminID, String password) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Admin WHERE AdminID = ? AND Passwd = ?")) {
        preparedStatement.setString(1, adminID);
        preparedStatement.setString(2, password);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            return resultSet.next(); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    private void handleStudLogin(String studId, String password, Stage studLoginStage) {
    if (!studId.isEmpty() && !password.isEmpty()) {
        loggedInStudentID = studId;
        if (isStudentCredentialsValid(studId, password)) {
            System.out.println("Student login successful");
            studLoginStage.close();
            VBox mainLayout = (VBox) primaryStage.getScene().getRoot();
            mainLayout.getChildren().removeAll(adminLoginButton, studLoginButton, trainLoginButton);
            showEventsMenu(loggedInStudentID);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Password. Please try again.");
            alert.showAndWait();
        }
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText("Please enter both Student ID and Password.");
        alert.showAndWait();
    }
}
private boolean isStudentCredentialsValid(String studentID, String password) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE StudentID = ? AND Passwd = ?")) {
        preparedStatement.setString(1, studentID);
        preparedStatement.setString(2, password);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            return resultSet.next();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    private void showFacilitiesMenu() {
    menuBarFacilities = new MenuBar();
    Menu menuFacilities = new Menu("Facilities");
    menuFacilities.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#8a3324, #eb984e); -fx-text-fill: white;");
    menuBarFacilities.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;");
    MenuItem menuItemShowFacilityNames = new MenuItem("Show Facility Names");
    menuItemShowFacilityNames.setOnAction(e -> showFacilityNames(primaryStage));
    menuItemShowFacilityNames.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #eb984e); -fx-text-fill: white;"); 
    menuFacilities.getItems().add(menuItemShowFacilityNames);
    menuBarFacilities.getMenus().add(menuFacilities);
    Button b=new Button("Back");
    b.setOnAction(e -> openLoginPage(primaryStage));
    b.setOnAction(e -> openLoginPage(primaryStage));
    b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;");
    b.setOnMouseEntered(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
    b.setOnMouseExited(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
    b.setOnMousePressed(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
    b.setOnMouseReleased(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
    Label adminIdLabel = new Label();
    Label adminNameLabel = new Label();
    fetchAndDisplayAdminDetails(adminIdLabel, adminNameLabel);
    Label sportsClubLabel = new Label("Sports Club");
    sportsClubLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
    Label welcomeLabel = new Label("Welcome Administrator!");
    welcomeLabel.setStyle("-fx-font-size: 16;");
    VBox mainLayout = (VBox) primaryStage.getScene().getRoot();
    mainLayout.getChildren().addAll(
            menuBarFacilities, sportsClubLabel, welcomeLabel, adminIdLabel, adminNameLabel,b
    );
}
private void fetchAndDisplayAdminDetails(Label adminIdLabel, Label adminNameLabel) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM Admin")) {
        if (resultSet.next()) {
            int adminId = resultSet.getInt("AdminID");
            String adminName = resultSet.getString("AdminName");
            adminIdLabel.setText("AdminID: " + adminId);
            adminNameLabel.setText("AdminName: " + adminName);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    private void showFacilityNames(Stage primaryStage) {
    Stage facilityNamesStage = new Stage();
    facilityNamesStage.setTitle("Facility Names");
    ListView<String> facilityListView = new ListView<>();
    fetchFacilityNames(facilityListView);
    facilityListView.setCellFactory(param -> new ListCell<>() {
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
                setStyle(null);
            } else {
                setText(item);
                setStyle("-fx-background-color: #f5cba7; -fx-text-fill: black;");
                setOnMouseEntered(e -> setStyle("-fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
                setOnMouseExited(e -> setStyle("-fx-background-color:#f5cba7 ; -fx-text-fill: black;"));
                
            }
        }
    });
    facilityListView.setOnMouseClicked(event -> {
        String selectedFacilityName = facilityListView.getSelectionModel().getSelectedItem();

        if (selectedFacilityName != null) {
            showFacilityDetailsPage(selectedFacilityName);
        }
    });
    Button addButton = new Button("Add");
    addButton.setOnAction(e -> showAddFacilityDialog());
    addButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;");
        addButton.setOnMouseEntered(e -> addButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        addButton.setOnMouseExited(e -> addButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
        addButton.setOnMousePressed(e -> addButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        addButton.setOnMouseReleased(e -> addButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
    Button deleteButton = new Button("Delete");
    deleteButton.setOnAction(e -> handleDeleteButtonClick(facilityListView));
    deleteButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;");
        deleteButton.setOnMouseEntered(e -> deleteButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        deleteButton.setOnMouseExited(e -> deleteButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
        deleteButton.setOnMousePressed(e -> deleteButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        deleteButton.setOnMouseReleased(e -> deleteButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
    VBox layout = new VBox(facilityListView, addButton, deleteButton);
    layout.setAlignment(Pos.CENTER);
    layout.setSpacing(10);
    Scene scene = new Scene(layout, 300, 250);
    facilityNamesStage.setScene(scene);
    facilityNamesStage.show();
}
    private void showAddFacilityDialog() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Add New Facility");
        dialog.setHeaderText("Please enter facility details:");
        ButtonType addButton = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);
        String a = "-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #eb984e;";
        TextField facilityIdField = new TextField();
        TextField facilityNameField = new TextField();
        TextField scheduleField = new TextField();
        TextField availabilityField = new TextField();
        TextField pricingField = new TextField();
        facilityIdField.setStyle(a);
        facilityNameField.setStyle(a);
        scheduleField.setStyle(a);
        availabilityField.setStyle(a);
        pricingField.setStyle(a);
        VBox content = new VBox(
                new Label("FacilityID:"),
                facilityIdField,
                new Label("FacilityName:"),
                facilityNameField,
                new Label("Schedule:"),
                scheduleField,
                new Label("Availability:"),
                availabilityField,
                new Label("Pricing:"),
                pricingField
        );
        content.setSpacing(10);
        dialog.getDialogPane().setContent(content);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                return String.format("%s,%s,%s,%s,%s",
                        facilityIdField.getText(),
                        facilityNameField.getText(),
                        scheduleField.getText(),
                        availabilityField.getText(),
                        pricingField.getText());
            }
            return null;
        });
        dialog.showAndWait().ifPresent(result -> {
            String[] facilityDetails = result.split(",");
            addFacilityToDatabase(facilityDetails);
            fetchFacilityNames((ListView<String>) dialog.getOwner().getScene().getRoot().getChildrenUnmodifiable().get(0));
        });
    }
    private void addFacilityToDatabase(String[] facilityDetails) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Facilities (FacilityID, FacilityName, Schedule, Availability, Pricing) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, Integer.parseInt(facilityDetails[0]));
            preparedStatement.setString(2, facilityDetails[1]); 
            preparedStatement.setString(3, facilityDetails[2]);
            preparedStatement.setInt(4, Integer.parseInt(facilityDetails[3]));
            preparedStatement.setDouble(5, Double.parseDouble(facilityDetails[4]));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void fetchFacilityNames(ListView<String> listView) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT FacilityName FROM Facilities")) {
            listView.getItems().clear();  
            while (resultSet.next()) {
                String facilityName = resultSet.getString("FacilityName");

                listView.getItems().add(facilityName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showFacilityDetailsPage(String selectedFacilityName) {
        Stage facilityDetailsStage = new Stage();
        facilityDetailsStage.setTitle("Facility Details");
        VBox facilityDetailsLayout = new VBox();
        Label nameLabel = new Label("Facility Name: " + selectedFacilityName);
        nameLabel.setStyle("-fx-font-size: 13; -fx-background-color: #fad7a0; -fx-text-fill: black;");
        TextArea facilityDetailsTextArea = new TextArea();
        fetchFacilityDetails(selectedFacilityName, facilityDetailsTextArea);
        Button editButton = new Button("Edit");
        editButton.setOnAction(e -> handleEditButtonClick(facilityDetailsTextArea));
        editButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;");
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> handleSubmit2ButtonClick(selectedFacilityName,facilityDetailsTextArea));
        submitButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;");

        editButton.setOnMouseEntered(e -> editButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        editButton.setOnMouseExited(e -> editButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
        editButton.setOnMousePressed(e -> editButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        editButton.setOnMouseReleased(e -> editButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
        submitButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;");

        submitButton.setOnMouseEntered(e -> submitButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        submitButton.setOnMouseExited(e -> submitButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));
        submitButton.setOnMousePressed(e -> submitButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        submitButton.setOnMouseReleased(e -> submitButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#eb984e, #8a3324); -fx-text-fill: white;"));

        facilityDetailsLayout.getChildren().addAll(nameLabel, facilityDetailsTextArea, editButton,submitButton);
        Scene scene = new Scene(facilityDetailsLayout, 300, 250);
        facilityDetailsStage.setScene(scene);
        facilityDetailsStage.show();
    }
    private void fetchFacilityDetails(String facilityName, TextArea detailsTextArea) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Facilities WHERE FacilityName = ?")) {
            preparedStatement.setString(1, facilityName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int facilityId = resultSet.getInt("FacilityID");
                    String schedule = resultSet.getString("Schedule");
                    int availability = resultSet.getInt("Availability");
                    double pricing = resultSet.getDouble("Pricing");

                    String details = "Facility ID: " + facilityId + "\n"
                            + "Schedule: " + schedule + "\n"
                            + "Availability: " + availability + "\n"
                            + "Pricing: " + pricing;

                    detailsTextArea.setText(details);
                    detailsTextArea.setEditable(false);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void handleEditButtonClick(TextArea detailsTextArea) {
        detailsTextArea.setEditable(true);
    }
    private void handleSubmit2ButtonClick(String selectedFacilityName, TextArea detailsTextArea) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement updateStatement = connection.prepareStatement(
                 "UPDATE Facilities SET Schedule = ?, Availability = ?, Pricing = ? WHERE FacilityName = ?")) {
        String editedDetails = detailsTextArea.getText();
        String[] lines = editedDetails.split("\n");
        String schedule = lines[1].substring(lines[1].indexOf(":") + 1).trim();
        int availability = Integer.parseInt(lines[2].substring(lines[2].indexOf(":") + 1).trim());
        double pricing = Double.parseDouble(lines[3].substring(lines[3].indexOf(":") + 1).trim());
        updateStatement.setString(1, schedule);
        updateStatement.setInt(2, availability);
        updateStatement.setDouble(3, pricing);
        updateStatement.setString(4, selectedFacilityName);
        int updatedRows = updateStatement.executeUpdate();
        if (updatedRows > 0) {
            System.out.println("Facility '" + selectedFacilityName + "' details updated in the database.");
        } else {
                    System.out.println("Error updating facility '" + selectedFacilityName + "' details in the database.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    private void handleDeleteButtonClick(ListView<String> facilityListView) {
        String selectedFacilityName = facilityListView.getSelectionModel().getSelectedItem();
        if (selectedFacilityName != null) {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Confirm Deletion");
            confirmAlert.setHeaderText(null);
            confirmAlert.setContentText("Are you sure you want to delete the selected facility?");
            ButtonType confirmButton = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            confirmAlert.getButtonTypes().setAll(confirmButton, ButtonType.CANCEL);

            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == confirmButton) {
                deleteFacility(selectedFacilityName);
                // Refresh the facility list after deleting the facility
                fetchFacilityNames(facilityListView);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Facility Selected");
            alert.setHeaderText(null);
            alert.setContentText("Please select a facility to delete.");
            alert.showAndWait();
        }
    }
    private void deleteFacility(String facilityName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Facilities WHERE FacilityName = ?")) {
            preparedStatement.setString(1, facilityName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showEventsMenu(String loggedInStudentID) {
    menuBarFacilities = new MenuBar();
    Menu menuEvents = new Menu("Events");
    menuEvents.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#8a3324, #ff6666); -fx-text-fill: white;");
    menuBarFacilities.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;");
    MenuItem menuItemShowStudentEvents = new MenuItem("Show Student Events");
    menuItemShowStudentEvents.setOnAction(e -> showStudentEvents(primaryStage));
    menuItemShowStudentEvents.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #ff6666); -fx-text-fill: white;");
    menuEvents.getItems().add(menuItemShowStudentEvents);
    menuBarFacilities.getMenus().add(menuEvents);
    Button b=new Button("Back");
    b.setOnAction(e -> openLoginPage(primaryStage));
    b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;");
    b.setOnMouseEntered(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
    b.setOnMouseExited(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));
    b.setOnMousePressed(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
    b.setOnMouseReleased(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));
    Label sportsClubLabel = new Label("Sports Club");
    sportsClubLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
    Label welcomeLabel = new Label("Welcome!");
    welcomeLabel.setStyle("-fx-font-size: 16;");
    Label studentIdLabel = new Label("StudentID: ");
    Label studentNameLabel = new Label("StudentName: ");
    Label feesLabel = new Label("Fees: ");
    fetchAndDisplayStudentDetails(loggedInStudentID, studentIdLabel, studentNameLabel, feesLabel);
    Button enrollButton = new Button();
    enrollButton.setOnAction(e -> handleEnrollButtonClick()); // Add your enrollment logic here
    enrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;");
    enrollButton.setOnMouseEntered(e -> enrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
    enrollButton.setOnMouseExited(e -> enrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));
    enrollButton.setOnMousePressed(e -> enrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
    enrollButton.setOnMouseReleased(e -> enrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));
    String enrolledStatus = fetchEnrolledStatus(loggedInStudentID);
    if ("yes".equalsIgnoreCase(enrolledStatus)) {
        enrollButton.setText("Enrolled");
        enrollButton.setDisable(true);
    } else {
        enrollButton.setText("Enroll");
    }
    String enrolledEvents = fetchEnrolledEvents(loggedInStudentID);
    Label enrolledEventsLabel;
    if ("None".equalsIgnoreCase(enrolledEvents)||"no".equalsIgnoreCase(enrolledStatus)) {
        enrolledEventsLabel = new Label("Not enrolled in any Events yet!");
    } else {
        enrolledEventsLabel = new Label("Enrolled in: " + enrolledEvents);
    }
    Button unenrollButton = new Button();
    unenrollButton.setOnAction(e -> handleUnenrollButtonClick(loggedInStudentID)); // Add your unenrollment logic here
    unenrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff3366, #8a3324); -fx-text-fill: white;");
    unenrollButton.setOnMouseEntered(e -> unenrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
    unenrollButton.setOnMouseExited(e -> unenrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));
    unenrollButton.setOnMousePressed(e -> unenrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
    unenrollButton.setOnMouseReleased(e -> unenrollButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));
    if ("no".equalsIgnoreCase(enrolledStatus)) {
        unenrollButton.setText("Unenrolled");
        unenrollButton.setDisable(true);
    } else {
        unenrollButton.setText("Unenroll");
    }
    VBox mainLayout = (VBox) primaryStage.getScene().getRoot();
    primaryStage.setWidth(300);
    primaryStage.setHeight(400);
    mainLayout.getChildren().addAll(
            menuBarFacilities, sportsClubLabel, welcomeLabel,
            studentIdLabel, studentNameLabel, feesLabel, enrollButton,
            enrolledEventsLabel, unenrollButton,b
    );
}
    private void handleUnenrollButtonClick(String studentID) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Students SET Enrolled='no', Events='' WHERE StudentID=?")) {
        preparedStatement.setString(1, studentID);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private String fetchEnrolledEvents(String studentID) {
        StringBuilder enrolledEvents = new StringBuilder();
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Events FROM Students WHERE StudentID = ? ")) {
            preparedStatement.setString(1, studentID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String eventName = resultSet.getString("Events");
                    enrolledEvents.append(eventName).append(", ");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrolledEvents.length() > 2 ? enrolledEvents.substring(0, enrolledEvents.length() - 2) : "None";
    }
private void fetchAndDisplayStudentDetails(String studentID, Label studentIdLabel, Label studentNameLabel, Label feesLabel) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE StudentID = ?")) {
            preparedStatement.setString(1, studentID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String studentName = resultSet.getString("StudentName");
                    String fees = resultSet.getString("Fees");
                    studentIdLabel.setText("StudentID: " + studentID);
                    studentNameLabel.setText("StudentName: " + studentName);
                    feesLabel.setText("Fees: " + fees);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
private String fetchEnrolledStatus(String studentID) {
        String enrolledStatus = "no";  
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT Enrolled FROM Students WHERE StudentID = ?")) {
            preparedStatement.setString(1, studentID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    enrolledStatus = resultSet.getString("Enrolled");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrolledStatus;
    }
private void handleEnrollButtonClick() {
    String enrolledStatus = fetchEnrolledStatus(loggedInStudentID);

    if (!"yes".equalsIgnoreCase(enrolledStatus)) {
        showEnrollmentPage();
    }
}
private void showEnrollmentPage() {
    Stage enrollmentStage = new Stage();
    enrollmentStage.setWidth(300);
    enrollmentStage.setHeight(400);
    enrollmentStage.setTitle("Enrollment Page");
    VBox enrollmentLayout = new VBox();
    enrollmentLayout.setAlignment(Pos.CENTER);
    enrollmentLayout.setSpacing(10);
    enrollmentLayout.setPadding(new Insets(20));
    Label studentIdLabel = new Label("Student ID:");
    Label studentNameLabel = new Label("Student Name:");
    Label eventsLabel = new Label("Event:");
    Label dateOfBirthLabel = new Label("Date of Birth:");
    Label classLabel = new Label("Class:");
    TextField studentIdField = new TextField();
    studentIdField.setPromptText("StudentID");
    TextField studentNameField = new TextField();
    studentNameField.setPromptText("StudentName");
    ComboBox<String> eventsComboBox = new ComboBox<>();
    eventsComboBox.setPromptText("Select Event");
    DatePicker dateOfBirthPicker = new DatePicker();
    dateOfBirthPicker.setPromptText("Date of Birth");
    TextField classField = new TextField();
    classField.setPromptText("Class");
    String a = "-fx-background-radius: 5; -fx-border-radius: 5; -fx-border-color: #ff9999;";
    studentIdField.setStyle(a);
    studentNameField.setStyle(a);
    eventsComboBox.setStyle(a);
    dateOfBirthPicker.setStyle(a);
    classField.setStyle(a);
    Button submitButton = new Button("Submit");
    submitButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;");

    submitButton.setOnMouseEntered(e -> submitButton.setStyle(
            "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
    submitButton.setOnMouseExited(e -> submitButton.setStyle(
            "-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));
    submitButton.setOnMousePressed(e -> submitButton.setStyle(
            "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
    submitButton.setOnMouseReleased(e -> submitButton.setStyle(
            "-fx-font-size: 13; -fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));

    submitButton.setOnAction(e -> handleEnrollmentSubmit(
            studentIdField.getText(),
            studentNameField.getText(),
            eventsComboBox.getValue(),
            dateOfBirthPicker.getValue(),
            classField.getText(),
            enrollmentStage
    ));
    studentIdField.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.isEmpty()) {
            fetchStudentDetails2(newValue, studentNameField, dateOfBirthPicker, classField);
        }
    });
    fetchFacilityNames2(eventsComboBox);
    enrollmentLayout.getChildren().addAll(
            studentIdLabel, studentIdField,
            studentNameLabel, studentNameField,
            eventsLabel, eventsComboBox,
            dateOfBirthLabel, dateOfBirthPicker,
            classLabel, classField,
            submitButton
    );
    Scene scene = new Scene(enrollmentLayout, 300, 300);
    enrollmentStage.setScene(scene);
    enrollmentStage.show();
}
private void fetchFacilityNames2(ComboBox<String> eventsComboBox) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT FacilityName FROM Facilities")) {

        while (resultSet.next()) {
            String facilityName = resultSet.getString("FacilityName");
            eventsComboBox.getItems().add(facilityName);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void fetchFacilityNames2(ChoiceBox<String> eventsComboBox) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT FacilityName FROM Facilities")) {
        while (resultSet.next()) {
            String facilityName = resultSet.getString("FacilityName");
            eventsComboBox.getItems().add(facilityName);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void fetchStudentDetails2(String studentId, TextField studentNameField, 
                                  DatePicker dateOfBirthPicker, TextField classField) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE StudentID = ?")) {
        preparedStatement.setString(1, studentId);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                String studentName = resultSet.getString("StudentName");
                long dateOfBirthMillis = resultSet.getLong("DateOfBirth");
                java.sql.Date sqlDate = new java.sql.Date(dateOfBirthMillis);
                String studentClass = resultSet.getString("class");
                studentNameField.setText(studentName);
                dateOfBirthPicker.setValue(sqlDate.toLocalDate());
                classField.setText(studentClass);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
private void handleEnrollmentSubmit(String studentID, String studentName, String events, LocalDate dateOfBirth, String classStr,  Stage enrollmentStage) {
    insertEnrollmentDetails(studentID, studentName, events, dateOfBirth, classStr);
    enrollmentStage.close();   
}
private void insertEnrollmentDetails(String studentID, String studentName, String events, LocalDate dateOfBirth, String classStr) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Students SET Events=?, DateOfBirth=?, class=?, WaitList=?, Enrolled=? WHERE StudentID=?")) {
        preparedStatement.setString(1, events);
        preparedStatement.setDate(2, Date.valueOf(dateOfBirth));
        preparedStatement.setString(3, classStr);
        preparedStatement.setString(4, "Yes"); 
        preparedStatement.setString(5, "no"); 
        preparedStatement.setString(6, studentID);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void showStudentEvents(Stage primaryStage) {
    Stage studentEventsStage = new Stage();
    studentEventsStage.setTitle("Student Events");
    ListView<String> eventsListView = new ListView<>();
    fetchStudentEvents(eventsListView);
    eventsListView.setCellFactory(param -> new ListCell<>() {
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
                setStyle(null);
            } else {
                setText(item);
                setStyle("-fx-background-color: #ff9999; -fx-text-fill: black;");
                setOnMouseEntered(e -> setStyle("-fx-background-color: linear-gradient(#ff6666, #8a3324); -fx-text-fill: white;"));
                setOnMouseExited(e -> setStyle("-fx-background-color:#ff9999 ; -fx-text-fill: black;"));              
            }
        }
    });
    VBox layout = new VBox(eventsListView);
    layout.setAlignment(Pos.CENTER);
    layout.setSpacing(10);
    Scene scene = new Scene(layout, 300, 250);
    studentEventsStage.setScene(scene);
    studentEventsStage.show();
}
private void fetchStudentEvents(ListView<String> listView) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT FacilityName FROM Facilities")) {
            listView.getItems().clear();  // Clear existing items
            while (resultSet.next()) {
                String eventName = resultSet.getString("FacilityName");
                listView.getItems().add(eventName);
            }
            listView.setOnMouseClicked(event -> {
                String selectedEventName = listView.getSelectionModel().getSelectedItem();
                if (selectedEventName != null) {
                    showEventDetailsPage(selectedEventName);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showEventDetailsPage(String selectedEventName) {
        Stage eventDetailsStage = new Stage();
        eventDetailsStage.setTitle("Event Details");
        VBox eventDetailsLayout = new VBox();
        Label nameLabel = new Label("Event Name: " + selectedEventName);
        nameLabel.setStyle("-fx-font-size: 13; -fx-background-color: #ff9999; -fx-text-fill: black;");
        TextArea eventDetailsTextArea = new TextArea();
        fetchEventDetails(selectedEventName, eventDetailsTextArea);
        eventDetailsLayout.getChildren().addAll(nameLabel, eventDetailsTextArea);
        Scene scene = new Scene(eventDetailsLayout, 300, 250);
        eventDetailsStage.setScene(scene);
        eventDetailsStage.show();
    }
    private void fetchEventDetails(String eventName, TextArea detailsTextArea) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Facilities WHERE FacilityName = ?")) {
            preparedStatement.setString(1, eventName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int facilityId = resultSet.getInt("FacilityID");
                    String schedule = resultSet.getString("Schedule");
                    int availability = resultSet.getInt("Availability");
                    double pricing = resultSet.getDouble("Pricing");
                    int noOfEnrolled = resultSet.getInt("NoOfEnrolled");
                    String details = "Facility ID: " + facilityId + "\n"
                            + "Schedule: " + schedule + "\n"
                            + "Availability: " + availability + "\n"
                            + "Pricing: " + pricing + "\n"
                            + "NoOfEnrolled: " + noOfEnrolled + "\n";
                    detailsTextArea.setText(details);
                    detailsTextArea.setEditable(false);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showTrainerMenu() {
    MenuBar menuBarFacilities = new MenuBar();
    Menu menuEvents = new Menu("Events");
    Menu menuEvents2 = new Menu("Wait List");
    menuEvents.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff9900, #ffcc00); -fx-text-fill: white;");
    menuEvents2.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ff9900, #ffcc00); -fx-text-fill: white;");
    menuBarFacilities.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #ff9900); -fx-text-fill: white;");
    MenuItem menuItemShowFacilityNames = new MenuItem("Show Facility Names");
    menuItemShowFacilityNames.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #ffcc00); -fx-text-fill: white;");
    menuItemShowFacilityNames.setOnAction(e -> showFacilityNamesForTrainer(primaryStage));
    MenuItem menuItemShowWaitList = new MenuItem("Show Wait List");
    menuItemShowWaitList.setOnAction(e -> showWaitList(primaryStage));
    menuItemShowWaitList.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #ffcc00); -fx-text-fill: white;");
    menuEvents.getItems().add(menuItemShowFacilityNames);
    menuEvents2.getItems().add(menuItemShowWaitList);
    menuBarFacilities.getMenus().addAll(menuEvents,menuEvents2);
    VBox mainLayout = (VBox) primaryStage.getScene().getRoot();
    Button b=new Button("Back");
    b.setOnAction(e -> openLoginPage(primaryStage));
    b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #ff9900); -fx-text-fill: white;");
    b.setOnMouseEntered(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
    b.setOnMouseExited(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #ff9900); -fx-text-fill: white;"));
    b.setOnMousePressed(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
    b.setOnMouseReleased(e -> b.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #ff9900); -fx-text-fill: white;"));
    Label couchIdLabel = new Label();
    Label couchNameLabel = new Label();
    fetchAndDisplayCouchDetails(couchIdLabel, couchNameLabel);
    Label sportsClubLabel = new Label("Sports Club");
    sportsClubLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
    Label welcomeLabel = new Label("Welcome Couch!");
    welcomeLabel.setStyle("-fx-font-size: 16;");
    mainLayout.getChildren().addAll(
            menuBarFacilities, sportsClubLabel, welcomeLabel, couchIdLabel, couchNameLabel,b
    );
}
private void fetchAndDisplayCouchDetails(Label couchIdLabel, Label couchNameLabel) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM Couch")) {
        if (resultSet.next()) {
            int couchId = resultSet.getInt("CouchID");
            String couchName = resultSet.getString("CouchName");

            couchIdLabel.setText("Couch ID: " + couchId);
            couchNameLabel.setText("Couch Name: " + couchName);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void showFacilityNamesForTrainer(Stage primaryStage) {
    Stage facilityNamesStage = new Stage();
    facilityNamesStage.setTitle("Facility Names");
    ListView<String> facilityNamesListView = new ListView<>();
    fetchFacilityNamesForTrainer(facilityNamesListView);
    facilityNamesListView.setCellFactory(param -> new ListCell<>() {
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
                setStyle(null);
            } else {
                setText(item);
                setStyle("-fx-background-color: #ffff99; -fx-text-fill: black;");
                setOnMouseEntered(e -> setStyle("-fx-background-color: linear-gradient(#ffcc00, #ff9900); -fx-text-fill: white;"));
                setOnMouseExited(e -> setStyle("-fx-background-color:#ffff99 ; -fx-text-fill: black;"));
                
            }
        }
    });
    VBox layout = new VBox(facilityNamesListView);
    layout.setAlignment(Pos.CENTER);
    layout.setSpacing(10);
    Scene scene = new Scene(layout, 300, 250);
    facilityNamesStage.setScene(scene);
    facilityNamesStage.show();
    facilityNamesListView.setOnMouseClicked(event -> {
        String selectedFacilityName = facilityNamesListView.getSelectionModel().getSelectedItem();
        if (selectedFacilityName != null) {
            showStudentNameForFacility(primaryStage, selectedFacilityName);
        }
    });
}
private void fetchFacilityNamesForTrainer(ListView<String> listView) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT FacilityName FROM Facilities")) {
        listView.getItems().clear(); 
        while (resultSet.next()) {
            String facilityName = resultSet.getString("FacilityName");
            listView.getItems().add(facilityName);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void showStudentNameForFacility(Stage primaryStage, String selectedFacilityName) {
    Stage studentNameStage = new Stage();
    studentNameStage.setTitle("Student Names for Facility");
    ListView<String> studentNamesListView = new ListView<>();
    fetchStudentNamesForFacility(studentNamesListView, selectedFacilityName);
    studentNamesListView.setOnMouseClicked(event -> {
        String selectedStudentName = studentNamesListView.getSelectionModel().getSelectedItem();
        if (selectedStudentName != null) {
            showStudentDetailsForFacility(primaryStage, selectedFacilityName, selectedStudentName);
        }
    });
    studentNamesListView.setCellFactory(param -> new ListCell<>() {
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
                setStyle(null);
            } else {
                setText(item);
                setStyle("-fx-background-color: #ffff99; -fx-text-fill: black;");
                setOnMouseEntered(e -> setStyle("-fx-background-color: linear-gradient(#ffcc00, #ff9900); -fx-text-fill: white;"));
                setOnMouseExited(e -> setStyle("-fx-background-color:#ffff99 ; -fx-text-fill: black;"));              
            }
        }
    });
    VBox layout = new VBox(studentNamesListView);
    layout.setAlignment(Pos.CENTER);
    layout.setSpacing(10);
    Scene scene = new Scene(layout, 300, 250);
    studentNameStage.setScene(scene);
    studentNameStage.show();
}
private void fetchStudentNamesForFacility(ListView<String> listView, String selectedFacilityName) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT StudentName FROM Students WHERE Events = ? AND Enrolled='Yes'")) {
        preparedStatement.setString(1, selectedFacilityName);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String studentName = resultSet.getString("StudentName");
                listView.getItems().add(studentName);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void showWaitList(Stage primaryStage) {
    Stage waitListStage = new Stage();
    waitListStage.setTitle("Wait List");
    ListView<String> waitListListView = new ListView<>();
    fetchWaitList(waitListListView);
    waitListListView.setCellFactory(param -> new ListCell<>() {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
                setStyle(null);
            } else {
                setText(item);
                setStyle("-fx-background-color: #ffff99; -fx-text-fill: black;");
                setOnMouseEntered(e -> setStyle("-fx-background-color: linear-gradient(#ffcc00, #ff9900); -fx-text-fill: white;"));
                setOnMouseExited(e -> setStyle("-fx-background-color:#ffff99 ; -fx-text-fill: black;"));
            }
        }
    });
    VBox layout = new VBox(waitListListView);
    layout.setAlignment(Pos.CENTER);
    layout.setSpacing(10);

    Scene scene = new Scene(layout, 300, 250);
    waitListStage.setScene(scene);
    waitListStage.show();
}
private void showStudentDetailsForFacility(Stage primaryStage, String selectedFacilityName, String selectedStudentName) {
    Stage studentDetailsStage = new Stage();
    studentDetailsStage.setTitle("Student Details");
    TextArea studentDetailsTextArea = new TextArea();
    fetchStudentDetailsForFacility(studentDetailsTextArea, selectedFacilityName, selectedStudentName);
    Button closeButton = new Button("Close");
    closeButton.setOnAction(e -> studentDetailsStage.close());
    VBox layout = new VBox(studentDetailsTextArea, closeButton);
    layout.setAlignment(Pos.CENTER);
    layout.setSpacing(10);
    Scene scene = new Scene(layout, 400, 300);
    studentDetailsStage.setScene(scene);
    studentDetailsStage.show();
}
private void fetchStudentDetailsForFacility(TextArea textArea, String selectedFacilityName, String selectedStudentName) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE StudentName = ? AND Events = ? AND Enrolled='Yes'")) {
        preparedStatement.setString(1, selectedStudentName);
        preparedStatement.setString(2, selectedFacilityName);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int studentID = resultSet.getInt("StudentID");
                java.sql.Date sqlDate = resultSet.getDate("date_of_birth");
                LocalDate localDate = sqlDate.toLocalDate();
                String classStr = resultSet.getString("Class");
                String events = resultSet.getString("Events");
                String fees = resultSet.getString("Fees");
                String enrolledStatus = resultSet.getString("Enrolled");

                // Construct and set details in TextArea
                String details = "Student ID: " + studentID + "\n"
                        + "Date of Birth: " + localDate + "\n"
                        + "Class: " + classStr + "\n"
                        + "Events: " + events + "\n"
                        + "Fees: " + fees + "\n"
                        + "Enrolled: " + enrolledStatus;
                
                textArea.setText(details);
                textArea.setEditable(false);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void fetchWaitList(ListView<String> listView) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT StudentName FROM Students WHERE WaitList = 'Yes'")) {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String studentName = resultSet.getString("StudentName");
                listView.getItems().add(studentName);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        listView.setOnMouseClicked(event -> {
        String selectedStudentName = listView.getSelectionModel().getSelectedItem();
        if (selectedStudentName != null) {
            showStudentDetailsFromWaitList(selectedStudentName);
        }
    });
}

private void fetchStudentDetails(String studentName, TextArea detailsTextArea) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL);
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Students WHERE StudentName = ?")) {

        preparedStatement.setString(1, studentName);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {

                int studentID = resultSet.getInt("StudentID");

                long dateOfBirthMillis = resultSet.getLong("DateOfBirth");
                java.sql.Date sqlDate = new java.sql.Date(dateOfBirthMillis);

                dateOfBirth.setValue(sqlDate.toLocalDate());

                String classStr = resultSet.getString("class"); 
                String events = resultSet.getString("Events");
                String fees = resultSet.getString("Fees");
                String enrolledStatus = resultSet.getString("Enrolled");

                // Construct and set details in TextArea
                String details = "Student ID: " + studentID + "\n"
                        + "Date of Birth: " + sqlDate.toLocalDate() + "\n"
                        + "Class: " + classStr + "\n"
                        + "Events: " + events + "\n"
                        + "Fees: " + fees + "\n"
                        + "Enrolled: " + enrolledStatus;
                detailsTextArea.setText(details);
                detailsTextArea.setEditable(false);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void showStudentDetailsFromWaitList(String selectedStudentName) {
    Stage studentDetailsStage = new Stage();
    studentDetailsStage.setTitle("Student Details");
    VBox studentDetailsLayout = new VBox();
    Label nameLabel = new Label("Student Name: " + selectedStudentName);
    nameLabel.setStyle("-fx-font-size: 13; -fx-background-color: #ffffcc; -fx-text-fill: black;");
    TextArea studentDetailsTextArea = new TextArea();
    fetchStudentDetails(selectedStudentName, studentDetailsTextArea);
    Button acceptButton = new Button("Accept");
    acceptButton.setOnAction(e -> handleAcceptButtonClick(selectedStudentName));
    acceptButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #cc9900); -fx-text-fill: white;");
        acceptButton.setOnMouseEntered(e -> acceptButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        acceptButton.setOnMouseExited(e -> acceptButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #cc9900); -fx-text-fill: white;"));
        acceptButton.setOnMousePressed(e -> acceptButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        acceptButton.setOnMouseReleased(e -> acceptButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #cc9900); -fx-text-fill: white;"));
    Button declineButton = new Button("Decline");
    declineButton.setOnAction(e -> handleDeclineButtonClick(selectedStudentName));
    declineButton.setStyle("-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #cc9900); -fx-text-fill: white;");
        declineButton.setOnMouseEntered(e -> declineButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#8EA6B4, #426181); -fx-text-fill: white;"));
        declineButton.setOnMouseExited(e -> declineButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #cc9900); -fx-text-fill: white;"));
        declineButton.setOnMousePressed(e -> declineButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#426181, #8EA6B4); -fx-text-fill: white;"));
        declineButton.setOnMouseReleased(e -> declineButton.setStyle(
                "-fx-font-size: 13; -fx-background-color: linear-gradient(#ffcc00, #cc9900); -fx-text-fill: white;"));
    studentDetailsLayout.getChildren().addAll(nameLabel, studentDetailsTextArea, acceptButton,declineButton);
    Scene scene = new Scene(studentDetailsLayout, 300, 300);
    studentDetailsStage.setScene(scene);
    studentDetailsStage.show();
}
private void handleAcceptButtonClick(String selectedStudentName) {
    try (Connection connection = DriverManager.getConnection(JDBC_URL)) {
        try (PreparedStatement checkAvailabilityStatement = connection.prepareStatement("SELECT Availability FROM Facilities WHERE FacilityName IN (SELECT Events FROM Students WHERE StudentName = ?)")) {
            checkAvailabilityStatement.setString(1, selectedStudentName);
            try (ResultSet resultSet = checkAvailabilityStatement.executeQuery()) {
                if (resultSet.next()) {
                    int availability = resultSet.getInt("Availability");
                    if (availability > 0) {
                        try (PreparedStatement updateStudentStatement = connection.prepareStatement("UPDATE Students SET WaitList = 'No', Enrolled = 'Yes' WHERE StudentName = ?")) {
                            updateStudentStatement.setString(1, selectedStudentName);
                            int updatedRowsStudent = updateStudentStatement.executeUpdate();

                            if (updatedRowsStudent > 0) {
                                System.out.println("Student '" + selectedStudentName + "' accepted and updated in the database.");
                                try (PreparedStatement incrementEnrolledStatement = connection.prepareStatement("UPDATE Facilities SET NoOfEnrolled = NoOfEnrolled + 1, Availability = Availability - 1 WHERE FacilityName IN (SELECT Events FROM Students WHERE StudentName = ?)")) {
                                    incrementEnrolledStatement.setString(1, selectedStudentName);
                                    int updatedRowsEvents = incrementEnrolledStatement.executeUpdate();

                                    if (updatedRowsEvents > 0) {
                                        System.out.println("NoOfEnrolled incremented and Availability decremented for the associated facility.");
                                    } else {
                                        System.out.println("Error updating noOfEnrolled and Availability for the associated facility.");
                                    }
                                }
                            } else {
                                System.out.println("Error updating student '" + selectedStudentName + "' in the database.");
                            }
                        }
                    } else {
                        showAlert("Facility Full", "The Facility is Full", Alert.AlertType.WARNING);
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private void showAlert(String title, String content, Alert.AlertType alertType) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}
    private void handleDeclineButtonClick(String selectedStudentName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             PreparedStatement updateStatement = connection.prepareStatement("UPDATE Students SET WaitList = 'No',Enrolled = 'no' WHERE StudentName = ?")) {

            updateStatement.setString(1, selectedStudentName);
            int updatedRows = updateStatement.executeUpdate();

            if (updatedRows > 0) {
            
                System.out.println("Student '" + selectedStudentName + "' declined and updated in the database.");        
            } else {
                 System.out.println("Error updating student '" + selectedStudentName + "' in the database.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
