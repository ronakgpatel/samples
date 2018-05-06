package samples.designpatterns.bridgepattern;

public class AdhocRequestProcessor extends RequestProcessor {

	public AdhocRequestProcessor(Input input) {
		super(input);
	}

	@Override
	void process() {
		System.out.println("Adhoc Processing : " + inputData);
		inputData.processInput();

	}

}
