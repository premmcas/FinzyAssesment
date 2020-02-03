package interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Premkumar\\Automation\\Chrome driver\\For Chrome 79\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='q']"));
		String par = "finzy";
		searchbox.sendKeys(par);
		searchbox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='med']//div[@class='TbwUpd']"));
		WebElement nextBtn = driver.findElement(By.xpath("//*[@id='pnnext']"));

		for (int i = 0; i < links.size(); i++) {
			String linktxt = links.get(i).getText();
			if (linktxt.contains("finzy")) {
				System.out.println("Finzy is showing at" + " " + linktxt.indexOf(linktxt));
				break;
			} else {
				nextBtn.click();
				continue;

			}
		}
		driver.close();

	}

}
