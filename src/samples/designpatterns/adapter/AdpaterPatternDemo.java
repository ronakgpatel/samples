package samples.designpatterns.adapter;

/***
 * 
 * Problem statement : Two incompatible types needs to interact with each other.
 * In following example, we have two different types of charging supported.
 * Wired & Wireless. There are two types of phone available which needs charging
 * : SmartPhone & FeaturePhone. SmartPhones comes with Wireless charging
 * support. FeaturePhones comes with Wired charging support.
 * 
 * Now, there is requirement to launch the mid range phone which falls in
 * category of FeaturePhone but must have Wireless charging support.
 * 
 * So we must make sure that "NotSoOldFeaturePhone" which in normal case would
 * support charging case, actually should adapt itself to "Wireless Charging".
 * 
 * @author
 *
 */
public class AdpaterPatternDemo {

	/**
	 * Wireless charging support.
	 *
	 */
	static interface WirelessChargerPlug {
		void startWirelessCharging();
	}

	/**
	 * Latest range of phones supporting wireless charging.
	 *
	 */
	static interface Smartphone {
		void charge(WirelessChargerPlug plug);
	}

	/**
	 * Concrete implementation of @link {@link Smartphone}
	 */
	public static class LatestSmartphone implements Smartphone {
		@Override
		public void charge(WirelessChargerPlug plug) {
			plug.startWirelessCharging();
		}
	}

	/**
	 * Plug for the devices which supports only wired charging.
	 */
	static interface WiredChargerPlug {
		void startWiredCharging();
	}

	/**
	 * Feature phones which are classic phones.
	 */
	static interface FeaturePhone {
		void charge(WiredChargerPlug plug);
	}

	/**
	 * Concrete implementation of @link {@link FeaturePhone}
	 */
	public static class OldFeaturePhone implements FeaturePhone {
		@Override
		public void charge(WiredChargerPlug plug) {
			plug.startWiredCharging();
		}
	}

	/**
	 * Now, this is the adapter class. This class makes sure that if we have
	 * wiredChargingPlug support available, then we can make it WirelessCharging.
	 * 
	 * Observe that it implements @link {@link WiredChargerPlug} interface and
	 * contains the @link {@link WirelessChargerPlug} instance as its field.
	 * Therefore when startWiredCharging is invoked, we can adapt it to wireless
	 * charging.
	 */
	public static class WiredToWirelessAdapterUsingComposition implements WiredChargerPlug {

		private WirelessChargerPlug wirelessChargerPlug;

		public WiredToWirelessAdapterUsingComposition(WirelessChargerPlug plug) {
			this.wirelessChargerPlug = plug;
		}

		@Override
		public void startWiredCharging() {
			this.wirelessChargerPlug.startWirelessCharging();
		}
	}
	
	/**
	 * Now, this is the adapter class. This class makes sure that if we have
	 * wiredChargingPlug support available, then we can make it WirelessCharging.
	 * 
	 * Observe that it implements @link {@link WiredChargerPlug} interface and {@linkp WirelessChargerPlug} both 
	 * interfaces or could have extended the abstract classes as well, if available.
	 * Therefore when startWiredCharging is invoked, we can adapt it to wireless
	 * charging.
	 */
	public static class WiredToWirelessAdapterUsingInheritance implements WiredChargerPlug,WirelessChargerPlug {


		public WiredToWirelessAdapterUsingInheritance() {
		}

		@Override
		public void startWiredCharging() {
			startWirelessCharging();
		}

		@Override
		public void startWirelessCharging() {
			System.out.println("Doing charging wirelessly");
		}
	}

	public static void main(String[] args) {
		Smartphone latestPhone = new LatestSmartphone();
		FeaturePhone oldPhone = new OldFeaturePhone();

		latestPhone.charge(() -> System.out.println("Starting wireless charging..."));
		oldPhone.charge(() -> System.out.println("Starting wired charging..."));

		FeaturePhone wiresslessChargingSupportedOldPhone = new OldFeaturePhone();
		WiredChargerPlug adapter = new WiredToWirelessAdapterUsingComposition(
				() -> System.out.println("Starting wireless charging for Adapter"));
		wiresslessChargingSupportedOldPhone.charge(adapter);

	}
}
