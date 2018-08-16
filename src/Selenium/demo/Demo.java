package Selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\farheen.kamal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://www.gmail.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("farheenkamal");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("hello123");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();
		
		
		Thread.sleep(2000);
		String at = driver.getTitle();
		String et = "gmail";
		driver.close();
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
