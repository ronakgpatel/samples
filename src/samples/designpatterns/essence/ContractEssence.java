package samples.designpatterns.essence;
/**
 * Interface that defines the contract for the
 * essence of the object.
 */
public interface ContractEssence {
	Contract createContract();
	void setCustomerName(String name);
	void setSupplierName(String name);
}
