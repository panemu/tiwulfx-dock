package com.panemu.tiwulfx.control.dock;

/**
 * Factory responsible to Instantiate new {@link DetachableTab} when a Tab is detached/docked.
 * Extend this class then implement {@link #init(DetachableTabPane)} method to customize the newly made tab pane.
 * <br>
 * You can change the implementation class of {@link DetachableTabPane} used by overriding {@link #create()}.
 *
 * @author amrullah
 */
public abstract class DetachableTabPaneFactory {

	/**
	 * @return New {@link DetachableTabPane} <i>(Or any child class)</i> instance.
	 */
	protected DetachableTabPane create() {
		return new DetachableTabPane();
	}

	/**
	 * @param source
	 * 		Tab pane to copy properties from.
	 *
	 * @return New {@link DetachableTabPane} with properties copied from the source tab pane.
	 */
	protected DetachableTabPane createAndInit(DetachableTabPane source) {
		final DetachableTabPane tabPane = create();
		tabPane.setSceneFactory(source.getSceneFactory());
		tabPane.setStageOwnerFactory(source.getStageOwnerFactory());
		tabPane.setScope(source.getScope());
		tabPane.setTabClosingPolicy(source.getTabClosingPolicy());
		tabPane.setCloseIfEmpty(true);
		tabPane.setDetachableTabPaneFactory(source.getDetachableTabPaneFactory());
		tabPane.setDropHint(source.getDropHint());
		init(tabPane);
		return tabPane;
	}

	/**
	 * Callback method to initialize newly created {@link DetachableTabPane} for the Tab that is being detached/docked.
	 *
	 * @param newTabPane
	 * 		Created tab pane to customize.
	 */
	protected abstract void init(DetachableTabPane newTabPane);
}
