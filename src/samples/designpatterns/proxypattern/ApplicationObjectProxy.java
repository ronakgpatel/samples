package samples.designpatterns.proxypattern;

public class ApplicationObjectProxy implements ApplicatioObj {
	private String userRegisteredStatus;
	private ApplicationObjectImpl actualObject;
	public ApplicationObjectProxy(String userAccess) {
		this.userRegisteredStatus = userAccess;
		this.actualObject = new ApplicationObjectImpl();
	}
	public String getUserAccessToken() {
		if ("registered".equals(userRegisteredStatus))
			return actualObject.getUserAccessToken();
		else
			return null;
	}
}
