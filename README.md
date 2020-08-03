# 🤸‍♀️ WELCOME ! AoneeMall ! 🤸‍♀️



<br>



## ⚙ 프로젝트 개발환경
프로젝트 개발 환경은 다음과 같다.

IDE : IntelliJ IDEA Ultimate   
Git Tools : Git Bash   
OS : Window   
SpringBoot 2.1.9   
Java8   
Gradle 4.10.2  

 👉 springBootVersion 2.1.7 / 2.1.8 / 2.1.9 모두 괜찮으나, 2.2 이상 버전에서는 정상작동 하지 않는다.

 👉 Gradle 5.x에서는 정상작동 하지 않는다.   
		🙋‍♀️ **`Gradle 4.10.2  ` 로 변경하는 방법 ?**    

​		인텔리제이에서 `alt+F12` 눌러 👉  터미널에서 `gradlew wrapper --gradle-version 4.10.2` 명령어 실행





<br>







## 🧶 build.gradle
```
buildscript {
    ext {
        springBootVersion = '2.1.9.RELEASE'
    }
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

group = 'com.devAon'
version '1.0.4-SNAPSHOT-'+new Date().format("yyyyMMddHHmmss")

sourceCompatibility = 1.8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter-web')
    compile('org.projectlombok:lombok')
    compile('org.springframework.boot:spring-boot-starter-data-jpa')
    compile('com.h2database:h2')
    compile('org.springframework.boot:spring-boot-starter-mustache')

    testCompile('org.springframework.boot:spring-boot-starter-test')
}

```

 

* **ext** 

  : build.gradle에서 사용하는 전역변수를 설정한다는 의미

* **spring-boot-gradle-plugin:${springBootVersion}**

  : springBootVersion = '2.1.9.RELEASE' 를 의존성으로 받겠다는 의미

* **repositories**

  : 각종 의존성(라이브러리)들을 어떤 원격 저장소에 받을지 정한다

  * **mavenCentral()**

    : 기본적으로 많이 사용. 

      하지만 라이브러리 업로드를 위해 정말 많은 과정과 설정이 필요해서 힘듦

  * **jcenter()**

    : 라이브러리 업로드 문제점 개선해서 간단하게 해줌

    jcenter에 라이브러리를 업로드하면 mavenCentral에도 업로드될 수 있도록 자동화할 수 있다. 

  👉 요즘은 jcenter을 더 많이 사용하지만, 프로젝트에서는 둘 다 등록해서 사용할 것이다.

* **dependencies**

  * **lombok**
    🙋‍♀️ **추가하는 방법 ?**   
    **step 1 )** `build.gradle`의 `dependencies`에 `compile('org.projectlombok:lombok')` 추가   
    **step 2 )** `Setting > Build > Compiler > Annotation Processros` 에서 `Enable annotation processing` 체크를 통해   
    		해당 프로젝트에서 롬복을 사용할 수 있도록 해줘야 한다. (롬복은 프로젝트마다 설정해야 한다 ! ! !)

  * **spring-boot-starter-jpa**
    스프링 부트용 Spring Data JPA 추상화 라이브러리

    스프링 부트 버전에 맞춰 자동으로 JPA 관련 라이브러리들의 버전을 관리해준다.
    
  * **h2**
  
    인메모리 RDBMS
  
    별도의 설치 없이 프로젝트 의존성만으로 관리할 수 있다
  
    메모리에서 실행되기 때문에 애플리케이션을 재시작할 때마다 초기화된다는 점을 이용하여 테스트 용도로 많이 사용된다
  
    AoneeMall 프로젝트에서는 JPA의 테스트, 로컬 환경에서의 구동에서 사용할 예정 !







<br>



## 🔗 패키지 구조

### src-main-java

* **web** : 컨트롤러와 관련된 클래스

