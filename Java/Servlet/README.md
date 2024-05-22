## Web Server
- 정해진 규격 (HTML)의 파일을 전송해주는 서버
- Client는 규격의 파일을 Browser라는 도구에서 출력함
- 과거 Web Server는 단순 파일 전송용 서버로 더 복잡한 기능은 구현할 수 없었음
    - 예 : Client의 데이터 기록 또는 사용자 인증 등등...

## WAS ( Web Application Server )
- 기존 정해진 규격의 문서 (HTML, CSS, JS) 뿐만 아니라, 프로그램을 탑재하고 있다가 클라이언트의 요청에 따라 실행시켜줄 수 있는 서버
- Client와 Web Application을 연결하는 Middle Ware
- 대표적인 WAS의 사례 : Tomcat

### Tomcat
- Client의 요청을 Server로 전달함 ( 요청 처리 X )
- Middle Ware

### Servlet
- 서버 측 웹 어플리케이션을 자바로 만들었을 때 Servlet 이라 함
- Tomcat이 가동되면 Servlet들은 인스턴스 생성 됨 (new)
- form 태그에서 action되는 경로는 Servlet 어노테이션에 매핑된 부분을 사용함
    - @WebServlet("/Exam01") → \<form action="/Exam01">
- 요청을 받고 응답까지 하는 것이 서블릿의 역할

### HTTP Protocol
1. Client → Server ( Request )
2. Server → Client ( Response )
- request : Client (submit) → Tomcat Server (헤드 영역 확인) → Java (Servlet)

### GET & POST
- GET
  - 전송하고자 하는 데이터를 Head 영역 URL 필드에 담아서 전송하는 방식
  - 서버에 전송하고자 하는 데이터가 주소창에 노출되는 특성이 있음
  - URL을 통한 절대 주소값 공유가 가능하다.
  - 데이터가 주소창에 노출되기 때문에 보안에 매우 취약하다.
  - 데이터가 head 영역에 포함되므로 데이터 적재량이 적다 ( 대량 데이터 전송 불가 )
- POST
  - 전송하고자 하는 데이터를 body 영역에 담아서 전송하는 방식
  - 데이터의 노출 없이 메모리에만 담겨서 전송됨
  - 데이터의 노출이 없기 때문에 GET 방식 대비 보안성이 미미하게 좋음
  - 대량 데이터 전송 가능 ( 이미지, 영상, 게임 등등의 파일 업로드 )
  - 공유 능력이 없음 ( 절대 URL 값을 얻을 수 없음 )


### 주소구조
- http://www.gagao.com/servletName?name=kim&age=20
  - http:// : 프로토콜
  - www.gagao.com : 도메인 네임, IP 주소
  - servletName : 서블릿
  - ?name=kim&age=20 : 인자 구분자
    - name은 kim이고 age는 20인 파라미터를 URL로 가지고 있음