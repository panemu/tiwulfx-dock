package com.panemu.tiwulfx.control.dock.demo1;

import com.panemu.tiwulfx.control.dock.DetachableTab;
import com.panemu.tiwulfx.control.dock.DetachableTabPane;
import com.panemu.tiwulfx.control.dock.DetachableTabPaneFactory;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

/**
 *
 * @author amrullah
 */
public class FrmDetachableTab extends VBox {

	 @FXML
    private DetachableTabPane tpnScope1;

    @FXML
    private DetachableTabPane tpnScope2;

    @FXML
    private DetachableTabPane tpnNoScope;
	
	public FrmDetachableTab() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(getClass().getSimpleName() + ".fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
		init();
	}

	private void init() {
		
		tpnScope1.getTabs().add(new DetachableTab("1 Scope1", createTabContent()));
		tpnScope1.getTabs().add(new DetachableTab("2 Scope1", createTabContent()));
		
		tpnScope1.setSceneFactory((param) -> {
			FrmScope1 frm = new FrmScope1();
			SplitPane sp = new SplitPane(param);
			VBox.setVgrow(sp, Priority.ALWAYS);
			frm.getChildren().add(sp);
			Scene scene1 = new Scene(frm);
			return scene1;
		});
		
		tpnScope1.setStageOwnerFactory(new Callback<Stage, Window>() {

			@Override
			public Window call(Stage param) {
				param.setTitle("Custom Stage & Scene");
				return getScene().getWindow();//return parent for the detached stage
			}
		});
		
		tpnScope2.getTabs().add(new DetachableTab("1 Scope2", createTabContent()));
		tpnScope2.getTabs().add(new DetachableTab("2 Scope2", createTabContent()));
		tpnScope2.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
		tpnNoScope.getTabs().add(new DetachableTab("1 No Scope", createTabContent()));
		tpnNoScope.getTabs().add(new DetachableTab("2 No Scope", createTabContent()));
		tpnNoScope.getTabs().add(new Tab("traditional tab"));
		tpnNoScope.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		tpnNoScope.setDetachableTabPaneFactory(new DetachableTabPaneFactory(){
			@Override
			protected void init(DetachableTabPane newTabPane) {
				newTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);
			}
		
		});
		tpnNoScope.setDropHint(new CustomDropHint());
	}
	
	private TableView createTabContent() {
		TableView tbl = new TableView();
		tbl.getColumns().addAll(new TableColumn<Object, Object>("Example"), new TableColumn<Object, Object>("Test"));
		return tbl;
	}
}
