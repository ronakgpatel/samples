package samples.designpatterns.essence;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ContractEssenceImpl implements ContractEssence {

	private String customerName;
	private String supplierName;

	@Override
	public Contract createContract() {
		if(!validate())
			 throw new Error("Data not sufficient for Contract creation");
		Contract c = new ContractImpl(customerName,supplierName);
		c.setDuration(TimeUnit.DAYS.toMillis(365));
		return c;
	}

	@Override
	public void setCustomerName(String name) {
		customerName = name;
	}

	@Override
	public void setSupplierName(String name) {
		supplierName = name;

	}

	public boolean validate() {
		if (Objects.isNull(customerName) || Objects.isNull(supplierName))
			return false;
		if ("".equals(customerName.trim()) || "".equals(supplierName.trim()))
			return false;
		return true;
	}

}
