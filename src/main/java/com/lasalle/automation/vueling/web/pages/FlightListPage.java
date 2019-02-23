package com.lasalle.automation.vueling.web.pages;

import com.lasalle.automation.vueling.web.model.FlightDTO;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.thucydides.core.pages.components.HtmlTable.inTable;


public class FlightListPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private FlightPage flightPage;

    @FindBy(css = "#availabilityTable0 > tbody > tr")
    private List<WebElementFacade> flightsList;

    public void addReservations(FlightDTO flight){
        flightPage.setDriver(getDriver());
        flightPage.registerflight(flight);
    }

    public List<WebElementFacade> getReservationList(){
        LOGGER.debug("getReservationList starts");

        return flightsList;
    }
}
