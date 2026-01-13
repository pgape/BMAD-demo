# 后端依赖管理文档

## 1. 项目概述

本项目是一个四人麻将游戏的后端服务，采用Java 17+和Spring Boot 3.x框架构建。本文档详细记录了项目中使用的所有依赖及其版本管理策略。

## 2. 技术栈概览

### 2.1 核心技术栈
- **编程语言**: Java 17+
- **框架**: Spring Boot 3.2.0
- **数据库**: PostgreSQL
- **缓存**: Redis
- **消息队列**: RabbitMQ
- **构建工具**: Maven

### 2.2 工具库
- **Lombok**: 简化Java代码
- **Hutool**: 通用工具集
- **Apache Commons**: 通用工具库

## 3. 依赖管理策略

### 3.1 版本管理方式
采用Maven的dependencyManagement机制进行依赖版本管理，确保所有依赖版本的一致性。

### 3.2 版本定义位置
所有依赖版本在pom.xml的properties标签中统一定义，便于维护和升级。

## 4. 核心依赖列表

### 4.1 Spring Boot 核心依赖

| 依赖名称 | 版本 | 用途 | 说明 |
|---------|------|------|------|
| spring-boot-starter-web | 3.2.0 | Web开发 | 包含Spring MVC、嵌入式Tomcat等 |
| spring-boot-starter-websocket | 3.2.0 | WebSocket支持 | 实现实时双向通信 |
| spring-boot-starter-data-jpa | 3.2.0 | 数据持久化 | 提供ORM支持和数据库访问 |
| spring-boot-starter-validation | 3.2.0 | 数据验证 | Bean验证支持 |
| spring-boot-starter-data-redis | 3.2.0 | Redis集成 | 缓存和会话管理 |
| spring-boot-starter-amqp | 3.2.0 | 消息队列 | RabbitMQ集成 |
| spring-boot-starter-test | 3.2.0 | 测试支持 | 单元测试和集成测试 |

### 4.2 数据库相关依赖

| 依赖名称 | 版本 | 用途 | 说明 |
|---------|------|------|------|
| postgresql | 42.6.0 | PostgreSQL驱动 | PostgreSQL数据库连接驱动 |

### 4.3 工具库依赖

| 依赖名称 | 版本 | 用途 | 说明 |
|---------|------|------|------|
| lombok | 1.18.30 | 代码简化 | 自动生成getter/setter等方法 |
| hutool-all | 5.8.22 | 通用工具 | 提供加密、日期处理、文件操作等 |
| commons-lang3 | 3.12.0 | 字符串处理 | Apache Commons语言扩展库 |
| commons-collections4 | 4.4 | 集合操作 | Apache Commons集合扩展库 |
| commons-io | 2.11.0 | IO操作 | Apache Commons IO工具库 |

### 4.4 测试相关依赖

| 依赖名称 | 版本 | 用途 | 说明 |
|---------|------|------|------|
| mockito-core | 5.7.0 | Mock框架 | 单元测试中的模拟对象 |
| springdoc-openapi-starter-webmvc-ui | 2.3.0 | API文档 | Swagger UI和OpenAPI文档生成 |

## 5. 依赖配置详情

### 5.1 Properties配置

```xml
<properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <java.version>17</java.version>
    
    <!-- Spring Boot Version -->
    <spring-boot.version>3.2.0</spring-boot.version>
    
    <!-- Dependency Versions -->
    <postgresql.version>42.6.0</postgresql.version>
    <lombok.version>1.18.30</lombok.version>
    <hutool.version>5.8.22</hutool.version>
    <commons-lang3.version>3.12.0</commons-lang3.version>
    <commons-collections4.version>4.4</commons-collections4.version>
    <commons-io.version>2.11.0</commons-io.version>
    <mockito.version>5.7.0</mockito.version>
    <spring-data-redis.version>3.2.0</spring-data-redis.version>
    <spring-amqp.version>3.2.0</spring-amqp.version>
</properties>
```

### 5.2 Dependency Management配置

```xml
<dependencyManagement>
    <dependencies>
        <!-- Spring Boot Dependency Management -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>${spring-boot.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

## 6. 依赖使用说明

### 6.1 Spring Boot Starter 依赖

#### spring-boot-starter-web
- 用途：提供Web开发的基本功能
- 包含：Spring MVC、嵌入式Tomcat、JSON转换等
- 使用场景：构建RESTful API服务

#### spring-boot-starter-websocket
- 用途：提供WebSocket支持
- 使用场景：实现游戏中的实时通信功能

#### spring-boot-starter-data-jpa
- 用途：简化数据库操作
- 使用场景：与PostgreSQL数据库交互

### 6.2 工具库依赖

#### Lombok
- 用途：减少样板代码
- 主要注解：
  - @Data: 自动生成getter/setter/toString/equals/hashCode
  - @Builder: 生成建造者模式代码
  - @NoArgsConstructor/@AllArgsConstructor: 生成构造函数
  - @Slf4j: 自动生成日志对象

#### Hutool
- 用途：提供丰富的工具类
- 主要功能：
  - 加密解密工具
  - 日期时间处理
  - 文件操作工具
  - JSON处理
  - HTTP客户端

#### Apache Commons
- 用途：提供常用的工具类
- 主要组件：
  - Commons Lang3: 字符串、数组、集合等工具
  - Commons Collections: 扩展集合操作功能
  - Commons IO: 简化IO操作

#### Swagger/OpenAPI
- 用途：API文档生成和可视化
- 主要功能：
  - 自动生成API文档
  - 提供交互式API测试界面
  - 支持OpenAPI 3.0规范

## 7. 版本升级策略

### 7.1 定期检查
- 每季度检查一次依赖版本
- 关注安全漏洞公告
- 评估新版本的兼容性

### 7.2 升级流程
1. 在测试环境中验证新版本兼容性
2. 运行所有测试用例确保功能正常
3. 更新生产环境依赖版本
4. 监控系统运行状态

### 7.3 版本锁定
- 所有依赖版本均在properties中明确定义
- 避免使用动态版本号（如LATEST、RELEASE）
- 确保构建的可重现性

## 8. 依赖安全

### 8.1 安全扫描
- 使用OWASP Dependency Check进行定期扫描
- 关注CVE公告
- 及时更新存在安全漏洞的依赖

### 8.2 依赖来源
- 优先使用Maven中央仓库的官方依赖
- 避免使用不可信的第三方依赖
- 定期审核依赖树

## 9. 最佳实践

### 9.1 依赖管理
- 使用dependencyManagement统一管理版本
- 避免依赖冲突
- 定期清理未使用的依赖

### 9.2 依赖范围
- runtime: 运行时需要，编译时不需要
- test: 仅测试时需要
- provided: 编译和测试时需要，运行时容器提供

### 9.3 依赖排除
- 明确排除不需要的传递依赖
- 避免引入冲突的依赖版本
- 减少最终打包体积

## 10. 维护指南

### 10.1 添加新依赖
1. 评估依赖的必要性和安全性
2. 确定合适的版本号
3. 在properties中定义版本
4. 在dependencies中添加依赖
5. 运行测试验证功能

### 10.2 依赖移除
1. 确认代码中不再使用该依赖
2. 从dependencies中移除
3. 从properties中移除版本定义
4. 运行测试确保功能正常

### 10.3 文档更新
- 每次依赖变更都需要更新此文档
- 记录变更原因和影响
- 保持文档与实际配置同步