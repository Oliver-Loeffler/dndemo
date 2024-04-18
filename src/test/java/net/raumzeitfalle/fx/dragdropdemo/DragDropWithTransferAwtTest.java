package net.raumzeitfalle.fx.dragdropdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DragDropWithTransferAwtTest extends FxTestTemplate {
    
    static {
        System.setProperty("testfx.robot", "awt");
    }
    
    Node dragSource;
    Node dropTarget;
    
    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        DragDropSourceScene sourceScene = new DragDropSourceScene().enableDragHandling();
        DragDropTargetScene targetScene = new DragDropTargetScene();
        dragSource = sourceScene.okayButton;
        dropTarget = targetScene.dropButton;
        
        HBox hbox = new HBox(sourceScene.scene.getRoot(), targetScene.scene.getRoot());
        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setX(100);
        stage.setY(100);
        stage.show();
        
    }
    
    @Test
    @DisplayName("With AWT robot everything works fine")
    void that_text_is_moved_from_source_to_target() throws Exception {
        drag(dragSource, MouseButton.PRIMARY).dropTo(dropTarget);      
        assertEquals("DRAG FROM HERE", ((Button)dropTarget).getText());
    }
}
