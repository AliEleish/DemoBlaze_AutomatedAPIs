package POJO.Models.RequestsModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginApiRequestModel {

    private String username;
    private String password;

    public LoginApiRequestModel(String username, String password){
        setUsername(username);
        setPassword(password);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
