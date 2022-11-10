package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage rootStage; //Dùng để chuyển scene

    public static void main(String[] args) {
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