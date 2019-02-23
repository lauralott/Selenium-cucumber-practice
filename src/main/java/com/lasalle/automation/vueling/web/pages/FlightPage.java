package com.lasalle.automation.vueling.web.pages;

import com.lasalle.automation.vueling.web.model.FlightDTO;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;
import java.util.List;

public class FlightPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = ".form-input.origin input")
    private WebElementFacade inputOrigen;

    @FindBy(css = ".form-input.destination input")
    private WebElementFacade inputDestiny;

    @FindBy(css = "td:not(.ui-state-disabled) a.ui-state-default")
    private List<WebElementFacade> datesAvailable;

    @FindBy(css = ".ui-state-active")
    private List<WebElementFacade> currentDay;

    @FindBy(css = "#btnSubmitHomeSearcher")
    private WebElementFacade btnSearch;


    public void registerflight(FlightDTO flight) {
        LOGGER.debug("Starting search for flight: [{}]", flight);
        inputOrigen.typeAndEnter(flight.getOrigin());
        inputDestiny.typeAndEnter(flight.getDestination());
        clickAvailableOutbound(flight.getOutbound());
        btnSearch.click();
    }

    private void clickAvailableOutbound(String flightOutbound){

        int initOutbound = Integer.parseInt(currentDay.get(0).getText())
                + getSearchDayOffset(flightOutbound);

        for (int i = 0; i < datesAvailable.size(); i++) {
            int day = Integer.parseInt(datesAvailable.get(i).getText());

            if (day > initOutbound){
                datesAvailable.get(i).click();
                return;
            }
        }
    }

    private int getSearchDayOffset(String flightOutbound){
        if (flightOutbound.equals("NEXT_WEEK")){
            return 7;
        }else
            return 1;
    }


}
