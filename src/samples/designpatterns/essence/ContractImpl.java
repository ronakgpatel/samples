package samples.designpatterns.essence;

public class ContractImpl implements Contract {
	private final String customerName;
	private final String supplierName;
	private long startDate;
	private long duration;

	 ContractImpl(String customerName, String supplierName) {
		this.customerName = customerName;
		this.supplierName = supplierName;
	}

	@Override
	public String getCustomerName() {
		return customerName;
	}

	@Override
	public String getSupplierName() {
		return supplierName;
	}

	@Override
	public void setStartDate(long time) {
		this.duration = time;
	}

	@Override
	public long getStartDate() {
		return startDate;
	}

	@Override
	public long getDuration() {
		return duration;
	}

	@Override
	public void setDuration(long time) {
		this.startDate = time;
	}

}
