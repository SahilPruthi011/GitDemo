package javaSream;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Webtable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\namit\\Downloads\\chromedriver_win32 (2)/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String baseUrl = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
        driver.get(baseUrl);
        //driver.findElement(By.xpath("(//a[@class='cart-header-navlink'])[1]")).click();
        //driver.findElement(By.xpath("//tr/th[1]")).click();
       // Thread.sleep(5000);
       
        driver.findElement(By.xpath("(//tr/th)[1]")).click();
        List<WebElement> elementList=driver.findElements(By.xpath("//tr/td[1]"));
        List<String> Original=elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> Afterlist=Original.stream().sorted().collect(Collectors.toList());
        System.out.println(Original);
        System.out.println(Afterlist);
       // Assert.assertTrue(Original.equals(Afterlist));
        List<Object> price;
        do {
        	List<WebElement> rows=driver.findElements(By.xpath("//tr/td[1]"));
     price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
       price.forEach(a->System.out.println(a));
       if(price.size()<1)
       {
    	   driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
       }
	}while(price.size()<1);
	}

	private static Object getPriceVeggie(WebElement s) {
		String Price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		// TODO Auto-generated method stub
		return Price;
	}
	
	

}
