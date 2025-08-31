import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestOne {
    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
        //WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> radioButtons = driver.findElements(By.name("radioButton"));
        for (WebElement radio: radioButtons) {radio.click();}

        By Suggession_Class_Exampl=By.className("ui-autocomplete-input");
        driver.findElement(Suggession_Class_Exampl).sendKeys("DemoWebsite");

        By Dropdown_Example=By.id("dropdown-class-example");
        Select select=new Select(driver.findElement(Dropdown_Example));
        select.selectByValue("option1");
        select.selectByValue("option2");
        select.selectByValue("option3");

        By Checkbox1=By.id("checkBoxOption1");
        driver.findElement(Checkbox1).click();
        By Checkbox2=By.id("checkBoxOption2");
        driver.findElement(Checkbox2).click();
        By Checkbox3=By.id("checkBoxOption3");
        driver.findElement(Checkbox3).click();
        handle();
        alert();
        hideShow();
        hover();


    }

     static void handle() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
        Object[] handles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) handles[1]);
        System.out.println(driver.getTitle());
        driver.switchTo().window((String) handles[0]);
        driver.findElement(By.linkText("Open Tab")).click();
        Thread.sleep(2000);
        driver.switchTo().window((String) handles[0]);
    }

     static void alert(){
        driver.findElement(By.cssSelector("input#name")).sendKeys("ALERT");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Alertbtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alertbtn")));
        Alertbtn.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String title = alert.getText();
        System.out.println(title);
        alert.accept();

        WebElement Confirmtbtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmbtn")));
        Confirmtbtn.click();
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        String titlee = alert.getText();
        System.out.println(titlee);
        alert2.dismiss();

    }

     static  void hideShow() throws InterruptedException {

         WebElement displayedExampleSection = driver.findElement(By.xpath("//*[contains(text(),'Element Displayed Example')]"));

         // Scroll to the "Displayed Example" section
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", displayedExampleSection);
         driver.findElement(By.xpath("//input[@name='show-hide']")).sendKeys("hide/show");
         driver.findElement(By.id("hide-textbox")).click();
         Thread.sleep(1000);
         driver.findElement(By.id("show-textbox")).click();

     }

     static void hover() throws InterruptedException {
         WebElement MouseHover = driver.findElement(By.xpath("//*[contains(text(),'Mouse Hover Example')]"));
         // Scroll to the "MouseHover Example" section
         JavascriptExecutor js1 = (JavascriptExecutor) driver;
         js1.executeScript("arguments[0].scrollIntoView(true);", MouseHover);

         By mouseHover=By.id("mousehover");
         WebElement element= driver.findElement(mouseHover);
         Actions actions=new Actions(driver);
         actions.moveToElement(element).perform();
         Thread.sleep(2000);
         driver.findElement(By.cssSelector("a[href='#top']")).click();
         Thread.sleep(1000);
         actions.moveToElement(element).perform();
         driver.findElement(By.xpath("//a[contains(text(),'Reload')]")).click();
     }
}
