package javafx.student.list;

import database.Connector;
import entities.Student;
import impls.StudentRepository;
import javafx.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student,String> cName;
    public TableColumn<Student,String> cEmail;
    public TableColumn<Student,Integer> cMark;
    public TableColumn<Student,String> cGender;
    public TableColumn<Student, Button> cAction;
    public TextField txtSearch;

    //Demo i18n
    public Button btnSearch;
    public Button btnAdd;

    private ObservableList<Student> ls = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cMark.setCellValueFactory(new PropertyValueFactory<>("mark"));
        cGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        cAction.setCellValueFactory(new PropertyValueFactory<>("edit"));

        //Demo i18n
        btnSearch.setText(Main._msg.getString("search"));
        btnAdd.setText(Main._msg.getString("add"));
        cName.setText(Main._msg.getString("name"));
        cEmail.setText(Main._msg.getString("email"));
        cMark.setText(Main._msg.getString("mark"));
        cGender.setText(Main._msg.getString("gender"));
        cAction.setText(Main._msg.getString("action"));


        try {
            StudentRepository sr = new StudentRepository();
            ls.addAll(sr.all());
            tbStudents.setItems(ls);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void search(ActionEvent actionEvent) {
    }



    public void goToAddPage(ActionEvent actionEvent) throws Exception{
        Parent addForm = FXMLLoader.load(getClass().getResource("../add/addStudent.fxml"));
        Main.rootStage.setScene(new Scene(addForm, 600, 600));
    }

}
