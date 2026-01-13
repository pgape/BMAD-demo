# 四人麻将游戏项目初始化文档

## 项目概述

本项目是一个四人麻将游戏系统，采用前后端分离的架构设计。项目使用Java Spring Boot作为后端框架，React作为前端框架。

## 项目结构

```
mahjong-game/
├── backend/                    # 后端模块
│   ├── src/main/java/com/pgape/games/mahjong/
│   │   ├── MahjongApplication.java          # Spring Boot启动类
│   │   ├── controller/                      # 控制器层
│   │   ├── service/                         # 服务层
│   │   ├── entity/                          # 实体类
│   │   ├── repository/                      # 数据访问层
│   │   └── config/                          # 配置类
│   ├── src/main/resources/
│   │   ├── application.yml                  # 应用配置文件
│   │   └── application-dev.yml              # 开发环境配置
│   ├── pom.xml                              # Maven配置文件
│   └── Dockerfile                           # Docker配置文件
├── frontend/                   # 前端模块
│   ├── src/
│   │   ├── components/                        # React组件
│   │   ├── pages/                            # 页面组件
│   │   ├── hooks/                            # 自定义hooks
│   │   ├── utils/                            # 工具函数
│   │   ├── services/                         # API服务
│   │   ├── store/                            # Redux store
│   │   ├── styles/                           # 样式文件
│   │   ├── App.tsx                           # 主应用组件
│   │   └── main.tsx                          # 应用入口
│   ├── public/
│   ├── package.json                          # npm配置文件
│   ├── tsconfig.json                         # TypeScript配置
│   ├── vite.config.ts                        # Vite配置
│   └── Dockerfile                            # Docker配置文件
├── docker-compose.yml          # Docker编排文件
├── README.md                   # 项目说明文档
└── PROJECT_SETUP.md            # 项目初始化文档
```

## 技术栈

### 后端技术栈
- **语言**: Java 17+
- **框架**: Spring Boot 3.x
- **持久层**: Spring Data JPA
- **数据库**: PostgreSQL
- **构建工具**: Maven
- **测试框架**: JUnit 5, Mockito, AssertJ

### 前端技术栈
- **框架**: React 18+
- **语言**: TypeScript
- **状态管理**: Redux Toolkit
- **路由**: React Router
- **构建工具**: Vite
- **样式**: Tailwind CSS
- **测试框架**: Jest + React Testing Library

## 数据库设计

### PostgreSQL配置
- 默认端口: 5432
- 数据库名: mahjong_game
- 用户名: mahjong_user
- 密码: mahjong_password

## 开发环境配置

### 后端配置

1. **JDK**: 安装Java 17+版本
2. **Maven**: 安装Maven 3.8+
3. **数据库**: 安装PostgreSQL并创建相应数据库

### 前端配置

1. **Node.js**: 安装Node.js 18+版本
2. **npm**: npm随Node.js一起安装

## 项目初始化步骤

### 1. 后端初始化

创建后端主应用类：

```java
// backend/src/main/java/com/pgape/games/mahjong/MahjongApplication.java
package com.pgape.games.mahjong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MahjongApplication {
    public static void main(String[] args) {
        SpringApplication.run(MahjongApplication.class, args);
    }
}
```

创建后端配置文件：

```yaml
# backend/src/main/resources/application.yml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/mahjong_game
    username: mahjong_user
    password: mahjong_password
    driver-class-name: org.postgresql.Driver
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true

logging:
  level:
    com.pgape.games.mahjong: DEBUG
```

创建Maven配置文件：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.pgape.games</groupId>
    <artifactId>mahjong-backend</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>
    <name>Mahjong Backend</name>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.0</version>
        <relativePath/>
    </parent>

    <properties>
        <java.version>17</java.version>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

### 2. 前端初始化

创建前端package.json：

```json
{
  "name": "mahjong-frontend",
  "private": true,
  "version": "0.0.0",
  "type": "module",
  "scripts": {
    "dev": "vite",
    "build": "tsc && vite build",
    "preview": "vite preview",
    "test": "vitest",
    "lint": "eslint src --ext ts,tsx --report-unused-disable-directives --max-warnings 0"
  },
  "dependencies": {
    "react": "^18.2.0",
    "react-dom": "^18.2.0",
    "react-router-dom": "^6.8.1",
    "@reduxjs/toolkit": "^1.9.3",
    "react-redux": "^8.0.5",
    "axios": "^1.3.4",
    "tailwindcss": "^3.2.7"
  },
  "devDependencies": {
    "@types/react": "^18.0.28",
    "@types/react-dom": "^18.0.11",
    "@vitejs/plugin-react": "^3.1.0",
    "typescript": "^4.9.3",
    "vite": "^4.2.0",
    "@testing-library/react": "^13.4.0",
    "@testing-library/jest-dom": "^5.16.5",
    "@testing-library/user-event": "^14.4.3",
    "jest": "^29.4.3",
    "ts-jest": "^29.0.5",
    "@types/jest": "^29.4.0",
    "vitest": "^0.29.2"
  }
}
```

