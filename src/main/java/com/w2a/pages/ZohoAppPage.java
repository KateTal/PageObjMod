package com.w2a.pages;

import org.openqa.selenium.By;


import com.w2a.base.Page;
import com.w2a.pages.cliq.CliqHomePage;

public class ZohoAppPage extends Page{
	

	//�������: ������ ����� ������� ��������� ����� �������� ������ ��������� ������ ������ ��������
			//��� ������������� ������ ���� ����������� ��������  ZohoAppPage - ������ ������ ����� ������ ���������� ������ ����� ��������
			// �� ���� ����� ��� ����������, void �������� �� CliqHomePage
	
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
