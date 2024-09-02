package com.panemu.tiwulfx.control.dock;

import com.panemu.tiwulfx.control.dock.DetachableTabPane.TabStage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Factory providing access to create custom {@link Stage} implementations.
 * This allows the user to define the type of new {@link Stage}s to create when a tab is dragged outside its
 * containing {@link DetachableTabPane}.
 *
 * @param <S> The base type of stage this factory creates.
 * @author Matt Coley
 */
@FunctionalInterface
public interface TabStageFactory<S extends Stage & TabStageAccessor> {
	/**
	 * Provides the new stage for the dropped tab to appear in.
	 * <p>
	 * Unlike {@link #createStage(DetachableTabPane, Tab)}, this method
	 * doesn't modify the new stage with default configuration.
	 *
	 * @param priorParent
	 * 		The prior tab pane the tab belonged to.
	 * @param tab
	 * 		The tab being dragged into an empty space.
	 *
	 * @return New stage provided to contain the tab when the drop completes.
	 * @see #createStage(DetachableTabPane, Tab)
	 */
	S provide(DetachableTabPane priorParent, Tab tab);

	/**
	 * @param priorParent
	 * 		The prior tab pane the tab belonged to.
	 * @param tab
	 * 		The tab being dragged into an empty space.
	 *
	 * @return New stage created and initialized with default configuration
	 * to contain the tab when the drop completes.
	 */
	default S createStage(DetachableTabPane priorParent, Tab tab) {
		final S stage = provide(priorParent, tab);

		// If the provided instance is a TabStage, don't apply the following
		// as it's done within TabStage's constructor already.
		if (!(stage instanceof TabStage)) {
			// Create a new DetachableTabPane with information based on the tab pane the tab
			// was previously associated with.
			final DetachableTabPane tabPane = priorParent.getDetachableTabPaneFactory().createAndInit(priorParent);
			stage.initOwner(tabPane.getStageOwnerFactory().call(stage));
			final Scene scene = tabPane.getSceneFactory().call(tabPane);

			scene.getStylesheets().addAll(priorParent.getScene().getStylesheets());
			stage.setScene(scene);

			final Point p = MouseInfo.getPointerInfo().getLocation();
			stage.setX( p.x - (DetachableTabPane.STAGE_WIDTH >> 1) );
			stage.setY( p.y );
			stage.show();
			tabPane.getTabs().add(tab);
			tabPane.getSelectionModel().select(tab);
			if (tab.getContent() instanceof Parent) {
				((Parent) tab.getContent()).requestLayout();
			}
		}

		return stage;
	}
}
