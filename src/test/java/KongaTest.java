import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaTest {
    private By ClickCard = By.xpath("//*[@id=\\\"channel-template\\\"]/div[2]/div/div[2]/button/div/span[1]");
    private By CardNumber = By.id("card-number");
    private By Date = By.id("expiry");
    private By CVV = By.id("cvv");
    private By Submit = By.id("validateCardForm");
    private By Close = By.xpath("/html/body/section/section/section/div[2]/div[1]/aside");

    //import the selenium webDriver
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //locate where the EdgeDriver
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
        //1. open the Edge Browser
        driver = new EdgeDriver();
        //2. input the konga page url(https://www.konga.com/)
        driver.get("https://www.konga.com");
        Thread.sleep(5000);
        //3. Maximize the page
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void Postivesignin() throws InterruptedException {
        //4. click on the signin button on the signin page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //5. input username on the username field
        driver.findElement(By.id("username")).sendKeys("hillaryhellenic@gmail.com");
        //6. input password on the password field
        driver.findElement(By.id("password")).sendKeys("hellenic@gmail.com");
        //7. click on the login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void SelectCategories() throws InterruptedException {

        //8. From the Categories, click on the “Computers and Accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(20000);

    }
    @Test (priority = 2)
    public void LaptopSubCategory() throws InterruptedException {
        // verify that user can navigate on click, on laptop
        //9.click on laptop
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(15000);
    }
    @Test (priority = 3)
    public void AppleMacbook() throws InterruptedException {
        //verify that user can navigate and click on AppleMacbook
        //10. click on AppleMacbook
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li[1]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 4)
    public void AddAnItemToTheCart() throws InterruptedException {
        //11.select an item
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/a/div[1]/h3")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void ClickOnBuyNow() throws InterruptedException {
        //15 click on Buy now
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/div[4]/div[3]/div[1]/div[2]/div[2]/form/div[5]/div[1]/button")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 6)
    public void ClickOnContinueToCheckOut() throws InterruptedException {
        //16. Click on continue to checkout
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/div/div[2]/div[4]/div/div[6]/div/a")).click();
        Thread.sleep(5000);
    }
    @Test (priority = 7)
    public void ClickOnPayNow() throws InterruptedException {
        //17. Click on Pay now
        driver.findElement(By.xpath("html body div#__next div.ais-InstantSearch__root section#app-content-wrapper.d6575_J-kZm div.c6dfe_HidJc section._0863a_3x99A main#mainContent._050ef_K0hT7 div._7e0c4_1mL_a form div._62f39_301Jg div.f78ce_2EMqS section._4b230_19Wk8._651d7_qAjL2.da539_3JsSH div._46c08_1Sov4 div._72d4a_2grAE div.ef287_1UjlY div._92b3c_pq4Z2 span input")).click();
        Thread.sleep(7000);
    }
    @Test (priority = 8)
    public void ClickOnContinueToPayment() throws InterruptedException {
        //18 Click on Continue to payment
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(7000);
    }

    @Test (priority = 10)
    public void SelectPaymentMethod() throws InterruptedException{
        //19. from the select payment method, click on the card option
        click(ClickCard);
    }
    private void click(By clickCard) {
    }
    @Test (priority = 11)
    public void EnterCardDetails() throws InterruptedException {
        //20. input an invalid card number in the card field
        setText(CardNumber, 981518);
        //21. input an invalid expiry date in the date field
        setText(Date, 8/27);
        //22. input an invalid cvv number in the cvv field
        setText(CVV, 276);
    }
    public void setText(By cardNumber, int i) {
    }
    @Test (priority = 12)
    public void PayNow ()throws InterruptedException{
        //23 click on the pay now button
        click(Submit);
        Thread.sleep(5000);
        //24 close the iFrame displayed
        click(Close);
        Thread.sleep(5000);
        //verify that user is unable to complete order with invalid card details
        String actualErrorMessage = "Invalid card number";
        if (actualErrorMessage.contains("Invalid card number"))
            //pass
            System.out.println("Invalid card number");
        else
            //fail
            System.out.println("successful");
        Thread.sleep(5000);
    }

    @AfterTest
    public void CloseBrowser() {
        //quit the browser
        driver.quit();
    }
}
