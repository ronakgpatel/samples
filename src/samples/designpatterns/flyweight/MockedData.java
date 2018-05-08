package samples.designpatterns.flyweight;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockedData implements Data<String> {

	private List<String> data;

	public MockedData(int version) {
		simulateData(version);
	}

	private void simulateData(int version) {
		data = IntStream.range(0, 10_000).filter(i -> i % version == 0).mapToObj(String::valueOf)
				.collect(Collectors.toList());
	}

	@Override
	public List<String> getData() {
		return data;
	}
}
