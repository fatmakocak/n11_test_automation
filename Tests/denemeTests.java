package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;

public class denemeTests {

	static WebDriver webDriver;

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.n11.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		if (driver.getCurrentUrl().contains("https://www.n11.com/")) {
			System.out.println("N11 sayfasina gidildi");
		} else {
			throw new WebDriverException("ilgili sayfaya acilamadi");
		}

		// driver.findElement(By.linkText("https://www.n11.com/hesabim")).click();
		 driver.findElement(By.linkText("https://www.n11.com/giris-yap")).click();
		
		  driver.findElements(By.className("menuTitle nobg")); //
		  //driver.findElement(By.className("btnSignUp")).click(); üyeol
		  driver.findElement(By.className("btnSignIn")).click(); // giriþ yap
		  
		  String mail = "fatma3124@gmail.com";
		  
		  WebElement mailbox= driver.findElement(By.name("email")); mailbox.click();
		  mailbox.sendKeys(mail);
		 
		 String sifre = "123456"; WebElement password=
		  driver.findElement(By.id("password")); password.click();
		  password.sendKeys(sifre); Thread.sleep(2000);
		 //driver.findElement(By.xpath("//button[text()='loginButton']")).click();
		  //WebElement giris =
		 driver.findElement(By.xpath("//button[text()='loginButton']"));
		  //giris.click();
		  
		  //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		  driver.findElement(By.id("loginButton")).click(); //
		  driver.findElement(By.name("email")).clear();
		  //driver.findElement(By.name("email")).sendKeys("");
		  
		  driver.findElement(By.cssSelector("div#loginButton.green_flat")).click();
		  
		  
		  String actualUrl="https://www.n11.com/giris-yap"; String expectedUrl=
		  driver.getCurrentUrl();
		  
		  if(actualUrl.equalsIgnoreCase(expectedUrl)) {
		 
		  System.out.println("Test passed"); } else {
		  System.out.println("Test failed"); }
		  
		 

		WebElement searchBox = driver.findElement(By.id("searchData"));
		searchBox.click();
		searchBox.sendKeys("Bilgisayar");
		driver.findElement(By.className("searchBtn")).click();

		/* ikinci sayfaya gecme */
		driver.findElement(By.xpath(".//*[@class='pagination']/a[2]")).click();
		// driver.findElement(By.cssSelector("div#p-392094116.columnContent adBg")).click();

		/* 2. sayfada rastgele ürün seçme */
		driver.findElement(By.xpath(".//*[@id='p-392094116']/div[2]/a[2]")).click();

		/* 2.Sayfa kontrolü */
		WebElement price = driver.findElement(By.xpath(".//*[@class='newPrice']/ins[1]"));
		String priceText = price.getText();

		if (driver.getCurrentUrl().contains("pg=2")) {
			System.out.println("Sayfaya 2 ye gecis yaptiniz");
			System.out.println("-----------------------------");

		} else {
			System.out.println("2. sayfaya gidemediniz");
			System.out.println("-----------------------------");

		}

		WebElement miktarbox = driver.findElement(By.id("quantity"));
		miktarbox.click();
		miktarbox.clear();
		miktarbox.sendKeys("1");

		/* Rastgele ürün seçilip seçilen ürünün sepete eklenmesi */
		// driver.findElement(By.className("btn btnGrey btnAddBasket")).click();

		/* sepete ürün ekleme */
		driver.findElement(By.xpath(".//*[@class='btnHolder']/a[2]")).click();
		// driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		// driver.findElement(By.cssSelector("div#continueToShopping.svgIcon svgIcon_arrow-left")).click();
		driver.findElement(By.xpath(".//*[@class='customMenu']/div[4]/a[1]")).click();
		Thread.sleep(3000);

		// Ürün sayfasýndaki fiyat ile sepetteki fiyatýn karþýlaþtýrýlmasý

		WebElement priceBasket = driver.findElement(By.className("price"));
		String priceText2 = priceBasket.getText();
		if (priceText.compareTo(priceText2) > 0) {

			// Sepetteki ürün adetinin artýrýlmasý
			WebElement quantityBasket = driver.findElement(By.id("quantity_126756461031"));
			quantityBasket.click();
			quantityBasket.clear();
			quantityBasket.sendKeys("1");
			// driver.findElement(By.className("spinnerUp spinnerArrow")).click();
			driver.findElement(By.xpath(".//*[@class='spinnerFieldContainer']/div[1]/span")).click();

		}
		/*
		 * driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		 * driver.findElement(By.className("removeProdData")).click();
		 * 
		 */

	}
}
