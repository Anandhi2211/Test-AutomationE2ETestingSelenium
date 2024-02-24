package com.solvd.testautomation.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;


@Endpoint(url="${config.cat_api_url}/facts/${id}",methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/get/animal_facts_by_id_rs.json")
public class GetAnimalFactsById extends AbstractApiMethodV2 {
    public GetAnimalFactsById(String id) {
        replaceUrlPlaceholder("id", id);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