* **domain** : 도메인 (소프트웨어에 대한 요구사항 or 문제영역)

  * **Posts** 

    : 도메인 클래스

  * **PostsRepository** 

    : Posts 클래스로 DB를 접근하게 해줄 JpaRepository  

    MyBatis 등에서 Dao라고 불리는 DB Layer 접근자

    JPA에서는 Repository라고 부르며 인터페이스로 생성한다.

    JpaRepository<Entity 클래스, PK타입> 을 상송하면 기본적인 CRUD 메소드가 자동으로 생성된다. ex) JpaRepository<Posts, Long>

    ✍ **주의** ✍    

    Entity 클래스와 기본 Repository는 함께 위치해야 제대로된 역할을 할 수 있다.

    

















<br>

<br>



## 📌 feature-1 : 프로젝트 생성

> build.gralde 의 코드의 역할 및 의존성 추가 방법을 스스로 해보자 !



### 📝 스프링 이니셜라이저 없이 프로젝트 생성하기

1. **프로젝트 생성**

   create - Gradle - Java

2. **그레이들 프로젝트를 스프링 부트 프로젝트로 변경하기**

   > build.gradle
   
   

```
buildscript {
    ext {
        springBootVersion = '2.1.9.RELEASE'
    }
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

group = 'com.devAon'
version '1.0.4-SNAPSHOT-'+new Date().format("yyyyMMddHHmmss")

sourceCompatibility = 1.8

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter-web')
    testCompile('org.springframework.boot:spring-boot-starter-test')
}


```

   👉 프로젝트의 플러그인 의존성 관리를 위한 설정



<br><br><br>



## 📌 feature-4 : TDD

### 📝 SpringBootApplication 추가



```
package com.devAon.aoneemall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}

```



* **해당 클래스는 프로젝트의 메인 클래스**

* **@SpringBootApplication**

  : 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 모두 자동으로 설정된다.

  ✍ **주의** ✍    

   @SpringBootApplication 이 있는 위치부터 설정을 읽어가기 때문에 항! 상! **프로젝트의 최상단**에 위치해야 한다.

* **SpringApplication.run**

  : 내장 WAS( Web Application Server)를 실행한다.

  🐥 **내장 WAS 란 ?**

  * 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 의미
  * 내장 WAS 사용 이유 ? 
    항상 서버에 톰캣을 설치할 필요가 없다.
    스프링 부트로 만들어진 Jar 파일 (실행 가능한 Java 패키징 파일)로 실행하면 된다.
  * `언제 어디서나 같은 환경에서 스프링 부트를 배포` 할 수 있기 때문에 내장 WAS 사용 권장
  * 외장 WAS 지양하는 이유 ? 
    모든 서버는 WAS의 종류, 버전, 설정을 일치시켜야만 한다.   ~~Oh my God~~  



<br>



### 📝 API 작성

* **@RestController**

  : JSON을 반환하는 컨트롤러로 만들어준다

* **@GetMapping**

  : HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어준다

* **@PostMapping, @PutMapping, @DeleteMapping**

* **@RequestParam**

  : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션

  파라미터에서 name `@RequestParam("name")`이란 이름으로 넘긴 값을 메소드 파라미터 name`(String name)`에 저장





<br>




### 📝 TDD란 ? 

**Test Driven Development, 테스트 주도 개발**

* **Red**

  : 항상 실패하는 테스트를 먼저 작성

* **Green**

  : 테스트가 통과하는 프로덕션 코드를 작성

* **Refactor**

  : 테스트가 통과하면 프로덕션 코드를 리팩토링



<br>



### 📝 TDD 장점

1. **빠른 피드백 가능**   

   ❌ TDD 사용 안한다면 ? `번거롭다     `

   ​	프로그램(Tomcat)을 실행하고    

   ​	Postman과 같은 API 도구로 HTTP 요청하고   

   ​	System.out.println()으로 눈으로 검증하고 결과가 다르면    

   ​	결과가 다르면 다시 프로그램(Tomcat)을 중지하고 코드 수정   

2. **자동검증 가능**   

