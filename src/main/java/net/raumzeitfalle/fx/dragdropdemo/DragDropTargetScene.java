package net.raumzeitfalle.fx.dragdropdemo;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;

/*
 * https://docs.oracle.com/javafx/2/drag_drop/jfxpub-drag_drop.htm
 */
public class DragDropTargetScene {

    public AnchorPane pane;
    
    public Scene scene;
    
    public Button dropButton;
    
    public DragDropTargetScene() {
        dropButton = new Button("...");
        pane = new AnchorPane(dropButton);
        
        AnchorPane.setBottomAnchor(dropButton, 5.0);
        AnchorPane.setRightAnchor(dropButton, 5.0);
        AnchorPane.setLeftAnchor(dropButton, 5.0);
        
        pane.setMinWidth(500);
        pane.setMinHeight(500);
        pane.setStyle("-fx-background-color: blue");
        scene = new Scene(pane, 500,500);
        
        dropButton.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                /* accept it only if it is not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != dropButton &&
                        event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
        
        dropButton.setOnDragDropped(new EventHandler<DragEvent>() {

            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                   dropButton.setText(db.getString());
                   success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                event.consume();
            }

        });
    }
}
