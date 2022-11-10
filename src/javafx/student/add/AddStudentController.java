package javafx.student.add;


import database.Connector;
import entities.Student;
import javafx.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddStudentController implements Initializable {

    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ComboBox<String> cbGender;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> genders = FXCollections.observableArrayList();
        genders.addAll("Male", "Female", "Other");
        cbGender.setItems(genders);
    }

    public void backToListPage(ActionEvent actionEvent) throws Exception {
        Parent listScene = FXMLLoader.load(getClass().getResource("../list/studentList.fxml"));
        Scene sc = new Scene(listScene, 600, 600);
//        Main.rootStage.setTitle("Student list");
        Main.rootStage.setScene(sc);
    }

    public void submit(ActionEvent actionEvent) {
        try {
            Integer mark = Integer.parseInt(txtMark.getText());
            if(mark < 0 || mark > 10) throw new Exception("Invalid mark");
            //tao student object
            Student s = new Student(null, txtName.getText(), txtEmail.getText(), mark, cbGender.getValue());

            //Add student to database
            Connector connector = new Connector();
            String sql_txt = "INSERT INTO students(name, email, mark, gender) VALUES (?, ?, ?, ?)";
            ArrayList parameters = new ArrayList();
            parameters.add(s.getName());
            parameters.add(s.getEmail());
            parameters.add(s.getMark());
            parameters.add(s.getGender());
            if(connector.execute(sql_txt,parameters)){
                backToListPage(null);
                return;
            }
            throw new Exception("Không thêm được dữ liệu");


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
