package com.hojin.java_web_data_parsing_jsoup;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.oracle.tools.packager.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

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
        usingJsoupParsing();

        return league_ranks;
    }

    //Jsoup으로 웹 파싱하여 데이터 구성
    public void usingJsoupParsing(){
        try{
            Document doc = Jsoup.connect("https://sports.news.naver.com/wfootball/record/index.nhn?category=epl").get();
            String TeamRecord = doc.toString();
            //split 메소드로 json 부분만 남김
            String[] TeamRecords = TeamRecord.split("jsonTeamRecord:");
            TeamRecords = TeamRecords[1].split("teamRecordBodyName");
            //TeamRecords[0] = TeamRecords[0].replaceAll("\\\"","'");
            TeamRecords = TeamRecords[0].split(",\\\n");

            //json 파싱
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(TeamRecords[0]);

            //regularTeamRecordList 추출
            JSONArray regularTeamRecordListArray = (JSONArray) jsonObject.get("regularTeamRecordList");


            switch (league_name){
                //프리미어리그
                case "epl":
                    for(int i=0;i<regularTeamRecordListArray.size();i++){
                        //팀별로 스코어 점수 매칭 시키는 코드 작성

                        //순차 접근
                        JSONObject eplRecordObject = (JSONObject) regularTeamRecordListArray.get(i);

                        FormLeague_Rank league_rank = new FormLeague_Rank();

                        league_rank.setRank(Integer.parseInt(eplRecordObject.get("rank").toString()));
                        league_rank.setTeam(eplRecordObject.get("teamName").toString());
                        league_rank.setGame_count(Integer.parseInt((eplRecordObject.get("gameCount").toString())));
                        league_rank.setWin_score(Integer.parseInt(eplRecordObject.get("gainPoint").toString()));
                        league_rank.setWin(Integer.parseInt(eplRecordObject.get("won").toString()));
                        league_rank.setDraw(Integer.parseInt(eplRecordObject.get("drawn").toString()));
                        league_rank.setLose(Integer.parseInt(eplRecordObject.get("lost").toString()));
                        league_rank.setGet_point(Integer.parseInt(eplRecordObject.get("gainGoal").toString()));
                        league_rank.setLose_point(Integer.parseInt(eplRecordObject.get("loseGoal").toString()));
                        league_rank.setDiff_point(Integer.parseInt(eplRecordObject.get("goalGap").toString()));

                        league_ranks.add(league_rank);
                    }
                    break;
                //라리가
                case "primera":
                    break;

            }

        }catch(Exception e){}

    }
}
