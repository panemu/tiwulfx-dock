package com.panemu.tiwulfx.control.dock.demo2;

import com.panemu.tiwulfx.control.dock.DetachableTabPane;
import java.util.Set;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author amrul
 */
public class FrmDemo2 extends VBox {
	private DetachableTabPane tabPane;
	private int counter = 1;
	private Label lblSplitpane = new Label();
	private Label lblTabPane = new Label();
	public FrmDemo2() {
		HBox pnlTop = new HBox(new Label("DEMO2"));
		
		HBox pnlClient = new HBox();
		VBox.setVgrow(pnlClient, Priority.ALWAYS);
		getChildren().setAll(pnlTop, pnlClient);
		
		VBox pnlLeft = new VBox();
		pnlLeft.setSpacing(10);
		pnlLeft.setPadding(new Insets(10));
		pnlLeft.setPrefWidth(300);
		tabPane = new DetachableTabPane();
		tabPane.setOnClosedPassSibling((sibling) -> tabPane = sibling);
		tabPane.setStageOwnerFactory((stage) -> getScene().getWindow());
		SplitPane sp = new SplitPane();
		HBox.setHgrow(sp, Priority.ALWAYS);
		sp.getItems().add(tabPane);
		pnlClient.getChildren().setAll(pnlLeft, sp);
		Button btnNewTab = new Button("New Tab");
		btnNewTab.setOnAction(e -> newTab());
		pnlLeft.getChildren().add(btnNewTab);
		
		Button btnScan = new Button("Scan Components");
		pnlLeft.getChildren().addAll(btnScan, lblSplitpane, lblTabPane);
		btnScan.setOnAction(e -> scan());
		
	}
	
	private void scan() {
		Parent p = getScene().getRoot();
		final Set<Node> collSplitpane = p.lookupAll(".split-pane");
		final Set<Node> collTabPane = p.lookupAll(".detachable-tab-pane");
		lblSplitpane.setText("SplitPane count: " + collSplitpane.size());
		lblTabPane.setText("DetachableTabPane count: " + collTabPane.size());
	}
	
	private void newTab(){
		Label lbl = new Label("Content of Tab " + counter);
		StackPane sp = new StackPane(lbl);
		sp.setPadding(new Insets(10));
		Tab tab = new Tab("New Tab " + counter);
		tab.setContent(sp);
		tabPane.getTabs().add(tab);
		counter++;
	}
	
}
