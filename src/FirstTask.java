import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FirstTask {
    Button button;
    TextField text_field;
    ComboBox combo_box;

    public void show(Stage primaryStage){
        primaryStage.setTitle("лабораторная 1");
        button = new Button("кнопка");
        text_field = new TextField();
        text_field.setPrefWidth(400);
        text_field.getText();
        ComboBox combo_box = new ComboBox();

        button.setOnAction((event -> {
            if (combo_box.getItems().contains(text_field.getText())){
                showAlert();
            } else {
                combo_box.getItems().add(text_field.getText());
            }
        }));
        HBox layout = new HBox();
        layout.setPadding(new Insets(15, 12, 15, 12));
        layout.setSpacing(10);
        layout.getChildren().addAll(text_field, button, combo_box);

        Scene scene = new Scene(layout, 600, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Aborted:");
        alert.setContentText("Think of something new, fellow!");

        alert.showAndWait();
    }
}