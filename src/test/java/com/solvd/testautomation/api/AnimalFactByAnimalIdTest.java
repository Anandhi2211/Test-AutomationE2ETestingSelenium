package com.solvd.testautomation.api;

import com.solvd.testautomation.api.GetAnimalFactsByAnimalType;
import com.solvd.testautomation.api.GetAnimalFactsById;
import com.solvd.testautomation.domain.Animal;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class AnimalFactByAnimalIdTest {

    @Test
    public void verifyAnimalFactByIdTest(){
        Animal animal = new Animal();
        animal.setId("65789429250dc04ab5206abf");
        GetAnimalFactsById getAnimalFactsById = new GetAnimalFactsById(animal.getId());
        getAnimalFactsById.addProperty("animal", animal);
        getAnimalFactsById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAnimalFactsById.callAPI();
        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date) && ZonedDateTime.parse(date)
                        .isAfter(LocalDate.of(1999,1,1)
                                .atStartOfDay(ZoneId.systemDefault())));
        getAnimalFactsById.validateResponse(comparatorContext);
    }

    private static boolean isDateValid(String date) {
        try {
            ZonedDateTime.parse(date);
            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
