package com.panemu.tiwulfx.control.dock.demo1;

import com.panemu.tiwulfx.control.dock.TabDropHint;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.SVGPath;

/**
 *
 * @author amrullah
 */
public class CustomDropHint extends TabDropHint {
	
	private AnchorPane dropGuide = new AnchorPane();
	private AnchorPane wrapper = new AnchorPane();
	private SVGPath arrow = new SVGPath();

	public CustomDropHint() {
		arrow.setContent("M1.745 14.475l-1.11-1.11c-.47-.47-.47-1.23 0-1.695L10.35 1.95c.47-.47 1.23-.47 1.695 0l9.715 9.715c.47.47 .47 1.23 0 1.695L20.65 14.47c-.475.475-1.25.465-1.715-.02L13.2 8.43V22.8c0 .665-.535 1.2-1.2 1.2h-1.6c-.665 0-1.2-.535-1.2-1.2V8.43L3.46 14.455c-.465.49-1.24.5-1.715.02z");
		arrow.setFill(Paint.valueOf("green"));
		dropGuide.setStyle("-fx-border-width: 3;-fx-border-color: green;");
		/**
		 * somehow the css style of dropGuide only works if it is inside a wrapper.
		 */
		wrapper.getChildren().add(dropGuide);
	}
	
	

	@Override
	protected void generateInsertionPath(Path path, double tabPos, double width, double height) {
		double tabHeight = getTabAreaPos();
		int start = 2;
		dropGuide.getChildren().clear();
		dropGuide.setLayoutX(start);
		dropGuide.setLayoutY(tabHeight);
		dropGuide.setPrefSize(width, height - tabHeight);
		if (tabPos > 20) {
//			path.getElements().add(new MoveTo(tabPos, tabHeight + 5));
//			dropGuide.getChildren().add(new Circle(tabPos, tabHeight + 5, 10));
			arrow.setLayoutX(tabPos - 10);
			arrow.setLayoutY(2);
			arrow.setRotate(0);
			dropGuide.getChildren().add(arrow);
		} else {
			double tip = Math.max(tabPos , start);
			arrow.setLayoutX(tip);
			arrow.setLayoutY(0);
			arrow.setRotate(315);
			dropGuide.getChildren().add(arrow);
		}
		
//		dropGuide.getChildren().add(path);
	}

	@Override
	protected void generateAdjacentPath(Path path, double startX, double startY, double width, double height) {
		dropGuide.getChildren().clear();
		dropGuide.setLayoutX(startX);
		dropGuide.setLayoutY(startY);
		dropGuide.setPrefSize(width, height);
	}
	
	

	@Override
	public Node getPath() {
		return wrapper;
	}
	
	
	
}
