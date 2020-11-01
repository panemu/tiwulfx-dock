package com.panemu.tiwulfx.control.dock;

import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;

/**
 *
 * @author amrullah
 */
class DetachableTabPathModel {

	private double tabPos;
	private double width;
	private double height;
	private double startX;
	private double startY;
	private final Path path;

	public DetachableTabPathModel(Path path) {
		this.path = path;
		this.path.getStyleClass().add("drop-path");
	}
	
	void refresh(double startX, double startY, double width, double height) {
		boolean regenerate = this.tabPos != -1
				  || this.width != width
				  || this.height != height
				  || this.startX != startX
				  || this.startY != startY;
		this.tabPos = -1;
		this.width = width;
		this.height = height;
		this.startX = startX;
		this.startY = startY;
		if (regenerate) {
			generateTabPath(path, startX + 2, startY + 2, width - 4, height - 4);
		}
	}
	
	void refresh(double tabPos, double width, double height) {
		boolean regenerate  = this.tabPos != tabPos
				  || this.width != width
				  || this.height != height;
		this.tabPos = tabPos;
		this.width = width;
		this.height = height;
		startX = 0;
		startY = 0;
		if (regenerate) {
			generateTabPath(path, tabPos, width - 2, height - 2);
		}
	}
	
	private void generateTabPath(Path path, double startX, double startY, double width, double height) {
		path.getElements().clear();
		MoveTo moveTo = new MoveTo();
		moveTo.setX(startX);
		moveTo.setY(startY);
		path.getElements().add(moveTo);//start
		path.getElements().add(new HLineTo(startX + width));//path width
		path.getElements().add(new VLineTo(startY + height));//path height
		path.getElements().add(new HLineTo(startX));//path bottom left
		path.getElements().add(new VLineTo(startY));//back to start
	}

	private void generateTabPath(Path path, double tabPos, double width, double height) {
		int tabHeight = 28;
		int start = 2;
		tabPos = Math.max(start, tabPos);
		path.getElements().clear();
		MoveTo moveTo = new MoveTo();
		moveTo.setX(start);
		moveTo.setY(tabHeight);
		path.getElements().add(moveTo);//start

		path.getElements().add(new HLineTo(width));//path width
		path.getElements().add(new VLineTo(height));//path height
		path.getElements().add(new HLineTo(start));//path bottom left
		path.getElements().add(new VLineTo(tabHeight));//back to start

		if (tabPos > 20) {
			path.getElements().add(new MoveTo(tabPos, tabHeight + 5));
			path.getElements().add(new LineTo(Math.max(start, tabPos - 10), tabHeight + 15));
			path.getElements().add(new HLineTo(tabPos + 10));
			path.getElements().add(new LineTo(tabPos, tabHeight + 5));
		} else {
			double tip = Math.max(tabPos, start + 5);
			path.getElements().add(new MoveTo(tip, tabHeight + 5));
			path.getElements().add(new LineTo(tip + 10, tabHeight + 5));
			path.getElements().add(new LineTo(tip, tabHeight + 15));
			path.getElements().add(new VLineTo(tabHeight + 5));
		}
	}
}
