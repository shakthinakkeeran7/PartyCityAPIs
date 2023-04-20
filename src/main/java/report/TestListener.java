package report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Code to execute when a test case starts
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to execute when a test case passes
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Code to execute when a test case fails
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute when a test case is skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code to execute when a test case fails but within success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before the start of the test suite
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to execute after the completion of the test suite
    }
}
