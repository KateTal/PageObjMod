package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import com.w2a.base.Page;

import com.w2a.utilities.Utilities;

public class CustomListeners extends Page implements ITestListener {

	public void onStart(ITestContext context) {	
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
		public void onTestStart(ITestResult result) {
			//runmode - Y
			//if (!Utilities.IsTestRunnable(result.getName(), excel)) {
				
				//throw new SkipException ("Skipping the test" + result.getName().toUpperCase() + "as the Runmode is NO");
			//}
			
		}
		
		public void onTestSuccess(ITestResult result) {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			try {
				Utilities.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.log("click to see Screenshot");
			Reporter.log("<a target=\"_blank\" href="+ Utilities.screenshotName+">Screenshot</a>");
			Reporter.log("<br>"); //добавляет сроку, ниже под надписью повится скриншот
			Reporter.log("<a target=\"_blank\" href="+ Utilities.screenshotName+"><img scr="+Utilities.screenshotName+"height=200 width=200></img></a>");
			
			
			
		}
			
		
		
		

		public void onTestFailure(ITestResult result) {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			try {
				Utilities.captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Reporter.log("click to see Screenshot");
			Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+">Screenshot</a>");
			Reporter.log("<br>"); //добавляет сроку, ниже под надписью повится скриншот
			Reporter.log("<a target=\"_blank\" href="+Utilities.screenshotName+"><img scr="+Utilities.screenshotName+"height=200 width=200></img></a>");
		}

		public void onTestSkipped(ITestResult result) {
			
		
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
		}
}


