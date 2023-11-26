# 도서 관리 시스템 프로젝트

## 개발 환경
```
언어 : Java
프레임워크 : Spring Boot
통합개발환경(IDE) : IntelliJ
JDK 버전 : JDK 17
DB : Mysql
ORM : Mybatis
Auth : JWT
빌드 툴 : Gradle
API 문서화 : Swagger
버전 관리 툴 : GitHub
```

## 사용기술
### Development
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=Java&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/Mybatis-007DB8?style=for-the-badge&logo=Mybatis&logoColor=white">  <img src="https://img.shields.io/badge/JWT-2088FF?style=for-the-badge&logo=JWT&logoColor=white">

### DB
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> <img src="https://img.shields.io/badge/amazon s3-569A31?style=for-the-badge&logo=amazons3&logoColor=white">

### DevOps
<img src="https://img.shields.io/badge/amazon ec2-FF9900?style=for-the-badge&logo=mamazonec2&logoColor=white">  <img src="https://img.shields.io/badge/github actions-2088FF?style=for-the-badge&logo=githubactions&logoColor=white"> <img src="https://img.shields.io/badge/amazon s3-569A31?style=for-the-badge&logo=amazons3&logoColor=white">


## 시스템 구성도

-

## 기능 정의서
### [ 회원 ]
- 회원 가입
- 로그인
  - 토큰 생성 및 비밀번호 암호화

### [ 책 ]
- 책 관리(등록, 수정, 삭제)
  - 관리자만 가능합니다.

### [ 대출 ]
- 대출 이력 확인
  - 로그인한 사용자만 이용 가능합니다. 
  - 등록된 책의 대출 이력을 최근 순으로 10개 표시합니다.
  - 해당 책의 등록 후 현재까지 대출 된 전체 카운트를 표시합니다.
- 책 대출
  - 로그인한 사용자만 이용 가능합니다.
  - 닉네임을 입력하여 대출처리를 합니다.
- 책 반납
  - 로그인한 사용자만 이용 가능합니다.
  - 대출 시 반납 기한(2주)이 지정되어 기한 초과 시 자동 반납처리 됩니다.


## ERD
![BookManagement ERD](https://github.com/woojkk/BookManagement/assets/122269418/e2e40e83-ad5a-462a-8b82-ed0f34bbd7dc)

