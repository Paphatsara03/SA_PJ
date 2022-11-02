package yote.workschedule.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import yote.workschedule.fxrouter.FXRouter;

import java.io.IOException;

public class BookingDoneController {

    @FXML
    private void initialize() {
        System.out.println("initialize BookingDoneController");
    }

    @FXML
    public void handleHomeButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("select_data_for_booking");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า select data for booking ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
