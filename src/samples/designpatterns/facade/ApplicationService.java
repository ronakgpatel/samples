package samples.designpatterns.facade;

/**
 * This is facade interface defining the
 * contract for all the operation it
 * hides.
 */
public interface ApplicationService {
	
	void saveSomething();
	void saveEverything();
	void deleteSomething();
	void deleteEverything();

}
