package samples.designpatterns.proxypattern;

public class ProxyPatternDemo {
public static void main(String[] args) {
	//Get the user status from another repository
	//String userStatus = user.getRegisteredStatus
	ApplicatioObj object = new ApplicationObjectProxy("userStatus");
	System.out.println(object.getUserAccessToken());
}
}
