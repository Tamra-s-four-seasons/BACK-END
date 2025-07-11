# 고블락 백엔드 (Goblock Backend)

## 🚀 프로젝트 개요

고블락 백엔드는 제주의 숨겨진 명소들을 생생하게 탐험할 수 있는 혁신적인 웹 애플리케이션 \*\*‘고블락’\*\*의 핵심 인프라를 제공합니다. 최첨단 AR 기술과 세련된 Next.js 프론트엔드를 지원하며, 사용자에게 스마트하고 몰입감 있는 관광 경험을 선사합니다.
저희는 AI에 의존하지 않고도 기획력과 창의력으로 저비용 솔루션을 구현하여 지속 가능한 여행 문화를 만들어가는 것을 목표로 합니다. 이 백엔드 서비스는 고블락의 뛰어난 사용자 경험, 확장성, 그리고 유지보수성을 보장하기 위해 최신 기술 스택과 견고한 아키텍처를 기반으로 설계되었습니다.

## ✨ 주요 기능

- **명소 및 미션 관리:** 제주의 숨겨진 명소 정보와 AR 기반 미션 경로 및 체크포인트 데이터 제공
- **사용자 인증 및 권한 부여:** JWT(JSON Web Token) 기반의 안전하고 효율적인 사용자 인증 시스템
- **실시간 데이터 처리:** AR 기술 및 동시 사용자 요청을 위한 고성능 API 응답
- **데이터베이스 연동:** 명소, 사용자, 미션 진행 상황 등 핵심 비즈니스 데이터 관리
- **API 문서화:** 프론트엔드 개발 및 외부 연동을 위한 자동화된 API 문서 제공

## 🏗️ 아키텍처 선정 이유

고블락 백엔드는 다음과 같은 전략적 고려사항을 바탕으로 아키텍처를 설계했습니다.

- **Spring Boot:** 빠르고 효율적인 개발, 강력한 생태계, 그리고 RESTful API 구축에 최적화된 기능을 제공하여 ‘저비용 솔루션 구현’과 ‘유지보수성’을 극대화합니다. 자동 설정과 내장형 서버는 개발 생산성을 높여 ‘기획력과 창의력’을 빠르게 서비스로 구현할 수 있도록 지원합니다.
- **Spring Data JDBC:** 복잡한 ORM의 오버헤드 없이 데이터베이스에 대한 세밀한 제어와 효율적인 쿼리 작성을 가능하게 합니다. 이는 특정 비즈니스 로직에 최적화된 데이터 접근을 통해 ‘저비용’ 운영에 기여하며, ‘지속 가능한 여행 문화’를 위한 자원 효율성을 추구합니다.
- **Spring WebFlux:** ‘최첨단 AR 기술’과 ‘뛰어난 사용자 경험’을 위해 높은 동시성과 확장성이 요구되는 환경에 적합합니다. 논블로킹 I/O 모델을 통해 다수의 동시 사용자 요청을 효율적으로 처리하며, AR 콘텐츠 제공과 같은 고성능이 필요한 핵심 경로에서 최적의 응답 속도를 보장합니다. (참고: Spring MVC와 WebFlux는 프로젝트의 특정 요구사항에 따라 전략적으로 함께 활용되어 각 스택의 장점을 최대한 활용합니다.)
- **JWT (JSON Web Token):** RESTful API의 상태 비저장(stateless) 인증 방식을 채택하여 서버의 부담을 줄이고, 사용자에게 끊김 없는 ‘뛰어난 사용자 경험’을 제공합니다. 이는 ‘확장성’ 높은 서비스 아키텍처를 구축하는 데 필수적인 요소입니다.
- **Lombok:** 반복적인 자바 코드를 줄여 개발 생산성을 향상시키고 코드 가독성을 높여 ‘유지보수성’에 크게 기여합니다.
- **Springdoc OpenAPI:** API 문서를 자동으로 생성하고 대화형 UI(Swagger UI)를 제공하여 프론트엔드 개발팀과의 협업을 원활하게 합니다. 이는 API의 명확한 이해를 돕고, ‘뛰어난 사용자 경험’을 위한 기능 구현을 가속화합니다.

## 🛠️ 사용된 기술 스택

