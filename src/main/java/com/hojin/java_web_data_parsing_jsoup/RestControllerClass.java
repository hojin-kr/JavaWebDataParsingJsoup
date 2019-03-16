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
    //라리가
    @RequestMapping("football/rank/primera")
    public FormLeagueInfo PrimeraLeagueInfo(){

        return new FormLeagueInfo("primera");
    }
    //분데스리가
    @RequestMapping("football/rank/bundaesliga")
    public FormLeagueInfo bundaesligaLeagueInfo(){

        return new FormLeagueInfo("bundaesliga");
    }
    //세리에 A
    @RequestMapping("football/rank/seria")
    public FormLeagueInfo seriaLeagueInfo(){

        return new FormLeagueInfo("seria");
    }
    //리그1
    @RequestMapping("football/rank/ligue1")
    public FormLeagueInfo ligue1LeagueInfo(){

        return new FormLeagueInfo("ligue1");
    }
    //에레디비시
    @RequestMapping("football/rank/eredivise")
    public FormLeagueInfo erediviseLeagueInfo(){

        return new FormLeagueInfo("eredivise");
    }
}
