package yote.workschedule.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import yote.workschedule.fxrouter.FXRouter;

import java.io.IOException;

public class LoginManagerController {

    @FXML private TextField usernameLoginTextField;
    @FXML private TextField passwordLoginTextField;

    @FXML
    private void initialize() {
        System.out.println("initialize LoginManagerController");
    }

    @FXML
    public void handleManagerLoginButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("manager_see_detail");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า manager see detail ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
