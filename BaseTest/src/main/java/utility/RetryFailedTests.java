package utility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class RetryFailedTests implements IRetryAnalyzer {

	int	retryCount		= 0;

	int	maxRetryCount	= ConfigFile.maxRetryCount;

	public boolean retry(ITestResult result) {

		if (retryCount < maxRetryCount) {
			retryCount++;
			System.out.println("Retrying the failed tests");
			return true;
		}
		return false;
	}
}
