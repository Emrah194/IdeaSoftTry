package deneme;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class İdeaSoft {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://qatestcase.myideasoft.com");//Gidilmek istenen url e yönlendirme.
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/form/input")).sendKeys("ürün");//Aramak istenen anaktar kelimenin search alanına yazılmazı.
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/form/input")).sendKeys(Keys.ENTER);//Enter tuşuna basılması.
		driver.findElement(By.xpath("//div[2]/div/div[1]/div/div[1]")).click();//Ürün detay sayfasına gidilmesi sağlanıyor.
		for(int i=0;i<5;i++)
		{
		driver.findElement(By.xpath("/html/body/main/div/div/section/div/div[1]/div/div[2]/div/div[4]/div[2]/div/div")).click();
		try {
			Thread.sleep(3500);//her 3.5 saniyede bir sepete yeni ürün ekleniyor.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[3]/div/div[3]/a")).click();//sepet sayfasına gidilir.
		WebElement inputElement = driver.findElement(By.xpath("//*[@id=\"cart-items\"]/div/div/div[2]/div/div/div[2]/div/div/div/input"));//sepetteki ürün sayısının bulunması
		String value = inputElement.getAttribute("value");//Sepetteki ürün sayısını değişkene atanması.
		if ("5".equals(value)) {//eğer sepetteki ürün sayısını 5 e eşit olup olmadığının kontrolü
			System.out.println("Islem Basarili");
		}else {
			System.out.println("Tekrar deneyiniz:");
			System.out.print(value);
		}
		
	}

}
