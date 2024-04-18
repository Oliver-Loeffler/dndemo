package net.raumzeitfalle.fx.dragdropdemo;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;

public class DragDropSourceScene {

    public AnchorPane pane;
    
    public Scene scene;

    public Button okayButton;
    
    public DragDropSourceScene enableDragHandling() {
        okayButton.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ClipboardContent content = new ClipboardContent();
                content.putString(okayButton.getText());
                event.consume();
                okayButton.startFullDrag();
                okayButton.startDragAndDrop(TransferMode.ANY).setContent(content);
            }
        });
        
        okayButton.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag and drop gesture ended */
                /* if the data was successfully moved, clear it */
                if (event.getTransferMode() == TransferMode.MOVE) {
                    okayButton.setText("...");
                }
                event.consume();
            }
        });
        return this;
    }

    public DragDropSourceScene disableDragHandling() {
        okayButton.setOnDragDetected(null);
        okayButton.setOnDragDone(null);
        return this;
    }

    public DragDropSourceScene() {
        okayButton = new Button("DRAG FROM HERE");
        pane = new AnchorPane(okayButton);
        
        AnchorPane.setTopAnchor(okayButton, 15.0);
        AnchorPane.setLeftAnchor(okayButton, 15.0);
        AnchorPane.setRightAnchor(okayButton, 15.0);
        
        pane.setMinWidth(500);
        pane.setMinHeight(500);
        pane.setStyle("-fx-background-color: orange");
        scene = new Scene(pane, 500,500);
  
    }
}
