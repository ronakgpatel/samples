package samples.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SupportManagerImpl extends Observable implements SupportManager {
	private List<String> supportList = new ArrayList<>();
	private StringBuilder strUpdateMessage = new StringBuilder();

	public void enableSupport(String newFeature) {
		setChanged(newFeature);
		supportList.add(newFeature);
	}

	/**
	 * The events or notifications are not broadcast until the user invokes refresh
	 * method.
	 */
	public synchronized void refresh() {
		super.notifyObservers(strUpdateMessage.toString());
		strUpdateMessage = new StringBuilder();
	}

	protected synchronized void setChanged(String featureName) {
		super.setChanged();
		strUpdateMessage.append(featureName).append(" ");
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		super.deleteObserver(o);
	}

	@Override
	public String toString() {
		return "SupportManagerImpl [supportList=" + supportList + "]";
	}

}
