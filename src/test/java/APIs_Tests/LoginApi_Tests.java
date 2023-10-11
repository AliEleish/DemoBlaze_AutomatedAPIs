package APIs_Tests;

import DataReaders.PropertiesFileReader;
import Enums.Endpoints;
import POJO.Models.RequestsModels.LoginApiRequestModel;
import Utils.LoginApi_Utils;
import Wrappers.RestWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginApi_Tests {


    @Test
    public void validateLoginAPiResponseContainsAuthToken(){
        PropertiesFileReader propertiesReader = new PropertiesFileReader("src/main/java/Properties/APIs_TestData.properties");
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        LoginApiRequestModel loginApiPayload = new LoginApiRequestModel(propertiesReader
                .getPropertyValue("login_username"), propertiesReader.getPropertyValue("login_password"));
      String loginApiResponseAsString =
              LoginApi_Utils.getLoginApiResponseAsString("src/main/java/Properties/BaseUrl.properties","BaseUrl"
                      , Endpoints.LOGIN,loginApiPayload,headers);
      Assertions.assertTrue(loginApiResponseAsString.contains("Auth_token"));
    }

    @Test
    public void validateLoginApiResponseStatusCode(){
        PropertiesFileReader propertiesReader = new PropertiesFileReader("src/main/java/Properties/APIs_TestData.properties");
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        LoginApiRequestModel loginApiPayload = new LoginApiRequestModel(propertiesReader
                .getPropertyValue("login_username"), propertiesReader.getPropertyValue("login_password"));
        int loginApiResponseStatusCode =
               LoginApi_Utils.getLoginApiResponseStatusCode("src/main/java/Properties/BaseUrl.properties"
                        ,"BaseUrl", Endpoints.LOGIN,loginApiPayload,headers);
        Assertions.assertEquals(loginApiResponseStatusCode
                ,Integer.parseInt(propertiesReader.getPropertyValue("apiResponse_Success_StatusCode")));
    }
}
