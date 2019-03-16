package com.hojin.java_web_data_parsing_jsoup;

public class FormLeague_Rank {

    //순위, 팀명, 경기수, 승점, 승, 무, 패, 득점, 실점, 득실차 : 10개 항목
    private int rank;
    private String team;
    private int game_count;
    private int win_score;
    private int win;
    private int draw;
    private int lose;
    private int get_point;
    private int lose_point;
    private int diff_point;


    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGame_count() {
        return game_count;
    }

    public void setGame_count(int game_count) {
        this.game_count = game_count;
    }

    public int getWin_score() {
        return win_score;
    }

    public void setWin_score(int win_score) {
        this.win_score = win_score;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getGet_point() {
        return get_point;
    }


    public void setGet_point(int get_point) {
        this.get_point = get_point;
    }


    public int getLose_point() {
        return lose_point;
    }

    public void setLose_point(int lose_point) {
        this.lose_point = lose_point;
    }

    public int getDiff_point() {
        return diff_point;
    }

    public void setDiff_point(int diff_point) {
        this.diff_point = diff_point;
    }
}