- **언어:** Java 21
- **빌드 도구:** Gradle
- **프레임워크:** Spring Boot 3.x
- **데이터베이스:** MySQL
- **데이터 접근:** Spring Data JDBC
- **웹 스택:** Spring WebFlux, Spring MVC
- **인증:** JWT (JSON Web Token)
- **개발 편의성:** Project Lombok
- **API 문서화:** Springdoc OpenAPI (Swagger UI)
- **테스트:** JUnit 5
- **컨테이너 오케스트레이션:** Kubernetes (k8s)
- **CI/CD:** Jenkins (지속적인 통합 및 배포)

## 📂 프로젝트 구조

```text
/Users/sang/back-end/
├── build.gradle                  # Gradle 빌드 설정 파일
├── Dockerfile                    # Docker 이미지 빌드 파일
├── gradlew                       # Gradle Wrapper (Linux/macOS)
├── gradlew.bat                   # Gradle Wrapper (Windows)
├── settings.gradle               # Gradle 멀티 프로젝트 설정
├── k8s/                          # Kubernetes 배포 관련 설정 파일
│   ├── backend.yaml              # 백엔드 서비스 배포 정의
│   ├── ingress.yaml              # Ingress 설정 (외부 접근)
│   ├── kustomization.yaml        # Kustomize 설정
│   └── config/
│       └── backend-config.json   # 백엔드 설정 (예: DB 연결 정보)
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/
    │   │       └── backend/
    │   │           ├── Application.java        # Spring Boot 메인 애플리케이션
    │   │           ├── controller/             # REST API 컨트롤러
    │   │           │   ├── LoginController.java
    │   │           │   └── MissionController.java
    │   │           ├── dto/                    # 데이터 전송 객체 (Request/Response)
    │   │           ├── repository/             # 데이터베이스 접근 계층
    │   │           ├── service/                # 비즈니스 로직 계층
    │   │           ├── util/                   # 유틸리티 클래스
    │   └── resources/
    │       └── application.yml                 # 애플리케이션 설정 파일
    └── test/
        └── java/
            └── com/
                └── backend/
                    └── ApplicationTests.java   # 단위 및 통합 테스트
```

## ⚙️ 로컬 환경 설정 방법

고블락 백엔드 서비스를 로컬에서 실행하기 위한 단계별 가이드입니다.

### 📋 필수 요구사항

- **Java Development Kit (JDK) 21**
- **Gradle** (Gradle Wrapper를 사용하므로 별도 설치는 필수는 아니지만, 시스템에 설치되어 있으면 편리합니다.)
- **MySQL 데이터베이스** (로컬 또는 접근 가능한 원격 인스턴스)

### 🚀 시작하기

1. **저장소 클론:**

   ```bash
   git clone <이 저장소의 URL>
   cd back-end
   ```

2. **MySQL 데이터베이스 설정:**

   - MySQL 서버를 실행합니다.
   - `application.yml` 파일에 설정된 데이터베이스 이름과 사용자 계정을 생성하고 권한을 부여합니다. (기본적으로 `src/main/resources/application.yml` 파일을 확인하세요.)
   - 예시:

     ```yaml
     spring:
       datasource:
         url: jdbc:mysql://localhost:3306/goblock_db?useSSL=false&serverTimezone=UTC
         username: your_username
         password: your_password
         driver-class-name: com.mysql.cj.jdbc.Driver
     ```

     `goblock_db`, `your_username`, `your_password`를 실제 환경에 맞게 변경해주세요.

3. **애플리케이션 빌드 및 실행:**

   프로젝트 루트 디렉토리에서 다음 명령어를 실행합니다.

   ```bash
   ./gradlew bootRun
   ```

   (Windows의 경우 `gradlew.bat bootRun`)
   애플리케이션이 성공적으로 시작되면 콘솔에 Spring Boot 시작 로그가 표시됩니다. 기본적으로 **8080** 포트에서 실행됩니다.

4. **API 문서 확인:**

   애플리케이션이 실행 중인 상태에서 웹 브라우저를 통해 다음 URL에 접속하여 API 문서를 확인할 수 있습니다.

   ```
   http://localhost:8080/swagger-ui.html
   ```

## 🧪 테스트 실행

프로젝트의 테스트 코드를 실행하려면 다음 명령어를 사용합니다.

```bash
./gradlew test
```

## 🤝 기여하기

고블락 프로젝트에 기여하고 싶으시다면 언제든지 환영합니다! Pull Request를 통해 코드 개선, 버그 수정, 새로운 기능 제안 등을 해주세요.

## 📄 라이선스

이 프로젝트는 \*\*\[라이선스 유형, 예: MIT License]\*\*에 따라 라이선스가 부여됩니다.
