package samples.designpatterns.essence;

public class Demo {
public static void main(String[] args) {
	ContractEssence essence = new ContractEssenceImpl();
	essence.setCustomerName("Customer1");
	essence.setSupplierName("Supplier1");
	Contract newContract = essence.createContract();
	System.out.println("Contact Created : " + newContract);
}
}
