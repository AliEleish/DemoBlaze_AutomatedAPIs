package APIs_Tests;

import DataReaders.PropertiesFileReader;
import Enums.Endpoints;
import POJO.Models.RequestsModels.SignupApiRequestModel;
import Utils.SignupApi_Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SignUpApi_Tests {

    @Test
    public void validateSignupAPiResponse(){
        PropertiesFileReader propertiesReader = new PropertiesFileReader("src/main/java/Properties/APIs_TestData.properties");
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        SignupApiRequestModel signupApi_payload = new SignupApiRequestModel(propertiesReader.getPropertyValue("signup_username")
        ,propertiesReader.getPropertyValue("signup_password"));
        String SignupAPiResponseAsString = SignupApi_Utils.getSignupApiResponseAsString("src/main/java/Properties/BaseUrl.properties"
        ,"BaseUrl", Endpoints.SIGNUP,signupApi_payload,headers);
        if (SignupAPiResponseAsString.contains("This user already exist.")){
            try {
                throw new Exception("This user already exists, Please update the value of signup_username in" +
                        " APIs_TestData.properties file");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void validateSignupApiResponse_StatusCode(){
        PropertiesFileReader propertiesReader = new PropertiesFileReader("src/main/java/Properties/APIs_TestData.properties");
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        SignupApiRequestModel signupApi_payload = new SignupApiRequestModel(propertiesReader.getPropertyValue("signup_username")
                ,propertiesReader.getPropertyValue("signup_password"));
        int SignupAPiResponse_StatusCode = SignupApi_Utils.getSignupApiResponse_StatusCode("src/main/java/Properties/BaseUrl.properties"
                ,"BaseUrl", Endpoints.SIGNUP,signupApi_payload,headers);
    }
}
