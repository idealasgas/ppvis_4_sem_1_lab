import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FifthTask {
    TextField textField = new TextField();
    Button firstButton = new Button("first");
    Button secondButton = new Button("second");
    Button thirdButton = new Button("third");

    public VBox getBox(){
        TableView table = new TableView();
        TableColumn firstColumn = new TableColumn();
        TableColumn secondColumn = new TableColumn();
        table.getColumns().addAll(firstColumn, secondColumn);
// сделать чтобы текст из поля для текста удалялся
        firstButton.setOnAction((event -> {
            firstColumn.setText(textField.getText());
        }));

        secondButton.setOnAction((event -> {
            secondColumn.setText(firstColumn.getText());
            firstColumn.setText("");
        }));

        HBox firstContainer = new HBox();
        firstContainer.getChildren().addAll(textField, firstButton, secondButton, thirdButton);

        HBox secondContainer = new HBox();
        secondContainer.getChildren().add(table);

        VBox mainContainer = new VBox();
        mainContainer.getChildren().addAll(firstContainer, secondContainer);

        return mainContainer;
    }
}
