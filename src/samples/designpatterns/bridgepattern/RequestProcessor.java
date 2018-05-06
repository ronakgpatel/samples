package samples.designpatterns.bridgepattern;

/**
 * defining the contract for processing any type of request.
 */
public abstract class RequestProcessor {
	protected Input inputData;

	public RequestProcessor(Input input) {
		this.inputData = input;
	}

	abstract void process();
}