3. **개발자가 만든 기능을 안전하게 보호**   

   EX)   

   기존에 잘되던 A기능이 B기능을 추가하고 문제가 발생했다.   

   새로운 기능이 추가될 때, 기존 기능이 잘 작동되는 것을 보장해주는 것이 테스트 코드이다.    

   A라는 기존 기능에 기본 기능을 비롯해 여러 경우를 모두 테스트 코드로 구현해 놓았다면 테스트 코드를 수행만 하면 조기에 문제를 찾을 수 있다.   

   (서비스의 모든 기능을 테스트하기 위해서는 너무나 많은 자원이 드는데 이를 방지할 수 있다 ❗)



<br>



### 📝 TDD 작성



> Controller TDD



* **@RunWith(SpringRunner.class)**

  : 스프링 부트 테스트와 JUnit 사이에 연결자 역할
  테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
  실행자 : SpringRunner

* **@WebMvcTest**

  : 여러 스프링 테스트 어노테이션 중, Web (Spring MVC)에 집중할 수 있는 어노테이션

  사용 가능 - @Controller, @ControllerAdvice

  사용 불가능 - @Service, @Component, @Repository

* **@Autowired**

  : 스프링이 관리하는 빈(Bean)을 주입 받는다.

* **private MockMvc mvc**

  : 웹 API 를 테스트할 때 사용   

  스프링 MVC 테스트의 시작점   

  이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.

* **mvc.perform(get("/hello"))**

  : MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다   
  
  체이닝이 지원되어 여러 검증 기능을 이어서 선언할 수 있다.
  
* **.andExpect(status().isOk())**

  : mvc.perform 의 결과를 검증한다.

  HTTP Header의 `Status를 검증`한다.

  Status인 200,404, 500 등 상태 중 200인지 검증한다

* **.andExpect(content().string(hello))**

  : mvc.perform 의 결과를 검증한다.

  `응답 본문의 내용을 검증`한다.

  Controller에서 리턴하는 "hello"와 내용이 일치하는지 검증한다. 

* **param**

  : API 테스트할 때 사용될 요청 파라미터를 설정

  단, 값은 String만 허용된다.

  따라서, 숫자/날짜/숫자 등 문자열로 변경해야만 가능

* **jsonPath**

  : JSON 응답값을 필드별로 검증할 수 있는 메소드

  $를 기준으로 필드명 명시

  ​	ex) $.amount



> DTO TDD



* **assertThat**

  : `org.assertj.core.api.Assertions.assertThat` assertj의 테스트 검증 라이브러리의 검증 메소드

  검증하고 싶은 대상을 메소드 인자로 받는다

  메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있다.

* **isEqualTo**

  : assertj의 동등 비교 메소드

  assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공



> Repository TDD



* **@RunWith(SpringRunner.class)**

* **@SpringBootTest**

  : H2 데이터베이스를 자동으로 실행해준다.

* **@After**

  : Junit 에서 단위 테스트가 끝날 때마다 수행되는 메소도를 지정

  🙋‍♀️ **언제 사용해 ?**

  보통, 배포 전, 전체 테스트 수행 시, 테스트간 데이터 침범을 막기 위해 사용한다.

  여러 테스트가 동시에 수행되면 테스트용 DB인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행 시, 테스트가 실패할 수 있기 때문이다.

* **postRepository.save**

  : 테이블 posts에 insert/update 쿼리를 실행한다.

  id 값이 있다면 update, 없다면 insert 쿼리가 실행된다.

* **postRepository.findAll**
  
  : 테이블 posts에 있는 모든 데이터를 조회하는 메소드



<br>



### 📝 lombok 사용

* **@Getter**

  선언된 모든 필드의 get 메소드를 생성해준다

* **@RequireArgsConstructor**

  선언된 모든 final 필드가 포함된 생성자를 생성해줌

  final이 없는 필드는 생성자에 포함되지 않는다.
  
* **@NoArgsConstructor**

  : 기본 생성자 자동 추가

  ex)

  public Posts() {} 와 같은 효과

* **@Builder**

  : 해당 클래스의 빌더 패턴 클래스를 생성

  생성자 상단에 선언 시, 생성자에 포함된 필드만 빌더에 포함

