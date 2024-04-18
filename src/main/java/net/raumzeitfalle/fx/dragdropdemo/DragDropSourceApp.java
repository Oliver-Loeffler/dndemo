package net.raumzeitfalle.fx.dragdropdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DragDropSourceApp extends Application {

    public DragDropSourceScene sourceScene = new DragDropSourceScene();
    public DragDropTargetScene targetScene = new DragDropTargetScene();
        
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        HBox hbox = new HBox(sourceScene.scene.getRoot(), targetScene.scene.getRoot());
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.setX(100);
        primaryStage.setY(100);
        primaryStage.show();
    }
    

}
