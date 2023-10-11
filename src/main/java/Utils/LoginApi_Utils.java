package Utils;

import Enums.Endpoints;
import Wrappers.RestWrapper;

import java.util.Map;

public class LoginApi_Utils {

    public static String getLoginApiResponseAsString(String baseUrlFilepath, String baseUrlKey, Endpoints endpoint
            , Object loginApiPayload, Map<String,String> headers){
        return RestWrapper.restPost(baseUrlFilepath, baseUrlKey, endpoint, loginApiPayload, headers);
    }

    public static int getLoginApiResponseStatusCode(String baseUrlFilepath, String baseUrlKey, Endpoints endpoint
                , Object loginApiPayload, Map<String,String> headers){
            return RestWrapper.restPost_getResponseStatusCode(baseUrlFilepath, baseUrlKey, endpoint, loginApiPayload, headers);
    }
}
