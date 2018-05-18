package samples.designpatterns.mediator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Demo {
	public static void main(String[] args) {

		final SharedSpace<Integer> intRepository = new ArraySharedSpace<>(32);
		IntProducer producer = new IntProducer(intRepository);
		IntConsumer consumer = new IntConsumer(intRepository);
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(producer);
		service.submit(consumer);
		
		ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);
		scheduledService.scheduleAtFixedRate(()->System.out.println("Remaining Capacity : " + intRepository.remainingCapacity()), 10, 100, TimeUnit.MILLISECONDS);
		
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdownNow();
		scheduledService.shutdownNow();

	}
}

class IntProducer implements Runnable {
	private SharedSpace<Integer> sharedSpace;

	IntProducer(SharedSpace<Integer> space) {
		this.sharedSpace = space;
	}

	@Override
	public void run() {
		while (true) {
			int element = ThreadLocalRandom.current().nextInt();
			System.out.println("Produced :" + element);
			sharedSpace.put(new Integer(element));
			try {
				TimeUnit.MILLISECONDS.sleep(element % 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class IntConsumer implements Runnable {
	private SharedSpace<Integer> sharedSpace;

	IntConsumer(SharedSpace<Integer> space) {
		this.sharedSpace = space;
	}

	@Override
	public void run() {
		while (true) {
			int element = sharedSpace.get();
			System.out.println("Consumed :" + element);
			try {
				TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt() % 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}