package com.justdial.pageObjects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.justdial.commons.BaseClass;

public class HomePage extends BaseClass{
	BaseClass b=new BaseClass();
	public static WebDriver driver;
	
	
	@FindBy(xpath="//span[@id='h_login']")
	WebElement clklogin;
	
	@FindBy(xpath="//button[@id='tstfb']")
	WebElement clkfacebook;
	
	@FindBy(xpath="//input[@id='srchbx']")
	WebElement search;

	@FindBy(xpath="//button[@class='search-button']")
	WebElement searchbtn;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement citySearch;
	
	@FindBy(xpath="//span[@id='ncard0']")
	WebElement sevamotors;
	
	@FindBy(xpath="//span[@onclick=\"closePopUp('best_deal_div');\"]")
	WebElement close;
	
	@FindBy(xpath="//span[@class='green-box']")
	WebElement starRaiting;
	
	@FindBy(xpath="//span[@class='rt_count lng_vote']")
	WebElement votes;

	public HomePage()
	{
		PageFactory.initElements(b.driver, this);
	}


	public void searchServices(String Location,String ServicesName) throws Exception
	{
		
		citySearch.clear();
		Thread.sleep(3000);
		citySearch.sendKeys(Location);
		search.sendKeys(ServicesName);
		searchbtn.click();
		close.click();
	

	}
	}

