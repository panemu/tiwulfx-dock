package com.panemu.tiwulfx.control.dock;

import com.panemu.tiwulfx.control.dock.DetachableTabPane.TabStage;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

/**
 * Type providing access to creating custom {@link Stage} extending the base {@link TabStage}.
 * This allows the user to define the type of new {@link Stage}s to create when a tab is dragged outside its
 * containing {@link DetachableTabPane}.
 *
 * @author Matt Coley
 */
@FunctionalInterface
public interface TabStageFactory {
	/**
	 * @param priorParent
	 * 		The prior tab pane the tab belonged to.
	 * @param tab
	 * 		The tab being dragged into an empty space.
	 *
	 * @return New stage to contain the tab when the drop completes.
	 */
	TabStage createStage(DetachableTabPane priorParent, Tab tab);
}
