package com.w2a.pages;

import org.openqa.selenium.By;


import com.w2a.base.Page;

public class LoginPage extends Page{

	
	//Пометка: каждый метод который открывает новую страницу должен создавать объект данной страницы
		//при использовании метода ниже открывается страница  ZohoAppPage - тоесть данный метод должен возвращать объект новой страницы
		// см ниже метод уже измененный, void меняется на ZohoAppPage
	
	public ZohoAppPage doLogin(String username, String password) {
		
		
		
		driver.findElement(By.xpath("//*[@id=\"login_id\"]")).sendKeys(username);
		
		driver.findElement(By.xpath("//*[@id=\"nextbtn\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id=\"nextbtn\"]")).click();
		
		return new ZohoAppPage();
		
		}
		
	
}
