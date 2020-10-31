package com.panemu.tiwulfx.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		initTiwulFXConfiguration();
		final FrmDetachableTab frmData = new FrmDetachableTab();
		Scene scene = new Scene(frmData);
		stage.setTitle("Form 1");
		stage.setScene(scene);
		stage.setX(10);
		stage.setY(10);
		stage.show();
		
	}
	
	private void initTiwulFXConfiguration() {
		Logger.getLogger("com.panemu.tiwulfx").setLevel(Level.SEVERE);
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be launched
	 * through deployment artifacts, e.g., in IDEs with limited FX support.
	 * NetBeans ignores main().
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
