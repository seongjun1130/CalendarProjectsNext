#     CalendarProjects Next 📝
이 프로젝트는 사용자들에게 일정 관리 기능을 제공하는 Calendar API입니다. Spring Boot를 기반으로 개발되었으며, JPA를 통해 데이터베이스와 상호작용하고, JWT를 이용해 안전한 사용자 인증 시스템을 구현하였습니다. 이 API는 기본적인 일정 생성, 조회, 수정, 삭제(CRUD) 기능뿐만 아니라, 일정에 담당자를 지정하는 기능도 제공합니다. 또한, 각 일정에 댓글을 추가함으로써 사용자 간의 소통을 강화하고, 일정 생성 시 해당 날짜의 날씨 정보를 외부 API로 받아와 저장하는 기능을 통해 더욱 풍부한 사용자 경험을 제공합니다. 이 모든 기능은 RESTful 아키텍처에 기반해 설계되었으며, 데이터를 주고받는 포맷으로는 JSON을 사용하여 확장성과 유지 보수성을 고려한 효율적인 시스템을 구축하였습니다.

해당 프로그램은 하단 구현 가이드라인에 초점을 맞추어 구현하였습니다.

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fseongjun1130%2FCalendarProjectsNext&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://github.com/seongjun1130)

## 목차
- [개요](#개요)
- [기능 구현 가이드라인](#기능-구현-가이드라인)
- [API 명세서](#API-명세서)
- [DateBase ERD](#DataBase-ERD)
- [아키텍쳐](#architecture)

## 개요
- 프로젝트 이름 : CalendarProjects Next
- 프로젝트 지속기간 : 2024.10.07 ~ 2024.10.17
- 개발언어 : JAVA, SpringBoot, MySQL, GRADLE, JPA, JWT
- 멤버 : 조성준

## 기능 구현 가이드라인
<details>
<summary>접기/펼치기</summary>
  
![image](https://github.com/user-attachments/assets/f3d097fd-3dc7-488e-a864-0e03e07c9ef1)
![image](https://github.com/user-attachments/assets/1c68520f-91d0-42e4-9220-4ed654dfa901)
![image](https://github.com/user-attachments/assets/cf07414c-aadf-44a8-9386-676baf9b0b0a)
![image](https://github.com/user-attachments/assets/9c94c0c9-b285-4707-b79d-d5b3880bc2af)


</details>

## API 명세서
- 명세서 WebPage
  
[API 명세서 Link](https://documenter.getpostman.com/view/38557957/2sAXxV6AER)

## DataBase ERD

![image](https://github.com/user-attachments/assets/ecd6e642-946e-4c7e-9721-fbc998f38802)

## 주요기능
- 사용자 인증: JWT(JSON Web Token)를 이용해 사용자를 안전하게 인증하며, 각 API 요청 시 JWT를 사용하여 인증을 검증합니다.
- 일정 관리(CRUD): 사용자는 일정을 생성(Create), 조회(Read), 수정(Update), 삭제(Delete)할 수 있습니다. 모든 일정 데이터는 JPA를 통해 데이터베이스에 저장됩니다.
- 일정 담당자 설정: 일정 생성 시 담당자를 지정할 수 있는 기능을 지원합니다.
- 댓글 기능: 일정에 댓글을 달아 사용자 간의 소통을 도모하며, 댓글 조회 기능도 함께 제공됩니다.
- 날씨 정보 통합: 일정 생성 시 외부 날씨 API를 통해 해당 날짜의 날씨 정보를 받아와 저장하여 일정과 함께 관리할 수 있습니다.

## Stacks
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">

## Communication
- ### Main blog
https://velog.io/@lionjojo/posts
- ### Project Main Documentation
https://velog.io/@lionjojo/CalendarProjects-Next
- ### Project troubleshooting
https://velog.io/@lionjojo/Spring-Calendar-Next-%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%85

## Architecture
```
📦 
├─ .gitignore
├─ build.gradle
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ schedule.sql
├─ settings.gradle
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ sparta
   │  │        └─ calendarprojectsnext
   │  │           ├─ CalendarProjectsNextApplication.java
   │  │           └─ domain : 요청 기능 별 Domain Layer
   │  │              ├─ audit : JPA Auditing 관련 패키지
   │  │              │  └─ Auditable.java
   │  │              ├─ client : 외부요청 API 관련 패키지
   │  │              │  ├─ dto
   │  │              │  │  └─ WeatherResponseDto.java : 날씨 데이터 응답 DTO
   │  │              │  └─ service
   │  │              │     └─ WeatherService.java : 외부 날씨 API 요청 Service
   │  │              ├─ comment : 댓글 관련 패키지
   │  │              │  ├─ command
   │  │              │  │  └─ CommentCommand.java : RequestDto -> Entity 변환 유틸 Class
   │  │              │  ├─ controller
   │  │              │  │  └─ CommentController.java : 댓글 API 컨트롤러
   │  │              │  ├─ dto : 댓글 관련 요청/응답 DTO
   │  │              │  │  ├─ CommentCreateRequestDto.java
   │  │              │  │  ├─ CommentCreateResponseDto.java
   │  │              │  │  ├─ CommentReadResponseDto.java
   │  │              │  │  └─ CommentUpdateRequestDto.java
   │  │              │  ├─ entity : 댓글 Entity
   │  │              │  │  └─ Comment.java
   │  │              │  ├─ mapper : Entity -> ResponseDto 변환 인터페이스
   │  │              │  │  └─ CommentMapper.java
   │  │              │  ├─ repository : 댓글 DB 접근 레파지토리
   │  │              │  │  └─ CommentRepository.java
   │  │              │  └─ service : 댓글 비즈니스로직 서비스
   │  │              │     └─ CommentService.java
   │  │              ├─ config : Spring 환경설정 관련 클래스
   │  │              │  ├─ PasswordEncoder.java : 비밀번호 암호화용 클래스
   │  │              │  └─ WebConfig.java : Resolver 인터페이스 등록용 클래스
   │  │              ├─ exception : 예외 관련 패키지
   │  │              │  ├─ CustomException.java : 사용자 예외 발생 클래스
   │  │              │  ├─ UnAuthorizationException.java : 토큰 인증처리 예외 클래스(필터용)
   │  │              │  ├─ controller : 예외발생용 컨트롤러
   │  │              │  │  └─ GlobalExceptionHandler.java : 전체 예외 Handler 클래스
   │  │              │  ├─ dto : 에러DTO 클래스
   │  │              │  │  └─ ErrorDto.java
   │  │              │  └─ eunm : 사용자 에러 지정 EUNM 클래스
   │  │              │     └─ ErrorCode.java
   │  │              ├─ filter : 인증/인가 용 필터 패키지
   │  │              │  ├─ AuthFilter.java : 인증/인가 용 필터
   │  │              │  └─ AuthenticationExceptionHandlerFilter.java 필터 예외 Handler 클래스
   │  │              ├─ jwt : JWT 관련 유틸 패키지
   │  │              │  └─ JwtUtil.java : JWT 관련 유틸클래스 (생성 검증등)
   │  │              ├─ schedule : 일정 관련 패키지
   │  │              │  ├─ command : RequestDto -> Entity 변환 유틸 Class
   │  │              │  │  └─ ScheduleCommand.java
   │  │              │  ├─ controller : 일정 API 컨트롤러
   │  │              │  │  └─ ScheduleController.java
   │  │              │  ├─ dto : 일정 관련 요청/응답 DTO
   │  │              │  │  ├─ ScheduleCreateRequestDto.java
   │  │              │  │  ├─ ScheduleCreateResponseDto.java
   │  │              │  │  ├─ ScheduleReadPageResponseDto.java
   │  │              │  │  ├─ ScheduleReadResponseDto.java
   │  │              │  │  └─ ScheduleUpdateRequestDto.java
   │  │              │  ├─ entity : 일정 Entity
   │  │              │  │  └─ Schedule.java
   │  │              │  ├─ mapper : Entity -> ResponseDto 변환 인터페이스
   │  │              │  │  └─ ScheduleMapper.java
   │  │              │  ├─ repository : 일정 DB 접근 레파지토리
   │  │              │  │  └─ ScheduleRepository.java
   │  │              │  └─ service : 일정 비즈니스로직 서비스
   │  │              │     └─ ScheduleService.java
   │  │              ├─ user : 유저 관련 패키지
   │  │              │  ├─ command : RequestDto -> Entity 변환 유틸 Class
   │  │              │  │  └─ UserCommand.java
   │  │              │  ├─ controller : 일정 API 컨트롤러
   │  │              │  │  └─ UserController.java
   │  │              │  ├─ dto : 일정 관련 요청/응답 DTO
   │  │              │  │  ├─ UserCreateRequestDto.java
   │  │              │  │  ├─ UserCreateResponseDto.java
   │  │              │  │  ├─ UserLoginRequestDto.java
   │  │              │  │  ├─ UserLoginResponseDto.java
   │  │              │  │  ├─ UserReadResponseDto.java
   │  │              │  │  └─ UserUpdateRequestDto.java
   │  │              │  ├─ entity : 일정 Entity
   │  │              │  │  └─ User.java
   │  │              │  ├─ eunm : 유저 권한 EUNM 클래스
   │  │              │  │  └─ UserRole.java
   │  │              │  ├─ mapper : Entity -> ResponseDto 변환 인터페이스
   │  │              │  │  └─ UserMapper.java
   │  │              │  ├─ repository : 유저 DB 접근 레파지토리
   │  │              │  │  └─ UserRepository.java
   │  │              │  ├─ resolver : HandlerMethodArgumentResolver 사용을 위한 인터페이스 및 클래스
   │  │              │  │  ├─ LoginUserResolver.java : Resolver 구현클래스
   │  │              │  │  └─ util
   │  │              │  │     └─ LoginUser.java : @LoginUser 어노테이션 구현
   │  │              │  └─ service : 유저 비즈니스로직 서비스
   │  │              │     └─ UserService.java
   │  │              └─ userschedule : 일정담당자 관련 패키지
   │  │                 ├─ command : RequestDto -> Entity 변환 유틸 Class
   │  │                 │  └─ UserScheduleCommand.java
   │  │                 ├─ controller : 일정담당자 API 컨트롤러
   │  │                 │  └─ UserScheduleController.java
   │  │                 ├─ dto : 담당자 관련 요청/응답 DTO
   │  │                 │  ├─ UserScheduleAssignRequestDto.java
   │  │                 │  ├─ UserScheduleAssignResponseDto.java
   │  │                 │  ├─ UserScheduleDeleteUserRequestDto.java
   │  │                 │  └─ UserScheduleDeleteUserResponseDto.java
   │  │                 ├─ entity : 담당자 Entity
   │  │                 │  └─ UserSchedule.java
   │  │                 ├─ mapper : Entity -> ResponseDto 변환 인터페이스
   │  │                 │  └─ UserScheduleMapper.java
   │  │                 ├─ repository : 담당자 DB 접근 레파지토리
   │  │                 │  └─ UserScheduleRepository.java
   │  │                 └─ service : 담당자 비즈니스로직 서비스
   │  │                    └─ UserScheduleService.java
   │  └─ resources
   │     └─ application.properties
   └─ test
      └─ java
         └─ com
            └─ sparta
               └─ calendarprojectsnext
                  └─ CalendarProjectsNextApplicationTests.java
```
©generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)
