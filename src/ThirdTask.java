import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ThirdTask {
    ToggleGroup toggleGroup = new ToggleGroup();

    RadioButton firstRadioButton = new RadioButton("Ruby");
    RadioButton secondRadioButton = new RadioButton("is");
    RadioButton thirdRadioButton = new RadioButton("better!");

    public VBox getBox(){
        Button button = new Button("button");
        toggleGroup.getToggles().addAll(firstRadioButton, secondRadioButton, thirdRadioButton);
        TextField textField = new TextField();
        ArrayList<RadioButton> radioButtonList = new ArrayList<RadioButton>();
        radioButtonList.add(firstRadioButton);
        radioButtonList.add(secondRadioButton);
        radioButtonList.add(thirdRadioButton);

        button.setOnAction(event -> {
            RadioButton chosen = radioButtonList.stream()
                    .filter(radioButton -> radioButton.getText().equals(textField.getText()))
                    .findAny()
                    .orElse(null);
            if(chosen != null){
                toggleGroup.selectToggle(chosen);
            } else {
                showAlert();
            }
        });


        VBox radioButtonContainer = new VBox();
        radioButtonContainer.getChildren().addAll(firstRadioButton, secondRadioButton, thirdRadioButton);
//        radioButtonContainer.setPadding(new Insets(15, 12, 15, 12));
        radioButtonContainer.setSpacing(10);

        HBox container = new HBox();
        container.getChildren().addAll(textField, button);
        container.setSpacing(10);

        VBox mainContainer = new VBox();
        mainContainer.getChildren().addAll(container, radioButtonContainer);
        mainContainer.setPadding(new Insets(15));
        mainContainer.setSpacing(10);

        return mainContainer;
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("This button");
        alert.setContentText("does not exist!");

        alert.showAndWait();
    }
}
