package samples.designpatterns.extensionpattern;

public class ExtensionPatternDemo {
	public static void main(String[] args) {
		DAOInterface daoOps = new ItemDAO();
		daoOps.getExtensions().forEach(e -> System.out.println("Item Executed extension : " + e));
		new OrderDAO().getExtensions().forEach(e -> System.out.println("Order Executed extension : " + e));
	}
}
