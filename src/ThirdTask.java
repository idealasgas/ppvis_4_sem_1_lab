import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class ThirdTask {
    ToggleGroup toggleGroup = new ToggleGroup();

    RadioButton firstRadioButton = new RadioButton("Ruby");
    RadioButton secondRadioButton = new RadioButton("is");
    RadioButton thirdRadioButton = new RadioButton("better!");

    public HBox getBox(){
        Button button = new Button();
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

        HBox container = new HBox();
        container.getChildren().addAll(textField, firstRadioButton, secondRadioButton, thirdRadioButton, button);

        return container;
    }

    private void showAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText("This button");
        alert.setContentText("does not exist!");

        alert.showAndWait();
    }
}
