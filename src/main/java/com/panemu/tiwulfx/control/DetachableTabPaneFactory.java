package com.panemu.tiwulfx.control;

/**
 * Factory responsible to Instantiate new DetachableTabPane when a Tab is
 * detached/docked. Extend this class then implement {@link #init(DetachableTabPane)} method.
 *
 * @author amrullah
 */
public abstract class DetachableTabPaneFactory {

	DetachableTabPane create(DetachableTabPane source) {
		DetachableTabPane tabPane = new DetachableTabPane();
		tabPane.setSceneFactory(source.getSceneFactory());
		tabPane.setStageOwnerFactory(source.getStageOwnerFactory());
		tabPane.setScope(source.getScope());
		tabPane.setTabClosingPolicy(source.getTabClosingPolicy());
		tabPane.setCloseIfEmpty(true);
		tabPane.setDetachableTabPaneFactory(source.getDetachableTabPaneFactory());
		init(tabPane);
		return tabPane;
	}

	/**
	 * Callback method to initialize newly created DetachableTabPane for the Tab
	 * that is being detached/docked.
	 *
	 * @param newTabPane
	 */
	protected abstract void init(DetachableTabPane newTabPane);
}
