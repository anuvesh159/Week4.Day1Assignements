package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	    // 2. Enter UserName and Password Using Id Locator
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link
		driver.findElement(By.className("crmsfa")).click();
		
		//5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//span[text()='From Contact']/following::a)")).click();
		Thread.sleep(3000);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		
		//8. Click on First Resulting Contact
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).click();
		driver.switchTo().window(windows.get(0));
		
		
		
		//9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	    
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(windows1.get(1));
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		//10. Click on Second Resulting Contact
		
		WebElement tocontact = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]"));
		tocontact.click();
		driver.switchTo().window(windows1.get(0));
		
		// 11. Click on Merge button using Xpath Locator
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
		
		// 13. Verify the title of the page
		System.out.println(driver.getTitle());
		
		

	}

}
