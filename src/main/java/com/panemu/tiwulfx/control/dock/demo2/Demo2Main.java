package com.panemu.tiwulfx.control.dock.demo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author amrul
 */
public class Demo2Main extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		final FrmDemo2 frmDemo2 = new FrmDemo2();
		Scene scene = new Scene(frmDemo2);
		stage.setTitle("TiwulFX Dock Demo2");
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
