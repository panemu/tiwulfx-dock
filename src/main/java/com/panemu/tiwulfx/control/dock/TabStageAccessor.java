package com.panemu.tiwulfx.control.dock;

import javafx.event.EventTarget;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

/**
 * Type providing access to a {@link Stage} that supports drag and drop operations of {@link DetachableTabPane}.
 * This allows a {@link Tab} to be dragged onto a user-defined {@link Stage} so long as it implements this type.
 *
 * @author Matt Coley
 */
public interface TabStageAccessor extends EventTarget {
	/**
	 * @return Targeted stage.
	 */
	Stage getStage();
}