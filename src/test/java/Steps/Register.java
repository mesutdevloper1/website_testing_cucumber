package Steps;
import Base.BaseSteps;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.UUID;



public class Register extends BaseSteps  {
    public WebDriver driver;
        String uuid = UUID.randomUUID().toString();

    public Register(List<WebElement> login_success) {
        super(login_success);
    }

  /*  public Register() {
        super(login_success);
    }*/

    @Given("^a web browser is at the Hepsiburada home page$")
        public void aWebBrowserIsAtTheHepsiburadaHomePage() {
            geturl();
        }

        @When("^the user click dropdown$")
        public void theUserClickDropdown() {
            findElementClick("myAccount",Pather.id);

        }

        @And("^user clicks on the registration item$")
        public void userClicksOnTheRegistrationItem() {
            findElementClick("register",Pather.id);
        }

        @Then("^user sees the registration form$")
        public void userSeesTheRegistrationForm() {

            waitElement(findElement("firstname",Pather.name,""),TimeOut.LOW);

        }

        @And("^user enters the name$")
        public void userEntersTheName() {
            PageScrolldown();
            findElement("firstname",Pather.id,"").sendKeys("Mesut");

        }

        @And("^user enters the surname$")
        public void userEntersTheSurname() {
            findElement("lastname",Pather.id,"").sendKeys("Test");


        }

        @And("^user enters the email$")
        public void userEntersTheEmail() {
            findElement("email-register",Pather.id,"").sendKeys( "x@test.com.tr");

        }

        @And("^user enters password$")
        public void userEntersPassword() {

            findElement("password-register",Pather.id,"").sendKeys("1A*"+ uuid);
        }

        @And("^user click the agreement checkbox$")
        public void userClickTheAgreementCheckbox() {
            findElementClick("form#form-user > div:nth-of-type(5) > div > label",Pather.cssSelector);
        }

        @And("^user click submit button$")
        public void userClickSubmitButton() {
            findElementClick("form#form-user > div:nth-of-type(6) > button",Pather.cssSelector);

        }

    @And("^user enters product name \"(.*)\"$")
    public void login(String product) {
        search_item(product);

        }
        @Then("^select second page first product$")
        public void select_product(){
        select_first_item();
        }



    @When("^user logs in using Username as \"(.*)\" and Password \"(.*)\"$")
    public void login(String usename,String password) {
        enter_username(usename);
        enter_psw(password);
        System.out.println("Username is:"+ usename);
        System.out.println("Password is:"+ password);}


    @When("^verifiy page title \"(.*)\"$")
    public  void verify(String pageTitle){
        validate_login();

    }

    @When("^he search for \"([^\"]*)\"$")
    public void he_search_for(String product)  {
        search_item(product);
    }

@When("^user click search area$")
    public void searchclick(){
        searchclick();
}
    @When("^user click search button$")
public void clicksearchbtn(){

        click_search();
    }

    @And("^user click second page btn$")
    public void click_second(){
        second_page.click();
    }
    @Then("^user add product basket$")
    public void AddBasket(){
        AddBasket();
    }
    @Given("^Basket Btn")
    public void clickBasketBtn(){
Basket();
    }
    @Given("^Delete product in Basket $")
    public void deleteProduct(){
        deleteProduct();
    }
    @Then("^verification login$")
    public void verification(){
        validate_login();
    }

}
