package Enums;

import lombok.Getter;

public enum Endpoints {
    LOGIN("/login"),
    SIGNUP("/signup");

    @Getter
    private final String url;


    Endpoints(String url){
        this.url = url;
    }
}
