package com.justdial.commons;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//  BaseClass is used to load the config file and Initialize  WebDriver
	public static Properties p;
	public static WebDriver driver;

	@BeforeTest
	public void loadConfig() {
		try {
			p=new Properties();
			FileInputStream f=new FileInputStream("C:\\Users\\Tathagat\\eclipse-workspace\\JustDialServices\\src\\main\\java\\com\\justdial\\properties\\config.properties" );
			p.load(f);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Give the details line number and class name where the exception occurred
		}
	}

	public static void launchApp() throws Exception {
		//String browserName = prop.getProperty("browser");
		if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
										
		} else if (p.getProperty("browser").equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (p.getProperty("browser").equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		// Maximize the screen
		driver.manage().window().maximize();
		// Delete all the cookies
		driver.manage().deleteAllCookies();
		//implicit wait new syntax
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Launching the URL	
		driver.get(p.getProperty("url"));//will wait for still web page open
//		Alert alert = driver.switchTo().alert();
//		driver.switchTo().alert();
//		alert.accept();
//		Robot robot = new Robot();
//		robot.delay(5000);
////		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyPress(KeyEvent.VK_ENTER);

		
	}
}
