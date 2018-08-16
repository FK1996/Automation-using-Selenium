package Selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//gmail login and logout
public class gmail {

	public static void main(String[] args) throws InterruptedException {

		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\farheen.kamal\\Downloads\\chromedriver_win32\\chromedriver.exe");
		    WebDriver driver=new ChromeDriver();
		    driver.navigate().to("http://www.gmail.com");//navigate to the link
		    driver.manage().window().maximize();//maximze the window
		    
		    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);//wait for the page to load
		    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("farheenkamal90@gmail.com");//email field 
		    driver.findElement(By.cssSelector("#identifierNext")).click();//next button click
		   
		    WebDriverWait wait = new WebDriverWait(driver, 50);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=password]")));

		    driver.findElement(By.cssSelector("input[type=password]")).sendKeys("*******");//password click 
		    driver.findElement(By.cssSelector("#passwordNext")).click();//password next click
		    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		    
		    //account flyout click
		    driver.findElement(By.xpath("/html//div[@id='gb']/div[1]/div[1]/div[@class='gb_Hc gb_Pg gb_R']/div[5]/div[1]/a[@role='button']/span[@class='gb_db gbii']")).click();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    driver.findElement(By.cssSelector("#gb_71")).click();//sign out button click
		    
		    String at = driver.getTitle();
			String et = "gmail";
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





