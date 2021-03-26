package Base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class BaseSteps {
    public WebDriver driver;
    @FindBy(xpath = "//*[@id=\"oldHeader_864186c6-5bbb-496b-b056-d892caaf4402\"]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/svg[1]")
    public WebElement Pagetitle;//"Hepsiburada"
    private List<WebElement> login_success;

    @FindBy(xpath = "//*[@id=\"myAccount\"]/span[1]/span[1]")
    public WebElement LOGİN_bigBtn;//"giriş yap ve üye ol"


    @FindBy(xpath = "//*[@id=\"login\"]")
    public WebElement LOGİN_Btn;//"giriş yap"

    @FindBy(xpath = "//*[@id=\"txtUserName\"]")
    public WebElement username_write;//"kullanıcı adı"


    @FindBy(xpath = "//*[@id=\"txtPassword\"]")
    public WebElement psw_write;//"kullanıcı adı"


    @FindBy(xpath = "//*[@id=\"SearchBoxOld\"]/div[1]/div[1]/div[1]/div[2]/input[1]")
    public WebElement search;//"kullanıcı adı"


    @FindBy(xpath = "//*[@id=\"pagination\"]/ul[1]/li[2]/a[1]")
    public WebElement second_page;
    public void setSecond_page(){
        second_page.click();
    }


    @FindBy(xpath = " //*[@id=\"f390b85c-feec-4313-8863-c6440eab2c03\"]/div[1]/div[1]/ul[1]/li[1]/div[1]/a[1]/div[2]/h3[1]/div[1]/p[1]")
    public WebElement secondPage_firstItem;
    public void select_first_item(){
        secondPage_firstItem.click();
    }

    public void setSecondPage_firstItem (){
        secondPage_firstItem.click();
    }

    //*[@id=""]
    @FindBy(id = "//*addToCart")
    public WebElement AddBasket;

    public void  AddBasket(){
        AddBasket.click();
    }

    @FindBy(id = "product-name")
    public WebElement PrdocutDeatil;

    public void ProductDetail(){
        PrdocutDeatil.click();
    }

    @FindBy(id = "shoppingCart")
    public WebElement BasketBtn;

    public void Basket(){
        BasketBtn.click();
    }

    @FindBy(id = "//*[@id=\"fd53c802-ceef-49c9-bfff-2f662bb21406\"]/div/div/div[2]/div[4]/div[2]/div/a[2]")
    public WebElement DeleteItemBasket;

    public void DeleteItemBasket(){
        DeleteItemBasket.click();
    }


    @FindBy(id = "btnHalfLogin")
    public WebElement LoginBtn;

    public void LoginBtn(){
        LoginBtn.click();
    }

    //This is dynamically changing xpath
    private String edit_btn_xpath = "//button[@href='#/branch/id']/following-sibling::button/child::span[2]";



    public BaseSteps(List<WebElement> login_success) {
        this.login_success = login_success;
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\mgulten\\Desktop\\ChromeDriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public enum Pather {


        id,
        className,
        name,
        xPath,
        cssSelector,
        linkText
    }

    public enum TimeOut {
        LOW(5),
        MIDDLE(10),
        HIGH(15),
        CUSTOM_MAX(60);
        private final int value;

        public int getValue() {
            return value;
        }

        // enum constructor - cannot be public or protected
        private TimeOut(int value) {
            this.value = value;
        }

    }

    public void geturl() {
        driver.get("https://www.hepsiburada.com");

    }

    public void waitElement(WebElement element, TimeOut timeOut) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut.value);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception ex) {

        }

    }

    public void findElementClick(String path, Pather type) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TimeOut.MIDDLE.value);
            switch (type) {
                case className:
                    wait.until(ExpectedConditions.elementToBeClickable(By.className(path))).click();
                    break;
                case id:
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(path))).click();
                    break;
                case name:
                    wait.until(ExpectedConditions.elementToBeClickable(By.name(path))).click();
                    break;
                case xPath:
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path))).click();
                    break;
                case cssSelector:
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(path))).click();
                    break;
                case linkText:
                    wait.until(ExpectedConditions.elementToBeClickable(By.linkText(path))).click();
                    break;
                default:
                    new NotFoundException();
            }

        } catch (Exception ex) {
        }
    }

    public WebElement findElement(String path, Pather type, TimeOut timeOut) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut.value);
            WebElement element = null;
            switch (type) {
                case className:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(path)));
                    break;
                case id:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
                    break;
                case name:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(path)));
                    break;
                case xPath:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
                    break;
                case cssSelector:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
                    break;
                case linkText:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(path)));
                    break;
                default:
                    new NotFoundException();
            }
            return element;
        } catch (Exception ex) {
            return null;
        }
    }

    public WebElement findElement(String path, Pather type, String description) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, TimeOut.MIDDLE.value);
            WebElement element = null;
            switch (type) {
                case className:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(path)));
                    break;
                case id:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(path)));
                    break;
                case name:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(path)));
                    break;
                case xPath:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
                    break;
                case cssSelector:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(path)));
                    break;
                case linkText:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(path)));
                    break;
                default:
                    new NotFoundException();
            }
            return element;
        } catch (Exception ex) {
            System.out.println("find element method error" + ex.getMessage());
            return null;
        }
    }


    public void PageScrolldown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)", "");

    }

    public void enter_psw(String password) {
        search.clear();
        search.clear();
        psw_write.sendKeys(password);}


        public void enter_username (String usename){
            search.clear();
        username_write.sendKeys(usename);
        }

        public void  click_search(){
        search.click();
        }

    public void search_item (String product){
        search.clear();
        search.click();
        search.sendKeys(product);
    }
public void secondPage(){
    second_page.click();
}
public void clickFirstItem(){
    secondPage_firstItem.click();
}


        public void PageScrollup () {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,-300)", "");
        }
        public void DriverQuit () {
            driver.quit();
        }

    public void validate_login() {
        if(login_success.size()==1) {
            System.out.println("Login successful");
        }else {
            System.out.println("Login failed");
        }
    }



    }
