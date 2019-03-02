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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        System.setProperty ("webdriver.chrome.driver","bin\\chromedriver.exe" );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
        driver.manage().window().maximize() ;
        page.setDriver(driver);

        LOGGER.debug("driver started");
    }

    @After
    public static void afterClass(){
        driver.close();
        LOGGER.debug("driver closed");
    }

    @Given("^I'm main page$")
    public void iMMainPage() {
        LOGGER.debug("iMMainPage starts");

        page.openAt(URL);
    }

    @When("^I try to find a fly$")
    public void tryFindAFly(List<FlightDTO> flightDtoList) {
        LOGGER.debug("tryFindAFly starts");
        flightListPage.setDriver(driver);
        flights = flightDtoList;
        flights.forEach(fl -> flightListPage.addReservations(fl));
    }

    @Then("^I get available flight$")
    public void iGetAvailableFlight() {
        LOGGER.debug("iGetAvailableFlight starts");
        List<WebElementFacade> actualReservations = flightListPage.getReservationList();
        assertThat(actualReservations.size()).isGreaterThan(0);
    }
}
