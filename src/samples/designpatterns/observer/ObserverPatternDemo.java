package samples.designpatterns.observer;

public class ObserverPatternDemo {
	public static void main(String[] args) {
		
		//Following are two independent classes which needs to communicate
		//if the System is refreshed.
		SupportManagerImpl impl = new SupportManagerImpl(); //Observable - It can provide updates
		ApplicationClient client = new ApplicationClient(); //Observer - It want updates
		
		impl.addObserver(client);//Set the relationship, tell the Observable regarding its Observer
		impl.enableSupport("Search And Store");//Adding new support in the system
		impl.enableSupport("bookMark");
		impl.enableSupport("Delete");
		//no events are published since only on 'refresh()' it should do so.
		impl.refresh(); //Update published, seen in output
		impl.enableSupport("Register"); //without invoking refresh, no event should be published.
	}
}
