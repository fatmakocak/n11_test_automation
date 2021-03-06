package TestsDeneme;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnaSayfaTest {
	
	static WebDriver webDriver;

	public static void main(String[] args) throws InterruptedException {
		
		
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\ChromeDriver\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
       
        
        driver.get("https://www.n11.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
       //driver.findElement(By.linkText("https://www.n11.com/hesabim")).click();
       //driver.findElement(By.linkText("https://www.n11.com/giris-yap")).click();
       //driver.findElements(By.className("menuTitle nobg"));
      // driver.findElement(By.className("btnSignUp")).click(); ?yeol
       driver.findElement(By.className("btnSignIn")).click(); // giri? yap
       
       String mail = "fatma3124@gmail.com";
     
       WebElement mailbox= driver.findElement(By.name("email"));
       mailbox.click();
       mailbox.sendKeys(mail);
       
       String sifre = "123456";
       WebElement password= driver.findElement(By.id("password"));
       password.click();
       password.sendKeys(sifre);
       Thread.sleep(2000);
       //driver.findElement(By.xpath("//button[text()='loginButton']")).click();
       //WebElement giris = driver.findElement(By.xpath("//button[text()='loginButton']"));
       //giris.click();
       
       driver.findElement(By.cssSelector("div#loginButton.green_flat")).click();
       
       String actualUrl="https://www.n11.com/giris-yap"; 
       String expectedUrl= driver.getCurrentUrl();
       
       if(actualUrl.equalsIgnoreCase(expectedUrl)) { 
    	   
       System.out.println("Test passed"); 
       }
       else { 
    	   System.out.println("Test failed");
    	   }
       
	
	}
}
