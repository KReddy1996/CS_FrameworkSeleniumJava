package com.mystore.utilities;



import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentListenerClass implements ITestListener
{
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		ReadConfig readconfig=new ReadConfig();
	
		
//		 DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/dd/MM/HH/mm");
//		 String reportFolder="Reports/"+df.format(LocalDateTime.now())+"/ExtentListenerReport.html";
//		 System.out.println(reportFolder);
//		System.out.println("=====================33333======================");
		
		String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName="MyStoreTestReport-"+timestamp+".html";
		
		htmlreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		//add system information/enviroment info to reports
		reports.setSystemInfo("Machine:","testpc1");
		reports.setSystemInfo("OS","windows 10");
		reports.setSystemInfo("browser",readconfig.getBrowser());
		reports.setSystemInfo("user name","Kundan Reddy");
		
		//configuration to change look and feel of reports
		htmlreporter.config().setDocumentTitle("Extent Listener Repots Demo");
		htmlreporter.config().setReportName("this is my first Reports");
		htmlreporter.config().setTheme(Theme.DARK);
		
	}
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("On start method invoked ......");
	}
	public void onFinish(ITestContext Result)
	{
		
		System.out.println("On Finish method invoked ......");
		reports.flush();
	}
	
	//when Test case get Failed , this method is called
	public void onTestFailure(ITestContext Result)
	{
		
		System.out.println("Name of the test method failed:"+ Result.getName() );
		test=reports.createTest(Result.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel("Name of the failed test case is:"+Result.getName(), ExtentColor.RED));
		
		String screenShotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+Result.getName()+".png";
		File screenShotFile= new File(screenShotPath);
		if(screenShotFile.exists())
		{
			test.fail("Capture Screenshot is below:" +test.addScreenCaptureFromPath(screenShotPath));
		}
	}
	//when  test case get skipped ,this method will invocked
	public void onTestSkipped(ITestContext Result)
	{
		
		System.out.println("Name of the test method Skipped:"+ Result.getName() );
		test=reports.createTest(Result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel("Name of the Skipped test case is:"+Result.getName(), ExtentColor.YELLOW));
	}
	//when test case get started, this method is called 
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of the test method started:"+Result.getName());
	}
	//when Test case get Failed , this method is called
	public void onTestSuccess(ITestResult Result)
	{
		
		System.out.println("Name of the test method Passed:"+ Result.getName() );
		test=reports.createTest(Result.getName());
		test.log(Status.PASS,MarkupHelper.createLabel("Name of the Pass test case is:"+Result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
		
	}

}
