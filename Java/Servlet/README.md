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