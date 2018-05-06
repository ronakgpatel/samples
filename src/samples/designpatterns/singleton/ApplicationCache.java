package samples.designpatterns.singleton;

public class ApplicationCache {
	private ApplicationCache() {
		// This is must for any class to be singleton
	}
	//Lazy initialization, object creation is deferred until it is
	//requested by getInstance
	private static class LazyHolder {
		static final ApplicationCache INSTANCE = new ApplicationCache();
	}

	public static ApplicationCache getInstance() {
		return LazyHolder.INSTANCE;
	}
}
