import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.animation.AnimationTimer;

import java.util.concurrent.ThreadLocalRandom;

public class IndividualTask {
    TableView<int[]> table;
    int[][] data;
    volatile boolean moving;
    volatile int step;
    volatile boolean needUpdate;

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

        needUpdate = false;

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(needUpdate){
                    if (isRightMove()){
                        table.refresh();
                    }
                    if (isDownMove()) {
                        printMatrix(table, data);
                    }
                    needUpdate = false;
                }
            }
        };

        move.setOnAction(event -> {
            animationTimer.start();

            step = 1;
            moving = true;
            moveRightThread();
            moveDownThread();
        });

        stop.setOnAction(event -> {
            stop();
        });

        panel.getChildren().addAll(width, height, makeTable, move, stop);
        panel.setSpacing(10);
        main.getChildren().addAll(panel, tableBox);
        main.setPadding(new Insets(15));
        main.setSpacing(10);
        return main;
    }

    private boolean isRightMove() {
        return step == 1 || step == 2;
    }

    private boolean isDownMove() { return step == 3;}

    private void stop(){
        moving = false;
    }

    private TableView<int[]> getTable(int width, int height){
        data = new int[width][height];
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                data[i][j] = ThreadLocalRandom.current().nextInt(0, 2);
            }
        }

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

    private void moveDown(){
        int[] temp = data[data.length - 1];
        for (int i = data.length - 1; i > 0; i--){
            data[i] = data[i-1];
        }
        data[0] = temp;
    }

    private void moveRight(){
        for (int[] row: data) {
            int temp = row[row.length - 1];
            for(int i = row.length - 1; i > 0; i--){
                row[i] = row[i-1];
            }
            row[0] = temp;
        }
    }

    private void moveRightThread(){
        new Thread(() -> {
            while (moving) {
                if (isRightMove()) {
                    moveRight();
                    needUpdate = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (step == 1) {
                        step = 2;
                    } else {
                        step = 3;
                    }
                }
            }
        }).start();
    }

    private void moveDownThread(){
        new Thread(() -> {
            while (moving) {
                if (isDownMove()){
                    moveDown();
                    needUpdate = true;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    step = 1;
                }
            }
        }).start();
    }
}
