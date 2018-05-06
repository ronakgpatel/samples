package samples.designpatterns.singleton;

public class ApplicationFactory {
	private ApplicationFactory() {
	}

	//Eager Loading
	private static ApplicationFactory INSTANCE = new ApplicationFactory();;

	public ApplicationFactory getInstance() {
		return INSTANCE;
	}
}
