package yote.workschedule.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import yote.workschedule.Model.GetList;
import yote.workschedule.Model.Select;
import yote.workschedule.Model.SelectList;
import yote.workschedule.Service.DataSource;
import yote.workschedule.Service.SelectDataSource;
import yote.workschedule.fxrouter.FXRouter;

import java.io.IOException;

public class BookingController {

    private SelectList selectList;

    private DataSource<SelectList> dataSource;

    @FXML private Label programBookingLabel;
    @FXML private Label dateBookingLabel;
    @FXML private Label timeBookingLabel;
    @FXML private Label priceBookingLabel;
    private String date;
    private Select select;
    private String time;
    private String price;
    private String program;
    private GetList getList = (GetList) FXRouter.getData();

    @FXML
    private void initialize()
    {
        readData();
        DataSource<SelectList> dataSource = new SelectDataSource();
        this.selectList = dataSource.readData();
        this.select = getList.getSelect();
        dateBookingLabel.setText(select.getDate());
        timeBookingLabel.setText(select.getTime());
        programBookingLabel.setText(program);
        priceBookingLabel.setText(price);
        System.out.println("initialize BookingController");
    }

    @FXML
    public void handleConfirmBookingButton(ActionEvent actionEvent) throws IOException {
        try {
            FXRouter.goTo("purchase");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า purchase ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleBackBookingButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("select_data_for_booking");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า select data for booking ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    private void readData()
    {
        dataSource = new SelectDataSource();
        selectList = dataSource.readData();
    }
}
