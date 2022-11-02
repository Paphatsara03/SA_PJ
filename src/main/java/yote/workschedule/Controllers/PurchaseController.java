package yote.workschedule.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import yote.workschedule.fxrouter.FXRouter;

import java.io.IOException;

public class PurchaseController {

    @FXML private Label programPurchaseLabel;
    @FXML private Label datePurchaseLabel;
    @FXML private Label timePurchaseLabel;
    @FXML private Label pricePurchaseLabel;

    @FXML
    private void initialize() {
        System.out.println("initialize PurchaseController");
    }

    @FXML
    public void handleBankPurchaseButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("booking_done");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า booking done ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleQrcodePurchaseButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("booking_done");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า booking done ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }
}
