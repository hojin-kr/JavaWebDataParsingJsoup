package com.hojin.java_web_data_parsing_jsoup;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class FormLeagueInfo {
    private final String league_name;
    private List<FormLeague_Rank> league_rank = new ArrayList<>();

    //생서자, 클래스 호출시 수행
    public FormLeagueInfo(String league_name){
        this.league_name = league_name;


    }

    public String getLeague_name() {
        return league_name;
    }

    public List<FormLeague_Rank> getLeague_rank(){
        

        return league_rank;
    }
}
