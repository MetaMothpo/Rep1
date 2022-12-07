package CreateTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static junit.framework.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class TestCase1_BuyProductScreen extends baseClass
{

    @BeforeMethod
    public void GetTitle()
    {
        String ExpectetedTitle = "Guru99 Payment Gateway";
        String ActualTtle = driver.getTitle();
        //Assert.assertEquals(ActualTtle,ExpectetedTitle);
        System.out.println("Guru99 Payment Gateaway title is: "+ActualTtle);
        Assert.assertTrue(ActualTtle.equalsIgnoreCase(ExpectetedTitle
        ),"Page title not matched or Problem in loading url page");
    }

    @Test
    public void BuyProducts() {
        Select NumberofItems = new Select(driver.findElement(By.name("quantity")));
        NumberofItems.selectByIndex(2);

        driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div/div[8]/ul/li/input")).click();
        driver.findElement(By.id("card_nmuber")).sendKeys("1289654902348905");

        Select ExpirationMonth = new Select(driver.findElement(By.id("month")));
        ExpirationMonth.selectByIndex(2);

        Select ExpirationYear = new Select(driver.findElement(By.id("year")));
        ExpirationYear.selectByIndex(2);

        driver.findElement(By.id("cvv_code")).sendKeys("214");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

        String ActualAmount = driver.findElement(By.name("submit")).getAttribute("value");
        String ExpectedAmount = "Pay $60.00";

        Assert.assertTrue(ActualAmount.equalsIgnoreCase(ExpectedAmount
        ), "Price is incorrect");
        driver.findElement(By.name("submit")).click();


    }


    @Test
    public void OderIDIsDisplayed()
    {
        String orderId = driver.findElement(By.xpath("//*[@id=\"three\"]/div/div/table/tbody/tr[1]/td[2]")).getText();

        if (orderId.isEmpty()){
        System.out.println("Oder Id is empty");
        }
        else
        {
            System.out.println("Oder ID number is displayed: "+ orderId);
        }


    }





}