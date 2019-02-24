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
        firstButton = new Button("button 1");
        secondButton = new Button("button 2");

        firstButton.setOnAction((event -> {
            secondButton.setText(textField.getText());
            textField.setText("");
        }));

        secondButton.setOnAction((event -> {
            String buffer = firstButton.getText();
            firstButton.setText(secondButton.getText());
            secondButton.setText(buffer);
            textField.setText("");
        }));

        HBox container = new HBox();
        container.setPadding(new Insets(15, 12, 15, 12));
        container.setSpacing(10);
        container.getChildren().addAll(textField, firstButton, secondButton);
        return container;
    }
}
