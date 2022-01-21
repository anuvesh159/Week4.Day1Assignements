package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("home")).click();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		WebDriver homepage = driver.switchTo().window(windows.get(1));
		System.out.println(homepage.getTitle());
		driver.close();
		driver.switchTo().window(windows.get(0));
		
		WebElement findElement = driver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
		findElement.click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(0));
		int size = windowHandles1.size();
		System.out.println(size);
		
		WebElement findElement2 = driver.findElement(By.xpath("//button[text()='Do not close me ']"));
		findElement2.click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(windows2.get(1));
		driver.switchTo().window(windows.get(0));
		
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> windows3 = new ArrayList<String>(windowHandles3);
		WebDriver waitforfive = driver.switchTo().window(windows3.get(2));
		System.out.println(waitforfive.getTitle());
		driver.close();
		
		WebDriver waitforfive1 = driver.switchTo().window(windows3.get(1));
		System.out.println(waitforfive1.getTitle());
		System.out.println(waitforfive1.getTitle());
		driver.close();
		
		driver.quit();		
		
		
	}	

}
