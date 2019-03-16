package com.hojin.java_web_data_parsing_jsoup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class FormLeagueInfo {
    private final String league_name;
    private List<FormLeague_Rank> league_ranks = new ArrayList<>();

    //생서자, 클래스 호출시 수행
    public FormLeagueInfo(String league_name){
        this.league_name = league_name;


    }

    public String getLeague_name() {
        return league_name;
    }

    public List<FormLeague_Rank> getLeague_rank(){


        return league_ranks;
    }

    //Jsoup으로 웹 파싱하여 데이터 구성
    public void usingJsoupParsing(){
        switch (league_name){
            //프리미어리그
            case "epl":try{
                Document doc = Jsoup.connect("https://sports.news.naver.com/wfootball/record/index.nhn?category=epl").get();
                for(short i=0;i<10;i++){
                    //팀별로 스코어 점수 매칭 시키는 코드 작성

                    FormLeague_Rank league_rank = new FormLeague_Rank();




                }



            }catch(Exception e){
                //에러
            }
            //라리가
            case "primera":try{
                Document doc = Jsoup.connect("https://sports.news.naver.com/wfootball/record/index.nhn?category=epl").get();



            }catch(Exception e){
                //에러
            }

        }
    }
}
