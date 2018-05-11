package samples.designpatterns.nullpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class NullPatternDemo {
	public static void main(String[] args) {
		Result<Integer> intResults = getRandomResults();
		for(Integer vals : intResults.get()) {
			System.out.println(vals);
		}
	}
	// Do nothing behavior
	static class EmptyResult<T> implements Result<T> {
		public static Result EMPTY_RESULT = new EmptyResult<>();
		// Do nothing object
		private static final List EMPTY_LIST = new ArrayList<>();
		public List get() {
			return EMPTY_LIST;
		}
		public static <T> EmptyResult<T> getEmpty() {
			return (EmptyResult<T>) EMPTY_RESULT;
		}
	}
	static class IntResult implements Result<Integer> {
		private List<Integer> resultList;

		IntResult(List<Integer> resultList) {
			this.resultList = resultList;
		}
		public List<Integer> get() {
			return resultList;
		}
	}
	public static Result<Integer> getRandomResults() {
		int random = ThreadLocalRandom.current().nextInt();
		if (random % 2 == 0)
			return new IntResult(createList());
		return EmptyResult.getEmpty();
	}

	private static List<Integer> createList() {
		return IntStream.range(1, 11).collect(ArrayList::new, List::add, List::addAll);
	}
}
