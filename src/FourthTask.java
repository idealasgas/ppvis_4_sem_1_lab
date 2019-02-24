import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class FourthTask {

    public VBox getBox(){
        ArrayList<CheckBox> checkBoxes = new ArrayList<>();

        CheckBox firstCheckBox = new CheckBox("first");
        CheckBox secondCheckBox = new CheckBox("second");
        CheckBox thirdCheckBox = new CheckBox("third");

        checkBoxes.add(firstCheckBox);
        checkBoxes.add(secondCheckBox);
        checkBoxes.add(thirdCheckBox);

        TextField textField = new TextField();

        Button button = new Button("button");
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

        VBox checkBoxContainer = new VBox();
        checkBoxContainer.getChildren().addAll(firstCheckBox, secondCheckBox, thirdCheckBox);
        checkBoxContainer.setSpacing(10);

        HBox container = new HBox();
        container.getChildren().addAll(textField, button);
        container.setSpacing(10);

        VBox mainContainer = new VBox();
        mainContainer.getChildren().addAll(container, checkBoxContainer);
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(15));

        return mainContainer;
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("This checkbox");
        alert.setContentText("does not exist!");

        alert.showAndWait();
    }
}
