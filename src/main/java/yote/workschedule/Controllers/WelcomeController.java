package yote.workschedule.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import yote.workschedule.Service.DataBaseConnection;
import yote.workschedule.fxrouter.FXRouter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class WelcomeController {

    @FXML private TextField usernameLoginTextField;
    @FXML private TextField passwordLoginTextField;
    @FXML private ImageView adminImageView;

    @FXML private Label loginLabel;

    @FXML
    private void initialize() {
        System.out.println("initialize WelcomeController");
    }

    @FXML
    public void handleRegisterButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("register_user");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า register ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleLoginButton(ActionEvent actionEvent){
        if (usernameLoginTextField.getText().equals("") && passwordLoginTextField.getText().equals("")){
            System.out.println("Login ไม่ได้");
        } else {
//            try {
                validateLogin();
//                FXRouter.goTo("select_data_for_booking");
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.err.println("ไปที่หน้า select data for booking ไม่ได้");
//                System.err.println("ให้ตรวจสอบการกำหนด route");
//            }
        }
    }

    @FXML
    public void handleManager(MouseEvent mouseEvent){
        try {
            FXRouter.goTo("login_manager");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า login_manager ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    public void validateLogin(){
        String username = usernameLoginTextField.getText();
        String password = passwordLoginTextField.getText();
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM mydb.customer WHERE C_username = '" + username + "' AND C_password = '" + password + "'";
//        SELECT count(1) FROM mysql.customer WHERE C_name = "Yote" AND C_password = "12378";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    loginLabel.setText("Congrats");
                    FXRouter.goTo("select_data_for_booking");
                } else {
                    loginLabel.setText("Invalid login. please try again.");
                    return;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
}
