package libraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class HTMLReport {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public ExtentTest test,node;
	public String authors,category;
	public static ThreadLocal<ExtentTest> tlNode = new ThreadLocal<ExtentTest>();
	
	public void startReport() {
		spark = new ExtentSparkReporter("./report/UIBankReport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	public void endReport() {
		extent.flush();
	}
	
	public ExtentTest getNode() {
		return tlNode.get();
	}
	
	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		test = extent.createTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);
		return test;
	}

	public ExtentTest startTestcase(String nodes) {
		//getNode() = test.createNode(nodes);
		tlNode.set(test.createNode(nodes));
		return getNode();
	}
	
	public void reportStep(String desc,String status) {
		if(status.equalsIgnoreCase("pass")){
			getNode().pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
			} else if(status.equalsIgnoreCase("fail")) {
				getNode().fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());	
			} else {
				getNode().info(desc);	
			}
	}
	
	public abstract String takeScreenshot();

}
