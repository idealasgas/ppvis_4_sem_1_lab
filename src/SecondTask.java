import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SecondTask {
    TextField textField;
    Button firstButton;
    Button secondButton;

    public HBox getLayout(){
        textField = new TextField();
        firstButton = new Button();
        secondButton = new Button();

        firstButton.setOnAction((event -> {
            secondButton.setText(textField.getText());
        }));
        secondButton.setOnAction((event -> {
            String buffer = firstButton.getText();
            firstButton.setText(secondButton.getText());
            secondButton.setText(buffer);
        }));

        HBox container = new HBox();
        container.setPadding(new Insets(15, 12, 15, 12));
        container.getChildren().addAll(textField, firstButton, secondButton);
        return container;
    }
}
