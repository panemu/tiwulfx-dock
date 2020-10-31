package com.panemu.tiwulfx.control;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Node;
import javafx.scene.control.Tab;

/**
 *
 * @author amrullah
 */
public class DetachableTab extends Tab {
	private BooleanProperty detachable = new SimpleBooleanProperty(true);

	public DetachableTab() {
		super();
	}

	public DetachableTab(String string) {
		super(string);
	}

	public DetachableTab(String text, Node content) {
		super(text, content);
	}
	
	public boolean isDetachable() {
		return detachable.get();
	}

	public void setDetachable(boolean detachable) {
		this.detachable.set(detachable);
	}
	public BooleanProperty detachableProperty() {
		return detachable;
	}
	
}
