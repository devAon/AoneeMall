# 🤸‍♀️ WElCOME ! AoneeMall ! 🤸‍♀️



<br>

## ⚙ 프로젝트 개발환경
프로젝트 개발 환경은 다음과 같다.

IDE : IntelliJ IDEA Ultimate   
Git Tools : Git Bash   
OS : Window   
SpringBoot 2.1.9   
Java8   
Gradle   

 👉 springBootVersion 2.1.7 / 2.1.8 / 2.1.9 모두 괜찮으나, 2.2 이상 버전에서는 정상작동 하지 않는다.

<br>


## 📌 feature-1 : 프로젝트 생성



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
  * 왜 ? 
    항상 서버에 톰캣을 설치할 필요가 없다.
    스프링 부트로 만들어진 Jar 파일 (실행 가능한 Java 패키징 파일)로 실행하면 된다.
  * `언제 어디서나 같은 환경에서 스프링 부트를 배포` 할 수 있기 때문에 내장 WAS 사용 권장
  * 외장 WAS 지양하는 이유 ? 
    모든 서버는 WAS의 종류, 버전, 설정을 일치시켜야만 한다.   ~~Oh my God~~  












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



### 

