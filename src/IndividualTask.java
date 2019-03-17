import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class IndividualTask {
    TableView<int[]> table;
    int[][] data;
    boolean Moving;

    public VBox getBox() {
        Button makeTable = new Button("make table");
        Button move = new Button("move");
        Button stop = new Button("stop");
        TextField height = new TextField();
        TextField width = new TextField();
        VBox tableBox = new VBox();
        VBox main = new VBox();
        HBox panel = new HBox();

        makeTable.setOnAction(event -> {
            table = getTable(Integer.parseInt(height.getText()), Integer.parseInt(width.getText()));
            tableBox.getChildren().add(table);
        });

        move.setOnAction(event -> {
//            Thread thread = moveContinuously();
//            thread.start();
            moveContinuously();
        });

        stop.setOnAction(event -> stop());

        panel.getChildren().addAll(width, height, makeTable, move, stop);
        panel.setSpacing(10);
        main.getChildren().addAll(panel, tableBox);
        main.setPadding(new Insets(15));
        main.setSpacing(10);
        return main;
    }

    private void stop(){
        Moving = false;
    }

    private void moveContinuously(){
        Platform.runLater(
            () -> {
                new Thread(()->{
                    Moving = true;
                    while(Moving){
                        moveCells();
                        printMatrix(table, data);
                        try {
                            Thread.sleep(2000);
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        );

    }

    private void moveCells(){
        Platform.runLater(
                () -> {
                    new Thread(()->{
                        move(data);
                    }).start();
                }
        );
    }

    private TableView<int[]> getTable(int width, int height){
        data = new int[width][height];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                data[i][j] = ThreadLocalRandom.current().nextInt(0, 2);
//                data[i][j] = 0;
            }
        }

//        data[0][0] = 1;

        TableView<int[]> table = new TableView<>();
        printMatrix(table, data);
        return table;
    }

    private void printMatrix(TableView<int[]> target, int[][] source) {

        target.getColumns().clear();
        target.getItems().clear();

        int numRows = source.length ;
        if (numRows == 0) return ;

        int numCols = source[0].length ;

        for (int i = 0 ; i < numCols ; i++) {
            TableColumn<int[], Number> column = new TableColumn<>("Column "+i);
            final int columnIndex = i ;
            column.setCellValueFactory(cellData -> {
                int[] row = cellData.getValue();
                return new SimpleDoubleProperty(row[columnIndex]);
            });
            target.getColumns().add(column);
        }

        for (int i = 0 ; i < numRows ; i++) {
            target.getItems().add(source[i]);
        }
    }

    private void move(int[][] array){
        int[][] dataCopy = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                change(array, dataCopy, i, j);
            }
        }



        data = dataCopy;
    }

    private void change(int[][] source, int[][] target, int i, int j){
        int x, y;
        if (i == source.length - 1){
            x = 0;
        } else {
            x = i + 1;
        }
        if (j == source[0].length - 1){
            y = 1;
        } else if (j == source[0].length - 2){
            y = 0;
        } else {
            y = j + 2;
        }

        target[x][y] = source[i][j];
    }
}
