package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtendsReport.ExtendsReportGenerator;
import Utilities.screenShots;

public class MyListeners extends pojo.Browser implements ITestListener{
	ExtentReports report=ExtendsReportGenerator.getExtendsReport();
	ExtentTest eTest;
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		eTest=report.createTest(testName);
		eTest.log(Status.INFO,testName+"Has Started Execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		eTest.log(Status.PASS,testName+"Has Successfully Executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String testName=result.getName();
		eTest.log(Status.FAIL,testName+"Got Failed");
		try {
			eTest.addScreenCaptureFromPath(screenShots.getScreenShots(driver,testName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName=result.getName();
		eTest.log(Status.SKIP, testName+"Got Skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
	   report.flush();
	}
	
	
	

}
