package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3Frames {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.tagName("input")).sendKeys("frames");
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame3);
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='animals']"));
		Select animals = new Select(dropDown);
		animals.selectByVisibleText("Avatar");
		
		driver.switchTo().defaultContent();
		
		
		
	}

}
