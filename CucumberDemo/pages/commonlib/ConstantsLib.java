package commonlib;

public class ConstantsLib {

	public static String DEFAULT_TIMEOUT = "18000";

	public static int DEFAULT_TIMEOUT_IN_MILLISECONDS = 18000;

	public static int DEFAULT_TIMEOUT_IN_SECONDS = 180;

	public static String ONE_MINUTE_TIMEOUT = "60000";

	public static String THIRTY_SECOND_TIMEOUT = "30000";

	public static int DEFAULT_TIMEOUT_FOR_FIND_ELEMENT_IN_SECONDS = 180;

	public static void setDefaultTimeout(String timeout) {
		int parseInt = Integer.parseInt(timeout);
		if (parseInt > 0) {
			DEFAULT_TIMEOUT = timeout;
		}
	}

	public static void setDefaultTimeoutInMilliseconds(int timeoutInMilliseconds) {
		DEFAULT_TIMEOUT_IN_MILLISECONDS = timeoutInMilliseconds;
		DEFAULT_TIMEOUT_IN_SECONDS = timeoutInMilliseconds / 1000;
		DEFAULT_TIMEOUT = Integer.toString(DEFAULT_TIMEOUT_IN_MILLISECONDS);
	}

	public static void setDefaultTimeoutForFindElementInSeconds(int timeout) {
		DEFAULT_TIMEOUT_FOR_FIND_ELEMENT_IN_SECONDS = timeout;
	}

}
