package samples.designpatterns.proxypattern;

public class ApplicationObjectImpl implements ApplicatioObj {
	public String getUserAccessToken() {
		return "secureToken";
	}
}
