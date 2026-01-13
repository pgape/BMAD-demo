# 后端架构设计文档

## 1. 项目概述

本项目是一个四人麻将游戏的后端服务，采用Spring Boot 3.x框架构建。系统设计遵循微服务架构原则，具有高可扩展性和可维护性。

## 2. 技术栈选择

### 2.1 核心框架
- **Spring Boot 3.x**: 作为主要开发框架，提供自动配置和快速开发能力
- **Java 17+**: 使用最新的长期支持版本，利用现代Java特性

### 2.2 数据持久化
- **Spring Data JPA**: 简化数据库操作，提供ORM支持
- **PostgreSQL**: 作为主数据库，提供强大的ACID特性和复杂查询能力

### 2.3 实时通信
- **Spring WebSocket**: 实现实时双向通信，支持麻将游戏的实时交互需求

### 2.4 缓存与消息队列
- **Redis**: 用于缓存游戏状态和会话管理
- **RabbitMQ**: 用于处理异步任务和事件通知

### 2.5 工具库
- **Lombok**: 减少样板代码，提高开发效率
- **Hutool**: 提供丰富的工具类，简化开发
- **Apache Commons**: 提供常用的工具类和集合操作

## 3. 依赖详解

### 3.1 Spring Boot Starter 依赖

#### spring-boot-starter-web
- 提供Web开发的基本功能
- 包含Spring MVC、嵌入式Tomcat等
- 支持RESTful API开发

#### spring-boot-starter-websocket
- 提供WebSocket支持
- 实现实时双向通信
- 适用于游戏状态同步

#### spring-boot-starter-data-jpa
- 简化数据库访问
- 提供声明式数据操作
- 支持多种数据库

#### springdoc-openapi-starter-webmvc-ui
- 自动生成API文档
- 提供交互式API测试界面
- 支持OpenAPI 3.0规范

#### spring-boot-starter-validation
- 提供Bean验证功能
- 支持注解方式进行数据校验
- 确保数据完整性

### 3.2 数据库相关依赖

#### PostgreSQL Driver
- PostgreSQL数据库驱动
- 提供高性能的数据库连接
- 支持PostgreSQL特有功能

### 3.3 工具类依赖

#### Lombok
- 自动生成getter/setter方法
- 简化构造函数、equals、hashCode等方法的编写
- 减少样板代码，提高代码可读性

#### Hutool
- 提供丰富的工具类
- 包含加密、日期处理、文件操作等功能
- 简化常见开发任务

#### Apache Commons
- Commons Lang3: 提供字符串、数组、集合等工具
- Commons Collections: 扩展集合操作功能
- Commons IO: 简化IO操作

### 3.4 消息与缓存依赖

#### Spring Data Redis
- 提供Redis集成
- 支持缓存、会话管理等功能
- 高性能的内存数据存储

#### Spring AMQP (RabbitMQ)
- 提供消息队列支持
- 适用于异步任务处理
- 解耦系统组件

## 4. 项目结构

```
src/main/java/com/pgape/mahjong/
├── MahjongApplication.java           # Spring Boot启动类
├── config/                         # 配置类
│   ├── WebSocketConfig.java        # WebSocket配置
│   ├── CacheConfig.java            # 缓存配置
│   ├── DatabaseConfig.java         # 数据库配置
│   └── SecurityConfig.java         # 安全配置
├── controller/                     # 控制器层
│   ├── GameController.java         # 游戏相关API
│   ├── PlayerController.java       # 玩家相关API
│   └── AuthController.java         # 认证相关API
├── service/                        # 服务层
│   ├── GameService.java            # 游戏业务逻辑
│   ├── PlayerService.java          # 玩家业务逻辑
│   ├── impl/                       # 服务实现类
│   └── dto/                        # 数据传输对象
├── entity/                         # 实体类
│   ├── Game.java                   # 游戏实体
│   ├── Player.java                 # 玩家实体
│   ├── MahjongTile.java            # 麻将牌实体
│   └── GameRecord.java             # 游戏记录实体
├── repository/                     # 数据访问层
│   ├── GameRepository.java         # 游戏数据访问
│   ├── PlayerRepository.java       # 玩家数据访问
│   └── TileRepository.java         # 麻将牌数据访问
├── websocket/                      # WebSocket相关
│   ├── handler/                    # 消息处理器
│   └── model/                      # WebSocket消息模型
└── util/                           # 工具类
    ├── GameUtils.java              # 游戏相关工具
    └── ValidationUtils.java        # 验证相关工具
```

## 5. 配置文件

### 5.1 application.yml
```yaml
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
  
  redis:
    host: localhost
    port: 6379
    timeout: 2000ms
  
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest

logging:
  level:
    com.pgape.mahjong: DEBUG
    org.springframework.web: INFO
    org.springframework.security: INFO

# 自定义配置
game:
  max-players: 4
  default-timeout: 30s
  enable-chat: true

# Swagger配置
springdoc:
  swagger-ui:
    path: /swagger-ui.html
    tags-sorter: alpha
    operations-sorter: alpha
  api-docs:
    path: /v3/api-docs
  show-actuator: true
```

## 6. 核心功能模块

### 6.1 游戏管理模块
- 游戏创建和销毁
- 玩家加入和离开
- 游戏状态管理
- 游戏规则执行

### 6.2 玩家管理模块
- 玩家注册和登录
- 玩家信息管理
- 积分和排名系统

### 6.3 实时通信模块
- WebSocket连接管理
- 游戏状态同步
- 实时消息推送

### 6.4 数据持久化模块
- 玩家数据存储
- 游戏记录保存
- 统计数据分析

## 7. 安全设计

### 7.1 认证机制
- JWT令牌认证
- 用户会话管理
- 权限控制

### 7.2 数据安全
- 敏感信息加密
- SQL注入防护
- XSS攻击防护

## 8. 性能优化

### 8.1 缓存策略
- Redis缓存热点数据
- HTTP响应缓存
- 数据库查询优化

### 8.2 异步处理
- 消息队列处理耗时任务
- 异步日志记录
- 非阻塞I/O操作

## 9. 部署架构

### 9.1 容器化部署
- Docker容器化
- Docker Compose编排
- 环境隔离

### 9.2 监控与日志
- 应用性能监控
- 业务日志记录
- 错误追踪

## 10. 扩展性考虑

### 10.1 微服务拆分
- 游戏服务
- 用户服务
- 排行榜服务
- 聊天服务

### 10.2 水平扩展
- 负载均衡
- 数据库分片
- 缓存集群

## 11. 开发规范

### 11.1 代码规范
- 遵循Java编码规范
- 使用Lombok减少样板代码
- 统一异常处理

### 11.2 测试策略
- 单元测试覆盖核心逻辑
- 集成测试验证组件协作
- 性能测试确保系统稳定性