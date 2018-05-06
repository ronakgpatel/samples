package samples.designpatterns.bridgepattern;

public class BridgePatternDemo {

	public static void main(String[] args) {
		Input xmlData = new XMLInput();
		Input json = new JsonInput();
		RequestProcessor reqProcessor = new AdhocRequestProcessor(xmlData);
		reqProcessor.process();
		RequestProcessor scheduledProcessor = new ScheuledRequestProcessor(xmlData);
		scheduledProcessor.process();
	}
}
