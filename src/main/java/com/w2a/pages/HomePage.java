package com.w2a.pages;

import org.openqa.selenium.By;


import com.w2a.base.Page;


public class HomePage extends Page{
	

	
	public void goToSupport() {
		
		driver.findElement(By.cssSelector(".zh-support")).click();
	}
	
	
	public void goToSignUp() {
		
		driver.findElement(By.cssSelector(".zh-signup")).click();
	}
	
	//Пометка: каждый метод который открывает новую страницу должен создавать объект данной страницы
	//при использовании метода ниже открывается страница login - тоесть данный метод должен возвращать объект новой страницы
	// см ниже метод уже измененный
	
	//public void goToLogin() {
		//driver.findElement(By.cssSelector(".zh-login")).click();
	//}
	  
	
      public LoginPage goToLogin() {
		
		driver.findElement(By.cssSelector(".zh-login")).click();
    	
		
		return new LoginPage();
		
		
		
	}
	
	
	
	public void goToZohoEdu() {
		
	}
	 
	
	public void goToLearnMore() {
		
	}
	
	
	public void validateFooterLinks() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
