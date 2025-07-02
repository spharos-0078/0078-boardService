# 🎯 Board Service

> **Piece of Cake** 프로젝트의 게시판 서비스  
> 마이크로서비스 아키텍처 기반의 고성능 게시판 시스템

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-6.0+-green.svg)](https://www.mongodb.com/)
[![Redis](https://img.shields.io/badge/Redis-7.0+-red.svg)](https://redis.io/)
[![Docker](https://img.shields.io/badge/Docker-20.10+-blue.svg)](https://www.docker.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📋 목차

- [프로젝트 개요](#-프로젝트-개요)
- [기술 스택](#-기술-스택)
- [아키텍처](#-아키텍처)
- [주요 기능](#-주요-기능)
- [시작하기](#-시작하기)
- [API 문서](#-api-문서)
- [개발 가이드](#-개발-가이드)
- [배포](#-배포)
- [기여하기](#-기여하기)

## 🎯 프로젝트 개요

Board Service는 **Piece of Cake** 프로젝트의 핵심 게시판 서비스로, 다양한 유형의 게시판을 관리하고 AI 기반 가격 예측 기능을 제공합니다.

### ✨ 주요 특징

- 🏗️ **DDD (Domain-Driven Design)** 패턴 적용
- 🤖 **AI 기반 가격 예측** (GPT-4 Vision API)
- 🔒 **강화된 입력 검증** 및 보안
- 📊 **다양한 게시판 유형** 지원
- 🚀 **마이크로서비스 아키텍처**
- 📱 **RESTful API** 설계

## 🛠️ 기술 스택

### Backend
- **Java 17** - 최신 LTS 버전
- **Spring Boot 3.5.0** - 웹 애플리케이션 프레임워크
- **Spring Data MongoDB** - NoSQL 데이터베이스
- **Spring Data Redis** - 캐싱 및 세션 관리
- **Spring Cloud Netflix Eureka** - 서비스 디스커버리
- **Spring Kafka** - 메시지 큐
- **Spring Validation** - 입력 검증

### Database & Cache
- **MongoDB** - 메인 데이터베이스
- **Redis** - 캐싱 및 인덱싱

### AI & External Services
- **OpenAI GPT-4 Vision API** - 이미지 분석 및 가격 예측
- **Spring WebFlux** - 비동기 HTTP 클라이언트

### DevOps & Tools
- **Docker** - 컨테이너화
- **GitHub Actions** - CI/CD 파이프라인
- **Gradle** - 빌드 도구
- **Swagger/OpenAPI** - API 문서화

## 🏗️ 아키텍처

### DDD (Domain-Driven Design) 패턴

```
src/main/java/com/pieceofcake/board_service/
├── board/
│   ├── domain/          # 도메인 엔티티 및 비즈니스 로직
│   ├── application/     # 애플리케이션 서비스
│   ├── infrastructure/ # 인프라스트럭처 (Repository)
│   ├── presentation/   # 프레젠테이션 (Controller)
│   ├── dto/           # 데이터 전송 객체
│   └── vo/            # 값 객체
├── ai/                # AI 서비스 모듈
├── common/            # 공통 모듈
│   ├── config/       # 설정
│   ├── entity/       # 공통 엔티티
│   ├── exception/    # 예외 처리
│   └── util/         # 유틸리티
└── BoardServiceApplication.java
```

### 마이크로서비스 아키텍처

```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   API Gateway   │    │  User Service   │    │  Board Service  │
│                 │    │                 │    │                 │
│  - 라우팅       │◄──►│  - 사용자 관리   │◄──►│  - 게시판 관리   │
│  - 인증/인가     │    │  - 인증         │    │  - AI 가격 예측  │
└─────────────────┘    └─────────────────┘    └─────────────────┘
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                    ┌─────────────────┐
                    │  Eureka Server  │
                    │                 │
                    │  서비스 디스커버리 │
                    └─────────────────┘
```

## 🚀 주요 기능

### 📝 게시판 관리
- **공지사항** - 시스템 공지 및 안내
- **이벤트** - 이벤트 게시판 (마감일 포함)
- **FAQ** - 자주 묻는 질문
- **일반 문의** - 사용자 문의사항
- **판매 문의** - AI 가격 예측 포함

### 🤖 AI 가격 예측
- **GPT-4 Vision API** 활용
- **이미지 분석** 기반 가격 예측
- **실시간 응답** 처리
- **멀티모달 입력** 지원 (텍스트 + 이미지)

### 🔒 보안 및 검증
- **Bean Validation** 기반 입력 검증
- **Null Safety** 보장
- **비즈니스 규칙 검증**
- **예외 처리 체계화**

## 🚀 시작하기

### 필수 요구사항

- Java 17 이상
- Docker & Docker Compose
- MongoDB (Atlas 또는 로컬)
- Redis
- OpenAI API Key

### 로컬 개발 환경 설정

1. **저장소 클론**
```bash
git clone https://github.com/spharos-0078/0078-boardService.git
cd 0078-boardService
```

2. **환경 변수 설정**
```bash
# .env 파일 생성
cp .env.example .env

# 필수 환경 변수 설정
EC2_MONGOID=your_mongodb_username
EC2_MONGOPW=your_mongodb_password
GPT_API_KEY=your_openai_api_key
EC2_HOST=your_eureka_server_host
```

3. **애플리케이션 실행**
```bash
# Gradle로 실행
./gradlew bootRun

# 또는 Docker로 실행
docker-compose up -d
```

4. **API 문서 확인**
```
http://localhost:8082/swagger-ui/index.html
```

### Docker 실행

```bash
# 이미지 빌드
docker build -t board-service .

# 컨테이너 실행
docker run -p 8082:8082 --env-file .env board-service
```

## 📚 API 문서

### 기본 엔드포인트

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/board` | 서비스 상태 확인 |
| GET | `/swagger-ui/index.html` | API 문서 |

### 게시판 API

#### 공지사항
```http
GET    /api/v1/board/notice                    # 공지사항 목록
GET    /api/v1/board/notice/{boardUuid}        # 공지사항 상세
POST   /api/v1/board/notice                    # 공지사항 생성
```

#### 이벤트
```http
GET    /api/v1/board/event                     # 이벤트 목록
GET    /api/v1/board/event/{boardUuid}         # 이벤트 상세
POST   /api/v1/board/event                     # 이벤트 생성
```

#### FAQ
```http
GET    /api/v1/board/faq                       # FAQ 목록
GET    /api/v1/board/faq/{boardUuid}           # FAQ 상세
POST   /api/v1/board/faq                       # FAQ 생성
```

#### 판매 문의 (AI 가격 예측)
```http
POST   /api/v1/board/sale-request              # 판매 문의 생성
GET    /api/v1/board/my/sale-requests          # 내 판매 문의 목록
GET    /api/v1/board/my/sale-requests/{uuid}   # 내 판매 문의 상세
```

### 요청 예시

#### 판매 문의 생성
```json
POST /api/v1/board/sale-request
Content-Type: application/json
X-Member-Uuid: user-uuid

{
  "boardTitle": "명품 가방 판매 문의",
  "boardContent": "새상품 같은 상태의 명품 가방입니다.",
  "desiredPrice": 500000,
  "mainCategoryId": "fashion",
  "subCategoryId": "bag",
  "mainCategoryName": "패션",
  "subCategoryName": "가방",
  "boardImageRequestVoList": [
    {
      "boardImageUrl": "https://example.com/image1.jpg",
      "boardImageOrder": 1,
      "boardThumbnail": "https://example.com/thumb1.jpg"
    }
  ]
}
```

### 응답 예시

```json
{
  "isSuccess": true,
  "code": 200,
  "message": "요청에 성공하였습니다.",
  "result": {
    "boardUuid": "abc123def456",
    "aiEstimatedPrice": 480000,
    "aiEstimatedDescription": "시장 가격을 고려한 예상 가격입니다."
  }
}
```

## 👨‍💻 개발 가이드

### 코드 컨벤션

#### Java 코딩 스타일
- **클래스명**: PascalCase (예: `BoardService`)
- **메서드명**: camelCase (예: `createBoard`)
- **상수**: UPPER_SNAKE_CASE (예: `MAX_IMAGE_COUNT`)
- **패키지명**: lowercase (예: `com.pieceofcake.board_service`)

#### DDD 패턴 준수
```java
// ✅ 좋은 예시
@Document(collection = "board_db")
public class Board extends BaseEntity {
    @Id
    private String id;
    
    public void markAsAnswered() { 
        this.boardAnswered = true; 
    }
}

// ❌ 피해야 할 예시
public class BoardController {
    public void saveBoard() {
        // 비즈니스 로직을 Controller에 작성
    }
}
```

### 예외 처리

#### 커스텀 예외 사용
```java
// ✅ 좋은 예시
throw new BaseException(BaseResponseStatus.NO_EXIST_BOARD);

// ❌ 피해야 할 예시
throw new IllegalArgumentException("게시글이 없습니다");
```

#### 예외 상태 코드 체계
- **8000번대**: Board Service 전용 예외
- **8100번대**: Validation 관련 예외
- **8200번대**: Business Logic 예외

### 테스트 작성

#### 단위 테스트
```java
@ExtendWith(MockitoExtension.class)
class BoardServiceTest {
    
    @Mock
    private BoardRepository boardRepository;
    
    @InjectMocks
    private BoardServiceImpl boardService;
    
    @Test
    @DisplayName("게시글 생성 성공")
    void createBoard_Success() {
        // given
        CreateBoardRequestDto request = createTestRequest();
        
        // when
        boardService.createBoard(request);
        
        // then
        verify(boardRepository).save(any(Board.class));
    }
}
```

## 🚀 배포

### GitHub Actions CI/CD

```yaml
name: Deploy board-service
on:
  push:
    branches: [develop]

jobs:
  build-and-deploy:
    runs-on: ubuntu-latest
    steps:
      - name: Build & Test
      - name: Docker Build & Push
      - name: Deploy to EC2
```

### 환경별 설정

#### 개발 환경 (dev)
```yaml
spring:
  profiles:
    active: dev
  data:
    mongodb:
      uri: mongodb+srv://${EC2_MONGOID}:${EC2_MONGOPW}@spharos.uxnx7ao.mongodb.net/piece_of_cake
```

#### 로컬 환경 (local)
```yaml
spring:
  profiles:
    active: local
  data:
    mongodb:
      uri: mongodb://localhost:27017/board_service
```

## 🤝 기여하기

### 개발 워크플로우

1. **이슈 생성**
   - 버그 리포트 또는 기능 요청
   - 명확한 제목과 설명

2. **브랜치 생성**
   ```bash
   git checkout -b feature/your-feature-name
   # 또는
   git checkout -b fix/your-bug-fix
   ```

3. **개발 및 테스트**
   ```bash
   ./gradlew test
   ./gradlew build
   ```

4. **커밋 및 푸시**
   ```bash
   git add .
   git commit -m "feat: 새로운 기능 추가"
   git push origin feature/your-feature-name
   ```

5. **Pull Request 생성**
   - GitHub에서 PR 생성
   - 코드 리뷰 요청

### 커밋 메시지 컨벤션

```
type(scope): description

feat: 새로운 기능
fix: 버그 수정
docs: 문서 수정
style: 코드 포맷팅
refactor: 코드 리팩토링
test: 테스트 추가/수정
chore: 빌드 프로세스 또는 보조 도구 변경
```

### 코드 리뷰 체크리스트

- [ ] 코드 컨벤션 준수
- [ ] 테스트 코드 작성
- [ ] 예외 처리 적절성
- [ ] 보안 검토
- [ ] 성능 고려사항
- [ ] 문서화 완료

## 📊 모니터링

### 로그 레벨
```yaml
logging:
  level:
    com.pieceofcake.board_service: DEBUG
    org.springframework.web: INFO
    org.springframework.data.mongodb: DEBUG
```

### 헬스 체크
```http
GET /actuator/health
```

### 메트릭
```http
GET /actuator/metrics
```

## 📄 라이선스

이 프로젝트는 MIT 라이선스 하에 배포됩니다. 자세한 내용은 [LICENSE](LICENSE) 파일을 참조하세요.

## 👥 팀

- **개발팀**: Piece of Cake Team
- **프로젝트**: Board Service
- **버전**: 1.0.0

## 📞 지원

- **이슈 리포트**: [GitHub Issues](https://github.com/spharos-0078/0078-boardService/issues)
- **문서**: [Wiki](https://github.com/spharos-0078/0078-boardService/wiki)
- **이메일**: support@pieceofcake.com

---

**Made with ❤️ by Piece of Cake Team** 