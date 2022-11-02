package yote.workschedule.Controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import yote.workschedule.Model.Select;
import yote.workschedule.Model.SelectList;
import yote.workschedule.Service.DataSource;
import yote.workschedule.Service.SelectDataSource;
import yote.workschedule.fxrouter.FXRouter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SelectDataForBookingController implements Initializable {

    @FXML private Label CheckItems;
    @FXML private CheckBox cb1;
    @FXML private CheckBox cb2;
    @FXML private CheckBox cb3;
    @FXML private CheckBox cb4;
    @FXML private CheckBox cb5;
    @FXML private CheckBox cb6;
    @FXML private CheckBox cb7;
    @FXML private CheckBox cb8;
    @FXML private CheckBox cb9;
    @FXML private CheckBox cb10;
    @FXML private DatePicker datePicker;
    @FXML private ComboBox<String> selectTime;

    private int price;

    private Select select;
    private SelectList selectList;
    private DataSource<SelectList> dataSource;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("initialize SelectDataForBookingController");
        dataSource = new SelectDataSource("Data", "Select.csv");
        selectList = dataSource.readData();
        selectTime.setItems(FXCollections.observableArrayList("10:00-11:00","11:00-12:00","12:00-13:00","13:00-14:00"));
    }

    @FXML
    public void handleNextToBookingButton(ActionEvent actionEvent) {
        String name = CheckItems.getText();
        LocalDate date = datePicker.getValue();
        String time = selectTime.getValue();

        selectList.add(name,String.valueOf(date),time);

        try {

            dataSource.writeData((selectList));
            FXRouter.goTo("booking",selectList);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("ไปที่หน้า booking ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML private void checkEvent(ActionEvent event) {
        int count = 0;
        String items = "";
        if(cb1.isSelected()){
            count++;
            items += cb1.getText() + "\n";
        }
        if(cb2.isSelected()){
            price = 200;
            count++;
            items += cb2.getText() + "\n";
        }
        if(cb3.isSelected()){
            price = 200;
            count++;
            items += cb3.getText() + "\n";
        }
        if(cb4.isSelected()){
            price = 200;
            count++;
            items += cb4.getText() + "\n";
        }
        if(cb5.isSelected()){
            price = 200;
            count++;
            items += cb5.getText() + "\n";
        }
        if(cb6.isSelected()){
            price = 200;
            count++;
            items += cb6.getText() + "\n";
        }
        if(cb7.isSelected()){
            price = 200;
            count++;
            items += cb7.getText() + "\n";
        }
        if(cb8.isSelected()){
            price = 200;
            count++;
            items += cb8.getText() + "\n";
        }
        if(cb9.isSelected()){
            price = 200;
            count++;
            items += cb9.getText() + "\n";
        }
        if(cb10.isSelected()){
            price = 200;
            count++;
            items += cb10.getText() + "\n";
        }
        CheckItems.setText(items);
    }
}
