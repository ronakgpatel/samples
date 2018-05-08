package samples.designpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class ApplicationClient implements Observer {

	public ApplicationClient() {
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Updated received from : " + o + ", with message : " + arg);
	}

}
