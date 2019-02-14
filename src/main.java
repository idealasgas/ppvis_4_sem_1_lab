import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class main extends Application implements EventHandler {
    Button button;
    TextField text_field;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("лабораторная 1");
        button = new Button("fuck");
        text_field = new TextField("набери в меня текст");
        text_field.setPrefWidth(400);
        button.setOnAction(this);
        HBox layout = new HBox();
        layout.setPadding(new Insets(15, 12, 15, 12));
        layout.setSpacing(10);
        layout.getChildren().addAll(text_field, button);
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(Event event) {
        if (event.getSource()==button){
            System.out.println("hey");
        }
    }
}
