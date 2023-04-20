package report;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.core.exception.CucumberException;
import io.cucumber.core.internal.utils.FileUtil;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.TestStepStarted;

public class TestReportGenerator implements ConcurrentEventListener {
    
    private static final String REPORT_DIR = "target" + File.separator + "cucumber-reports" + File.separator + "extent-report";
    private ExtentReports extent;
    private List<String> jsonFiles = new ArrayList<>();

    public TestReportGenerator() {
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(REPORT_DIR + File.separator + "index.html");
        htmlReporter.config().setTheme(Theme.DARK);
        extent.attachReporter(htmlReporter);
    }
    
    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
    }
    
    private void handleTestStepStarted(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
            String featureName = step.getUri().toString();
            String scenarioName = step.getStep().getText();
            String testName = featureName + ":" + scenarioName;
            ExtentTest test = extent.createTest(testName, "");
            test.assignCategory(step.getStep().getKeyword());
        }
    }
    
    private void handleTestStepFinished(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
            String featureName = step.getUri().toString();
            String scenarioName = step.getStep().getText();
            String testName = featureName + ":" + scenarioName;
            TestCase testCase = step.getTestCase();
            if (testCase.getStatus().isOk()) {
                extent.createTest(testName).pass("Step passed");
            } else if (testCase.getStatus().isFailed()) {
                extent.createTest(testName).fail(event.getResult().getError());
            } else if (testCase.getStatus().isSkipped()) {
                extent.createTest(testName).skip(event.getResult().getError());
            }
        }
    }

    public void addJsonFile(File file) {
        jsonFiles.add(file.getAbsolutePath());
    }

    public void generateReport() {
        try {
            FileUtil.ensureDirectoryExists(new File(REPORT_DIR));
            FileUtil.copyDir(new File("src" + File.separator + "test" + File.separator + "resources" + File.separator + "static"),
                    new File(REPORT_DIR));
            extent.setReportUsesManualConfiguration(true);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Framework", "Cucumber JVM with Selenium");
            extent.setSystemInfo
