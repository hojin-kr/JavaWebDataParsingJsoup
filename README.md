# JavaWebDataParsingJsoup
자바에서 Jsoup 라이브러리를 사용하여 데이터를 수집하고 REST API를 구현합니다.

주어지 사이트에서 리그별 경기 정보를 수집합니다.

웹 페이지의 경기 정보 테이블이 JavaScript Script 작성되어 Jsoup이 제대로 읽어오지 못하는 이슈가 발생하여
split과 JSONParser를 사용하여 데이터를 정리, 분리하여 REST api를 구현

![실행](https://user-images.githubusercontent.com/22079767/54603829-ab369700-4a88-11e9-8e21-4a30922f9ebe.png)

### Spring boot 에서 REST API
~~~
//Rest ful 하게 api를 구현하도록 해줌
@RestController
public class RestControllerClass {
~~~
@RestController 어노테이션으 REST API 구현을 선언함

### 요청 매핑
~~~
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
~~~
@ReauestMapping(/directory/) 어노테이션을 사용하여 요청에 따 다른 값을 응답하도록함

### 데이터 파싱
~~~
Document doc = Jsoup.connect("https://sports.news.naver.com/wfootball/record/index.nhn?category=" + league_name).get();
            String TeamRecord = doc.toString();
            //split 메소드로 json 부분만 남김
            String[] TeamRecords = TeamRecord.split("jsonTeamRecord:");
            TeamRecords = TeamRecords[1].split("teamRecordBodyName");
            //TeamRecords[0] = TeamRecords[0].replaceAll("\\\"","'");
            TeamRecords = TeamRecords[0].split(",\\\n");
~~~
Jsoup의 get() 메소드로 타게 웹의 전체 구조를 받아와 작업합니다. 전체 구조에서 원하는 요소를 Jsoup에서 제공하는 다양하 선택자로 선택하 분리하려고 하였으나 네이버 스포츠 사이트의 리그 정보 테이블이 자바스크립으로 생성하도로 되어있고 Jsoup에서는 자바스크립트 해석이 안되서 자바스크립트 그대로 노출됨 따라서 DOM(문서객체모델)을 사용한 선택자 활용에 제약이 생김. 대안으로 split()과 replaceAll() 메소들 원하는 부분만 추출하여 데이터를 분리함

### 각 데이터 원하는 응답 이름에 매칭
~~~
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
~~~
전체 스콩 데이터를 JSON 형태로 추출한 reqularTeamRecordListArray의 값을 각 이름에 맞게 저장함.

   
    