创建TypeScript配置：

```json
{
  "compilerOptions": {
    "target": "ES2020",
    "useDefineForClassFields": true,
    "lib": ["ES2020", "DOM", "DOM.Iterable"],
    "module": "ESNext",
    "skipLibCheck": true,

    /* Bundler mode */
    "moduleResolution": "bundler",
    "allowImportingTsExtensions": true,
    "resolveJsonModule": true,
    "isolatedModules": true,
    "noEmit": true,
    "jsx": "react-jsx",

    /* Linting */
    "strict": true,
    "noUnusedLocals": true,
    "noUnusedParameters": true,
    "noFallthroughCasesInSwitch": true
  },
  "include": ["src"],
  "references": [{ "path": "./tsconfig.node.json" }]
}
```

创建Vite配置：

```typescript
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: 3000,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
    },
  },
})
}
```

## 数据库实体设计

### 麻将牌实体

```java
// backend/src/main/java/com/pgape/games/mahjong/entity/MahjongTile.java
package com.pgape.games.mahjong.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "mahjong_tiles")
public class MahjongTile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "牌ID不能为空")
    @Column(unique = true, nullable = false)
    private String tileId;  // 唯一标识符
    
    @NotNull(message = "牌面类型不能为空")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SuitType suit;  // 万、筒、条、字
    
    @Min(value = 1, message = "牌值不能小于1")
    @Max(value = 9, message = "牌值不能大于9")
    @Column(nullable = false)
    private Integer value;  // 1-9 for numbered suits, 1-7 for zi
    
    // 构造函数
    public MahjongTile() {}
    
    public MahjongTile(String tileId, SuitType suit, Integer value) {
        this.tileId = tileId;
        this.suit = suit;
        this.value = value;
    }
    
    // Getter和Setter方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTileId() { return tileId; }
    public void setTileId(String tileId) { this.tileId = tileId; }
    
    public SuitType getSuit() { return suit; }
    public void setSuit(SuitType suit) { this.suit = suit; }
    
    public Integer getValue() { return value; }
    public void setValue(Integer value) { this.value = value; }
}

// 牌面类型枚举
enum SuitType {
    WAN,    // 万
    TONG,   // 筒
    TIAO,   // 条
    ZI      // 字（风牌和箭牌）
}
```

### 数据访问层

```java
// backend/src/main/java/com/pgape/games/mahjong/repository/MahjongTileRepository.java
package com.pgape.games.mahjong.repository;

import com.pgape.games.mahjong.entity.MahjongTile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahjongTileRepository extends JpaRepository<MahjongTile, Long> {
    // 可以添加自定义查询方法
}
```

## Docker配置

### 后端Dockerfile

```dockerfile
# backend/Dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN ./mvnw package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/mahjong-backend-1.0.0.jar"]
```

### 前端Dockerfile

```dockerfile
# frontend/Dockerfile
FROM node:18-alpine

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

EXPOSE 3000

CMD ["npm", "run", "dev"]
```

### Docker Compose配置

```yaml
# docker-compose.yml
version: '3.8'

services:
  postgres:
    image: postgres:15
    container_name: mahjong_postgres
    environment:
      POSTGRES_DB: mahjong_game
      POSTGRES_USER: mahjong_user
      POSTGRES_PASSWORD: mahjong_password
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  backend:
    build:
      context: ./backend
    container_name: mahjong_backend
    depends_on:
      - postgres
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/mahjong_game
      SPRING_DATASOURCE_USERNAME: mahjong_user
      SPRING_DATASOURCE_PASSWORD: mahjong_password

  frontend:
    build:
      context: mahjong-frontend
    container_name: mahjong_frontend
    depends_on:
      - backend
    ports:
      - "3000:3000"
    volumes:
      - ./frontend/src:/app/src

volumes:
  postgres_data:
```

## 启动说明

### 开发环境启动

1. **启动数据库**：
   ```bash
   docker-compose up postgres
   ```

2. **启动后端**：
   ```bash
   cd backend
   mvn spring-boot:run
   ```

3. **启动前端**：
   ```bash
   cd frontend
   npm install
   npm run dev
   ```

### 生产环境启动

```bash
docker-compose up --build
```

## 测试配置

### 后端测试

创建测试配置文件：

```java
// backend/src/test/java/com/pgape/games/mahjong/TestConfig.java
package com.pgape.games.mahjong;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=password",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class TestConfig {
    // 测试配置类
}
```

### 前端测试

创建测试配置：

```typescript
// frontend/vitest.config.ts
import { defineConfig } from 'vitest/config'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  test: {
    globals: true,
    environment: 'jsdom',
    setupFiles: './src/test/setup.ts',
  },
})
```

## 项目初始化完成

至此，项目的基础结构已搭建完成。接下来可以根据具体需求开发业务功能模块。