package samples.designpatterns.mediator;

/**
 * This class to be used a  mediator between two set of 
 * objects which want to use the same space.
 *
 * @param <E>
 */
public interface SharedSpace<E> {
	public void put(E e);
	public E get();
	public int remainingCapacity();
}
