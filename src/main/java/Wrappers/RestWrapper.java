package Wrappers;

import DataReaders.PropertiesFileReader;
import Enums.Endpoints;
import io.restassured.parsing.Parser;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestWrapper {

    public static String restPost(String baseUrlFilePath, String baseUrl_key, Endpoints endpoint, Object apiPayload
            , Map<String,String> headers){
        PropertiesFileReader propertiesReader = new PropertiesFileReader(baseUrlFilePath);
       String baseUrl = propertiesReader.getPropertyValue(baseUrl_key);
       String responseAsString = given().headers(headers).body(apiPayload).expect().defaultParser(Parser.JSON).when()
               .post(baseUrl.concat(endpoint.getUrl())).then().extract().asString();
       System.out.println(responseAsString);
        return responseAsString;
    }

    public static int restPost_getResponseStatusCode(String baseUrlFilePath, String baseUrl_key, Endpoints endpoint, Object apiPayload
            , Map<String,String> headers){
        PropertiesFileReader propertiesReader = new PropertiesFileReader(baseUrlFilePath);
        String baseUrl = propertiesReader.getPropertyValue(baseUrl_key);
        int responseStatusCode = given().headers(headers).body(apiPayload).expect().defaultParser(Parser.JSON).when()
                .post(baseUrl.concat(endpoint.getUrl())).then().extract().statusCode();
        System.out.println("Api Response Status code is " + responseStatusCode);
        return responseStatusCode;


    }
}
