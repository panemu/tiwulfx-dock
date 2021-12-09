module com.panemu.tiwufxdock {
	exports com.panemu.tiwulfx.control.dock;
	exports com.panemu.tiwulfx.control.dock.demo1 to javafx.graphics;
	exports com.panemu.tiwulfx.control.dock.demo2 to javafx.graphics;
	
	requires java.desktop;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	
	opens com.panemu.tiwulfx.control.dock.demo1 to javafx.fxml;
	
}