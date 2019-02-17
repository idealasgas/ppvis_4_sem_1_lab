import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class FourthTask {
    CheckBox firstCheckBox = new CheckBox("first");
    CheckBox secondCheckBox = new CheckBox("second");
    CheckBox thirdCheckBox = new CheckBox("third");
    TextField textField = new TextField();
    Button button = new Button();

    public HBox getBox(){
        ArrayList<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(firstCheckBox);
        checkBoxes.add(secondCheckBox);
        checkBoxes.add(thirdCheckBox);

        button.setOnAction((event -> {
            CheckBox chosen = checkBoxes.stream()
                    .filter(checkBox -> textField.getText().equals(checkBox.getText()))
                    .findAny()
                    .orElse(null);
            if (chosen != null){
                chosen.setSelected(!chosen.isSelected());
            } else {
                showAlert();
            }
        }));

        HBox container = new HBox();
        container.getChildren().addAll(firstCheckBox, secondCheckBox, thirdCheckBox, textField, button);

        return container;
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("This checkbox");
        alert.setContentText("does not exist!");

        alert.showAndWait();
    }
}
