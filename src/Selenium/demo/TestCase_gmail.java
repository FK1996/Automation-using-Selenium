package Selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_gmail {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\farheen.kamal\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.navigate().to("http://www.gmail.com");//navigate to the link
	    driver.manage().window().maximize();//maximze the window
	    
	 // CASE- 2. Both Email and Password Fields are blank.
	    try
	        {
	    		WebElement GmailText = driver.findElement(By.xpath("//input[@type='email']"));
	    		String text = GmailText.getText();
	    		if(text.equals("Primary"))
	    		{
	    			System.out.println("----------Sucessful login -------");
	    		}
	    		else
	    		{
	    			System.out.println("----------Login failure ----------");
	    		}
			}
	    catch(Throwable e)
	    {
			System.out.println("Erroril and Password fields are blank. \n----------------------- ");
			System.out.println("Elementfound: "+e.getMessage() + "\n-----------------------");
	    }


	}

}
