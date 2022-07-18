package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.w2a.utilities.ExcelReader;


public class Page {
	
	public static WebDriver driver; //public WebDriver driver не будет создаваться каждый раз объект новой странички в LoginTestб а методы будут идти по очереди на страничках
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");//apache log4j...
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\main\\resources\\com\\w2a\\excel\\testdata.xlsx");
	public static WebDriverWait wait;

	
	public static String browser;
	
	
	
	
	
	public Page() {
		
		if(driver == null) {

		
		
		//загрузка файлов OR и Config
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\com\\w2a\\properties\\Config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			config.load(fis);
			log.debug("Config file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\com\\w2a\\properties\\OR.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			OR.load(fis);
			log.debug("OR file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		/*код ниже для дженкинса чтоб там можно было выбирать браузер, но у меня не сработало
		if (System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
		}else {
			browser = config.getProperty("browser");
		}
		config.setProperty("browser", browser);*/
		
		
		
		
		if(config.getProperty("browser").equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "gecko.exe");
			
			driver = new FirefoxDriver();
		} else if(config.getProperty("browser").equals("chrome")) {
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\com\\w2a\\executables\\chromedriver.exe");
		
		
		
		
		//чтобы желтая строка и нотификации не мешали на странице (ниже добавляется options в driver)
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extentions");
		options.addArguments("--disable-infobars");
		
				//тут добавляется options в driver)
		driver = new ChromeDriver(options);
		} 
		else if(config.getProperty("browser").equals("ie")) {
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to:"+ config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,5);
	}
	}

	public static void quit() {
		
		driver.quit();
	}
	
	
	
public boolean isElementPresent(By by) {
		
		try {
		driver.findElement(by);
		return true;
		
	} catch(NoSuchElementException e) {
		
		return false;
	}
	
	
}
}
