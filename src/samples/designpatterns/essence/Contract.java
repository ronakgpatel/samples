package samples.designpatterns.essence;
/**
 * Interface for contract object
 */
public interface Contract {
	String getCustomerName();
	String getSupplierName();
	void setStartDate(long time);
	long getStartDate();
	long getDuration();
	void setDuration(long time);
}
