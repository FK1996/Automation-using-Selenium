package Selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DTLogin {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","src//main//java//driver//chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.navigate().to("https://control.dtitsupport247.net");//navigate to the link
	    driver.manage().window().maximize();//maximze the window
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//wait for the page to load
	    driver.findElement(By.cssSelector("[type=\"text\"]")).sendKeys("Farheen.kamal@continuum.net");//email field 
	    driver.findElement(By.cssSelector("[type=\"password\"]")).sendKeys("Abc@1234");//password field
	    driver.findElement(By.xpath("/html//input[@id='remember']")).click();
	   
	    WebDriverWait wait = new WebDriverWait(driver, 50);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type=\"password\"]")));

	   
	    driver.findElement(By.cssSelector("#loginButton_0")).click();//password next click
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    
	    String at = driver.getTitle();
		String et = "itsupport247";
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Test Success");
		}
		else
		{
			System.out.println("Test Failure");
		}
		driver.quit();

	}

}
