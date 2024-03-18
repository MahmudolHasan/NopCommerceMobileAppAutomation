package factory;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	private static final ThreadLocal<AndroidDriver> LocalDriver = new ThreadLocal<>();

	public static synchronized void setLocalDriver(AndroidDriver driver) {
		LocalDriver.set(driver);
		System.err.println("Setting Up driver");
		if (LocalDriver.get() == null) {
			System.err.println("Driver thread is empty from setup");
		}

	}

	public static synchronized AndroidDriver getLocalDriver() {
		if (LocalDriver.get() == null) {
			System.err.println("Driver thread is empty from get");
		}
		return LocalDriver.get();
	}
}
