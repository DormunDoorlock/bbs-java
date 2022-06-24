## 개발 환경 만들기

### 과제 1. IDE 설치
#### 현재 사용하고있는 컴퓨터에 IntelliJ 설치

### 과제 2. 인프라 환경 만들기
#### 현재 사용하고 있는 컴퓨터에 도커(Docker)환경을 구성

#### 도커 실행 해서 MariaDB 실행 하기
```shell
$ ./gradlew.bat startDocker # linux or mac -> ./gradlew startDocker 
# 도커 실행 성공 로그
> Task :startDocker
Network infra_default  Creating
Network infra_default  Created
Container local-mariadb  Creating
Container local-mariadb  Created
Container local-mariadb  Starting
Container local-mariadb  Started

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed

```
#### 애플리케이션 테스트 실행해보기 
```shell
$ ./gradlew.bat clean test # linux or mac -> ./gradlew clean test

# 애플리케이션 테스트 성공 로그
> Task :test
2022-06-07 00:33:57.809  INFO 71207 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2022-06-07 00:33:57.820  INFO 71207 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

BUILD SUCCESSFUL in 3s
5 actionable tasks: 5 executed
```

### 위 내용까지 완료 되었으면 DB 연동

###
## 진행사항

### 06.25
CRUD 기능 + 전체 조회 기능 구현 => Postman으로 확인

추가 개선 필요: 목적에 맞게 테이블 수정, 페이징 기능, Post 내용만 따로 뽑기

