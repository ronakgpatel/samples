package samples.designpatterns.bridgepattern;

public class ScheuledRequestProcessor extends RequestProcessor {

	public ScheuledRequestProcessor(Input requestData) {
		super(requestData);
	}

	@Override
	public void process() {
		System.out.println("Scheduled Processing : " + inputData);
		inputData.processInput();
	}

}