👉 서비스 초기 구축 단계에서 빈번하게 테이블 설계가 변경되는데, 

​		롬복의 어노테이션들은 코드 변경량을 최소화시켜 주기 때문에 적극적으로 사용한다 !





<br><br><br>



## 📌 feature-8 : JPA

### 📝 JPA란 ?

객체지향적으로 프로그래밍을 하고, JPA가 이를 RDBMS에 맞게 SQL을 대신 생성해서 실행한다.   

즉, JPA는 중간에서 패러다임을 일치시켜주는 기술이다.   



🙋‍♀️ **무슨 소리냐구 ?**    

RDBMS와 객체지향 프로그래밍 언어의 패러다임은 서로 달라 문제가 발생한다. (RDBMS에 없는 상속의 개념도 해결해줌 !)   

그런데! ! !  JPA가 이를 해결해준다.  ~~WOW~~

🐥 **참고**

`RDBMS 패러다임 `: 어떻게 데이터를 저장할지 초점이 맞춰진 기술   

`객체지향 프로그래밍 언어 패러다임` : 객체는 기능과 속성을 한 곳에 관리하는 기술   



<br>



### 📝 Spring Data JPA란 ?

JPA : 인터페이스로서 자바 표준명세서

인터페이스인 JPA를 사용하기 위해서는 구현체가 필요하다.

대표적으로 Hibernate, Eclipse, Link등이 있다.   

   



하지만 Spring에서 JPA를 사용할 때는 이 구현체를 직접 다루지 않는다.

Spring Data JPA라는 모듈을 이용하여 JPA 기술을 다룬다.

`JPA 👈 Hibernate  👈 Spring Data JPA`

Hibernate와 Spring Data JPA 쓰는 것 사이에는 큰 차이가 없다   

   

**🙋‍♀️ 그러나 Spring Data JPA 가 등장한 이유는 ?** 



> 스프링 진영에서 개발함



**1) 구현체 교체의 용이성**

​		Hibernate 외에 다른 구현체로 쉽게 교체하기 위함

**2) 저장소 교체의 용이성**

​        RDBMS 외에 다른 저장소로 쉽게 교체하기 위함

​		만약, NoSQL인 MongoDB로 교체가 필요하다면 Spring Data MongoDB로 의존성만 교체하면 된다.

👉 Spring Data 의 하위 프로젝트들은 기본적인 CRUD의 인터페이스가 같고 1)2)와 같은 장점들로 인해 Spring Data JPA를 권장한다.





<br>



 ### 📝 JPA 어노테이션

* **@Entity**

  : 테이블과 링크될 클래스임을 나타낸다.

  기본 값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍 (_) 으로 테이블 이름을 매칭한다.

  ex ) SalesManager.java -> sales_manager table

* **@ Id**

  해당 테이블의 PK필드를 나타낸다

* **@GeneratedValue**

  : PK의 생성 규칙을 나타낸다

  스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.

* **@Column**

  : 테이블 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.

  **🙋‍♀️ 그런데 사용하는 이유는 ?**    

  기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.

  ex)

  문자열의 기본값인 VARCHAR(255) 에서 사이즈를 500으로 늘리거나,

  TEXT로 타입을 변경하고 싶은 경우에 사용됨.



🐥 **참고**

 Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다 ! ! 

​	🙋‍♀️ **왜 ?** 

​	해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 코드상으로 명확하게 구분할 수 없어, 차후 기능 변경 시 정말 복잡해지기 때 ! 문 !

  	대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야만 한다.

ex)

❌ 잘못된 사용 방법

```
public class Order{
	public void setStatus(boolean status){
		this.status = status;
	}
}
public void 주문_취소event(){
	order.setStatus(false);
}
```



⭕ 올바른 사용 방법

```
public class Order{
	public void cancelOrder(){
		this.status = false;
	}
}
public void 주문_취소event(){
	order.cancelOrder();
}
```



**🙋‍♀️ Setter가 없는 상황에서 값을 채워 DB에 넣는 방법은 ?** 

