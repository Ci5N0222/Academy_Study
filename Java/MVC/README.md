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

```


### MVC2
Model / View / Controller가 완벽하게 분리되는 구조의 디자인 패턴
- MVC1의 단점1을 해결하기 위해 등장






Servlet & JSP(Java Server Page)
JSP의 컴파일은 2번 진행됨 ( JSP → Servlet → Binary code, Java → Binary code )


<% %> : Scriptlet