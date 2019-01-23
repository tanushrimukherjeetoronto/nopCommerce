package com.nopCommerce.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver localDriver;
	
	
	//add constructor
	
	public AddCustomerPage(WebDriver remoteDriver)
	{
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver,this);
		
	}
	
	//identify locators
	
	By lnkCustomers_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	
	By btnAddnew=By.xpath("//a[@class='btn bg-blue']"); //Add new
		
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	
	By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	
	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
		
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	
	public void clickOnCustomersMenu() {
		localDriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem() {
		localDriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew() {
		localDriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		localDriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		localDriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException 
	{
		localDriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
	
		localDriver.findElement(txtcustomerRoles).click();
					
		WebElement listitem;
		
		Thread.sleep(3000);
					
		if(role.equals("Administrators"))
		{
			listitem=localDriver.findElement(lstitemAdministrators); 
		}
		else if(role.equals("Guests"))
		{
			listitem=localDriver.findElement(lstitemGuests);
		}
		else if(role.equals("Registered"))
		{
			listitem=localDriver.findElement(lstitemRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listitem=localDriver.findElement(lstitemVendors);
		}
		else
		{
			listitem=localDriver.findElement(lstitemGuests);
		}
					
		//listitem.click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)localDriver;
		js.executeScript("arguments[0].click();", listitem);
	}
	
	
		public void setManagerOfVendor(String value)
		{
			Select drp=new Select(localDriver.findElement(drpmgrOfVendor));
			drp.selectByVisibleText(value);
		}
		
		public void setGender(String gender)
		{
			if(gender.equals("Male"))
			{
				localDriver.findElement(rdMaleGender).click();
			}
			else if(gender.equals("Female"))
			{
				localDriver.findElement(rdFeMaleGender).click();
			}
			else
			{
				localDriver.findElement(rdMaleGender).click();//Default
			}
			
		}
		
		public void setFirstName(String fname)
		{
			localDriver.findElement(txtFirstName).sendKeys(fname);
		}
		
		public void setLastName(String lname)
		{
			localDriver.findElement(txtLastName).sendKeys(lname);
		}
		
		public void setDob(String dob)
		{
			localDriver.findElement(txtDob).sendKeys(dob);
		}
		
		public void setCompanyName(String comname)
		{
			localDriver.findElement(txtCompanyName).sendKeys(comname);
		}
		
		public void setAdminContent(String content)
		{
			localDriver.findElement(txtAdminContent).sendKeys(content);
		}
		
		public void clickOnSave()
		{
			localDriver.findElement(btnSave).click();
		}
		

	
	
}
