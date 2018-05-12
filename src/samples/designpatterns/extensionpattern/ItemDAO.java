package samples.designpatterns.extensionpattern;

import java.util.Arrays;
import java.util.List;

public class ItemDAO implements DAOInterface {
	public List<ItemDAOExtension> getExtensions() {
		return Arrays.asList(new CustomNotifyExtension(), new LowInventoryAlarm());
	}

	// Extensions are owned by the Object
	// Here NotifyExtension is owned by ItemDAO. It can not
	// exists without ItemDAO, observe inner class is "non-static"
	// If not it is defined as separate object, then it would
	// need to hold reference to ItemDAO as its constructor
	// argument.
	class NewColumnsExtension implements ItemDAOExtension {
		public boolean executeItemOperation() {
			// execute all the DB operations
			// that are to be executed which are added in future.
			return true;
		}
	}

	class CustomNotifyExtension implements ItemDAOExtension {
		public boolean executeItemOperation() {
			return false;
		}
	}

	class LowInventoryAlarm implements ItemDAOExtension {
		public boolean executeItemOperation() {
			return true;
		}

	}
}
