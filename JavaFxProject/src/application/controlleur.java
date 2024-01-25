package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class controlleur {

    @FXML
    private Button close;
    public void close() {
        javafx.application.Platform.exit();
    }
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public void login() {

        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";

        connect = MysqlConnection.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, si_username.getText());
            prepare.setString(2, si_password.getText());
            result = prepare.executeQuery();

            Alert alert;

            if (si_username.getText().isEmpty() || si_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                if (result.next()) {

                	 data.username = si_username.getText();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login!");
                    alert.showAndWait();
                    si_loginbtn.getScene().getWindow().hide();

                    // LINK YOUR DASHBOARD FORM 
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard2.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();
                   

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void signup() {

        String sql = "INSERT INTO admin (email, username, password) VALUES(?,?,?)";

        connect = MysqlConnection.connectDb();

        try {
            Alert alert;

            if (su_email.getText().isEmpty() || su_username.getText().isEmpty()
                    || su_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                if (su_password.getText().length() < 8) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid password :3");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, su_email.getText());
                    prepare.setString(2, su_username.getText());
                    prepare.setString(3, su_password.getText());

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully create new account!");
                    alert.showAndWait();

                    prepare.executeUpdate();

                    su_email.setText("");
                    su_username.setText("");
                    su_password.setText("");
                    loginSlider();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void signupSlider() {

        TranslateTransition slider1 = new TranslateTransition();
        slider1.setNode(sub_form);
        slider1.setToX(300);
   
        slider1.play();
        slider1.setOnFinished((ActionEvent event) -> {
           
            close_icon.setFill(Color.valueOf("#fff"));
        });



    }
    public void loginSlider() {

        TranslateTransition slider1 = new TranslateTransition();
        slider1.setNode(sub_form);
        slider1.setToX(0);

        slider1.play();

        slider1.setOnFinished((ActionEvent event) -> {
           
            close_icon.setFill(Color.valueOf("#000"));
        });



    }
    

    @FXML
    private AnchorPane main_form;

    @FXML
    private FontAwesomeIcon close_icon;

    @FXML
    private Hyperlink si_hypertext1;

    @FXML
    private Hyperlink si_hypertext2;

    @FXML
    private Button si_loginbtn;

    @FXML
    private PasswordField si_password;

    @FXML
    private TextField si_username;

    @FXML
    private Button su_btnsignup;

    @FXML
    private TextField su_email;

    @FXML
    private Hyperlink su_hyperlink;

    @FXML
    private PasswordField su_password;

    @FXML
    private TextField su_username;

    @FXML
    private TextField su_verifypassword;

    @FXML
    private AnchorPane sub_form;
    
   

}
