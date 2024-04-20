package net.raumzeitfalle.fx.dragdropdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DragDropWithoutTransferTest extends ApplicationTest {
    
    @BeforeAll
    public static void setup() {
        System.clearProperty("testfx.robot");
    }
    
    private Node dragSource;
    private Node dropTarget;
    
    @Override
    public void start(Stage stage) {
        DragDropSourceScene sourceScene = new DragDropSourceScene().disableDragHandling();
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
    @DisplayName("Here the drag and drop motion happens but no content exchange.")
    void that_text_is_moved_from_source_to_target() throws Exception {
        drag(dragSource, MouseButton.PRIMARY).dropTo(dropTarget);      
        assertEquals("DRAG FROM HERE", ((Button)dropTarget).getText());
    }
}
