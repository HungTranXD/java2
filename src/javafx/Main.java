package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {
    public static Stage rootStage; //Dùng để chuyển scene

    //Demo i18n
    public static ResourceBundle _msg;

    public static void main(String[] args) {
        //Demo i18n
        Locale.setDefault(new Locale("vi", "VN"));
        _msg = ResourceBundle.getBundle("demo.i18n.messages");

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("student/list/studentList.fxml"));

        rootStage.setTitle("Connect to DB");
        rootStage.setScene(new Scene(root, 600, 600));
        rootStage.show();
    }

}