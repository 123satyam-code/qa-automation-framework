package util.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY = 1; // retry once

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < MAX_RETRY) {
            retryCount++;
            System.out.println("🔁 Retrying test: "
                    + result.getMethod().getMethodName()
                    + " | Retry count: " + retryCount);
            return true;
        }
        return false;
    }
}
