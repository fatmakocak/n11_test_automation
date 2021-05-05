package TestsDeneme;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {

	 static WebDriver driver;

	@BeforeTest
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.n11.com/");
		driver.manage().window().maximize();
		if (driver.getCurrentUrl().contains("https://www.n11.com/")) {
			System.out.println("N11 sayfasina gidildi");
		} else {
			throw new WebDriverException("ilgili sayfaya acilamadi");
		}
		// driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}

	
	/*public void AnasayfaTest() {
	

		// driver.findElements(By.className("menuTitle nobg")); //hesabým
		driver.findElement(By.className("btnSignIn")).click();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String mail = "fatma3124@gmail.com";// email
		WebElement mailbox = driver.findElement(By.name("email"));
		mailbox.click();
		mailbox.sendKeys(mail);

		String sifre = "123456"; // þifre
		WebElement password = driver.findElement(By.id("password"));
		password.click();
		password.sendKeys(sifre);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		// Thread.sleep(2000);

		driver.findElement(By.cssSelector("div#loginButton.green_flat")).click();

		String actualUrl = "https://www.n11.com/giris-yap";
		String expectedUrl = driver.getCurrentUrl();

		if (actualUrl.equalsIgnoreCase(expectedUrl)) {

			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
      
	}
*/
	
	public void girisKontrol() {
		if (driver.getCurrentUrl().contains("giris-yap")) {
			System.out.println("Login sayfasýndasýnýz.");
			System.out.println("-----------------------------");
		} else {
			System.out.println("Login sayfasýna gidemediniz.");
			System.out.println("-----------------------------");
		}
	}

	public void kelime() {

		WebElement searchBox = driver.findElement(By.id("searchData"));
		searchBox.click();
		searchBox.sendKeys("Bilgisayar");
		driver.findElement(By.className("searchBtn")).click();

	}

	public void Pagination() {

		driver.findElement(By.xpath(".//*[@class='pagination']/a[2]")).click();
		// driver.findElement(By.cssSelector("div#p-392094116.columnContent
		// adBg")).click();
		driver.findElement(By.xpath(".//*[@id='p-392094116']/div[2]/a[2]")).click();

		if (driver.getCurrentUrl().contains("pg=2")) {
			System.out.println("Sayfaya 2 ye geçiþ yaptýnýz.");
			System.out.println("-----------------------------");

		} else {
			System.out.println("2. sayfaya geçiþ yapamadýnýz.");
			System.out.println("-----------------------------");

		}

		WebElement miktarbox = driver.findElement(By.id("quantity"));
		miktarbox.click();
		miktarbox.clear();
		miktarbox.sendKeys("1");

	}

	public void sepetuyg() throws InterruptedException {

		WebElement price = driver.findElement(By.xpath(".//*[@class='newPrice']/ins[1]"));
		String priceText = price.getText();

		/* Rastgele ürün seçilip seçilen ürünün sepete eklenmesi */
		// driver.findElement(By.className("btn btnGrey btnAddBasket")).click();

		/* sepete ürün ekleme */
		driver.findElement(By.xpath(".//*[@class='btnHolder']/a[2]")).click();
		// driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		// driver.findElement(By.cssSelector("div#continueToShopping.svgIcon
		// svgIcon_arrow-left")).click();
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

	}

	@AfterTest
	public void sepetdelete() { // sepetin boþaltýlmasý

		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.findElement(By.className("removeProdData")).click();

	}
	/*
	 * @AfterTest private void quitDriver(){
	 * //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	 * driver.quit();
	 * 
	 * }
	 */

	public void n11WebPageTestCases() {

		try {

			setupDriver();
			//AnasayfaTest();
			// quitDriver();
			girisKontrol();
			kelime();
			Pagination();
			sepetuyg();
			sepetdelete();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}

