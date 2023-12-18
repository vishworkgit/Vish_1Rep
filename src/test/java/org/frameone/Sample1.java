package org.frameone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1 {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("https://omrbranch.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("Myname@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("myname12");
		driver.findElement(By.xpath("//button[@value='login']")).click();
	}
}
