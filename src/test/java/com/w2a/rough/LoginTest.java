package com.w2a.rough;


import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.cliq.CliqHomePage;

public class LoginTest {

	public static void main(String[] args) {
		
		
		//�������: ������ ����� ������� ��������� ����� �������� ������ ��������� ������ ������ ��������
		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		ZohoAppPage zp = lp.doLogin("livia2008@yandex.ru", "Qwerty123/");
	    CliqHomePage cl = zp.goToCliq();
	}

}
