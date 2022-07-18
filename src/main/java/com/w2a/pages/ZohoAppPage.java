package com.w2a.pages;

import org.openqa.selenium.By;


import com.w2a.base.Page;
import com.w2a.pages.cliq.CliqHomePage;

public class ZohoAppPage extends Page{
	

	//Пометка: каждый метод который открывает новую страницу должен создавать объект данной страницы
			//при использовании метода ниже открывается страница  ZohoAppPage - тоесть данный метод должен возвращать объект новой страницы
			// см ниже метод уже измененный, void меняется на CliqHomePage
	
	public CliqHomePage goToCliq() {
		
		driver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[4]/div/a/span")).click();
		
		return new CliqHomePage();
	}
	
	
	public void goToBooks() {
		
		driver.findElement(By.xpath("//*[@id=\"zl-myapps\"]/div[1]/div[1]/div/a/span")).click();
	}
	
	public void goCalendar() {
		
	}
}
