package samples.designpatterns.extensionpattern;

import java.util.List;
public interface DAOInterface {
	//All standard DAO operations for 
	// the entities goes here.
	//public <? extends DAOObject> get();
	//public boolean remove();
	List<? extends DAOExtension> getExtensions();
}
