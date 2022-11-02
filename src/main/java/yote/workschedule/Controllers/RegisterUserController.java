package yote.workschedule.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import yote.workschedule.Model.MemberList;
import yote.workschedule.Service.DataBaseConnection;
import yote.workschedule.Service.DataSource;
import yote.workschedule.Service.MemberDataSource;
import yote.workschedule.fxrouter.FXRouter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class RegisterUserController {

    public TextField confirmPasswordRegisterTextField;
    private MemberList memberList;
    private DataSource<MemberList> dataSource;

    @FXML private TextField usernameRegisterTextField;
    @FXML private TextField passwordRegisterTextField;
    @FXML private TextField nameTextField;

    @FXML private TextField confirmPasswordTextField;
    @FXML private TextField phoneRegisterTextField;

    @FXML private Label userNameLabel;
    @FXML private Label nameLabel;
    @FXML private Label passwordLabel;
    @FXML private Label conPassLabel;
    @FXML private Label phoneLabel;

    @FXML
    private void initialize() {
        readData();
        DataSource<MemberList> dataSource = new MemberDataSource();
        this.memberList = dataSource.readData();
//        showListView();
        System.out.println("initialize RegisterUserController");
    }
    private void readData() {
        dataSource = new MemberDataSource();
        memberList = dataSource.readData();
    }

    @FXML
    public void handleUseConfirmRegisterButton(ActionEvent actionEvent) throws SQLException {
        String name = nameTextField.getText();
        if (name.equals("")){
            nameLabel.setText("ต้องการชื่อ");
            return;
        }
        String userName = usernameRegisterTextField.getText();
        if (userName.equals("")){
            userNameLabel.setText("ต้องการ Username");
            return;
        }
        String password = passwordRegisterTextField.getText();
        if (password.equals("") ){
            passwordLabel.setText("ต้องการ Password");
            return;
        }
        String confirmPassword = confirmPasswordTextField.getText();
        if (!Objects.equals(confirmPassword, password)){
            conPassLabel.setText("รหัสผ่านไม่ตรง");
            return;
        }
        String phoneNumber = phoneRegisterTextField.getText();
        if (phoneNumber.equals("")){
            phoneLabel.setText("ต้องการเบอร์มือถือ");
            return;
        }
        DataBaseConnection connectionClass = new DataBaseConnection();
        Connection connection = connectionClass.getConnection();
        String register = "INSERT INTO CUSTOMER (C_name,C_tel,C_username,C_password)VALUES('" + name + "','" + phoneNumber + "','" + userName + "','" + password +"')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(register);

        memberList.add(name ,userName, password,phoneNumber);
        dataSource.writeData((memberList));
        try {
            FXRouter.goTo("welcome");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า welcome ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    void handleBackToWelcomeButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("welcome");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า welcome ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
