package com.solvd.testautomation.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url="${config.cat_api_url}/facts/random?animal_type=${animalType}&amount=${count}",methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/get/animal_facts_by_type_rs.json")
public class GetAnimalFactsByAnimalType extends AbstractApiMethodV2 {
    public GetAnimalFactsByAnimalType(String animalType, int count) {
        replaceUrlPlaceholder("animalType", animalType);
        replaceUrlPlaceholder("count", String.valueOf(count));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
