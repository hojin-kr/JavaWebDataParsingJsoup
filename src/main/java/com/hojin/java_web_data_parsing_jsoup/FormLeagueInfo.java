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
            Document doc = Jsoup.connect("https://sports.news.naver.com/wfootball/record/index.nhn?category=" + league_name).get();
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


            for(int i=0;i<regularTeamRecordListArray.size();i++) {
                // 스코어 매칭 시키는 코드

                //순차 접근
                JSONObject RecordObject = (JSONObject) regularTeamRecordListArray.get(i);

                FormLeague_Rank league_rank = new FormLeague_Rank();

                league_rank.setRank(Integer.parseInt(RecordObject.get("rank").toString()));
                league_rank.setTeam(RecordObject.get("teamName").toString());
                league_rank.setGame_count(Integer.parseInt((RecordObject.get("gameCount").toString())));
                league_rank.setWin_score(Integer.parseInt(RecordObject.get("gainPoint").toString()));
                league_rank.setWin(Integer.parseInt(RecordObject.get("won").toString()));
                league_rank.setDraw(Integer.parseInt(RecordObject.get("drawn").toString()));
                league_rank.setLose(Integer.parseInt(RecordObject.get("lost").toString()));
                league_rank.setGet_point(Integer.parseInt(RecordObject.get("gainGoal").toString()));
                league_rank.setLose_point(Integer.parseInt(RecordObject.get("loseGoal").toString()));
                league_rank.setDiff_point(Integer.parseInt(RecordObject.get("goalGap").toString()));

                league_ranks.add(league_rank);
            }


        }catch(Exception e){}

    }
}
