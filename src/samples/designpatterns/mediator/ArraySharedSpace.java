package samples.designpatterns.mediator;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/** 
 * Concrete implementation of the SharedSpace
 * @param <E>
 */
public class ArraySharedSpace<E> implements SharedSpace<E> {
	private final int size;
	private final BlockingQueue<E> listOfElements;

	public ArraySharedSpace(int size) {
		if (size <= 0)
			size = 16;
		this.size = size;
		listOfElements = new ArrayBlockingQueue<>(size);
	}

	@Override
	public void put(E e) {
		try {
			listOfElements.put(e);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public E get() {
		try {
			return listOfElements.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int remainingCapacity() {
		return listOfElements.remainingCapacity();
	}

	public int getSize() {
		return size;
	}

}
