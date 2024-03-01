package com.solvd.testautomation.api;

import com.solvd.testautomation.api.GetCurrentWeatherByCoordinates;
import com.solvd.testautomation.domain.Coordinate;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetWeatherByCoordinateTest {
    @Test
    public void verifyGetCurrentWeatherByCoordinateTest(){
        Coordinate coordinate = new Coordinate();
        coordinate.setLat(44.34);
        coordinate.setLon(20.99);
        GetCurrentWeatherByCoordinates currentWeatherByCoordinates = new GetCurrentWeatherByCoordinates(coordinate.getLat(),coordinate.getLon(),"86bedb8ff873ff41754873762b833ec6");
        currentWeatherByCoordinates.addProperty("coordinate",coordinate);
        currentWeatherByCoordinates.expectResponseStatus(HttpResponseStatusType.OK_200);
        currentWeatherByCoordinates.callAPI();
        currentWeatherByCoordinates.validateResponse();
    }
}
