import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FifthTask {
    TextField textField = new TextField();
    Button firstButton = new Button("first");
    Button secondButton = new Button("second");
    Button thirdButton = new Button("third");

    public VBox getBox(){
        TableView table = new TableView();

        TableColumn firstColumn = new TableColumn("First column");
        firstColumn.setMinWidth(150);
        firstColumn.setCellValueFactory(
                new PropertyValueFactory<>("string"));

        TableColumn secondColumn = new TableColumn("Second column");
        secondColumn.setMinWidth(150);
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("string"));

        ObservableList<Property> data = FXCollections.observableArrayList();

        //table.setItems(data);

        table.getColumns().addAll(firstColumn, secondColumn);
        table.setPrefWidth(300);
        // сделать чтобы текст из поля для текста удалялся
        firstButton.setOnAction((event -> {
            //firstColumn.setText(textField.getText());
            data.add(new Property(textField.getText()));
            table.setItems(data);
        }));
//
//        secondButton.setOnAction((event -> {
//            secondColumn.setText(firstColumn.getText());
//            firstColumn.setText("");
//        }));

        HBox firstContainer = new HBox();
        firstContainer.getChildren().addAll(textField, firstButton, secondButton, thirdButton);

        HBox secondContainer = new HBox();
        secondContainer.getChildren().add(table);

        VBox mainContainer = new VBox();
        mainContainer.getChildren().addAll(firstContainer, secondContainer);

        return mainContainer;
    }
}
