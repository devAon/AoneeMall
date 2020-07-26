# 🤸‍♀️ WElCOME ! AoneeMall ! 🤸‍♀️



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
		🙋‍♀️ `Gradle 4.10.2  ` 로 변경하는 방법 ? 

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

    testCompile('org.springframework.boot:spring-boot-starter-test')
}

```

 

* **ext** 

  : build.gradle에서 사용하는 전역변수를 설정한다는 의미

* **spring-boot-gradle-plugin:${springBootVersion}**

  : springBootVersion = '2.1.9.RELEASE' 를 의존성으로 받겠다는 의미

* **repositories**

  : 각종 의존성 (라이브러리)들을 어떤 원격 저장소에 받을지 정한다

  * **mavenCentral()**

    : 기본적으로 많이 사용. 

      하지만 라이브러리 업로드를 위해 정말 많은 과정과 설정이 필요해서 힘듬

  * **jcenter()**

    : 라이브러리 업로드 문제점 개선해서 간단하게 해줌

    jcenter에 라이브러리를 업로드하면 mavenCentral에도 업로드될 수 있도록 자동화할 수 있다. 

  👉 요즘은 jcenter을 더 많이 사용하지만, 프로젝트에서는 둘 다 등록해서 사용할 것이다.

* **dependencies**

  * **lombok**
    🙋‍♀️ 추가하는 방법 ?   
    **step 1 )** `build.gradle`의 `dependencies`에 `compile('org.projectlombok:lombok')` 추가   
    **step 2 )** `Setting > Build > Compiler > Annotation Processros` 에서 `Enable annotation processing` 체크를 통해   
    		해당 프로젝트에서 롬복을 사용할 수 있도록 해줘야 한다. (롬복은 프로젝트마다 설정해야 한다 ! ! !)

  * **spring-boot-starter-jpa**
    스프링 부트용 Spring Data Jpa 추상화 라이브러리

    스프링 부트 버전에 맞춰 자동으로 JPA 관련 라이브러리들의 버전을 관리해준다
    
  * **h2**
  
    인메모리 RDBMS
  
    별도의 설치 없이 프로젝트 의존성만으로 관리할 수 있다
  
    메모리에서 실행되기 때문에 애플리케이션을 재시작할 때마다 초기화된다는 점을 이용하여 테스트 용도로 많이 사용된다
  
    AoneeMAll 프로젝트에서는 JPA의 테스트, 로컬 환경에서의 구동에서 사용할 예정 !







<br>



## 🔗 패키지 구조

### src-main-java

* web : 컨트롤러와 관련된 클래스
* domain : 도메인 (소프트웨어에 대한 요구사항 or 문제영역)



















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
    compile('org.projectlombok:lombok')
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

* **assertThat**

  : `org.assertj.core.api.Assertions.assertThat` assertj의 테스트 검증 라이브러리의 검증 메소드

  검증하고 싶은 대상을 메소드 인자로 받는다

  메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있다.

* **isEqualTo**

  : assertj의 동등 비교 메소드

  assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공

* **param**

  : API 테스트할 때 사용될 요청 파라미터를 설정

  단, 값은 String만 허용된다.

  따라서, 숫자/날짜/숫자 등 문자열로 변경해야만 가능

* **jsonPath**

  : JSON 응답값을 필드별로 검증할 수 있는 메소드

  $를 기준으로 필드명 명시

  ​	ex) $.amount

<br>



### 📝 lombok 사용

* @Getter

  선언된 모든 필드의 get 메소드를 생성해준다

* @RequireArgsConstructor

  선언된 모든 final 필드가 포함된 생성자를 생성해줌

  final이 없는 필드는 생성자에 포함되지 않는다.







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