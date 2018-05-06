package samples.designpatterns.facade;

/**
 * This is actual facade class which is hides everything to the caller regarding
 * the internals of the system.
 */
public class ApplicationServiceImpl implements ApplicationService {

	public static class LazyHolder {
		static ApplicationService INSTANCE = new ApplicationServiceImpl();
	}

	public static ApplicationService getInstance() {
		return LazyHolder.INSTANCE;
	}

	public SaveRepository saveRepo;
	private DeleteRepository deleteRepo;

	private ApplicationServiceImpl() {
		this.saveRepo = new ServiceRepositoryImpl();
		this.deleteRepo =  new DeleteRepositoryImpl();
	}

	@Override
	public void saveSomething() {
		saveRepo.saveSomething();
	}

	@Override
	public void saveEverything() {
		saveRepo.saveEverything();
	}

	@Override
	public void deleteSomething() {
		deleteRepo.deleteSomething();
	}

	@Override
	public void deleteEverything() {
		deleteRepo.deleteEverything();
	}

}
