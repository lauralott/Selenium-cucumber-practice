package com.lasalle.automation.vueling.web.pages;

import com.lasalle.automation.vueling.web.model.FlightDTO;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.util.List;

public class FlightPage extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(css = "div.input-group.ng-untouched.ng-pristine.ng-valid")
    private WebElementFacade inputOrigen;

    @FindBy(css = "#origin-sugestion-popup > div:nth-child(2) > ul > li:nth-child(6)")
    private WebElementFacade optionOrigin;

    //@FindBy(css = "div.input-group.ng-untouched.ng-pristine.ng-invalid")
    //private WebElementFacade inputDestiny;

    @FindBy(css = "#destinationInput-sugestion-popup > div:nth-child(2) > ul > li:nth-child(5)")
    private WebElementFacade optionDestiny;

    @FindBy(css = "#ui-datepicker-div > div.ui-datepicker-group.ui-datepicker-group-first > table > tbody > tr")
    private List<WebElementFacade> datePicker;

    @FindBy(css = "#passengers-popup > div.passengers-popup_action > button")
    private WebElementFacade btnPassengers;

    @FindBy(css = "#btnSubmitHomeSearcher")
    private WebElementFacade btnSearch;


    public void registerflight(FlightDTO flight) {
        LOGGER.debug("register flight starts, flight: [{}]", flight);

        inputOrigen.click();
        optionOrigin.click();
        optionDestiny.click();

        datePicker.get(3).click();
      //getCalendar();
        //btnPassengers.click();
        btnSearch.click();
        /*
        typeInto(txtPhone, flight.getDestination());
        typeInto(txtEmail, flight.getOutbound());
        typeInto(txtDate, flight.getPassengers());


        typeInto(txtNumber, flight.getReturn());
        typeInto(txtSearch, flight.getTime());
        display.click();

        evaluateJavascript("arguments[0].value=arguments[1];", txtColor, flight.getColor());
        btnSave.click();*/
    }

    private void getCalendar(){

        int currentDay = LocalDate.now().getDayOfMonth();

        for (int i = 0; i < datePicker.size(); i++) {

            String daysInRow = datePicker.get(i).getText();

            /*if(daysInRow.contains(currentDay))
            {
                datePicker.get(i+1).click();
                break;
            }*/

        }

    }

}
