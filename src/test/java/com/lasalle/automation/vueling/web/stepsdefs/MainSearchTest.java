package com.lasalle.automation.vueling.web.stepsdefs;
import com.lasalle.automation.vueling.web.model.FlightDTO;
import com.lasalle.automation.vueling.web.pages.FlightListPage;
import com.lasalle.automation.vueling.web.pages.FlightPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class MainSearchTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static WebDriver driver;
    private static FlightPage page;

    private static String URL;
    private List<FlightDTO> flights;
    private FlightListPage flightListPage;

    @Before
    public static void beforeClass(){
        URL = "https://www.vueling.com/es";

        System.setProperty ("webdriver.chrome.driver","C:\\Users\\Laura\\Dropbox\\MDAS\\Fundamentos_de_pruebas\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
        driver.manage().window().maximize() ;

        LOGGER.debug("driver started");

        //LOGGER.debug("before class");
    }

    @After
    public static void afterClass(){
        driver.close();
        LOGGER.debug("driver closed");
    }

    @Test
    public void testTitle() throws InterruptedException {
        LOGGER.debug("start testTitle");

        URL = "https://www.vueling.com/es";

        System.setProperty ("webdriver.chrome.driver","C:\\Users\\Laura\\Dropbox\\MDAS\\Fundamentos_de_pruebas\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.manage().window().maximize() ;
        driver.get(URL);
        WebElement origin = driver.findElement(By.cssSelector("div.input-group.ng-untouched.ng-pristine.ng-valid"));
        //driver.

        //search button
        WebElement searchBtn = driver.findElement(By.id("btnSubmitHomeSearcher"));
        searchBtn.click();
    }

    @Given("^I'm main page$")
    public void iMMainPage() {
        //driver.get(URL);
        page.setDriver(driver);
        page.openAt(URL);
    }

    @When("^I try to find a fly$")
    public void tryFindAFly(List<FlightDTO> flightDtoList) {
        //page.registerflight(flight);
        //flightListPage.setFlightPage(page);
        flightListPage.setDriver(driver);
        flights = flightDtoList;
        flights.forEach(fl -> flightListPage.addReservations(fl));
    }

    @Then("^I get available flight$")
    public void iGetAvailableFlight() {
        LOGGER.debug("iGetTheReservationInTheReservationsList starts");

        //List<FlightDTO> actualReservations = flightListPage.getReservationList();
       // assertThat(actualReservations).usingFieldByFieldElementComparator().containsExactlyElementsOf(flights);
        List<WebElementFacade> actualReservations = flightListPage.getReservationList();
        assertThat(actualReservations.size()).isGreaterThan(0);
    }
}
