package samples.designpatterns.extensionpattern;

import java.util.Collections;
import java.util.List;

public class OrderDAO implements DAOInterface {
	public List<? extends DAOExtension> getExtensions() {
		return Collections.emptyList();
	}
}
