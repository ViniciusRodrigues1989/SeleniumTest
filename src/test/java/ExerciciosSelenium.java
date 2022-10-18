import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExerciciosSelenium {

    @Test

    public void testesFormularioSelenium() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://demo.automationtesting.in/Register.html");
        //Thread.sleep(3000) ou;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.manage().window().maximize();

        //Close Toolbar
        WebElement adToolbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ins[2]/div[1]")));
        if (adToolbar.isDisplayed()){
            adToolbar.click();
        }
        else {
            System.out.println("Elemento não localizado");
        }

        driver.findElement(By.xpath("//form[1]/div[1]/div[1]/input[1]")).sendKeys("Vinicius");
        driver.findElement(By.xpath("//form[1]/div[1]/div[2]/input[1]")).sendKeys("Rodrigues");
        driver.findElement(By.xpath("//form[1]//textarea[1]")).sendKeys("Rua dos Testadores,94");
        driver.findElement(By.xpath("//*/form[1]/div[3]//input[1]")).sendKeys("teste@teste.com");
        driver.findElement(By.xpath("//section[1]//form[1]/div[4]//input[1]")).sendKeys("11964589088");
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[5]/div/label[1]/input")).click();
        Assert.assertTrue("Elemento não localizado",driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[5]/div/label[1]/input")).isSelected());
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[6]/div/div[2]/input")).click();
        Assert.assertTrue("Elemento não selecionado",driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[6]/div/div[2]/input")).isSelected());
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[1]")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul/li[29]/a")).click();
        Thread.sleep(5000);
        driver.quit();

    }
}
