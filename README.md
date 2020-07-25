# 🤸‍♀️ WElCOME ! AoneeMall ! 🤸‍♀️



<br>

## ⚙ 프로젝트 개발환경
프로젝트 개발 환경은 다음과 같습니다.

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



