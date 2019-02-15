import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class main extends Application {
    Button button;
    TextField text_field;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("лабораторная 1");
        button = new Button("кнопка");
        text_field = new TextField();
        text_field.setPrefWidth(400);
        text_field.getText();
        ComboBox combo_box = new ComboBox();


        button.setOnAction((event -> {
            combo_box.getItems().add(text_field.getText());
        }));
        HBox layout = new HBox();
        layout.setPadding(new Insets(15, 12, 15, 12));
        layout.setSpacing(10);
        layout.getChildren().addAll(text_field, button, combo_box);
        Scene scene = new Scene(layout, 300, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
