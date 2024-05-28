## MVC 디자인 패턴
### MVC1
Model에 해당하는 데이터 처리 클래스만 분리되고, Controller와 view가 함께 처리되는 디자인 패턴
- M / C + V
- 단점1 : 역할 분담이 어렵다 ( Servlet이 Java 코드인 Controller와 HTML 코드인 View를 함께 작성하므로 역할 분리가 안됨 )
- 단점2 : Servlet에서의 프론트 코드 작성은 너무 불편하다

단점 2를 해결하기 위해 JSP가 등장하였다.

```bash
// MVC1 jsp 예시
  <%@page import="movie.dao.MovieDAO"%>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
      
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  </head>
  <body>
  
      <%
          String title = request.getParameter("title");
          String genre = request.getParameter("genre");
          
          System.out.println("title ==== " + title);
          System.out.println("genre ==== " + genre);
          
          MovieDAO dao = MovieDAO.getInstance();
          dao.addMovie(title, genre);
      %>
      
      Input Success <button id="ok">OK</button>
      
      <script>
          document.getElementById("ok").onclick = function(){
              location.href = "index.html";
          }
      </script>
      
  </body>

 // <% %> : Scriptlet : JSP에서 JAVA 문법을 사용
```

### MVC2
Model / View / Controller가 완벽하게 분리되는 구조의 디자인 패턴
- MVC1의 단점1을 해결하기 위해 등장
- MVC1에서 Controller와 View를 완벽하게 구분 짓기 위해 JSP는 View로만 사용하기 시작함
- 동적인 데이터를 바인딩하기 위해 JSP로 데이터를 forword

``` bash
List<TestDTO> list = dao.getList();
request.setAttribute("list", list);
request.getRequestDispatcher("list.jsp").forward(request, response);
```


### Servlet & JSP(Java Server Page)
Compile
- Java Compile ( Java → Binary code )
- JSP Compile  ( JSP → Servlet → Binary code )

### EL / JSTL
#### EL ( Expression Language )
- JSP 내에서 JAVA 문법이 아닌 새로운 문법으로 자바의 값을 사용하는 방법
- JAVA Servlet에서 추가한 Attribute Data를 JSP에서 사용하는 EL 문법
  - ${ int } == <% request.getAttribute("int") %>

#### JSTL
``` bash
// JSTL을 사용하기 위한 환경설정으로 core 기능을 prefix로 설정한 "c"로 사용!
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 조건문 1 --> 
<c:if test="${ param1 == 10 }">
    param1 == ${ param1 }
</c:if>


<!-- 조건문 2 --> 
<c:choose>
    <c:when test="${ param2 eq 'Hello' }">
        Param2 값은 ${ param2 }입니다.
    </c:when>
    <c:when test="${ param2 eq 'Hello JS' }">
        Param2 값은 ${ param2 }입니다.
    </c:when>
    <c:otherwise>
        Param2 값은 텍스트 입니다.
    </c:otherwise>
</c:choose>


<!-- 반복문 1 --> 
<c:forEach var="list" items="${ movieList }">
  <tr>
    <td>${list.id }</td>
    <td>${ list.title }</td>
    <td>${ list.genre }</td>
  </tr>
</c:forEach>
```


### 절대 경로 / 상대경로
- 절대 경로 지정법
  - action="/signup.members" → http://localhost/signup.members
- 상대 경로 지정법
  - action="signup.mnembers" → http://localhost/현재위치/signup.members

### Cookie 파일
- 과거 로그인 기록을 남겼던 기술
- 로그인 성공 후 사용자가 인증된 정보를 클라이언트에게 제공하여 파일로 보관하게 함
- 향후 클라이언트가 서버에 어떤 파일에 접근하던지 쿠키 파일을 제시하면 인증 사용자임을 확일 할 수있음
- 예시 : 집 키를 클라이언트가 가지고 있다가 필요할 때 마다 들고 가서 마음대로 여는 방식
- 파일을 사용하기 떄문에 보안 이슈 ( 파일 위치만 알면 쉽게 탈취 가능 )

### Session
- 로그인 성공 후, 인증되었다는 정보에 접근할 수 있는 key를 클라이언트에게 제공하여 보관할 수 있게 함
- 향후 클라이언트가 서버에 어떤 파일에 접근하던지 key를 제시하여 인증된 사용자임을 확인할 수 있음
- 예시 : 금고 은행에 키를 제시하여 인증 여부를 확인하는 방식
- 서버 측에서 사용자에 대한 추가적인 검증을 수행할 수 있음 ( IP, User-Agent 등 )
- JSON(MAP) 내에 JSON(MAP)을 저장하는 방식

### Cookie와 Session의 장단점
- Cookie
  - 인증 정보를 클라이언트가 보관하므로 서버에 부하가 상대적으로 낮음
  - 반면 인증 정보를 탊취 당할 시, 해킹으로 부터 매우 취약
- Session
  - 인증 정보를 탈취 당해도, 서버측 추가 검증을 통해 보안성을 확립할 수 있음
  - 인증 정보를 서버측에 보관하여, 추가 검증 로직이 들어가므로 서버 부하가 상대적으로 높음

#### 하이잭킹
- 쿠키의 인증된 정보 파일, 세션의 인증된 key를 탈취하는 해킹 기술을 말함
