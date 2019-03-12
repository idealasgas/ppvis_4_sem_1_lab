import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FirstTask {
    Button button;
    TextField textField;
    ComboBox comboBox;

    public HBox getBox(){
        button = new Button("кнопка");
        textField = new TextField();
        comboBox = new ComboBox();

        button.setOnAction((event -> {
            if (comboBox.getItems().contains(textField.getText())){
                showAlert();
            } else {
                comboBox.getItems().add(textField.getText());
            }
            textField.setText("");
        }));
        HBox layout = new HBox();
        layout.setPadding(new Insets(15));
        layout.setSpacing(10);
        layout.getChildren().addAll(textField, button, comboBox);
        return layout;
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("Aborted:");
        alert.setContentText("Think of something new, fellow!");

        alert.showAndWait();
    }
}
