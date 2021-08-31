package com.panemu.tiwulfx.control.dock;

import javafx.event.EventTarget;
import javafx.stage.Stage;

/**
 * Type providing access to a {@link Stage} that supports drag and drop operations of {@link DetachableTabPane}.
 *
 * @author Matt Coley
 */
public interface TabStageAccessor extends EventTarget {
	/**
	 * @return Targeted stage.
	 */
	Stage getStage();
}