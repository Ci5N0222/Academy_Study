## Framework Spring 개요

#### EJB ( Enterprise Java Beans )
- 스프링의 전신

#### Spring 
- Light weight ( 경량 프레임워크 )
- POJO ( Plain Old Java Object )
- EJB에 비해 상대적으로 진입장벽이 낮다.
→ Legacy ( 구형 Spring )
- STS ( Spring Tool Suite ): 스프링을 다운받아 놓은 이클립스
- STS3: JAVA 11 버전 부터

#### SpringBoot
- STS4: JAVA 17 버전 부터

## Directory
- src/main/java : java 소스파일
- src/main/resources : java에서 사용할 자원 ( xml )
- src/test/* : 단위 테스트
- pom.xml : maven을 컨트롤
- WEB-INF : 외부접근으로 부터 차단, 클라이언트는 jsp로 직접 접근이 안됨
#### Maven : 라이브러리 관리자
#### Spring : 디자인 패턴 보조, 라이프 사이클 보조


## IOC ( inversion of control )
- 제어의 역전
- 제어를 개발자가 하는 것이 아닌 Spring에서 함


## Dispatcher Servlet
- 클라이언트의 모든 요청은 Dispatcher Servlet을 거치게 되어 있다.
- 클라이언트에게 어떤 요청이 왔는지 검사
- 클라이언트에게 첫번째 요청이 들어왔을 때 생성
- 이 시점 부터 Spring Container 2개 운영 (servlet-context.xml 기반으로 생성)

### Handler Mapper
- 클라이언트의 핸들러들에 대한 Mapping 정보를 가지고 있다.

### View Resolver
- 뷰의 이름을 조립해주는 역할
- prefix : 접두사 ( /경로/ )
- suffix : 접미사 ( .확장자 )

## Spring Project 서버 시작 시점에 발생되는 Sequence
1. Tomcat 구동
2. Tomcat이 web.xml을 분석하여 Context Loader Listener를 생성
3. ContextLoaderListener 내부 코드에 의해 Spring Container가 생성
4. SpringContainer는 설정 상 root-context.xml을 기반으로 생성
5. Dispatcher Servlet, Handler Mapper가 톰캣에 의해 생성
6. Dispatcher Servlet 내부 코드에 의해 두번째 Spring Container 생성
7. 두번째 Spring Container는 servlet-context.xml을 기반으로 한다.

#### Spring Container가 2개로 관리되는 이유
1. root-context
    - presentation Layer와 관련 없는 인스턴스 관리
2. servlet-context
    - presentation Layer 관련 인스턴스 관리


``` bash
/* 환경 설정 */

=========================== web.xml ===========================
    <!-- UTF-8 Encoding -->
    <filter>
        <filter-name>encoding-filter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    
    <filter-mapping>
        <filter-name>encoding-filter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>


======================= root-context.xml =======================
    <!-- DBCP -->
	<bean class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="username" value="<user_name>" />
		<property name="password" value="<user_password>" />
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
		<property name="url" value="jdbc:oracle:thin:@<db_url>:1521:xe" />
		<property name="initialSize" value="20" />
	</bean>

    <!-- !Presentation Layer (어노테이션을 쉽게 만들어 준다) -->
    <context:component-scan base-package="com.kedu.dao" />

====================== servlet-context.xml ======================
    <!-- 프로젝트 내부 어노테이션을 찾는다. -->
	<annotation-driven />

	<!-- 정적 파일 -->
	<resources mapping="/resources/**" location="/resources/" />

	<!-- Resolves views  -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
    <!-- Presentation Layer (어노테이션을 쉽게 만들어 준다) -->
	<context:component-scan base-package="com.kedu.controllers" />

```