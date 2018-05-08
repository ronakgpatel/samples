package samples.designpatterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomeCollection<E> implements Iterable<E> {

	private List<E> data = new ArrayList<>();

	public void add(E element) {
		data.add(element);
	}

	public boolean remove(E element) {
		return data.remove(element);
	}

	public boolean contains(E element) {
		return data.contains(element);
	}

	public static class OddIterator<E> implements Iterator<E> {

		private int index = 0;
		private List<E> data;

		OddIterator(List<E> data) {
			this.data = data;
		}

		@Override
		public boolean hasNext() {
			return index < data.size();
		}

		@Override
		public E next() {
			index += 2;
			return data.get(index - 2);
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new OddIterator<E>(this.data);
	}

}
