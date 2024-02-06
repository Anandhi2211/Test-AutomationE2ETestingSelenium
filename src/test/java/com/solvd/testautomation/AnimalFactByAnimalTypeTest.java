package com.solvd.testautomation;

import com.solvd.testautomation.api.GetAnimalFactsByAnimalType;
import com.solvd.testautomation.domain.Animal;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class AnimalFactByAnimalTypeTest {

    @Test
    public void verifyAnimalDataTest() {
        Animal animal = new Animal();
        animal.setAnimalType("cat");
        animal.setCount(1);
        GetAnimalFactsByAnimalType getAnimalFactsByAnimalType = new GetAnimalFactsByAnimalType(animal.getAnimalType(), animal.getCount());
        getAnimalFactsByAnimalType.addProperty("animal", animal);
        getAnimalFactsByAnimalType.expectResponseStatus(HttpResponseStatusType.OK_200);
        getAnimalFactsByAnimalType.callAPI();
        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date) && ZonedDateTime.parse(date)
                        .isAfter(LocalDate.of(1999,1,1)
                                .atStartOfDay(ZoneId.systemDefault())));

//        getAnimalFactsByAnimalType.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
//
        getAnimalFactsByAnimalType.validateResponse(comparatorContext);
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
