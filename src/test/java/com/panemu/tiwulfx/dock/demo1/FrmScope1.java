package com.panemu.tiwulfx.dock.demo1;

import java.io.IOException;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author amrullah
 */
public class FrmScope1 extends VBox {
	private static int counter = 1;

	public FrmScope1() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(getClass().getSimpleName() + ".fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	@FXML
	void actionNewTab(ActionEvent event) {
		Set<Node> setNode = lookupAll(".tab-pane");
		if (!setNode.isEmpty()) {
			TabPane tabPane = (TabPane) setNode.iterator().next();
			tabPane.getTabs().add(new Tab("New Tab " + counter, new Label("Content New Tab " + counter++)));
		}
	}

}
