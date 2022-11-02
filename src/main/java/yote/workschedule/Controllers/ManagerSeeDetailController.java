package yote.workschedule.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import yote.workschedule.fxrouter.FXRouter;

import java.io.IOException;

public class ManagerSeeDetailController {

    @FXML private ListView memberListView;

    @FXML
    private void initialize() {
        System.out.println("initialize ManagerSeeDetailController");
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("login_manager");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า login manager ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
