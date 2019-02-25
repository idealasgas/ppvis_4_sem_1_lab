import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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

            if (data.get(index).getString1() != ""){
                String buffer = data.get(index).getString1();

                data.remove(index);
                data.add(index, new Property("", buffer));
                table.setItems(data);
            }
        }));

        thirdButton.setOnAction((event -> {
            int index = table.getFocusModel().getFocusedIndex();
            if (data.get(index).getString2() != ""){
                String buffer = data.get(index).getString2();

                data.remove(index);
                data.add(index, new Property(buffer, ""));

                table.setItems(data);
            }
        }));

        HBox firstContainer = new HBox();
        firstContainer.getChildren().addAll(textField, firstButton, secondButton, thirdButton);
        firstContainer.setSpacing(10);

        HBox secondContainer = new HBox();
        secondContainer.getChildren().add(table);
        secondContainer.setSpacing(10);

        VBox mainContainer = new VBox();
        mainContainer.getChildren().addAll(firstContainer, secondContainer);
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(15));

        return mainContainer;
    }
}
