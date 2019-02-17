import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("лабораторная 1");

        FirstTask firstTask = new FirstTask();
        SecondTask secondTask = new SecondTask();
        ThirdTask thirdTask = new ThirdTask();
        FourthTask fourthTask = new FourthTask();
        FifthTask fifthTask = new FifthTask();

        VBox main = new VBox();



        main.getChildren().addAll(firstTask.show(), secondTask.getLayout(), thirdTask.getBox(), fourthTask.getBox(),
                fifthTask.getBox());

        Scene scene = new Scene(main, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