생성자를 통해 최종값을 채운 후 DB에 삽입 !

값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 한다.





<br>



 ### 📝application.properties 파일 생성



> src-main-resources-application.properties



* **spring.jpa.show_sql=true**

  : 실제로 실행된 쿼리의 형태를 콘솔에서 쿼리로그로 확인 가능하게 해준다.

  ```
  Hibernate: create table posts (id bigint generated by default as identity, author varchar(255), content TEXT not null, title varchar(500) not null, primary key (id))
  ```

* **spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect**

  : 출력되는 쿼리 로그를 MySQL 버전으로 변경

  ```
  Hibernate: create table posts (id bigint not null auto_increment, author varchar(255), content TEXT not null, title varchar(500) not null, primary key (id)) engine=InnoDB
  ```

* **spring.h2.console.enabled=true**

  main 실행 후,

  http://localhost:8080/h2-console 로 접속

  JDBC URL : jdbc:h2:mem:testdb

  connect 후 테이블 조회 가능





<br>



 ### 📝Spring 웹 계층

![](https://i.imgur.com/ZbszQve.png)



* **Web Layer**

  : 흔히 사용되는 컨트롤러(@Controller)와  JSP/Freemarker 등의 뷰 템플릿 영역

  이외에도 필터(@Filter), 인터셉터, 컨트롤러 어드바이스(@ControllerAdvice)등 외부 요청과 응답에 대한 전반적인 영역

* **Service Layer**

  : @Service에 사용되는 서비스 영역

  일반적으로 Controller와 Dao의 중간 영역에서 사용된다

  @Transactional이 사용되어야 하는 영역

  ✍ **주의** ✍    

  "Service에서 비즈니스 로직을 처리해야한다." 는 오 ! 해 !  ~~정말?😵~~

  👉 Service는 트랜잭션, 도메인 간 **순서 보장**의 역할만 한다 !

* **Repository Layer**

  : DB와 같이 데이터 저장소에 접근하는 영역

   Dao(Data Access Object) 영역

* **Dtos**

  : 계층 간에 데이터 교환을 위한 객체

  뷰 템플릿 엔진에서 사용될 객체나 Repository Layer에서 결과로 넘겨준 객체 등

* **Domain Model**

  : 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록 단순화시킨 것

  **ex)** 택시 앱의 배차, 탑승, 요금 등이 모두 도메인

  @Entity가 사용된 영역 역시 도메인 모델이다.

  다만, 무조건 DB 테이블과 관계까 있어야 하는 것은 아니다. VO처럼 값 객체들도 이 영역에 해당하기 때문 !

**🙋‍♀️ 5가지 레이어 중 비즈니스 처리를 담당해야 할 곳은 ?** Domain







<br>



### 📝스프링에서 Bean을 주입받는 방식

* **@Autowired**
* **setter**
* **생성자**

🙋‍♀️ **이 중 가장 권장하는 방식은 ?**    

생성자로 주입받는 방식 (@Autowired는 권장하지 않는다)

롬복의 **@RequiredArgsConstructor**이 final이 선언된 모든 필드를 인자값으로 하는 생상자를 생성해줌

🙋‍♀️ **왜 생성자를 직접 안 쓰고 롬복 어노테이션을 사용하나 ?**

해당 클래스의 의존성 관계가 변경될 때마다    

**생성자 코드를 계속해서 수정하는 번거로움 해결**하기 위함

즉, 해당 컨트롤러에 새로운 서비스를 추가하거나, 기존 컴포넌트를 제거하는 등의 상황이 발생해도 생성자 코드는 전혀 손대지 않아도 된다. 편리하다 !





<br>



 ### 📝API 만들기

API를 만들기 위해 총 3개의 클래스가 필요하다

* **Request 데이터를 받을 Dto**
* **API 요청을 받을 Controller**
* **트랜잭션, 도메인 기능 간의 순서를 보장하는 Service**



<br>

<br>



#### ✏ **등록 POST**

**web - PostsApiController**

