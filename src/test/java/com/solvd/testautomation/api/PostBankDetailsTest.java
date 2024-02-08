package com.solvd.testautomation.api;

import com.solvd.testautomation.api.PostBankDetails;
import org.testng.annotations.Test;

public class PostBankDetailsTest {
    @Test
    public void verifyBankDetailsTest(){
        PostBankDetails postBankDetails = new PostBankDetails();
        postBankDetails.setProperties("api/bank.properties");
        postBankDetails.getProperties().remove("bank_name");
        postBankDetails.callAPI();
        postBankDetails.validateResponse();
    }
}
