# Spring Boot Project
        
* Dependency 설정
      	    <dependency>
    			<groupId>org.springframework.boot</groupId>
        		<artifactId>spring-boot-starter-security</artifactId>
     		</dependency>
        
       
            <dependency>
                <groupId>org.thymeleaf.extras</groupId>
                <artifactId>thymeleaf-extras-springsecurity5</artifactId>
            </dependency>

* Spring Framework 에 Security 관련 Dependency를 설정하면 Project 가
* Security 에 wrapping 되어 모든 제어가 Security를 거쳐서 작동된다
* Security 관련 Config를 설정하여 Security 작동을 Custom화 하여
* Project를 진행하게 된다

## Spsring Security 에서 POST 전송
* Security Proeject 에서는 절대 일반적인 방법으로는 POST로 데이터를 보낼수 없다
* thymeleaf 의 extra security의 도움을 받아 FORM을 재설정해야한다
* Security 에서 POST로 데이터를 서버로 전송하려면 
반드시 _csrf 변수에 Token을 담아서 같이 보내야 한다
* thymeleaf 에서 form tag에 th:action={} 지정하면 자동으로 해당 변수가
form에 <input type=hidden>으로 설정되어 준비 된다

## CSRF : Cross-site Request Forgery
* 상대방 서버의 input form 화면의 코드를 복제하여 로컬에 파일로 만들고,
    일부 내용을 위조하여 다시 submit 하여 서버로 전송하는 해킹 행위

* Spring Security는 POST로 전송되는 모든 데이터에 대하영 CSRF 거부정책을 수행한다
* POST 전송되는 모든 데이터에 _csrf 데이터가 없으면 거부한다 (403 Forbidden 오류 발생)
* tymeleaf 의 extar_security 를 dependency에 설정해 두면
	thymleaf 에서 _csrf 값을 취급할수 있다

  

    