```java
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
```



<br>



**service - PostsService**

```java
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
```







<br>



**web.dto - PostsSaveRequestDto**

```java
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
```

**🙋‍♀️ Entity 클래스와 거의 유사한 형태임에도 Dto클래스를 추가로 생성하는 이유는 ?**

**Request와 Response용 Dto**는 **View를 위한 클래스**이기 때문에 **자주 변경**된다.

Entity 클래스는 DB와 맞닿은 핵심 클래스로 Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경된다. 

즉, 화면변경을 사소한 기능 변경인데, 이를 위해 테이블과 연결된 Entity 클래스를 변경하는 것은 너무 큰 변경이다.

따라서, View Layer와 DB Layer의 역할 분리를 철저하게 하는 것이 좋다.



<br>



**test - web - PostsApiControllerTest**

```java
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception{
        //given
        String title = "title";
        String content = "content";
        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }
}
```

* **@SpringBootTest, TestRestTemplate** 

  JPA 기능까지 한 번에 테스트할 때 사용

  (**@WebMvcTest**의 경우, JPA기능이 작동하지 않으며, controller와 ControllerAdvice 등 외부 연동과 관련된 부분만 활성화된다! 그러니 여기서는 JPA를 테스트할 것이기 때문에 사용 안함!)



<br><br>



#### ✏ **수정 UPDATE**

**web - PostsApiController**

```java
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    ...
    
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
}
```



<br>



**service - PostsService**

```java
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
	
	...
    
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
}
```







<br>



**web.dto - PostsUpdateRequestDto**

```java
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
```







<br>



**domain - posts - Posts**

```java
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    ...
    
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
```



##### 🐥 더티체킹 

**update 기능에서는 쿼리를 날리는 부분이 없다 ?! !?  ?!**

엔티티를 영구 저장하는 환경인 **JPA의 영속성 컨텍스트** 때문에 가능 ! ~~WOW~~

JPA의 엔티티 매니저가 활성화된 상태로 트랜잭션 안에서 **DB에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태.**

이 상태에서 해당 데이터의 값을 변경하면 **트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영**한다. 즉, **Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없다.** 이 개념을 더티 체킹이라고 한다. 



<br>







**test - web - PostsApiControllerTest**

```java
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    
    ...
    

    @Test
    public void Posts_수정된다() throws Exception{
        //given
        Posts savedPosts = postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        Long updateId = savedPosts.getId();
        String title = "title2";
        String content = "content2";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title(title)
                .content(content)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        HttpEntity<PostsUpdateRequestDto> requestEntity  = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity
                = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }
}

```







<br><br>



#### ✏ **조회 GET**

**web - PostsApiController**

```java
@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    ...
    
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}

```



<br>



**service - PostsService**

```java
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    ...

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }
}
```







<br>



**web.dto - PostsResponseDto**

```java
@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto (Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
```





<br>

**조회하기**

1. **application.properties**

   spring.h2.console.enabled=true 추가

2. **localhost:8080/h2-console**

   JDBC URL :   jdbc:h2:mem:testdb

   connect 

3. **test 데이터 삽입**

   ```
   INSERT INTO POSTS(author, title, content) VALUES('aonee', 'title', 'content');
   ```

4. **API 조회**

   http://localhost:8080/api/v1/posts/1

   ```
   {"id":1,"title":"title","content":"content","author":"aonee"}
   ```

   





<br><br>



#### ✏ **삭제 DELETE**

**web - PostsApiController**

```java
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsApiController {
    private final PostsService postsService;

    ...

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
```



<br>



**service - PostsService**

```java
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    ...
    
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->
                        new IllegalArgumentException("해당 게시글이 없습니다. id = "+ id));

        postsRepository.delete(posts);
    }
}

```









<br>



 ### 📝JPA Auditing으로 생성시간/수정시간 자동화

Entity에 생성시간과 수정시간은 차후 유지보수에 있어 굉장히 중요한 정보이기 때문에 해당 내용을 포함한다.

