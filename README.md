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
