import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("лабораторная 1");

        FirstTask firstTask = new FirstTask();
        SecondTask secondTask = new SecondTask();
        ThirdTask thirdTask = new ThirdTask();
        FourthTask fourthTask = new FourthTask();
        FifthTask fifthTask = new FifthTask();
        IndividualTask individualTask = new IndividualTask();

        VBox main = new VBox();

        main.getChildren().addAll(firstTask.getBox(), secondTask.getBox(), thirdTask.getBox(), fourthTask.getBox(),
                fifthTask.getBox(), individualTask.getBox());

        Scene scene = new Scene(main, 415, 650);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