매번 DB에 삽입/갱신 전 날짜 데이터를 등록/수정하는 코드를 추가하지 않도록 JPA  Auditing 사용할 것이다.



**domain - BaseTimeEntity**

```java
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}

```

* **@MappedSuperclass**

  : JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우, 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 한다

* **@EntityListeners(AuditingEntityListener.class)**

  : BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.

* **@CreatedDate**

  : Entity가 생성되어 저장될 때 시간이 자동 저장된다.

* **@LastModifiedDate**

  : 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.



**domain - posts - Posts**

```
public class Posts extends BaseTimeEntity 
```

BaseTimeEntity  상속받기





**Application**

```
@EnableJpaAuditing //JPA Auditing 활성화
```

@EnableJpaAuditing 롬복 어노테이션을 붙여주어 JPA Auditing을 활성화 시킨다.



**test - domain - posts - PostRepositoryTest**

```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }
    
...

    @Test
    public void BaseTimeEntity_등록(){
       //given
        LocalDateTime now = LocalDateTime.of(2020,7,28,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>> createDate = " + posts.getCreatedDate()
        + ", modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}
```



<br><br><br>



## 📌 feature-11 : 머스테치

### 📝머스테치란 ? 

JSP와 같이 HTML을 만들어주는 템플릿 엔진



🐥 **참고**

* **템플릿 엔진?**

  지정된 템플릿 데이터를 이용해 HTML을 생성하는 템플릿 엔진

* **서버 템플릿 엔진**

  JSP, Freemarker

  화면 생성 : 서버에서 Java 코드로 문자열을 만든 뒤 이 문자열을 HTML 로 변환하여 브라우저에 전달

* **클라이언트 템플릿 엔진**

  React, Vue

  SPA(Single Page Application) 브라우저에서 화면을 생성한다. 즉, 서버에서 이미 코드가 벗어난 경우

  서버에서는 Json or Xml 형식의 데이터만 전달하고 클라이언트에서 조립한다.

  최근에는 React, Vue 와 같은 자바스크림트 프레임워크에서 서버 사이드 렌더링을 지원하긴 한다.



### 📝머스테치 설치

1. 

`ctrl+shift+A` -> 'plugins' -> mustache 검색 후 설치



2. 

build.gradle에 추가

```
compile('org.springframework.boot:spring-boot-starter-mustache')
```





<br>



### 📝머스테치로 화면 구성

**IndexController**

```java
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/") //경로: 머스테치 스타터가 자동 지정해줌
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
```

경로: 머스테치 스타터가 자동 지정해줌

src/main/resources/templates/index.mustache



<br>

**PostsRepository**

```java
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
```

메인화면에 전체 글 목록 조회 추가



<br>



**PostsService**

```java
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    
    ...
    
    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
```

메인화면에 전체 글 목록 조회 추가



<br>



**PostsListResponseDto**

```java
@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
```

메인화면에 전체 글 목록 조회 추가





<br><br><br>



## 📌 feature-11 : Oauth

### 📝Google

<img src="https://i.imgur.com/teywoLF.png" width="50%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>



<br>



<img src="https://i.imgur.com/MN9BScv.png" width="50%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>





<br>





<img src="https://i.imgur.com/qfUDML7.png" width="50%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>





<br>









### 📝Naver

<img src="https://i.imgur.com/teywoLF.png" width="50%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

<br>

<img src="https://i.imgur.com/o1TMg5b.png" width="50%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

<br>

<img src="https://i.imgur.com/qfUDML7.png" width="50%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

<br>



<br>

<br>





### 📝 ISSUE

<img src="https://i.imgur.com/isAts8i.png" width="50%" height="40%" title="px(픽셀) 크기 설정" alt="RubberDuck"></img>

👉 **Naver**는 개발중인 상태에서는 등록된 아이디로만 로그인 가능하다. 
즉, 외부 사용자는 가입하지 못한다. ❌ ~~출시를 해야겠네🤔~~
👉 **Google**은 개발자 이메일 외에도 로그인 가능하다.⭕















