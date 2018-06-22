package assignment.weight_watchers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ProblemTwo {

	private static WebDriver driver = null;
	private String WEIGHTWATCHERS = "https://www.weightwatchers.com/us/";

	public static WebDriver getDriver() {
		return driver;
	}
	
	@Test

	public void initializeDriver() {
		// Initializing the Chrome Driver
		System.setProperty("webdriver.chrome.driver", "/Users/mamun/Downloads/chromedriver");
		driver = new ChromeDriver();
		
		// Telling the driver to implicitly Wait for 20 seconds
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Getting the url from top
		driver.get(WEIGHTWATCHERS);
		getDriver().manage().window().maximize();
		System.out.println("Task 1 Completed");
		
		// Verifying the title Weight Loss Program, Recipes & Help | Weight Watchers
		String actual_title = driver.getTitle();
		System.out.println(actual_title);
		String expected_title = "Weight Loss Program, Recipes & Help | Weight Watchers";
		Assert.assertEquals(actual_title, expected_title);
		System.out.println("Task 2 Completed");
		
		//Clicking on Find a Meeting
		driver.findElement(By.xpath("//*[@id=\"ela-menu-visitor-desktop-supplementa_find-a-meeting\"]")).click();
		System.out.println("Task 3 Completed");
		
		// Verifying the title Find A Meeting: Get Schedules & Times Near You | Weight Watchers
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "Find A Meeting: Get Schedules & Times Near You | Weight Watchers";
		Assert.assertEquals(actual, expected);
		System.out.println("Task 4 Completed");
		
		//Entering 10011 in the search field
		driver.findElement(By.xpath("//input[@type='text' and @ name ='meetingSearch']")).sendKeys("10011");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		System.out.println("Task 5 Completed");
		
		// Printing the title and distance of the first result
		String titleOfFResult = driver.findElement(By.xpath("//*[@id=\"ml-1180510\"]/result-location/div/div[1]/a/location-address/div/div/div[1]/div[1]/span")).getText();
		System.out.println(titleOfFResult);
		String distanceOfFResult = driver.findElement(By.xpath("//*[@id=\"ml-1180510\"]/result-location/div/div[1]/a/location-address/div/div/div[1]/div[2]")).getText();
		System.out.println(distanceOfFResult);
		System.out.println("Task 6 Completed");
		
		//Clicking on First Search Result and Verifying the names
		driver.findElement(By.xpath("//*[@id=\"ml-1180510\"]/result-location/div")).click();
		String locationName = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div[1]/div/div/div[1]/div[2]/div[2]/div/location-address/div/div/div[1]/div/span")).getText();
		Assert.assertTrue(locationName.contains("WEIGHT WATCHERS STORE 23RD ST-5TH AVE"));
		System.out.println("Task 7 Completed");

		//Printing today Operation Hours
		String todayDate = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/ui-view/ui-view/div[1]/div/div/div[2]/div[2]/div[1]/hours-list/ul/li[5]/div")).getText();
		System.out.println(todayDate);
		
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}

}
