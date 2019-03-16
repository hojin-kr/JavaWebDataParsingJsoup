package com.hojin.java_web_data_parsing_jsoup;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//Rest ful 하게 api를 구현하도록 해줌
@RestController
public class RestControllerClass {

    //epl : 프리미어리그
    //요청에 대해 특정 메소드에 대한 맵핑, 연결
    @RequestMapping("football/rank/epl")
    public FormLeagueInfo EplLeagueInfo(){

        return new FormLeagueInfo("epl");
    }
}
