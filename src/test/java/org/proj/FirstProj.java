package org.proj;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstProj {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//      Getting OmrBranch url	
		driver.get("https://omrbranch.com/");
		
//      Maximize  the windows
		driver.manage().window().maximize();
		
//      Entering Login Credentials		
		driver.findElement(By.id("email")).sendKeys("viahvaksekar@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Vish@1995");

//      Click login button
		driver.findElement(By.xpath("//button[text()='Login']")).click();

//      use wait for Loading elements
		Thread.sleep(3000);
		
//      Get the username
		String username_text = driver.findElement(By.xpath("//a[@data-testid='username']")).getText();
		System.out.println("**************************************");
		System.out.println(username_text);
		
//      Search product and print
		driver.findElement(By.id("search")).sendKeys("Nuts",Keys.ENTER);
		String search_text=driver.findElement(By.xpath("(//h5[contains(text(),'')])[1]")).getText();
		System.out.println(search_text);
		
		
//       Add product
		driver.findElement(By.xpath("(//a[text()='Add'])[1]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("cart-21")).click();
		
 		Thread.sleep(3000);
		driver.findElement(By.className("hover1")).click();

//      Go To cart
		String cart_text = driver.findElement(By.xpath("//h5[text()='My Cart']")).getText();
		System.out.println(cart_text);
		
		Thread.sleep(3000);
//      Add Address
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement address_click=driver.findElement(By.xpath("//section[@class='cartWarpper2']//descendant::img"));
		js.executeScript("arguments[0].click();",address_click );
		
//      Address Enter
		WebElement addrs_type = driver.findElement(By.xpath("//select[@name='address_type']"));
		Select select_addrs = new Select(addrs_type);
		select_addrs.selectByValue("Work");
		
		// first name
		driver.findElement(By.xpath("(//input[@name='first_name'])[1]")).sendKeys("John");
		// last name
		driver.findElement(By.xpath("//input[@placeholder='Last name*']")).sendKeys("Smith");
		// contact no
		driver.findElement(By.xpath("//input[@placeholder='Contact No*']")).sendKeys("8976543678");
		// house no
		driver.findElement(By.xpath("//input[@placeholder='House No*']")).sendKeys("10");
		// Address
		driver.findElement(By.xpath("//input[@placeholder='Address*']")).sendKeys("12,Wallmart Street");
		// Country
		WebElement country_select = driver.findElement(By.xpath("//select[@name='country']"));
		Select select_cntry = new Select(country_select);
		select_cntry.selectByVisibleText("India");
		// State
		WebElement state_select = driver.findElement(By.xpath("//select[@name='state']"));
		Select select_st = new Select(state_select);
		select_st.selectByVisibleText("Tamil Nadu");
		// City
		WebElement city_select = driver.findElement(By.xpath("//select[@name='city']"));
		Select select_ct = new Select(city_select);
		select_ct.selectByVisibleText("Chennai");
		// Zipcode
		driver.findElement(By.xpath("//input[@placeholder='Zip Code*']")).sendKeys("600 028");
		// save Button
		driver.findElement(By.xpath("(//button[text()='Save'])[3]")).click();

		
//      Payment
		
		Thread.sleep(3000);
		WebElement payment_typ = driver.findElement(By.xpath("//select[@id='payment_type']"));
		Select select_pay = new Select(payment_typ);
		select_pay.selectByValue("debit_card");
		
//      Visa Card Click		
		driver.findElement(By.xpath("//label[@for='visa_card']")).click();
		
//      Card number
		driver.findElement(By.xpath("//input[@placeholder='Card Number']")).sendKeys("5555555555552222");
//      Month select
		WebElement month_select = driver.findElement(By.xpath("//select[@id='month']"));
		Select select_M = new Select(month_select);
		select_M.selectByVisibleText(" August ");
//      Year select	
		WebElement year_select = driver.findElement(By.xpath("//select[@id='year']"));
		Select select_Yr = new Select(year_select);
		select_Yr.selectByVisibleText(" 2028 ");
//      CVV value
		driver.findElement(By.xpath("//input[@placeholder='CVV']")).sendKeys("1234");
		
//      Place Order
		driver.findElement(By.xpath("//button[@id='placeOrder']")).click();
		
		Thread.sleep(3000);
//      Order No
		String orderNo_text = driver.findElement(By.xpath("(//div[@class='orderStatus']//descendant::span)[1]")).getText();
		System.out.println(orderNo_text);
		System.out.println("**************************************");

		
		
		
	}
}
