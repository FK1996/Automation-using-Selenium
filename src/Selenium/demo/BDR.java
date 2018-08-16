package Selenium.demo;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BDR {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\farheen.kamal\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.navigate().to("https://control.itsupport247.net/");//navigate to the link
	    driver.manage().window().maximize();//maximze the window
	    
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);//wait for the page to load
	    
	    //1.Login to ITS portal with Remember me option selected.
	    driver.findElement(By.name("callback_0")).sendKeys("ansari.moin25@outlook.com");//email field
	    driver.findElement(By.name("callback_1")).sendKeys("Abc@1234");//password field
	    driver.findElement(By.id("remember")).click();//Remember me checkbox
	    driver.findElement(By.id("loginButton_0")).click();//Login Button
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    
	    //2.Navigate to BDR tab.
	    driver.findElement(By.linkText("BDR")).click();
	    
	    //3.Verify the page header name of the BDR home page
	    String at = driver.getTitle();
		String et = "BDR Home";
			if(at.equalsIgnoreCase(et))
			{
				System.out.println("Page Header Verified Successfully");
			}
			else
			{
				System.out.println("Page Header Verification Failure");
			}
			
		//4.Verify Connect to Appliance button is disabled if no appliance is selected
		WebDriverWait wait = new WebDriverWait(driver, 50);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("radio")));
		
		WebElement cta =driver.findElement(By.xpath("/html//div[@id='divMainContent']//input[@name='ctl00$ctl00$leftPanel$CenterPanel$btnConnect']"));
		WebElement element = null;
		boolean ctavalue = cta.isEnabled();
		int size = driver.findElements(By.name("radio")).size();
		for (int i = 0; i < size; i++) {
	        element = driver.findElements(By.name("radio")).get(i);
		}
		boolean radiovalue= element.isSelected();
		if (radiovalue==true && ctavalue==false) {                       
	            System.out.println("Appliance is selected and Connect To Appliance is Disabled");//not ideal case
	        }
		else if(radiovalue==false && ctavalue==true)//no possibility of this condition
		{
			System.out.println("Appliance is not selected and Connect To Appliance is Enabled");//not ideal case
		}
		else if(radiovalue==false && ctavalue==false) {
			System.out.println("Appliance is NOT SELECTED and Connect to Appliance button is Disabled");//IDEAL case
		}
		else {
				System.out.println(" Connect To Appliance Button is Enabled");
	        }
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//5.Verify Connect to Appliance button is enabled if appliance is selected.
		driver.findElement(By.xpath("//div[@id='SiteViewGrid']//table[@role='treegrid']/tbody/tr[1]/td[2]//input[@name='radio']")).click();//appliance is selected
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//div[@id='divMainContent']//input[@name='ctl00$ctl00$leftPanel$CenterPanel$btnConnect']")));
			System.out.println("Appliance is SELECTED and Connect To Appliance button is ENABLED");
		}
	
		//6. Once the Connect to Appliance button is enabled click on it.
		String parent = driver.getWindowHandle();// Store the current window handle
		System.out.println(parent);
		cta.click();// Perform the click operation that opens new popup window
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		// Switch to new popup window opened
		String pop1=driver.getWindowHandle();
		System.out.println("beforeswitch1"+pop1);
		for(String winHandle1 : driver.getWindowHandles()){
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.switchTo().window(winHandle1);
			System.out.println(winHandle1);
		}
		
		String pop2=driver.getWindowHandle();
		System.out.println("beforeswitch2"+pop2);
		for(String winHandle2 : driver.getWindowHandles()){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//span[@id='divDispCredentials_wnd_title']")));
		driver.switchTo().window(winHandle2);
		System.out.println(winHandle2);
		}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html//input[@id='btnCnct']")).click();
		
		for(String winHandle3 : driver.getWindowHandles()){
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().window(winHandle3);
		System.out.println(winHandle3);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//span[@id='qOwPp0']")));
		//driver.findElement(By.xpath("/html//input[@id='qOwPt0']")).sendKeys("admin");
		}
		driver.switchTo().window(pop2);
		driver.findElement(By.xpath("/html//input[@id='btnclose']")).click();
		
		//driver.close();
		driver.quit();
	
}
}
	
	