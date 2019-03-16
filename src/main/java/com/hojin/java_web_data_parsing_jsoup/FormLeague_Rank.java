package com.hojin.java_web_data_parsing_jsoup;

public class FormLeague_Rank {

    //순위, 팀명, 경기수, 승점, 승, 무, 패, 득점, 실점, 득실차 : 10개 항목
    private short rank;
    private String team;
    private short game_count;
    private short win_score;
    private short win;
    private short draw;
    private short lose;
    private short get_point;
    private short lose_point;
    private short diff_point;


    public void setRank(short rank) {
        this.rank = rank;
    }

    public short getRank() {
        return rank;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public short getGame_count() {
        return game_count;
    }

    public void setGame_count(short game_count) {
        this.game_count = game_count;
    }

    public short getWin_score() {
        return win_score;
    }

    public void setWin_score(short win_score) {
        this.win_score = win_score;
    }

    public short getWin() {
        return win;
    }

    public void setWin(short win) {
        this.win = win;
    }

    public short getDraw() {
        return draw;
    }

    public void setDraw(short draw) {
        this.draw = draw;
    }

    public short getLose() {
        return lose;
    }

    public void setLose(short lose) {
        this.lose = lose;
    }

    public short getGet_point() {
        return get_point;
    }


    public void setGet_point(short get_point) {
        this.get_point = get_point;
    }


    public short getLose_point() {
        return lose_point;
    }

    public void setLose_point(short lose_point) {
        this.lose_point = lose_point;
    }

    public short getDiff_point() {
        return diff_point;
    }

    public void setDiff_point(short diff_point) {
        this.diff_point = diff_point;
    }
}
