package samples.designpatterns.iterator;

public class IteratorPatternDemo {
	public static void main(String[] args) {
		CustomeCollection<String> collection = new CustomeCollection<>();
		collection.add("One");
		collection.add("Two");
		collection.add("Three");
		collection.add("Four");
		collection.add("Five");
		/**
		 * For each, internally iterator() only
		 */
		for (String s : collection) {
			System.out.println(s);
		}
	}
}
