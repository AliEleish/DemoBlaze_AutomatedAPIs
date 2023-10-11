package Utils;

import Enums.Endpoints;
import Wrappers.RestWrapper;

import java.util.Map;

public class SignupApi_Utils {

    public static String getSignupApiResponseAsString(String baseUrlFilePath, String baseUrl_key, Endpoints endpoint
            , Object apiPayload, Map<String,String> headers){
        return RestWrapper.restPost(baseUrlFilePath,baseUrl_key,endpoint,apiPayload,headers);
    }

    public static int getSignupApiResponse_StatusCode(String baseUrlFilePath, String baseUrl_key, Endpoints endpoint
            , Object apiPayload, Map<String,String> headers){
        return RestWrapper.restPost_getResponseStatusCode(baseUrlFilePath,baseUrl_key,endpoint,apiPayload,headers);

    }
}
