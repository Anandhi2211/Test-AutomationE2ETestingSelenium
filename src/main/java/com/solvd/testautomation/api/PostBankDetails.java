package com.solvd.testautomation.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.http.HttpMethodType;


@Endpoint(url="${config.random_api_url}/banks}",methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/get/animal_facts_by_type_rs.json")

public class PostBankDetails extends AbstractApiMethodV2 {
    public PostBankDetails() {
        super("api/post/bank_rq.json","api/post/bank_rs.json","api/bank.properties");
    }
}
