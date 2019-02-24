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
                new PropertyValueFactory<>("string1"));

        TableColumn secondColumn = new TableColumn("Second column");
        secondColumn.setMinWidth(150);
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("string2"));

        ObservableList<Property> data = FXCollections.observableArrayList();

        //table.setItems(data);

        table.getColumns().addAll(firstColumn, secondColumn);
        table.setPrefWidth(300);
        // сделать чтобы текст из поля для текста удалялся
        firstButton.setOnAction((event -> {
            data.add(new Property(textField.getText(),""));
            table.setItems(data);
        }));

        secondButton.setOnAction((event -> {
            int index = table.getFocusModel().getFocusedIndex();

            String buffer = data.get(index).getString1();

            data.remove(index);
            data.add(index, new Property("", buffer));

//            data.get(table.getFocusModel().getFocusedIndex()).setString1("");
//            data.get(table.getFocusModel().getFocusedIndex()).setString2(buffer);
            table.setItems(data);

        }));

        thirdButton.setOnAction((event -> {
            int index = table.getFocusModel().getFocusedIndex();
            String buffer = data.get(index).getString2();

            data.remove(index);
            data.add(index, new Property(buffer, ""));

            table.setItems(data);
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
